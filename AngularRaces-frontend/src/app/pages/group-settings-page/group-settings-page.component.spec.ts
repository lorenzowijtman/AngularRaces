import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupSettingsPageComponent } from './group-settings-page.component';

describe('GroupSettingsPageComponent', () => {
  let component: GroupSettingsPageComponent;
  let fixture: ComponentFixture<GroupSettingsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupSettingsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupSettingsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
