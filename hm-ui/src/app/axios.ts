import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import axios,{AxiosResponse} from 'axios';

@Injectable({
  providedIn:'root'
})


export class AxiosService{

  constructor(){}

    getData(url: string):Observable<AxiosResponse<any>>{
      return new Observable(observer=>{
        axios.get(url).then(response=>{
          observer.next(response);
          observer.complete();
        })
        .catch(error=>{
          observer.error(error);
        })
      })
    }


}
