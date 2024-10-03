import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormDto } from 'src/app/Model/Form';
import { FormService } from 'src/app/Service/form.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
// show.component.ts
export class ShowComponent implements OnInit {
  formes: FormDto[] = [];
  displayColumns: string[] = ['idShape', 'name', 'dimensions', 'price', 'image', 'action']; // Ajoutez 'image' ici

  constructor(
    private formeService: FormService,
     private router :Router
  ) { }

  ngOnInit(): void {
    this.loadFormes();
  }

  loadFormes(): void {
    this.formeService.getAllFormes().subscribe(
      data => {
        this.formes = data;
      },
      error => {
        console.error('Erreur lors du chargement des formes', error);
      }
    );
  }


  onDeleteForme(id: number): void {
    this.formeService.deleteForme(id).subscribe(() => {
      alert(`Forme avec ID ${id} supprimée avec succès.`);
      
      // Remove the deleted item from the `formes` array to refresh the UI
      this.formes = this.formes.filter(forme => forme.idShape !== id);
      
    }, error => {
      console.error('Erreur lors de la suppression de la forme:', error);
    });
  }
  
}
