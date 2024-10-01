import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormService } from 'src/app/Service/form.service';
import { UploadImageService } from 'src/app/Service/upload-image.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  forme = {
    idShape: 0,
    image: '',
    name: '',
    dimensions: '',
    price: 0
  };
  
  selectedFile: File | null = null;
  id!: number;

  constructor(
    private formeService: FormService,
    private uploadImageService: UploadImageService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.loadForme();
  }

  // Charger les données de la forme
  loadForme(): void {
    this.formeService.getFormeById(this.id).subscribe(
      data => {
        this.forme = data;
      },
      error => {
        console.error('Erreur lors du chargement de la forme', error);
      }
    );
  }

  // Sélectionner une image
  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  // Soumettre la mise à jour de la forme
  onSubmit(): void {
    if (this.selectedFile) {
      // Upload de l'image à Cloudinary
      this.uploadImageService.uploadImageToCloudinary(this.selectedFile).then((imageUrl: string) => {
        console.log('Image URL:', imageUrl);  // Vérification de l'URL
        this.forme.image = imageUrl;
        this.updateForme();
      }).catch(error => {
        console.error('Erreur lors du téléchargement de l\'image:', error);
      });
    } else {
      this.updateForme();
    }
  }

  // Mettre à jour la forme
  updateForme(): void {
    console.log('Données avant mise à jour :', this.forme);  // Vérification des données à envoyer
    this.formeService.updateForme(this.id, this.forme).subscribe(
      () => {
        console.log(`Forme avec ID ${this.id} mise à jour avec succès.`);
        this.router.navigate(['/dashboard/show']); // Rediriger après la mise à jour
      },
      error => {
        console.error('Erreur lors de la mise à jour de la forme', error);
      }
    );
  }
}
