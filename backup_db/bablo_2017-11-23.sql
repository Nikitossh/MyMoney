-- MySQL dump 10.14  Distrib 5.5.56-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: bablo
-- ------------------------------------------------------
-- Server version	5.5.56-MariaDB

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
-- Table structure for table `budget`
--

DROP TABLE IF EXISTS `budget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budget` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `amount` int(8) unsigned NOT NULL,
  `comment` varchar(255) NOT NULL DEFAULT '',
  `category_id` smallint(5) unsigned DEFAULT NULL,
  `date_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_budget_category` (`category_id`),
  KEY `FK_budget_date` (`date_id`),
  CONSTRAINT `FK_budget_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_budget_date` FOREIGN KEY (`date_id`) REFERENCES `date` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget`
--

LOCK TABLES `budget` WRITE;
/*!40000 ALTER TABLE `budget` DISABLE KEYS */;
INSERT INTO `budget` VALUES (6,0,'noAlcohol',10,137),(7,17000,'repairGBC',2,137),(8,800,'phoneInet',6,137),(9,0,'nothing',11,137),(10,3000,'fatherAndMother',8,137),(11,16500,'rentBills',4,137),(12,5000,'food',1,137),(13,1000,'medicine',3,137),(14,3000,'allOther',7,137),(15,3300,'boxingAndSwimming',5,137),(16,500,'taxi',9,137);
/*!40000 ALTER TABLE `budget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `category` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (10,'alcohol'),(2,'car'),(6,'communications'),(11,'face'),(8,'family'),(4,'flat'),(1,'food'),(3,'health'),(7,'other'),(5,'sport'),(9,'transport');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costs`
--

DROP TABLE IF EXISTS `costs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `value` int(8) unsigned NOT NULL,
  `comment` varchar(255) NOT NULL DEFAULT '',
  `category_id` smallint(5) unsigned DEFAULT NULL,
  `date_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_costs_category` (`category_id`),
  KEY `FK_costs_date` (`date_id`),
  CONSTRAINT `FK_costs_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_costs_date` FOREIGN KEY (`date_id`) REFERENCES `date` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=298 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costs`
--

LOCK TABLES `costs` WRITE;
/*!40000 ALTER TABLE `costs` DISABLE KEYS */;
INSERT INTO `costs` VALUES (1,300,'taxi',9,2),(2,300,'bathhouse',3,2),(3,210,'vodka',10,2),(4,70,'snack',1,2),(5,90,'chocolate',1,2),(6,300,'barbershop',11,2),(7,420,'fruit',1,3),(8,150,'vegetables',1,3),(9,184,'sweet',1,3),(10,168,'coffee',1,3),(11,300,'semifinished',1,3),(12,257,'toothbrush and toothpaste',3,3),(13,5000,'dentist',3,4),(14,78,'water',1,3),(15,300,'boxing',5,5),(16,60,'water',1,5),(17,50,'food',1,6),(18,18,'water',1,6),(19,300,'fuel',2,6),(20,220,'beer, cafe',10,7),(21,680,'cafe',1,7),(22,200,'taxi',9,7),(23,270,'bathhouse',3,8),(24,350,'waterpool',5,8),(25,150,'cafe',1,8),(26,50,'fruit',1,8),(27,250,'vodka',10,8),(28,480,'food',1,8),(29,160,'toy for Elisey',7,8),(30,13100,'rent',4,8),(31,500,'fuel',2,9),(32,300,'boxing',5,10),(33,93,'beer',10,10),(34,85,'fruit',1,10),(35,195,'water',1,10),(36,150,'food',1,11),(37,47,'chemical',4,11),(38,100,'beer',10,11),(39,136,'sweet',1,12),(40,200,'smoke',7,12),(41,300,'fuel',2,13),(42,320,'bathhouse',3,13),(43,350,'waterpool',5,13),(44,150,'snack',1,13),(45,137,'food',1,13),(46,144,'vegetables',1,13),(47,56,'chicken',1,13),(48,270,'fruits',1,13),(49,184,'fish',1,13),(50,150,'beer',10,13),(51,129,'chemical',4,13),(52,104,'bic',11,13),(53,1054,'beer',10,14),(54,798,'tequila',10,14),(55,500,'fuel',2,14),(56,420,'flowers',7,14),(57,27,'food',1,15),(58,250,'parking',2,15),(59,250,'phone',6,16),(60,160,'food',1,16),(61,60,'chicken',1,16),(62,259,'vodka',10,17),(63,168,'fruit',1,17),(64,350,'swimming',5,18),(65,270,'bathhouse',3,18),(66,160,'present',7,18),(67,260,'vodka',10,18),(68,30,'food',1,19),(69,120,'smoke',7,19),(70,620,'film',7,19),(71,760,'cafe',7,19),(72,220,'water',7,19),(73,450,'flower',7,19),(74,110,'metro',9,20),(75,110,'metro',9,21),(76,110,'metro',9,22),(77,55,'metro',9,23),(78,23,'bus',9,20),(79,82,'bus',9,20),(80,23,'bus',9,23),(81,100,'snack',1,20),(82,500,'aeroexpress',9,23),(83,40,'coffee',1,20),(84,90,'beer',10,20),(85,35,'vegetables',1,20),(86,70,'food',1,20),(87,500,'funeral',7,24),(88,500,'fuel',2,24),(89,350,'swimming',5,24),(90,790,'food',1,24),(91,70,'beer',10,24),(92,30,'water',1,24),(93,533,'beer',10,25),(94,465,'smoke',7,25),(95,80,'smoke',7,25),(96,2000,'father',8,1),(97,4500,'bills',4,1),(98,400,'internet',6,1),(99,260,'vodka',10,26),(100,115,'present',7,26),(130,2000,'father',8,32),(131,420,'fruits and bread',1,32),(133,20,'bublegum',1,34),(134,500,'cinema',7,34),(135,890,'icecream_cinema',7,34),(136,210,'water_cinema',7,34),(138,160,'taxi_home-SBS',9,34),(139,1500,'manual therapist',3,36),(140,150,'coffee',1,37),(141,1090,'bike service',5,38),(142,350,'swimming',5,38),(143,244,'snack',1,38),(144,270,'bathhouse',3,38),(145,65,'alcohol',10,38),(146,250,'alcohol',10,38),(147,210,'sweet',1,38),(148,590,'shefflera',7,38),(149,460,'beer',10,39),(150,100,'beer',10,39),(151,160,'sweet',1,39),(152,100,'bus',9,39),(154,27,'bread',1,44),(155,90,'beer',10,44),(156,485,'forCleaning',4,36),(157,240,'vodka',10,36),(160,240,'foods',1,36),(162,300,'mobile',6,32),(163,4800,'bills',4,32),(164,127,'forShefflera',7,56),(165,305,'vodkaAndBeer',10,56),(166,144,'shave',11,56),(167,210,'food',1,56),(168,240,'food',1,60),(169,120,'food',1,60),(170,1006,'food',1,62),(174,170,'taxi',9,62),(175,280,'vizit',7,62),(176,350,'swimming',5,68),(177,370,'bathhouse',3,68),(178,250,'?????',1,68),(179,60,'beer',10,68),(180,375,'food',1,72),(181,211,'food',1,73),(182,690,'fruits',1,73),(183,350,'beer',10,73),(184,300,'boxing',5,76),(185,150,'food',1,76),(186,300,'underpants',11,78),(187,1380,'viski',10,79),(188,230,'toothbrush',11,79),(189,430,'food',1,79),(190,11110,'rent',4,82),(191,70,'water',1,82),(192,150,'mobile',6,82),(193,250,'vodka',10,82),(194,2300,'battery',2,82),(195,350,'swimming',5,82),(196,300,'vizitNazar',7,88),(197,310,'spray',3,89),(198,275,'coffee',7,89),(200,805,'food',1,91),(201,16080,'repair',2,92),(202,800,'fuel',2,92),(203,30,'bread',1,92),(204,330,'lightAndMop',4,95),(205,51,'toothpaste',11,95),(206,1320,'food',1,95),(207,485,'fishing',7,98),(208,300,'snack',1,99),(209,700,'cafe',7,99),(210,350,'swimming',5,95),(211,320,'bathhouse',3,95),(212,3206,'bills',4,103),(213,2020,'father',8,103),(214,2000,'mother',8,103),(215,2200,'concert',7,103),(217,930,'food',1,103),(218,1526,'trainToSochi',7,109),(219,609,'hotelSochi',7,109),(220,100,'tosol',2,109),(221,229,'food',1,109),(222,500,'dendrariySochi',7,113),(223,150,'transportSochi',7,113),(224,420,'MacDonalds',1,113),(225,500,'sunglases',11,116),(226,500,'teaAsPresent',7,116),(227,1350,'foodInSochi',1,116),(228,352,'food',1,116),(229,300,'phone',6,120),(230,375,'rightSmoke',7,116),(231,295,'food',1,120),(232,515,'food',1,123),(233,165,'snack',1,124),(234,500,'fuel',2,109),(235,500,'fuel',2,126),(236,1600,'Abrau-Durso',7,127),(237,500,'rightSmoke',7,127),(238,1500,'presents',7,127),(239,220,'cheese',1,127),(240,170,'food',1,128),(241,250,'wash',2,129),(242,700,'fuel',2,129),(243,520,'fodd',1,129),(244,60,'shampoo',11,129),(245,334,'bike',NULL,129),(246,600,'food',1,134),(247,600,'TheProdigy',7,134),(248,1250,'HBKolyan',7,136),(249,280,'food',1,137),(250,200,'things',4,138),(251,1461,'food',1,138),(252,13130,'rent',4,140),(253,80,'food',1,141),(254,180,'presentVisitNazar',7,142),(255,900,'cafe',1,143),(256,500,'boxing',5,144),(257,200,'phone',6,140),(258,1000,'tooth',3,126),(259,350,'swimming',5,140),(260,300,'dinner',1,140),(263,1495,'',10,145),(264,700,'fuel',2,145),(265,850,'phone and internet',6,145),(266,4020,'mother and father',8,145),(267,2930,'bills',4,145),(268,4658,'',1,145),(269,382,'medicine',3,145),(270,1115,'HB Elisey and smoke',7,145),(271,12780,'X-fit',5,145),(272,800,'beer',10,154),(273,110,'smoke',7,155),(274,101,'shop',1,155),(275,1100,'cafe',1,154),(276,4600,'relaXXX',7,154),(277,290,'bathhouse',3,154),(278,400,'taxi',9,154),(279,50,'shop',1,161),(280,250,'shop',1,162),(281,12780,'x-fit',5,163),(282,2230,'HB_NatlyYork',7,164),(283,1000,'fuel',2,165),(284,737,'stuff IKEA',4,165),(285,172,'cafe',1,165),(286,350,'shop',1,165),(287,260,'chemistry',4,165),(288,220,'stuff',4,165),(289,2360,'curtains',4,165),(290,520,'flowers',4,165),(291,550,'shop',1,165),(292,530,'bathhouse',3,174),(293,290,'shop',1,174),(294,90,'medicine',3,174),(295,65,'shop',1,177),(296,33,'shop',1,177),(297,50,'shop',1,179);
/*!40000 ALTER TABLE `costs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date`
--

DROP TABLE IF EXISTS `date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `date` (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date`
--

LOCK TABLES `date` WRITE;
/*!40000 ALTER TABLE `date` DISABLE KEYS */;
INSERT INTO `date` VALUES (1,'2017-03-10'),(2,'2017-03-11'),(3,'2017-03-12'),(4,'2017-03-14'),(5,'2017-03-15'),(6,'2017-03-17'),(7,'2017-03-18'),(8,'2017-03-19'),(9,'2017-03-20'),(10,'2017-03-22'),(11,'2017-03-23'),(12,'2017-03-24'),(13,'2017-03-25'),(14,'2017-03-26'),(15,'2017-03-27'),(16,'2017-03-28'),(17,'2017-03-30'),(18,'2017-04-01'),(19,'2017-04-02'),(20,'2017-04-03'),(21,'2017-04-04'),(22,'2017-04-05'),(23,'2017-04-06'),(24,'2017-04-07'),(25,'2017-04-08'),(26,'2017-04-09'),(32,'2017-04-10'),(34,'2017-04-11'),(36,'2017-04-13'),(37,'2017-04-14'),(38,'2017-04-15'),(39,'2017-04-16'),(41,'2017-04-17'),(44,'2017-04-18'),(56,'2017-04-19'),(60,'2017-04-20'),(62,'2017-04-21'),(68,'2017-04-22'),(72,'2017-04-23'),(73,'2017-04-25'),(76,'2017-04-26'),(79,'2017-04-27'),(78,'2017-04-28'),(82,'2017-04-29'),(88,'2017-04-30'),(89,'2017-05-01'),(91,'2017-05-02'),(92,'2017-05-04'),(95,'2017-05-06'),(98,'2017-05-08'),(99,'2017-05-09'),(103,'2017-05-10'),(109,'2017-05-12'),(113,'2017-05-13'),(116,'2017-05-14'),(120,'2017-05-15'),(123,'2017-05-16'),(124,'2017-05-17'),(126,'2017-05-18'),(127,'2017-05-19'),(128,'2017-05-20'),(129,'2017-05-21'),(137,'2017-05-22'),(134,'2017-05-23'),(136,'2017-05-24'),(138,'2017-05-25'),(144,'2017-05-26'),(143,'2017-05-27'),(142,'2017-05-28'),(141,'2017-05-29'),(140,'2017-05-30'),(145,'2017-11-01'),(154,'2017-11-12'),(155,'2017-11-13'),(161,'2017-11-14'),(163,'2017-11-15'),(162,'2017-11-16'),(164,'2017-11-17'),(174,'2017-11-18'),(165,'2017-11-19'),(177,'2017-11-20'),(179,'2017-11-21');
/*!40000 ALTER TABLE `date` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-23  0:00:01
