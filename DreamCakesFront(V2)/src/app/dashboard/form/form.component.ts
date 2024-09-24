import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormDto } from 'src/app/Models/FormDto';
import { SizeService } from 'src/app/Services/size.service';

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

  constructor(private formeService: SizeService) { }

  ngOnInit(): void {
    this.loadFormes();
  }

  loadFormes(): void {
    this.formeService.getAllFormes().subscribe(data => {
      this.formes = data;
    });
  }

  createForme(formDto: FormDto): void {
    this.formeService.createForme(formDto).subscribe(newForm => {
      this.formes.push(newForm);
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
