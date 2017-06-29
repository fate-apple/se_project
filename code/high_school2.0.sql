/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/28 16:52:40                           */
/*==============================================================*/


drop table if exists class;

drop index teach3_FK on course;

drop table if exists course;

drop table if exists period;

drop index Relationship_3_FK on room;

drop table if exists room;

drop table if exists student;

drop table if exists subject;

drop table if exists take;

drop index Relationship_6_FK on teacher;

drop table if exists teacher;

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   class_id             char(20) not null,
   building_number      char(20) not null,
   room_number          char(20) not null,
   employee_id          char(20) not null,
   password             char(20),
   amount               int,
   primary key (class_id)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   course_id            char(20) not null,
   employee_id          char(20) not null,
   building_number      char(20) not null,
   room_number          char(20) not null,
   period_id            char(20) not null,
   title                char(20) not null,
   primary key (course_id)
);

/*==============================================================*/
/* Index: teach3_FK                                             */
/*==============================================================*/
create index teach3_FK on course
(
   
);

/*==============================================================*/
/* Table: period                                                */
/*==============================================================*/
create table period
(
   period_id            char(20) not null,
   primary key (period_id)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   building_number      char(20) not null,
   room_number          char(20) not null,
   capacity             int,
   primary key (building_number, room_number)
);

/*==============================================================*/
/* Index: Relationship_3_FK                                     */
/*==============================================================*/
create index Relationship_3_FK on room
(
   
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   student_id           char(20) not null,
   class_id             char(20) not null,
   password             char(20),
   name                 char(20),
   gender               bool,
   birthdate            date,
   primary key (student_id)
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
   student_id           char(20) not null,
   course_id            char(20) not null,
   primary key (student_id, course_id)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   employee_id          char(20) not null,
   building_number      char(20) not null,
   room_number          char(20) not null,
   password             char(20),
   name                 char(20),
   gender               bool,
   birthdate            date,
   authority            bool,
   primary key (employee_id)
);

/*==============================================================*/
/* Index: Relationship_6_FK                                     */
/*==============================================================*/
create index Relationship_6_FK on teacher
(
   
);

alter table class add constraint FK_Relationship_2 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

alter table class add constraint FK_Relationship_5 foreign key (employee_id)
      references teacher (employee_id) on delete restrict on update restrict;

alter table course add constraint FK_teach foreign key (employee_id)
      references teacher (employee_id) on delete restrict on update restrict;

alter table course add constraint FK_teach2 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

alter table course add constraint FK_teach4 foreign key (period_id)
      references period (period_id) on delete restrict on update restrict;

alter table course add constraint FK_teach5 foreign key (title)
      references subject (title) on delete restrict on update restrict;

alter table student add constraint FK_Relationship_4 foreign key (class_id)
      references class (class_id) on delete restrict on update restrict;

alter table take add constraint FK_Reference_11 foreign key (student_id)
      references student (student_id) on delete restrict on update restrict;

alter table take add constraint FK_Reference_12 foreign key (course_id)
      references course (course_id) on delete restrict on update restrict;

alter table teacher add constraint FK_Relationship_1 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

