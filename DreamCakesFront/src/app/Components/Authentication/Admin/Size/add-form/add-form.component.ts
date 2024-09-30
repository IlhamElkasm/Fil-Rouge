import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormService } from 'src/app/Service/form.service';
import { UploadImageService } from 'src/app/Service/upload-image.service';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent {
  form: FormGroup;
  imagePreviewUrl: string | null = null;
   // To store the uploaded image URL

  constructor(
    private fb: FormBuilder,
    private formService: FormService,
    private uploadImageService: UploadImageService,
    private router : Router
  ) {
    // Initialize the form group with all necessary controls
    this.form = this.fb.group({
      name: ['', Validators.required],
      dimensions: ['', Validators.required],
      price: ['', Validators.required],
      image: [''],
    });
  }
  async onSubmit() {
    if (this.form.valid) {
      const formData = this.form.value;
      console.log('Form Data:', this.form.value);

      console.log(formData.image)
      formData.image = await this.uploadImageService.uploadImageToCloudinary(formData.image);

      console.log('Form Data after:', formData);

      this.formService.createForme(formData).subscribe(
        data => {
          console.log('Automobiliste created successfully:', data);
          this.router.navigateByUrl("/dashboard/show")
        }
      )

    }
  }

  onFileSelected(event: any, controlName: string): void {
    const file = event.target.files[0];
    if (file && file.type.match(/image\/*/) != null) {
      const previewUrl = URL.createObjectURL(file);
      this.form.patchValue({
        [controlName]: file
      });
      this.form.get(controlName)?.markAsTouched();
        this.imagePreviewUrl = previewUrl;
    } else {
      alert('Veuillez sélectionner une image valide');
    }
  }
}