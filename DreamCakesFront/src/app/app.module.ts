import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './Components/sidebar/sidebar.component';
import { MainComponent } from './Components/main/main.component';
import { FooterComponent } from './Components/footer/footer.component';
import { FormComponent } from './Components/Forms/Showform/form.component';
import { HttpClientModule } from '@angular/common/http';
import { ShowsaveurComponent } from './Components/Saveurs/showsaveur/showsaveur.component';
import { ShowgarnitureComponent } from './Components/Garniture/showgarniture/showgarniture.component';
import { CreategateauComponent } from './Components/Gateau/creategateau/creategateau.component';
import { LoginComponent } from './Components/Authentication/login/login.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component'; 
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    MainComponent,
    FooterComponent,
    FormComponent,
    ShowsaveurComponent,
    ShowgarnitureComponent,
    CreategateauComponent,
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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
