/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/28 11:45:56                           */
/*==============================================================*/


drop table if exists class;

drop table if exists dean;

drop table if exists period;

drop table if exists room;

drop table if exists student;

drop table if exists subject;

drop table if exists teach;

drop table if exists teacher;

drop table if exists user;

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   ID                   int not null,
   building_number      int not null,
   room_number          int not null,
   tea_ID               int not null,
   password             char(20),
   class_number         char(20),
   amount               int,
   primary key (ID)
);

/*==============================================================*/
/* Table: dean                                                  */
/*==============================================================*/
create table dean
(
   ID                   int not null,
   password             char(20),
   name                 char(20),
   gender               bool,
   birthdate            date,
   primary key (ID)
);

/*==============================================================*/
/* Table: period                                                */
/*==============================================================*/
create table period
(
   period_id            int not null,
   primary key (period_id)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   building_number      int not null,
   room_number          int not null,
   ID                   int,
   capacity             int,
   primary key (building_number, room_number)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   ID                   int not null,
   cla_ID               int not null,
   password             char(20),
   name                 char(20),
   gender               bool,
   birthdate            date,
   primary key (ID)
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
/* Table: teach                                                 */
/*==============================================================*/
create table teach
(
   tea_ID               int not null,
   building_number      int not null,
   room_number          int not null,
   ID                   int not null,
   period_id            int not null,
   title                char(20) not null,
   primary key (tea_ID, building_number, room_number, ID, period_id, title)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   ID                   int not null,
   building_number      int not null,
   room_number          int not null,
   cla_ID               int,
   password             char(20),
   name                 char(20),
   gender               bool,
   birthdate            date,
   primary key (ID)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   ID                   int not null,
   password             char(20),
   primary key (ID)
);

alter table class add constraint FK_Inheritance_2 foreign key (ID)
      references user (ID) on delete restrict on update restrict;

alter table class add constraint FK_Relationship_2 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

alter table class add constraint FK_Relationship_5 foreign key (tea_ID)
      references teacher (ID) on delete restrict on update restrict;

alter table dean add constraint FK_Inheritance_4 foreign key (ID)
      references user (ID) on delete restrict on update restrict;

alter table room add constraint FK_Relationship_3 foreign key (ID)
      references class (ID) on delete restrict on update restrict;

alter table student add constraint FK_Inheritance_3 foreign key (ID)
      references user (ID) on delete restrict on update restrict;

alter table student add constraint FK_Relationship_4 foreign key (cla_ID)
      references class (ID) on delete restrict on update restrict;

alter table teach add constraint FK_teach foreign key (tea_ID)
      references teacher (ID) on delete restrict on update restrict;

alter table teach add constraint FK_teach2 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

alter table teach add constraint FK_teach3 foreign key (ID)
      references student (ID) on delete restrict on update restrict;

alter table teach add constraint FK_teach4 foreign key (period_id)
      references period (period_id) on delete restrict on update restrict;

alter table teach add constraint FK_teach5 foreign key (title)
      references subject (title) on delete restrict on update restrict;

alter table teacher add constraint FK_Inheritance_1 foreign key (ID)
      references user (ID) on delete restrict on update restrict;

alter table teacher add constraint FK_Relationship_1 foreign key (building_number, room_number)
      references room (building_number, room_number) on delete restrict on update restrict;

alter table teacher add constraint FK_Relationship_6 foreign key (cla_ID)
      references class (ID) on delete restrict on update restrict;

