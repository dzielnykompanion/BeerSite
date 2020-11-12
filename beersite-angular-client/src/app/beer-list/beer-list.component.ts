import { Component, OnInit } from '@angular/core';
import { BeerService } from '../beer-service/beer.service';
import { Beer } from '../models/beer';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {MatDialog,MatDialogConfig} from '@angular/material/dialog';
import {CreateBeerComponent} from '../create-beer/create-beer.component';
import {DialogService} from '../dialog-service/dialog.service.service'

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css'],
})

export class BeerListComponent implements OnInit {
  beers: Observable<Beer[]>;

  constructor(private _beerService: BeerService,
              private _router: Router,
              private _dialog:MatDialog,
              private _dialogService: DialogService
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

  createBeerDialog(){
    this._dialogService.openCreateDialog()
        .afterClosed().subscribe(response =>{
          if(response){
                this.reloadData()
              }
              (error) => console.log(error)
            });
          }


  deleteBeerDialog(id: number){
    this._dialogService.openConfirmDialog()
        .afterClosed().subscribe(response =>{
          if(response){
            this._beerService.deleteBeer(id).subscribe(
              (data) => {
                console.log(data);
                this.reloadData()
              },
              (error) => console.log(error)
            );
          }
        });
  }
}
