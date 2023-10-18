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
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2023-07-15 09:00:00',1,'2023-08-18 09:00:00',16,2,5,4),(8,'2023-08-24 09:00:00',1,'2023-09-08 16:36:38',51,2,6,4),(12,'2023-08-11 10:00:00',1,'2023-10-09 16:30:03',1,2,6,4),(13,'2023-08-22 11:00:00',1,'2023-08-31 16:55:05',1,2,6,4),(14,'2023-08-27 12:00:00',1,'2023-10-06 15:27:11',1,2,6,4),(16,'2023-08-25 12:30:00',1,'2023-10-09 23:21:28',28,2,6,4),(17,'2023-08-23 11:30:00',1,'2023-10-10 11:29:43',29,2,6,4),(18,'2023-08-10 14:00:00',1,'2023-10-09 22:49:37',30,2,6,4),(19,'2023-09-09 08:00:00',1,'2023-10-10 11:34:29',30,2,6,2),(20,'2023-09-14 12:00:00',1,'2023-10-10 11:46:01',32,2,6,4),(21,'2023-09-05 17:30:00',1,'2023-10-10 12:06:26',74,2,6,4),(22,'2023-03-05 17:30:00',1,'2023-10-10 23:19:42',35,2,6,4),(23,'2023-08-26 08:30:00',1,'2023-10-11 00:16:47',34,2,6,4),(24,'2023-08-18 14:30:00',1,'2023-10-14 13:15:07',36,2,6,4),(26,'2023-08-24 09:30:00',1,'2023-09-10 14:23:56',47,2,6,4),(32,'2023-04-09 12:00:00',1,'2023-10-10 08:11:11',46,2,6,2),(33,'2023-08-25 15:00:00',1,'2023-09-21 10:10:10',46,2,6,4),(34,'2023-08-10 08:00:00',1,'2023-08-09 15:11:11',46,2,6,4),(43,'2023-09-12 11:30:00',1,'2023-10-05 01:43:52',55,2,32,35),(48,'2023-09-11 00:00:00',1,'2023-09-12 11:27:11',58,2,34,4),(49,'2023-09-11 08:00:00',1,'2023-09-11 17:11:32',56,2,34,35),(52,'2023-09-12 00:00:00',1,'2023-09-12 11:26:18',57,2,38,4),(53,'2023-09-12 16:00:00',1,'2023-09-29 11:56:48',59,2,38,35),(55,'2023-09-12 00:00:00',1,'2023-10-12 12:49:41',59,2,33,4),(77,'2023-10-19 14:30:00',1,'2023-10-12 12:40:27',76,2,53,4),(81,'2023-10-20 13:00:00',1,'2023-10-16 10:36:09',80,2,6,4);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (2,33,1,1200410,1),(6,22,2,100000,1),(8,8,1,1300015,1),(18,43,2,3160000,1),(19,49,1,11222000,1),(20,52,3,2155000,1),(21,48,3,855000,1),(22,53,3,11720000,1),(23,13,2,11720000,1),(24,21,2,824000,1),(25,20,1,922000,1);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Khoa Tim Mạch',' Khoa tim mạch chuyên về chẩn đoán, điều trị và quản lý các bệnh tim mạch. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực tim mạch và cung cấp các dịch vụ y tế liên quan như kiểm tra tim, siêu âm tim, xét nghiệm máu, và các phương pháp can thiệp tim mạch.'),(2,'Khoa Xương Khớp','Khoa Xương Khớp chuyên về chẩn đoán, điều trị và quản lý các bệnh và vấn đề liên quan đến hệ thống xương và khớp. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực xương khớp và cung cấp các dịch vụ y tế như chẩn đoán bệnh, điều trị thuốc, phục hồi chức năng, và phẫu thuật xương khớp.'),(3,'Khoa Thần Kinh','Khoa Thần kinh chuyên về chẩn đoán, điều trị và quản lý các bệnh và rối loạn về hệ thống thần kinh. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực thần kinh và cung cấp các dịch vụ y tế như chẩn đoán bệnh, điều trị thuốc, phục hồi chức năng, và các phương pháp can thiệp thần kinh.'),(4,'Khoa Tiêu Hóa','Khoa Tiêu hóa chuyên về chẩn đoán, điều trị và quản lý các bệnh và rối loạn về hệ tiêu hóa. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực tiêu hóa và gan mật, cung cấp các dịch vụ y tế như chẩn đoán bệnh, điều trị thuốc, can thiệp nội soi và phẫu thuật tiêu hóa.'),(5,'Khoa Phụ Sản','Khoa Phụ sản chuyên về chẩn đoán, điều trị và quản lý các vấn đề liên quan đến sức khỏe sinh sản của phụ nữ. Khoa này có đội ngũ bác sĩ và nhân viên chuyên gia trong lĩnh vực phụ sản, cung cấp các dịch vụ y tế như khám bệnh, chẩn đoán, điều trị, theo dõi thai kỳ, quản lý sản khoa và chăm sóc sau sinh.'),(6,'Khoa Da Liễu','Khoa Da Liễu chuyên về chẩn đoán, điều trị và quản lý các vấn đề liên quan đến da, tóc, và móng. Khoa này có đội ngũ bác sĩ da liễu và nhân viên chuyên gia trong lĩnh vực da liễu, cung cấp các dịch vụ y tế như khám bệnh, chẩn đoán, điều trị và theo dõi các bệnh lý da.'),(7,'Nhi Khoa','Khoa Nhi chuyên về chẩn đoán, điều trị và quản lý các vấn đề sức khỏe của trẻ em. Khoa này có đội ngũ bác sĩ nhi khoa và nhân viên chuyên gia trong lĩnh vực nhi khoa, cung cấp các dịch vụ y tế như khám bệnh, chẩn đoán, điều trị, theo dõi sự phát triển và sức khỏe tổng thể của trẻ em.');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'Paracetamol',110000.00,'JAPAN','2023-10-08','2024-10-08',2,94),(2,'Amoxicillin',200000.00,'KOREA','2023-10-08','2024-10-08',2,202),(8,'Thuốc cảm',120000.00,'VIETNAM','2023-08-17','2024-09-17',3,274),(18,'Thuốc nhứt đầu',123000.00,'THAILAN','2023-01-01','2024-10-10',2,100),(19,'Thuốc chống óii',100000.00,'VIETNAM','2023-08-28','2025-08-29',6,997),(22,'Vitamin A',10000.00,'VIETNAM','2023-08-31','2024-10-08',1,190),(23,'Vitamin B',11000.00,'VIETNAM','2023-08-28','2024-10-08',1,195),(24,'Vitamin C',12000.00,'VIETNAM','2023-08-22','2025-01-01',1,94);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'TIỀN MẶT'),(2,'MOMO'),(3,'PayPal'),(4,'CASD');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'2023-10-09 16:29:05','1','thanh cong di ma','Prescribed painkillers.'),(2,'2023-07-15 16:24:23','Prescription A','lạnh','Advised to gargle with warm water.'),(4,'2023-08-02 00:00:00','Prescription B','đau tai','Prescribed painkillers.'),(5,'2023-08-03 00:00:00','Prescription C','đau họng','Advised to gargle with warm water.'),(6,'2023-08-04 00:00:00','Prescription D','đau họng','Recommended antihistamines.'),(15,'2023-08-24 00:00:00','1','đau họng','ho hen'),(16,'2023-08-24 00:00:00','1','đau lưng','ho hen'),(17,'2023-08-24 00:00:00','1','đau lưng','ho hen'),(19,'2023-08-24 00:00:00','1','đau đầu','ho hen'),(22,'2023-08-24 00:00:00','1','đau đầu','ho hen'),(26,'2023-08-25 00:00:00','1','đau đầu','ho hen'),(27,'2023-08-25 00:00:00','1','đau đầu','ho hen'),(28,'2023-10-09 23:21:05','1','benh cam','ho hen'),(29,'2023-10-10 11:16:34','1','benh cam','ho hen'),(30,'2023-10-10 11:30:35','1','benh cam','ho hen'),(31,'2023-08-25 00:00:00','1','đau đầu','ho hen'),(32,'2023-10-10 11:45:42','1','benh cam','ho hen'),(33,'2023-08-25 00:00:00','1','đau đầu','ho hen'),(34,'2023-10-10 23:38:22','1','benh cam','ho hen'),(35,'2023-10-10 22:41:07','1','benh cam','ho hen'),(36,'2023-10-14 13:05:24','1','benh cam','ho hen'),(37,'2023-08-26 00:00:00','1','đau bụng','ho hen'),(38,'2023-08-26 00:00:00','1','đâu chân','ho hen'),(39,'2023-08-27 00:00:00','1','đâu chân','ho hen'),(40,'2023-08-27 00:00:00','1','đau bụng','ho hen'),(41,'2023-08-27 00:00:00','1','đau bụng','ho hen'),(42,'2023-08-28 00:00:00','1','đau đầu','ho hen'),(43,'2023-08-30 00:00:00','1','đau đầu','ho hen'),(44,'2023-08-31 00:00:00','1','đau đầu','ho hen'),(46,'2023-09-06 00:00:00','1','cảm','ho hen'),(47,'2023-09-08 00:00:00','1','suy giam the luc','ho hen va nhay mui'),(48,'2023-09-08 00:00:00','1','suy giam the luc','ho hen va nhay mui'),(49,'2023-09-08 00:00:00','1','đau họng','há»c java'),(50,'2023-09-08 00:00:00','1','đau đầu','ho hen'),(51,'2023-09-08 00:00:00','1','đâu chân','mÃ¨o'),(52,'2023-09-10 00:00:00','1','cảm lạnh','ho hen'),(55,'2023-09-11 00:00:00','1','viêm phổi','Ho ÄÃªm nhiá»u ngÃ y'),(56,'2023-09-11 00:00:00','1','suy giam the luc','Hen xuyen, nhut dau'),(57,'2023-09-12 00:00:00','1','cảm lạnh','ho hen va nhay mui'),(58,'2023-09-12 00:00:00','1','cam lanh','ho hen va nhay mui'),(59,'2023-10-12 12:49:22','1','cam benh','há»c java'),(73,'2023-10-02 01:21:41','1','benh thiet oi','thanh cong di'),(74,'2023-10-10 00:00:00','1','gãy tay','ho hen'),(76,'2023-10-12 12:39:38','1','benh cam','nhut dau'),(80,'2023-10-16 10:35:18','1','ho nhiều','cảm');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `prescription_item`
--

