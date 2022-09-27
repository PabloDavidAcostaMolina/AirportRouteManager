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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16 11:19:06
