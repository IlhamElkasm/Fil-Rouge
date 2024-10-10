import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { GateauDto } from 'src/app/Model/GateauDto';
import { GateauService } from 'src/app/Service/gateau.service';

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

  constructor(private gateauService: GateauService, private router: Router) { }

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
      alert('Garniture Selected ID:'+idTopping);
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
        if (response.idGateau !== undefined) {
          this.gateauId = response.idGateau;
          this.isGateauCreated = true;
          this.router.navigate(['/dashboard/Cakereview', { id: this.gateauId }]);

        } else {
          console.error('Gateau creation failed: idGateau is undefined.');
        }
      });
    } else {
      console.log('Please select all options.');
    }
  }
  
}