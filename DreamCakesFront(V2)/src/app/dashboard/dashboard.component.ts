import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  sidebarOpen = true;
  userRole!: string | null;
  currentPath: string = '';

  // constructor(private authService: Aut, private router: Router) {}

  ngOnInit() {
    this.userRole = localStorage.getItem("role");
  }

  toggleSidebar() {
    this.sidebarOpen = !this.sidebarOpen;
  }

  // checkPath(): boolean {
  //   this.currentPath = this.router.url;

  //   return this.currentPath === '/dashboard';
  // }
}
