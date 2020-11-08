import { Component, OnInit } from '@angular/core';
import { Beer } from '../models/beer';
import { BeerService } from '../beer-service/beer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-beer-details',
  templateUrl: './beer-details.component.html',
  styleUrls: ['./beer-details.component.css']
})
export class BeerDetailsComponent implements OnInit {

  constructor(private _beerService: BeerService, private router: Router) {}

  beer: Beer;

  ngOnInit(){
    this._beerService.getBeerList()
    .subscribe
    (
      data =>
      {
        this.beer = data;
      }
    )
  }
}
