import { Component, OnInit } from "@angular/core";
import * as $ from "jquery";
import { ApiService } from "../../services/api.service";
import { Router } from "@angular/router";

@Component({
    selector: "app-group-settings",
    templateUrl: "./group-settings.component.html",
    styleUrls: ["./group-settings.component.css"],
    providers: [ApiService]
})
export class GroupSettingsComponent implements OnInit {
    users: any[];

    constructor(private apiService: ApiService, private router: Router,) {
        this.users = [];
        
    }

    ngOnInit() {
        $("#userFinder").on("input", function() {
            $("#selectedUser").text("press enter to search");
        });
        $(".succes").hide();
    }

    createGroup() {
        const name = $("#groupName").val();
        const groupName: string = "" + name + "";
        if (this.users.length != 0) {
            this.apiService.createNewgroup(groupName, this.users);
        $(".succes").show();
        $(".succes").fadeOut(2000);
        this.users = [];
        this.router.navigateByUrl("/home");
        }
        
    }

    addUser(input) {
        this.users.push(input);
    }

    findUser(event: any) {
        var input = event.target.value;
        console.log(input);

        this.apiService.getUserByNickname(input.toString()).subscribe(res => {
            console.log(res);
            if (res["ok"] != false) {
                this.addUser(res);
                $("#selectedUser").text(input + " added to listing for group");
                console.log($('.list').length);
                $('.list').append("<li>"+input+"</li>");
            } else {
                console.log(res["ok"]);
                $("#selectedUser").text("user not found");
            }
        });
    }
}
