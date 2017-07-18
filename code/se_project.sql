/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : se_project

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-14 10:54:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` bigint(20) NOT NULL,
  `class_teacher_id` bigint(20) NOT NULL,
  `classroom_id` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `FK_Relationship_5` (`class_teacher_id`),
  KEY `FK_classroom` (`classroom_id`),
  CONSTRAINT `FK_class` FOREIGN KEY (`class_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_classroom` FOREIGN KEY (`classroom_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(20) NOT NULL,
  `teacher_id` bigint(20) NOT NULL,
  `period_id` int(20) NOT NULL,
  `subject_id` int(20) NOT NULL,
  `class_id` bigint(11) DEFAULT NULL,
  `virtual_class_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `weekday` int(11) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK_teach` (`teacher_id`),
  KEY `FK_teach4` (`period_id`),
  KEY `FK_teach5` (`subject_id`),
  KEY `FKvc` (`virtual_class_id`),
  KEY `FK_room` (`room_id`),
  CONSTRAINT `FK1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `FK2` FOREIGN KEY (`period_id`) REFERENCES `period` (`period_id`),
  CONSTRAINT `FK_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FK_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `FKvc` FOREIGN KEY (`virtual_class_id`) REFERENCES `virtualclass` (`virtual_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for period
-- ----------------------------
DROP TABLE IF EXISTS `period`;
CREATE TABLE `period` (
  `period_id` int(20) NOT NULL,
  `begin_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`period_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of period
-- ----------------------------
INSERT INTO `period` VALUES ('1', '08:00:00', '08:40:00');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `rolename` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `building_name` varchar(20) DEFAULT NULL,
  `room_num` varchar(20) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` bigint(11) NOT NULL,
  `class_id` bigint(11) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `enroll_date` date DEFAULT NULL,
  `virtual_class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_Relationship_4` (`class_id`),
  KEY `FK_vc` (`virtual_class_id`),
  CONSTRAINT `FK_class1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `FK_student` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_vc` FOREIGN KEY (`virtual_class_id`) REFERENCES `virtualclass` (`virtual_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for take
-- ----------------------------
DROP TABLE IF EXISTS `take`;
CREATE TABLE `take` (
  `student_id` bigint(20) NOT NULL,
  `course_id` int(20) NOT NULL,
  KEY `FK_Reference_11` (`student_id`),
  KEY `FK333` (`course_id`),
  CONSTRAINT `FK233` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `FK333` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of take
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` bigint(20) NOT NULL,
  `office_id` int(11) DEFAULT NULL,
  `authority` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `FK_office` (`office_id`),
  CONSTRAINT `FK_office` FOREIGN KEY (`office_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FK_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL,
  `password` char(63) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `last_password_reset_date` date DEFAULT NULL,
  `fullname` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test4', '$2a$10$0CYI90cpU/OjvoAQRFDuxu6qgyq..cDBd1v64p6qEtVegST5LZIhe', '2', '2017-07-12', 'test4');
INSERT INTO `user` VALUES ('2', '', '$2a$10$moWvU8IYnFGaicX6P16wW.xFDsV1PjzmtrD5ndVQnnEff9ZN1c9/a', '2', '2017-07-14', 'laosiji');
INSERT INTO `user` VALUES ('3', 'sjw', '$2a$10$/Eb3LIbILFpgXmBAPi1pOuQQYLePKUW2HZP.tvh0NS.C2L2AGNome', '2', '2017-07-14', 'laoshiji');

-- ----------------------------
-- Table structure for virtualclass
-- ----------------------------
DROP TABLE IF EXISTS `virtualclass`;
CREATE TABLE `virtualclass` (
  `virtual_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`virtual_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of virtualclass
-- ----------------------------
