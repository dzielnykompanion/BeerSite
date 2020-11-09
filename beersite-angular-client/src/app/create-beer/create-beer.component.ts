import { Component, OnInit, Output } from '@angular/core';
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



  ngOnInit() {
    }

    onSubmit(data) {
      this._beerService.createBeer(data).subscribe(
        (data) => {
          console.log(data);
        },
        (error) => console.log(error)
      );
    }


}
