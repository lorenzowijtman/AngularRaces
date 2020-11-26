import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-results-upload-page',
  templateUrl: './results-upload-page.component.html',
  styleUrls: ['./results-upload-page.component.css']
})
export class ResultsUploadPageComponent implements OnInit {

  constructor(private  router: Router) { }

  ngOnInit() {
      if (sessionStorage.getItem('id') == null) {
          this.router.navigateByUrl('/');
      }
  }

}
