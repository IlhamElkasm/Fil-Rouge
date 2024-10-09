import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommandeDto } from 'src/app/Model/CommandeDto';
import { FormDto } from 'src/app/Model/Form';
import { GarnitureDto } from 'src/app/Model/Garniture';
import { GateauDto } from 'src/app/Model/GateauDto';
import { SaveurDto } from 'src/app/Model/Saveur';
import { CartService } from 'src/app/Service/cart.service';
import { CommandeService } from 'src/app/Service/commande.service';
import { FormService } from 'src/app/Service/form.service';
import { GarnitureService } from 'src/app/Service/garniture.service';
import { GateauService } from 'src/app/Service/gateau.service';
import { SaveurService } from 'src/app/Service/saveur.service';

@Component({
  selector: 'app-add-gateau',
  templateUrl: './add-gateau.component.html',
  styleUrls: ['./add-gateau.component.css']
})
export class AddGateauComponent {

  selectedFormeId: number | null = null;
  selectedSaveurId: number | null = null;
  selectedGarnitureId: number | null = null;
  isGateauCreated: boolean = false; // Flag to check if Gateau is created
  gateauId: number | null = null; // Store the created Gateau ID

  constructor(private gateauService: GateauService, private commandeService: CommandeService, private router: Router) { }

  onFormeSelected(id: number) {
    if (this.selectedFormeId === null) {
      this.selectedFormeId = id;
      console.log('Form Selected ID:', id);
      alert('Form Selected ID:'+ id);
    } else {
      alert('Already selected a form. Can\'t select another one!');
    }
  }

  onSaveurSelected(idFlavor: number) {
    if (this.selectedSaveurId === null) {
      this.selectedSaveurId = idFlavor;
      console.log('Saveur Selected ID:', idFlavor);
      alert('Saveur Selected ID:'+idFlavor);
    } else {
      alert('Already selected a saveur. Can\'t select another one!');
    }
  }

  onGarnitureSelected(idTopping: number) {
    if (this.selectedGarnitureId === null) {
      this.selectedGarnitureId = idTopping;
      console.log('Garniture Selected ID:', idTopping);
      alert('Garniture Selected ID:'+ idTopping);
    } else {
      alert('Already selected a garniture. Can\'t select another one!');
    }
  }

  createGateau() {
    if (this.selectedFormeId && this.selectedSaveurId && this.selectedGarnitureId) {
      const gateauDto: GateauDto = {
        message: 'Your Cake',
        idShape: this.selectedFormeId,
        idFlavor: this.selectedSaveurId,
        idTopping: this.selectedGarnitureId
      };
  
      this.gateauService.createGateau(gateauDto).subscribe(response => {
        // Ensure that response.idGateau is not undefined before assignment
        if (response.idGateau !== undefined) {
          alert('Gateau created: ' + response.idGateau);
          this.gateauId = response.idGateau; // Store the created Gateau ID
          this.isGateauCreated = true; // Set the flag to true
        } else {
          console.error('Gateau creation failed: idGateau is undefined.');
        }
      });
    } else {
      console.log('Please select all options.');
    }
  }
  
  createCommande() {
    if (this.gateauId) {
      const commandeDto: CommandeDto = {
        dateCommende: new Date(), // Set the current date
        gateauId: this.gateauId // Use the ID from the created Gateau
      };

      this.commandeService.createCommande(commandeDto).subscribe(commandeResponse => {
        alert('Commande created: ' + commandeResponse.idCommende);
        // Navigate to the review page after the Commande is created
        this.router.navigate(['/dashboard/Cakereview']);
      });
    } else {
      console.log('Gateau has not been created yet.');
    }
  }
}