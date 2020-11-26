import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ApiService} from '../../services/api.service';
import {DataService} from '../../services/data.service';
import * as $ from 'jquery';

@Component({
    selector: 'app-calendar-page',
    templateUrl: './calendar-page.component.html',
    styleUrls: ['./calendar-page.component.css'],
    providers: [ApiService]
})
export class CalendarPageComponent implements OnInit {
    races: any;
    group: any;
    private idgroup: number;

    constructor(private apiService: ApiService, private  router: Router, private dataService: DataService) {
        this.apiService
            .getGroupsByUserId()
            .subscribe(res => (this.group = res));
    }

    viewCalander(event) {
        const groupName = $('#group').val();
        console.log(groupName);
        for (let i = 0, keys = Object.keys(this.group), l = keys.length; i < l; i++) {
            if (this.group[i].name === groupName) {
                this.idgroup = this.group[i].idgroup;
                break;
            }
        }

        console.log(this.idgroup);
        this.apiService.getCalanderOnRaceId(this.idgroup)
            .subscribe(data => {
                this.races = data;
                this.createJSDateObjects(data);
            });
    }

    viewResults(race) {
        if (this.raceIsInThePast(race)) {
            this.dataService.setMessage(race.idrace);
            this.router.navigateByUrl('/results');
        }
    }

    ngOnInit() {
        if (sessionStorage.getItem('id') == null) {
            this.router.navigateByUrl('/');
        }
    }

    raceIsInThePast(race) {
        return race['date'] < new Date();
    }

    createJSDateObjects(data) {
        for (let i = 0; i < data.length; i++) {
            this.races[i]['date'] = new Date(data[i]['date']);
        }
    }

}
