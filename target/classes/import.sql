-- wypelnianie tabeli section
insert into section (section_name, email, home_phone_number, mobile_phone_number) values('Outsorcing', 'outsorc@ml.pl', '111 222 333', '111 222 333');
insert into section (section_name, email, home_phone_number, mobile_phone_number) values('Automotive', 'utomotiv@ml.pl', '123 213 312', '123 213 312');
insert into section (section_name, email, home_phone_number, mobile_phone_number) values('Ship', 'ship@ml.pl', '555 666 777', '555 666 777');
insert into section (section_name, email, home_phone_number, mobile_phone_number) values('XPL', 'xpl@ml.pl', '141 414 444', '141 414 444');

-- wypelnianie tabeli worker
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Artur', 'Mach', '12345678901','2006-01-01',1,'arturM@pr.pl', '999 000 999', '+48 333 444 444');
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Kamil', 'Grabowski', '23456789012','2006-01-02',1, 'kamilG@pr.pl', '495 735 406', '+48 373 474 050');
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Jarek', 'Błazków', '34567890123','2006-01-03',2, 'jarekB@pe.pl', '333 888 333', '035 735 283');
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Daniel', 'Olesiejuk', '45678901234','2006-01-04', 2, 'danielO@pe.pl', '949 237 040', '394 956 365');
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Sebastian', 'Tomczyk', '56789012345','2006-01-05',3, 'sebastianT@wp.pl', '784 111 285', '777 777 777');
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Mikołaj', 'Roszak', '67890123456','2006-01-06',3, 'mikolajR@pe.pl', '939 203 838', '048 039 332');
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Tomasz', 'Czypionka', '78901234567','2006-01-07',4, 'tomaszC@wo.pl', '394 937 930', '058 828 382');
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Kajetan', 'Kiedel', '89012345678','1916-02-01',4, 'kajetanK@dk.pl', '837 338 823','293 393 292' );
insert into worker (name, surname, pesel, birth_date, section_id, email, home_phone_number, mobile_phone_number) values('Sebastiano', 'Amigo', '89012945678','1966-02-01',4, 'STomciko@dk.pl', '837 338 823','293 393 292' );


insert into project (name, type, salary) values ('projektA', 'inner',23);
insert into project (name, type, salary) values ('projektB', 'outer',243);
insert into project (name, type, salary) values ('projektC', 'outer',187);

-- wypelnianie tabeli workers_in_projetcts
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-01', '2016-08-01', 1, 1, 'PL');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-01', '2016-08-01', 2, 1, 'TCD');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-01', '2016-08-01', 3, 1, 'FCD');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-02', '2016-08-01', 4, 1, 'DEV');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-02', '2016-08-01', 5, 1, 'DEV');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-02', '2016-08-01', 6, 1, 'DEV');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-01', '2016-08-01', 7, 1, 'DEV');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-01', '2016-08-01', 8, 1, 'DEV');


insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('2015-01-01', '2018-01-01', 1, 2, 'PL');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('1996-01-01', '2018-01-01', 2, 2, 'TCD');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('1996-01-01', '2018-01-01', 3, 2, 'FCD');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('1996-01-01', '2018-01-01', 4, 2, 'DEV');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('1996-01-01', '2018-01-01', 5, 2, 'DEV');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('1996-01-01', '2018-01-01', 6, 2, 'DEV');
insert into workers2projects (date_since, date_to, worker_id, project_id, function_type) values ('1996-01-01', '2018-01-01', 7, 2, 'DEV');
insert into workers2projects (date_since, worker_id, project_id, function_type) values ('2015-01-01', 8, 2, 'DEV');

