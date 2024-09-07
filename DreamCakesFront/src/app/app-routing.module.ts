import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreategateauComponent } from './Components/Gateau/creategateau/creategateau.component';
import { LoginComponent } from './Components/Authentication/login/login.component';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component';
import { MainComponent } from './Components/main/main.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, children: [
    { path: '', component: MainComponent },
  ]},
  { path: '**', redirectTo: '/login' },
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
