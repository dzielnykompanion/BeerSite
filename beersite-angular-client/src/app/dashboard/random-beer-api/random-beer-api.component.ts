import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BrewDogBeer } from '../../models/brewDogBeer';

@Component({
  selector: 'app-random-beer-api',
  templateUrl: './random-beer-api.component.html',
  styleUrls: ['./random-beer-api.component.css']
})
export class RandomBeerApiComponent implements OnInit {

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }

  randomBeer: BrewDogBeer;

  private baseUrl = 'https://api.punkapi.com/v2/beers/random';

}
