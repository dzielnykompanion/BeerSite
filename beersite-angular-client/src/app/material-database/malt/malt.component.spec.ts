import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaltComponent } from './malt.component';

describe('MaltComponent', () => {
  let component: MaltComponent;
  let fixture: ComponentFixture<MaltComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaltComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MaltComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
