import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditResultsPageComponent } from './edit-results-page.component';

describe('EditResultsPageComponent', () => {
  let component: EditResultsPageComponent;
  let fixture: ComponentFixture<EditResultsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditResultsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditResultsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
