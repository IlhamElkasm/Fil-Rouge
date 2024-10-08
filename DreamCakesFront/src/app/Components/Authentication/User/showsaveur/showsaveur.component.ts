import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { SaveurDto } from 'src/app/Model/Saveur';
import { SaveurService } from 'src/app/Service/saveur.service';

@Component({
  selector: 'app-showsaveur',
  templateUrl: './showsaveur.component.html',
  styleUrls: ['./showsaveur.component.css']
})
export class ShowsaveurComponent implements OnInit {
  @Output() selectSaveur = new EventEmitter<number>();
  saveurs: SaveurDto[] = []; // Store the list of SaveurDto

  constructor(private saveurService: SaveurService) { }

  ngOnInit(): void {
    this.loadSaveurs();
  }

  // Load all Saveurs
  loadSaveurs(): void {
    this.saveurService.getAllSaveurs().subscribe(
      (data: SaveurDto[]) => {
        this.saveurs = data;
      },
      error => {
        console.error('Error loading saveurs:', error);
      }
    );
  }

  onSelectSaveur(id: number): void {
    this.selectSaveur.emit(id);
  }
}
