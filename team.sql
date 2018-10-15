/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : studentoa

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-10-15 16:24:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队id',
  `taskname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队绑定的主任务名',
  `progress` int(11) NOT NULL DEFAULT '100' COMMENT '任务进展',
  `substack_number` int(11) NOT NULL DEFAULT '0' COMMENT '子任务数量',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组长email',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '任务的描述',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '主任务状态：进行中，完成，过期，死亡',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '团队任务启动时间',
  `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '任务到期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('01', '测试', '100', '0', 'Ldixing@163.com', '暂无描述', '0', '2018-10-15 15:39:07', '2018-10-15 15:39:07');
