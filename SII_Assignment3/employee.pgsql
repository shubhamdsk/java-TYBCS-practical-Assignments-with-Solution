-- create table employee(empid int primary key, empname char(20),empaddress char(30),empcontact bigint ,empage int);

-- create table investor(invno int primary key,invname char(20),invdate varchar(20),invamt int,empid int,foreign key(empid) references employee(empid));

INSERT INTO employee VALUES(1,'Jay','Nagpur',9876787656,34);
INSERT INTO employee VALUES(2,'Aijay','Kolhapur',9876787656,24);
INSERT INTO employee VALUES(3,'Vijay','Rajapur',9876789876,56);
INSERT INTO employee VALUES(4,'Sanjay','Dapur',9876123656,51);
INSERT INTO employee VALUES(5,'Rajesh','Sangamner',9876134656,21);

SELECT * FROM employee;


INSERT INTO investor VALUES(1,'Jay','11/11/2018',34567,1);
INSERT INTO investor VALUES(2,'Aijay','11/12/2019',45643,2);
INSERT INTO investor VALUES(3,'Vijay','11/9/2020',54321,3);
INSERT INTO investor VALUES(4,'Sanjay','11/8/2021',23452,4);
INSERT INTO investor VALUES(5,'Bhavesh','11/3/2022',34532,NULL);

SELECT * FROM investor;

SELECT empname from employee UNION SELECT invname FROM investor;

SELECT empname from employee EXCEPT SELECT invname FROM investor;