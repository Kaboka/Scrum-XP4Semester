drop table STUDENT;
drop table SUBJECT;

create table SUBJECT(
ID int primary key,
NAME varchar(30),
POOL int
);

create table STUDENT(
ID int primary key, 
FULL_NAME varchar(50),
FRONTER varchar(8),
FIRST_PRIO_1 int references SUBJECT(ID),
FIRST_PRIO_2 int references SUBJECT(ID),
SECOND_PRIO_1 int references SUBJECT(ID),
SECOND_PRIO_2 int references SUBJECT(ID)
);

insert into SUBJECT values (1, 'C#', 0);
insert into SUBJECT values (2, 'Algorithms', 0);
insert into SUBJECT values (3, 'Apps and innovation', 0);
insert into SUBJECT values (4, 'HCI', 0);
insert into SUBJECT values (5, 'Globalization', 0);
insert into SUBJECT values (6, 'Databases', 0);
insert into SUBJECT values (7, 'Test', 0);
insert into SUBJECT values (8, 'Project management', 0);

insert into STUDENT values (1, 'Bjarke Carlsen','cph-bc01', 1,4,3,2);
insert into STUDENT values (2, 'Martin Olgenkjær','cph-mo02', 8,4,6,7);
insert into STUDENT values (3, 'Henrik Stavnem','cph-hs03', 3,5,1,6);
insert into STUDENT values (4, 'Nicklas Thomsen','cph-nt04', 2,8,4,7);
