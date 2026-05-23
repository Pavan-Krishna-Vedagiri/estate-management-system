import { ChangeDetectionStrategy, Component } from '@angular/core';
import { AuthService } from '../../core/auth/auth-service';
import { Router } from '@angular/router';
import { CommonApiService } from '../../core/services/common-api-service';
import { CommonModule } from '@angular/common';
import { map, Observable } from 'rxjs';
import { Resident } from '../../shared/models/Resident';

@Component({
  selector: 'app-dashboard-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-component.html',
  styleUrl: './dashboard-component.css',
  changeDetection: ChangeDetectionStrategy.Default
})
export class DashboardComponent {

  totalResidents = 120;
  pendingRequests = 8;
  revenue = 50000;

}
