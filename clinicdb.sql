CREATE DATABASE  IF NOT EXISTS `clinicdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clinicdb`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `appointment_date` datetime DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `medicalappointment_date` datetime DEFAULT NULL,
  `prescription_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `sickperson_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `per_idx` (`prescription_id`),
  KEY `user_idx` (`doctor_id`),
  KEY `sick_idx` (`sickperson_id`),
  KEY `nu_idx` (`nurse_id`),
  CONSTRAINT `doc` FOREIGN KEY (`doctor_id`) REFERENCES `user` (`id`),
  CONSTRAINT `nu` FOREIGN KEY (`nurse_id`) REFERENCES `user` (`id`),
  CONSTRAINT `per` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`),
  CONSTRAINT `sick` FOREIGN KEY (`sickperson_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (5,'2023-07-15 09:00:00',1,'2023-08-18 09:00:00',16,2,5,4),(8,'2023-08-24 09:00:00',1,'2023-09-08 16:36:38',51,2,6,4),(12,'2023-08-11 10:00:00',1,'2023-10-09 16:30:03',1,2,6,4),(13,'2023-08-22 11:00:00',1,'2023-08-31 16:55:05',1,2,6,4),(14,'2023-08-27 12:00:00',1,'2023-10-06 15:27:11',1,2,6,4),(16,'2023-08-25 12:30:00',1,'2023-10-09 23:21:28',28,2,6,4),(17,'2023-08-23 11:30:00',1,'2023-10-10 11:29:43',29,2,6,4),(18,'2023-08-10 14:00:00',1,'2023-10-09 22:49:37',30,2,6,4),(19,'2023-09-09 08:00:00',1,'2023-10-10 11:34:29',30,2,6,2),(20,'2023-09-14 12:00:00',1,'2023-10-10 11:46:01',32,2,6,4),(21,'2023-09-05 17:30:00',1,'2023-10-10 12:06:26',74,2,6,4),(22,'2023-03-05 17:30:00',1,'2023-10-10 23:19:42',35,2,6,4),(23,'2023-08-26 08:30:00',1,'2023-10-11 00:16:47',34,2,6,4),(24,'2023-08-18 14:30:00',1,'2023-10-14 13:15:07',36,2,6,4),(25,'2023-08-09 08:30:00',1,NULL,37,2,6,4),(26,'2023-08-24 09:30:00',1,'2023-09-10 14:23:56',47,2,6,4),(27,'2023-08-09 10:00:00',1,NULL,39,2,6,4),(28,'2023-08-17 13:00:00',1,NULL,41,2,6,4),(29,'2023-08-17 11:00:00',1,NULL,42,2,6,4),(30,'2023-08-10 13:30:00',1,NULL,43,2,6,4),(31,'2023-08-26 11:00:00',1,NULL,46,2,6,4),(32,'2023-04-09 12:00:00',1,NULL,46,2,6,2),(33,'2023-08-25 15:00:00',1,NULL,46,2,6,4),(34,'2023-08-10 08:00:00',1,NULL,46,2,6,4),(43,'2023-09-12 11:30:00',1,'2023-10-05 01:43:52',55,2,32,35),(44,'2023-11-18 07:00:00',1,NULL,55,2,32,4),(45,'2023-12-24 20:00:00',1,NULL,55,2,32,4),(46,'2023-05-12 10:00:00',1,NULL,55,2,33,4),(47,'2023-09-11 00:00:00',1,NULL,55,2,33,4),(48,'2023-09-11 00:00:00',1,'2023-09-12 11:27:11',58,2,34,4),(49,'2023-09-11 08:00:00',1,'2023-09-11 17:11:32',56,2,34,35),(52,'2023-09-12 00:00:00',1,'2023-09-12 11:26:18',57,2,38,4),(53,'2023-09-12 16:00:00',1,'2023-09-29 11:56:48',59,2,38,35),(55,'2023-09-12 00:00:00',1,'2023-10-12 12:49:41',59,2,33,4),(56,'2023-09-12 20:30:00',1,NULL,59,2,33,4),(61,'2023-10-11 09:00:00',1,NULL,64,2,6,4),(64,'2023-10-01 09:00:00',0,NULL,67,NULL,6,NULL),(65,'2023-10-01 09:00:00',0,NULL,68,NULL,6,NULL),(66,'2023-10-01 09:00:00',0,NULL,69,NULL,6,NULL),(67,'2023-10-01 09:00:00',0,NULL,70,NULL,6,NULL),(68,'2023-10-01 09:00:00',0,NULL,71,NULL,6,NULL),(69,'2023-10-01 09:00:00',0,NULL,72,NULL,6,NULL),(70,'2023-10-01 09:00:00',0,NULL,71,NULL,6,NULL),(71,'2023-10-01 09:00:00',0,NULL,72,NULL,6,NULL),(72,'2023-10-01 09:00:00',0,NULL,71,NULL,2,NULL),(73,'2023-10-01 09:00:00',0,NULL,72,NULL,2,NULL),(74,'2023-10-10 10:00:00',1,NULL,73,2,6,4),(75,'2023-10-06 16:00:00',1,NULL,73,2,6,4),(77,'2023-10-19 14:30:00',1,'2023-10-12 12:40:27',76,2,53,4),(78,'2023-10-10 00:00:00',1,NULL,77,2,53,4),(80,'2023-10-14 12:00:00',1,NULL,79,2,6,4);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `appo_id` int DEFAULT NULL,
  `pay_id` int DEFAULT NULL,
  `pay_money` int DEFAULT NULL,
  `tienkham` int DEFAULT '100000',
  PRIMARY KEY (`id`),
  KEY `apo_idx` (`appo_id`),
  KEY `pay_idx` (`pay_id`),
  KEY `kham_idx` (`tienkham`),
  CONSTRAINT `apo` FOREIGN KEY (`appo_id`) REFERENCES `appointment` (`id`),
  CONSTRAINT `kham` FOREIGN KEY (`tienkham`) REFERENCES `tienkham` (`id`),
  CONSTRAINT `pay` FOREIGN KEY (`pay_id`) REFERENCES `payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (2,33,1,1200410,1),(6,22,2,100000,1),(8,8,1,1300015,1),(18,43,2,3160000,1),(19,49,1,11222000,1),(20,52,3,2155000,1),(21,48,3,855000,1),(22,53,3,11720000,1),(23,13,2,11720000,1),(24,21,2,824000,1),(25,20,1,922000,1),(26,23,3,711000,NULL),(27,77,NULL,NULL,NULL);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `describe` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Khoa Tim Mạch',' Khoa tim mạch chuyên về chẩn đoán, điều trị và quản lý các bệnh tim mạch. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực tim mạch và cung cấp các dịch vụ y tế liên quan như kiểm tra tim, siêu âm tim, xét nghiệm máu, và các phương pháp can thiệp tim mạch.'),(2,'Khoa Xương Khớp','Khoa Xương Khớp chuyên về chẩn đoán, điều trị và quản lý các bệnh và vấn đề liên quan đến hệ thống xương và khớp. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực xương khớp và cung cấp các dịch vụ y tế như chẩn đoán bệnh, điều trị thuốc, phục hồi chức năng, và phẫu thuật xương khớp.'),(3,'Khoa Thần Kinh','Khoa Thần kinh chuyên về chẩn đoán, điều trị và quản lý các bệnh và rối loạn về hệ thống thần kinh. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực thần kinh và cung cấp các dịch vụ y tế như chẩn đoán bệnh, điều trị thuốc, phục hồi chức năng, và các phương pháp can thiệp thần kinh.'),(4,'Khoa Tiêu Hóa','Khoa Tiêu hóa chuyên về chẩn đoán, điều trị và quản lý các bệnh và rối loạn về hệ tiêu hóa. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực tiêu hóa và gan mật, cung cấp các dịch vụ y tế như chẩn đoán bệnh, điều trị thuốc, can thiệp nội soi và phẫu thuật tiêu hóa.'),(5,'Khoa Phụ Sản','Khoa Phụ sản chuyên về chẩn đoán, điều trị và quản lý các vấn đề liên quan đến sức khỏe sinh sản của phụ nữ. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực phụ sản, cung cấp các dịch vụ y tế như khám bệnh, chẩn đoán, điều trị, theo dõi thai kỳ, quản lý sản khoa và chăm sóc sau sinh.'),(6,'Khoa Da Liễu','Khoa Da Liễu chuyên về chẩn đoán, điều trị và quản lý các vấn đề liên quan đến da, tóc, và móng. Khoa này có đội ngũ bác sĩ da liễu và nhân viên chuyên gia trong lĩnh vực da liễu, cung cấp các dịch vụ y tế như khám bệnh, chẩn đoán, điều trị và theo dõi các bệnh lý da.'),(7,'Nhi Khoa','Khoa Nhi chuyên về chẩn đoán, điều trị và quản lý các vấn đề sức khỏe của trẻ em. Khoa này có đội ngũ bác sĩ nhi khoa và nhân viên chuyên gia trong lĩnh vực nhi khoa, cung cấp các dịch vụ y tế như khám bệnh, chẩn đoán, điều trị, theo dõi sự phát triển và sức khỏe tổng thể của trẻ em.');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `provider` varchar(45) DEFAULT NULL,
  `production_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `id_unit` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `unit_idx` (`id_unit`),
  CONSTRAINT `unit` FOREIGN KEY (`id_unit`) REFERENCES `unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'Paracetamol',110000.50,'JAPAN','2023-10-08','2024-10-08',2,97),(2,'Amoxicillin',200000.00,'KOREA','2023-10-08','2024-10-08',2,202),(8,'Thuốc cảm',120000.00,'VIETNAM','2023-08-17','2023-09-17',3,274),(18,'Thuốc nhứt đầu',123000.00,'123123','1111-11-11','1111-11-22',2,7),(19,'Thuốc chống óii',10000000.00,'VIETNAM','2023-08-28','2023-08-29',6,997),(22,'Vitamin A',10000.00,'VIETNAM','2023-08-31','2023-10-08',1,190),(23,'Vitamin B',11000.00,'VIETNAM','2023-08-28','2023-10-08',1,195),(24,'Vitamin C',12000.00,'VIETNAM','2023-08-22','2023-10-20',1,94);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `payment_method` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'TIỀN MẶT'),(2,'MOMO'),(3,'PayPal'),(4,'CASD');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prescription_date` datetime DEFAULT NULL,
  `prescriptioncol` varchar(45) DEFAULT NULL,
  `symptom` varchar(45) DEFAULT NULL,
  `conclusion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'2023-10-09 16:29:05','1','thanh cong di ma','Prescribed painkillers.'),(2,'2023-07-15 16:24:23','Prescription A','Fever, cough','Advised to gargle with warm water.'),(3,NULL,NULL,NULL,NULL),(4,'2023-08-02 00:00:00','Prescription B','Headache','Prescribed painkillers.'),(5,'2023-08-03 00:00:00','Prescription C','Sore throat','Advised to gargle with warm water.'),(6,'2023-08-04 00:00:00','Prescription D','Allergies','Recommended antihistamines.'),(15,'2023-08-24 00:00:00','1','cáº£m','ho hen'),(16,'2023-08-24 00:00:00','1','cáº£m','ho hen'),(17,'2023-08-24 00:00:00','1','cáº£m','ho hen'),(19,'2023-08-24 00:00:00','1','cáº£m','ho hen'),(22,'2023-08-24 00:00:00','1','cáº£m láº¡nh','ho hen'),(26,'2023-08-25 00:00:00','1','cáº£m láº¡nh','ho hen'),(27,'2023-08-25 00:00:00','1','cáº£m','ho hen'),(28,'2023-10-09 23:21:05','1','benh cam','ho hen'),(29,'2023-10-10 11:16:34','1','benh cam','ho hen'),(30,'2023-10-10 11:30:35','1','benh cam','ho hen'),(31,'2023-08-25 00:00:00','1','cáº£m','ho hen'),(32,'2023-10-10 11:45:42','1','benh cam','ho hen'),(33,'2023-08-25 00:00:00','1','cáº£m','ho hen'),(34,'2023-10-10 23:38:22','1','benh cam','ho hen'),(35,'2023-10-10 22:41:07','1','benh cam','ho hen'),(36,'2023-10-14 13:05:24','1','benh cam','ho hen'),(37,'2023-08-26 00:00:00','1','cáº£m láº¡nh','ho hen'),(38,'2023-08-26 00:00:00','1','cáº£m','ho hen'),(39,'2023-08-27 00:00:00','1','cáº£m','ho hen'),(40,'2023-08-27 00:00:00','1','cáº£m láº¡nh','ho hen'),(41,'2023-08-27 00:00:00','1','cáº£m láº¡nh','ho hen'),(42,'2023-08-28 00:00:00','1','cáº£m','ho hen'),(43,'2023-08-30 00:00:00','1','cáº£m láº¡nh','ho hen'),(44,'2023-08-31 00:00:00','1','cáº£m láº¡nh','ho hen'),(46,'2023-09-06 00:00:00','1','cáº£m láº¡nh','ho hen'),(47,'2023-09-08 00:00:00','1','suy giam the luc','ho hen va nhay mui'),(48,'2023-09-08 00:00:00','1','suy giam the luc','ho hen va nhay mui'),(49,'2023-09-08 00:00:00','1','nhá»©t Äáº§u','há»c java'),(50,'2023-09-08 00:00:00','1','cáº£m','ho hen'),(51,'2023-09-08 00:00:00','1','mÃ¨o xinh','mÃ¨o'),(52,'2023-09-10 00:00:00','1','cáº£m láº¡nh','ho hen'),(55,'2023-09-11 00:00:00','1','ViÃªn Phá»i','Ho ÄÃªm nhiá»u ngÃ y'),(56,'2023-09-11 00:00:00','1','suy giam the luc','Hen xuyen, nhut dau'),(57,'2023-09-12 00:00:00','1','cáº£m','ho hen va nhay mui'),(58,'2023-09-12 00:00:00','1','cam lanh','ho hen va nhay mui'),(59,'2023-10-12 12:49:22','1','cam benh','há»c java'),(60,NULL,NULL,NULL,'nhut dau du lam'),(61,NULL,NULL,NULL,'nhut dau du lam'),(62,NULL,NULL,NULL,'nhut dau du lam'),(63,NULL,NULL,NULL,'nhut dau du lam'),(64,NULL,NULL,NULL,'nhut dau du lam'),(65,NULL,NULL,NULL,'nhut dau du lam'),(66,NULL,NULL,NULL,'nhut dau du lam'),(67,NULL,NULL,NULL,'nhut dau du lam'),(68,NULL,NULL,NULL,'nhut dau du lam'),(69,NULL,NULL,NULL,'nhut dau du lam'),(70,NULL,NULL,NULL,'nhut dau du lam'),(71,NULL,NULL,NULL,'nhut dau du lam'),(72,NULL,NULL,NULL,'THANHC ONG DI MA'),(73,'2023-10-02 01:21:41','1','benh thiet oi','thanh cong di'),(74,'2023-10-10 00:00:00','1','cáº£m láº¡nh','ho hen'),(75,NULL,NULL,NULL,'nhut dau'),(76,'2023-10-12 12:39:38','1','benh cam','nhut dau'),(77,NULL,NULL,NULL,'sot, so mui'),(78,NULL,NULL,NULL,'cho toi thanh cong di'),(79,NULL,NULL,NULL,'test');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_item`
