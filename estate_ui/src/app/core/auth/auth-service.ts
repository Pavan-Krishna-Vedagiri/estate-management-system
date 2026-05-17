import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root',
})
export class AuthService {

  
  private authApiUrl : string = "http://localhost:8080/auth/login"

  constructor(private http : HttpClient){
  }

  login(username : string, password : string){
    return this.http.post(this.authApiUrl, {username, password});
  }

  saveToken(token : string){
    localStorage.setItem("Jwt-Token", token);
  }
  
  getToken() : string | null{
    return localStorage.getItem("Jwt-Token");
  }

  isLoginned() : boolean {
    return !!this.getToken()
  }

  logout(){
    localStorage.removeItem("JWT-token")
  }

}
