-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        8.0.26 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出 guigu_common_system 的数据库结构
CREATE DATABASE IF NOT EXISTS `guigu_common_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `guigu_common_system`;

-- 导出  表 guigu_common_system.sys_dept 结构
CREATE TABLE IF NOT EXISTS `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` bigint DEFAULT '0' COMMENT '上级部门id',
  `tree_path` varchar(255) DEFAULT ',' COMMENT '树结构',
  `sort_value` int DEFAULT '1' COMMENT '排序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='组织机构';

-- 正在导出表  guigu_common_system.sys_dept 的数据：~17 rows (大约)
DELETE FROM `sys_dept`;
INSERT INTO `sys_dept` (`id`, `name`, `parent_id`, `tree_path`, `sort_value`, `leader`, `phone`, `status`, `create_time`, `update_time`, `is_deleted`) VALUES
	(1, '尚硅谷教育', 0, ',1,', 1, '张老师', '15659090912', 1, '2023-03-10 08:08:53', '2023-03-10 08:08:53', 0),
	(10, '北京校区', 1, ',1,10,', 1, '李老师', '18790007789', 1, '2023-03-10 06:38:01', '2023-03-10 06:27:48', 0),
	(20, '上海校区', 1, ',1,20,', 1, '王老师', '15090987678', 1, '2023-03-10 06:38:00', '2023-03-10 06:27:48', 0),
	(30, '深圳校区', 1, ',1,30,', 1, '李老师', '15090987678', 1, '2023-03-10 06:37:59', '2023-03-10 06:27:48', 0),
	(1010, '教学部', 10, ',1,10,1010,', 1, '李老师', '15090987678', 1, '2023-03-10 08:08:29', '2023-03-10 08:08:29', 0),
	(1020, '运营部', 10, ',1,10,1020,', 1, '王老师', '15090987678', 1, '2023-03-10 08:08:27', '2023-03-10 08:08:27', 0),
	(1021, 'Java', 1010, ',1,10,1010,1021,', 1, '王老师', '15090987678', 1, '2023-03-10 08:09:10', '2023-03-10 08:09:10', 0),
	(1022, '大数据', 1010, ',1,10,1010,1022,', 1, '王老师', '15090987678', 1, '2023-03-10 08:09:11', '2023-03-10 08:09:11', 0),
	(1024, '前端', 1010, ',1,10,1010,1024,', 1, '李老师', '15090987678', 1, '2023-03-10 08:09:13', '2023-03-10 08:09:13', 0),
	(1025, '客服', 1020, ',1,10,1020,1025,', 1, '李老师', '15090987678', 1, '2023-03-10 06:37:56', '2023-03-10 06:27:48', 0),
	(1026, '网站推广', 1020, ',1,10,1020,1026,', 1, '30.607366', '15090987678', 1, '2023-03-10 06:37:55', '2023-03-10 06:27:48', 0),
	(1027, '线下运营', 1020, ',1,10,1020,1027,', 1, '李老师', '15090987678', 1, '2023-03-10 06:37:55', '2023-03-10 06:27:48', 0),
	(1028, '设计', 1020, ',1,10,1020,1028,', 1, '李老师', '15090987678', 1, '2023-03-10 06:37:54', '2023-03-10 06:27:48', 0),
	(2012, '教学部', 20, ',1,20,2012,', 1, '王老师', '18909890765', 1, '2023-03-10 08:08:34', '2023-03-10 08:08:34', 0),
	(2013, '教学部', 30, ',1,30,2013,', 1, '李老师', '18567867895', 1, '2023-03-10 08:08:35', '2023-03-10 08:08:35', 0),
	(2016, 'Java', 2012, ',1,20,2012,2012,', 1, '张老师', '15090909909', 1, '2023-03-10 08:09:14', '2023-03-10 08:09:14', 0),
	(2017, '大数据', 2012, ',1,20,2012,2012,', 1, '李老师', '15090980989', 1, '2023-03-10 08:09:15', '2023-03-10 08:09:15', 0);


-- 导出  表 guigu_common_system.sys_menu 结构
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '所属上级',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型(0:目录,1:菜单,2:按钮)',
  `path` varchar(100) DEFAULT NULL COMMENT '路由地址',
  `component` varchar(100) DEFAULT NULL COMMENT '组件路径',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `sort_value` int DEFAULT NULL COMMENT '排序',
  `status` tinyint DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

-- 正在导出表  guigu_common_system.sys_menu 的数据：~33 rows (大约)
DELETE FROM `sys_menu`;
INSERT INTO `sys_menu` (`id`, `parent_id`, `name`, `type`, `path`, `component`, `perms`, `icon`, `sort_value`, `status`, `create_time`, `update_time`, `is_deleted`) VALUES
	(2, 0, '系统管理', 0, 'system', 'Layout', NULL, 'el-icon-s-tools', 10, 1, '2021-05-31 10:05:37', '2022-06-09 01:23:24', 0),
	(3, 2, '用户管理', 1, 'sysUser', 'system/sysUser/list', '', 'el-icon-s-custom', 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:47', 0),
	(4, 2, '角色管理', 1, 'sysRole', 'system/sysRole/list', '', 'el-icon-user-solid', 2, 1, '2021-05-31 10:05:37', '2022-06-09 01:37:18', 0),
	(5, 2, '菜单管理', 1, 'sysMenu', 'system/sysMenu/list', '', 'el-icon-s-unfold', 3, 1, '2021-05-31 10:05:37', '2022-06-09 01:37:21', 0),
	(6, 3, '查看', 2, NULL, NULL, 'bnt.sysUser.list', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(7, 3, '添加', 2, NULL, NULL, 'bnt.sysUser.add', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(8, 3, '修改', 2, NULL, NULL, 'bnt.sysUser.update', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(9, 3, '删除', 2, NULL, NULL, 'bnt.sysUser.remove', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(10, 4, '查看', 2, NULL, NULL, 'bnt.sysRole.list', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(11, 4, '添加', 2, NULL, NULL, 'bnt.sysRole.add', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(12, 4, '修改', 2, NULL, NULL, 'bnt.sysRole.update', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(13, 4, '删除', 2, NULL, NULL, 'bnt.sysRole.remove', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(14, 5, '查看', 2, NULL, NULL, 'bnt.sysMenu.list', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(15, 5, '添加', 2, NULL, NULL, 'bnt.sysMenu.add', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(16, 5, '修改', 2, NULL, NULL, 'bnt.sysMenu.update', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(17, 5, '删除', 2, NULL, NULL, 'bnt.sysMenu.remove', NULL, 1, 1, '2021-05-31 10:05:37', '2022-06-09 01:22:38', 0),
	(18, 3, '分配角色', 2, NULL, NULL, 'bnt.sysUser.assignRole', NULL, 1, 1, '2022-05-23 09:14:32', '2022-06-09 01:22:38', 0),
	(19, 4, '分配权限', 2, 'assignAuth', 'system/sysRole/assignAuth', 'bnt.sysRole.assignAuth', NULL, 1, 1, '2022-05-23 09:18:14', '2022-06-09 01:22:38', 0),
	(20, 2, '部门管理', 1, 'sysDept', 'system/sysDept/list', '', 'el-icon-s-operation', 4, 1, '2022-05-24 02:07:05', '2022-06-09 01:38:12', 0),
	(21, 20, '查看', 2, NULL, NULL, 'bnt.sysDept.list', NULL, 1, 1, '2022-05-24 02:07:44', '2022-06-09 01:22:38', 0),
	(22, 2, '岗位管理', 1, 'sysPost', 'system/sysPost/list', '', 'el-icon-more-outline', 5, 1, '2022-05-24 02:25:30', '2022-06-09 01:38:13', 0),
	(23, 22, '查看', 2, NULL, NULL, 'bnt.sysPost.list', NULL, 1, 1, '2022-05-24 02:25:45', '2022-06-09 01:22:38', 0),
	(24, 20, '添加', 2, NULL, NULL, 'bnt.sysDept.add', NULL, 1, 1, '2022-05-25 07:31:27', '2022-06-09 01:22:38', 0),
	(25, 20, '修改', 2, NULL, NULL, 'bnt.sysDept.update', NULL, 1, 1, '2022-05-25 07:31:41', '2022-06-09 01:22:38', 0),
	(26, 20, '删除', 2, NULL, NULL, 'bnt.sysDept.remove', NULL, 1, 1, '2022-05-25 07:31:59', '2022-06-09 01:22:38', 0),
	(27, 22, '添加', 2, NULL, NULL, 'bnt.sysPost.add', NULL, 1, 1, '2022-05-25 07:32:44', '2022-06-09 01:22:38', 0),
	(28, 22, '修改', 2, NULL, NULL, 'bnt.sysPost.update', NULL, 1, 1, '2022-05-25 07:32:58', '2022-06-09 01:22:38', 0),
	(29, 22, '删除', 2, NULL, NULL, 'bnt.sysPost.remove', NULL, 1, 1, '2022-05-25 07:33:11', '2022-06-09 01:22:38', 0);

-- 导出  表 guigu_common_system.sys_post 结构
CREATE TABLE IF NOT EXISTS `sys_post` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '岗位名称',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位信息表';

-- 正在导出表  guigu_common_system.sys_post 的数据：~4 rows (大约)
DELETE FROM `sys_post`;
INSERT INTO `sys_post` (`id`, `post_code`, `name`, `description`, `status`, `create_time`, `update_time`, `is_deleted`) VALUES
	(5, 'dsz', '董事长', '董事长', 1, '2023-03-10 06:27:48', '2023-03-10 06:35:46', 0),
	(6, 'zjl', '总经理', '总经理', 1, '2023-03-10 06:27:48', '2023-03-10 06:35:45', 0),
	(7, 'wz', '网咨', '网咨', 1, '2023-03-10 06:27:48', '2023-03-10 06:35:44', 0),
	(8, 'yyzj', '运营总监', '运营总监', 1, '2023-03-10 06:27:48', '2023-03-10 06:27:48', 0);

-- 导出  表 guigu_common_system.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

-- 正在导出表  guigu_common_system.sys_role 的数据：~4 rows (大约)
DELETE FROM `sys_role`;
INSERT INTO `sys_role` (`id`, `role_name`, `role_code`, `description`, `create_time`, `update_time`, `is_deleted`) VALUES
	(1, '系统管理员', 'SYSTEM', '系统管理员', '2023-03-10 06:27:48', '2023-03-10 06:35:31', 0),
	(2, '普通管理员', 'COMMON', '普通管理员', '2023-03-10 06:27:48', '2023-03-11 08:57:36', 0),
	(8, '用户管理员', 'USER', '用户管理员', '2023-03-10 06:27:48', '2023-03-10 07:05:01', 0),
	(9, '角色管理员', 'ROLE', '角色管理员', '2023-03-10 06:27:48', '2023-03-10 07:05:02', 0);

-- 导出  表 guigu_common_system.sys_role_menu 结构
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL DEFAULT '0',
  `menu_id` bigint NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单';

-- 正在导出表  guigu_common_system.sys_role_menu 的数据：~51 rows (大约)
DELETE FROM `sys_role_menu`;
INSERT INTO `sys_role_menu` (`id`, `role_id`, `menu_id`, `create_time`, `update_time`, `is_deleted`) VALUES
	(66, 1, 2, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(67, 1, 3, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(68, 1, 6, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(69, 1, 7, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(70, 1, 8, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(71, 1, 9, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(72, 1, 18, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(73, 1, 4, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(74, 1, 10, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(75, 1, 11, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(76, 1, 12, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(77, 1, 13, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(78, 1, 19, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(79, 1, 5, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(80, 1, 14, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(81, 1, 15, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(82, 1, 16, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(83, 1, 17, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(84, 1, 20, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(85, 1, 21, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(86, 1, 24, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(87, 1, 25, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(88, 1, 26, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(89, 1, 22, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(90, 1, 23, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(91, 1, 27, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(92, 1, 28, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(93, 1, 29, '2023-03-10 09:24:58', '2023-03-10 09:24:58', 0),
	(129, 2, 2, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(130, 2, 20, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(131, 2, 21, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(132, 2, 24, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(133, 2, 25, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(134, 2, 26, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(135, 2, 22, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(136, 2, 23, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(137, 2, 27, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(138, 2, 28, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(139, 2, 29, '2023-03-13 01:41:03', '2023-03-13 01:41:03', 0),
	(140, 9, 2, '2023-03-13 01:41:32', '2023-03-13 01:41:32', 0),
	(141, 9, 4, '2023-03-13 01:41:32', '2023-03-13 01:41:32', 0),
	(142, 9, 10, '2023-03-13 01:41:32', '2023-03-13 01:41:32', 0),
	(143, 9, 11, '2023-03-13 01:41:32', '2023-03-13 01:41:32', 0),
	(144, 9, 12, '2023-03-13 01:41:32', '2023-03-13 01:41:32', 0),
	(145, 9, 13, '2023-03-13 01:41:32', '2023-03-13 01:41:32', 0),
	(146, 9, 19, '2023-03-13 01:41:32', '2023-03-13 01:41:32', 0);

-- 导出  表 guigu_common_system.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `head_url` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `dept_id` bigint DEFAULT NULL COMMENT '部门id',
  `post_id` bigint DEFAULT NULL COMMENT '岗位id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint DEFAULT NULL COMMENT '状态（1：正常 0：停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- 正在导出表  guigu_common_system.sys_user 的数据：~3 rows (大约)
DELETE FROM `sys_user`;
INSERT INTO `sys_user` (`id`, `username`, `password`, `name`, `phone`, `head_url`, `dept_id`, `post_id`, `description`, `status`, `create_time`, `update_time`, `is_deleted`) VALUES
	(1, 'admin', '96e79218965eb72c92a549dd5a330112', 'admin', '15099909888', 'http://r61cnlsfq.hn-bkt.clouddn.com/7daa4595-dfde-45da-8513-c5c2b81d20cc', 1021, 5, NULL, 1, '2023-03-10 06:27:48', '2023-03-10 12:07:51', 0),
	(2, 'wangqq', '96e79218965eb72c92a549dd5a330112', '王倩倩', '15010546381', 'http://r61cnlsfq.hn-bkt.clouddn.com/b09b3467-3d99-437a-bd2e-dd8c9be92bb8', 1022, 6, NULL, 1, '2023-03-10 06:27:48', '2023-03-10 07:16:16', 0),
	(3, 'wanggang', '96e79218965eb72c92a549dd5a330112', '王刚', '18909098909', NULL, 1024, 5, NULL, 1, '2023-03-10 06:27:48', '2023-03-10 07:10:05', 0);

-- 导出  表 guigu_common_system.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_admin_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色';

-- 正在导出表  guigu_common_system.sys_user_role 的数据：~8 rows (大约)
DELETE FROM `sys_user_role`;
INSERT INTO `sys_user_role` (`id`, `role_id`, `user_id`, `create_time`, `update_time`, `is_deleted`) VALUES
	(18, 2, 2, '2023-03-10 09:23:52', '2023-03-10 12:10:23', 1),
	(19, 8, 3, '2023-03-10 09:23:57', '2023-03-10 09:23:57', 0),
	(20, 1, 1, '2023-03-10 09:24:05', '2023-03-10 09:24:05', 0),
	(21, 2, 1, '2023-03-10 09:24:05', '2023-03-10 09:24:05', 0),
	(22, 8, 1, '2023-03-10 09:24:05', '2023-03-10 09:24:05', 0),
	(23, 9, 1, '2023-03-10 09:24:05', '2023-03-10 09:24:05', 0),
	(24, 2, 2, '2023-03-10 12:10:23', '2023-03-10 12:10:23', 0),
	(25, 9, 2, '2023-03-10 12:10:23', '2023-03-10 12:10:23', 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
