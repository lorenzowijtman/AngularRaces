import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import {assertNumber} from '@angular/core/src/render3/assert';

@Injectable({
    providedIn: 'root'
})
export class ApiService {
    private baseUrl = 'http://localhost:8080';

    constructor(private http: HttpClient) {
    }

    getUserFromEmail(email: string) {
        // console.log(this.baseUrl + '/userEntities/search/findByEmail?email=' + email);
        return this.http.get(
            this.baseUrl + '/userEntities/search/findByEmail?email=' + email
        );
    }

    createNewUser(email: string, username: string, password: string) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };

        const body = {
            id: Math.random(),
            nickname: username,
            email: email,
            password: password
        };

        this.http
            .post(this.baseUrl + '/userEntities', body, httpOptions)
            .subscribe();
    }

    getUserByNickname(nickname: string) {
        return this.http.get(this.baseUrl + '/users/userNickname/' + nickname);
    }

    setUserIdFromEmail(email: string) {
        const userList = this.http.get(this.baseUrl + '/users/' + email);

        userList.subscribe(data => {
            sessionStorage.setItem('id', JSON.stringify(data));
        });
    }

    createNewgroup(name: string, users: number[]) {
        const groupId = Math.floor(Math.random() * 500);
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        this.http
            .post(
                this.baseUrl +
                '/gamegroups/add/' +
                groupId +
                '/' +
                name +
                '/' +
                sessionStorage.getItem('id'),
                httpOptions
            )
            .subscribe(res => {
                users.forEach(element => {
                    const body = {
                        iduser: element,
                        idgroup: groupId,
                        is_admin: 0
                    };
                    this.http
                        .post(
                            this.baseUrl + '/usergroupEntities',
                            body,
                            httpOptions
                        )
                        .subscribe();
                });
            });
    }

    getGroupsByUserId() {
        return this.http.get(this.baseUrl + '/usergroups/id/' + sessionStorage.getItem('id'));
    }

    getGroupIdsByUserId() {
        return this.http.get(
            this.baseUrl +
            '/gamegroups/' +
            sessionStorage.getItem('id') +
            '/allgroups'
        );
    }

    getRaces() {
        return this.http.get(this.baseUrl + '/races');
    }

    createNewRaces(date: any, location: any, idgroup: any) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        const body = {
            idrace: Math.random(),
            date: date,
            location: location,
            idgroup: idgroup
        };
        this.http
            .post(this.baseUrl + '/raceEntities', body, httpOptions)
            .subscribe();
    }

    getUserByGroupId(groupId: string) {
        return this.http.get(this.baseUrl + '/usergroups/' + groupId + '/allusers');
    }

    getCalanderOnRaceId(idGroup: number) {
        return this.http.get(this.baseUrl + '/races/idGroup/' + idGroup);
    }

    getRaceResult(idRace: number) {
        return this.http.get(this.baseUrl + '/results/' + idRace);
    }

    getAllDrivers() {
        return this.http.get(this.baseUrl + '/drivers');
    }

    get3UpcomingRaces(idGroup: number) {
        return this.http.get(this.baseUrl + '/races/3UpcomingRaces/' + idGroup);
    }

    get3LastRaces(idGroup: number) {
        return this.http.get(this.baseUrl + '/races/3LastRaces/' + idGroup);
    }

    saveResultsFromRace(body) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        console.log(body);
        console.log(this.baseUrl + '/results/new/' + body, httpOptions);
        return this.http.post(this.baseUrl + '/results/new/' + body, httpOptions);
    }

    calculateScores() {
        return this.http.get(this.baseUrl + '/results/finished');
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

    }

