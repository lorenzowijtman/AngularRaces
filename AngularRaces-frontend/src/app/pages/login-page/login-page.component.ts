import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ApiService } from "../../services/api.service";
import * as $ from "jquery";

@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrls: ['./login-page.component.css'],
    providers: [ApiService]
})
export class LoginPageComponent implements OnInit {
    constructor(private router: Router, private http: HttpClient, private apiService : ApiService) {}

    allowNav = true;

    ngOnInit() {}

    homeNav() {
        this.router.navigateByUrl('/home');
    }

    // navigates user to home page
    loginBtnClick() {
        const email = $("#email").val();
        const password = $("#password").val();
        this.apiService.getUserFromEmail(email.toString()).subscribe(data => {
            if (email === data["email"] && password === data["password"]) {
                sessionStorage.setItem("email", data["email"]);
                this.apiService.setUserIdFromEmail(email.toString());
                sessionStorage.setItem("username", data["nickname"]);
                this.router.navigateByUrl("/home");
            }
        });
    }
}
