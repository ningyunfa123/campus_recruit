# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: db_equipment
# Generation Time: 2018-05-23 10:29:46 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table equ_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `equ_user`;

CREATE TABLE `equ_user` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `newpassword` varchar(255) DEFAULT NULL,
  `roleName` varchar(20) DEFAULT '用户' COMMENT '管理员、使用者、维护者',
  `trueName` varchar(20) DEFAULT NULL COMMENT '用户名字',
  `deptName` varchar(20) DEFAULT NULL COMMENT '部门名称',
  `createId` int(5) DEFAULT NULL COMMENT '创建人ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `repwdTime` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `activeCode` varchar(255) DEFAULT NULL COMMENT '激活验证码',
  `status` int(11) DEFAULT NULL COMMENT '0 未激活 1 已激活 2 此前注册的用户，特殊处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `equ_user` WRITE;
/*!40000 ALTER TABLE `equ_user` DISABLE KEYS */;

INSERT INTO `equ_user` (`id`, `userName`, `password`, `newpassword`, `roleName`, `trueName`, `deptName`, `createId`, `createTime`, `repwdTime`, `phone`, `activeCode`, `status`)
VALUES
	(2,'aa','aa',NULL,'维修者','小张','维修部',1,'2017-05-03 09:58:26',NULL,'18722348797',NULL,2),
	(6,'admin','666',NULL,'管理员','赵总','行政部',1,'2017-05-05 15:12:28',NULL,'18723400983',NULL,2),
	(7,'bb','bb',NULL,'用户','刘师傅','仓储部',6,'2017-05-05 15:13:56',NULL,'18766664444',NULL,2),
	(8,'S','S',NULL,'Admin','S',NULL,7,NULL,NULL,NULL,NULL,2),
	(9,'asdfasdf','asdfasdfsad',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:15:56',NULL,NULL,NULL,2),
	(10,'asdfasdfa','sdfasdfsa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:16:42',NULL,NULL,NULL,2),
	(11,'asdfasdfa','sdfasdfas',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:16:59',NULL,NULL,NULL,2),
	(12,'sdfasda','asdfdasdfsa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:23:51',NULL,NULL,NULL,2),
	(13,'asdfasdf','sdfasdfa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:23:58',NULL,NULL,NULL,2),
	(14,'dd','dd',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:25:42',NULL,NULL,NULL,2),
	(15,'aaa','aaaaa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:28:08',NULL,NULL,NULL,2),
	(16,'sdasdfasd','asdfdsafa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:28:34',NULL,NULL,NULL,2),
	(17,'safasd','asdfsasd',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:29:36',NULL,NULL,NULL,2),
	(18,'sasas','ASDas',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:31:14',NULL,NULL,NULL,2),
	(19,'SDSAD','ASD',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:31:30',NULL,NULL,NULL,2),
	(20,'asdfasdf','asdfasdfsa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:35:36',NULL,NULL,NULL,2),
	(21,'asdfasdfad','asdfasdfsdf',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:35:44',NULL,NULL,NULL,2),
	(22,'asdfasf','asdfsasadfa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:47:06',NULL,NULL,NULL,2),
	(23,'asdfsafs','sadfsadf',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:47:12',NULL,NULL,NULL,2),
	(27,'qqqq','qqqqq',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:51:49',NULL,NULL,NULL,2),
	(28,'qqqq','qqq',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:51:58',NULL,NULL,NULL,2),
	(29,'sdfasda','asdfasdf',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:57:09',NULL,NULL,NULL,2),
	(30,'asdfasdfas','asdfadsfsdfsa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 19:12:31',NULL,NULL,NULL,2),
	(31,'asdfasdfsadf','asdfasdfsaf',NULL,'用户',NULL,NULL,NULL,'2017-08-20 19:12:36',NULL,NULL,NULL,2),
	(35,'123@1231','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-20 21:36:16',NULL,NULL,NULL,2),
	(36,'123@1231','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-20 21:38:40',NULL,NULL,NULL,2),
	(37,'123@1231','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-20 21:41:07',NULL,NULL,NULL,2),
	(38,'123@124','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-20 21:51:48',NULL,NULL,NULL,2),
	(44,'345@345','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-21 07:27:59',NULL,NULL,NULL,2),
	(45,'123@123','123','12','鐢ㄦ埛',NULL,NULL,NULL,'2017-08-21 07:28:29','2017-09-20 17:34:57',NULL,NULL,2),
	(46,'123@123','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-21 08:26:24',NULL,NULL,NULL,2),
	(47,'guest','guest',NULL,'guest',NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),
	(48,'123@123','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-21 09:40:03',NULL,NULL,NULL,2),
	(49,'123@123','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-21 09:40:10',NULL,NULL,NULL,2),
	(50,'sdasdfasd','asdfdsafa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:28:34',NULL,NULL,NULL,2),
	(51,'safasd','asdfsasd',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:29:36',NULL,NULL,NULL,2),
	(52,'sasas','ASDas',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:31:14',NULL,NULL,NULL,2),
	(53,'SDSAD','ASD',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:31:30',NULL,NULL,NULL,2),
	(54,'asdfasdf','asdfasdfsa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:35:36',NULL,NULL,NULL,2),
	(55,'asdfasdfad','asdfasdfsdf',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:35:44',NULL,NULL,NULL,2),
	(56,'asdfasf','asdfsasadfa',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:47:06',NULL,NULL,NULL,2),
	(119,'qqw','qqq',NULL,'用户',NULL,NULL,NULL,'2017-08-20 18:51:33',NULL,NULL,NULL,2),
	(120,'456@456','456',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-23 00:51:25',NULL,NULL,NULL,2),
	(121,'456@456','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-23 00:52:43',NULL,NULL,NULL,2),
	(122,'234@234','234',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-08-23 00:56:22',NULL,NULL,NULL,2),
	(136,'2342@123','123',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-09-20 13:17:07',NULL,NULL,'a75cbe81fb7d0a3586957ac7385df63c',2),
	(137,'234234@12','1',NULL,'鐢ㄦ埛',NULL,NULL,NULL,'2017-09-20 13:17:39',NULL,NULL,'8b471aade4468c4c7a886d6494e87e9c',2),
	(142,'ewwqe@23','sdf',NULL,'user',NULL,NULL,NULL,'2017-09-20 17:24:41',NULL,NULL,'741505899481638f615058994816383c1505899481638f21505899481638fb15058994816383a1505899481638d815058994816382615058994816389b1505899481638a41505899481638f715058994816383a1505899481638be15058994816387015058994816385a1505899481638b91505899481638',2),
	(149,'wangcheng2234@163.com','163',NULL,'user',NULL,NULL,NULL,'2017-09-20 21:07:27',NULL,NULL,'ff6fda913f0d3a500469ec3d4bcb83711505912847881',0),
	(153,'877217445@qq.com','2234','2234','user',NULL,NULL,NULL,'2017-09-20 21:19:33','2017-09-20 21:20:58',NULL,'6b67e01c8c67f67a6d1fdbe0dcb34b101505913669953',1);

/*!40000 ALTER TABLE `equ_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_company
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_company`;

CREATE TABLE `user_company` (
  `user_id` int(11) unsigned NOT NULL,
  `cpy_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0' COMMENT '投递状态 0 未投递 1已投 2 没兴趣'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_company` WRITE;
/*!40000 ALTER TABLE `user_company` DISABLE KEYS */;

INSERT INTO `user_company` (`user_id`, `cpy_id`, `status`)
VALUES
	(2,1,0),
	(6,6,0),
	(7,7,0),
	(8,1,0),
	(2,6,0),
	(6,7,0),
	(7,1,1),
	(8,6,1),
	(2,7,1),
	(6,19,1),
	(7,20,1),
	(8,21,0),
	(2,23,0),
	(6,24,0),
	(7,25,0),
	(8,26,1),
	(2,27,0),
	(7,28,0),
	(6,1,1),
	(8,6,1),
	(2,7,0),
	(6,0,0),
	(0,0,0),
	(10,1,0),
	(7,6,0),
	(7,19,0),
	(7,24,0),
	(7,22,0),
	(47,1,0),
	(47,19,1),
	(8,7,2),
	(8,59,2),
	(8,19,2),
	(8,20,2),
	(8,22,2),
	(8,23,2),
	(8,24,2),
	(8,56,2),
	(7,21,2),
	(7,23,2),
	(7,56,2),
	(7,58,2),
	(7,57,2),
	(7,59,2),
	(7,61,2),
	(7,68,0),
	(7,60,2),
	(8,25,2),
	(8,69,0),
	(8,68,2),
	(8,60,2),
	(8,63,2),
	(8,65,2),
	(8,67,2),
	(8,66,2),
	(8,71,0),
	(8,64,1),
	(45,72,1),
	(45,73,0),
	(45,19,2),
	(45,20,1),
	(45,74,0),
	(45,75,1),
	(45,76,1),
	(45,77,1),
	(45,78,1),
	(7,79,0),
	(7,80,0),
	(45,87,0),
	(35,19,1),
	(45,59,1),
	(45,21,0),
	(45,22,1),
	(45,23,0),
	(45,24,1),
	(45,25,0),
	(45,88,0),
	(45,89,0),
	(45,90,0),
	(45,91,0),
	(45,92,0),
	(45,26,2),
	(45,60,2),
	(45,56,2),
	(45,63,2),
	(45,64,1),
	(45,65,0),
	(45,85,1),
	(45,93,0),
	(45,94,0),
	(45,95,1),
	(45,96,1),
	(45,97,0),
	(45,66,0),
	(45,67,1),
	(45,71,1),
	(45,69,0),
	(45,68,1),
	(45,83,1),
	(45,86,0),
	(45,81,1),
	(45,98,0),
	(45,82,2),
	(45,21,2),
	(45,21,2),
	(45,20,2),
	(45,77,2),
	(45,84,2),
	(45,21,2),
	(45,21,2),
	(45,20,2),
	(45,21,2),
	(45,21,2),
	(45,21,2),
	(45,21,2),
	(45,21,2),
	(45,21,2),
	(45,20,2),
	(45,21,2),
	(45,23,2),
	(45,23,2),
	(45,20,2),
	(45,20,2),
	(45,77,2),
	(45,20,2),
	(45,20,2),
	(45,20,2),
	(45,25,2),
	(45,90,2),
	(45,89,2),
	(45,88,2),
	(45,92,2),
	(45,95,2),
	(45,98,2);

/*!40000 ALTER TABLE `user_company` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
