import { Component, OnInit } from '@angular/core';
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

  constructor(private formeService: FormService) { }

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
      console.log(`Forme avec ID ${id} supprimée avec succès.`);
      // Ajoutez ici le code pour mettre à jour l'interface utilisateur si nécessaire
    }, error => {
      console.error('Erreur lors de la suppression de la forme:', error);
    });
  }
}
