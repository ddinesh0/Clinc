import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Patient } from './patient';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {



private baseUrl='http://localhost:8080/api/patient/patient';
private baseUrl1='http://localhost:8080/api/patient';
private baseUrl2='http://localhost:8080/api/patient/put';
private baseUrl3='http://localhost:8080/api/patient';


  constructor( private http:HttpClient) { }

private handleError(error:HttpErrorResponse){
  if(error.error instanceof ErrorEvent){
    console.error('An error occured:', error.error.message);
  }else{
    console.error(
      `Backend retured code ${error.status},`+
      `body was: ${error.error}`
    )
  }
  return throwError(
    'Something bad happened; please try again later.'
  );
};

  public registerPatient(patient:Patient){
    return this.http.post("http://localhost:8080/api/patient",patient);
  }
  getview():Observable<Patient[]>{
    return this.http.get<Patient[]>(`${this.baseUrl}`)
    .pipe(catchError(this.handleError)
    );
  }
  updatepatient(id: number, patient:Patient):Observable<object> {
    return this.http.put(`${this.baseUrl2}/${id}`,patient)
  }

  getbypatientid(id: number):Observable<Patient>{
    return this.http.get<Patient>(`${this.baseUrl1}/${id}`);
  }
  deletelist(id:number):Observable<any>{
    return this.http.delete(`${this.baseUrl3}/${id}`,{responseType:'text'});
  }
  patientlogin(patient:Patient){
    return this.http.post("http://localhost:8080/api/patient/plogin",patient);

  }

  setprofile(patient:any){
    localStorage.setItem("patient",patient);

  }
  getprofile():any{
const role=localStorage.getItem("patient");
return role;
  }
  logout(): void {
    // Clear localStorage
    localStorage.clear();
  }


}
