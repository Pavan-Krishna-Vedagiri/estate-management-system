import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RoomRoutingModule } from './room-routing-module';
import {ViewRoomsComponent } from './view-rooms-component/view-rooms-component'


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RoomRoutingModule,
    ViewRoomsComponent
  ]
})
export class RoomModule { }
