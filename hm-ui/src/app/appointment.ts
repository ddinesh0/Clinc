


export class Appointment {

  id!:number;
  age!:number;
  dates!:Date;
  disease!:string;
  patient!: Patient[];
  filter: Appointment;

}

export class Patient{
  id: number;
  name: String;
  email: String;
  contactno: String;
  password: String;
  dob: String;
  gender: String;
  country: String;
  state: String;
  city: String;
  address: String;
  appointment:number;
  role:String;
}
