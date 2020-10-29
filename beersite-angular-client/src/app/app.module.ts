import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CreateBeerComponent } from './create-beer/create-beer.component';
import { BeerDetailsComponent } from './beer-details/beer-details.component';
import { BeerListComponent } from './beer-list/beer-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateBeerComponent,
    BeerDetailsComponent,
    BeerListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
