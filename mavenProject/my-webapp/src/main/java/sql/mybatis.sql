/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-25 15:47:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `c_role_menu`;
CREATE TABLE `c_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for c_role_menu_btn
-- ----------------------------
DROP TABLE IF EXISTS `c_role_menu_btn`;
CREATE TABLE `c_role_menu_btn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `btn_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_role_menu_btn
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `c_user_dept`;
CREATE TABLE `c_user_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dpt_id` int(11) DEFAULT NULL COMMENT '部门id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `dpt_id` (`dpt_id`),
  CONSTRAINT `dpt_id` FOREIGN KEY (`dpt_id`) REFERENCES `t_sys_dpt` (`dpt_id`),
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `name` varchar(50) NOT NULL,
  `current_value` int(11) NOT NULL,
  `increment` int(11) NOT NULL DEFAULT '1'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='序列表，命名s_[table_name]';

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('s_blog_account', '3', '1');
INSERT INTO `sequence` VALUES ('s_user_code', '100006', '1');

-- ----------------------------
-- Table structure for t_sys_but
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_but`;
CREATE TABLE `t_sys_but` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_but
-- ----------------------------
INSERT INTO `t_sys_but` VALUES ('1', '增加', 'codeAdd');
INSERT INTO `t_sys_but` VALUES ('2', '删除', 'codeDelete');
INSERT INTO `t_sys_but` VALUES ('3', '修改', 'codeUpdate');
INSERT INTO `t_sys_but` VALUES ('4', '查询', 'codeSearch');
INSERT INTO `t_sys_but` VALUES ('5', '查看', 'codeDetail');

