import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css']
})
export class LoaderComponent implements OnInit{
show:boolean=true;

constructor(){
  setTimeout(() =>{
    this.show = false;
  },1500);
}

  ngOnInit(): void {

  }

}
