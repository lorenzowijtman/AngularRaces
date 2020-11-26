import { Component, OnInit } from '@angular/core';
import {ApiService} from '../../services/api.service';
import {DataService} from '../../services/data.service';
import {Router} from '@angular/router';
import {RaceDriver} from '../../race-driver';

@Component({
  selector: 'app-results-page',
  templateUrl: './results-page.component.html',
  styleUrls: ['./results-page.component.css'],
  providers: [ApiService]
})
export class ResultsPageComponent implements OnInit {
    public results: any;

    constructor(private apiService: ApiService, private  router: Router, private dataService: DataService) {
      console.log(this.dataService.getMessage());
      this.apiService
          .getRaceResult(this.dataService.getMessage())
          .subscribe(data => {
              this.results = data;
          });
  }

  ngOnInit() {
      if (sessionStorage.getItem('id') == null) {
          this.router.navigateByUrl('/');
      }
  }

  editResults() {
        this.router.navigateByUrl('calendar/editrace');
  }


}
