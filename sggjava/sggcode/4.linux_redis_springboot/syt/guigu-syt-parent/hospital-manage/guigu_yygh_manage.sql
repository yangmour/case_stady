-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        8.0.26 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 guigu_yygh_manage 的数据库结构
CREATE DATABASE IF NOT EXISTS `guigu_yygh_manage` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `guigu_yygh_manage`;

-- 导出  表 guigu_yygh_manage.hospital_set 结构
CREATE TABLE IF NOT EXISTS `hospital_set` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `hoscode` varchar(30) DEFAULT NULL COMMENT '医院编号',
  `sign_key` varchar(50) DEFAULT NULL COMMENT '签名秘钥',
  `api_url` varchar(100) DEFAULT NULL COMMENT '统一挂号平台api地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='医院设置表';

-- 正在导出表  guigu_yygh_manage.hospital_set 的数据：~1 rows (大约)
DELETE FROM `hospital_set`;
INSERT INTO `hospital_set` (`id`, `hoscode`, `sign_key`, `api_url`, `create_time`, `update_time`, `is_deleted`) VALUES
	(1, '10000', '8af52af00baf6aec434109fc17164aae', 'http://localhost:8200', '2023-02-14 12:12:25', '2023-02-14 12:12:25', 0);

-- 导出  表 guigu_yygh_manage.order_info 结构
CREATE TABLE IF NOT EXISTS `order_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `schedule_id` bigint DEFAULT NULL COMMENT '排班id',
  `patient_id` bigint DEFAULT NULL COMMENT '就诊人id',
  `number` int DEFAULT NULL COMMENT '预约号序',
  `fetch_time` varchar(50) DEFAULT NULL COMMENT '建议取号时间',
  `fetch_address` varchar(255) DEFAULT NULL COMMENT '取号地点',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '医事服务费',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `quit_time` datetime DEFAULT NULL COMMENT '退号时间',
  `order_status` tinyint DEFAULT NULL COMMENT '订单状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='订单表';

-- 正在导出表  guigu_yygh_manage.order_info 的数据：~0 rows (大约)
DELETE FROM `order_info`;

-- 导出  表 guigu_yygh_manage.schedule 结构
CREATE TABLE IF NOT EXISTS `schedule` (
  `id` bigint NOT NULL DEFAULT '0' COMMENT '编号',
  `hoscode` varchar(30) DEFAULT NULL COMMENT '医院编号',
  `depcode` varchar(30) DEFAULT NULL COMMENT '科室编号',
  `title` varchar(20) DEFAULT NULL COMMENT '职称',
  `docname` varchar(20) DEFAULT NULL COMMENT '医生名称',
  `skill` text COMMENT '擅长技能',
  `work_date` date DEFAULT NULL COMMENT '安排日期',
  `work_time` tinyint DEFAULT '0' COMMENT '安排时间（0：上午 1：下午）',
  `reserved_number` int DEFAULT '0' COMMENT '可预约数',
  `available_number` int DEFAULT '0' COMMENT '剩余预约数',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '挂号费',
  `status` tinyint DEFAULT NULL COMMENT '排班状态（-1：停诊 0：停约 1：可约）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='医生日程安排表';

-- 正在导出表  guigu_yygh_manage.schedule 的数据：~0 rows (大约)
DELETE FROM `schedule`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
