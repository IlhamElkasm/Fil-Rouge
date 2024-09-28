import { NgModule } from '@angular/core';
import { LoginComponent } from './Components/Authentication/login/login.component';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component';
import { MainComponent } from './Components/main/main.component';
import { RouterModule, Routes } from '@angular/router';
import { AddFormComponent } from './Components/Authentication/Admin/Size/add-form/add-form.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, children: [
    { path: '', component: MainComponent },
    {path: 'AddForm', component: AddFormComponent}
  ]},
  { path: '**', redirectTo: '/login' },
]

    



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
