/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-10 17:04:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL COMMENT '菜单名称',
  `urlKey` varchar(50) DEFAULT NULL COMMENT 'eg:<a href="#!/urlKey">test</a>',
  `urlHtml` varchar(50) DEFAULT NULL COMMENT '链接标记（html），用户不输入，就默认key生成',
  `urlCtrl` varchar(50) DEFAULT NULL COMMENT '控制器的url（js），用户不输入，就默认key生成',
  `ctrlKey` varchar(50) DEFAULT NULL,
  `code` varchar(25) DEFAULT NULL COMMENT '菜单编码，使用key别扭，将code和key使用用途分开，不要∠在一起',
  `level` int(2) DEFAULT '1' COMMENT '多少级菜单',
  `parent` int(11) DEFAULT NULL COMMENT '父级',
  `key` varchar(50) DEFAULT NULL COMMENT '用于生成默认url路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('1', '系统管理', '', null, null, null, 'code2000', '1', null, null);
INSERT INTO `t_sys_menu` VALUES ('2', '你妹', null, null, null, null, 'code2001', '1', null, null);
INSERT INTO `t_sys_menu` VALUES ('3', '商品管理', null, null, null, null, 'code2002', '1', null, null);
INSERT INTO `t_sys_menu` VALUES ('4', '其他管理', null, null, null, null, 'code2003', '1', null, null);
INSERT INTO `t_sys_menu` VALUES ('5', '图形统计', null, null, null, null, null, '1', null, null);
INSERT INTO `t_sys_menu` VALUES ('11', '首页（锐理）', null, null, null, null, null, '1', null, null);
INSERT INTO `t_sys_menu` VALUES ('12', '新房管理（锐理）', null, null, null, null, null, '1', null, null);
INSERT INTO `t_sys_menu` VALUES ('25', '角色管理', 'role', '../ftl/sys/role.html', 'webappJs/sys/roleCtrl', 'roleCtrl', 'code3001', '2', '1', '/system/role');
INSERT INTO `t_sys_menu` VALUES ('26', '用户管理', 'user', '../ftl/sys/user.html', 'webappJs/sys/userCtrl', 'userCtrl', 'code3002', '2', '1', '/system/user');
INSERT INTO `t_sys_menu` VALUES ('27', '权限管理', 'power', '../ftl/sys/power.html', 'webappJs/sys/powerCtrl', 'powerCtrl', 'code3003', '2', '1', '/system/power');
INSERT INTO `t_sys_menu` VALUES ('28', '菜单管理', 'menu', '../ftl/sys/menu.html', 'webappJs/sys/menuCtrl', 'menuCtrl', 'code3004', '2', '1', '/system/menu');
INSERT INTO `t_sys_menu` VALUES ('29', '流程实列', 'flew', '../ftl/sys/flew.html', 'webappJs/sys/flewCtrl', 'flewCtrl', 'code3005', '2', '1', '/system/flew');
INSERT INTO `t_sys_menu` VALUES ('51', '楼盘优势分析（锐理）', 'ysAnalysis', '../ftl/analysis/ysA.html', 'webappJs/analysis/ysAnalysisCtrl', 'ysAnalysisCtrl', 'code3006', '2', '5', '/analysis/ysAnalysisCtrl');
INSERT INTO `t_sys_menu` VALUES ('52', '区域价格分析（锐理）', 'priceAnalysis', '../ftl/analysis/priceA.html', 'webappJs/analysis/priceAnalysisCtrl', 'priceAnalysisCtrl', 'code3007', '2', '5', '/analysis/priceAnalysisCtrl');
INSERT INTO `t_sys_menu` VALUES ('221', '来呀来呀来呀', null, null, null, null, null, '2', '2', null);
INSERT INTO `t_sys_menu` VALUES ('222', '来呀来呀来呀2', null, null, null, null, null, '2', '2', null);
