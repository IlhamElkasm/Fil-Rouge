import { Component, OnInit } from '@angular/core';
import { SaveurDto } from 'src/app/Model/Saveur';
import { SaveurService } from 'src/app/Service/saveur.service';

@Component({
  selector: 'app-showsaveur',
  templateUrl: './showsaveur.component.html',
  styleUrls: ['./showsaveur.component.css']
})
export class ShowsaveurComponent implements OnInit {

  saveurs: SaveurDto[] = [];
  selectedSaveur: SaveurDto | null = null;

  constructor(private saveurService: SaveurService) { }

  ngOnInit(): void {
    this.loadSaveurs();
  }

  // Load all Saveurs
  loadSaveurs(): void {
    this.saveurService.getAllSaveurs().subscribe(
      (data: SaveurDto[]) => {
        this.saveurs = data;
      },
      error => {
        console.error('Error loading saveurs:', error);
      }
    );
  }

  // Get Saveur by ID
  getSaveur(id: number): void {
    this.saveurService.getSaveurById(id).subscribe(
      (data: SaveurDto) => {
        this.selectedSaveur = data;
      },
      error => {
        console.error('Error loading saveur:', error);
      }
    );
  }

  // Create a new Saveur
  createSaveur(newSaveur: SaveurDto): void {
    this.saveurService.createSaveur(newSaveur).subscribe(
      (data: SaveurDto) => {
        this.saveurs.push(data);
      },
      error => {
        console.error('Error creating saveur:', error);
      }
    );
  }

  // Update an existing Saveur
  updateSaveur(id: number, updatedSaveur: SaveurDto): void {
    this.saveurService.updateSaveur(id, updatedSaveur).subscribe(
      (data: SaveurDto) => {
        const index = this.saveurs.findIndex(s => s.idFlavor === id);
        if (index !== -1) {
          this.saveurs[index] = data;
        }
      },
      error => {
        console.error('Error updating saveur:', error);
      }
    );
  }

  // Delete a Saveur
  deleteSaveur(id: number): void {
    this.saveurService.deleteSaveur(id).subscribe(
      () => {
        this.saveurs = this.saveurs.filter(s => s.idFlavor !== id);
      },
      error => {
        console.error('Error deleting saveur:', error);
      }
    );
  }
}
