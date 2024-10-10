import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GateauDto } from '../Model/GateauDto';
import { Observable } from 'rxjs';
import { cake } from '../Model/cake';

@Injectable({
  providedIn: 'root'
})
export class GateauService {
  private baseUrl = 'http://localhost:8089/api/v1/User'; 

  constructor(private http: HttpClient) { }

  createGateau(gateauDto: GateauDto): Observable<GateauDto> {
    console.log('Sending request to create gateau:', gateauDto); // Log request data
    return this.http.post<GateauDto>(`${this.baseUrl}/gateau`, gateauDto);
  }

    // Méthode pour récupérer les détails d'un gâteau par son ID
    getGateauById(id: number): Observable<cake> {
      return this.http.get<cake>(`${this.baseUrl}/${id}`);
    }
}
