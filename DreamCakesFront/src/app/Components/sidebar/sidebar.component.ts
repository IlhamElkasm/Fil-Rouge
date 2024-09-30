import { Component, Input } from '@angular/core';
import { AuthenticationService } from 'src/app/Service/authentication.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  constructor(private auth : AuthenticationService){}
logout() {
  this.auth.logout();
}

  @Input() userRole!: string | null;
}
