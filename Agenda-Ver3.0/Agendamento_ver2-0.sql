CREATE DATABASE  IF NOT EXISTS `agendamento` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agendamento`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: agendamento
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `compromisso_evento`
--

DROP TABLE IF EXISTS `compromisso_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compromisso_evento` (
  `ID_compromisso` int NOT NULL AUTO_INCREMENT,
  `ID_usuario` int DEFAULT NULL,
  `Titulo_compromisso` varchar(255) NOT NULL,
  `descricao_compromisso` text,
  `data` varchar(20) NOT NULL,
  `hora` time NOT NULL,
  `localizacao` varchar(100) DEFAULT 'Nenhum',
  PRIMARY KEY (`ID_compromisso`),
  KEY `fk_Compromisso_user` (`ID_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compromisso_evento`
--

LOCK TABLES `compromisso_evento` WRITE;
/*!40000 ALTER TABLE `compromisso_evento` DISABLE KEYS */;
INSERT INTO `compromisso_evento` VALUES (1,4,'Bailao diadema','baile da penha pocando','19/06/2024','00:30:00','Diadema Sp'),(2,4,'bailao','E O BAILAO','21/06/2024','00:15:00','diadema'),(3,5,'SERRAO','SERRAO CARAI','20/06/2024','01:45:00','SERRAO MG');
/*!40000 ALTER TABLE `compromisso_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compromisso_tarefa`
--

DROP TABLE IF EXISTS `compromisso_tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compromisso_tarefa` (
  `id_compromisso_tarefa` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `titulo_compromisso` varchar(255) NOT NULL,
  `data_inicial` varchar(20) NOT NULL,
  `hora_inicial` time NOT NULL,
  `data_final` varchar(20) NOT NULL,
  `hora_final` time NOT NULL,
  `prioridade` varchar(20) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id_compromisso_tarefa`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compromisso_tarefa`
--

LOCK TABLES `compromisso_tarefa` WRITE;
/*!40000 ALTER TABLE `compromisso_tarefa` DISABLE KEYS */;
INSERT INTO `compromisso_tarefa` VALUES (1,4,'almoçar','19/06/2024','12:00:00','19/06/2024','12:00:00','Média Prioridade','almoçar com mae');
/*!40000 ALTER TABLE `compromisso_tarefa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `gmail` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `nome` (`nome`),
  UNIQUE KEY `gmail` (`gmail`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Rodrigo123123','testesql@gmail.com','1232123'),(2,'miojao mixirica','sushidog@gmail.com','sanduba_de_marmitex'),(3,'lucas','lucaspaqueta@gmail.com','123'),(4,'julio','julio@gmail.com','123'),(5,'nicolas','nicolas@gmail.com','123'),(6,'nomealeatorio','aleatorio@gmail.com','123'),(7,'gustavo','gustavo@gmail.com','123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-15 12:32:44
