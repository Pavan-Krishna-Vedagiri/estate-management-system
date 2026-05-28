import { Component } from '@angular/core';
import { map, Observable, shareReplay } from 'rxjs';
import { Resident } from '../../../shared/models/Resident';
import { AuthService } from '../../../core/auth/auth-service';
import { Router } from '@angular/router';
import { CommonApiService } from '../../../core/services/common-api-service';
import { AsyncPipe } from '@angular/common';
import { PagingComponent } from '../../../shared/paging-component/paging-component';

@Component({
  selector: 'app-resident-list-component',
  imports: [ AsyncPipe, PagingComponent],
  templateUrl: './resident-list-component.html',
  styleUrl: './resident-list-component.css',
})
export class ResidentListComponent {

  residents$ !: Observable<Resident[]>;
  resident$  !: Observable<any>;
  test: string = "";

  constructor(
    private authService: AuthService,
    private router: Router,
    private commonApiService: CommonApiService
  ) { }

  ngOnInit() {
    this.getResidents();
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(["/login"]);
  }

  getResidents() {
    this.residents$ = this.commonApiService.get("/residents").pipe(
      map((data: any) => data.data.residents)
    );
  }

  getResident(id: string) {
    this.router.navigate([`/residents/view/${id}`]);
  }

  navigateCreateResident() {
    this.router.navigate(['/residents/create'])
  }
}
