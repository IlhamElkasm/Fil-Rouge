import { Component, OnInit } from '@angular/core';
import { CommandeDto } from 'src/app/Model/CommandeDto';
import { CommandeService } from 'src/app/Service/commande.service';

@Component({
  selector: 'app-commande-all',
  templateUrl: './commande-all.component.html',
  styleUrls: ['./commande-all.component.css']
})
export class CommandeAllComponent implements OnInit {

  commandes: CommandeDto[] = [];
  displayedColumns: string[] = ['idCommende', 'dateCommende', 'gateauId']; // Colonnes à afficher

  constructor(private commandeService: CommandeService) {}

  ngOnInit(): void {
    this.fetchCommandes();
  }

  fetchCommandes(): void {
    this.commandeService.getAllCommandes().subscribe({
      next: (data) => {
        this.commandes = data;
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des commandes:', error);
      }
    });
  }
}