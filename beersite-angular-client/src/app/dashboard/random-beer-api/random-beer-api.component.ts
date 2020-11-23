import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BrewDogBeer } from '../../models/brewDogBeer';
import { Observable } from "rxjs";

@Component({
  selector: 'app-random-beer-api',
  templateUrl: './random-beer-api.component.html',
  styleUrls: ['./random-beer-api.component.css']
})
export class RandomBeerApiComponent implements OnInit {

  constructor(private http: HttpClient) {}

  randomBeer: BrewDogBeer[]; // variable: <interface>
  baseUrl = 'https://api.punkapi.com/v2/beers/random';

  ngOnInit() {
    this.getBeer().subscribe
    (data => { 
      this.randomBeer = data;
    } )
  }

  getBeer(): Observable<any> {
    return this.http.get(this.baseUrl);
  }


}

