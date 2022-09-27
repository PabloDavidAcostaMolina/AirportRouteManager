-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: vuelafacildb
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `idairport` int NOT NULL AUTO_INCREMENT,
  `airport` varchar(45) NOT NULL,
  `idcity` int NOT NULL,
  PRIMARY KEY (`idairport`,`idcity`),
  KEY `fk_airport_city_idx` (`idcity`),
  CONSTRAINT `fk_airport_city` FOREIGN KEY (`idcity`) REFERENCES `city` (`idcity`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (2,'Santiago Pérez Quiroz',2),(5,'Antonio Roldán Betancourt',1),(7,'Prueba',14);
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `idbooking` int NOT NULL AUTO_INCREMENT,
  `bookingdate` datetime NOT NULL,
  `seatcat` int DEFAULT NULL,
  `iduser` int NOT NULL,
  `idstatus` int NOT NULL,
  `idflight` int NOT NULL,
  PRIMARY KEY (`idbooking`,`iduser`,`idstatus`,`idflight`),
  KEY `fk_booking_user1_idx` (`iduser`),
  KEY `fk_booking_status1_idx` (`idstatus`),
  KEY `fk_booking_flight1_idx` (`idflight`),
  CONSTRAINT `fk_booking_flight1` FOREIGN KEY (`idflight`) REFERENCES `flight` (`idflight`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_booking_status1` FOREIGN KEY (`idstatus`) REFERENCES `status` (`idstatus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_booking_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `idcity` int NOT NULL AUTO_INCREMENT,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`idcity`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Apartado'),(2,'Arauca'),(7,'Pereira'),(8,'Medellin'),(10,'Popayan'),(14,'cali');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `idflight` int NOT NULL AUTO_INCREMENT,
  `flightdate` datetime NOT NULL,
  `paxcapacity` int DEFAULT NULL,
  `avlseat` int DEFAULT NULL,
  `idroute` int NOT NULL,
  PRIMARY KEY (`idflight`,`idroute`),
  KEY `fk_flight_route1_idx` (`idroute`),
  CONSTRAINT `fk_flight_route1` FOREIGN KEY (`idroute`) REFERENCES `route` (`idroute`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restriction`
--

DROP TABLE IF EXISTS `restriction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restriction` (
  `idrestriction` int NOT NULL,
  `restrictiondesc` varchar(45) NOT NULL,
  PRIMARY KEY (`idrestriction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restriction`
--

LOCK TABLES `restriction` WRITE;
/*!40000 ALTER TABLE `restriction` DISABLE KEYS */;
/*!40000 ALTER TABLE `restriction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `idroute` int NOT NULL AUTO_INCREMENT,
  `deptime` datetime NOT NULL,
  `arrtime` datetime NOT NULL,
  `flighttime` varchar(45) NOT NULL,
  `idcityorg` int NOT NULL,
  `idairportorg` int NOT NULL,
  `idairportdest` int NOT NULL,
  `idcitydest` int NOT NULL,
  PRIMARY KEY (`idroute`,`idcityorg`,`idairportorg`,`idairportdest`,`idcitydest`),
  KEY `fk_route_city1_idx` (`idcityorg`),
  KEY `fk_route_airport1_idx` (`idairportorg`),
  KEY `fk_route_airport2_idx` (`idairportdest`),
  KEY `fk_route_city2_idx` (`idcitydest`),
  CONSTRAINT `fk_route_airport1` FOREIGN KEY (`idairportorg`) REFERENCES `airport` (`idairport`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_route_airport2` FOREIGN KEY (`idairportdest`) REFERENCES `airport` (`idairport`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_route_city1` FOREIGN KEY (`idcityorg`) REFERENCES `city` (`idcity`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_route_city2` FOREIGN KEY (`idcitydest`) REFERENCES `city` (`idcity`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `idstatus` int NOT NULL,
  `status` int NOT NULL,
  `idrestriction` int NOT NULL,
  PRIMARY KEY (`idstatus`,`idrestriction`),
  KEY `fk_status_restriction1_idx` (`idrestriction`),
  CONSTRAINT `fk_status_restriction1` FOREIGN KEY (`idrestriction`) REFERENCES `restriction` (`idrestriction`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `usertype` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16 11:21:25
