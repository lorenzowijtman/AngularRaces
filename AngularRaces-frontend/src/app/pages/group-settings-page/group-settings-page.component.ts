import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-group-settings-page',
  templateUrl: './group-settings-page.component.html',
  styleUrls: ['./group-settings-page.component.css']
})
export class GroupSettingsPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
      if (sessionStorage.getItem('id') == null) {
          this.router.navigateByUrl('/');
      }
  }
}
