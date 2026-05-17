import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CreateResidentComponent } from './create-resident-component/create-resident-component';
import { ResidentRoutingModule } from './resident-routing-module';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    RouterModule,
    CreateResidentComponent,
    ResidentRoutingModule,
    ReactiveFormsModule
  ]
})
export class ResidentModule { }
