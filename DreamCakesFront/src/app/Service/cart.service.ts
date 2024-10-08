import { Injectable } from '@angular/core';
import { GateauDto } from '../Model/GateauDto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Cart } from '../Model/Cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private baseUrl = 'http://localhost:8089/api/v1/User/cart'; 

  constructor(private http: HttpClient) { }
  // Exemple d'ajout dans le service
  addToCart(gateauDto: GateauDto): Observable<Cart> {
    return this.http.post<Cart>(`${this.baseUrl}/add`, gateauDto);
  }

}
