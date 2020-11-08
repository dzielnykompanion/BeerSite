import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CreateBeerComponent } from './create-beer/create-beer.component';
import { BeerDetailsComponent } from './beer-details/beer-details.component';
import { BeerListComponent } from './beer-list/beer-list.component';

import { BeerService } from './beer-service/beer.service';

import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CreateBeerComponent,
    BeerDetailsComponent,
    BeerListComponent,
    CreateBeerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([]),
    FormsModule
  ],
  providers: [BeerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
