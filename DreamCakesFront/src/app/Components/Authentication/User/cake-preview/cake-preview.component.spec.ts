import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CakePreviewComponent } from './cake-preview.component';

describe('CakePreviewComponent', () => {
  let component: CakePreviewComponent;
  let fixture: ComponentFixture<CakePreviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CakePreviewComponent]
    });
    fixture = TestBed.createComponent(CakePreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
