import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormDto } from 'src/app/Model/Form';
import { FormService } from 'src/app/Service/form.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  @Output() selectForme = new EventEmitter<number>();  // Emit the selected forme ID

  formes: FormDto[] = []; // Assume this array is populated elsewhere


  constructor(private formeService: FormService) { }

  ngOnInit(): void {
    this.loadFormes();
  }

  loadFormes(): void {
    this.formeService.getAllFormes().subscribe(data => {
      this.formes = data;
    });
  }

    // Method to emit selected forme
    onSelectForme(id: number): void {
      this.selectForme.emit(id);  // Emit the forme ID to the parent
    }
    
}
