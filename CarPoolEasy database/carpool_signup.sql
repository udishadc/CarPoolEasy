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
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `idsignup` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `emailID` varchar(45) NOT NULL,
  PRIMARY KEY (`idsignup`,`firstname`,`lastname`,`emailID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES (59,'Udisha ','Dutta Chowdhury','udishaduttachowdhury@gmail.com'),(60,'Pooja','kanna','udishaduttachowdhury@yahoo.com'),(61,'u','s','udishaduttachowdhury@gmail.com'),(62,'Udisha','d','s'),(63,'u','s','udishaduttachowdhury@gmail.com'),(64,'u','s','udishaduttachowdhury@gmail.com'),(65,'Udisha','Dutta Chowdhury','udishaduttachowdhury@gmail.com'),(66,'Udisha','Dutta Chowdhury','udishaduttachowdhury@gmail.com'),(67,'Udisha','Dutta Chowdhury','udishaduttachowdhury@gmail.com'),(68,'Udisha ','Dutta Chowdhury','udishaduttachowdhury@gmail.com'),(69,'Udisha ','Dutta Chowdhury','udishaduttachowdhury@gmail.com'),(70,'Udisha','Dutta Chowdhury','duttachowdhury.u@northeastern.edu'),(71,'Udisha','Dutta Chowdhury','duttachowdhury.u@northeastern.edu'),(72,'Udisha','Dutta Chowdhury','duttachowdhury.u@northeastern.edu'),(73,'Udisha','Dutta Chowdhury','duttachowdhury.u@northeastern.edu'),(74,'Udisha','Dutta Chowdhury','udishaduttachowdhury@gmail.com'),(75,'u','d','duttachowdhury.u@northeastern.edu'),(76,'u','d','udishaduttachowdhury@gmail.com'),(77,'u','d','duttachowdhury.u@northeastern.edu'),(78,'h','s','duttachowdhury.u@northeastern.edu');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
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
