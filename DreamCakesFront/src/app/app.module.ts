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
import { LoginComponent } from './Components/Authentication/login/login.component';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component'; 
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JWT_OPTIONS, JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationService } from './Service/authentication.service';
import { AuthInterceptorInterceptor } from './interceptor/auth-interceptor.interceptor';
import { AddFormComponent } from './Components/Authentication/Admin/Size/add-form/add-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { AddComponent } from './Components/Authentication/Admin/Size/add/add.component';





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
    AddComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatCardModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
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
