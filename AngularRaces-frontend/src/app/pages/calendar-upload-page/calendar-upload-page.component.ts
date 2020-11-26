import {Component, OnInit} from '@angular/core';
import { ApiService } from '../../services/api.service';
import {Router} from '@angular/router';
import * as $ from 'jquery';

@Component({
  selector: 'app-calendar-upload-page',
  templateUrl: './calendar-upload-page.component.html',
  styleUrls: ['./calendar-upload-page.component.css'],
  providers: [ApiService]
})
export class CalendarUploadPageComponent implements OnInit {
    idNewRace = 0;
    group: any;
    date = new Date();

    constructor( private router: Router,
               private apiService: ApiService) {this.apiService
      .getGroupsByUserId()
      .subscribe(res => (this.group = res)); }

    ngOnInit() {
        if (sessionStorage.getItem('id') == null) {
            this.router.navigateByUrl('/');
        }
    }

  getGroupId() {
      const groupName = $('#group').val();
      console.log(groupName);
      for (let i = 0, keys = Object.keys(this.group), l = keys.length; i < l; i++) {
          if (this.group[i].name === groupName) {
              console.log(this.group[i].idgroup);
             return this.group[i].idgroup;
          }
      }
  }

  calanderNav() {
      this.router.navigateByUrl('/calendar');
  }

  addNewRace(event) {
      const dateString = $('#date').val() + 'T' + $('#time').val();
      const location = $('#location').val();
      const date = new Date(dateString);
      console.log(date);

    this.apiService.createNewRaces(date, location, this.getGroupId());
     this.calanderNav();
  }

}
