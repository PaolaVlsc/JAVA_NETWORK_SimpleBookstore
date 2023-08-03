CREATE DATABASE  IF NOT EXISTS `bookstore_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bookstore_db`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore_db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(250) NOT NULL,
  `author` varchar(70) NOT NULL,
  `isbn` bigint NOT NULL,
  `publisher` varchar(70) DEFAULT NULL,
  `bookEdition` int NOT NULL,
  `category` varchar(70) DEFAULT NULL,
  `bookPages` int DEFAULT NULL,
  `price` decimal(8,2) NOT NULL,
  `noOfCopiesStatus` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77016 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (77005,'JAVA for everyone','Nikitas Karanikolas',9789607235022,'New Tech Pub',1,'Programming',510,22.40,199),(77006,'Computer Networking: A Top-Down Approach','James Kurose',9780132856201,'Pearson',7,'Computer Networking',832,171.60,96),(77007,'Fundamentals of Database Systems','Ramez Elmasri',9780133971224,'Pearson',7,'Database',1280,186.65,64),(77008,'Java Network Programming','Elliotte Rusty Harold',9781449357672,'OReilly Media',4,'Programming',506,32.87,29),(77009,'Introduction to Algorithms','Thomas H. Cormen ',9780262033848,'MIT Press',3,'Computer Algorithms',1292,80.83,60),(77010,'Algorithm Design','Jon Kleinberg',9780321295354,'Pearson',1,'Computer Algorithms',864,167.54,25),(77011,'Data Structures and Algorithms in Java','Robert Lafore',9780672324536,'Sams Publishing',2,'Data Structure and Algorithms',800,36.64,36),(77012,'The C++ Programming Language','Bjarne Stroustrup',9780321563842,'Addison-Wesley Professional',4,'Programming',1376,54.99,175),(77013,'Modern Operating Systems','Andrew Tanenbaum',9780133591620,'Pearson',4,'Computer Operating Systems Theory',1136,166.80,111),(77014,'Operating System Concepts','Abraham Silberschatz',9781118063330,'Wiley',9,'Computer Operating Systems Theory',976,192.92,231),(77015,'\'Discrete Mathematics and Its Applications','Kenneth Rosen',9780073383095,'McGraw-Hill Education',7,'Applied Mathematics',1072,183.99,2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-21 23:14:21
