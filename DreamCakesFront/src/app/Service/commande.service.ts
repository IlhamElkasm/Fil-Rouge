import { Injectable } from '@angular/core';
import { CommandeDto } from '../Model/CommandeDto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private baseUrl = 'http://localhost:8089/api/v1/User/commande'; // Update with your API URL

  constructor(private http: HttpClient) { }

  createCommande(commandeDto: CommandeDto): Observable<CommandeDto> {
    return this.http.post<CommandeDto>(this.baseUrl, commandeDto);
  }
}
