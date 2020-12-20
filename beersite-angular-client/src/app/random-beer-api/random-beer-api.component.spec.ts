import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomBeerApiComponent } from './random-beer-api.component';

describe('RandomBeerApiComponent', () => {
  let component: RandomBeerApiComponent;
  let fixture: ComponentFixture<RandomBeerApiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RandomBeerApiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomBeerApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
