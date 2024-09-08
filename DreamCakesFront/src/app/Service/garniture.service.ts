import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GarnitureDto } from '../Model/Garniture';

@Injectable({
  providedIn: 'root'
})
export class GarnitureService {
  private apiUrl = 'http://localhost:8089/api/v1/auth';

  constructor(private http: HttpClient) {}

  private createAuthorizationHeader(): HttpHeaders | undefined {
    const jwtToken = localStorage.getItem('jwt');
    if (jwtToken) {
        return new HttpHeaders().set("Authorization", "Bearer " + jwtToken);
    } else {
        return undefined;
    }
  }

  saveGarniture(garniture: GarnitureDto): Observable<GarnitureDto> {
    return this.http.post<GarnitureDto>(`${this.apiUrl}`, garniture);
  }

  getGarnitureById(id: number): Observable<GarnitureDto> {
    return this.http.get<GarnitureDto>(`${this.apiUrl}/${id}`);
  }

  getAllGarnitures(): Observable<GarnitureDto[]> {
    const headers = this.createAuthorizationHeader();
    return this.http.get<GarnitureDto[]>(`${this.apiUrl}/User/garniture` , { headers });
  }

  updateGarniture(id: number, garniture: GarnitureDto): Observable<GarnitureDto> {
    return this.http.put<GarnitureDto>(`${this.apiUrl}/${id}`, garniture);
  }

  deleteGarniture(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
