import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string = '';
  password: string = '';
  role: string = '';

  constructor(private authService: AuthenticationService, private router: Router) {}

  onLogin() {
    this.authService.login(this.username, this.password).subscribe(
        (response) => {
            localStorage.setItem('jwt', response.token);
            localStorage.setItem('role', response.role);  // Store role
            
            if (response.role === 'ADMIN') {
                this.router.navigate(['/dashboardA']);
            } else if (response.role === 'USER') {
                this.router.navigate(['/dashboard']);
            } else {
                alert('Rôle non reconnu');
            }
        },
        (error) => {
            alert('Échec de l\'authentification');
        }
    );
}

}