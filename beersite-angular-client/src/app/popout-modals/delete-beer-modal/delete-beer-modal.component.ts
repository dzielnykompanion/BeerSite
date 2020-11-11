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
    private _beerService: BeerService,
    private _matDialogRef: MatDialogRef<DeleteBeerModalComponent>,
    @Inject(MAT_DIALOG_DATA) private _id:number
  ) { }

  ngOnInit() {
  }

  deleteBeer() {
    this._beerService.deleteBeer(this._id).subscribe(
      (data) => {
        console.log(data);
      },
      (error) => console.log(error)
    );
  }

  closeDialog(){
    this._matDialogRef.close();
  }
}
