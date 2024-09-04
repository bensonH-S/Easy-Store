-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Nov 09, 2017 as 04:20 PM
-- Versão do Servidor: 5.5.8
-- Versão do PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `sistemavendas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bairro`
--

CREATE TABLE IF NOT EXISTS `bairro` (
  `id_bairro` int(11) NOT NULL AUTO_INCREMENT,
  `nome_bairro` varchar(50) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  PRIMARY KEY (`id_bairro`),
  KEY `id_cidade` (`id_cidade`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `bairro`
--

INSERT INTO `bairro` (`id_bairro`, `nome_bairro`, `id_cidade`) VALUES
(1, 'BELA VISTA', 1),
(2, 'PICARRA', 1),
(3, 'CENTRO', 1),
(4, 'PAU FERRADO', 1),
(6, 'ESMERINO GOMES', 1),
(7, 'BARATEIRO', 1),
(8, 'RUA DO ACUDE', 1),
(9, 'SANTA RITA', 1),
(11, 'FERROS', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE IF NOT EXISTS `caixa` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `caixa`
--

INSERT INTO `caixa` (`id_caixa`, `saldo_inicial`, `total_caixa`, `data`, `hora`, `data_fechamento`, `hora_fechamento`, `saldo_final`, `status`) VALUES
(2, 200, 1570, '2017-11-06', '04:28', '07-11-2017', '04:41', 170, 'fechado'),
(3, 170, -2194, '2017-11-07', '04:41', '07-11-2017', '08:43', 0, 'fechado'),
(4, 0, 368.05, '2017-11-07', '08:44', '08-11-2017', '03:38', 0, 'fechado'),
(5, 0, NULL, '2017-11-08', '03:42', NULL, NULL, NULL, 'aberto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nome_categoria`) VALUES
(1, 'VARIADOS'),
(2, 'TV LED'),
(3, 'FONES'),
(4, 'TECLADO'),
(5, 'MOUSE');

-- --------------------------------------------------------

--
-- Estrutura da tabela `chaveacesso`
--

CREATE TABLE IF NOT EXISTS `chaveacesso` (
  `id_chave` int(11) NOT NULL AUTO_INCREMENT,
  `chave` varchar(100) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_chave`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `chaveacesso`
--

INSERT INTO `chaveacesso` (`id_chave`, `chave`, `status`) VALUES
(2, '1234567', 'USADA'),
(3, '123456', 'USADA'),
(4, '123', 'USADA'),
(5, '1234', 'USADA'),
(6, '12345', 'USADA'),
(7, '12345678', 'USADA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE IF NOT EXISTS `cidade` (
  `id_cidade` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cidade` varchar(50) NOT NULL,
  `id_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_cidade`),
  KEY `id_estado` (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id_cidade`, `nome_cidade`, `id_estado`) VALUES
(1, 'ITAPAJE', 1),
(2, 'IRAUCUBA', 1),
(3, 'SOBRAL', 1),
(4, 'FORTALEZA', 1),
(5, 'SAO LUIS CURU', 1),
(6, 'SAO GONCALO', 1),
(7, 'PARACURU', 1),
(8, 'PARAIPABA', 1),
(9, 'UMIRIM', 1),
(10, 'FORQUILHA', 1),
(11, 'CAMOCIM', 1),
(12, 'MARACANAU', 1),
(13, 'CAUCAIA', 1),
(14, 'URUBURETAMA', 1),
(15, 'ITAPIPOCA', 1),
(16, 'CRUZ', 1),
(17, 'BELA CRUZ', 1),
(18, 'JIJOCA', 1),
(19, 'JERICOACORA', 1),
(20, 'AMONTADA', 1),
(21, 'MASSAPE', 1),
(22, 'ACARAU', 1),
(24, 'TEJUCUOCA', 1),
(26, 'CANINDE', 1),
(27, 'PREA', 1),
(28, 'CRATEUS', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nome_cliente`, `endereco_cliente`, `rg_cliente`, `cpf_cliente`, `bairro`, `id_cidade`, `telefone`, `limite_compra`, `email`, `apelido`, `sexo`) VALUES
(1, 'NAO CADASTRADO', 'ENDERECO', 'RG', 'CPF', 'BAIRRO', 15, 'TELEFONE', 0, 'EMAIL', 'APELIDO', 'Masculino'),
(2, 'JOSE CYRO CRUZ SOUSA', 'CRISTINA BASTOS. 148', '20200002200', '20020202020', 'BELA VISTA', 1, '33460432', 1200, 'cyrojames@gmail.com', 'JAMES', 'Masculino'),
(3, 'LEBRON JAMES', 'LEBRON AVENUE', '020202020', '0202020202', 'CLEVELAND', 15, '33460432', 1200, 'lebron@gmail.com', 'KING JAMES', 'Masculino'),
(4, 'KEVIN DURANT', 'RUA DE OAKLAND', '00505050', '0505050505', 'BAIRR DE OAKLAND', 0, '33402020', 1200, 'kevin@gmail.com', 'DURANT', 'Masculino'),
(5, 'CLIENTE TESTE', '5050', '05050', '05050', '5050', 0, '50', 50, '505', '050', 'Masculino'),
(8, 'RICARDO KAKA', 'MORUMBI', '000404044', '0404', 'MORUMBI', 1, '33460432', 5000, 'kaka@gmail.com', 'KAKA', 'Masculino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `compras`
--

CREATE TABLE IF NOT EXISTS `compras` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `compras`
--

INSERT INTO `compras` (`id_compra`, `fornecedor`, `numero_nota`, `data_emissao`, `total_produtos`, `desconto`, `total_nota`, `tipo_pagamento`, `vendedor`, `status`, `id_caixa`) VALUES
(2, 'NAO CADASTRADO', 1, '2017-11-07', 150, 0, 150, 'Dinheiro', 'ADMINISTRADOR', 'finalizada', 2),
(13, 'NAO CADASTRADO', 3, '2017-11-07', 30, 0, 30, 'Dinheiro', 'ADMINISTRADOR', 'finalizada', 4),
(14, 'NAO CADASTRADO', 4, '2017-11-07', 800, 0, 800, 'Crediario', 'ADMINISTRADOR', 'finalizada', 4),
(15, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'iniciada', NULL),
(16, 'NAO CADASTRADO', 5, '2017-11-08', 60, 0, 60, 'Dinheiro', 'ADMINISTRADOR', 'finalizada', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `despesas`
--

CREATE TABLE IF NOT EXISTS `despesas` (
  `id_despesa` int(11) NOT NULL AUTO_INCREMENT,
  `nome_despesa` varchar(50) NOT NULL,
  PRIMARY KEY (`id_despesa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `despesas`
--

INSERT INTO `despesas` (`id_despesa`, `nome_despesa`) VALUES
(1, 'INFORMATICA'),
(2, 'ENERGIA ELETRICA'),
(3, 'AGUA'),
(4, 'CONTADOR'),
(5, 'MERENDA'),
(6, 'OUTROS'),
(8, 'SERVIÇOS'),
(9, 'GASOLINA'),
(10, 'VIAGEM');

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `nomefantasia` varchar(50) NOT NULL,
  `cnpj` varchar(25) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`id_empresa`, `nome`, `nomefantasia`, `cnpj`, `rua`, `bairro`, `cidade`, `telefone`) VALUES
(1, 'nome da empresa', 'nome fantasia', '000000000000000', 'endereco, 000', 'bairro', 'cidade-estado', '3346-0432 / 992171187');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estados`
--

CREATE TABLE IF NOT EXISTS `estados` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nome_estado` varchar(20) NOT NULL,
  `sigla_estado` varchar(2) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Extraindo dados da tabela `estados`
--

INSERT INTO `estados` (`id_estado`, `nome_estado`, `sigla_estado`) VALUES
(1, 'CEARA', 'CE'),
(2, 'SAO PAULO', 'SP'),
(3, 'BAHIA', 'BA'),
(4, 'ESPIRITO SANTO', 'ES'),
(5, 'RIO DE JANEIRO', 'RJ'),
(6, 'PIAUI', 'PI'),
(7, 'GOIAS', 'GO'),
(8, 'PARANA', 'PR'),
(9, 'RIO GRANDE DO SUL', 'RS'),
(10, 'MINAS GERAIS', 'MG'),
(11, 'SANTA CATARINA', 'SC'),
(12, 'PARA', 'PA'),
(13, 'PERNAMBUCO', 'PE'),
(14, 'AMAZONAS', 'AM'),
(15, 'MARANHAO', 'MA'),
(16, 'DISTRITO FEDERAL', 'DF'),
(17, 'MATO GROSSO', 'MT'),
(18, 'MATO GROSSO DO SUL', 'MS'),
(19, 'ACRE', 'AC'),
(20, 'PARAIBA', 'PB'),
(21, 'ALAGOAS', 'AL'),
(22, 'RORAIMA', 'RR'),
(23, 'RONDONIA', 'RO'),
(24, 'RIO GRANDE DO NORTE', 'RN'),
(25, 'TOCANTINS', 'TO'),
(26, 'SERGIPE', 'SE'),
(27, 'AMAPA', 'AP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
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
  KEY `id_bairro` (`id_bairro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id_fornecedor`, `nome_fornecedor`, `endereco_fornecedor`, `id_bairro`, `bairro`, `cidade`, `estado`, `cnpj`, `telefone`, `celular`, `email`, `nomefantasia`, `ie`) VALUES
(1, 'NAO CADASTRADO', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_compra_produto`
--

CREATE TABLE IF NOT EXISTS `itens_compra_produto` (
  `id_compra` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `itens_compra_produto`
--

INSERT INTO `itens_compra_produto` (`id_compra`, `id_produto`, `quantidade_produto`) VALUES
(2, 3, 10),
(8, 2, 6),
(13, 3, 2),
(14, 2, 2),
(16, 4, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_venda_produto`
--

CREATE TABLE IF NOT EXISTS `itens_venda_produto` (
  `id_venda` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade_produto` int(11) NOT NULL,
  KEY `id_venda` (`id_venda`),
  KEY `id_produto` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `itens_venda_produto`
--

INSERT INTO `itens_venda_produto` (`id_venda`, `id_produto`, `quantidade_produto`) VALUES
(1, 2, 1),
(5, 2, 1),
(7, 2, 1),
(8, 2, 1),
(9, 2, 1),
(10, 3, 1),
(11, 3, 1),
(13, 4, 1),
(12, 5, 1),
(15, 5, 1),
(14, 2, 1),
(16, 3, 10),
(17, 7, 2),
(18, 2, 1),
(19, 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcela_cartao`
--

CREATE TABLE IF NOT EXISTS `parcela_cartao` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `parcela_cartao`
--

INSERT INTO `parcela_cartao` (`id_parc_venda`, `cod_venda`, `valor_venda`, `valor_total`, `numero_parcela`, `valor_parc`, `datavenc`, `estado`, `recebido`, `bandeira`, `tipo_pagamento`, `datavenda`, `datarecebimento`) VALUES
(1, 13, 30, 30, 1, 30, '2017-12-07', 'NAO', NULL, 'MasterCard', 'Credito', '2017-11-07', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcela_compra`
--

CREATE TABLE IF NOT EXISTS `parcela_compra` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `parcela_compra`
--

INSERT INTO `parcela_compra` (`id_parc_compra`, `cod_compra`, `valor_compra`, `valor_nota`, `numero_parcela`, `valor_parc`, `datavenc`, `estado`, `valor_parcial`, `valor_resta`, `pago`, `id_fornecedor`, `datavenda`, `datarecebimento`) VALUES
(1, 14, 800, 600, 1, 300, '2017-12-07', 'NAO', NULL, NULL, NULL, 1, '2017-11-07', NULL),
(2, 14, 800, 600, 2, 300, '2018-01-07', 'NAO', NULL, NULL, NULL, 1, '2017-11-07', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcela_venda`
--

CREATE TABLE IF NOT EXISTS `parcela_venda` (
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
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Extraindo dados da tabela `parcela_venda`
--

INSERT INTO `parcela_venda` (`id_parc_venda`, `cod_venda`, `valor_venda`, `valor_total`, `numero_parcela`, `valor_parc`, `datavenc`, `estado`, `valor_parcial`, `valor_resta`, `pago`, `id_cliente`, `datavenda`, `datarecebimento`) VALUES
(1, 5, 1200, 1000, 1, 200, '2017-12-07', 'NAO', NULL, NULL, NULL, 8, '2017-11-07', NULL),
(2, 5, 1200, 1000, 2, 200, '2018-01-07', 'NAO', NULL, NULL, NULL, 8, '2017-11-07', NULL),
(3, 5, 1200, 1000, 3, 200, '2018-02-07', 'NAO', NULL, NULL, NULL, 8, '2017-11-07', NULL),
(4, 5, 1200, 1000, 4, 200, '2018-03-07', 'NAO', NULL, NULL, NULL, 8, '2017-11-07', NULL),
(5, 5, 1200, 1000, 5, 200, '2018-04-07', 'NAO', NULL, NULL, NULL, 8, '2017-11-07', NULL),
(6, 7, 1200, 1100, 1, 183.333, '2017-12-07', 'NAO', NULL, NULL, NULL, 3, '2017-11-07', NULL),
(7, 7, 1200, 1100, 2, 183.333, '2018-01-07', 'NAO', NULL, NULL, NULL, 3, '2017-11-07', NULL),
(8, 7, 1200, 1100, 3, 183.333, '2018-02-07', 'NAO', NULL, NULL, NULL, 3, '2017-11-07', NULL),
(9, 7, 1200, 1100, 4, 183.333, '2018-03-07', 'NAO', NULL, NULL, NULL, 3, '2017-11-07', NULL),
(10, 7, 1200, 1100, 5, 183.333, '2018-04-07', 'NAO', NULL, NULL, NULL, 3, '2017-11-07', NULL),
(11, 7, 1200, 1100, 6, 183.333, '2018-05-07', 'NAO', NULL, NULL, NULL, 3, '2017-11-07', NULL),
(12, 8, 1200, 1200, 1, 200, '2017-12-07', 'NAO', NULL, NULL, NULL, 2, '2017-11-07', NULL),
(13, 8, 1200, 1200, 2, 200, '2018-01-07', 'NAO', NULL, NULL, NULL, 2, '2017-11-07', NULL),
(14, 8, 1200, 1200, 3, 200, '2018-02-07', 'NAO', NULL, NULL, NULL, 2, '2017-11-07', NULL),
(15, 8, 1200, 1200, 4, 200, '2018-03-07', 'NAO', NULL, NULL, NULL, 2, '2017-11-07', NULL),
(16, 8, 1200, 1200, 5, 200, '2018-04-07', 'NAO', NULL, NULL, NULL, 2, '2017-11-07', NULL),
(17, 8, 1200, 1200, 6, 200, '2018-05-07', 'NAO', NULL, NULL, NULL, 2, '2017-11-07', NULL),
(18, 9, 1200, 1200, 1, 300, '2017-12-07', 'Parcial', 200, 100, 200, 4, '2017-11-07', '2017-11-08'),
(19, 9, 1200, 1200, 2, 300, '2018-01-07', 'NAO', NULL, NULL, NULL, 4, '2017-11-07', NULL),
(20, 9, 1200, 1200, 3, 300, '2018-02-07', 'NAO', NULL, NULL, NULL, 4, '2017-11-07', NULL),
(21, 9, 1200, 1200, 4, 300, '2018-03-07', 'NAO', NULL, NULL, NULL, 4, '2017-11-07', NULL),
(22, 14, 1200, 800, 1, 200, '2017-12-08', 'NAO', NULL, NULL, NULL, 8, '2017-11-08', NULL),
(23, 14, 1200, 800, 2, 200, '2018-01-08', 'NAO', NULL, NULL, NULL, 8, '2017-11-08', NULL),
(24, 14, 1200, 800, 3, 200, '2018-02-08', 'NAO', NULL, NULL, NULL, 8, '2017-11-08', NULL),
(25, 14, 1200, 800, 4, 200, '2018-03-08', 'NAO', NULL, NULL, NULL, 8, '2017-11-08', NULL),
(26, 19, 1200, 1000, 1, 1100, '2017-12-08', 'NAO', NULL, NULL, NULL, 2, '2017-11-08', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `codigobarras`, `nome_produto`, `preco_compra`, `lucrovenda`, `lucro_esperado`, `preco_venda`, `quantidade`, `quantidade_minima`, `id_fornecedor`, `id_categoria`, `unidade`) VALUES
(1, '0505050505050', 'PRODUTO NAO CADASTRADO', 1, 0, 0, 1, 5, 5, 3, 1, 'UN'),
(2, '7890000000017', 'TV PHILLIPS 32 POLEGADAS', 400, 800, 66.67, 1200, 9, 5, 1, 2, 'UN'),
(3, '0050505151510', 'FONE DE OUVIDO SAMSUNG', 15, 5, 25, 20, 10, 5, 1, 3, 'UN'),
(4, '1234567891012', 'MOUSE GOLDENTEC', 10, 20, 66.67, 30, 20, 5, 1, 5, 'UN'),
(5, '1234567881023', 'TECLADO GOLDENTEC', 20, 20, 50, 40, 23, 5, 1, 5, 'UN'),
(6, '1234567891013', 'TECLADO SEM FIO', 50, 30, 37.5, 80, 15, 5, 1, 4, 'UN'),
(7, '', 'ANEL DE VEDAÇAO', 6.5, 3, 31.58, 9.5, 1, 2, 1, 1, 'UN');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_cartao`
--

CREATE TABLE IF NOT EXISTS `tbl_cartao` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tbl_cartao`
--

INSERT INTO `tbl_cartao` (`id_venda_cartao`, `id_venda`, `id_caixa`, `entrada_cartao`, `parcelas`, `tipo_cartao`, `total_venda`, `data_venda`, `tipo_pagamento`) VALUES
(1, 11, 3, 0, 0, NULL, 20, '2017-11-07', 'Cartao'),
(2, 13, 3, 0, 0, NULL, 30, '2017-11-07', 'Cartao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_cartao_debito`
--

CREATE TABLE IF NOT EXISTS `tbl_cartao_debito` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tbl_cartao_debito`
--

INSERT INTO `tbl_cartao_debito` (`id_debito`, `id_caixa`, `valor_venda`, `valor_total`, `id_venda`, `data_venda`, `pagamento`, `bandeira`, `status`) VALUES
(1, 3, 20, 20, 11, '2017-11-07', 'Debito', 'Visa', 'AGUARDANDO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada`
--

CREATE TABLE IF NOT EXISTS `tbl_entrada` (
  `id_entrada` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  `data_venda` varchar(20) DEFAULT NULL,
  `valor_entrada` float DEFAULT NULL,
  `tipo_pagamento` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_entrada`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `tbl_entrada`
--

INSERT INTO `tbl_entrada` (`id_entrada`, `id_caixa`, `id_venda`, `data_venda`, `valor_entrada`, `tipo_pagamento`) VALUES
(1, 2, 5, '2017-11-07', 200, 'Dinheiro'),
(2, 2, 7, '2017-11-07', 100, 'Dinheiro'),
(3, 2, 8, '2017-11-07', 0, 'Dinheiro'),
(4, 2, 9, '2017-11-07', 0, 'Dinheiro'),
(5, 4, 14, '2017-11-08', 400, 'Dinheiro'),
(6, 5, 19, '2017-11-08', 200, 'Dinheiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada_cartao`
--

CREATE TABLE IF NOT EXISTS `tbl_entrada_cartao` (
  `id_entrada_cartao` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) NOT NULL,
  `valor_pago` float NOT NULL,
  `data_recebimento` date NOT NULL,
  `id_venda` int(11) NOT NULL,
  PRIMARY KEY (`id_entrada_cartao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `tbl_entrada_cartao`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada_crediario`
--

CREATE TABLE IF NOT EXISTS `tbl_entrada_crediario` (
  `id_crediario` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `valor_pago` float DEFAULT NULL,
  `data_recebimento` date DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_crediario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tbl_entrada_crediario`
--

INSERT INTO `tbl_entrada_crediario` (`id_crediario`, `id_caixa`, `valor_pago`, `data_recebimento`, `id_venda`) VALUES
(1, 5, 200, '2017-11-08', 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada_venda`
--

CREATE TABLE IF NOT EXISTS `tbl_entrada_venda` (
  `id_entrada_venda` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `valor_venda` float DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  `data_venda` varchar(20) DEFAULT NULL,
  `tipo_pagamento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_entrada_venda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `tbl_entrada_venda`
--

INSERT INTO `tbl_entrada_venda` (`id_entrada_venda`, `id_caixa`, `valor_venda`, `id_venda`, `data_venda`, `tipo_pagamento`) VALUES
(1, 2, 1200, 1, '2017-11-07', 'Dinheiro'),
(2, 2, 20, 10, '2017-11-07', 'Dinheiro'),
(3, 3, 36, 12, '2017-11-07', 'Dinheiro'),
(4, 4, 40, 15, '2017-11-08', 'Dinheiro'),
(5, 4, 200, 16, '2017-11-08', 'Dinheiro'),
(6, 4, 18.05, 17, '2017-11-08', 'Dinheiro'),
(7, 5, 1200, 18, '2017-11-08', 'Dinheiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_registrar_despesa`
--

CREATE TABLE IF NOT EXISTS `tbl_registrar_despesa` (
  `id_registro_despesa` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(250) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `data` date DEFAULT NULL,
  `id_caixa` int(11) NOT NULL,
  PRIMARY KEY (`id_registro_despesa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `tbl_registrar_despesa`
--

INSERT INTO `tbl_registrar_despesa` (`id_registro_despesa`, `descricao`, `tipo`, `valor`, `data`, `id_caixa`) VALUES
(1, '50', 'AGUA', 0, '2017-11-07', 3),
(2, 'descricao', 'AGUA', 0, '2017-11-07', 3),
(3, 'des', 'AGUA', 0, '2017-11-07', 3),
(4, '', 'AGUA', 0, '2017-11-07', 3),
(5, '', 'AGUA', 0, '2017-11-07', 3),
(6, '', 'AGUA', 0, '2017-11-07', 3),
(7, 'pagamento do contador', 'CONTADOR', 20, '2017-11-07', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_saida`
--

CREATE TABLE IF NOT EXISTS `tbl_saida` (
  `id_saida` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) DEFAULT NULL,
  `id_compra` int(11) DEFAULT NULL,
  `data_compra` date DEFAULT NULL,
  `valor_saida` float DEFAULT NULL,
  `tipo_pagamento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_saida`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `tbl_saida`
--

INSERT INTO `tbl_saida` (`id_saida`, `id_caixa`, `id_compra`, `data_compra`, `valor_saida`, `tipo_pagamento`) VALUES
(1, 2, 2, '2017-11-07', 150, 'Dinheiro'),
(2, 3, 8, '2017-11-07', 2400, 'Dinheiro'),
(3, 4, 13, '2017-11-07', 30, 'Dinheiro'),
(4, 4, 14, '2017-11-07', 200, 'Dinheiro'),
(5, 4, 16, '2017-11-08', 60, 'Dinheiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_saida_crediario`
--

CREATE TABLE IF NOT EXISTS `tbl_saida_crediario` (
  `id_saida_crediario` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) NOT NULL,
  `valor_pago` float NOT NULL,
  `data_recebimento` date NOT NULL,
  `id_compra` int(11) NOT NULL,
  PRIMARY KEY (`id_saida_crediario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `tbl_saida_crediario`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `level` int(5) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id_user`, `user`, `pass`, `level`, `tipo`) VALUES
(1, 'ADMINISTRADOR', '1234', 0, 'Administrador');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `data_venda` date DEFAULT NULL,
  `valor_venda` float NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `tipo_pagamento` varchar(30) DEFAULT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  `vendedor` varchar(25) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id_venda`, `data_venda`, `valor_venda`, `id_cliente`, `tipo_pagamento`, `id_caixa`, `vendedor`, `status`) VALUES
(1, '2017-11-07', 1200, NULL, 'Dinheiro', 2, 'ADMINISTRADOR', 'finalizada'),
(5, '2017-11-07', 1200, 8, 'Crediario', 2, 'ADMINISTRADOR', 'finalizada'),
(7, '2017-11-07', 1200, 3, 'Crediario', 2, 'ADMINISTRADOR', 'finalizada'),
(8, '2017-11-07', 1200, 2, 'Crediario', 2, 'ADMINISTRADOR', 'finalizada'),
(9, '2017-11-07', 1200, 4, 'Crediario', 2, 'ADMINISTRADOR', 'finalizada'),
(10, '2017-11-07', 20, NULL, 'Dinheiro', 2, 'ADMINISTRADOR', 'finalizada'),
(11, '2017-11-07', 20, NULL, 'Cartao', 3, 'ADMINISTRADOR', 'finalizada'),
(12, '2017-11-07', 36, NULL, 'Dinheiro', 3, 'ADMINISTRADOR', 'finalizada'),
(13, '2017-11-07', 30, NULL, 'Cartao', 3, 'ADMINISTRADOR', 'finalizada'),
(14, '2017-11-08', 1200, 8, 'Crediario', 4, 'ADMINISTRADOR', 'finalizada'),
(15, '2017-11-08', 40, NULL, 'Dinheiro', 4, 'ADMINISTRADOR', 'finalizada'),
(16, '2017-11-08', 200, NULL, 'Dinheiro', 4, 'ADMINISTRADOR', 'finalizada'),
(17, '2017-11-08', 18.05, NULL, 'Dinheiro', 4, 'ADMINISTRADOR', 'finalizada'),
(18, '2017-11-08', 1200, NULL, 'Dinheiro', 5, 'ADMINISTRADOR', 'finalizada'),
(19, '2017-11-08', 1200, 2, 'Crediario', 5, 'ADMINISTRADOR', 'finalizada'),
(20, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `bairro`
--
ALTER TABLE `bairro`
  ADD CONSTRAINT `bairro_ibfk_1` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id_cidade`);

--
-- Restrições para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`);

--
-- Restrições para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`id_bairro`) REFERENCES `bairro` (`id_bairro`);

--
-- Restrições para a tabela `itens_venda_produto`
--
ALTER TABLE `itens_venda_produto`
  ADD CONSTRAINT `itens_venda_produto_ibfk_1` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`),
  ADD CONSTRAINT `itens_venda_produto_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`);

--
-- Restrições para a tabela `parcela_venda`
--
ALTER TABLE `parcela_venda`
  ADD CONSTRAINT `parcela_venda_ibfk_1` FOREIGN KEY (`cod_venda`) REFERENCES `venda` (`id_venda`),
  ADD CONSTRAINT `parcela_venda_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

--
-- Restrições para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);
