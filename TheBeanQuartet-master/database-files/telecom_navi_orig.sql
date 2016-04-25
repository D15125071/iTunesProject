-- MySQL dump 10.13  Distrib 5.6.26, for Win64 (x86_64)
--
-- Host: localhost    Database: telecomproject
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `base_data`
--

DROP TABLE IF EXISTS `base_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_data` (
  `Base_Data_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Date_Time` datetime NOT NULL,
  `Event_Id` int(11) NOT NULL,
  `Failure_Class` int(11) DEFAULT NULL,
  `UE_Type` int(11) NOT NULL,
  `Market` int(11) NOT NULL,
  `Operator` int(11) NOT NULL,
  `Cell_Id` int(11) NOT NULL,
  `Duration` int(11) NOT NULL,
  `Cause_Code` int(11) DEFAULT NULL,
  `NE_Version` varchar(50) NOT NULL,
  `IMSI` bigint(20) NOT NULL,
  `HIER3_ID` bigint(8) NOT NULL,
  `HIER32_ID` bigint(8) NOT NULL,
  `HIER321_ID` bigint(8) NOT NULL,
  PRIMARY KEY (`Base_Data_Id`)
  
  /*
  
  --- foreign keys commented out ---
  
  KEY `Market` (`Market`,`Operator`),
  KEY `Failure_Class` (`Failure_Class`),
  KEY `UE_Type` (`UE_Type`),
  KEY `Cause_Code` (`Cause_Code`,`Event_Id`),
  CONSTRAINT `base_data_ibfk_1` FOREIGN KEY (`Market`, `Operator`) REFERENCES `mcc_mnc` (`Mcc`, `Mnc`),
  CONSTRAINT `base_data_ibfk_2` FOREIGN KEY (`Failure_Class`) REFERENCES `failure_class` (`Failure_Class_Id`),
  CONSTRAINT `base_data_ibfk_3` FOREIGN KEY (`UE_Type`) REFERENCES `ue_table` (`Tac`),
  CONSTRAINT `base_data_ibfk_4` FOREIGN KEY (`Cause_Code`, `Event_Id`) REFERENCES `event_cause` (`Cause_Code`, `Event_Id`) 
  
  */

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_data`
--

LOCK TABLES `base_data` WRITE;
/*!40000 ALTER TABLE `base_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_cause`
--

DROP TABLE IF EXISTS `event_cause`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_cause` (
  `Cause_Code` int(11) NOT NULL,
  `Event_Id` int(11) NOT NULL,
  `Description` varchar(150) NOT NULL,
  PRIMARY KEY (`Cause_Code`,`Event_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_cause`
--

LOCK TABLES `event_cause` WRITE;
/*!40000 ALTER TABLE `event_cause` DISABLE KEYS */;
INSERT INTO `event_cause` VALUES (0,4097,'RRC CONN SETUP-SUCCESS'),(0,4098,'S1 SIG CONN SETUP-SUCCESS'),(0,4106,'INITIAL CTXT SETUP-SUCCESS'),(0,4125,'UE CTXT RELEASE-UNSPECIFIED'),(1,4097,'RRC CONN SETUP-UNSPECIFIED'),(1,4098,'S1 SIG CONN SETUP-S1 INTERFACE DOWN'),(1,4106,'INITIAL CTXT SETUP-UNSPECIFIED'),(1,4125,'UE CTXT RELEASE-NORMAL RELEASE'),(2,4097,'RRC CONN SETUP-FAILURE IN RADIO PROCEDURE'),(2,4098,'S1 SIG CONN SETUP-TIME OUT'),(2,4106,'INITIAL CTXT SETUP-FAILURE IN RADIO PROCEDURE'),(2,4125,'UE CTXT RELEASE-AUTHENTICATION FAILURE'),(3,4097,'RRC CONN SETUP-EUTRAN GENERATED REASON'),(3,4098,'S1 SIG CONN SETUP-DSP RESTART'),(3,4106,'INITIAL CTXT SETUP-EUTRAN GENERATED REASON'),(3,4125,'UE CTXT RELEASE-DETACH'),(4,4097,'RRC CONN SETUP-CELL UNAVAILABLE'),(4,4106,'INITIAL CTXT SETUP-CELL UNAVAILABLE'),(4,4125,'UE CTXT RELEASE-LOAD BALANCING TAU REQUIRED'),(5,4097,'RRC CONN SETUP-LACK OF RESOURCES'),(5,4106,'INITIAL CTXT SETUP-LACK OF RESOURCES'),(5,4125,'UE CTXT RELEASE-CS FALLBACK TRIGGERED'),(6,4097,'RRC CONN SETUP-ACTIVE USER LICENSE EXCEEDED'),(6,4106,'INITIAL CTXT SETUP-ACTIVE USER LICENSE EXCEEDED'),(6,4125,'UE CTXT RELEASE-UE NOT AVAILABLE FOR PS SERVICES'),(7,4097,'RRC CONN SETUP-UNKNOWN ENBS1APID'),(7,4106,'INITIAL CTXT SETUP-UNKNOWN ENBS1APID'),(7,4125,'UE CTXT RELEASE-HANDOVER CANCELLED'),(8,4097,'RRC CONN SETUP-UE CAPABILITY ENQUIRY TIMEOUT'),(8,4106,'INITIAL CTXT SETUP-UE CAPABILITY ENQUIRY TIMEOUT'),(8,4125,'UE CTXT RELEASE-SUCCESSFUL HANDOVER'),(9,4097,'RRC CONN SETUP-S1 INTERFACE DOWN'),(9,4106,'INITIAL CTXT SETUP-MULTIPLE ERAB LICENSE EXCEEDED'),(9,4125,'UE CTXT RELEASE-RELEASE DUE TO EUTRAN GENERATED REASON'),(10,4097,'RRC CONN SETUP-INTRA LTE HANDOVER LICENSE REJECT'),(10,4106,'INITIAL CTXT SETUP-ONGOING HANDOVER'),(10,4125,'UE CTXT RELEASE-USER INACTIVITY'),(11,4097,'RRC CONN SETUP-REJECT DUE TO REATTEMPT'),(11,4106,'INITIAL CTXT SETUP-TRANSPORT REJECT'),(11,4125,'UE CTXT RELEASE-RADIO CONNECTION WITH UE LOST'),(12,4097,'RRC CONN SETUP-REJECT DUE TO OVERLOAD'),(12,4106,'INITIAL CTXT SETUP-DRB SETUP REJECT'),(12,4125,'UE CTXT RELEASE-RADIO RESOURCES NOT AVAILABLE'),(13,4097,'RRC CONN SETUP-UE BEARERS REJECTED DUE TO ARP ADM REJ'),(13,4106,'INITIAL CTXT SETUP-S1 INTERFACE DOWN'),(13,4125,'UE CTXT RELEASE-FAILURE IN THE RADIO INTERFACE PROCEDURE'),(14,4097,'RRC CONN SETUP-UE BEARERS REJECTED DUE TO LICENSES MISSING'),(14,4106,'INITIAL CTXT SETUP-ALLOCATION RETENTION REJECT'),(14,4125,'UE CTXT RELEASE-TRANSPORT RESOURCES UNAVAILABLE'),(15,4097,'RRC CONN SETUP-UE BEARERS REJECTED DUE TO ARP ADM REJ AND LICENSES MISSING'),(15,4106,'INITIAL CTXT SETUP-TO SECURITY SETUP'),(15,4125,'UE CTXT RELEASE-HANDOVER TRIGGERED'),(16,4097,'RRC CONN SETUP-DSP RESTART'),(16,4106,'INITIAL CTXT SETUP-FAILED SECURITY SETUP'),(16,4125,'UE CTXT RELEASE-PARTIAL HANDOVER'),(17,4106,'INITIAL CTXT SETUP-SRB2 SETUP FAILURE'),(17,4125,'UE CTXT RELEASE-HANDOVER FAILURE IN TARGET EPC ENB OR TARGET SYSTEM'),(18,4106,'INITIAL CTXT SETUP-RLCUM LICENSE MISSING'),(18,4125,'UE CTXT RELEASE-HANDOVER TARGET NOT ALLOWED'),(19,4106,'INITIAL CTXT SETUP-RLCUM CHANGE REJECT'),(19,4125,'UE CTXT RELEASE-TS1RELOC OVERALL EXPIRY'),(20,4106,'INITIAL CTXT SETUP-LSM EMERGENCY CALL LICENSE MISSING'),(20,4125,'UE CTXT RELEASE-TS1RELOC PREP EXPIRY'),(21,4106,'INITIAL CTXT SETUP-CIPHERING INTEGRITY ALG MISMATCH'),(21,4125,'UE CTXT RELEASE-UNKNOWN TARGET ID'),(22,4106,'INITIAL CTXT SETUP-CSFB LICENSE MISSING'),(22,4125,'UE CTXT RELEASE-NO RADIO RESOURCES AVAILABLE IN TARGET CELL'),(23,4106,'INITIAL CTXT SETUP-DSP RESTART'),(23,4125,'UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID'),(24,4106,'INITIAL CTXT SETUP-CSFB UNDEFINED MOB FREQ REL'),(24,4125,'UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED ENB UE S1AP ID'),(25,4125,'UE CTXT RELEASE-UNKNOWN OR INCONSISTENT PAIR OF UE S1AP ID'),(26,4125,'UE CTXT RELEASE-HANDOVER DESIRABLE FOR RADIO REASONS'),(27,4125,'UE CTXT RELEASE-TIME CRITICAL HANDOVER'),(28,4125,'UE CTXT RELEASE-RESOURCE OPTIMISATION HANDOVER'),(29,4125,'UE CTXT RELEASE-REDUCE LOAD IN SERVING CELL'),(30,4125,'UE CTXT RELEASE-TX2RELOC OVERALL EXPIRY'),(31,4125,'UE CTXT RELEASE-CELL NOT AVAILABLE'),(32,4125,'UE CTXT RELEASE-REDIRECTION TOWARDS 1XRTT'),(33,4125,'UE CTXT RELEASE-ENCRYPTION AND OR INTEGRITY ALGORITHMS NOT SUPPORTED');
/*!40000 ALTER TABLE `event_cause` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `failure_class`
--

DROP TABLE IF EXISTS `failure_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `failure_class` (
  `Failure_Class_Id` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`Failure_Class_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `failure_class`
--

LOCK TABLES `failure_class` WRITE;
/*!40000 ALTER TABLE `failure_class` DISABLE KEYS */;
INSERT INTO `failure_class` VALUES (0,'EMERGENCY'),(1,'HIGH PRIORITY ACCESS'),(2,'MT ACCESS'),(3,'MO SIGNALLING'),(4,'MO DATA');
/*!40000 ALTER TABLE `failure_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mcc_mnc`
--

DROP TABLE IF EXISTS `mcc_mnc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mcc_mnc` (
  `Mcc` int(11) NOT NULL,
  `Mnc` int(11) NOT NULL,
  `Country` varchar(40) NOT NULL,
  `Operator` varchar(40) NOT NULL,
  PRIMARY KEY (`Mcc`,`Mnc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mcc_mnc`
--

LOCK TABLES `mcc_mnc` WRITE;
/*!40000 ALTER TABLE `mcc_mnc` DISABLE KEYS */;
INSERT INTO `mcc_mnc` VALUES (238,1,'Denmark','TDC-DK'),(238,2,'Denmark','Sonofon DK '),(238,3,'Denmark','MIGway A/S DK '),(240,1,'Sweden','Telia Sonera-SE'),(240,2,'Sweden','H3G-SE'),(240,3,'Sweden','AINMT Sverige AB SE '),(240,20,'Sweden','iMEZ AB SE '),(240,21,'Sweden','Banverket SE '),(302,36,'Canada','Clearnet CA '),(302,37,'Canada','Microcell CA '),(302,62,'Canada','Ice Wireless CA '),(302,63,'Canada','Aliant Mobility CA '),(310,10,'United States of America','Verizon Wireless'),(310,12,'United States of America','Verizon Wireless'),(310,13,'United States of America','Verizon Wireless'),(310,540,'United States of America','Oklahoma Western Telephone Company US '),(310,550,'United States of America','Wireless Solutions International US '),(310,560,'United States of America','AT&T Mobility'),(310,570,'United States of America','MTPCS LLC US '),(310,580,'United States of America','Inland Cellular Telephone Company US '),(310,590,'United States of America','Verizon Wireless'),(340,1,'Guadeloupe-France','Orange-Caraibe'),(340,2,'Guadeloupe-France','Outremer Telecom GP '),(344,30,'Antigua and Barbuda','APUA PCS AG '),(344,920,'Antigua and Barbuda','Cable & Wireless-Antigua AG '),(344,930,'Antigua and Barbuda','AT&T Wireless-Antigua AG '),(405,0,'India','Shyam Telelink Ltd-Rajasthan IN '),(405,1,'India','Reliance Infocomm-IN'),(405,3,'India','Reliance Infocomm-IN'),(405,4,'India','Reliance Infocomm-IN'),(405,5,'India','Reliance Infocomm-IN'),(440,9,'Japan','NTT DoCoMo'),(440,10,'Japan','NTT DoCoMo'),(440,11,'Japan','NTT DoCoMo'),(505,62,'Australia','NBNCo Ltd AU '),(505,68,'Australia','NBNCo Ltd AU '),(505,71,'Australia','Telstra'),(505,72,'Australia','Telstra'),(505,88,'Australia','Localstar Holding Pty. Ltd. AU '),(505,90,'Australia','Optus Ltd. AU ');
/*!40000 ALTER TABLE `mcc_mnc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ue_table`
--

DROP TABLE IF EXISTS `ue_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ue_table` (
  `Tac` int(11) NOT NULL,
  `Marketing_Name` varchar(50) NOT NULL,
  `Manufacturer` varchar(50) NOT NULL,
  `Access_Cpability` varchar(50) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Vendor_Name` varchar(50) NOT NULL,
  `UE_Type` varchar(50) DEFAULT NULL,
  `OS` varchar(50) DEFAULT NULL,
  `Input_Mode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Tac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ue_table`
--

LOCK TABLES `ue_table` WRITE;
/*!40000 ALTER TABLE `ue_table` DISABLE KEYS */;
INSERT INTO `ue_table` VALUES (100100,'G410','Mitsubishi','GSM 1800, GSM 900','G410','Mitsubishi','(null)','(null)','(null)'),(100200,'A53','Siemens','GSM 1900, GSM850 (GSM800)','A53','Siemens','HANDHELD','(null)','BASIC'),(100300,'TBD (AAB-1880030-BV)','Sony Ericsson','GSM 1900, GSM850 (GSM800)','TBD (AAB-1880030-BV)','Sony Ericsson','HANDHELD','(null)','(null)'),(100400,'RM-669','Nokia','GSM 1900, GSM850 (GSM800)','RM-669','Nokia','(null)','(null)','(null)'),(100500,'M930 NA DB','Motorola','GSM 1900, GSM850 (GSM800)','M930 NA DB','Motorola','HANDHELD','(null)','(null)'),(100600,'EBX700','Panasonic','GSM 1800, GSM 1900, GSM 900','EBX700','Panasonic','(null)','(null)','(null)'),(100700,'Test IMEI','Sagem','GSM 1900','Test IMEI','Sagem','(null)','(null)','(null)'),(100800,'TCD718','Philips','GSM 1900','TCD718','Philips','(null)','(null)','(null)'),(100900,'Test IMEI','Sony','GSM 1900','Test IMEI','Sony','(null)','(null)','(null)'),(101000,'Test IMEI','Casio Hitachi Mobile Communications','GSM 1900','Test IMEI','Casio Hitachi Mobile Communications','(null)','(null)','(null)'),(101300,'LMU','Nortel','GSM 1900','LMU','Nortel','(null)','(null)','(null)'),(101500,'GX-28','Sharp','GSM 1800, GSM 1900, GSM850 (GSM800)','GX-28','Sharp','HANDHELD','(null)','(null)'),(101600,'ALCATEL OT-807A','TCT Mobile Suzhou Limited','GSM 1900, GSM850 (GSM800)','ALCATEL OT-807A','TCT Mobile Suzhou Limited','(null)','(null)','(null)'),(101700,'Wireless CPU Q2687','Wavecom','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','Wireless CPU Q2687','Wavecom','M2M','(null)','(null)'),(101710,'WMO2-g1900','Wavecom','GSM 1900','WMO2-g1900','Wavecom','M2M','(null)','(null)'),(102000,'RAP40GW','RIM','GSM 1800, GSM 900','RAP40GW','RIM','HANDHELD','BLACKBERRY','QWERTY'),(102100,'MX-5010','Shintom Co. Ltd','GSM 1800, GSM 1900, GSM 900','MX-5010','Shintom Co. Ltd','(null)','(null)','(null)'),(102200,'Zoarmon','Intel','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','Zoarmon','Intel','(null)','(null)','(null)'),(102300,'SGH-t829','Samsung','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','SGH-t829','Samsung','HANDHELD','(null)','(null)'),(102400,'Telguard 5 (TG5)','Telular Corp','GSM 1900, GSM850 (GSM800)','Telguard 5 (TG5)','Telular Corp','(null)','(null)','(null)'),(102500,'Fizgig','Option NV','GSM 1800, GSM 1900, GSM 900','Fizgig','Option NV','(null)','(null)','(null)'),(102600,'KMP6J1S1-6','NEC','GSM 1800, GSM 1900, GSM 900','KMP6J1S1-6','NEC','(null)','(null)','(null)'),(102800,'U1','Danger Inc.','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','U1','Danger Inc.','(null)','(null)','(null)'),(102900,'Ferry','Quanta Computer','GSM 1900','Ferry','Quanta Computer','(null)','(null)','(null)'),(103000,'700C','Intermec Technologies Corp.','GSM 1800, GSM 1900, GSM 900','700C','Intermec Technologies Corp.','(null)','(null)','(null)'),(103100,'K1','Sendo Ltd','GSM 1900, GSM850 (GSM800)','K1','Sendo Ltd','(null)','(null)','(null)'),(103200,'7525 Workabout pro','Psion Teklogix Inc.','GSM 1800, GSM 1900, GSM 900','7525 Workabout pro','Psion Teklogix Inc.','(null)','(null)','(null)'),(103300,'Benefon Track Box','benefon oyj','GSM 1900, GSM 900','Benefon Track Box','benefon oyj','(null)','(null)','(null)'),(103600,'GSM5108','Enfora','GPRS','GSM5108','Enfora','M2M','(null)','(null)'),(103700,'TM3000-C ATD','Trimble','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','TM3000-C ATD','Trimble','(null)','(null)','(null)'),(103800,'G1000','Sanyo','GSM 1800, GSM 1900, GSM 900','G1000','Sanyo','(null)','(null)','(null)'),(103900,'AGM 1100','Accetio, Inc.','GSM 1800, GSM 1900, GSM 900','AGM 1100','Accetio, Inc.','(null)','(null)','(null)'),(104100,'ITH155/MGH900','Mirae Comm Co Ltd','GSM 1800, GSM 1900, GSM 900','ITH155/MGH900','Mirae Comm Co Ltd','(null)','(null)','(null)'),(104200,'CF-29/CF-18/CF-73/CF-P1','Matsushita','GSM 1800, GSM 1900, GSM850 (GSM800)','CF-29/CF-18/CF-73/CF-P1','Matsushita','(null)','(null)','(null)'),(104400,'H6xxx','Compal Com.inc','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','H6xxx','Compal Com.inc','(null)','(null)','(null)'),(104500,'Artema Mobile Secure GPRS','Thales e-Transactions GmbH','GSM 1900, GSM850 (GSM800)','Artema Mobile Secure GPRS','Thales e-Transactions GmbH','(null)','(null)','(null)'),(104600,'TS34','Toshiba','GSM 1800, GSM 900','TS34','Toshiba','(null)','(null)','(null)'),(104700,'PLD','PowerLOC Technologies Inc.','GSM 1900, GSM850 (GSM800)','PLD','PowerLOC Technologies Inc.','(null)','(null)','(null)'),(104800,'1000-1146','Arbitron','GSM 1800, GSM 900','1000-1146','Arbitron','(null)','(null)','(null)'),(105000,'GU-1000','Curitel Communications. Inc.','GSM 1800, GSM 1900, GSM 900','GU-1000','Curitel Communications. Inc.','(null)','(null)','(null)'),(105200,'VK530','VK Corporation','GSM 1900, GSM850 (GSM800)','VK530','VK Corporation','(null)','(null)','(null)'),(105300,'BM3-891G GPRS OEM Modem','Wavenet Technology','GPRS','BM3-891G GPRS OEM Modem','Wavenet Technology','M2M','(null)','(null)'),(105400,'P7','Qingdao Haier Telecom','GSM 1800, GSM 1900, GSM 900','P7','Qingdao Haier Telecom','(null)','(null)','(null)'),(105500,'PLD100 series','Destinator Technologies','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','PLD100 series','Destinator Technologies','(null)','(null)','(null)'),(105600,'Jembi','Psitek','GSM 1900, GSM850 (GSM800)','Jembi','Psitek','(null)','(null)','(null)'),(105700,'U-300','Telian','GSM 1800, GSM 1900, GSM 900','U-300','Telian','(null)','(null)','(null)'),(105900,'DM1000G','Waxess Inc','GSM 1900, GSM850 (GSM800)','DM1000G','Waxess Inc','(null)','(null)','(null)'),(106200,'SM5100B','Spreadtrum','GSM 1900, GSM850 (GSM800)','SM5100B','Spreadtrum','M2M','(null)','(null)'),(106400,'Debussy','CMCS','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','Debussy','CMCS','(null)','(null)','(null)'),(106500,'GX820','CalAmp','GSM 1900, GSM850 (GSM800)','GX820','CalAmp','(null)','(null)','(null)'),(106600,'WRTU54G','Cisco Systems','GSM 1800, GSM 900','WRTU54G','Cisco Systems','(null)','(null)','(null)'),(106700,'whereQube201','Geometris','GSM 1800, GSM 1900, GSM850 (GSM800)','whereQube201','Geometris','(null)','(null)','(null)'),(106900,'R100','Firefly Mobile','GSM 1900, GSM850 (GSM800)','R100','Firefly Mobile','(null)','(null)','(null)'),(107100,'Dolphin 9900','Handheld Products, Inc d/b/a HHP','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','Dolphin 9900','Handheld Products, Inc d/b/a HHP','(null)','(null)','(null)'),(107200,'Test IMEI','Apple','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','Test IMEI','Apple','(null)','IOS','TOUCH_SCREEN'),(107400,'Nurit 8020','VeriFone','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','Nurit 8020','VeriFone','(null)','(null)','(null)'),(107800,'247910','Garmin International','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','247910','Garmin International','(null)','(null)','(null)'),(107900,'Machine Gateway','Phoenix International','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','Machine Gateway','Phoenix International','(null)','(null)','(null)'),(108000,'XP3300-AR1 (P25C005AA)','Sonim Technologies','GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)','XP3300-AR1 (P25C005AA)','Sonim Technologies','(null)','(null)','(null)'),(116000,'Test IMEI','Omnipoint','GSM 1900','Test IMEI','Omnipoint','(null)','(null)','(null)'),(21060800,'VEA3','S.A.R.L. B  & B International','GSM 1800, GSM 900','VEA3','S.A.R.L. B  & B International','(null)','(null)','(null)'),(33000153,'9109 PA','Alcatel Radiotelephone (LAVAL)','GSM 900','9109 PA','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33000253,'Dirland Miniphone','Alcatel Radiotelephone (LAVAL)','GSM 900','Dirland Miniphone','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33000353,'9109PA','Alcatel Radiotelephone','GSM 900','9109PA','Alcatel Radiotelephone','(null)','(null)','(null)'),(33000453,'Lisa 9030 Type 9109H','Alcatel Radiotelephone (LAVAL)','GSM 900','Lisa 9030 Type 9109H','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33000553,'Dirland Mobiphone','Alcatel Radiotelephone (LAVAL)','GSM 900','Dirland Mobiphone','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33000635,'Mitsubishi GSM MT-1000F02A','Mitsubishi Electric France','GSM 900','Mitsubishi GSM MT-1000F02A','Mitsubishi Electric France','(null)','(null)','(null)'),(33000753,'Audiovox Type GSM 510','Alcatel Radiotelephone (LAVAL)','GSM 900','Audiovox Type GSM 510','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33000853,'Dirland Type Miniphone III','Alcatel Radiotelephone (LAVAL)','GSM 900','Dirland Type Miniphone III','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33000953,'GSM 510 Type Audiovox HB 160','Alcatel Radiotelephone (LAVAL)','GSM 900','GSM 510 Type Audiovox HB 160','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33001053,'Vodafone VN 2121','Alcatel Radiotelephone (LAVAL)','GSM 900','Vodafone VN 2121','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33001195,'Sagem Type G 14','Sagem','GSM 900','Sagem Type G 14','Sagem','(null)','(null)','(null)'),(33001235,'RC410/430 Type G14-1','Sagem','GSM 900','RC410/430 Type G14-1','Sagem','(null)','(null)','(null)'),(33001295,'RC410/430 Type G14-1','Sagem','GSM 900','RC410/430 Type G14-1','Sagem','(null)','(null)','(null)'),(33001453,'Pocketline Tango Type NPTT HC 400','Alcatel Radiotelephone (LAVAL)','GSM 900','Pocketline Tango Type NPTT HC 400','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33001553,'Alcatel Airtel HC 600 Type Airtel HC 600','Alcatel Radiotelephone (LAVAL)','GSM 900','Alcatel Airtel HC 600 Type Airtel HC 600','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33001635,'Affinity/Affinity 930 Type G14-S','Sagem','GSM 900','Affinity/Affinity 930 Type G14-S','Sagem','(null)','(null)','(null)'),(33001695,'Affinity/Affinity 930 Type G14-S','Sagem','GSM 900','Affinity/Affinity 930 Type G14-S','Sagem','(null)','(null)','(null)'),(33001735,'Mitsubishi GSM MT 20 Type MT 1171FD2','Mitsubishi Electric France','GSM 900','Mitsubishi GSM MT 20 Type MT 1171FD2','Mitsubishi Electric France','(null)','(null)','(null)'),(33001835,'Mitsubishi GSM MT 10 Type MT 1176F02','Mitsubishi Electric France','GSM 900','Mitsubishi GSM MT 10 Type MT 1176F02','Mitsubishi Electric France','(null)','(null)','(null)'),(33001953,'Alcatel 9100 Type 9109 HC 500','Alcatel Radiotelephone (LAVAL)','GSM 900','Alcatel 9100 Type 9109 HC 500','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33002053,'Alcatel 9100 Type 9109 HC 800','Alcatel Radiotelephone (LAVAL)','GSM 900','Alcatel 9100 Type 9109 HC 800','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33002135,'Detewe CP-ONE Type G14.1','Sagem','GSM 900','Detewe CP-ONE Type G14.1','Sagem','(null)','(null)','(null)'),(33002195,'Detewe CP-ONE Type G14.1','Sagem','GSM 900','Detewe CP-ONE Type G14.1','Sagem','(null)','(null)','(null)'),(33002235,'RM 833-/S/R Type G14-S','Sagem','GSM 900','RM 833-/S/R Type G14-S','Sagem','(null)','(null)','(null)'),(33002295,'RM 833-/S/R Type G14-S','Sagem','GSM 900','RM 833-/S/R Type G14-S','Sagem','(null)','(null)','(null)'),(33002353,'Alcatel Movistar HC 100 Type Telefonica HC 1000','Alcatel Radiotelephone (LAVAL)','GSM 900','Alcatel Movistar HC 100 Type Telefonica HC 1000','Alcatel Radiotelephone (LAVAL)','(null)','(null)','(null)'),(33002499,'SGH 200','Samsung','GSM 900','SGH 200','Samsung','HANDHELD','(null)','(null)'),(33002535,'Mitsubishi GSM MT11 Type MT 1177 F02A','Mitsubishi Electric France','GSM 900','Mitsubishi GSM MT11 Type MT 1177 F02A','Mitsubishi Electric France','(null)','(null)','(null)'),(33002635,'Mitsubishi GSM MT20 D Type MT 1172 F02A','Mitsubishi Electric France','GSM 900','Mitsubishi GSM MT20 D Type MT 1172 F02A','Mitsubishi Electric France','(null)','(null)','(null)');
/*!40000 ALTER TABLE `ue_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `User_Password` varchar(45) NOT NULL,
  `UserType` varchar(45) NOT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Thomas','1234','administrator\r'),(2,'Ivan','1234','Network engineer\r'),(3,'Paul','1234','Network engineer\r'),(4,'Mark','1234','support engineer\r'),(5,'Brian','1234','support engineer\r'),(6,'Suzzane','1234','customer rep\r'),(7,'Ciaran','1234','customer rep\r'),(8,'Navi','1234','Network engineer\r'),(9,'Kang','1234','support engineer\r'),(10,'Marco','1234','administrator\r');
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

-- Dump completed on 2016-02-17 21:03:32
