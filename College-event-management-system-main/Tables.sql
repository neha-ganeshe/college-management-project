--CREATING DATABASE

--1) EVENT TABLE:
create table event(event_id int primary key, place varchar(10) , name varchar(10) , DateOfEvent date)
select *from event
insert into event values(0001,'S block','Casino',to_date('08/12/2019','dd/mm/yyyy'));
insert into event values(0002,'M block','JAM',to_date('10/12/2019','dd/mm/yyyy'));
insert into event values(0003,'D block','Reverb',to_date('15/12/2019','dd/mm/yyyy'));

--2) WINNER TABLE:
create table winner(win_id int primary key,FN varchar(10),LN varchar(10),PrAmt int,Rank int,event_id int references event(event_id));
select *from winner
insert into winner values(2098,'neha','ganeshe',3500,002,0001);
insert into winner values(2067,'shanaya','singhaniya',5000,001,0001);
insert into winner values(2090,'shanaya','singhaniya',2000,003,0003);
insert into winner values(2030,'shourya','gupta',5000,001,0002);

--3) CREW TABLE:
create table crew(crew_id int primary key,FN varchar(10),LN varchar(10),Email varchar(30),Dept varchar(15),city varchar(10),street varchar (10),state varchar(10),event_id int references event(event_id))
select *from crew
insert into crew values(138,'shivam','giri','shivamgiri@gmail.com','publicity','mumbai','hillroad','maha',0002);
insert into crew values(1,'arpita','waghule','arpitaw90@gmail.com','publicity','thane','yk road','maha',0002);
insert into crew values(209,'saamiya','newrekar','saamiya.newrekargmail.com','sports','mumbai','carter','maha',0001);
insert into crew values(789,'raza','khan','razakhan@gmail.com','cultural','mumbai','hillroad','maha',0003);

--4) SPONSERS TABLE:
create table sponsers(spons_id int primary key,tolamt int,company varchar(10),street varchar(10),city varchar(10),state varchar(20));
select *from sponsers
insert into sponsers values(021,500000,'dominos','mirard','kharghar','maha');
insert into sponsers values(025,200000,'mcd','nagpada','mumbai','maha');
insert into sponsers values(029,350000,'zomato','byculla','mumbai','maha');
insert into sponsers values(031,150000,'fab','sector2','thane','maha');
insert into sponsers values(010,167000,'spice','sector9','borivali','maha')

--5) PARTICIPANTS TABLE:
create table participant(part_id int ,FN varchar(10) ,LN varchar(15) ,CollegeName varchar(20) ,email varchar(40),DOB date ,street varchar(15) ,city varchar(10) ,state varchar(20) , primary key (part_id))
select  * from participant
insert into participant values( 0001, 'Neha' , 'Ganeshe' , 'VIT' , 'nehaganeshe4@gmail.com' , to_date('04/05/2000','dd/mm/yyyy')  , 'sector 19' , 'thane' , 'maharastra');
insert into participant values( 0002, 'Nihal' , 'jain' , 'VIT' , 'nihaljain10@gmail.com' , to_date('04/02/2000','dd/mm/yyyy')   , 'sector 7' , 'thane' , 'maharastra');
insert into participant values( 0003, 'Shourya' , 'Gupta' , 'DJ Sanghvi' , 'shouryag78@gmail.com' , to_date('19/08/1998','dd/mm/yyyy')   , 'i.r road' , 'mumbai' , 'maharastra');
insert into participant values( 0004, 'Shanaya' , 'singhaniya' , 'COEP' , 'shanaya225@gmail.com' , to_date('22/05/2000','dd/mm/yyyy')  , 'sk road' , 'pune' , 'maharastra');
insert into participant values( 0005, 'Kushagra' , 'soni' , 'SPIT' , 'nehaganeshe4@gmail.com' , to_date('25/11/1999','dd/mm/yyyy')   , 'sangam nagar' , 'mumbai' , 'maharastra');

--6) EVENTPART TABLE:
create table eventpart(event_id int references event(event_id),part_id int references participant(part_id));
select *from eventpart
 insert into eventpart values(0001,0001);
 insert into eventpart values(0001,0004);
 insert into eventpart values(0003,0004);
 insert into eventpart values(0002,0003);
 insert into eventpart values(0002,0005);
 insert into eventpart values(0001,0002);
 insert into eventpart values(0002,0001);
  
--7) EVENTSPONS TABLE:
  create table eventspons(spons_id int references sponsers(spons_id),event_id int references event(event_id))
  select * from eventspons
  insert into eventspons values(025,0003);
  insert into eventspons values(029,0003);
  insert into eventspons values(025,0001);
  insert into eventspons values(029,0002);

--8) PARTSPONS TABLE:
  create table partspons(part_id int references participant(part_id),spons_id int references sponsers(spons_id),vouch_id int,amt int);
  select * from partspons
  insert into partspons values(0001,025,832,250);
  insert into partspons values(0001,029,978,150);
  insert into partspons values(0002,025,032,250);
  insert into partspons values(0004,029,832,350);
  insert into partspons values(0003,025,542,250);
