import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SaveurService } from 'src/app/Service/saveur.service';
import { UploadImageService } from 'src/app/Service/upload-image.service';

@Component({
  selector: 'app-add-saveur',
  templateUrl: './add-saveur.component.html',
  styleUrls: ['./add-saveur.component.css']
})
export class AddSaveurComponent {

  saveur!: FormGroup;
  imageUp : string | null = null;
  constructor(
    private fb : FormBuilder,
    private saveurService : SaveurService,
    private UploadImage: UploadImageService,
    private router : Router

  ){
    this.saveur = this.fb.group({
      name : ['', Validators.required],
      price : ['', Validators.required],
      image : ['']
    });
  }

  async onSubmit() {
    if (this.saveur.valid) {
      const saveurData = this.saveur.value;
      
      // Upload the actual file from the form, not the preview URL
      saveurData.image = await this.UploadImage.uploadImageToCloudinary(this.saveur.value.image);
      console.log('saveur data after:', saveurData);
  
      this.saveurService.createSaveur(saveurData).subscribe(
        data => {
          console.log('Saveur avec succes:', data);
          this.router.navigateByUrl("/dashboard/All")
        }
      );
    }
  }
  


  onFileSelected(event: any, controlName: string): void {
    const file = event.target.files[0];
    if (file && file.type.match(/image\/*/) != null) {
      this.saveur.patchValue({
        [controlName]: file  // Store the actual file, not the preview URL
      });
      this.saveur.get(controlName)?.markAsTouched();
      // Optional: create a preview URL if you want to display the image before uploading
      this.imageUp = URL.createObjectURL(file); 
    } else {
      alert('Veuillez sélectionner une image valide');
    }
  }
  

}