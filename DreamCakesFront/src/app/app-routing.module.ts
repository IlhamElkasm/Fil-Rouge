import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './Components/Authentication/dashboard/dashboard.component';
import { MainComponent } from './Components/main/main.component';
import { RouterModule, Routes } from '@angular/router';
import { AddFormComponent } from './Components/Authentication/Admin/Size/add-form/add-form.component';
import { ShowComponent } from './Components/Authentication/Admin/Size/show/show.component';
import { EditComponent } from './Components/Authentication/Admin/Size/edit/edit.component';
import { AddSaveurComponent } from './Components/Authentication/Admin/Saveur/add-saveur/add-saveur.component';
import { AllSaveurComponent } from './Components/Authentication/Admin/Saveur/all-saveur/all-saveur.component';
import { EditSaveurComponent } from './Components/Authentication/Admin/Saveur/edit-saveur/edit-saveur.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, children: [
    { path: '', component: MainComponent },
    { path: 'show', component: ShowComponent},
    {path: 'AddForm', component: AddFormComponent},
    { path: 'edit/:id', component: EditComponent },

    { path: 'All', component: AllSaveurComponent},
    {path: 'AddSaveur', component: AddSaveurComponent},
    { path: 'update/:id', component: EditSaveurComponent },
    { path: 'logout', component: LoginComponent },
  ]},
  { path: '**', redirectTo: '/login' },
]

    



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
