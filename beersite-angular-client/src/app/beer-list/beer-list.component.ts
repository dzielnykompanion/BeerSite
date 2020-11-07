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

  constructor(private beerService: BeerService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.beers = this.beerService.getBeerList();
  }

  deleteBeer(id: number) {
    this.beerService.deleteBeer(id).subscribe(
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
