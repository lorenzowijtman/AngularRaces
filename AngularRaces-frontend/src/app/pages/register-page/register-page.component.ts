import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../../services/api.service';
import * as $ from "jquery";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css'],
  providers: [ApiService]
})
export class RegisterPageComponent implements OnInit {

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
  }

  // naviagtes user to home page
  registerBtnClick() {
      const email = $('#email').val();
      const password = $('#password').val();
      const username = $('#username').val();

     this.apiService.createNewUser(email.toString(), username.toString(), password.toString());
     this.router.navigateByUrl('/login');


  }

}
