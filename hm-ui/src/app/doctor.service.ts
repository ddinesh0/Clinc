import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctor } from './doctor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseUrl='http://localhost:8080/api/doctors';
  private baseUrl1='http://localhost:8080/api/doctors';
  private baseUrl2='http://localhost:8080/api/doctors/put';
  private baseUrl3='http://localhost:8080/api/doctors/doctor';
  private baseUrl4='http://localhost:8080/api/doctors/dlogin';

  constructor(private http:HttpClient) {

   }
   public formcreate(doctor:Doctor){
    return this.http.post("http://localhost:8080/api/doctors/post",doctor);
  }
  public logindoctor(doctor:Doctor):Observable<object>
  {
    return this.http.post(`${this.baseUrl4}`,doctor);
  }
  public updatedoctor(id:number,doctor:Doctor):Observable<object>{
    return this.http.put(`${this.baseUrl2}/${id}`,doctor);
  }

  getview():Observable<Doctor[]>{
    return this.http.get<Doctor[]>(`${this.baseUrl3}`);
  }

  getdoctorById(id:number):Observable<Doctor>{
    return this.http.get<Doctor>(`${this.baseUrl}/${id}`);
   }

  deletelist(id:number):Observable<any>
  {
   return this.http.delete(`${this.baseUrl1}/${id}`,{responseType:'text'});
  }

  setprofile(doctor:any){
    localStorage.setItem("doctor",doctor);

  }
  getprofile():any{
const role=localStorage.getItem("doctor");
return role;
  }
  logout(): void {
    // Clear localStorage
    localStorage.clear();
}
}
