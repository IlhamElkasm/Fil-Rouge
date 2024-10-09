import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { GarnitureDto } from 'src/app/Model/Garniture';
import { GarnitureService } from 'src/app/Service/garniture.service';

@Component({
  selector: 'app-showgarniture',
  templateUrl: './showgarniture.component.html',
  styleUrls: ['./showgarniture.component.css']
})
export class ShowgarnitureComponent  implements OnInit {

  @Output() selectGarniture = new EventEmitter<number>();
  garnitures: GarnitureDto[] = []; // Assume this array is populated elsewhere
  
  constructor(private garnitureService: GarnitureService) {}

  ngOnInit(): void {
    this.loadGarnitures();
  }

  loadGarnitures(): void {
    this.garnitureService.getAllGarnitures().subscribe((data: GarnitureDto[]) => {
      this.garnitures = data;
    });
  }

  onSelectGarniture(id: number): void {
    this.selectGarniture.emit(id);
  }
  
}

