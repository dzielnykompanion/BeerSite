import { Component } from '@angular/core';
import { BeerService } from './beer-service/beer.service';
import { Beer } from './models/beer';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'beersite-angular-client';

  constructor(private _beerService: BeerService){
  }

  listBeer: Beer[];

  ngOnInit() {
    this._beerService.getBeerList()
    .subscribe
    (
      data =>
      {
        this.listBeer = data;
      }
    )
  }
  
}
