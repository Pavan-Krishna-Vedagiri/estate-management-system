import { Routes } from '@angular/router';
import { LoginComponent } from './features/auth/login-component/login-component';
import { DashboardComponent } from './features/dashboard-component/dashboard-component';
import { authGuard } from './core/auth/auth-guard';

export const routes: Routes = [
    { path : "", loadChildren : () => import('./features/auth/auth-module').then(m => m.AuthModule) },
    { path : "dashboard", component : DashboardComponent, canActivate : [authGuard] },
    { path : "residents", loadChildren : () => import('./features/')},
    {path : "", redirectTo : "login", pathMatch : 'full'}
];
