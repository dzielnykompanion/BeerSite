import { Injectable } from '@angular/core';
import {MatDialog,MatDialogConfig} from '@angular/material/dialog';
import { DeleteBeerModalComponent } from '../popout-modals/delete-beer-modal/delete-beer-modal.component';
import { CreateBeerComponent } from '../create-beer/create-beer.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private _dialog: MatDialog) { }

  openConfirmDialog(){
    return this._dialog.open(DeleteBeerModalComponent,{
      disableClose: true
    })
  }

  openCreateDialog(){
    return this._dialog.open(CreateBeerComponent,{
      disableClose: true
    })
  }

}
