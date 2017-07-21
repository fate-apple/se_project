/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : se_project3

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-18 11:01:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminclass
-- ----------------------------
DROP TABLE IF EXISTS `adminclass`;
CREATE TABLE `adminclass` (
  `grade` int(11) DEFAULT NULL,
  `class_id` bigint(20) NOT NULL,
  `classroom_id` int(11) DEFAULT NULL,
  `class_teacher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `FK5k2bt1a3c0sb2pxfok3q56iq0` (`classroom_id`),
  KEY `FKo7quv4qbpw2vkt0l0kor8e1jh` (`class_teacher_id`),
  CONSTRAINT `FK5k2bt1a3c0sb2pxfok3q56iq0` FOREIGN KEY (`classroom_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FKep1ni5nneh79835pe3ys61w09` FOREIGN KEY (`class_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKo7quv4qbpw2vkt0l0kor8e1jh` FOREIGN KEY (`class_teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminclass
-- ----------------------------
INSERT INTO `adminclass` VALUES ('1', '5', '1', '3');
INSERT INTO `adminclass` VALUES ('2', '8', '2', '4');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `weekday` int(11) DEFAULT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  `period_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `virtual_class_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK7wigmbx3hjc09lxmnx56gr9oy` (`class_id`),
  KEY `FK5efmmmbbf46nls6qnyjirgg5u` (`period_id`),
  KEY `FKj29qwwp1brsjqsn8rle1k3seu` (`room_id`),
  KEY `FKm1expnaas0onmafqpktmjixnx` (`subject_id`),
  KEY `FKsybhlxoejr4j3teomm5u2bx1n` (`teacher_id`),
  KEY `FK646r2u9w769cqfvf28hiaps72` (`virtual_class_id`),
  CONSTRAINT `FK5efmmmbbf46nls6qnyjirgg5u` FOREIGN KEY (`period_id`) REFERENCES `period` (`period_id`),
  CONSTRAINT `FK646r2u9w769cqfvf28hiaps72` FOREIGN KEY (`virtual_class_id`) REFERENCES `virtualclass` (`virtual_class_id`),
  CONSTRAINT `FK7wigmbx3hjc09lxmnx56gr9oy` FOREIGN KEY (`class_id`) REFERENCES `adminclass` (`class_id`),
  CONSTRAINT `FKj29qwwp1brsjqsn8rle1k3seu` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FKm1expnaas0onmafqpktmjixnx` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `FKsybhlxoejr4j3teomm5u2bx1n` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for period
-- ----------------------------
DROP TABLE IF EXISTS `period`;
CREATE TABLE `period` (
  `period_id` int(11) NOT NULL AUTO_INCREMENT,
  `begin_time` time NOT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`period_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of period
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `rolename` varchar(255) DEFAULT NULL,
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
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_name` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `room_num` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '一号楼', '30', '101', '教室');
INSERT INTO `room` VALUES ('2', '二号楼', '40', '402', '教室');
INSERT INTO `room` VALUES ('3', '二号楼', '10', '303', '办公室');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `enroll_date` datetime DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `student_id` bigint(20) NOT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  `virtual_class_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FKjt0jw04a2lfajmi738mlml8no` (`class_id`),
  KEY `FK1s0xy239512vkug7qwb2qsrj0` (`virtual_class_id`),
  CONSTRAINT `FK1s0xy239512vkug7qwb2qsrj0` FOREIGN KEY (`virtual_class_id`) REFERENCES `virtualclass` (`virtual_class_id`),
  CONSTRAINT `FKjt0jw04a2lfajmi738mlml8no` FOREIGN KEY (`class_id`) REFERENCES `adminclass` (`class_id`),
  CONSTRAINT `FKmlyxb44mx4v92t1eq5v655fk3` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
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
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `gender` bit(1) DEFAULT NULL,
  `teacher_id` bigint(20) NOT NULL,
  `office_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `FK6yhnm9pwi34wee7jrbtxcupd1` (`office_id`),
  CONSTRAINT `FK6yhnm9pwi34wee7jrbtxcupd1` FOREIGN KEY (`office_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `FK95g4kwoji012jrf9u2a5rmvxp` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('\0', '3', '3');
INSERT INTO `teacher` VALUES ('', '4', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `last_password_reset_date` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '石金炜', '2017-07-18 09:24:09', '$2a$10$4IA28do7SpIMC4DdNlWKaun9CuBZhn6q1.LOJkLUOxQ8FuszMPVB6', 'test4', '2');
INSERT INTO `user` VALUES ('2', '刘沐', '2017-07-18 09:25:33', '$2a$10$BEzs9qh6/zh/hBAVZlHT0uVP1fgQ5CcKIa/lWFsvaDVSYj./Wac2a', 'test3', '2');
INSERT INTO `user` VALUES ('3', '张老师', '2017-07-18 10:16:13', '$2a$10$PRY98GZNLqGNNXeK/d1hDudlsi7WWoA3mA8EQq2dQ4qhvLOrjk.Ou', '222', '2');
INSERT INTO `user` VALUES ('4', '王老师', '2017-07-18 10:17:05', '$2a$10$vrrFk6MK1Jkxs6td7HuPz.3895UKaBD4L6QdFCwnjOiKOtaO0UYvi', '333', '2');
INSERT INTO `user` VALUES ('5', '高一（1）班', '2017-07-18 10:22:08', '$2a$10$yb8xJNVhBJuTs8BCGKDLyunofZ3.iu3r1htaAdWWP4H0pd1MKnSMa', 'g1c1', '2');
INSERT INTO `user` VALUES ('6', '高一（2）班', '2017-07-18 10:22:30', '$2a$10$rzCkZG.knTTgVu6mZ1vGIOLzbTfvFUEiiPck6/xy4v48QJH4dUbeG', 'g1c2', '2');
INSERT INTO `user` VALUES ('8', '高二（2）班', '2017-07-18 10:22:59', '$2a$10$1LoHv7j1/OdJ9Efp0xUW1uHRlt6Xa/crt0LaIoU0k5JNNnwupFR4e', 'g2c2', '2');

-- ----------------------------
-- Table structure for virtualclass
-- ----------------------------
DROP TABLE IF EXISTS `virtualclass`;
CREATE TABLE `virtualclass` (
  `virtual_class_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`virtual_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of virtualclass
-- ----------------------------
