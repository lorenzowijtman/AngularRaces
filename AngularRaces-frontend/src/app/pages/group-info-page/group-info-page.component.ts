import { Component, OnInit } from "@angular/core";
import * as $ from "jquery";
import {Router} from '@angular/router';
import { ApiService } from "../../api.service";

@Component({
    selector: "app-group-info-page",
    templateUrl: "./group-info-page.component.html",
    styleUrls: ["./group-info-page.component.css"],
    providers: [ApiService]
})
export class GroupInfoPageComponent implements OnInit {
    users : any;
    points: any;

    constructor(private router: Router, private apiservice: ApiService) {
        this.points = [{amount:70}, {amount:65}, {amount:55}, {amount:40}, {amount:20}, {amount:45}, {amount:25}]
    }

    ngOnInit() {
        if (sessionStorage.getItem('id') == null) {
            this.router.navigateByUrl('/');
        }
        this.apiservice.getUsersByGroupName().subscribe(data => {
            this.users = data;
        })
    }
}
