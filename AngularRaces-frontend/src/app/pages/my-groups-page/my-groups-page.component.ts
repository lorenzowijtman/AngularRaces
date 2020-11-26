import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { ApiService } from "../../services/api.service";

@Component({
    selector: "app-my-groups-page",
    templateUrl: "./my-groups-page.component.html",
    styleUrls: ["./my-groups-page.component.css"],
    providers: [ApiService]
})

export class MyGroupsPageComponent implements OnInit {
    usernames: Array<object>;
    groups: object;
    groups2: Array<string>;
    noObject: boolean;
    notLoaded: boolean;

    constructor(private router: Router, private apiService: ApiService) {
        this.usernames = new Array<object>();
        this.noObject = false;
        this.notLoaded = true;
        this.groups2 = new Array<string>();
    }

    ngOnInit() {
        this.apiService
            .getGroupsByUserId()
            .subscribe(data => {this.groups = data;
                for(let group in this.groups) {
                    this.apiService.getUserByGroupId(this.groups[group].idgroup).subscribe(res => {this.usernames.push(res);
                        this.groups2.push(this.groups[group].name);
                    });
                }
                this.notLoaded = false;
            });
    }

    groupBtnClick() {
        this.router.navigateByUrl("/groupinfo");
    }
}
