import { Component, OnInit } from "@angular/core";
import {Router} from '@angular/router';

@Component({
  selector: 'app-new-group-page',
  templateUrl: './new-group-page.component.html',
  styleUrls: ['./new-group-page.component.css']
})
export class NewGroupPageComponent implements OnInit {
    constructor(private router: Router) {}

    ngOnInit() {
        if (sessionStorage.getItem('id') == null) {
            this.router.navigateByUrl('/');
        }
    }
}
