import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GarnitureService } from 'src/app/Service/garniture.service';
import { UploadImageService } from 'src/app/Service/upload-image.service';

@Component({
  selector: 'app-edit-garniture',
  templateUrl: './edit-garniture.component.html',
  styleUrls: ['./edit-garniture.component.css']
})
export class EditGarnitureComponent implements OnInit {

  garniture = {
    idTopping: 0,
    image: '',
    name: '',
    price: 0
  };
  
  selectedFile: File | null = null;
  id!: number;

  constructor(
    private garnitureService: GarnitureService,
    private uploadImageService: UploadImageService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.loadGarniture();
  }

  // Charger les données de la forme
  loadGarniture(): void {
    this.garnitureService.getGarnitureById(this.id).subscribe(
      data => {
        this.garniture = data;
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
        this.garniture.image = imageUrl;
        this.updategarniture();
      }).catch(error => {
        console.error('Erreur lors du téléchargement de l\'image:', error);
      });
    } else {
      this.updategarniture();
    }
  }

  // Mettre à jour la forme
  updategarniture(): void {
    console.log('Données avant mise à jour :', this.garniture);  // Vérification des données à envoyer
    this.garnitureService.updateGarniture(this.id, this.garniture).subscribe(
      () => {
        alert(`Forme avec ID ${this.id} mise à jour avec succès.`);
        this.router.navigate(['/dashboard/Allgarniture']); // Rediriger après la mise à jour
      },
      error => {
        console.error('Erreur lors de la mise à jour de la forme', error);
      }
    );
  }
}
