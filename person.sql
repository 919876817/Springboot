/*
Navicat MySQL Data Transfer

Source Server         : students
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : person

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2019-08-28 17:33:57
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
INSERT INTO `user` VALUES ('101', '段珞新', '武汉技术开发部');
INSERT INTO `user` VALUES ('102', '刘华', '武汉技术开发部');
INSERT INTO `user` VALUES ('103', '向逢舟', 'c1研发中心');
INSERT INTO `user` VALUES ('104', '黄渊', '武汉技术开发部');
