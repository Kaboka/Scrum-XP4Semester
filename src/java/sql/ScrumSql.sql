drop table STUDENT;
drop table SUBJECT;

create table SUBJECT(
ID int primary key,
NAME varchar(30)
);

create table STUDENT(
ID int primary key, 
FULL_NAME varchar(50),
FIRST_PRIO_1 int references SUBJECT(ID),
FIRST_PRIO_2 int references SUBJECT(ID),
SECOND_PRIO_1 int references SUBJECT(ID),
SECOND_PRIO_2 int references SUBJECT(ID)
);

insert into SUBJECT values (1, 'C#');
insert into SUBJECT values (2, 'Algorithms');
insert into SUBJECT values (3, 'Apps and innovation');
insert into SUBJECT values (4, 'HCI');
insert into SUBJECT values (5, 'Globalization');
insert into SUBJECT values (6, 'Databases');
insert into SUBJECT values (7, 'Test');
insert into SUBJECT values (8, 'Project management');

insert into STUDENT values (1, 'Bjarke Carlsen', 1,4,3,2);
insert into STUDENT values (2, 'Martin Olgenkjær', 8,4,6,7);
insert into STUDENT values (3, 'Henrik Stavnem', 3,5,1,6);
insert into STUDENT values (4, 'Nicklas Thomsen', 2,8,4,7);