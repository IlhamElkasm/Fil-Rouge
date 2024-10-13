import { Component, Inject, Input, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { cake } from 'src/app/Model/cake';
import { GateauDto } from 'src/app/Model/GateauDto';
import { CommandeService } from 'src/app/Service/commande.service';
import { GateauService } from 'src/app/Service/gateau.service';

@Component({
  selector: 'app-cake-preview',
  templateUrl: './cake-preview.component.html',
  styleUrls: ['./cake-preview.component.css']
})
export class CakePreviewComponent implements OnInit {
  gateauId: number | null = null; // ID du gâteau
  gateauDetails: cake | null = null; // Détails du gâteau


  constructor(
    private route: ActivatedRoute,
    private commandeService: CommandeService,
    private gateauService: GateauService,
    private router : Router
  ) {}

  ngOnInit(): void {
    // Récupérer l'ID du gâteau depuis les paramètres de route
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id'); // Remplacez 'gateauId' par 'id'

      // Vérifier si idParam est null avant de le convertir
      if (idParam !== null) {
        this.gateauId = +idParam; // Convertir en nombre
        console.log('GateauId récupéré:', this.gateauId);

        // Vérifiez que gateauId est un nombre valide avant de faire l'appel de service
        if (this.gateauId) {
          this.gateauService.getGateauById(this.gateauId).subscribe(
            (data: cake) => {
              this.gateauDetails = data; // Store the cake details
              console.log('Détails du gâteau:', this.gateauDetails);
              console.log('Form details:', this.gateauDetails.forme);
              console.log('Saveur details:', this.gateauDetails.saveur);
              console.log('Garniture details:', this.gateauDetails.garnitures); // Check if this returns undefined
            },
            (error) => {
              console.error('Erreur lors de la récupération des détails du gâteau:', error);
            }
          );
          
        } else {
          console.error('GateauId est invalide');
        }
      } else {
        console.error('GateauId est null');
      }
    });
}


  createCommande(): void {
    if (this.gateauId !== null) {
      const commandeDto = {
        dateCommende: new Date(),
        gateauId: this.gateauId
      };
      this.commandeService.createCommande(commandeDto).subscribe(response => {
        alert("Commande créée !");
        this.router.navigateByUrl("/dashboard/commande")
      });
    } else {
      console.error('GateauId est null');
    }
  }
}