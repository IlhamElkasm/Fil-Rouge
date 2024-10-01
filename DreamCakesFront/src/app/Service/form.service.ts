import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FormDto } from '../Model/Form';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private apiUrl = 'http://localhost:8089/api/v1';

  constructor(private http: HttpClient) { }


  // Méthode pour créer une forme, acceptant FormData
  createForme(formData: FormData): Observable<FormDto> {
    return this.http.post<FormDto>(`${this.apiUrl}/Admin/shapes`, formData);
  }

  // Get all Formes
  getAllFormes(): Observable<FormDto[]> {
    return this.http.get<FormDto[]>(`${this.apiUrl}/show`);
  }
  // Récupérer une forme par son ID
  getFormeById(id: number): Observable<FormDto> {
    return this.http.get<FormDto>(`${this.apiUrl}/get/${id}`);
  }

  // Mettre à jour une forme par son ID
  updateForme(id: number, forme: FormDto): Observable<FormDto> {
    return this.http.put<FormDto>(`${this.apiUrl}/update/${id}`, forme);
  }
  // Delete Forme
  deleteForme(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