--

DROP TABLE IF EXISTS `prescription_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prescription_id` int DEFAULT NULL,
  `medicine_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `instructions` text,
  PRIMARY KEY (`id`),
  KEY `prescription_item_ibfk_1` (`prescription_id`),
  KEY `prescription_item_ibfk_2` (`medicine_id`),
  CONSTRAINT `prescription_item_ibfk_1` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`),
  CONSTRAINT `prescription_item_ibfk_2` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_item`
--

LOCK TABLES `prescription_item` WRITE;
/*!40000 ALTER TABLE `prescription_item` DISABLE KEYS */;
INSERT INTO `prescription_item` VALUES (3,2,1,30,'Uống mỗi ngày một viên'),(5,1,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(6,1,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(7,1,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(8,NULL,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(9,NULL,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(10,29,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(11,30,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(12,31,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(13,32,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(14,33,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(16,35,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(17,35,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(18,35,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(19,35,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(20,37,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(21,37,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(27,39,8,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(28,39,2,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(29,39,8,2,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(30,39,8,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(33,38,1,2,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(34,38,18,2,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(35,38,8,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(36,43,8,5,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(37,43,1,5,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(38,44,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(41,38,8,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(42,38,8,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(43,38,8,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(44,38,8,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(48,46,8,3,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(55,51,19,NULL,''),(56,51,1,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(57,51,1,NULL,''),(60,47,1,NULL,''),(61,47,1,NULL,''),(62,47,1,NULL,''),(63,48,18,2,''),(64,48,1,1,''),(65,48,1,NULL,''),(66,48,1,NULL,''),(69,55,1,6,'Uá»ng sau khi Än 30 phÃºt'),(70,55,2,6,'Han Che uong nuoc lanh'),(71,56,1,1,'u'),(72,56,19,1,'uá»ng má»i ngÃ y 1 viÃªn'),(73,56,24,1,'uá»ng má»i ngÃ y 1 viÃªn'),(74,57,8,5,'uong moi buoi sang 1 vien'),(75,57,23,5,'uong truoc khi ngu'),(76,58,23,5,'an uong day du va uong truoc 30p'),(77,59,19,1,'uá»ng vÃ o buá»i sÃ¡ng hÃ´m sau'),(78,59,8,1,'Uá»ng sau khi Än 30 phÃºt'),(79,55,1,1,'thanh cong'),(86,1,1,1,'thu nghiem'),(87,1,22,5,'moi ngay uong mot vien'),(88,30,24,1,'moi ngay uong mot vien'),(89,30,23,1,'moi ngay uong mot vien'),(90,28,22,1,'moi ngay uong mot vien'),(91,28,19,1,'moi ngay uong mot vien'),(92,28,2,1,'moi ngay uong mot vien'),(93,29,8,1,'moi ngay uong mot vien'),(94,29,24,1,'moi ngay uong mot vien'),(95,29,24,1,'moi ngay uong mot vien'),(96,29,24,1,'moi ngay uong mot vien'),(97,29,24,1,'moi ngay uong mot vien'),(98,29,24,1,'moi ngay uong mot vien'),(99,30,22,1,'moi ngay uong mot vien'),(100,30,24,1,'moi ngay uong mot vien'),(101,32,24,1,'moi ngay uong mot vien'),(102,74,24,1,'uong'),(103,74,24,1,'uong truoc khi ngu'),(104,35,23,1,'moi ngay uong mot vien'),(105,35,24,2,'moi ngay uong mot vien'),(106,35,23,2,'moi ngay uong mot vien'),(107,35,22,2,'moi ngay uong mot vien'),(108,35,22,1,'moi ngay uong mot vien'),(109,35,24,2,'moi ngay uong mot vien'),(110,35,24,1,'moi ngay uong mot vien'),(114,34,23,1,'moi ngay uong mot vien'),(115,76,18,1,'moi ngay uong mot vien'),(116,76,18,1,'moi ngay uong mot vien'),(118,76,18,1,'moi ngay uong mot vien'),(119,76,18,1,'moi ngay uong mot vien'),(125,59,24,1,'moi ngay uong mot vien'),(128,36,1,1,'moi ngay uong mot vien');
/*!40000 ALTER TABLE `prescription_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES (1,'Tien si',500000),(2,'Thac si',300000),(3,'Bac si',150000);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(45) DEFAULT NULL,
  `rating_date` date DEFAULT NULL,
  `point` int DEFAULT NULL,
  `phieukham_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `phieu_idx` (`phieukham_id`),
  CONSTRAINT `phieukham` FOREIGN KEY (`phieukham_id`) REFERENCES `appointment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,'Kham tot lam!','2023-08-10',3,33),(2,'thanh cong','2023-09-25',2,22),(3,'thanh cong mới','2023-09-25',5,43),(4,'123','2023-10-08',4,20),(5,'Khám rất tốt','2023-10-15',3,53);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_DOCTOR'),(3,'ROLE_NURSE'),(4,'ROLE_SICKPERSON');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_detail`
