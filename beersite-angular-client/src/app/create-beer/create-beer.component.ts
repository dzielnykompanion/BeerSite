import { Component, OnInit } from '@angular/core';
import { BeerService } from '../beer-service/beer.service';
import { Beer } from '../models/beer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-beer',
  templateUrl: './create-beer.component.html',
  styleUrls: ['./create-beer.component.css']
})
export class CreateBeerComponent implements OnInit {

  constructor(private _beerService: BeerService, private router:Router) { }

  listBeer: Beer[];

  ngOnInit() {
    this.reloadData()
    }
  
    reloadData() {
      this._beerService.getBeerList()
      .subscribe
      (
        data =>
        {
          this.listBeer = data;
        }
      )
    }

    // onSubmit(data) {
    //   console.log(data);
    // }

    onSubmit(data) {
      this._beerService.createBeer(data).subscribe(
        (data) => {
          console.log(data);
          this.reloadData();
        },
        (error) => console.log(error)
      );
    }
}
