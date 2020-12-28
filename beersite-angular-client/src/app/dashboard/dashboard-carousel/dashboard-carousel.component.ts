import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-carousel',
  templateUrl: './dashboard-carousel.component.html',
  styleUrls: ['./dashboard-carousel.component.css']
})

export class DashboardCarouselComponent implements OnInit{

  constructor(){}

  ngOnInit(){}

  //images = [950, 999, 984].map((n) => `https://picsum.photos/id/${n}/1120/500`);
  images: string[] = ['/assets/carousel1.jpg',
                      '/assets/carousel2.jpg',
                      '/assets/carousel3.jpg']

}