-- ----------------------------
-- Table structure for t_sys_dpt
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dpt`;
CREATE TABLE `t_sys_dpt` (
  `dpt_id` int(11) NOT NULL AUTO_INCREMENT,
  `dpt_name` varchar(50) NOT NULL COMMENT '部门名',
  `dpt_sort` int(8) DEFAULT NULL COMMENT '排序',
  `dpt_status` int(2) DEFAULT NULL COMMENT '状态',
  `dpt_create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dpt_create_user` int(11) DEFAULT NULL,
  `dpt_parent` int(11) DEFAULT NULL COMMENT '父级部门id',
  PRIMARY KEY (`dpt_id`)
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
  `disable` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('1', '系统管理', '', null, null, null, 'code2000', '1', null, null, '&#xe614;', '1');
INSERT INTO `t_sys_menu` VALUES ('2', '你妹', null, null, null, null, 'code2001', '1', null, null, '&#xe659;', '1');
INSERT INTO `t_sys_menu` VALUES ('3', '商品管理', null, null, null, null, 'code2002', '1', null, null, '&#xe659;', '1');
INSERT INTO `t_sys_menu` VALUES ('4', '其他管理', null, null, null, null, 'code2003', '1', null, null, '&#xe614;', '1');
INSERT INTO `t_sys_menu` VALUES ('5', '图形统计', null, null, null, null, null, '1', null, null, '&#xe005;', '1');
INSERT INTO `t_sys_menu` VALUES ('11', '首页（锐理）', null, null, null, null, null, '1', null, null, '&#xe68e;', '1');
INSERT INTO `t_sys_menu` VALUES ('12', '新房管理（锐理）', 'nh', '../ftl/nh/nh.html', 'webappJs/nh/nhCtrl', 'nhCtrl', 'code3008', '1', null, null, '&#xe770;', '1');
INSERT INTO `t_sys_menu` VALUES ('24', '部门管理', 'dept', '../ftl/sys/dept.html', 'webappJs/sys/deptCtrl', 'deptCtrl', 'code3000', '2', '1', null, '&#xe601;', '1');
INSERT INTO `t_sys_menu` VALUES ('25', '角色管理', 'role', '../ftl/sys/role.html', 'webappJs/sys/roleCtrl', 'roleCtrl', 'code3001', '2', '1', null, '&#xe64c;', '1');
INSERT INTO `t_sys_menu` VALUES ('26', '用户管理', 'user', '../ftl/sys/user.html', 'webappJs/sys/userCtrl', 'userCtrl', 'code3002', '2', '1', null, '&#xe770;', '1');
INSERT INTO `t_sys_menu` VALUES ('27', '权限管理', 'power', '../ftl/sys/power.html', 'webappJs/sys/powerCtrl', 'powerCtrl', 'code3003', '2', '1', null, '&#xe006;', '1');
INSERT INTO `t_sys_menu` VALUES ('28', '菜单管理', 'menu', '../ftl/sys/menu.html', 'webappJs/sys/menuCtrl', 'menuCtrl', 'code3004', '2', '1', null, '&#xe007;', '1');
INSERT INTO `t_sys_menu` VALUES ('29', '流程实列', 'flew', '../ftl/sys/flew.html', 'webappJs/sys/flewCtrl', 'flewCtrl', 'code3005', '2', '1', null, '&#xe606;', '1');
INSERT INTO `t_sys_menu` VALUES ('31', '新房-详情', 'nh_detail', '../ftl/nh/nh_detail.html', 'webappJs/nh/nh_detailCtrl', 'nh_detailCtrl', 'code3009', '2', '12', null, '&#xe606;', '1');
INSERT INTO `t_sys_menu` VALUES ('51', '楼盘优势分析（锐理）', 'ysAnalysis', '../ftl/analysis/ysA.html', 'webappJs/analysis/ysAnalysisCtrl', 'ysAnalysisCtrl', 'code3006', '2', '5', null, '&#xe607;', '1');
INSERT INTO `t_sys_menu` VALUES ('52', '区域价格分析（锐理）', 'priceAnalysis', '../ftl/analysis/priceA.html', 'webappJs/analysis/priceAnalysisCtrl', 'priceAnalysisCtrl', 'code3007', '2', '5', null, '&#xe608;', '1');
INSERT INTO `t_sys_menu` VALUES ('221', '来呀来呀来呀', null, null, null, null, null, '2', '2', null, '&#xe609;', '1');
INSERT INTO `t_sys_menu` VALUES ('222', '来呀来', null, null, null, null, null, '2', '2', null, '&#xe60a;', '1');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `meo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员', '后台人员，具备删库跑路权限');
INSERT INTO `t_sys_role` VALUES ('2', '产品总监', '具备删库权限');
INSERT INTO `t_sys_role` VALUES ('3', '产品负责人', '具备除了系统管理外所有权限');
INSERT INTO `t_sys_role` VALUES ('4', '跑腿儿的', '首页，商品管理');

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
  `dpt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'Q', 'code0001', 'Q.com', '13588822221', '1234', 'admin', '2018-07-25 15:37:00', 'AF9B3FC59D6CC7CBD55B51A1D43EC8BC', '1');
INSERT INTO `t_sys_user` VALUES ('5', '张三', 'wocailei20180705142011', '1312299@qq.com', '13823233221', '123456', 'zhangsan', '2018-07-05 16:12:28', null, '2');
INSERT INTO `t_sys_user` VALUES ('6', '李四', 'wocailei20180705142013', '123@qq.com', '15882232132', '123456', 'lisi', '2018-07-05 16:12:29', null, '3');
INSERT INTO `t_sys_user` VALUES ('7', '王麻子', 'wocailei20180705142014', '12@qq.com', '15882322133', '123456', 'wangmazi', '2018-07-05 16:12:30', null, '4');
INSERT INTO `t_sys_user` VALUES ('8', '开飞机', 'wocailei20180705142015', '1329929@qq.com', '15882232213', '123456', 'kaifeiji', '2018-07-05 16:12:33', null, '2');
INSERT INTO `t_sys_user` VALUES ('9', '炸老子', 'wocailei20180705142016', '1232993@qq.com', '18231313331', '123456', 'zhalaozi', '2018-07-05 16:12:34', null, '3');
INSERT INTO `t_sys_user` VALUES ('10', '锤子分割线', 'wocailei20180705154651', '192323@qq.com', '15662232723', '123456', 'chuizi', '2018-07-06 09:48:01', null, '8');
INSERT INTO `t_sys_user` VALUES ('13', '仙女', 'code100005', '1969323222@qq.com', '15884426321', '123456', 'xiannv', '2018-07-06 09:46:21', null, '2');
INSERT INTO `t_sys_user` VALUES ('14', '帅哥', 'code100006', '13123@qq.com', '15888232321', '123456', 'shuaige', '2018-07-06 09:47:56', null, '4');

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`test`@`localhost` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)
    READS SQL DATA
    DETERMINISTIC
BEGIN  
  
DECLARE VALUE INTEGER;  
  
SET VALUE = 0;  
  
SELECT current_value INTO VALUE FROM sequence WHERE NAME = seq_name;  
  
RETURN VALUE;  
  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`test`@`localhost` FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN  
  
UPDATE sequence SET current_value = current_value + increment WHERE NAME = seq_name;  
  
RETURN currval(seq_name);  
  
END
;;
DELIMITER ;
