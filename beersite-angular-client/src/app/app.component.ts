import { Component } from '@angular/core';
import {MatDialog,MatDialogConfig} from '@angular/material/dialog';
import {CreateBeerComponent} from './create-beer/create-beer.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'beersite-angular-client';

  constructor(private _dialog:MatDialog) {};

  openDialog(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width="70%";
    this._dialog.open(CreateBeerComponent, dialogConfig);
  }
}
