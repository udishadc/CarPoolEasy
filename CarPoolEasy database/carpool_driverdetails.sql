-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: carpool
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `driverdetails`
--

DROP TABLE IF EXISTS `driverdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driverdetails` (
  `iddriverdetails` int NOT NULL AUTO_INCREMENT,
  `DriverLicense` varchar(45) NOT NULL,
  `OwnerName` varchar(45) NOT NULL,
  `OwnerEmail` varchar(45) NOT NULL,
  `CarName` varchar(45) NOT NULL,
  `ModelName` varchar(45) NOT NULL,
  `CarColor` varchar(45) NOT NULL,
  `Modelyear` varchar(45) NOT NULL,
  `SeatNumber` varchar(45) NOT NULL,
  `drivercontact` varchar(45) NOT NULL,
  PRIMARY KEY (`iddriverdetails`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driverdetails`
--

LOCK TABLES `driverdetails` WRITE;
/*!40000 ALTER TABLE `driverdetails` DISABLE KEYS */;
INSERT INTO `driverdetails` VALUES (3,'dhh','udisha','udishaduttachowdhury@gmail.com','jjk','l','o','m','n',''),(4,'ABC123','John Doe','john.doe@example.com','Toyota Camry','Sedan','Blue','2023','4','1234567890'),(5,'r','e','udishaduttachowdhury@yahoo.com','u','d','s','s','s','t'),(6,'123','Pooja','udishaduttachowdhury@gmail.com','Merc','Bui','red','1999','4','9901295285'),(7,'dhiwd','Pooja','udishaduttachowdhury@gmail.com','merc','Yuua','Red','1999','2','99012862'),(8,'2','3','udishaduttachowdhury@yahoo.com','q','w','1','e','r','1');
/*!40000 ALTER TABLE `driverdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-09 20:57:03
