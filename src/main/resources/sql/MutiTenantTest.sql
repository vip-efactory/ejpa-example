-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.17 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 创建测试的数据库
CREATE DATABASE IF NOT EXISTS `db_ejpa_example_1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE DATABASE IF NOT EXISTS `db_ejpa_example_2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE DATABASE IF NOT EXISTS `db_ejpa_example_3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs */ /*!80016 DEFAULT ENCRYPTION='N' */;
-- 使用默认库
USE `db_ejpa_example_1`;

-- 创建系统租户表
CREATE TABLE IF NOT EXISTS `sys_tenant` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tenant_name` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '租户名称',
  `tenant_code` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '租户编码',
  `db_username` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT 'DB用户名',
  `db_password` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT 'DB密码',
  `driver_class_name` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '驱动URL',
  `jdbc_url` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '租户名称',
  `remark` varchar(1024) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updater_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_zh_0900_as_cs;

-- 创建学生表
CREATE TABLE IF NOT EXISTS `student` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '姓名',
  `age` INT(11) NOT NULL COMMENT '年龄',
  `birthday` DATE NULL DEFAULT NULL COMMENT '生日',
  `sex` INT(11) NOT NULL COMMENT '性别',
  `email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '邮件',
  `hobby` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '爱好',
  `height` DOUBLE NULL DEFAULT NULL COMMENT '身高',
  `remark` varchar(1024) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updater_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_zh_0900_as_cs;

-- 插入租户测试数据
INSERT INTO `sys_tenant` (`id`,`db_password`, `db_username`, `driver_class_name`, `jdbc_url`, `tenant_code`, `tenant_name`) VALUES
	(1,'123456', 'root', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://localhost:3306/db_ejpa_example_1?characterEncoding=utf8&useSSL=false', 'DEFAULT', '默认租户1'),
	(2,'123456', 'root', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://localhost:3306/db_ejpa_example_2?characterEncoding=utf8&useSSL=false', 'DEFAULT', '租户2'),
	(3,'123456', 'root', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://localhost:3306/db_ejpa_example_3?characterEncoding=utf8&useSSL=false', 'DEFAULT', '租户3');

-- 使用租户2
USE `db_ejpa_example_2`;
-- 创建学生表，表定义和上面是一样的
CREATE TABLE IF NOT EXISTS `student` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '姓名',
  `age` INT(11) NOT NULL COMMENT '年龄',
  `birthday` DATE NULL DEFAULT NULL COMMENT '生日',
  `sex` INT(11) NOT NULL COMMENT '性别',
  `email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '邮件',
  `hobby` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '爱好',
  `height` DOUBLE NULL DEFAULT NULL COMMENT '身高',
  `remark` varchar(1024) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updater_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_zh_0900_as_cs;

-- 使用租户3
USE `db_ejpa_example_3`;
-- 创建学生表，表定义和上面是一样的
CREATE TABLE IF NOT EXISTS `student` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '姓名',
  `age` INT(11) NOT NULL COMMENT '年龄',
  `birthday` DATE NULL DEFAULT NULL COMMENT '生日',
  `sex` INT(11) NOT NULL COMMENT '性别',
  `email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '邮件',
  `hobby` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_zh_0900_as_cs' COMMENT '爱好',
  `height` DOUBLE NULL DEFAULT NULL COMMENT '身高',
  `remark` varchar(1024) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updater_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_zh_0900_as_cs;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
