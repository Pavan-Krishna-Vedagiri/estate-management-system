import { Component } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Room } from "../../../shared/models/Room";
import { CommonApiService } from '../../../core/services/common-api-service';
import { AsyncPipe } from '@angular/common';
import { RoomBooking } from '../../../shared/models/RoomBooking'
import { Resident } from '../../../shared/models/Resident';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-rooms',
  imports: [ AsyncPipe],
  templateUrl: './view-rooms-component.html',
  styleUrl: './view-rooms-component.css'
})
export class ViewRoomsComponent {

  rooms$ !: Observable<Room[]>

  constructor(
    private commonApiService : CommonApiService,
    private router : Router
  ){}

  ngOnInit(){

    this.rooms$ =  this.commonApiService.get("/rooms").pipe(
      map((data : any) => data.data as Room[])
    );
  }

  getBookingDetail(roomId : string){
    this.router.navigate([`/rooms/${roomId}`]);
  }
}
