/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : highschool

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-05 15:38:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classNum` int(11) NOT NULL AUTO_INCREMENT,
  `grade` int(11) NOT NULL,
  `buildingNum` char(20) NOT NULL,
  `roomNum` char(20) NOT NULL,
  `tID` int(11) DEFAULT NULL,
  `password` char(20) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`classNum`,`grade`),
  KEY `FK_Relationship_2` (`buildingNum`,`roomNum`),
  KEY `FK_Relationship_5` (`tID`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`buildingNum`, `roomNum`) REFERENCES `room` (`buildingNum`, `roomNum`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`tID`) REFERENCES `teacher` (`tID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseID` int(11) NOT NULL AUTO_INCREMENT,
  `buildingNum` char(20) NOT NULL,
  `roomNum` char(20) NOT NULL,
  `periodID` int(11) NOT NULL,
  `title` char(20) NOT NULL,
  `tID` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseID`),
  KEY `FK_teach` (`tID`),
  KEY `FK_teach2` (`buildingNum`,`roomNum`),
  KEY `FK_teach4` (`periodID`),
  KEY `FK_teach5` (`title`),
  CONSTRAINT `FK_teach` FOREIGN KEY (`tID`) REFERENCES `teacher` (`tID`),
  CONSTRAINT `FK_teach2` FOREIGN KEY (`buildingNum`, `roomNum`) REFERENCES `room` (`buildingNum`, `roomNum`),
  CONSTRAINT `FK_teach4` FOREIGN KEY (`periodID`) REFERENCES `period` (`periodID`),
  CONSTRAINT `FK_teach5` FOREIGN KEY (`title`) REFERENCES `subject` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for period
-- ----------------------------
DROP TABLE IF EXISTS `period`;
CREATE TABLE `period` (
  `periodID` int(11) NOT NULL AUTO_INCREMENT,
  `weekday` int(11) DEFAULT NULL,
  `beginTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL,
  PRIMARY KEY (`periodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of period
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `buildingNum` char(20) NOT NULL,
  `roomNum` char(20) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`buildingNum`,`roomNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sID` int(11) NOT NULL AUTO_INCREMENT,
  `studentNum` char(20) DEFAULT NULL,
  `grade` int(11) NOT NULL,
  `classNum` int(11) NOT NULL,
  `password` char(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `enrollDate` date DEFAULT NULL,
  PRIMARY KEY (`sID`),
  KEY `FK_Relationship_10` (`grade`),
  KEY `FK_relationship4` (`classNum`,`grade`),
  CONSTRAINT `FK_relationship4` FOREIGN KEY (`classNum`, `grade`) REFERENCES `class` (`classNum`, `grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `title` char(20) NOT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for take
-- ----------------------------
DROP TABLE IF EXISTS `take`;
CREATE TABLE `take` (
  `sID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  PRIMARY KEY (`sID`,`courseID`),
  KEY `FK_Reference_12` (`courseID`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`sID`) REFERENCES `student` (`sID`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of take
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tID` int(11) NOT NULL AUTO_INCREMENT,
  `employNum` char(20) NOT NULL,
  `buildingNum` char(20) NOT NULL,
  `roomNum` char(20) NOT NULL,
  `password` char(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `authority` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`tID`),
  KEY `FK_Relationship_1` (`buildingNum`,`roomNum`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`buildingNum`, `roomNum`) REFERENCES `room` (`buildingNum`, `roomNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
