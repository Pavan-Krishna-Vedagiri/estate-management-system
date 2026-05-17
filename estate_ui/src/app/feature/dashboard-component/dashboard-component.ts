import { ChangeDetectionStrategy, Component } from '@angular/core';
import { AuthService } from '../../core/auth/auth-service';
import { Router } from '@angular/router';
import { CommonApiService } from '../../core/services/common-api-service';
import { CommonModule } from '@angular/common';
import { map, Observable } from 'rxjs';

@Component({
  selector: 'app-dashboard-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-component.html',
  styleUrl: './dashboard-component.css',
  changeDetection: ChangeDetectionStrategy.Default
})
export class DashboardComponent {

  residents$ !: Observable<any[]>;
  resident$  !: Observable<any>;
  test: string = "";

  constructor(
    private authService: AuthService,
    private router: Router,
    private commonApiService: CommonApiService
  ) {}

  ngOnInit() {
    this.getResidents();
    this.test = "Some things";
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
    this.resident$ = this.commonApiService.get(`/residents/${id}`).pipe(
      map(data => data.data)
    )
  }

  navigateCreateResident(){
    this.router.navigate(['/residents/create'])
  }
}
