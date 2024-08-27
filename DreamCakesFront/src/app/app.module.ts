import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './Components/sidebar/sidebar.component';
import { MainComponent } from './Components/main/main.component';
import { FooterComponent } from './Components/footer/footer.component';
import { FormComponent } from './Components/form/form.component';


@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    MainComponent,
    FooterComponent,
    FormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
