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
import { MatDialogModule} from '@angular/material/dialog';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { DeleteBeerModalComponent } from './popout-modals/delete-beer-modal/delete-beer-modal.component';
import { CustomMinDirective } from './shared/directives/custom-min-directive';
import { CustomMaxDirective } from './shared/directives/custom-max-directive';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateBeerComponent,
    BeerDetailsComponent,
    BeerListComponent,
    CreateBeerComponent,
    NavBarComponent,
    DeleteBeerModalComponent,
    CustomMinDirective,
    CustomMaxDirective,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([]),
    FormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatCardModule,
    MatButtonModule,
    AppRoutingModule
  ],
  providers: [BeerService],
  bootstrap: [AppComponent],
  entryComponents: [CreateBeerComponent, DeleteBeerModalComponent],
})
export class AppModule { }
