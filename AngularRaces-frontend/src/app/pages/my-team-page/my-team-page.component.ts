import { Component, OnInit } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ApiService } from "../../services/api.service";
import * as $ from "jquery";
import {Router} from '@angular/router';

@Component({
    selector: "app-my-team-page",
    templateUrl: "./my-team-page.component.html",
    styleUrls: ["./my-team-page.component.css"],
    providers: [ApiService]
})
export class MyTeamPageComponent implements OnInit {
    budget: number;
    drivers: any;
    used: Array<{}>;
    selected: Array<String>;
    positions: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]

    constructor(
        private apiService: ApiService,
        private htppClient: HttpClient,
        private router: Router
    ) {
        this.budget = 20000000;
        this.selected = [];
        this.used = [];
    }

    ngOnInit() {
        if (sessionStorage.getItem('id') == null) {
            this.router.navigateByUrl('/');
        }

        this.apiService.getAllDrivers().subscribe(res => {
            this.drivers = res;
            console.log(this.drivers);
        });
    }



    update(target: Event) {
        let event = target.currentTarget as HTMLInputElement;
        var selected = event.innerText;
        var parent = event.parentElement.id;

        let drivers = this.drivers;
        if (this.selected.length < 5) {
            this.selected.push(selected);
            for (let j = 0; j < this.selected.length; j++){
                for (let i = 0; i < drivers.length; i++) {
                    let budget = 20000000;
                    if (selected == drivers[i].lastname) {
                        if(budget - drivers[i].cost > 0) {
                            budget -= drivers[i].cost;
                        } else {
                            alert("not enough budget");
                        }

                        $('.budget').text("Budget: " + budget);
                        console.log(this.selected);
                    }
                }
        }



    }
}

    confirmClick() {
        let selectedDrivers = [$('#driverOne').val(), $('#driverTwo').val(), $('#driverThree').val(), $('#driverFour').val(), $('#driverFive').val()]
        let mVPosition = $('#mVPosition').val();
        let allowPost = true;

        //check for duplicate drivers and null values
        for (let i = 0; i < selectedDrivers.length; i++) {
            if(selectedDrivers[i] == "") {
                console.log("null value")
                allowPost = false;
                //show null value alert
            }
            for(let j = 0; j < selectedDrivers.length; j++) {
                if (i == j) {
                    // do nothing
                } else {
                    if(selectedDrivers[i] == selectedDrivers[j]) {
                        console.log("duplicate drivers")
                        allowPost = false;
                        //show duplicate driver alert
                    }
                }
            }
        }

        if(allowPost) {
            //send data
            this.apiService.createDriversTeam(selectedDrivers, mVPosition, "A name", this.budget);
        }
    }
}
