import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component';
import { MainComponent } from './Components/main/main.component';
import { RouterModule, Routes } from '@angular/router';
import { AddFormComponent } from './Components/Authentication/Admin/Size/add-form/add-form.component';
import { ShowComponent } from './Components/Authentication/Admin/Size/show/show.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, children: [
    { path: '', component: MainComponent },
    { path: 'show', component: ShowComponent},
    {path: 'AddForm', component: AddFormComponent},
    { path: 'logout', component: LoginComponent },
  ]},
  { path: '**', redirectTo: '/login' },
]

    



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
