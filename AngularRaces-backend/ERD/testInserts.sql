use persistencepractise;

delete from teamSelectiondriver;
delete from teamSelection;
delete from points;
delete from usergroup;
delete from user;
delete from game_group;
delete from resultdriver;
delete from driver;
delete from result;
delete from race;

insert into user(iduser, nickname, password, email) values(1,"lorenzo", "admin", "some_email");
insert into user(iduser, nickname, password, email) values(2, "bas", "admin", "some_email");

insert into game_group(idgroup, name, admin_id) values(1, "first", 1);

insert into usergroup(iduser, idgroup) values(1, 1);
insert into usergroup(iduser, idgroup) values(2, 1);

insert into points(game_points, iduser, idgroup) values(5, 1, 1);

insert into driver(firstname, lastname, cost) values("max", "verstappen", 5000);
insert into driver(firstname, lastname, cost) values("lewis", "hamilton", 6000);
insert into driver(firstname, lastname, cost) values("kimmi", "raikonen", 7000);

insert into race(idrace, date, location) values(1, '2019-07-01', "monaco");
insert into race(idrace, date, location) values(2, '2019-08-05', "libanon");

insert into result(idresult, idrace) values(1,1);

insert into resultdriver(idresult, lastname, position, finished) values (1, "verstappen", 1, true);
insert into resultdriver(idresult, lastname, position, finished) values (1, "hamilton", 2, true);
insert into resultdriver(idresult, lastname, position, finished) values (1, "raikonen", 3, false);

insert into teamSelection(idteamSelection, name, budget, iduser)values(1, "first team", 20000, 1);
insert into teamSelection(idteamSelection, name, budget, iduser)values(2, "second team", 20000, 2);
insert into teamSelection(idteamSelection, name, budget, iduser)values(3, "thid team", 20000, 2);

insert into teamSelectiondriver(idteamSelection, iduser, lastname) values(1, 1, "verstappen");
insert into teamSelectiondriver(idteamSelection, iduser, lastname) values(1, 1, "hamilton");
insert into teamSelectiondriver(idteamSelection, iduser, lastname) values(2, 2, "verstappen");
insert into teamSelectiondriver(idteamSelection, iduser, lastname) values(2, 2, "raikonen");
insert into teamSelectiondriver(idteamSelection, iduser, lastname) values(3, 2, "hamilton");
insert into teamSelectiondriver(idteamSelection, iduser, lastname) values(3, 2, "raikonen");

