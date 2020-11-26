import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { HttpHeaders } from "@angular/common/http";

@Injectable({
    providedIn: "root"
})
export class ApiService {
    baseUrl = "http://localhost:8080";

    constructor(private http: HttpClient) {}

    getUserFromEmail(email: string) {
        // console.log(this.baseUrl + '/userEntities/search/findByEmail?email=' + email);
        return this.http.get(
            this.baseUrl + "/userEntities/search/findByEmail?email=" + email
        );
    }

    createNewUser(email: string, username: string, password: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                "Content-Type": "application/json"
            })
        };

        const body = {
            id: Math.random(),
            nickname: username,
            email: email,
            password: password
        };

        this.http
            .post(this.baseUrl + "/userEntities", body, httpOptions)
            .subscribe();
    }

    getUserByNickname(nickname: string) {
        return this.http.get(this.baseUrl + "/users/userNickname/" + nickname);
    }

    setUserIdFromEmail(email: string) {
        let userList = this.http.get(this.baseUrl + "/users/" + email);
        userList.subscribe(data => {
            console.log(data);
            sessionStorage.setItem("id", JSON.stringify(data));
        });
    }

    createNewgroup(name: string, users: number[]) {
        const groupId = Math.floor(Math.random() * 500);
        const httpOptions = {
            headers: new HttpHeaders({
                "Content-Type": "application/json"
            })
        };
        this.http
            .post(
                this.baseUrl +
                    "/gamegroups/add/" +
                    groupId +
                    "/" +
                    name +
                    "/" +
                    sessionStorage.getItem("id"),
                httpOptions
            )
            .subscribe(res => {
                users.forEach(element => {
                    let body = {
                        iduser: element,
                        idgroup: groupId,
                        is_admin: 0
                    };
                    this.http
                        .post(
                            this.baseUrl + "/usergroupEntities",
                            body,
                            httpOptions
                        )
                        .subscribe();
                });
            });
    }

    getGroupsByUserId() {
        return this.http.get(
            this.baseUrl + "/usergroups/id/" + sessionStorage.getItem("id")
        );
    }

    getGroupIdsByUserId() {
        return this.http.get(
            this.baseUrl +
                "/gamegroups/" +
                sessionStorage.getItem("id") +
                "/allgroups"
        );
    }

    getRaces() {
        return this.http.get(this.baseUrl + "/races");
    }

    createNewRaces(date: any, location: any, time: any, id: number) {
        const httpOptions = {
            headers: new HttpHeaders({
                "Content-Type": "application/json"
            })
        };
        const body = {
            idrace: id,
            date: date,
            location: location,
            time: time,
            idgroup: sessionStorage.getItem("id")
        };
        this.http
            .post(this.baseUrl + "/raceEntities", body, httpOptions)
            .subscribe();
    }

    getAllDrivers() {
        return this.http.get(this.baseUrl + "/drivers");
    }

    createDriversTeam(selectedDrivers: any[], positionMV: number, name: String, budget: number) {
        const httpOptions = {
            headers: new HttpHeaders({
                "Content-Type": "application/json"
            })
        };

        let driverOne = selectedDrivers[0];
        let driverTwo = selectedDrivers[1];
        let driverThree = selectedDrivers[2];
        let driverFour = selectedDrivers[3];
        let driverFive = selectedDrivers[4];
        

        this.http
            .post(this.baseUrl + "/teamselections/new/1/newTeam/"+"/"+budget+"/"+ sessionStorage.getItem("id")+"/"+positionMV+"/"+driverOne+"/"+driverTwo+"/"+driverThree+"/"+driverFour+"/"+driverFive, httpOptions)
            .subscribe();
    }

    getUsersByGroupName() {
        return this.http.get(this.baseUrl+ "/users/userGroup/" + sessionStorage.getItem("selectedGroup"));
    }

    }

