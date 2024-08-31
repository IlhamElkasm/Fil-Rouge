import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowsaveurComponent } from './showsaveur.component';

describe('ShowsaveurComponent', () => {
  let component: ShowsaveurComponent;
  let fixture: ComponentFixture<ShowsaveurComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowsaveurComponent]
    });
    fixture = TestBed.createComponent(ShowsaveurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
