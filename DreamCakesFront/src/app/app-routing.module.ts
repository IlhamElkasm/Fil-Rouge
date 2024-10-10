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
import { AllGarnitureComponent } from './Components/Authentication/Admin/Garniture/all-garniture/all-garniture.component';
import { AddGarnitureComponent } from './Components/Authentication/Admin/Garniture/add-garniture/add-garniture.component';
import { EditGarnitureComponent } from './Components/Authentication/Admin/Garniture/edit-garniture/edit-garniture.component';
import { RegisterComponent } from './Components/Authentication/User/register/register.component';
import { FormComponent } from './Components/Authentication/User/Showform/form.component';
import { ShowsaveurComponent } from './Components/Authentication/User/showsaveur/showsaveur.component';
import { ShowgarnitureComponent } from './Components/Authentication/User/showgarniture/showgarniture.component';
import { CakePreviewComponent } from './Components/Authentication/User/cake-preview/cake-preview.component';
import { CommandeListComponent } from './Components/Authentication/User/commande-list/commande-list.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, children: [

    { path : 'commande' , component : CommandeListComponent},


    { path: '', component: MainComponent },
    //Form
    { path: 'allform', component: FormComponent },
    { path: 'show', component: ShowComponent},
    {path: 'AddForm', component: AddFormComponent},
    { path: 'edit/:id', component: EditComponent },

    //Saveur
    { path: 'allsaveur', component: ShowsaveurComponent },
    { path: 'All', component: AllSaveurComponent},
    {path: 'AddSaveur', component: AddSaveurComponent},
    { path: 'update/:id', component: EditSaveurComponent },

     //Garniture
     { path: 'allgarniture', component: ShowgarnitureComponent },
     { path: 'Allgarniture', component: AllGarnitureComponent},
     {path: 'AddGarnitur', component: AddGarnitureComponent},
     { path: 'updateG/:id', component: EditGarnitureComponent },

     { path : 'Cakereview', component: CakePreviewComponent},

    { path: 'logout', component: LoginComponent },
  ]},
  { path: 'Register', component: RegisterComponent },
  { path: '**', redirectTo: '/login' },
]

    



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
