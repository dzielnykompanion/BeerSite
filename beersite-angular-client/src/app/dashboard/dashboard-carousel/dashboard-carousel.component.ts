import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-carousel',
  templateUrl: './dashboard-carousel.component.html',
  styleUrls: ['./dashboard-carousel.component.css']
})

export class DashboardCarouselComponent implements OnInit{

  constructor(){}

  ngOnInit(){}

  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
}

