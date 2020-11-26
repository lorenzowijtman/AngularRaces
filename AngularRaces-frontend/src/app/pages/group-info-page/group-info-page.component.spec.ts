import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupInfoPageComponent } from './group-info-page.component';

describe('GroupInfoPageComponent', () => {
  let component: GroupInfoPageComponent;
  let fixture: ComponentFixture<GroupInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
