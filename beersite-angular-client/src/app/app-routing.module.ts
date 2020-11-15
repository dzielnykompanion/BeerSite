import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BeerListComponent } from './beer-list/beer-list.component'

export const routes: Routes = [
  { path: '', component: AppComponent },
  { path: 'list', component: BeerListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }