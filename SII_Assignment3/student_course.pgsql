create table student1(s_id int ,s_name char(30) primary key,s_class char(20));
insert into student1 values(1,'abc','tybcs');
insert into student1 values(2,'xyz','sybcs');
insert into student1 values(3,'pqr','fybcs');
insert into student1 values(4,'lmn','tybcs');
insert into student1 values(56,'Prasad','TyBcs');
insert into student1 values(77,'Swayam','TYBCS');

select * from student1;

create table course(c_id int ,c_name char(30) primary key, c_inst char(30));
insert into course values(1,'java','Gite Madam');
insert into course values(2,'ruby','Kawde sir');
insert into course values(3,'python','Thorat Madam');
insert into course values(4,'c','Sharma Madam');
insert into course values(5,'php','Kawde sir');
insert into course values(6,'mysql','Vikhe Madam');

select * from course;

create table SC(s_name char(30),foreign key(s_name) references student1(s_name),c_name char(30),foreign key(c_name) references course(c_name));

insert into SC values('abc','java');
insert into SC values('xyz','java');
insert into SC values('pqr','php');
insert into SC values('lmn','c');
insert into SC values('Swayam','ruby');
insert into SC values('Prasad','php');
insert into SC values('Swayam','c');
insert into SC values('Prasad','ruby');

SELECT * from SC;

select s_name from SC where c_name = 'c';