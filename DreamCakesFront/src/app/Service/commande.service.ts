import { Injectable } from '@angular/core';
import { CommandeDto } from '../Model/CommandeDto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private baseUrl = 'http://localhost:8089/api/v1/commande'; // Update with your API URL

  constructor(private http: HttpClient) { }

  createCommande(commandeDto: CommandeDto): Observable<CommandeDto> {
    return this.http.post<CommandeDto>(`${this.baseUrl}/add`, commandeDto);
  }

    // Appelle l'API pour obtenir toutes les commandes de l'utilisateur authentifié
    getAllCommendes(): Observable<CommandeDto[]> {
      return this.http.get<CommandeDto[]>(`${this.baseUrl}/show`);
    }
}
