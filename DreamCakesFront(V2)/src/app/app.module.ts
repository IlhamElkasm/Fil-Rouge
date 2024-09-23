import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component'; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { JWT_OPTIONS, JwtHelperService } from '@auth0/angular-jwt';
import { AuthService } from './Services/auth.service';
import { AuthInterceptorInterceptor } from './interceptor/auth-interceptor.interceptor';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
    [AuthService,
      { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorInterceptor, multi: true }
    ],
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
