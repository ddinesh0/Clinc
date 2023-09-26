import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hospital';
  show:number;
  public link: string = 'https://medium.com/@garfunkel61/angular-simplest-solution-for-social-sharing-feature-6f00d5d99c5e'
}
