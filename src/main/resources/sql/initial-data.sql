# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.17)
# Database: test
# Generation Time: 2017-02-13 16:42:10 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Account`;

CREATE TABLE `Account` (
  `id` bigint(20) NOT NULL,
  `credentialsexpired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `expired` bit(1) NOT NULL,
  `locked` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;

INSERT INTO `Account` (`id`, `credentialsexpired`, `enabled`, `expired`, `locked`, `password`, `username`)
VALUES
	(1,b'0',b'1',b'0',b'0','$2a$06$gKFQfHYeoGPpXvya6dedeeAeQDt6rhbppyViI8JWjgB4HMJ0WNB0.','clint@');

/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Module
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Module`;

CREATE TABLE `Module` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Module` WRITE;
/*!40000 ALTER TABLE `Module` DISABLE KEYS */;

INSERT INTO `Module` (`id`, `description`, `name`)
VALUES
	(0,'dashboard','dashboard');

/*!40000 ALTER TABLE `Module` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Person
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Person`;

CREATE TABLE `Person` (
  `id` bigint(20) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;

INSERT INTO `Person` (`id`, `birthday`, `firstname`, `lastname`)
VALUES
	(1,NULL,'clint','atmo');

/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Privilege
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Privilege`;

CREATE TABLE `Privilege` (
  `id` bigint(20) NOT NULL,
  `canCreate` tinyint(4) NOT NULL,
  `canDelete` tinyint(4) NOT NULL,
  `canRead` tinyint(4) NOT NULL,
  `canUpdate` tinyint(4) NOT NULL,
  `component` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `module_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1hskxhgchqb0l2kmg1ocl3224` (`module_id`),
  CONSTRAINT `FK1hskxhgchqb0l2kmg1ocl3224` FOREIGN KEY (`module_id`) REFERENCES `Module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Privilege` WRITE;
/*!40000 ALTER TABLE `Privilege` DISABLE KEYS */;

INSERT INTO `Privilege` (`id`, `canCreate`, `canDelete`, `canRead`, `canUpdate`, `component`, `description`, `module_id`)
VALUES
	(1,1,1,1,1,NULL,'dashboard module',0);

/*!40000 ALTER TABLE `Privilege` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Role`;

CREATE TABLE `Role` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;

INSERT INTO `Role` (`id`, `description`, `name`)
VALUES
	(1,'USER','USER');

/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table roles_privileges
# ------------------------------------------------------------

DROP TABLE IF EXISTS `roles_privileges`;

CREATE TABLE `roles_privileges` (
  `role_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL,
  KEY `FKp0x1d9k5aksyqd1akwwfkh0ki` (`privilege_id`),
  KEY `FK2rfl694fu6ls2f2mqcxesqc6p` (`role_id`),
  CONSTRAINT `FK2rfl694fu6ls2f2mqcxesqc6p` FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`),
  CONSTRAINT `FKp0x1d9k5aksyqd1akwwfkh0ki` FOREIGN KEY (`privilege_id`) REFERENCES `Privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `roles_privileges` WRITE;
/*!40000 ALTER TABLE `roles_privileges` DISABLE KEYS */;

INSERT INTO `roles_privileges` (`role_id`, `privilege_id`)
VALUES
	(1,1);

/*!40000 ALTER TABLE `roles_privileges` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users_roles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa9r8g5hiyy57ts5u4tkf0lbab` (`role_id`),
  KEY `FKkicmw5uhbwhgixd7ee85ypuvf` (`user_id`),
  CONSTRAINT `FKa9r8g5hiyy57ts5u4tkf0lbab` FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`),
  CONSTRAINT `FKkicmw5uhbwhgixd7ee85ypuvf` FOREIGN KEY (`user_id`) REFERENCES `Account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;

INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES
	(1,1);

/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
