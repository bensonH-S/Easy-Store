CREATE DATABASE  IF NOT EXISTS `sistemavendas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistemavendas`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sistemavendas
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

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
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bairro` (
  `id_bairro` int(11) NOT NULL AUTO_INCREMENT,
  `nome_bairro` varchar(50) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  PRIMARY KEY (`id_bairro`),
  KEY `id_cidade` (`id_cidade`),
  CONSTRAINT `bairro_ibfk_1` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id_cidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairro`
--

LOCK TABLES `bairro` WRITE;
/*!40000 ALTER TABLE `bairro` DISABLE KEYS */;
/*!40000 ALTER TABLE `bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caixa` (
  `id_caixa` int(11) NOT NULL AUTO_INCREMENT,
  `saldo_inicial` double DEFAULT NULL,
  `total_caixa` float DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` varchar(15) DEFAULT NULL,
  `data_fechamento` varchar(50) DEFAULT NULL,
  `hora_fechamento` varchar(30) DEFAULT NULL,
  `saldo_final` float DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_caixa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixa`
--

LOCK TABLES `caixa` WRITE;
/*!40000 ALTER TABLE `caixa` DISABLE KEYS */;
INSERT INTO `caixa` VALUES (1,0,0,'2018-01-18','10:00','2018/01/2018','12:00',0,'fechado ');
/*!40000 ALTER TABLE `caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Padrão');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chaveacesso`
--

DROP TABLE IF EXISTS `chaveacesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chaveacesso` (
  `id_chave` int(11) NOT NULL AUTO_INCREMENT,
  `chave` varchar(100) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `datavenc` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_chave`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chaveacesso`
--

LOCK TABLES `chaveacesso` WRITE;
/*!40000 ALTER TABLE `chaveacesso` DISABLE KEYS */;
INSERT INTO `chaveacesso` VALUES (1,'0000','','17012018');
/*!40000 ALTER TABLE `chaveacesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `id_cidade` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cidade` varchar(50) NOT NULL,
  `id_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_cidade`),
  KEY `id_estado` (`id_estado`),
  CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(50) NOT NULL,
  `endereco_cliente` varchar(30) DEFAULT NULL,
  `rg_cliente` varchar(20) DEFAULT NULL,
  `cpf_cliente` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `id_cidade` int(11) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `limite_compra` float DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `sexo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `fornecedor` varchar(60) DEFAULT NULL,
  `numero_nota` int(11) DEFAULT NULL,
  `data_emissao` date DEFAULT NULL,
  `total_produtos` float DEFAULT NULL,
  `desconto` float DEFAULT NULL,
  `total_nota` float DEFAULT NULL,
  `tipo_pagamento` varchar(25) DEFAULT NULL,
  `vendedor` varchar(30) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `despesas`
--

DROP TABLE IF EXISTS `despesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `despesas` (
  `id_despesa` int(11) NOT NULL AUTO_INCREMENT,
  `nome_despesa` varchar(50) NOT NULL,
  PRIMARY KEY (`id_despesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despesas`
--

LOCK TABLES `despesas` WRITE;
/*!40000 ALTER TABLE `despesas` DISABLE KEYS */;
/*!40000 ALTER TABLE `despesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `nomefantasia` varchar(50) NOT NULL,
  `cnpj` varchar(25) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nome_estado` varchar(20) NOT NULL,
  `sigla_estado` varchar(2) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'CEARA','CE'),(2,'SAO PAULO','SP'),(3,'BAHIA','BA'),(4,'ESPIRITO SANTO','ES'),(5,'RIO DE JANEIRO','RJ'),(6,'PIAUI','PI'),(7,'GOIAS','GO'),(8,'PARANA','PR'),(9,'RIO GRANDE DO SUL','RS'),(10,'MINAS GERAIS','MG'),(11,'SANTA CATARINA','SC'),(12,'PARA','PA'),(13,'PERNAMBUCO','PE'),(14,'AMAZONAS','AM'),(15,'MARANHAO','MA'),(16,'DISTRITO FEDERAL','DF'),(17,'MATO GROSSO','MT'),(18,'MATO GROSSO DO SUL','MS'),(19,'ACRE','AC'),(20,'PARAIBA','PB'),(21,'ALAGOAS','AL'),(22,'RORAIMA','RR'),(23,'RONDONIA','RO'),(24,'RIO GRANDE DO NORTE','RN'),(25,'TOCANTINS','TO'),(26,'SERGIPE','SE'),(27,'AMAPA','AP');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `nome_fornecedor` varchar(35) NOT NULL,
  `endereco_fornecedor` varchar(35) DEFAULT NULL,
  `id_bairro` int(11) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(25) DEFAULT NULL,
  `cnpj` varchar(30) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `celular` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nomefantasia` varchar(50) DEFAULT NULL,
  `ie` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_fornecedor`),
  KEY `id_bairro` (`id_bairro`),
  CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`id_bairro`) REFERENCES `bairro` (`id_bairro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Fornecedor Padrão','Não cadastrado',NULL,'paranoá','brasília','DF','000000','000000','000000','Não cadastrado','Padrão','000000');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_compra_produto`
--

DROP TABLE IF EXISTS `itens_compra_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens_compra_produto` (
  `id_compra` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_compra_produto`
--

LOCK TABLES `itens_compra_produto` WRITE;
/*!40000 ALTER TABLE `itens_compra_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_compra_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_venda_produto`
--

DROP TABLE IF EXISTS `itens_venda_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens_venda_produto` (
  `id_venda` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade_produto` int(11) NOT NULL,
  KEY `id_venda` (`id_venda`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `itens_venda_produto_ibfk_1` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`),
  CONSTRAINT `itens_venda_produto_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_venda_produto`
--

LOCK TABLES `itens_venda_produto` WRITE;
/*!40000 ALTER TABLE `itens_venda_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_venda_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcela_cartao`
--

DROP TABLE IF EXISTS `parcela_cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcela_cartao` (
  `id_parc_venda` int(11) NOT NULL AUTO_INCREMENT,
  `cod_venda` int(11) DEFAULT NULL,
  `valor_venda` float DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `numero_parcela` int(11) DEFAULT NULL,
  `valor_parc` float DEFAULT NULL,
  `datavenc` date DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `recebido` float DEFAULT NULL,
  `bandeira` varchar(30) DEFAULT NULL,
  `tipo_pagamento` varchar(15) DEFAULT NULL,
  `datavenda` date DEFAULT NULL,
  `datarecebimento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_parc_venda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcela_cartao`
--

LOCK TABLES `parcela_cartao` WRITE;
/*!40000 ALTER TABLE `parcela_cartao` DISABLE KEYS */;
/*!40000 ALTER TABLE `parcela_cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcela_compra`
--

DROP TABLE IF EXISTS `parcela_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcela_compra` (
  `id_parc_compra` int(11) NOT NULL AUTO_INCREMENT,
  `cod_compra` int(11) DEFAULT NULL,
  `valor_compra` float DEFAULT NULL,
  `valor_nota` float DEFAULT NULL,
  `numero_parcela` int(11) DEFAULT NULL,
  `valor_parc` float DEFAULT NULL,
  `datavenc` date DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `valor_parcial` int(11) DEFAULT NULL,
  `valor_resta` float DEFAULT NULL,
  `pago` float DEFAULT NULL,
  `id_fornecedor` int(11) DEFAULT NULL,
  `datavenda` date DEFAULT NULL,
  `datarecebimento` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_parc_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcela_compra`
--

LOCK TABLES `parcela_compra` WRITE;
/*!40000 ALTER TABLE `parcela_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `parcela_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcela_venda`
--

DROP TABLE IF EXISTS `parcela_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcela_venda` (
  `id_parc_venda` int(11) NOT NULL AUTO_INCREMENT,
  `cod_venda` int(11) DEFAULT NULL,
  `valor_venda` float DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `numero_parcela` int(11) DEFAULT NULL,
  `valor_parc` float DEFAULT NULL,
  `datavenc` date DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `valor_parcial` float DEFAULT NULL,
  `valor_resta` float DEFAULT NULL,
  `pago` float DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `datavenda` date DEFAULT NULL,
  `datarecebimento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_parc_venda`),
  KEY `cod_venda` (`cod_venda`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `parcela_venda_ibfk_1` FOREIGN KEY (`cod_venda`) REFERENCES `venda` (`id_venda`),
  CONSTRAINT `parcela_venda_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcela_venda`
--

LOCK TABLES `parcela_venda` WRITE;
/*!40000 ALTER TABLE `parcela_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `parcela_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `codigobarras` varchar(100) DEFAULT NULL,
  `nome_produto` varchar(50) NOT NULL,
  `preco_compra` float DEFAULT NULL,
  `lucrovenda` float DEFAULT NULL,
  `lucro_esperado` float DEFAULT NULL,
  `preco_venda` float NOT NULL,
  `quantidade` int(11) NOT NULL,
  `quantidade_minima` int(11) NOT NULL,
  `id_fornecedor` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `unidade` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cartao`
--

DROP TABLE IF EXISTS `tbl_cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cartao` (
  `id_venda_cartao` int(11) NOT NULL AUTO_INCREMENT,
  `id_venda` int(11) NOT NULL,
  `id_caixa` int(11) NOT NULL,
  `entrada_cartao` float NOT NULL,
  `parcelas` int(11) NOT NULL,
  `tipo_cartao` varchar(25) DEFAULT NULL,
  `total_venda` float NOT NULL,
  `data_venda` varchar(30) NOT NULL,
  `tipo_pagamento` varchar(30) NOT NULL,
  PRIMARY KEY (`id_venda_cartao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cartao`
--

LOCK TABLES `tbl_cartao` WRITE;
/*!40000 ALTER TABLE `tbl_cartao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cartao_debito`
--

DROP TABLE IF EXISTS `tbl_cartao_debito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cartao_debito` (
  `id_debito` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) NOT NULL,
  `valor_venda` float NOT NULL,
  `valor_total` float DEFAULT NULL,
  `id_venda` int(11) NOT NULL,
  `data_venda` date NOT NULL,
  `pagamento` varchar(20) NOT NULL,
  `bandeira` varchar(20) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id_debito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cartao_debito`
--

LOCK TABLES `tbl_cartao_debito` WRITE;
/*!40000 ALTER TABLE `tbl_cartao_debito` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cartao_debito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_entrada`
--

DROP TABLE IF EXISTS `tbl_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_entrada` (
  `id_entrada` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  `data_venda` varchar(20) DEFAULT NULL,
  `valor_entrada` float DEFAULT NULL,
  `tipo_pagamento` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_entrada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_entrada`
--

LOCK TABLES `tbl_entrada` WRITE;
/*!40000 ALTER TABLE `tbl_entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_entrada_cartao`
--

DROP TABLE IF EXISTS `tbl_entrada_cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_entrada_cartao` (
  `id_entrada_cartao` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) NOT NULL,
  `valor_pago` float NOT NULL,
  `data_recebimento` date NOT NULL,
  `id_venda` int(11) NOT NULL,
  PRIMARY KEY (`id_entrada_cartao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_entrada_cartao`
--

LOCK TABLES `tbl_entrada_cartao` WRITE;
/*!40000 ALTER TABLE `tbl_entrada_cartao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_entrada_cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_entrada_crediario`
--

DROP TABLE IF EXISTS `tbl_entrada_crediario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_entrada_crediario` (
  `id_crediario` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `valor_pago` float DEFAULT NULL,
  `data_recebimento` date DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_crediario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_entrada_crediario`
--

LOCK TABLES `tbl_entrada_crediario` WRITE;
/*!40000 ALTER TABLE `tbl_entrada_crediario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_entrada_crediario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_entrada_venda`
--

DROP TABLE IF EXISTS `tbl_entrada_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_entrada_venda` (
  `id_entrada_venda` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `valor_venda` float DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  `data_venda` varchar(20) DEFAULT NULL,
  `tipo_pagamento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_entrada_venda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_entrada_venda`
--

LOCK TABLES `tbl_entrada_venda` WRITE;
/*!40000 ALTER TABLE `tbl_entrada_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_entrada_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_registrar_despesa`
--

DROP TABLE IF EXISTS `tbl_registrar_despesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_registrar_despesa` (
  `id_registro_despesa` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(250) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `data` date DEFAULT NULL,
  `id_caixa` int(11) NOT NULL,
  PRIMARY KEY (`id_registro_despesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_registrar_despesa`
--

LOCK TABLES `tbl_registrar_despesa` WRITE;
/*!40000 ALTER TABLE `tbl_registrar_despesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_registrar_despesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_saida`
--

DROP TABLE IF EXISTS `tbl_saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_saida` (
  `id_saida` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `id_compra` int(11) DEFAULT NULL,
  `data_compra` date DEFAULT NULL,
  `valor_saida` float DEFAULT NULL,
  `tipo_pagamento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_saida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_saida`
--

LOCK TABLES `tbl_saida` WRITE;
/*!40000 ALTER TABLE `tbl_saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_saida_crediario`
--

DROP TABLE IF EXISTS `tbl_saida_crediario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_saida_crediario` (
  `id_saida_crediario` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) NOT NULL,
  `valor_pago` float NOT NULL,
  `data_recebimento` date NOT NULL,
  `id_compra` int(11) NOT NULL,
  PRIMARY KEY (`id_saida_crediario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_saida_crediario`
--

LOCK TABLES `tbl_saida_crediario` WRITE;
/*!40000 ALTER TABLE `tbl_saida_crediario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_saida_crediario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `level` int(5) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'GestorWeb','123',0,'Administrador '),(2,'Benson','1833',3,'Analista ');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `data_venda` date DEFAULT NULL,
  `valor_venda` float NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `tipo_pagamento` varchar(30) DEFAULT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  `vendedor` varchar(25) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,'2018-01-17',0,0,'Dinheiro ',1,'ADMINISTRADOR ','finalizada ');
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-17 15:30:31
