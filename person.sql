/*
Navicat MySQL Data Transfer

Source Server         : students
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : person

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2019-09-02 16:38:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `usercode` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`usercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', '刘华', '武汉开发');
INSERT INTO `user` VALUES ('002', '向逢舟', '武汉C1');
INSERT INTO `user` VALUES ('003', '段珞新', '华南开发');
INSERT INTO `user` VALUES ('101', '段珞新', '武汉技术开发部');
INSERT INTO `user` VALUES ('102', '刘华', '武汉技术开发部');
INSERT INTO `user` VALUES ('103', '向逢舟', 'c1研发中心');
INSERT INTO `user` VALUES ('104', '黄渊', '武汉技术开发部');

-- ----------------------------
-- Table structure for u_department
-- ----------------------------
DROP TABLE IF EXISTS `u_department`;
CREATE TABLE `u_department` (
  `usercode` varchar(20) NOT NULL,
  `department` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`usercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_department
-- ----------------------------
INSERT INTO `u_department` VALUES ('001', '武汉开发');
INSERT INTO `u_department` VALUES ('002', '武汉C1');
INSERT INTO `u_department` VALUES ('003', '华南开发');
INSERT INTO `u_department` VALUES ('101', '武汉技术开发部');
INSERT INTO `u_department` VALUES ('102', '武汉技术开发部');
INSERT INTO `u_department` VALUES ('103', 'c1研发中心');
INSERT INTO `u_department` VALUES ('104', '武汉技术开发部');
INSERT INTO `u_department` VALUES ('110', '阿里巴巴董事会');

-- ----------------------------
-- Table structure for u_name
-- ----------------------------
DROP TABLE IF EXISTS `u_name`;
CREATE TABLE `u_name` (
  `usercode` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`usercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_name
-- ----------------------------
INSERT INTO `u_name` VALUES ('001', '刘华');
INSERT INTO `u_name` VALUES ('002', '向逢舟');
INSERT INTO `u_name` VALUES ('003', '段珞新');
INSERT INTO `u_name` VALUES ('101', '段珞新');
INSERT INTO `u_name` VALUES ('102', '刘华');
INSERT INTO `u_name` VALUES ('103', '向逢舟');
INSERT INTO `u_name` VALUES ('104', '黄渊');
INSERT INTO `u_name` VALUES ('110', '马云');
