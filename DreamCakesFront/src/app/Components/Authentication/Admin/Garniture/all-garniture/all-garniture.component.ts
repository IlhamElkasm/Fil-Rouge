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
      alert(`Garniture avec ID ${id} supprimée avec succès.`);
      // Ajoutez ici le code pour mettre à jour l'interface utilisateur si nécessaire
    }, error => {
      console.error('Erreur lors de la suppression de la Garniture:', error);
    });
  }
}
