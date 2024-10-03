import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GarnitureService } from 'src/app/Service/garniture.service';
import { UploadImageService } from 'src/app/Service/upload-image.service';

@Component({
  selector: 'app-add-garniture',
  templateUrl: './add-garniture.component.html',
  styleUrls: ['./add-garniture.component.css']
})
export class AddGarnitureComponent {

  garniture!: FormGroup;
  imagePreviewUrl: string | null = null;
   // To store the uploaded image URL

  constructor(
    private fb: FormBuilder,
    private garnitureService: GarnitureService,
    private uploadImageService: UploadImageService,
    private router : Router
  ) {
    // Initialize the form group with all necessary controls
    this.garniture = this.fb.group({
      name: ['', Validators.required],
      price: ['', Validators.required],
      image: [''],
    });
  }
  async onSubmit() {
    if (this.garniture.valid) {
      const garnitureData = this.garniture.value;
      console.log('Garniture Data:', this.garniture.value);

      console.log(garnitureData.image)
      garnitureData.image = await this.uploadImageService.uploadImageToCloudinary(garnitureData.image);

      console.log('Form Data after:', garnitureData);

      this.garnitureService.saveGarniture(garnitureData).subscribe(
        data => {
          console.log('Automobiliste created successfully:', data);
          this.router.navigateByUrl("/dashboard/AllG")
        }
      )

    }
  }

  onFileSelected(event: any, controlName: string): void {
    const file = event.target.files[0];
    if (file && file.type.match(/image\/*/) != null) {
      const previewUrl = URL.createObjectURL(file);
      this.garniture.patchValue({
        [controlName]: file
      });
      this.garniture.get(controlName)?.markAsTouched();
        this.imagePreviewUrl = previewUrl;
    } else {
      alert('Veuillez sélectionner une image valide');
    }
  }
}