import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteBeerModalComponent } from './delete-beer-modal.component';

describe('DeleteBeerModalComponent', () => {
  let component: DeleteBeerModalComponent;
  let fixture: ComponentFixture<DeleteBeerModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteBeerModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteBeerModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
