import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BeerListComponent } from './beer-list/beer-list.component'
import { DashboardComponent } from './dashboard/dashboard.component'
import { RandomBeerApiComponent } from './random-beer-api/random-beer-api.component';
import { ContactComponent } from './contact/contact.component';

export const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'list', component: BeerListComponent },
  { path: 'randomBeer', component: RandomBeerApiComponent},
  { path: 'contact', component: ContactComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }