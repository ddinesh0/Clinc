import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{


  constructor(){}


  ngOnInit(): void {

  }

  entersearchvalue:string='';

  @Output()
  searchTextChanged: EventEmitter<string> = new EventEmitter<string>();


  onSearch() {
    this.searchTextChanged.emit(this.entersearchvalue);
  }
}
