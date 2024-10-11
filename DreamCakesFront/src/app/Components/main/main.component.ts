import { ViewportScroller } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Service/authentication.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  
  userRole!: string | null;


  constructor(private authService: AuthenticationService, private router: Router, private viewportScroller: ViewportScroller) {}

  ngOnInit() {
    this.userRole = localStorage.getItem("role");
  }

  onScroll(section: string) {
    console.log(section);
    
    this.viewportScroller.scrollToAnchor(section)
  }
}
