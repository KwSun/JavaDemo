-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: webclass
-- ------------------------------------------------------
-- Server version	5.6.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) DEFAULT NULL,
  `adminPwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `新建索引` (`adminName`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Kw','Kw');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classmate`
--

DROP TABLE IF EXISTS `classmate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classmate` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` bigint(20) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `sname` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` tinyint(3) DEFAULT NULL,
  `qq` varchar(30) DEFAULT NULL,
  `msn` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `dormitory` varchar(10) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `新建索引` (`sno`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classmate`
--

LOCK TABLES `classmate` WRITE;
/*!40000 ALTER TABLE `classmate` DISABLE KEYS */;
INSERT INTO `classmate` VALUES (1,20121346002,'20121346002','孔炜',22,1,'1023519351','1023519351','13813015558','213','1433990433295.jpg'),(2,20121346005,'20121346005','王忠亚',22,1,'123456789','123456789','15123232323','','1433990368465.jpg'),(3,20121346020,'20121346020','张玉洁',22,0,'599356909','599356909','15415544474','527','1433990797627.jpg'),(4,20121346023,'20121346023','周彤彤',22,0,'125658552','125658552','12556225566','527','1433990884255.jpg'),(5,20121346024,'20121346024','胡啸',22,0,'125556556','125556556','12522552255','527','1433990921482.jpg'),(11,20121376034,'20121376034','盛艺暄',22,0,'475390362','475390362','13987654367','527','1433990161521.jpeg');
/*!40000 ALTER TABLE `classmate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `pubdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `typid` int(11) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (64,'write java','write java','2015-06-11 02:25:31',2,'盛艺暄'),(65,'We will meet~','&#26399;&#26411;&#32771;&#35797;~','2015-06-11 03:10:04',1,'Kw'),(62,'&#27605;&#19994;&#23395;','&#23398;&#38271;&#23398;&#22992;&#27605;&#19994;&#24555;&#20048;','2015-06-05 06:57:47',1,'Kw');
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `afrom` bigint(20) DEFAULT NULL,
  `ato` bigint(20) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `sendTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `isRead` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `to` (`ato`),
  KEY `from` (`afrom`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (10,20121346005,20121376034,'记得写实验报告','2015-06-04 10:52:24',NULL),(9,20121376034,20121346005,'haha','2015-06-02 07:47:18',NULL),(8,20121346002,20121376034,'记得来上课','2015-06-02 07:41:10',NULL),(1,20121346002,20121346005,'测试','2015-05-31 16:00:00',1),(11,20121346002,20121346005,'记得吃饭','2015-06-05 04:07:48',NULL),(12,20121346002,20121346005,'亚哥，记得来上课','2015-06-11 01:24:46',NULL),(13,20121346005,20121376034,'你好，我是王中亚','2015-06-11 02:24:41',NULL),(14,20121346005,20121346002,'炜哥，记得带点好吃的~','2015-06-11 03:01:01',NULL);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `uploadDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (20,'kola','','2015-05-26 00:20:58','1401063658957.jpg'),(21,'','','2014-05-26 00:21:19','1401063679470.jpg'),(22,'','','2015-06-11 02:49:22','1433990962631.jpeg'),(23,'','','2015-06-11 02:50:39','1433991039312.jpeg'),(24,'','','2015-06-11 02:53:02','1433991182346.jpg'),(25,'','','2015-06-11 02:53:02','1433991182351.jpg'),(26,'','','2015-06-11 02:53:02','1433991182356.jpg');
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) DEFAULT '还未设置状态',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sno` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `sno` (`sno`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'最新状态','2014-12-01 10:18:35',20073001268),(2,'貌似还可以','2014-11-28 15:32:30',20073001237),(5,'还未设置','2014-11-28 14:57:55',20073001255),(6,'??zz','2014-05-12 02:39:45',20073001234),(7,'d?','2014-05-12 02:40:08',20073001234),(8,'?','2014-05-26 00:15:06',20073001234),(9,'hello','2014-05-26 00:15:15',20073001234),(10,'','2015-06-01 07:42:45',20121308003),(11,'我是谁？','2015-06-01 07:58:14',20121308003),(12,'帅锅一枚','2015-06-01 08:27:40',20121308003),(13,'帅锅','2015-06-01 08:46:07',20121308003),(14,'smile','2015-06-02 05:08:39',20121346005),(15,'haha','2015-06-02 05:08:46',20121346005),(16,'girl~','2015-06-02 05:12:26',20121376034);
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'学院通知'),(2,'班级通知');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-11 11:15:03
