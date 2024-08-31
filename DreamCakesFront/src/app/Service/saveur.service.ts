import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SaveurDto } from '../Model/Saveur';

@Injectable({
  providedIn: 'root'
})
export class SaveurService {
  private apiUrl = 'http://localhost:8089/api/v1/auth/saveur'; // Adjust to your API base URL

  constructor(private http: HttpClient) { }

  // Create a new Saveur
  createSaveur(saveur: SaveurDto): Observable<SaveurDto> {
    return this.http.post<SaveurDto>(this.apiUrl, saveur);
  }

  // Get a Saveur by ID
  getSaveurById(id: number): Observable<SaveurDto> {
    return this.http.get<SaveurDto>(`${this.apiUrl}/${id}`);
  }

  // Get all Saveurs
  getAllSaveurs(): Observable<SaveurDto[]> {
    return this.http.get<SaveurDto[]>(this.apiUrl);
  }

  // Update a Saveur
  updateSaveur(id: number, saveur: SaveurDto): Observable<SaveurDto> {
    return this.http.put<SaveurDto>(`${this.apiUrl}/${id}`, saveur);
  }

  // Delete a Saveur
  deleteSaveur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
