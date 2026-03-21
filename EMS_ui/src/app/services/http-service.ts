import { Injectable } from '@angular/core';
import { HttpClient, provideHttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  doGetCall(url : string){
    return this.http.get(url);
  }

  
}
