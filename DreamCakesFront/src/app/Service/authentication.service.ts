import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { Jwt } from '../Model/Jwt';
import { RegisterData } from '../Model/RegisterData';
import { LoginData } from '../Model/LoginData';
import { JwtHelperService } from '@auth0/angular-jwt';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private BASE_URL = "http://localhost:8089/api/v1/auth";
  private readonly TOKEN_KEY = 'jwt';
  private readonly ROLE_KEY = 'role';

  constructor(
    private http: HttpClient,
    private router: Router,
    private jwtHelper: JwtHelperService
  ) { }

  register(registerdata: RegisterData): Observable<Jwt> {
    return this.http.post<Jwt>(`${this.BASE_URL}/register`, registerdata);
  }

  login(logindata: LoginData): Observable<Jwt> {
    return this.http.post<Jwt>(`${this.BASE_URL}/authenticate`, logindata).pipe(
      tap((response: Jwt) => {
        if (response && response.token) {
          localStorage.setItem(this.TOKEN_KEY, response.token);
          localStorage.setItem(this.ROLE_KEY, response.role);
        }
      })
    );
  }


  logout(): void {
    localStorage.removeItem(this.ROLE_KEY);
    localStorage.removeItem(this.TOKEN_KEY);
    this.router.navigate(['/login']);
  }

//   logout(): void {
//     console.log("Before logout:", localStorage.getItem('jwt'), localStorage.getItem('role'));
//     localStorage.removeItem('role');
//     localStorage.removeItem('jwt');
//     console.log("After logout:", localStorage.getItem('jwt'), localStorage.getItem('role'));
//     this.router.navigate(['/login']);
// }


  isAuthenticated(): boolean {
    const token = localStorage.getItem(this.TOKEN_KEY);
    return token != null && !this.jwtHelper.isTokenExpired(token);
  }

  getToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  getRole(): string | null {
    return localStorage.getItem(this.ROLE_KEY);
  }
}
