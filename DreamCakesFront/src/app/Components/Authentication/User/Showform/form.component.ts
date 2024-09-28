import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormDto } from 'src/app/Model/Form';
import { FormService } from 'src/app/Service/form.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Output() formSelected = new EventEmitter<FormDto>();

  formes: FormDto[] = []; // Assume this array is populated elsewhere
  gateauDto: any = {}; // Initialize as an empty object

  selectForm(forme: FormDto): void {
    this.gateauDto.idShape = forme.idShape;
    console.log('Selected Form:', forme.name);
  }

  constructor(private formeService: FormService) { }

  ngOnInit(): void {
    this.loadFormes();
  }

  loadFormes(): void {
    this.formeService.getAllFormes().subscribe(data => {
      this.formes = data;
    });
  }

  getFormeById(id: number): void {
    this.formeService.getFormeById(id).subscribe(form => {
      console.log(form);
    });
  }

  updateForme(id: number, formDto: FormDto): void {
    this.formeService.updateForme(id, formDto).subscribe(updatedForm => {
      const index = this.formes.findIndex(f => f.idShape === id);
      if (index !== -1) {
        this.formes[index] = updatedForm;
      }
    });
  }

  deleteForme(id: number): void {
    this.formeService.deleteForme(id).subscribe(() => {
      this.formes = this.formes.filter(f => f.idShape !== id);
    });
  }
}
