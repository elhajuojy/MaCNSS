-- MySQL dump 10.13  Distrib 8.1.0, for Linux (aarch64)
--
-- Host: localhost    Database: MACNSS
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Visite`
--

DROP TABLE IF EXISTS `Visite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Visite` (
  `visiteId` bigint NOT NULL,
  `prix` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dossierNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`visiteId`),
  KEY `dossierNum` (`dossierNum`),
  CONSTRAINT `Visite_ibfk_1` FOREIGN KEY (`dossierNum`) REFERENCES `dossiers` (`numDossier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Visite`
--

LOCK TABLES `Visite` WRITE;
/*!40000 ALTER TABLE `Visite` DISABLE KEYS */;
INSERT INTO `Visite` VALUES (1,40,'Visit 1','Dossier1'),(2,55,'Visit 2','Dossier2'),(3,45,'Visit 3','Dossier3'),(4,60,'Visit 4','Dossier4'),(5,50,'Visit 5','Dossier5'),(6,70,'Visit 6','Dossier6'),(7,75,'Visit 7','Dossier7'),(8,65,'Visit 8','Dossier8'),(9,80,'Visit 9','Dossier9'),(10,85,'Visit 10','Dossier10');
/*!40000 ALTER TABLE `Visite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrateurs`
--

DROP TABLE IF EXISTS `administrateurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrateurs` (
  `email` char(55) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrateurs`
--

