import { Component, OnInit } from '@angular/core';
import { BeerDetailsComponent } from '../beer-details/beer-details.component';
import { BeerService } from '../beer-service/beer.service';
import { Beer } from '../models/beer';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {MatDialog,MatDialogConfig} from '@angular/material/dialog';
import {CreateBeerComponent} from '../create-beer/create-beer.component';
import {DeleteBeerModalComponent} from '../popout-modals/delete-beer-modal/delete-beer-modal.component';


@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css'],
})
export class BeerListComponent implements OnInit {
  beers: Observable<Beer[]>;

  constructor(private _beerService: BeerService,
              private _router: Router,
              private _dialog:MatDialog
              ) {}

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

  beerDetails(id: number) {
    this._router.navigate(['details', id]);
  }


  openDialog(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width="70%";
    this._dialog.open(CreateBeerComponent, dialogConfig);
  }

  deleteBeerDialog(id: number){
    this._dialog.open(DeleteBeerModalComponent,
                     { data: {id: id} }
    );
  }
}
