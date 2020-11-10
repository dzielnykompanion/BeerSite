import { BeerService } from '../../beer-service/beer.service';
import {Component, Inject, OnInit} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';


@Component({
  selector: 'app-delete-beer-modal',
  templateUrl: './delete-beer-modal.component.html',
  styleUrls: ['./delete-beer-modal.component.css'],

})
export class DeleteBeerModalComponent implements OnInit {


  constructor(
    private _beerService: BeerService,
    // public dialogRef: MatDialogRef<AdSettingsComponent>,
    @Inject(MAT_DIALOG_DATA) public id: any
  ) { }


  ngOnInit(): void {
  }

  deleteBeer() {
    console.log(this.id);
    // this._beerService.deleteBeer(this.id).subscribe(
    //   (data) => {
    //     console.log(data);
    //   },
    //   (error) => console.log(error)
    // );
  }

}