--

DROP TABLE IF EXISTS `schedule_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule_detail` (
  `date_schedule` date DEFAULT NULL,
  `shift_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `SHI_idx` (`shift_id`),
  KEY `user_idx` (`user_id`),
  CONSTRAINT `SHI` FOREIGN KEY (`shift_id`) REFERENCES `shift` (`id`),
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=813 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_detail`
--

LOCK TABLES `schedule_detail` WRITE;
/*!40000 ALTER TABLE `schedule_detail` DISABLE KEYS */;
INSERT INTO `schedule_detail` VALUES ('2023-10-14',2,4,1,1),('2023-10-15',3,4,2,1),('2023-10-15',3,2,3,1),('2023-10-14',2,2,4,1),('2023-09-03',1,2,5,1),('2023-08-30',1,2,6,1),('2023-08-25',1,2,7,1),('2023-08-29',1,2,8,1),('2023-08-29',1,2,9,1),('2023-09-03',1,2,10,1),('2023-08-29',1,3,11,1),('2023-09-02',1,3,12,1),('2023-11-18',1,3,13,1),('2023-09-03',1,2,14,1),('2023-08-30',1,2,15,1),('2023-09-08',1,2,16,1),('2023-10-04',2,2,24,1),('2023-10-04',3,2,26,1),('2023-10-05',3,2,27,1),('2023-09-10',3,2,28,0),('2023-09-04',3,2,31,0),('2023-09-06',2,2,35,0),('2023-09-07',3,2,36,0),('2023-09-06',3,2,37,0),('2023-09-10',3,2,39,1),('2023-09-10',2,2,40,1),('2023-09-06',3,2,43,0),('2023-09-08',3,2,44,1),('2023-09-06',3,2,46,0),('2023-09-07',3,2,47,0),('2023-09-06',3,2,49,0),('2023-09-08',3,2,50,1),('2023-09-06',2,2,51,0),('2023-09-07',2,2,52,0),('2023-09-08',2,2,53,1),('2023-09-04',1,2,54,0),('2023-09-05',1,2,55,0),('2023-09-04',2,2,56,0),('2023-09-09',1,2,57,1),('2023-09-09',2,2,58,1),('2023-09-09',3,2,59,1),('2023-09-28',1,4,60,1),('2023-09-09',2,4,61,1),('2023-09-09',3,4,62,1),('2023-08-30',3,2,63,0),('2023-08-30',3,2,64,0),('2023-09-04',2,2,65,0),('2023-09-05',2,2,66,0),('2023-09-06',2,2,67,0),('2023-09-04',1,2,68,0),('2023-09-05',1,2,69,0),('2023-09-04',2,2,70,0),('2023-09-09',3,3,72,1),('2023-09-10',3,3,73,1),('2023-09-04',1,2,76,0),('2023-09-05',1,2,77,0),('2023-09-06',1,2,78,0),('2023-09-07',1,2,79,0),('2023-09-08',1,2,80,0),('2023-09-09',1,2,81,1),('2023-09-10',1,2,82,0),('2023-09-04',1,2,83,0),('2023-09-05',2,4,84,0),('2023-09-05',1,4,85,0),('2023-09-05',3,4,86,0),('2023-09-06',2,4,87,0),('2023-09-17',1,2,88,1),('2023-09-15',2,2,89,1),('2023-09-16',2,2,90,1),('2023-09-30',1,4,91,1),('2023-09-13',1,4,92,1),('2023-09-11',2,4,93,1),('2023-09-12',2,4,94,1),('2023-09-27',2,2,95,1),('2023-09-27',1,2,96,1),('2023-09-11',1,2,97,1),('2023-09-12',1,2,98,1),('2023-09-13',1,2,99,1),('2023-09-14',1,2,100,1),('2023-09-15',1,2,101,1),('2023-09-16',1,2,102,1),('2023-09-17',1,2,103,1),('2023-09-11',2,2,104,1),('2023-09-12',2,2,105,1),('2023-09-13',2,2,106,1),('2023-09-14',2,2,107,1),('2023-09-15',2,2,108,1),('2023-09-16',2,2,109,1),('2023-09-17',2,2,110,1),('2023-09-11',3,2,111,1),('2023-09-12',3,2,112,1),('2023-09-13',3,2,113,1),('2023-09-14',3,2,114,1),('2023-09-15',3,2,115,1),('2023-09-16',3,2,116,1),('2023-09-17',3,2,117,1),('2023-09-12',3,2,120,1),('2023-09-14',1,4,121,1),('2023-09-14',2,4,122,1),('2023-09-12',1,2,124,0),('2023-09-14',1,2,126,0),('2023-09-15',1,2,127,0),('2023-09-16',1,2,128,0),('2023-09-17',1,2,129,0),('2023-09-11',2,2,130,0),('2023-09-12',2,2,131,0),('2023-09-13',2,2,132,0),('2023-09-14',2,2,133,0),('2023-09-15',2,2,134,0),('2023-09-16',2,2,135,0),('2023-09-17',2,2,136,0),('2023-09-11',3,2,137,0),('2023-05-12',3,2,138,1),('2023-09-13',3,2,139,1),('2023-09-14',3,2,140,1),('2023-09-15',3,2,141,1),('2023-10-01',2,3,142,1),('2023-10-01',1,3,143,1),('2023-09-11',1,4,144,0),('2023-09-29',1,4,145,1),('2023-09-12',3,4,146,1),('2023-09-12',2,4,147,1),('2023-09-15',1,4,148,0),('2023-09-16',1,4,149,0),('2023-09-17',1,4,150,0),('2023-09-11',2,4,151,0),('2023-09-12',2,4,152,0),('2023-09-13',2,4,153,0),('2023-09-14',2,4,154,0),('2023-09-15',2,4,155,0),('2023-09-16',2,4,156,0),('2023-09-17',2,4,157,0),('2023-09-11',3,4,158,0),('2023-09-12',3,4,159,0),('2023-09-13',3,4,160,0),('2023-09-14',3,4,161,0),('2023-09-15',3,4,162,0),('2023-09-16',3,4,163,0),('2023-09-17',3,4,164,0),('2023-09-18',1,2,165,1),('2023-09-21',3,2,182,1),('2023-09-23',3,2,184,1),('2023-09-24',3,2,185,1),('2023-09-12',1,2,186,0),('2023-09-18',2,2,187,0),('2023-09-18',3,2,188,0),('2023-09-18',1,2,189,0),('2023-09-19',1,2,190,1),('2023-09-18',2,2,191,1),('2023-09-19',2,2,192,0),('2023-09-19',1,4,194,1),('2023-09-20',1,4,195,1),('2023-09-21',1,4,196,1),('2023-09-22',1,4,197,1),('2023-09-23',1,4,198,1),('2023-09-24',1,4,199,1),('2023-09-18',2,4,200,0),('2023-09-19',2,4,201,0),('2023-09-20',2,4,202,0),('2023-09-21',2,4,203,0),('2023-09-22',2,4,204,0),('2023-09-23',2,4,205,0),('2023-09-24',2,4,206,0),('2023-09-18',3,4,207,0),('2023-09-19',3,4,208,0),('2023-09-20',3,4,209,1),('2023-09-21',3,4,210,0),('2023-09-22',3,4,211,0),('2023-09-23',3,4,212,0),('2023-09-24',3,4,213,0),('2023-09-18',1,4,214,0),('2023-09-18',2,4,215,0),('2023-09-18',3,4,216,0),('2023-09-18',1,3,217,0),('2023-09-19',1,3,218,0),('2023-09-20',1,3,219,0),('2023-09-18',2,3,220,1),('2023-09-19',2,3,221,0),('2023-09-20',2,3,222,1),('2023-09-18',3,3,223,0),('2023-09-19',3,3,224,0),('2023-09-20',3,3,225,0),('2023-09-19',1,3,226,1),('2023-09-19',2,3,227,1),('2023-09-19',3,3,228,1),('2023-09-18',1,5,229,1),('2023-09-19',1,5,230,1),('2023-09-18',2,5,231,1),('2023-09-19',2,5,232,0),('2023-09-18',3,5,233,0),('2023-09-19',3,5,234,0),('2023-09-18',1,5,235,0),('2023-09-18',2,5,236,1),('2023-09-18',3,5,237,1),('2023-09-18',1,2,238,1),('2023-09-19',2,2,239,0),('2023-09-18',1,36,258,0),('2023-09-19',1,36,259,0),('2023-09-20',1,36,260,0),('2023-09-21',1,36,261,0),('2023-09-22',1,36,262,0),('2023-09-11',2,36,263,1),('2023-09-24',1,36,264,0),('2023-09-18',2,36,265,0),('2023-09-19',2,36,266,0),('2023-09-20',2,36,267,0),('2023-09-21',2,36,268,0),('2023-09-22',2,36,269,0),('2023-09-23',2,36,270,0),('2023-09-24',2,36,271,0),('2023-09-18',3,36,272,0),('2023-09-19',3,36,273,0),('2023-09-20',3,36,274,0),('2023-09-21',3,36,275,0),('2023-09-22',3,36,276,0),('2023-09-23',3,36,277,0),('2023-09-24',3,36,278,0),('2023-09-18',1,37,279,0),('2023-09-19',1,37,280,0),('2023-09-20',1,37,281,1),('2023-09-21',1,37,282,0),('2023-09-22',1,37,283,0),('2023-09-23',1,37,284,0),('2023-09-24',1,37,285,0),('2023-09-18',2,37,286,0),('2023-09-19',2,37,287,1),('2023-09-20',2,37,288,1),('2023-09-21',2,37,289,1),('2023-09-22',2,37,290,1),('2023-09-23',2,37,291,1),('2023-09-24',2,37,292,1),('2023-09-18',3,37,293,1),('2023-09-19',3,37,294,1),('2023-09-20',3,37,295,1),('2023-09-21',3,37,296,1),('2023-09-22',3,37,297,1),('2023-09-23',3,37,298,1),('2023-09-24',3,37,299,1),('2023-10-03',1,2,729,0),('2023-10-09',1,2,730,1),('2023-10-09',2,2,731,1),('2023-10-12',3,2,732,1),('2023-10-09',1,4,733,1),('2023-10-10',1,4,734,0),('2023-10-14',1,4,735,1),('2023-10-15',1,4,736,1),('2023-10-09',2,4,737,1),('2023-10-10',2,4,738,1),('2023-10-12',2,4,739,1),('2023-10-13',2,4,740,1),('2023-10-09',3,4,741,1),('2023-10-10',3,4,742,1),('2023-10-09',1,50,743,1),('2023-10-10',1,2,744,1),('2023-10-11',1,2,745,1),('2023-10-09',1,50,746,1),('2023-10-10',2,2,747,1),('2023-10-01',2,2,748,1),('2023-10-09',2,3,749,1),('2023-10-09',1,3,750,1),('2023-10-09',1,2,751,0),('2023-10-11',1,2,752,0),('2023-10-12',1,2,753,0),('2023-10-09',2,2,754,0),('2023-10-10',2,2,755,0),('2023-10-11',2,2,756,0),('2023-10-09',3,2,757,0),('2023-10-10',3,2,758,0),('2023-10-11',3,2,759,0),('2023-10-12',3,2,760,0),('2023-10-13',1,2,761,0),('2023-10-13',2,2,762,0),('2023-10-13',3,2,763,0),('2023-10-16',1,2,765,1),('2023-10-17',1,2,766,1),('2023-10-18',1,2,767,0),('2023-10-16',2,2,768,1),('2023-10-17',2,2,769,0),('2023-10-18',2,2,770,0),('2023-10-20',2,2,771,0),('2023-10-16',3,2,772,1),('2023-10-17',3,2,773,0),('2023-10-18',3,2,774,0),('2023-10-16',1,3,775,1),('2023-10-17',1,3,776,0),('2023-10-18',1,3,777,0),('2023-10-16',2,3,778,1),('2023-10-17',2,3,779,0),('2023-10-16',3,3,780,0),('2023-10-17',3,3,781,0),('2023-10-18',3,3,782,0),('2023-10-16',1,50,783,0),('2023-10-17',1,50,784,0),('2023-10-16',2,50,785,0),('2023-10-17',2,50,786,1),('2023-10-19',2,50,787,0),('2023-10-16',3,50,788,1),('2023-10-18',3,50,789,0),('2023-10-18',1,4,810,0),('2023-10-17',2,4,811,0),('2023-10-16',3,4,812,0);
/*!40000 ALTER TABLE `schedule_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'X-QUANG',500000),(2,'TỔNG QUÁT',1000000),(3,'XÉT NGHIỆM MÁU',200000),(4,'XÉT NGHIỆM ADN',400000);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_items`
--

DROP TABLE IF EXISTS `service_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_items` (
  `appo_id` int DEFAULT NULL,
  `date_ser` datetime DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `se_idx` (`service_id`),
  KEY `appo_idx` (`appo_id`),
  CONSTRAINT `appo` FOREIGN KEY (`appo_id`) REFERENCES `appointment` (`id`),
  CONSTRAINT `se` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_items`
--

LOCK TABLES `service_items` WRITE;
/*!40000 ALTER TABLE `service_items` DISABLE KEYS */;
INSERT INTO `service_items` VALUES (13,'2023-08-24 00:00:00',18,3),(13,'2023-08-24 00:00:00',19,2),(12,'2023-08-25 00:00:00',20,2),(22,'2023-08-24 00:00:00',31,2),(22,'2023-08-24 00:00:00',32,1),(32,'2023-09-08 00:00:00',43,3),(32,'2023-09-08 00:00:00',44,4),(26,'2023-09-08 00:00:00',45,3),(26,'2023-09-08 00:00:00',46,4),(26,'2023-09-08 00:00:00',47,4),(32,'2023-09-08 00:00:00',48,2),(32,'2023-09-08 00:00:00',49,3),(32,'2023-09-08 00:00:00',50,4),(34,'2023-09-08 00:00:00',51,1),(34,'2023-09-08 00:00:00',52,2),(34,'2023-09-08 00:00:00',53,3),(34,'2023-09-08 00:00:00',54,4),(33,'2023-09-10 00:00:00',58,2),(33,'2023-09-10 00:00:00',59,3),(43,'2023-09-11 00:00:00',62,2),(43,'2023-09-11 00:00:00',63,3),(49,'2023-09-11 00:00:00',64,2),(52,'2023-09-12 00:00:00',65,2),(52,'2023-09-12 00:00:00',66,3),(48,'2023-09-12 00:00:00',67,1),(53,'2023-09-29 00:00:00',68,1),(53,'2023-09-29 00:00:00',69,2),(75,'2023-10-02 01:21:41',70,2),(75,'2023-10-02 01:21:41',71,3),(12,'2023-10-06 01:13:36',72,1),(12,'2023-10-06 01:16:29',74,1),(12,'2023-10-06 01:16:29',75,2),(22,'2023-10-08 12:52:40',76,1),(22,'2023-10-08 12:52:40',77,2),(12,'2023-10-09 16:29:05',78,1),(12,'2023-10-09 16:29:05',79,2),(18,'2023-10-09 22:49:12',80,1),(18,'2023-10-09 22:49:12',81,2),(16,'2023-10-09 23:21:05',82,3),(16,'2023-10-09 23:21:05',83,4),(17,'2023-10-10 11:16:34',84,1),(17,'2023-10-10 11:16:34',85,3),(19,'2023-10-10 11:30:35',86,1),(19,'2023-10-10 11:30:35',87,3),(20,'2023-10-10 11:45:42',88,1),(21,'2023-10-10 00:00:00',89,1),(22,'2023-10-10 16:45:14',90,1),(22,'2023-10-10 22:41:07',91,3),(22,'2023-10-10 22:41:07',92,4),(23,'2023-10-10 23:38:22',93,4),(77,'2023-10-12 12:39:38',94,1),(77,'2023-10-12 12:39:38',95,3),(55,'2023-10-12 12:49:22',96,2),(24,'2023-10-14 12:33:47',97,1),(24,'2023-10-14 12:33:47',98,4),(24,'2023-10-14 12:40:41',99,1),(24,'2023-10-14 13:05:24',100,1);
/*!40000 ALTER TABLE `service_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift`
--

DROP TABLE IF EXISTS `shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shift` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `start` time DEFAULT NULL,
  `end` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift`
--

LOCK TABLES `shift` WRITE;
/*!40000 ALTER TABLE `shift` DISABLE KEYS */;
INSERT INTO `shift` VALUES (1,'Ca sáng','08:00:00','16:00:00'),(2,'Ca chiều','16:00:00','23:59:00'),(3,'Ca đêm','00:00:00','08:00:00');
/*!40000 ALTER TABLE `shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tienkham`
--

DROP TABLE IF EXISTS `tienkham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tienkham` (
  `id` int NOT NULL,
  `tienkham` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienkham`
--

LOCK TABLES `tienkham` WRITE;
/*!40000 ALTER TABLE `tienkham` DISABLE KEYS */;
INSERT INTO `tienkham` VALUES (1,100000);
/*!40000 ALTER TABLE `tienkham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'Hộp'),(2,'Viên'),(3,'Vỉ thuốc'),(4,'Gram'),(5,'Ống'),(6,'Gối');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `role_id` int NOT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `emaill` varchar(45) DEFAULT NULL,
  `dod` date DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `khoa_id` int DEFAULT NULL,
  `rank_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `role_idx` (`role_id`),
  KEY `khoa_idx` (`khoa_id`),
  KEY `rank_idx` (`rank_id`),
  CONSTRAINT `khoa` FOREIGN KEY (`khoa_id`) REFERENCES `department` (`id`),
  CONSTRAINT `rank` FOREIGN KEY (`rank_id`) REFERENCES `ranking` (`id`),
  CONSTRAINT `role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$12$m.6Wyu5HSAzwdv8RSQmxwuW24uapMoa8LPbrnCNZoaTkmE8yWsEyO',1,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691306503/avatar1.png','quanly','042302340243','123HCM123','123@123','2002-11-16','Nam',NULL,NULL),(2,'doctor1','$2a$12$S6GNLW60N031dXxU5wYnMesRp1A1/Uj1XJ6IvOE8xP5XAkz2uftmS',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691307639/avatar2.png','Nguyễn Văn A','001233012312','123ABC','123@123','1992-02-02','Nam',1,2),(3,'doctor2','$2a$12$ugHEVyKVH2nOSVjOQIeqGuEgEPsq0rhrgsz4OL8L0df84BIZG3i4y',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691307639/avatar2.png','Trịnh Bảo D','321231230132','123DCQ','123@124','1992-02-02','Nữ',2,3),(4,'nurse1','$2a$10$3sTfCiZUOnF3Eag4S15pEeq9HTVRw3VpWFfvcohuL6RTkB5k7l4oe',3,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691307639/avatar3.png','Phạm Huỳnh N','212301231230','123QWER','2051050075duy@ou.edu.vn','1993-03-03','Nữ',NULL,NULL),(5,'nurse2','$2a$12$4U5WueGLKEQrpS9.te6g9.xl3XELxjp66qxirurQZYfNH3YJpQIW.',3,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691307639/avatar3.png','Trịnh Thanh B','1231231212','1121Q12','122@13','1993-03-03','Nam',NULL,NULL),(6,'sickperson1','$2a$12$/5co2R/d2mrvBZ8oLhUjHeNyzP.wsuNlRaqFPKWmjwIAOXznflFqm',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697267399/dgltp4tjd9yl8ugp25cb.png','Nguyen Van Phuot','12312312313','qADFEQ','2051050381phuoc@ou.edu.vn','1993-04-04','Nam',NULL,NULL),(32,'tanphat','$2a$10$ay7CAvdar7AMH07F6mZEwOyY7WJV9ZAfy9zDC8OelebuFeAvKgZMy',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375225/owptphokxxpl9iy2vgbu.jpg','THAI TAN PHAT','0826523431','An Giang','2051050075duy@ou.edu.vn','2002-02-11','Nam',NULL,NULL),(33,'thuyennguyen','$2a$10$mGDuu02xyWySE6kJXuvaleaLwmvA4iVze1pn6WNpeNIlqHjGsY5r.',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375302/bjcttt2lwyovk4zj4dch.jpg','NGUYEN THANH THUYEN','0826523432','Sóc Trăng','2051050075duy@ou.edu.vn','2002-05-22','Nam',NULL,NULL),(34,'baoduy','$2a$10$kt6..dnkdGHD/Cnodyz7ReaBUI66L9ozvLaGg2HQqjuMzHjmmmEUu',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375369/e5z53ai6vb630axjhzbd.jpg','TRINH BAO DUY','0826523433','An Giang','2051050075duy@ou.edu.vn','2002-02-22','Nam',NULL,NULL),(35,'thanhnurse','$2a$10$40V3zt9h3XdFMkVKqOzJneYViwsgtik4A9wCkjLvt0M6XG16MkZXO',3,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375468/wfkmwe0dfrjkwgdhjvor.jpg','NGUYEN THI THANH','0826543434','Thành Phố Hồ Chí Minh','2051050075duy@ou.edu.vn','2002-02-22','Nam',NULL,NULL),(36,'toanmydoctor','$2a$10$0RrJWXj2/FrZISleRMCbauDAf.AVi9vIv21mfXs306o3JTwx/JQg6',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375569/bwwr02flhqvsn86pmnje.jpg','NGUYEN TOAN MY','0826523439','Tiền Giang','2051050075duy@ou.edu.vn','2002-02-22','Nam',3,NULL),(37,'yenvidoctor','$2a$10$OwAuMcU5TS.7y4yx2LGLlOzNUF3O5EoLupgNw47Yg4oapmFDN5g12',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694377815/aoyi4vvmm22u0ebkheci.jpg','PHAN THI YEN VI','0826523439','Gia Lai','2051050075duy@ou.edu.vn','2002-02-22','Nam',4,NULL),(38,'myhang','$2a$10$Fu/20J0FS/EFN5oTIDDomu6E12bYJgef8KP1qs9p3eKKsIRGNqhEi',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694412056/a6xabc3guhdx8e6wbk3s.png','DUONG THI MY HANG','0826523430','Gò Vấp','2051050381phuoc@ou.edu.vn','2002-02-22','Nữ',NULL,NULL),(39,'baoan','$2a$10$R9ipUUA8bRS9KRH5yzwnkutUxW.XfIJAweHC.aaqaM5W9zQaZZM6K',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694423736/uzqv6ys6y4f19iqxrix4.jpg','Thai Bao An','0826523430','An Giang','2051050381phuoc@ou.edu.vn','2002-02-22','Nữ',NULL,NULL),(48,'2051050075duy@ou.edu.vn','$2a$10$fvktfPiLG.8H.wqHQnyzx.5c99hce8xSIrRWK147hsEjTFWplxAae',4,'https://lh3.googleusercontent.com/a/ACg8ocIJqzM9eUDNaQjXbVEc_uLE3i-ufaMAQK6Uz39JyTIr=s96-c','Trịnh BảoDuy',NULL,NULL,'2051050075duy@ou.edu.vn',NULL,NULL,NULL,NULL),(50,'doctor5','$2a$10$vm0h93Zy2tafciw9Kou89enpRyQw8UbKcH8mJO.Nv.RixP4SMZ/pu',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1695442646/ygbzf2tgvh7kxo7azlu4.jpg','PHAN THI YEN VI','0388853371','089202010041','2051050075duy@ou.edu.vn','2002-11-16','Nam',1,1),(53,'thanhtoan','$2a$10$Dbkase7UVpBwn2Vztk.AfujGit7729/SHp5HpkzLRxtGMnpuU3c76',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697087817/naoprllvbka7jiybwjli.jpg','Thanh Thao','0327233646','An Giang','thanhthao08062002@gmail.com','2020-03-12','Nữ',NULL,NULL);
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

-- Dump completed on 2023-10-15  2:02:00
