import { Component, Input } from '@angular/core';
import { FormDto } from 'src/app/Model/Form';
import { GarnitureDto } from 'src/app/Model/Garniture';
import { SaveurDto } from 'src/app/Model/Saveur';

@Component({
  selector: 'app-cake-preview',
  templateUrl: './cake-preview.component.html',
  styleUrls: ['./cake-preview.component.css']
})
export class CakePreviewComponent {

  @Input() gateau: any;

  constructor() {}
}
