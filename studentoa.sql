/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : studentoa

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-10-11 16:46:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `friend_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('01', '01', '01', 'a', '2018-09-27 10:48:19', '2018-09-27 10:48:29');
INSERT INTO `friend` VALUES ('02', '01', '02', 'b', '2018-09-27 10:48:46', '2018-09-27 10:48:54');
INSERT INTO `friend` VALUES ('03', '01', '03', '007', '2018-09-27 10:49:05', '2018-09-28 08:54:50');
INSERT INTO `friend` VALUES ('04', '01', '04', 'd', '2018-09-27 10:49:34', '2018-09-27 10:49:44');
INSERT INTO `friend` VALUES ('05', '01', '05', 'e', '2018-09-27 10:50:06', '2018-09-27 10:50:10');
INSERT INTO `friend` VALUES ('06', '01', '06', 'f', '2018-09-27 10:50:43', '2018-09-27 10:50:46');
INSERT INTO `friend` VALUES ('07', '01', '07', 'g', '2018-09-27 10:51:05', '2018-09-27 10:51:08');
INSERT INTO `friend` VALUES ('08', '01', '08', 'h', '2018-09-27 10:51:24', '2018-09-27 10:51:27');
INSERT INTO `friend` VALUES ('09', '01', '09', 'i', '2018-09-27 10:51:41', '2018-09-27 10:51:44');
INSERT INTO `friend` VALUES ('10', '01', '10', 'j', '2018-09-27 10:51:57', '2018-09-27 10:52:01');
INSERT INTO `friend` VALUES ('11', '02', '01', 'k', '2018-09-27 10:52:20', '2018-09-27 10:52:24');
INSERT INTO `friend` VALUES ('12', '02', '02', 'l', '2018-09-27 10:52:36', '2018-09-27 10:52:38');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `username` varchar(64) NOT NULL,
  `sex` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(11) NOT NULL COMMENT '激活状态',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1537427498359197048', 'ldx', '男', '44', '359203', '10086', 'Ldixing@163.com', '0', '2018-09-20 15:11:38', '2018-09-21 16:19:24');
INSERT INTO `user` VALUES ('1537947695034180082', 'ych', '女', '18', '123456', '10001', '980297943@qq.com', '0', '2018-09-26 15:41:35', '2018-09-26 16:05:50');
INSERT INTO `user` VALUES ('1538011461179616415', '蜗牛', '女', '30', '123456', '135135135135', 'yang_chu_hua@163.com', '0', '2018-09-27 09:24:21', '2018-09-27 09:28:56');
