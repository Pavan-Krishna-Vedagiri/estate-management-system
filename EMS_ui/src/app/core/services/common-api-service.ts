import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CommonApiService {
  
  private authApiUrl : string = "http://localhost:8080/estate-management-portal/api/v1"

  constructor(private http : HttpClient){}

  get(url : string, params?: any) : Observable<any>{
    return this.http.get(this.authApiUrl + url);
  }

  post<T>(url : string, body : any){
    return this.http.post(url, body);
  }

  put<T>(url : string, body : any){
    return this.http.put(url, body);
  }

  delete<T>(url : string){
    return this.http.delete(url);
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
