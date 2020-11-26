use persistencepractise;

-- select user id
select iduser from user where nickname = "lorenzo";

-- select group id

-- select group
select name from game_group where idgroup=1;

-- select all users in  group
select nickname from user u inner join usergroup g on u.iduser = g.iduser;

-- select the admin from a group
select nickname from user inner join game_group on admin_id=iduser;

-- select a user's points in a group
select game_points from points inner join user u on u.iduser = 1;

-- select all drivers
select firstname, lastname from driver;

-- select race
select location, date from race;

-- select results from specific race
select lastname, position, finished from resultdriver left join race on location= "monaco" order by position asc;

-- select user's team selection
select idteamSelection from teamSelection where iduser = 1;

-- select all drivers in specific team
select lastname from teamSelectiondriver where idteamSelection=1 and iduser = 1;

