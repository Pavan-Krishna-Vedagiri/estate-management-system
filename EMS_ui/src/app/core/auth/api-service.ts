import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  private authApiUrl : string = "http://localhost:8080/auth/login"

  constructor(private http : HttpClient){
  }

  getRequest(url : string) : Observable<object>{
    return this.http.get(url);
  }
  
}
