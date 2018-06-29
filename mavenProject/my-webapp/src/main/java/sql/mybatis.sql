/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-28 14:05:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `c_role_menu`;
CREATE TABLE `c_role_menu` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for c_role_menu_but
-- ----------------------------
DROP TABLE IF EXISTS `c_role_menu_but`;
CREATE TABLE `c_role_menu_but` (
  `id` int(11) NOT NULL,
  `role_menu_id` int(11) DEFAULT NULL,
  `but_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_role_menu_but
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `c_user_dept`;
CREATE TABLE `c_user_dept` (
  `id` int(11) NOT NULL,
  `dpt_id` int(11) DEFAULT NULL COMMENT '部门id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `dpt_id` (`dpt_id`),
  CONSTRAINT `dpt_id` FOREIGN KEY (`dpt_id`) REFERENCES `t_sys_dpt` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_dept
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_role
-- ----------------------------
DROP TABLE IF EXISTS `c_user_role`;
CREATE TABLE `c_user_role` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_but
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_but`;
CREATE TABLE `t_sys_but` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_but
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_dpt
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dpt`;
CREATE TABLE `t_sys_dpt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '部门名',
  `sort` int(8) DEFAULT NULL COMMENT '排序',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` int(11) DEFAULT NULL,
  `parent_dpt` int(11) DEFAULT NULL COMMENT '父级部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_dpt
-- ----------------------------
INSERT INTO `t_sys_dpt` VALUES ('1', '成都自由人有限公司', null, '1', '2018-05-16 11:41:46', '1', null);
INSERT INTO `t_sys_dpt` VALUES ('2', '研发部', '0', '1', '2018-05-16 11:44:36', '1', '1');
INSERT INTO `t_sys_dpt` VALUES ('3', '研发一部', '1', '1', '2018-05-16 11:44:27', '1', '2');
INSERT INTO `t_sys_dpt` VALUES ('4', '研发二部', '2', '1', '2018-05-16 11:44:27', '1', '2');
INSERT INTO `t_sys_dpt` VALUES ('5', '研发三部', '3', '0', '2018-05-16 11:44:31', '1', '2');
INSERT INTO `t_sys_dpt` VALUES ('6', '市场部', null, '1', '2018-05-16 11:44:41', '1', '1');
INSERT INTO `t_sys_dpt` VALUES ('7', '市场一部', null, '1', '2018-05-16 11:44:35', '1', '6');
INSERT INTO `t_sys_dpt` VALUES ('8', '测试部', null, '1', null, '1', '1');
INSERT INTO `t_sys_dpt` VALUES ('9', '运营部', null, '1', null, '1', '1');
INSERT INTO `t_sys_dpt` VALUES ('10', '策划部', null, '1', null, '1', '1');

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
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('1', '系统管理', '', null, null, null, 'code2000', '1', null, null, '&#xe614;');
INSERT INTO `t_sys_menu` VALUES ('2', '你妹', null, null, null, null, 'code2001', '1', null, null, '&#xe659;');
INSERT INTO `t_sys_menu` VALUES ('3', '商品管理', null, null, null, null, 'code2002', '1', null, null, '&#xe659;');
INSERT INTO `t_sys_menu` VALUES ('4', '其他管理', null, null, null, null, 'code2003', '1', null, null, '&#xe614;');
INSERT INTO `t_sys_menu` VALUES ('5', '图形统计', null, null, null, null, null, '1', null, null, '&#xe005;');
INSERT INTO `t_sys_menu` VALUES ('11', '首页（锐理）', null, null, null, null, null, '1', null, null, '&#xe68e;');
INSERT INTO `t_sys_menu` VALUES ('12', '新房管理（锐理）', null, null, null, null, null, '1', null, null, '&#xe770;');
INSERT INTO `t_sys_menu` VALUES ('24', '部门管理', 'dept', '../ftl/sys/dept.html', 'webappJs/sys/deptCtrl', 'deptCtrl', 'code3000', '2', '1', '/system/dept', '&#xe601;');
INSERT INTO `t_sys_menu` VALUES ('25', '角色管理', 'role', '../ftl/sys/role.html', 'webappJs/sys/roleCtrl', 'roleCtrl', 'code3001', '2', '1', '/system/role', '&#xe602;');
INSERT INTO `t_sys_menu` VALUES ('26', '用户管理', 'user', '../ftl/sys/user.html', 'webappJs/sys/userCtrl', 'userCtrl', 'code3002', '2', '1', '/system/user', '&#xe603;');
INSERT INTO `t_sys_menu` VALUES ('27', '权限管理', 'power', '../ftl/sys/power.html', 'webappJs/sys/powerCtrl', 'powerCtrl', 'code3003', '2', '1', '/system/power', '&#xe006;');
INSERT INTO `t_sys_menu` VALUES ('28', '菜单管理', 'menu', '../ftl/sys/menu.html', 'webappJs/sys/menuCtrl', 'menuCtrl', 'code3004', '2', '1', '/system/menu', '&#xe007;');
INSERT INTO `t_sys_menu` VALUES ('29', '流程实列', 'flew', '../ftl/sys/flew.html', 'webappJs/sys/flewCtrl', 'flewCtrl', 'code3005', '2', '1', '/system/flew', '&#xe606;');
INSERT INTO `t_sys_menu` VALUES ('51', '楼盘优势分析（锐理）', 'ysAnalysis', '../ftl/analysis/ysA.html', 'webappJs/analysis/ysAnalysisCtrl', 'ysAnalysisCtrl', 'code3006', '2', '5', '/analysis/ysAnalysisCtrl', '&#xe607;');
INSERT INTO `t_sys_menu` VALUES ('52', '区域价格分析（锐理）', 'priceAnalysis', '../ftl/analysis/priceA.html', 'webappJs/analysis/priceAnalysisCtrl', 'priceAnalysisCtrl', 'code3007', '2', '5', '/analysis/priceAnalysisCtrl', '&#xe608;');
INSERT INTO `t_sys_menu` VALUES ('221', '来呀来呀来呀', null, null, null, null, null, '2', '2', null, '&#xe609;');
INSERT INTO `t_sys_menu` VALUES ('222', '来呀来呀来呀2', null, null, null, null, null, '2', '2', null, '&#xe60a;');

-- ----------------------------
-- Table structure for t_sys_post
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_post`;
CREATE TABLE `t_sys_post` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_post
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `loginName` varchar(255) NOT NULL COMMENT '登录名',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `safeKey` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'Q', 'code0001', 'Q.com', '13588822221', '1234', 'admin', '2018-06-28 13:52:26', 'D30EDE89488AB0F00752FA0906DD7E67');
