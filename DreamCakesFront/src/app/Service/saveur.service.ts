import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SaveurDto } from '../Model/Saveur';

@Injectable({
  providedIn: 'root'
})
export class SaveurService {
  
  private apiUrl = 'http://localhost:8089/api/v1/Saveur'; // Adjust to your API base URL

  constructor(private http: HttpClient) { }


  // Create a new Saveur
  createSaveur(saveur: SaveurDto): Observable<SaveurDto> {
    return this.http.post<SaveurDto>(`${this.apiUrl}/Admin/addS`, saveur);
  }

  // Get all Saveurs
  getAllSaveurs(): Observable<SaveurDto[]> {
    return this.http.get<SaveurDto[]>(`${this.apiUrl}/all`);
  }

   // Get a Saveur by ID
   getSaveurById(id: number): Observable<SaveurDto> {
    return this.http.get<SaveurDto>(`${this.apiUrl}/get/${id}`);
  }
  // Update a Saveur
  updateSaveur(id: number, saveur: SaveurDto): Observable<SaveurDto> {
    return this.http.put<SaveurDto>(`${this.apiUrl}/edit/${id}`, saveur);
  }

  // Delete a Saveur
  deleteSaveur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
