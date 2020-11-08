import { Component, OnInit } from '@angular/core';
import { BeerDetailsComponent } from '../beer-details/beer-details.component';
import { BeerService } from '../beer-service/beer.service';
import { Beer } from '../models/beer';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css'],
})
export class BeerListComponent implements OnInit {
  beers: Observable<Beer[]>;

  constructor(private _beerService: BeerService, private router: Router) {}

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

  reloadData() {
    this.beers = this._beerService.getBeerList();
  }

  deleteBeer(id: number) {
    this._beerService.deleteBeer(id).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  beerDetails(id: number) {
    this.router.navigate(['details', id]);
  }
}
