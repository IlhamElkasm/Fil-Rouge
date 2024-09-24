import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MainComponent } from './main/main.component';




//++++++++++++++Angular Materail
//dashboard
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';



@NgModule({
  declarations: [
    DashboardComponent,
    SidebarComponent,
    MainComponent,

  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
   

  ]
})
export class DashboardModule { }