LOCK TABLES `prescription_item` WRITE;
/*!40000 ALTER TABLE `prescription_item` DISABLE KEYS */;
INSERT INTO `prescription_item` VALUES (3,2,1,30,'Uống mỗi ngày một viên'),(5,1,1,1,'Uống mỗi ngày một viên'),(6,1,1,1,'Sáng 1 lần chìu 1 lần'),(7,1,1,1,'Sáng 1 lần chìu 1 lần'),(10,29,1,1,'Uống buổi tối'),(11,30,1,1,'Sáng 1 lần chìu 1 lần'),(12,31,1,1,'Sáng 1 lần chìu 1 lần'),(13,32,1,1,'Chỉ uống buổi sáng'),(14,33,1,1,'Chỉ uống buổi sáng'),(16,35,1,1,'Chỉ uống buổi sáng'),(17,35,1,1,'Uống mỗi ngày một viên'),(18,35,1,1,'Uống mỗi ngày một viên'),(19,35,1,1,'Chỉ uống buổi tối'),(20,37,1,1,'Uống buổi tối'),(21,37,1,1,'Chỉ uống buổi tối'),(27,39,8,1,'Chỉ uống buổi tối'),(28,39,2,1,'Uống buổi tối'),(29,39,8,2,'Uống buổi tối'),(30,39,8,1,'Uống buổi tối'),(33,38,1,2,'Uống buổi tối'),(34,38,18,2,'Uống trước khi ăn'),(35,38,8,1,'Uống trước khi ăn'),(36,43,8,5,'Uống trước khi ăn'),(37,43,1,5,'Uống sau khi ăn'),(38,44,1,1,'Uống sau khi ăn'),(41,38,8,1,'Uống sau khi ăn'),(69,55,1,6,'Dùng sau ăn 30 phút'),(70,55,2,6,'Dùng sau ăn 30 phút'),(72,56,19,1,'Dùng sau ăn 30 phút'),(73,56,24,1,'Dùng sau ăn 30 phút'),(74,57,8,5,'Dùng sau ăn 30 phút'),(75,57,23,5,'Dùng trước ăn 30 phút'),(76,58,23,5,'Dùng trước ăn 30 phút'),(77,59,19,1,'Dùng trước ăn 30 phút'),(78,59,8,1,'Dùng trước ăn 30 phút');
/*!40000 ALTER TABLE `prescription_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES (1,'Tiến sĩ',500000),(2,'Thạc sĩ',300000),(3,'Bác sĩ',150000);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,'Kham tot lam!','2023-08-10',3,33),(2,'10 điểm','2023-09-25',5,22),(3,'Bác sĩ giỏi','2023-09-25',5,43),(4,'Tuyệt vời','2023-10-08',4,20),(5,'Khám rất tốt','2023-10-15',3,53);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_DOCTOR'),(3,'ROLE_NURSE'),(4,'ROLE_SICKPERSON');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `schedule_detail`
--

LOCK TABLES `schedule_detail` WRITE;
/*!40000 ALTER TABLE `schedule_detail` DISABLE KEYS */;
INSERT INTO `schedule_detail` VALUES ('2023-10-18',1,4,1,1),('2023-10-18',1,2,2,1),('2023-10-19',2,2,3,1),('2023-10-19',2,2,4,1),('2023-10-20',1,2,5,1),('2023-10-21',1,2,6,1),('2023-10-25',1,2,7,1),('2023-10-25',2,4,8,1),('2023-10-26',1,2,9,1),('2023-10-26',3,2,10,1),('2023-10-27',1,3,11,1),('2023-10-27',2,3,12,1),('2023-10-23',1,2,821,0),('2023-10-25',1,2,822,0),('2023-10-26',1,2,823,0),('2023-10-24',2,2,824,0),('2023-10-26',2,2,825,0),('2023-10-27',2,2,826,0),('2023-10-28',2,2,827,0),('2023-10-29',3,2,828,0);
/*!40000 ALTER TABLE `schedule_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'X-QUANG',500000),(2,'TỔNG QUÁT',1000000),(3,'XÉT NGHIỆM MÁU',200000),(4,'XÉT NGHIỆM ADN',400000);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service_items`
--

LOCK TABLES `service_items` WRITE;
/*!40000 ALTER TABLE `service_items` DISABLE KEYS */;
INSERT INTO `service_items` VALUES (13,'2023-08-24 00:00:00',18,3),(13,'2023-08-24 00:00:00',19,2),(12,'2023-08-25 00:00:00',20,2),(22,'2023-08-24 00:00:00',31,2),(22,'2023-08-24 00:00:00',32,1),(32,'2023-09-08 00:00:00',43,3),(32,'2023-09-08 00:00:00',44,4),(26,'2023-09-08 00:00:00',45,3),(26,'2023-09-08 00:00:00',46,4),(26,'2023-09-08 00:00:00',47,4),(32,'2023-09-08 00:00:00',48,2),(32,'2023-09-08 00:00:00',49,3),(32,'2023-09-08 00:00:00',50,4),(34,'2023-09-08 00:00:00',51,1),(34,'2023-09-08 00:00:00',52,2),(34,'2023-09-08 00:00:00',53,3),(34,'2023-09-08 00:00:00',54,4),(33,'2023-09-10 00:00:00',58,2),(33,'2023-09-10 00:00:00',59,3),(43,'2023-09-11 00:00:00',62,2),(43,'2023-09-11 00:00:00',63,3),(49,'2023-09-11 00:00:00',64,2),(52,'2023-09-12 00:00:00',65,2),(52,'2023-09-12 00:00:00',66,3),(48,'2023-09-12 00:00:00',67,1),(53,'2023-09-29 00:00:00',68,1),(53,'2023-09-29 00:00:00',69,2),(12,'2023-10-06 01:13:36',72,1),(12,'2023-10-06 01:16:29',74,1),(12,'2023-10-06 01:16:29',75,2),(22,'2023-10-08 12:52:40',76,1),(22,'2023-10-08 12:52:40',77,2),(12,'2023-10-09 16:29:05',78,1),(12,'2023-10-09 16:29:05',79,2),(18,'2023-10-09 22:49:12',80,1),(18,'2023-10-09 22:49:12',81,2),(16,'2023-10-09 23:21:05',82,3),(16,'2023-10-09 23:21:05',83,4),(17,'2023-10-10 11:16:34',84,1),(17,'2023-10-10 11:16:34',85,3),(19,'2023-10-10 11:30:35',86,1),(19,'2023-10-10 11:30:35',87,3),(20,'2023-10-10 11:45:42',88,1),(21,'2023-10-10 00:00:00',89,1),(22,'2023-10-10 16:45:14',90,1),(22,'2023-10-10 22:41:07',91,3),(22,'2023-10-10 22:41:07',92,4),(23,'2023-10-10 23:38:22',93,4),(77,'2023-10-12 12:39:38',94,1),(77,'2023-10-12 12:39:38',95,3),(55,'2023-10-12 12:49:22',96,2),(24,'2023-10-14 12:33:47',97,1),(24,'2023-10-14 12:33:47',98,4),(24,'2023-10-14 12:40:41',99,1),(24,'2023-10-14 13:05:24',100,1),(81,'2023-10-16 10:35:18',101,1);
/*!40000 ALTER TABLE `service_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shift`
--

LOCK TABLES `shift` WRITE;
/*!40000 ALTER TABLE `shift` DISABLE KEYS */;
INSERT INTO `shift` VALUES (1,'Ca sáng','08:00:00','16:00:00'),(2,'Ca chiều','16:00:00','23:59:00'),(3,'Ca đêm','00:00:00','08:00:00');
/*!40000 ALTER TABLE `shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tienkham`
--

LOCK TABLES `tienkham` WRITE;
/*!40000 ALTER TABLE `tienkham` DISABLE KEYS */;
INSERT INTO `tienkham` VALUES (1,100000);
/*!40000 ALTER TABLE `tienkham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'Hộp'),(2,'Viên'),(3,'Vỉ'),(4,'Gram'),(5,'Ống'),(6,'Gói');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$12$m.6Wyu5HSAzwdv8RSQmxwuW24uapMoa8LPbrnCNZoaTkmE8yWsEyO',1,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691306503/avatar1.png','quanly','042302340243','123HCM123','123@123','2002-11-16','Nam',NULL,NULL),(2,'doctor1','$2a$12$S6GNLW60N031dXxU5wYnMesRp1A1/Uj1XJ6IvOE8xP5XAkz2uftmS',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697524706/vjfn3ykymwqofthqi9yf.jpg','Nguyễn Văn Nam','001233012312','123ABC','123@123','1992-02-02','Nam',1,2),(3,'doctor2','$2a$12$ugHEVyKVH2nOSVjOQIeqGuEgEPsq0rhrgsz4OL8L0df84BIZG3i4y',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697524706/vab0rsh738l32efcqxtt.jpg','Trịnh Bảo Duy','321231230132','123DCQ','123@124','1992-02-02','Nữ',2,3),(4,'nurse1','$2a$10$3sTfCiZUOnF3Eag4S15pEeq9HTVRw3VpWFfvcohuL6RTkB5k7l4oe',3,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691307639/avatar3.png','Phạm Huỳnh Như','212301231230','123QWER','2051050075duy@ou.edu.vn','1993-03-03','Nữ',NULL,NULL),(5,'nurse2','$2a$12$4U5WueGLKEQrpS9.te6g9.xl3XELxjp66qxirurQZYfNH3YJpQIW.',3,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1691307639/avatar3.png','Trịnh Thanh Bình','1231231212','1121Q12','122@13','1993-03-03','Nam',NULL,NULL),(6,'sickperson1','$2a$12$/5co2R/d2mrvBZ8oLhUjHeNyzP.wsuNlRaqFPKWmjwIAOXznflFqm',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697267399/dgltp4tjd9yl8ugp25cb.png','Nguyễn Văn Phước','12312312313','qADFEQ','2051050381phuoc@ou.edu.vn','1993-04-04','Nam',NULL,NULL),(7,'nhunhu','123',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697525747/sdguph1s5skq5lrmea09.jpg','Nguyễn An Nhi','0931187902','Cần Thơ','nhi@gmail.com','1999-09-20','Nữ',3,1),(32,'tanphat','$2a$10$ay7CAvdar7AMH07F6mZEwOyY7WJV9ZAfy9zDC8OelebuFeAvKgZMy',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375225/owptphokxxpl9iy2vgbu.jpg','Thái Tấn Phát','0826523431','An Giang','2051050075duy@ou.edu.vn','2002-02-11','Nam',NULL,NULL),(33,'thuyennguyen','$2a$10$mGDuu02xyWySE6kJXuvaleaLwmvA4iVze1pn6WNpeNIlqHjGsY5r.',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375302/bjcttt2lwyovk4zj4dch.jpg','Nguyễn Thanh Thuyền','0826523432','Sóc Trăng','2051050075duy@ou.edu.vn','2002-05-22','Nam',NULL,NULL),(34,'baoduy','$2a$10$kt6..dnkdGHD/Cnodyz7ReaBUI66L9ozvLaGg2HQqjuMzHjmmmEUu',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375369/e5z53ai6vb630axjhzbd.jpg','Trịnh Bảo An','0826523433','An Giang','2051050075duy@ou.edu.vn','2002-02-22','Nam',NULL,NULL),(35,'thanhnurse','$2a$10$40V3zt9h3XdFMkVKqOzJneYViwsgtik4A9wCkjLvt0M6XG16MkZXO',3,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694375468/wfkmwe0dfrjkwgdhjvor.jpg','Nguyễn Thị Thanh','0826543434','Thành Phố Hồ Chí Minh','2051050075duy@ou.edu.vn','2002-02-22','Nam',NULL,NULL),(36,'toanmydoctor','$2a$10$0RrJWXj2/FrZISleRMCbauDAf.AVi9vIv21mfXs306o3JTwx/JQg6',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697524706/sxbtafohao53grxpa0d1.jpg','Nguyễn Toàn Mỹ','0826523439','Tiền Giang','2051050075duy@ou.edu.vn','2002-02-22','Nam',3,2),(37,'yenvidoctor','$2a$10$OwAuMcU5TS.7y4yx2LGLlOzNUF3O5EoLupgNw47Yg4oapmFDN5g12',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697524923/fbpyhd2jkluufx2nqtvd.jpg','Phan Thị Yến Vi','0826523439','Gia Lai','2051050075duy@ou.edu.vn','2002-02-22','Nam',4,1),(38,'myhang','$2a$10$Fu/20J0FS/EFN5oTIDDomu6E12bYJgef8KP1qs9p3eKKsIRGNqhEi',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694412056/a6xabc3guhdx8e6wbk3s.png','Dương Thị Mỹ Hằng','0826523430','Gò Vấp','2051050381phuoc@ou.edu.vn','2002-02-22','Nữ',NULL,NULL),(39,'baoan','$2a$10$R9ipUUA8bRS9KRH5yzwnkutUxW.XfIJAweHC.aaqaM5W9zQaZZM6K',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1694423736/uzqv6ys6y4f19iqxrix4.jpg','Lê Thị Huỳnh Như','0826523430','An Giang','2051050381phuoc@ou.edu.vn','2002-02-22','Nữ',NULL,NULL),(50,'doctor5','$2a$10$vm0h93Zy2tafciw9Kou89enpRyQw8UbKcH8mJO.Nv.RixP4SMZ/pu',2,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697524706/tvig9eyowm8q2phaqnb0.jpg','PHAN THI YEN VI','0388853371','089202010041','2051050075duy@ou.edu.vn','2002-11-16','Nam',1,1),(53,'thanhtoan','$2a$10$Dbkase7UVpBwn2Vztk.AfujGit7729/SHp5HpkzLRxtGMnpuU3c76',4,'https://res.cloudinary.com/dstqvlt8d/image/upload/v1697087817/naoprllvbka7jiybwjli.jpg','Thanh Thao','0327233646','An Giang','thanhthao08062002@gmail.com','0198-02-17','Nữ',NULL,NULL);
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

-- Dump completed on 2023-10-18 20:00:36
