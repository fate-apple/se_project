/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/30 14:43:08                           */
/*==============================================================*/


drop table if exists class;

drop table if exists course;

drop table if exists period;

drop table if exists room;

drop table if exists student;

drop table if exists subject;

drop table if exists take;

drop table if exists teacher;

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   class_ID             int(11) not null AUTO_INCREMENT,
   class_name           char(20),
   building_number      char(20) not null,
   room_number          char(20) not null,
   tID                  int(11),
   password             char(20),
   amount               int(11),
   primary key (class_ID)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   course_ID            int(11) not null AUTO_INCREMENT,
   building_number      char(20) not null,
   room_number          char(20) not null,
   period_ID            int(11) not null,
   title                char(20) not null,
   tID                  int(11),
   primary key (course_ID)
);



/*==============================================================*/
/* Table: period                                                */
/*==============================================================*/
create table period
(
   period_ID            int(11) not null AUTO_INCREMENT,
   week_day             integer,
   begin_time           time,
   end_time             time,
   primary key (period_ID)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   building_number      char(20) not null,
   room_number          char(20) not null,
   capacity             int(11),
   primary key (building_number, room_number)
);




/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   sID                  int(11) not null AUTO_INCREMENT,
   stu_number           char(20),
   class_ID             int(11) not null,
   password             char(20),
   name                 char(20),
   gender               bool,
   birthdate            date,
   primary key (sID)
);

/*==============================================================*/
/* Table: subject                                               */
/*==============================================================*/
create table subject
(
   title                char(20) not null,
   primary key (title)
);

/*==============================================================*/
/* Table: take                                                  */
/*==============================================================*/
create table take
(
   sID                  int(11) not null,
   course_ID            int(11) not null,
   primary key (sID, course_ID)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   tID                  int(11) not null AUTO_INCREMENT,
   employ_number        char(20) not null,
   building_number      char(20) not null,
   room_number          char(20) not null,
   password             char(20),
   name                 char(20),
   gender               bool,
   authority            bool,
   primary key (tID)
);



alter table class add constraint FK_Relationship_2 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

alter table class add constraint FK_Relationship_5 foreign key (tID)
      references teacher (tID) on delete restrict on update restrict;

alter table course add constraint FK_teach foreign key (tID)
      references teacher (tID) on delete restrict on update restrict;

alter table course add constraint FK_teach2 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

alter table course add constraint FK_teach4 foreign key (period_ID)
      references period (period_ID) on delete restrict on update restrict;

alter table course add constraint FK_teach5 foreign key (title)
      references subject (title) on delete restrict on update restrict;

alter table student add constraint FK_Relationship_4 foreign key (class_ID)
      references class (class_ID) on delete restrict on update restrict;

alter table take add constraint FK_Reference_11 foreign key (sID)
      references student (sID) on delete restrict on update restrict;

alter table take add constraint FK_Reference_12 foreign key (course_ID)
      references course (course_ID) on delete restrict on update restrict;

alter table teacher add constraint FK_Relationship_1 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

