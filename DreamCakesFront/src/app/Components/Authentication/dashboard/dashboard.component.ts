import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Service/authentication.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  userRole!: string | null;


  constructor(private authService: AuthenticationService, private router: Router) {}

  ngOnInit() {
    this.userRole = localStorage.getItem("role");
  }
}
