import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Jwt } from '../Model/Jwt';

const BASE_URL = "http://localhost:8089/api/v1/auth/";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient, private router: Router) { }

  register(singRequest: any): Observable<Jwt> {
    const headers = this.createAuthorizationHeader();
    return this.http.post<Jwt>(`${BASE_URL}Admin/register`, singRequest, { headers });
}


  login(username: string, password: string): Observable<any> {
    const loginRequest = { username, password };
    return this.http.post<any>(`${BASE_URL}authenticate`, loginRequest);
  }

  getUserCount(): Observable<number> {
    const headers = this.createAuthorizationHeader();
    return this.http.get<number>(`${BASE_URL}Admin/count`, { headers });
  }


  private createAuthorizationHeader(): HttpHeaders | undefined {
    const jwtToken = localStorage.getItem('jwt');
    if (jwtToken) {
        return new HttpHeaders().set("Authorization", "Bearer " + jwtToken);
    } else {
        return undefined;
    }
}
}