LOCK TABLES `administrateurs` WRITE;
/*!40000 ALTER TABLE `administrateurs` DISABLE KEYS */;
INSERT INTO `administrateurs` VALUES ('admin1@example.com','$2a$10$/M/cPsl8IOhtgAkY.Y.BSu3TIqNUXVI.N/g92gIigORB4HrzBaHe.'),('admin2@example.com','password2'),('admin3@example.com','password3'),('admin4@example.com','password4'),('admin5@example.com','password5'),('admin6@example.com','password6'),('admin7@example.com','password7'),('admin8@example.com','password8'),('admin9@example.com','password9'),('admin10@example.com','password10');
/*!40000 ALTER TABLE `administrateurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agents`
--

DROP TABLE IF EXISTS `agents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agents` (
  `email` char(55) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `codeVerification` varchar(250) DEFAULT NULL,
  `timeRegester` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agents`
--

LOCK TABLES `agents` WRITE;
/*!40000 ALTER TABLE `agents` DISABLE KEYS */;
INSERT INTO `agents` VALUES ('agent1@example.com','password1','code1','1695755997572'),('agent2@example.com','password2','code2','1695755997572'),('agent3@example.com','password3','code3','1695755997572'),('agent4@example.com','password4','code4',NULL),('agent5@example.com','password5','code5',NULL),('agent6@example.com','password6','code6',NULL),('agent7@example.com','password7','code7',NULL),('agent8@example.com','password8','code8',NULL),('agent9@example.com','password9','code9',NULL),('agent10@example.com','password10','code10',NULL),('souirimehdi311@gmail.com','$2a$10$7CmX1n7b8rZYLmv4QQHUE.h/92BYnVH.wNOMtTjdQi5iPYZfUCvQm','Y8yav4w3BGJcWxjFLNxBf','1695755997572'),('elhajuojye@gmail.com','$2a$10$/R0CUZUMmf5TeHBT6MSMQu5dTfukK.MtuMYM.AYWbnzbPc2rrugdG',NULL,NULL);
/*!40000 ALTER TABLE `agents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analyse`
--

DROP TABLE IF EXISTS `analyse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `analyse` (
  `analyseId` bigint NOT NULL,
  `prix` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dossierNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`analyseId`),
  KEY `dossierNum` (`dossierNum`),
  CONSTRAINT `analyse_ibfk_1` FOREIGN KEY (`dossierNum`) REFERENCES `dossiers` (`numDossier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analyse`
--

LOCK TABLES `analyse` WRITE;
/*!40000 ALTER TABLE `analyse` DISABLE KEYS */;
INSERT INTO `analyse` VALUES (1,50,'Analysis 1','Dossier1'),(2,75,'Analysis 2','Dossier2'),(3,60,'Analysis 3','Dossier3'),(4,80,'Analysis 4','Dossier4'),(5,45,'Analysis 5','Dossier5'),(6,55,'Analysis 6','Dossier6'),(7,70,'Analysis 7','Dossier7'),(8,65,'Analysis 8','Dossier8'),(9,90,'Analysis 9','Dossier9'),(10,85,'Analysis 10','Dossier10');
/*!40000 ALTER TABLE `analyse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dossiers`
--

DROP TABLE IF EXISTS `dossiers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dossiers` (
  `numDossier` varchar(123) NOT NULL,
  `status` char(55) DEFAULT NULL,
  `totalRemboursement` float DEFAULT NULL,
  `matricule` varchar(123) DEFAULT NULL,
  PRIMARY KEY (`numDossier`),
  KEY `matricule` (`matricule`),
  CONSTRAINT `dossiers_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `patients` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dossiers`
--

LOCK TABLES `dossiers` WRITE;
/*!40000 ALTER TABLE `dossiers` DISABLE KEYS */;
INSERT INTO `dossiers` VALUES ('093874873','En_attend',9845780,'11111'),('11111','Refusé',47647,'11111'),('14044075','En_attend',0,'11111'),('34349206','En_attend',0,'11111'),('46049325','En_attend',0,'11111'),('63786046','En_attend',0,'11111'),('73838366','En_attend',0,'11111'),('80796731','En_attend',0,'11111'),('8974847','En_attend',0,'11111'),('98944472','En_attend',0,'11111'),('Dossier1','En_attend',100,'12345'),('Dossier10','En_attend',220,'44444'),('Dossier2','En_attend',250,'67890'),('Dossier3','En_attend',50,'13579'),('Dossier4','En_attend',300,'24680'),('Dossier5','En_attend',75,'98765'),('Dossier6','En_attend',120,'54321'),('Dossier7','En_attend',200,'11111'),('Dossier8','En_attend',180,'22222'),('Dossier9','En_attend',90,'33333');
/*!40000 ALTER TABLE `dossiers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fichiers`
--

DROP TABLE IF EXISTS `fichiers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichiers` (
  `numeroFichier` bigint NOT NULL,
  `dateDepot` date DEFAULT NULL,
  `TotalFraisDossier` float DEFAULT NULL,
  `specialite` varchar(123) DEFAULT NULL,
  `dossierNum` varchar(123) DEFAULT NULL,
  PRIMARY KEY (`numeroFichier`),
  KEY `dossierNum` (`dossierNum`),
  CONSTRAINT `fichiers_ibfk_1` FOREIGN KEY (`dossierNum`) REFERENCES `dossiers` (`numDossier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichiers`
--

LOCK TABLES `fichiers` WRITE;
/*!40000 ALTER TABLE `fichiers` DISABLE KEYS */;
INSERT INTO `fichiers` VALUES (0,'2023-12-12',66,'Specialty 1','11111'),(1,'2023-09-23',150,'Specialty 1','Dossier1'),(2,'2023-09-24',200,'Specialty 2','Dossier2'),(3,'2023-09-25',125,'Specialty 3','Dossier3'),(4,'2023-09-26',180,'Specialty 4','Dossier4'),(5,'2023-09-27',220,'Specialty 5','Dossier5'),(6,'2023-09-28',95,'Specialty 6','Dossier6'),(7,'2023-09-29',120,'Specialty 7','Dossier7'),(8,'2023-09-30',175,'Specialty 8','Dossier8'),(9,'2023-10-01',140,'Specialty 9','Dossier9'),(10,'2023-10-02',160,'Specialty 10','Dossier10');
/*!40000 ALTER TABLE `fichiers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicament` (
  `codeBarre` bigint NOT NULL,
  `quantite` int DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `dossierNum` varchar(123) DEFAULT NULL,
  KEY `dossierNum` (`dossierNum`),
  CONSTRAINT `medicament_ibfk_1` FOREIGN KEY (`dossierNum`) REFERENCES `dossiers` (`numDossier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicament`
--

LOCK TABLES `medicament` WRITE;
/*!40000 ALTER TABLE `medicament` DISABLE KEYS */;
INSERT INTO `medicament` VALUES (11111,4,25,'Dossier7'),(12345,5,20,'Dossier1'),(1234509876,8,12.5,'Dossier3'),(22222,9,14,'Dossier8'),(24680,6,18,'Dossier4'),(33333,11,16.5,'Dossier9'),(44444,5,21,'Dossier10'),(54321,7,22,'Dossier6'),(67890,10,15,'Dossier2'),(98765,12,10,'Dossier5'),(384774,2,12,'34349206'),(30498474,1,3837,'34349206'),(598575,3,0,'8974847'),(54321,2,0,'98944472'),(1234509876,2,0,'11111');
/*!40000 ALTER TABLE `medicament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `email` char(55) DEFAULT NULL,
  `password` char(55) DEFAULT NULL,
  `nom` char(55) DEFAULT NULL,
  `matricule` varchar(250) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES ('patient7@example.com','password7','Patient 7','11111'),('patient1@example.com','password1','Patient 1','12345'),('patient3@example.com','password3','Patient 3','13579'),('patient8@example.com','password8','Patient 8','22222'),('patient4@example.com','password4','Patient 4','24680'),('patient9@example.com','password9','Patient 9','33333'),('patient10@example.com','password10','Patient 10','44444'),('patient6@example.com','password6','Patient 6','54321'),('patient2@example.com','password2','Patient 2','67890'),('patient5@example.com','password5','Patient 5','98765');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radio`
--

DROP TABLE IF EXISTS `radio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radio` (
  `radioId` bigint NOT NULL,
  `prix` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dossierNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`radioId`),
  KEY `dossierNum` (`dossierNum`),
  CONSTRAINT `radio_ibfk_1` FOREIGN KEY (`dossierNum`) REFERENCES `dossiers` (`numDossier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radio`
--

LOCK TABLES `radio` WRITE;
/*!40000 ALTER TABLE `radio` DISABLE KEYS */;
INSERT INTO `radio` VALUES (1,60,'X-ray 1','Dossier1'),(2,80,'CT Scan 1','Dossier2'),(3,65,'MRI 1','Dossier3'),(4,70,'Ultrasound 1','Dossier4'),(5,75,'X-ray 2','Dossier5'),(6,90,'CT Scan 2','Dossier6'),(7,55,'MRI 2','Dossier7'),(8,75,'Ultrasound 2','Dossier8'),(9,70,'X-ray 3','Dossier9'),(10,85,'CT Scan 3','Dossier10');
/*!40000 ALTER TABLE `radio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remboursement`
--

DROP TABLE IF EXISTS `remboursement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `remboursement` (
  `specialite` varchar(100) NOT NULL,
  `trMedicament` float DEFAULT NULL,
  `pbMedicament` float DEFAULT NULL,
  `trAnalyse` float DEFAULT NULL,
  `pbAnalyse` float DEFAULT NULL,
  `trRadio` float DEFAULT NULL,
  `pbRadio` float DEFAULT NULL,
  `trScanner` float DEFAULT NULL,
  `pbScanner` float DEFAULT NULL,
  `trVisisteSpecialiste` float DEFAULT NULL,
  `pbVisiteSpecialiste` float DEFAULT NULL,
  `trVisiteGeneratrice` float DEFAULT NULL,
  `pbVisiteGeneratrice` float DEFAULT NULL,
  PRIMARY KEY (`specialite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remboursement`
--

LOCK TABLES `remboursement` WRITE;
/*!40000 ALTER TABLE `remboursement` DISABLE KEYS */;
INSERT INTO `remboursement` VALUES ('Specialty 1',10,5,15,8,20,10,25,12,30,15,35,18),('Specialty 10',16,8,24,12,32,16,40,20,48,24,56,28),('Specialty 2',12,6,18,9,24,12,30,14,36,18,42,20),('Specialty 3',8,4,12,6,16,8,20,10,24,12,28,14),('Specialty 4',15,7.5,22.5,11.25,30,15,37.5,18.75,45,22.5,52.5,26.25),('Specialty 5',9,4.5,13.5,6.75,18,9,22.5,11.25,27,13.5,31.5,15.75),('Specialty 6',11,5.5,16.5,8.25,22,11,27.5,13.75,33,16.5,38.5,19.25),('Specialty 7',13,6.5,19.5,9.75,26,13,32.5,16.25,39,19.5,45.5,22.75),('Specialty 8',10,5,15,7.5,20,10,25,12.5,30,15,35,17.5),('Specialty 9',14,7,21,10.5,28,14,35,17.5,42,21,49,24.5);
/*!40000 ALTER TABLE `remboursement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remboursementmedicament`
--

DROP TABLE IF EXISTS `remboursementmedicament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `remboursementmedicament` (
  `codeBare` bigint NOT NULL,
  `PrixBasic` float NOT NULL,
  `TauxRe` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remboursementmedicament`
--

LOCK TABLES `remboursementmedicament` WRITE;
/*!40000 ALTER TABLE `remboursementmedicament` DISABLE KEYS */;
INSERT INTO `remboursementmedicament` VALUES (1123456789,11.99,45),(1234509876,7.99,10),(1234567890,10.99,1),(1345678901,25.49,37),(1456789012,14.99,28),(1567890123,26.99,19),(2234567890,26.49,46),(2345018765,18.49,11),(2345678901,15.49,2),(2456789012,20.99,38),(2567890123,17.49,29),(2678901234,16.49,20),(3345678901,15.49,47),(3450187654,13.99,12),(3456789012,8.99,3),(3567890123,16.99,39),(3678901234,11.49,30),(3789012345,23.99,21),(4456789012,27.49,48),(4501876543,16.99,13),(4567890123,25.99,4),(4678901234,18.49,40),(4789012345,29.99,31),(4890123456,12.49,22),(5018765432,14.49,14),(5567890123,12.49,49),(5678901234,12.99,5),(5789012345,21.49,41),(5890123456,9.49,32),(5901234567,8.49,23),(6012345678,27.99,24),(6123456789,21.99,15),(6678901234,28.99,50),(6789012345,17.99,6),(6890123456,24.49,42),(6901234567,12.99,33),(7012345678,13.49,34),(7123456789,15.99,25),(7234567890,9.99,16),(7890123456,22.49,7),(7901234567,14.99,43),(8123456789,22.99,35),(8234567890,28.49,26),(8345678901,20.49,17),(8901234567,11.99,8),(9012345678,19.99,9),(9234567890,19.49,36),(9345678901,10.49,27),(9456789012,24.99,18);
/*!40000 ALTER TABLE `remboursementmedicament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scanner`
--

DROP TABLE IF EXISTS `scanner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scanner` (
  `scannerId` bigint NOT NULL,
  `prix` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dossierNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`scannerId`),
  KEY `dossierNum` (`dossierNum`),
  CONSTRAINT `scanner_ibfk_1` FOREIGN KEY (`dossierNum`) REFERENCES `dossiers` (`numDossier`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scanner`
--

LOCK TABLES `scanner` WRITE;
/*!40000 ALTER TABLE `scanner` DISABLE KEYS */;
INSERT INTO `scanner` VALUES (1,60,'X-ray 1','Dossier1'),(2,80,'CT Scan 1','Dossier2'),(3,65,'MRI 1','Dossier3'),(4,70,'Ultrasound 1','Dossier4'),(5,75,'X-ray 2','Dossier5'),(6,90,'CT Scan 2','Dossier6'),(7,55,'MRI 2','Dossier7'),(8,75,'Ultrasound 2','Dossier8'),(9,70,'X-ray 3','Dossier9'),(10,85,'CT Scan 3','Dossier10'),(3345,45,'this is description for the scanner face ','8974847');
/*!40000 ALTER TABLE `scanner` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-27  8:40:12
