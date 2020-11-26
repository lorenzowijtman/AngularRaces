import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultsUploadPageComponent } from './results-upload-page.component';

describe('ResultsUploadPageComponent', () => {
  let component: ResultsUploadPageComponent;
  let fixture: ComponentFixture<ResultsUploadPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultsUploadPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultsUploadPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
