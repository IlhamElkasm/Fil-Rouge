import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SaveurService } from 'src/app/Service/saveur.service';
import { UploadImageService } from 'src/app/Service/upload-image.service';

@Component({
  selector: 'app-edit-saveur',
  templateUrl: './edit-saveur.component.html',
  styleUrls: ['./edit-saveur.component.css']
})
export class EditSaveurComponent implements OnInit {

  saveur = {
    idFlavor: 0,
    image: '',
    name: '',
    price: 0
  };
  
  selectedFile: File | null = null;
  id!: number;

  constructor(
    private saveurService: SaveurService,
    private uploadImageService: UploadImageService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    console.log("this the id : ",this.id)
    this.loadSaveur();
  }

  // Charger les données de la forme
  loadSaveur(): void {
    this.saveurService.getSaveurById(this.id).subscribe(
      data => {
        this.saveur = data;
      },
      error => {
        console.error('Erreur lors du chargement de la saveur', error);
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
        this.saveur.image = imageUrl;
        this.updateSaveur();
      }).catch(error => {
        console.error('Erreur lors du téléchargement de l\'image:', error);
      });
    } else {
      this.updateSaveur();
    }
  }

  // Mettre à jour la forme
  updateSaveur(): void {
    console.log('Données avant mise à jour :', this.saveur);  // Vérification des données à envoyer
    this.saveurService.updateSaveur(this.id, this.saveur).subscribe(
      () => {
        console.log(`Forme avec ID ${this.id} mise à jour avec succès.`);
        this.router.navigate(['/dashboard/All']); // Rediriger après la mise à jour
      },
      error => {
        console.error('Erreur lors de la mise à jour de la forme', error);
      }
    );
  }
}
