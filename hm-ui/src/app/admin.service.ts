import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Admin } from './admin';
import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8080/api/admin';
  private baseUrl1 = 'http://localhost:8080/api/admin';


  constructor(private http:HttpClient)  { }

  public registerAdmin(admin:Admin){

    return this.http.post("http://localhost:8080/api/admin/register",admin);

  }
  public loginAdmin(admin:Admin){
    return this.http.post("http://localhost:8080/api/admin/login",admin);

  }

  public logindoctor(admin:Admin){
    return this.http.post("http://localhost:8080/api/doctors/dlogin",admin);

  }

   public getById(id: number):Observable<Admin> {
    return this.http.get<Admin>(`${this.baseUrl}/${id}`);

  }
  public getview():Observable<Admin[]>{
    return this.http.get<Admin[]>(`${this.baseUrl}`)
  }
  public updateadmin(id:number,admin:Admin):Observable<object>{
    return this.http.put(`${this.baseUrl1}/${id}`,admin);
  }


  // getview():Observable<Bill[]>{
  //   return this.http.get<Bill[]>(`${this.baseUrl}`);
  // }

  setprofile(admin:any){
    localStorage.setItem("admin",admin);

  }
  getprofile():any{
const role=localStorage.getItem("admin");
return role;
  }
  logout(): void {
    // Clear localStorage
    localStorage.clear();
}
}
