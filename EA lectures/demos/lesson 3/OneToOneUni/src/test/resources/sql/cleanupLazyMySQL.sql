-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eacore
-- ------------------------------------------------------
-- Server version	5.6.26-log
 

// LOCK TABLES `membr` WRITE;
/*!40000 ALTER TABLE `membr` DISABLE KEYS */;
TRUNCATE TABLE `membr` ;
/*!40000 ALTER TABLE `membr` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `credentials` WRITE;
/*!40000 ALTER TABLE `credentials` DISABLE KEYS */;
SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE TABLE `credentials`;
SET FOREIGN_KEY_CHECKS = 1; 
/*!40000 ALTER TABLE `credentials` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2017-04-10 22:09:29
