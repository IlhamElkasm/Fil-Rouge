import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './Components/sidebar/sidebar.component';
import { MainComponent } from './Components/main/main.component';
import { FooterComponent } from './Components/footer/footer.component';
import { FormComponent } from './Components/Forms/Showform/form.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ShowsaveurComponent } from './Components/Saveurs/showsaveur/showsaveur.component';
import { ShowgarnitureComponent } from './Components/Garniture/showgarniture/showgarniture.component';
import { LoginComponent } from './Components/Authentication/login/login.component';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component'; 
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JWT_OPTIONS, JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationService } from './Service/authentication.service';
import { AuthInterceptorInterceptor } from './interceptor/auth-interceptor.interceptor';




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



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
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
