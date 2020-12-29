import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BeerListComponent } from './beer-list/beer-list.component'
import { DashboardComponent } from './dashboard/dashboard.component'
import { RandomBeerApiComponent } from './random-beer-api/random-beer-api.component';
import { ContactComponent } from './contact/contact.component';
import { MaterialDatabaseComponent } from './material-database/material-database.component';
import { YeastComponent } from './material-database/yeast/yeast.component';
import { HopComponent } from './material-database/hop/hop.component';
import { MaltComponent } from './material-database/malt/malt.component';

export const routes: Routes = [
  { path: '', redirectTo:'/home', pathMatch: 'full'},
  { path: 'home', component: DashboardComponent },
  { path: 'list', component: BeerListComponent },
  { path: 'randomBeer', component: RandomBeerApiComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'materialDatabase', component: MaterialDatabaseComponent},

  { path: 'materialDatabase/yeast', component: YeastComponent},
  { path: 'materialDatabase/hop', component: HopComponent},
  { path: 'materialDatabase/malt', component: MaltComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }