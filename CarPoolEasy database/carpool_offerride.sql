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
-- Table structure for table `offerride`
--

DROP TABLE IF EXISTS `offerride`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offerride` (
  `idofferride` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `pickup_location` varchar(45) DEFAULT NULL,
  `drop_location` varchar(45) DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `Time` varchar(45) DEFAULT NULL,
  `seats` varchar(45) NOT NULL,
  `price` varchar(45) DEFAULT NULL,
  `Distance` double DEFAULT NULL,
  `traveltime` double DEFAULT NULL,
  PRIMARY KEY (`idofferride`,`seats`),
  UNIQUE KEY `idofferride_UNIQUE` (`idofferride`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offerride`
--

LOCK TABLES `offerride` WRITE;
/*!40000 ALTER TABLE `offerride` DISABLE KEYS */;
INSERT INTO `offerride` VALUES (0000000001,'Boston','Ca','2023-12-07','00:00','q','1',NULL,NULL),(0000000002,'Boston ','Cambridge','2023-12-06','04:03','1','2',NULL,NULL),(0000000003,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-07','04:09','2','50',NULL,NULL),(0000000004,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-14','07:08','2','3',NULL,NULL),(0000000005,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-07','04:03','3','2',NULL,NULL),(0000000006,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-07','04:03','3','2',NULL,NULL),(0000000007,'Boston','cambridge','2023-12-14','11:09','3','4',NULL,NULL),(0000000008,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-14','11:04','32','2',NULL,NULL),(0000000009,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-13','05:03','2','3',1.380686362,8),(0000000010,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-20','13:03','5','6',1.476998867,9),(0000000011,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-14','12:03','5','4',1.380686362,8),(0000000012,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-14','05:03','4','6',1.476998867,9),(0000000013,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-14','04:10','5','2',1.476998867,9),(0000000014,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-21','04:10','5','2',1.476998867,9),(0000000015,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-14','04:04','2','3',1.476998867,9),(0000000016,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-19','06:30','4','20',1.380686362,8),(0000000017,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-21','04:10','2','25',1.380686362,8),(0000000018,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-21','04:10','2','25',1.380686362,8),(0000000019,'29 Queensberry St, Boston MA, 02215','Northeastern University, Boston','2023-12-21','04:10','4','20',1.127166994,6),(0000000020,'29 Queensberry St, Boston, MA, 02215','360 Huntington Ave, Boston, MA 02115','2023-12-21','04:10','2','2',1.380686362,8);
/*!40000 ALTER TABLE `offerride` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-09 20:57:02
