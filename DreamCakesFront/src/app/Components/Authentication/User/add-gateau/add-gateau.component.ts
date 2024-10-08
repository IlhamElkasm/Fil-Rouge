import { Component } from '@angular/core';
import { FormDto } from 'src/app/Model/Form';
import { GarnitureDto } from 'src/app/Model/Garniture';
import { GateauDto } from 'src/app/Model/GateauDto';
import { SaveurDto } from 'src/app/Model/Saveur';
import { CartService } from 'src/app/Service/cart.service';
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

  constructor(private gateauService: GateauService) { }

  onFormeSelected(id: number) {
    this.selectedFormeId = id;
    console.log('Selected Form ID:', id);
    alert('Selected Form ID:'+ id)
  }

  onSaveurSelected(idFlavor: number) {
    this.selectedSaveurId = idFlavor;
    console.log('Selected Saveur ID:', idFlavor);
    alert('Selected Saveur ID:'+ idFlavor);
  }

  onGarnitureSelected(idTopping: number) {
    this.selectedGarnitureId = idTopping;
    console.log('Selected Garniture ID:', idTopping);
  }

  createGateau() {
    if (this.selectedFormeId && this.selectedSaveurId && this.selectedGarnitureId) {
      const gateauDto = {
        message: 'Your Cake',
        idShape: this.selectedFormeId,
        idFlavor: this.selectedSaveurId,
        idTopping: this.selectedGarnitureId
      };

      this.gateauService.createGateau(gateauDto).subscribe(response => {
        console.log('Gateau created:', response);
      });
    } else {
      console.log('Please select all options.');
    }
  }
}