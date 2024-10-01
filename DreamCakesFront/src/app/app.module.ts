import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './Components/sidebar/sidebar.component';
import { MainComponent } from './Components/main/main.component';
import { FooterComponent } from './Components/footer/footer.component';
import { FormComponent } from './Components/Authentication/User/Showform/form.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ShowsaveurComponent } from './Components/Authentication/User/showsaveur/showsaveur.component';
import { ShowgarnitureComponent } from './Components/Authentication/User/showgarniture/showgarniture.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component'; 
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JWT_OPTIONS, JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationService } from './Service/authentication.service';
import { AuthInterceptorInterceptor } from './interceptor/auth-interceptor.interceptor';
import { AddFormComponent } from './Components/Authentication/Admin/Size/add-form/add-form.component';
import { ShowComponent } from './Components/Authentication/Admin/Size/show/show.component';


//++++++++++++++Angular Materail
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatCardModule} from '@angular/material/card';
import { EditComponent } from './Components/Authentication/Admin/Size/edit/edit.component';




@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    MainComponent,
    FooterComponent,
    FormComponent,
    ShowsaveurComponent,
    ShowgarnitureComponent,
    LoginComponent,
    DashboardComponent,
    AddFormComponent,
    ShowComponent,
    EditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  //++++++++++++++Angular Materail
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule
   
  ],
  providers: [
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
    [AuthenticationService,
      { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorInterceptor, multi: true }
    ],
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
