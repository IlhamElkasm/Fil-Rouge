import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FormDto } from '../Model/Form';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private apiUrl = 'http://localhost:8089/api/v1/auth';

  constructor(private http: HttpClient) { }


  // Create Forme
  createForme(formDto: FormDto): Observable<FormDto> {
    return this.http.post<FormDto>(this.apiUrl, formDto);
  }

  // Get Forme by ID
  getFormeById(id: number): Observable<FormDto> {
    return this.http.get<FormDto>(`${this.apiUrl}/${id}`);
  }

  // Get all Formes
  getAllFormes(): Observable<FormDto[]> {
    return this.http.get<FormDto[]>(`${this.apiUrl}/User/shapes`);
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
