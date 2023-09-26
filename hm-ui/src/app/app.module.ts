import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { WelcomeComponent } from './welcome/welcome.component';
import { SignupComponent } from './signup/signup.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { SigninComponent } from './signin/signin.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';

import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { DoctorupdateComponent } from './doctorupdate/doctorupdate.component';
import { MyspaceComponent } from './myspace/myspace.component';
import { AdminupdateComponent } from './admin/adminupdate/adminupdate.component';
import { DoctordashboardComponent } from './doctor/doctordashboard/doctordashboard.component';

import { PatientupdateComponent } from './patient/patientupdate/patientupdate.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { PatientviewComponent } from './patient/patientview/patientview.component';
import { DoctorspaceComponent } from './doctorspace/doctorspace.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { AppointmentlistComponent } from './appointment/appointmentlist/appointmentlist.component';
import { DoctorpathComponent } from './doctordetails/doctorpath/doctorpath.component';
import { PatientdashboardComponent } from './patient/patientdashboard/patientdashboard.component';
import { SearchComponent } from './search/search.component';
import { PatientlistComponent } from './doctor/patientlist/patientlist.component';
import { DocpofileComponent } from './patient/patientdashboard/docpofile/docpofile.component';
import { ShareModule } from '@ngx-share/core';
import { NgxPaginationModule } from 'ngx-pagination';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { LoaderComponent } from './loader/loader.component';
import { MyappointmentComponent } from './patient/patientdashboard/myappointment/myappointment.component';
import { AppointmentService } from './appointment.service';
import { RegisterGuardService } from './Register-guard.service';
import { AuthService } from './auth.service';
import { CustomHttpInterceptor } from './http.interceptor';

@NgModule({
  declarations: [
    AppComponent,

    WelcomeComponent,
    SignupComponent,
    AdminComponent,
    SigninComponent,
    DoctorComponent,
    PatientComponent,
    DoctordetailsComponent,
    DoctorupdateComponent,
    MyspaceComponent,
    AdminupdateComponent,
    DoctordashboardComponent,
    PatientupdateComponent,
    AppointmentComponent,
    PatientviewComponent,
    DoctorspaceComponent,
    UserloginComponent,
    AppointmentlistComponent,
    DoctorpathComponent,
    PatientdashboardComponent,
    SearchComponent,
    PatientlistComponent,
    DocpofileComponent,
    LoaderComponent,
    MyappointmentComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    ShareModule,
    NgxPaginationModule,
    NgbModule,
    NgbPaginationModule,
    CommonModule,
    BsDatepickerModule.forRoot()


  ],
  providers: [AppointmentService,RegisterGuardService,AuthService, {provide:HTTP_INTERCEPTORS, useClass:CustomHttpInterceptor, multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
