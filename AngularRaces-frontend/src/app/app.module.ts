import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginPageComponent} from './pages/login-page/login-page.component';
import {HomePageComponent} from './pages/home-page/home-page.component';
import {RegisterPageComponent} from './pages/register-page/register-page.component';
import {MyTeamPageComponent} from './pages/my-team-page/my-team-page.component';
import {MyGroupsPageComponent} from './pages/my-groups-page/my-groups-page.component';
import {GroupInfoPageComponent} from './pages/group-info-page/group-info-page.component';
import {GroupSettingsPageComponent} from './pages/group-settings-page/group-settings-page.component';
import {CalendarUploadPageComponent} from './pages/calendar-upload-page/calendar-upload-page.component';
import {ResultsUploadPageComponent} from './pages/results-upload-page/results-upload-page.component';
import {ResultsPageComponent} from './pages/results-page/results-page.component';
import {CalendarPageComponent} from './pages/calendar-page/calendar-page.component';
import {NewGroupPageComponent} from './pages/new-group-page/new-group-page.component';
import {GroupSettingsComponent} from './components/group-settings/group-settings.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {HttpClientModule} from '@angular/common/http';
import {EditResultsPageComponent} from './pages/edit-results-page/edit-results-page.component';

const appRoutes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginPageComponent},
    {path: 'home', component: HomePageComponent},
    {path: 'mygroups', component: MyGroupsPageComponent},
    {path: 'groupinfo', component: GroupInfoPageComponent},
    {path: 'groupsettings', component: GroupSettingsPageComponent},
    {path: 'myteam', component: MyTeamPageComponent},
    {path: 'calendarupload', component: CalendarUploadPageComponent},
    {path: 'resultsupload', component: ResultsUploadPageComponent},
    {path: 'results', component: ResultsPageComponent},
    {path: 'calendar', component: CalendarPageComponent},
    {path: 'newgroup', component: NewGroupPageComponent},
    {path: 'register', component: RegisterPageComponent},
    {path: 'calendar/editrace', component: EditResultsPageComponent}
];

@NgModule({
    declarations: [
        AppComponent,
        LoginPageComponent,
        HomePageComponent,
        RegisterPageComponent,
        MyTeamPageComponent,
        MyGroupsPageComponent,
        GroupInfoPageComponent,
        GroupSettingsPageComponent,
        CalendarUploadPageComponent,
        ResultsUploadPageComponent,
        ResultsPageComponent,
        CalendarPageComponent,
        NewGroupPageComponent,
        GroupSettingsComponent,
        HeaderComponent,
        FooterComponent,
        EditResultsPageComponent
    ],

    imports: [BrowserModule, RouterModule.forRoot(appRoutes), HttpClientModule],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
