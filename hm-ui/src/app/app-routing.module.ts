import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { AdminComponent } from './admin/admin.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';
import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { MyspaceComponent } from './myspace/myspace.component';
import { DoctorupdateComponent } from './doctorupdate/doctorupdate.component';
import { AdminupdateComponent } from './admin/adminupdate/adminupdate.component';
import { DoctordashboardComponent } from './doctor/doctordashboard/doctordashboard.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { PatientviewComponent } from './patient/patientview/patientview.component';
import { PatientupdateComponent } from './patient/patientupdate/patientupdate.component';
import { DoctorspaceComponent } from './doctorspace/doctorspace.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { AppointmentlistComponent } from './appointment/appointmentlist/appointmentlist.component';
import { DoctorpathComponent } from './doctordetails/doctorpath/doctorpath.component';
import { PatientdashboardComponent } from './patient/patientdashboard/patientdashboard.component';
import { PatientlistComponent } from './doctor/patientlist/patientlist.component';
import { DocpofileComponent } from './patient/patientdashboard/docpofile/docpofile.component';
import { MyappointmentComponent } from './patient/patientdashboard/myappointment/myappointment.component';
import { AppointmentService } from './appointment.service';
import { RegisterGuardService } from './Register-guard.service';

const routes: Routes = [
{path: 'welcomepage', component:WelcomeComponent},
{path: 'signup', component:SignupComponent},
{path: 'signin', component:SigninComponent},
{path: 'admin',component:AdminComponent},
{path: 'doctor',component:DoctorComponent},
{path: 'doctordetails',component:DoctordetailsComponent},
{path: 'patient',component:PatientComponent},
{path: 'myspace/:id',component:MyspaceComponent},
{path: 'doctorupdate/edit/:id',component:DoctorupdateComponent},
{path: 'admin/adminupdate',component:AdminupdateComponent},
{path:'dashboard',component:DoctordashboardComponent},
{path:'appointment',component:AppointmentComponent,canActivate:[RegisterGuardService]},
{path:'patientview',component:PatientviewComponent},
{path:'patientupdate/:id',component:PatientupdateComponent},
{path:'doctorspace/:id',component:DoctorspaceComponent},
{path:'userlogin',component:UserloginComponent,canActivate:[RegisterGuardService]},
{path:'appointment/:id',component:AppointmentComponent,canActivate:[AppointmentService]},
{path:'appointmentlist',component:AppointmentlistComponent},
{path:'doctorpath',component:DoctorpathComponent},
{path:'patientdash',component:PatientdashboardComponent},
{path:'patientlist',component:PatientlistComponent},
{path:'docprofile',component:DocpofileComponent},
{path:'myappoint',component:MyappointmentComponent}

]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
