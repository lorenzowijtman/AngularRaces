import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ApiService} from '../../services/api.service';
import {DataService} from '../../services/data.service';
import * as $ from 'jquery';

@Component({
    selector: 'app-edit-results-page',
    templateUrl: './edit-results-page.component.html',
    styleUrls: ['./edit-results-page.component.css'],
    providers: [ApiService]
})
export class EditResultsPageComponent implements OnInit {

    drivers: any;
    race: any;
    dnfs: Array<number>;

    constructor(private apiService: ApiService, private dataService: DataService, private router: Router) {
        apiService.getAllDrivers().subscribe(data => {
            this.drivers = data;
        });
        apiService.getRaceResult(dataService.getMessage()).subscribe(data => {
            this.race = data;
            console.log(data);
        });
        this.dnfs = [];
    }

    ngOnInit() {
        if (sessionStorage.getItem('id') == null) {
            this.router.navigateByUrl('/');
        }
    }

    parseDnfs(dnfs) {
        for (let i = 0; i < dnfs.length; i++) {
            if (dnfs[i]['checked']) {
                this.dnfs[i] = 0;
            } else {
                this.dnfs[i] = 1;
            }

        }
    }

    editRace() {
        const dnfs = document.getElementsByClassName('dnf');
        const positions = document.getElementsByClassName('position');

        this.parseDnfs(dnfs);

        let body = {};

        for (let i = 0; i < positions.length; i++) {

            body[i] = {
                idrace: this.dataService.getMessage(),
                iddriver: this.drivers[i]['iddriver'],
                startingPosition: 1,
                finishPosition: positions[i]['value'],
                finished: this.dnfs[i],
        };

            // if (i === 19) {
            //     this.apiService.saveResultsFromRace(this.dataService.getMessage(), this.drivers[i]['iddriver'], 1,
            //         positions[i]['value'], this.dnfs[i]).subscribe();
            //     window.setTimeout(this.calculateScores(), 5000);
            // } else {
            //     this.apiService.saveResultsFromRace(this.dataService.getMessage(), this.drivers[i]['iddriver'], 1,
            //         positions[i]['value'], this.dnfs[i]).subscribe();
            // }
        }
        console.log(body);
        this.apiService.saveResultsFromRace(body);
    }

    calculateScores() {
        console.log('test');
        this.apiService.calculateScores();
    }


}
