import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DataService {
    private messageSource = new BehaviorSubject('default message');
    currentMessage = this.messageSource.asObservable();
    private message: any;

    constructor() { }

    changeMessage(message: string) {
        this.messageSource.next(message);
    }

    setMessage(message: any) {
        this.message = message;
    }

    getMessage() {
        return this.message;
    }
}
