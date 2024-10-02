import { Component, OnInit } from '@angular/core';
import { SaveurDto } from 'src/app/Model/Saveur';
import { SaveurService } from 'src/app/Service/saveur.service';

@Component({
  selector: 'app-all-saveur',
  templateUrl: './all-saveur.component.html',
  styleUrls: ['./all-saveur.component.css']
})
export class AllSaveurComponent  implements OnInit{

  saveurs : SaveurDto[] = [];
  displayColumns: string[] = ['idFlavor', 'name', 'price', 'image', 'action'];

  constructor(private saveurService : SaveurService){}
  ngOnInit(): void {
    this.ShowSaveurs();
  }

  ShowSaveurs() : void{
    this.saveurService.getAllSaveurs().subscribe(
      data =>{
        this.saveurs = data;
      },
      error =>{
        console.log('Erreur Afficher saveurs', error);
      }
    )
  }

  DelateSaveur(id : number): void{
    this.saveurService.deleteSaveur(id).subscribe(() => {
      alert(`Saveur avec Id ${id} supprimée avec succès.`);
    },
    error =>{
      console.error('Erreur lors de la suppression de la saveur:', error);
      
    });
  }

}
