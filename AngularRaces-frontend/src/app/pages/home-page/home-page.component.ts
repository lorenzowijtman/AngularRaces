import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ApiService} from '../../services/api.service';
import {forEach} from '@angular/router/src/utils/collection';
import {conditionallyCreateMapObjectLiteral} from '@angular/compiler/src/render3/view/util';
import {applySourceSpanToExpressionIfNeeded} from '@angular/compiler/src/output/output_ast';
import {DataService} from '../../services/data.service';

@Component({
    selector: 'app-home-page',
    templateUrl: './home-page.component.html',
    styleUrls: ['./home-page.component.css'],
    providers: [ApiService]
})
export class HomePageComponent implements OnInit {
    upcommingRaces: any;
    lastRaces: any;
    groupids: any;

    constructor(private apiService: ApiService, private router: Router, private dataService: DataService) {
        this.apiService.getGroupIdsByUserId().subscribe(data => {
            this.groupids = data;
            console.log(this.groupids);

            if (this.groupids != null) {
                this.apiService
                    .get3UpcomingRaces(this.groupids[0]['idgroup'])
                    .subscribe(data2 => {
                        this.upcommingRaces = data2;
                        this.createJSDateObjects(data2, this.upcommingRaces);
                    });

                this.apiService
                    .get3LastRaces(this.groupids[0]['idgroup'])
                    .subscribe(data2 => {
                        this.lastRaces = data2;
                        this.createJSDateObjects(data2, this.lastRaces);
                    });
            }
        });
    }

    ngOnInit() {
        if (sessionStorage.getItem('id') == null) {
            this.router.navigateByUrl('/');
        }
    }

    viewResults(race) {
        this.dataService.setMessage(race['idRace']);
        this.router.navigateByUrl('/results');
    }

    createJSDateObjects(data, object) {
        for (let i = 0; i < data.length; i++) {
            object[i][1] = new Date(data[i][1]);
        }
    }
}

