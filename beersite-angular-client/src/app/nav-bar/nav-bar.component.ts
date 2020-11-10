import { Component, OnInit } from '@angular/core';
import { BeerService } from '../beer-service/beer.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private _beerService: BeerService
    ) {}

  deleteBeer(id: number) {
    this._beerService.deleteBeer(id).subscribe(
      (data) => {
        console.log(data);
      },
      (error) => console.log(error)
    );
  }

  ngOnInit(): void {
  }

}
