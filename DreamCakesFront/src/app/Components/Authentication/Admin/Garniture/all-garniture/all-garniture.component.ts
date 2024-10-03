import { Component, OnInit } from '@angular/core';
import { GarnitureDto } from 'src/app/Model/Garniture';
import { GarnitureService } from 'src/app/Service/garniture.service';

@Component({
  selector: 'app-all-garniture',
  templateUrl: './all-garniture.component.html',
  styleUrls: ['./all-garniture.component.css']
})
export class AllGarnitureComponent implements OnInit {

  garnitures: GarnitureDto[] = [];
  displayColumns: string[] = ['idTopping', 'name', 'price', 'image', 'action']; // Ajoutez 'image' ici

  constructor(private garnitureService: GarnitureService) { }

  ngOnInit(): void {
    this.loadGarniture();
  }

  loadGarniture(): void {
    this.garnitureService.getAllGarnitures().subscribe(
      data => {
        this.garnitures = data;
      },
      error => {
        console.error('Erreur lors du chargement des formes', error);
      }
    );
  }
  onDeleteGarniture(id: number): void {
    this.garnitureService.deleteGarniture(id).subscribe(() => {
      alert(`garniture avec ID ${id} supprimée avec succès.`);
      
      // Remove the deleted item from the `formes` array to refresh the UI
      this.garnitures = this.garnitures.filter(garniture => garniture.idTopping !== id);
      
    }, error => {
      console.error('Erreur lors de la suppression de la garniture:', error);
    });
  }
  
}
