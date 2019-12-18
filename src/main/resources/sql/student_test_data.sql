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


-- 导出 db_ejpa_example 的数据库结构
CREATE DATABASE IF NOT EXISTS `db_ejpa_example` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_ejpa_example`;

-- 导出  表 db_ejpa_example.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '????',
  `creator_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '???',
  `remark` varchar(1024) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '??',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '????',
  `updater_num` varchar(32) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL COMMENT '???',
  `age` int(11) NOT NULL,
  `birthday` date DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL,
  `hobby` varchar(255) COLLATE utf8mb4_zh_0900_as_cs DEFAULT NULL,
  `height` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_zh_0900_as_cs;

-- 正在导出表  db_ejpa_example.student 的数据：~4 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `create_time`, `creator_num`, `remark`, `update_time`, `updater_num`, `age`, `birthday`, `name`, `sex`, `email`, `hobby`, `height`) VALUES
	(1, '2019-12-09 14:49:04', NULL, NULL, '2019-12-18 17:30:52', NULL, 34, '1984-10-15', 'joy chuo', 1, NULL, '篮球', 150),
	(2, '2019-12-09 14:49:59', NULL, NULL, '2019-12-18 17:30:57', NULL, 45, '1978-10-15', 'tim chuo', 1, NULL, '足球', 165),
	(3, '2019-12-09 14:50:39', NULL, NULL, '2019-12-18 17:31:03', NULL, 30, '1978-07-15', 'jimmy blue', 1, NULL, '乒乓球', 170),
	(4, '2019-12-09 14:51:00', NULL, NULL, '2019-12-18 17:31:09', NULL, 30, '1978-07-15', 'cammny white', 1, NULL, '台球', 180);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
