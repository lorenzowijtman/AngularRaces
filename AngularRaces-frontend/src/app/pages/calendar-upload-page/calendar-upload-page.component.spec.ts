import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarUploadPageComponent } from './calendar-upload-page.component';

describe('CalendarUploadPageComponent', () => {
  let component: CalendarUploadPageComponent;
  let fixture: ComponentFixture<CalendarUploadPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalendarUploadPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalendarUploadPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
