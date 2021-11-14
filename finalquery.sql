create database auprojectdatabase1;

use auprojectdatabase1;

create table userinformation (id int primary key,name varchar(45), email varchar(45),password varchar(45),location varchar(20) );

create table topic(topicid int primary key auto_increment,topicname varchar(45), timestamp date,userid int , foreign key(userid) references userinformation(id));

create table question(id int primary key auto_increment,answeredflag boolean, description longtext,timestamp date,userid int , topicid int,foreign key(userid) references userinformation(id),foreign key(topicid) references topic(topicid));


create table answer(id int primary key auto_increment, description longtext,userid int, questionid int, timestamp date, isarchive boolean default false,foreign key(userid) references userinformation(id),foreign key(questionid) references question(id));



create table email(id int primary key auto_increment, remail varchar(45), timestamp date, issuccess varchar(8), description longtext, subject varchar(45),userid int,foreign key(userid) references userinformation(id));

create table notification(id int primary key auto_increment,description longtext, timestamp date,userid int, visited boolean, foreign key(userid) references userinformation(id));


create table usertopic (id int primary key auto_increment, topicname varchar(30), topicid int , userid int,foreign key(userid) references userinformation(id),foreign key(topicid) references topic(topicid));

create table keyword(id int primary key auto_increment,name varchar(45), userid int,timestamp date,foreign key(userid) references userinformation(id));

create table keywordquestion (id int primary key auto_increment, keywordid int,questionid int,foreign key(keywordid) references keyword(id),foreign key(questionid) references question(id));


delimiter //
create trigger inserttopic after insert  on topic for each row
    begin
    insert into usertopic (userid,topicid,topicname) values(NEW.userid, NEW.topicid,NEW.topicname);
    end //
delimiter ;
