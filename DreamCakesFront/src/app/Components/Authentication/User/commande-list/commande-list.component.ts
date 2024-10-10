import { Component, OnInit } from '@angular/core';
import { CommandeDto } from 'src/app/Model/CommandeDto';
import { CommandeService } from 'src/app/Service/commande.service';

@Component({
  selector: 'app-commande-list',
  templateUrl: './commande-list.component.html',
  styleUrls: ['./commande-list.component.css']
})
export class CommandeListComponent implements OnInit {

  commandes: CommandeDto[] = [];

  constructor(private commandeService: CommandeService) { }

  ngOnInit(): void {
    this.getAllCommendes();
  }

  // Récupérer toutes les commandes via le service
  getAllCommendes(): void {
    this.commandeService.getAllCommendes().subscribe(
      (data: CommandeDto[]) => {
        this.commandes = data;
        console.log(this.commandes);  // Optionnel: pour afficher dans la console
      },
      (error) => {
        console.error('Erreur lors de la récupération des commandes', error);
      }
    );
  }
}