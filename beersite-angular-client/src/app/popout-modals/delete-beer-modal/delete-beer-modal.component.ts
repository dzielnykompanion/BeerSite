import { BeerService } from '../../beer-service/beer.service';
import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { _DisposeViewRepeaterStrategy } from '@angular/cdk/collections';


@Component({
  selector: 'app-delete-beer-modal',
  templateUrl: './delete-beer-modal.component.html',
  styleUrls: ['./delete-beer-modal.component.css'],

})
export class DeleteBeerModalComponent implements OnInit {

  constructor(
    private _matDialogRef: MatDialogRef<DeleteBeerModalComponent>,
  ) { }

  ngOnInit() {
  }

  closeDialog(){
    this._matDialogRef.close();
  }
}
