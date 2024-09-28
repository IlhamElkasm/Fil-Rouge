import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowgarnitureComponent } from './showgarniture.component';

describe('ShowgarnitureComponent', () => {
  let component: ShowgarnitureComponent;
  let fixture: ComponentFixture<ShowgarnitureComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowgarnitureComponent]
    });
    fixture = TestBed.createComponent(ShowgarnitureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
