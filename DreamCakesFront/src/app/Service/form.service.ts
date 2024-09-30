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

  

  // Get Forme by ID
  getFormeById(id: number): Observable<FormDto> {
    return this.http.get<FormDto>(`${this.apiUrl}/${id}`);
  }

  // Get all Formes
  getAllFormes(): Observable<FormDto[]> {
    return this.http.get<FormDto[]>(`${this.apiUrl}/show`);
  }

  // Update Forme
  updateForme(id: number, formDto: FormDto): Observable<FormDto> {
    return this.http.put<FormDto>(`${this.apiUrl}/${id}`, formDto);
  }

  // Delete Forme
  deleteForme(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
