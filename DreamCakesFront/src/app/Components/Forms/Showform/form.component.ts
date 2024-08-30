import { Component, OnInit } from '@angular/core';
import { FormDto } from 'src/app/Model/Form';
import { FormService } from 'src/app/Service/form.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent  implements OnInit {
  formes: FormDto[] = [];

  constructor(private formeService: FormService) { }

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