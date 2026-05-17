import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CommonApiService {
  
  private apiUrl : string = "http://localhost:8080/estate-management-portal/api/v1"

  constructor(private http : HttpClient){}

  get(url : string, params?: any) : Observable<any>{
    return this.http.get(this.apiUrl + url);
  }

  post<T>(url : string, body : any){
    return this.http.post(this.apiUrl + url, body);
  }

  put<T>(url : string, body : any){
    return this.http.put(this.apiUrl + url, body);
  }

  delete<T>(url : string){
    return this.http.delete(this.apiUrl + url);
  }

  buildParams<T>(params?: any) : HttpParams{
    let httpParams = new HttpParams();
    if(params){
      Object.keys(params).forEach(
        key => httpParams.set(key, params[key])
      );
    }
    return httpParams;
  }

}
