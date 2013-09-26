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

insert into SUBJECT
values
(1, 'C'),
(2, 'C++'),
(3, 'C#'),
(4, 'CFlat');

insert into STUDENT
values
(1, 'Ole Jensen', 1, 2, 3, 4);