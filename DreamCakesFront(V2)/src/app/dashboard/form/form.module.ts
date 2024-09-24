import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormRoutingModule } from './form-routing.module';
import { FormComponent } from './form.component';
import { EditComponent } from './edit/edit.component';
import { AddComponent } from './add/add.component';
import { ShowAllComponent } from './show-all/show-all.component';
import { DeleteComponent } from './delete/delete.component';


@NgModule({
  declarations: [
    FormComponent,
    EditComponent,
    AddComponent,
    ShowAllComponent,
    DeleteComponent
  ],
  imports: [
    CommonModule,
    FormRoutingModule
  ]
})
export class FormModule { }
