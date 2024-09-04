-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Mar-2018 às 16:07
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistemavendas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bairro`
--

CREATE TABLE `bairro` (
  `id_bairro` int(11) NOT NULL,
  `nome_bairro` varchar(50) NOT NULL,
  `id_cidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE `caixa` (
  `id_caixa` int(11) NOT NULL,
  `saldo_inicial` double DEFAULT NULL,
  `total_caixa` float DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` varchar(15) DEFAULT NULL,
  `data_fechamento` varchar(50) DEFAULT NULL,
  `hora_fechamento` varchar(30) DEFAULT NULL,
  `saldo_final` float DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `caixa`
--

INSERT INTO `caixa` (`id_caixa`, `saldo_inicial`, `total_caixa`, `data`, `hora`, `data_fechamento`, `hora_fechamento`, `saldo_final`, `status`) VALUES
(1, 0, 0, '2018-01-18', '10:00', '2018/01/2018', '12:00', 0, 'fechado '),
(2, 1, NULL, '2018-03-07', '01:45', NULL, NULL, NULL, 'aberto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nome_categoria` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nome_categoria`) VALUES
(1, 'Padrão'),
(2, 'Lubrificantes'),
(3, 'Frios');

-- --------------------------------------------------------

--
-- Estrutura da tabela `chaveacesso`
--

CREATE TABLE `chaveacesso` (
  `id_chave` int(11) NOT NULL,
  `chave` varchar(100) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `datavenc` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `chaveacesso`
--

INSERT INTO `chaveacesso` (`id_chave`, `chave`, `status`, `datavenc`) VALUES
(1, '0000', '', '17042018');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id_cidade` int(11) NOT NULL,
  `nome_cidade` varchar(50) NOT NULL,
  `id_estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id_cidade`, `nome_cidade`, `id_estado`) VALUES
(1, 'Goiânia', 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
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
  `sexo` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nome_cliente`, `endereco_cliente`, `rg_cliente`, `cpf_cliente`, `bairro`, `id_cidade`, `telefone`, `limite_compra`, `email`, `apelido`, `sexo`) VALUES
(1, 'Haurio Vieira da Silva', 'Av. Rio Verde Qd.9', '5809806', '04778787170', 'Parque Amazonas', 1, '(62)98583-6372', 300, 'hauriovieira@gmail.com', 'Haurio Vieira', 'Masculino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `compras`
--

CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL,
  `fornecedor` varchar(60) DEFAULT NULL,
  `numero_nota` int(11) DEFAULT NULL,
  `data_emissao` date DEFAULT NULL,
  `total_produtos` float DEFAULT NULL,
  `desconto` float DEFAULT NULL,
  `total_nota` float DEFAULT NULL,
  `tipo_pagamento` varchar(25) DEFAULT NULL,
  `vendedor` varchar(30) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `id_caixa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `despesas`
--

CREATE TABLE `despesas` (
  `id_despesa` int(11) NOT NULL,
  `nome_despesa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE `empresa` (
  `id_empresa` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `nomefantasia` varchar(50) NOT NULL,
  `cnpj` varchar(25) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `telefone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estados`
--

CREATE TABLE `estados` (
  `id_estado` int(11) NOT NULL,
  `nome_estado` varchar(20) NOT NULL,
  `sigla_estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `fornecedor` (
  `id_fornecedor` int(11) NOT NULL,
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
  `ie` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id_fornecedor`, `nome_fornecedor`, `endereco_fornecedor`, `id_bairro`, `bairro`, `cidade`, `estado`, `cnpj`, `telefone`, `celular`, `email`, `nomefantasia`, `ie`) VALUES
(1, 'Fornecedor Padrão', 'Não cadastrado', NULL, 'paranoá', 'brasília', 'DF', '000000', '000000', '000000', 'Não cadastrado', 'Padrão', '000000'),
(2, 'Castrol Brasil Lubrificantes Ltda', 'Av. Perimentral Norte', NULL, 'Setor Nova Esperança', 'Goiânia', 'Goias', '236659236000358', '(62)4002-6356', '', 'Vendas.CB@castrolbrasil.com.br', 'Castrol Brasil Lubrificantes', '56986597');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_compra_produto`
--

CREATE TABLE `itens_compra_produto` (
  `id_compra` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_venda_produto`
--

CREATE TABLE `itens_venda_produto` (
  `id_venda` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade_produto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `itens_venda_produto`
--

INSERT INTO `itens_venda_produto` (`id_venda`, `id_produto`, `quantidade_produto`) VALUES
(10, 1, 1),
(47, 1, 1),
(97, 2, 0.985);

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcela_cartao`
--

CREATE TABLE `parcela_cartao` (
  `id_parc_venda` int(11) NOT NULL,
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
  `datarecebimento` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `parcela_cartao`
--

INSERT INTO `parcela_cartao` (`id_parc_venda`, `cod_venda`, `valor_venda`, `valor_total`, `numero_parcela`, `valor_parc`, `datavenc`, `estado`, `recebido`, `bandeira`, `tipo_pagamento`, `datavenda`, `datarecebimento`) VALUES
(1, 10, 98.65, 98.65, 1, 98.65, '2018-04-08', 'NAO', NULL, 'Visa', 'Credito', '2018-03-08', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcela_compra`
--

CREATE TABLE `parcela_compra` (
  `id_parc_compra` int(11) NOT NULL,
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
  `datarecebimento` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcela_venda`
--

CREATE TABLE `parcela_venda` (
  `id_parc_venda` int(11) NOT NULL,
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
  `datarecebimento` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `parcela_venda`
--

INSERT INTO `parcela_venda` (`id_parc_venda`, `cod_venda`, `valor_venda`, `valor_total`, `numero_parcela`, `valor_parc`, `datavenc`, `estado`, `valor_parcial`, `valor_resta`, `pago`, `id_cliente`, `datavenda`, `datarecebimento`) VALUES
(1, 47, 98.65, 48.65, 1, 48.65, '2018-04-14', 'NAO', NULL, NULL, NULL, 1, '2018-03-14', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `codigobarras` varchar(100) DEFAULT NULL,
  `nome_produto` varchar(50) NOT NULL,
  `preco_compra` float DEFAULT NULL,
  `lucrovenda` float DEFAULT NULL,
  `lucro_esperado` float DEFAULT NULL,
  `preco_venda` float NOT NULL,
  `quantidade` float NOT NULL,
  `quantidade_minima` int(11) NOT NULL,
  `id_fornecedor` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `unidade` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `codigobarras`, `nome_produto`, `preco_compra`, `lucrovenda`, `lucro_esperado`, `preco_venda`, `quantidade`, `quantidade_minima`, `id_fornecedor`, `id_categoria`, `unidade`) VALUES
(1, '8565449613123000112', 'Filtro de Oleo S-10', 62.34, 36.31, 36.81, 98.65, 8, 2, 2, 2, 'Litro'),
(2, '75489328955665489', 'Frango Congelado ', 2.59, 1.4, 35.09, 3.99, 0, 10, 1, 3, 'Kg');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_cartao`
--

CREATE TABLE `tbl_cartao` (
  `id_venda_cartao` int(11) NOT NULL,
  `id_venda` int(11) NOT NULL,
  `id_caixa` int(11) NOT NULL,
  `entrada_cartao` float NOT NULL,
  `parcelas` int(11) NOT NULL,
  `tipo_cartao` varchar(25) DEFAULT NULL,
  `total_venda` float NOT NULL,
  `data_venda` varchar(30) NOT NULL,
  `tipo_pagamento` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_cartao`
--

INSERT INTO `tbl_cartao` (`id_venda_cartao`, `id_venda`, `id_caixa`, `entrada_cartao`, `parcelas`, `tipo_cartao`, `total_venda`, `data_venda`, `tipo_pagamento`) VALUES
(1, 10, 2, 0, 0, NULL, 98.65, '2018-03-08', 'Cartao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_cartao_debito`
--

CREATE TABLE `tbl_cartao_debito` (
  `id_debito` int(11) NOT NULL,
  `id_caixa` int(11) NOT NULL,
  `valor_venda` float NOT NULL,
  `valor_total` float DEFAULT NULL,
  `id_venda` int(11) NOT NULL,
  `data_venda` date NOT NULL,
  `pagamento` varchar(20) NOT NULL,
  `bandeira` varchar(20) DEFAULT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada`
--

CREATE TABLE `tbl_entrada` (
  `id_entrada` int(11) NOT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  `data_venda` varchar(20) DEFAULT NULL,
  `valor_entrada` float DEFAULT NULL,
  `tipo_pagamento` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_entrada`
--

INSERT INTO `tbl_entrada` (`id_entrada`, `id_caixa`, `id_venda`, `data_venda`, `valor_entrada`, `tipo_pagamento`) VALUES
(1, 2, 47, '2018-03-14', 50, 'Dinheiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada_cartao`
--

CREATE TABLE `tbl_entrada_cartao` (
  `id_entrada_cartao` int(11) NOT NULL,
  `id_caixa` int(11) NOT NULL,
  `valor_pago` float NOT NULL,
  `data_recebimento` date NOT NULL,
  `id_venda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada_crediario`
--

CREATE TABLE `tbl_entrada_crediario` (
  `id_crediario` int(11) NOT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  `valor_pago` float DEFAULT NULL,
  `data_recebimento` date DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada_venda`
--

CREATE TABLE `tbl_entrada_venda` (
  `id_entrada_venda` int(11) NOT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  `valor_venda` float DEFAULT NULL,
  `id_venda` int(11) DEFAULT NULL,
  `data_venda` varchar(20) DEFAULT NULL,
  `tipo_pagamento` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_entrada_venda`
--

INSERT INTO `tbl_entrada_venda` (`id_entrada_venda`, `id_caixa`, `valor_venda`, `id_venda`, `data_venda`, `tipo_pagamento`) VALUES
(1, 2, 3.93, 97, '2018-03-15', 'Dinheiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_registrar_despesa`
--

CREATE TABLE `tbl_registrar_despesa` (
  `id_registro_despesa` int(11) NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `data` date DEFAULT NULL,
  `id_caixa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_saida`
--

CREATE TABLE `tbl_saida` (
  `id_saida` int(11) NOT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  `id_compra` int(11) DEFAULT NULL,
  `data_compra` date DEFAULT NULL,
  `valor_saida` float DEFAULT NULL,
  `tipo_pagamento` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_saida_crediario`
--

CREATE TABLE `tbl_saida_crediario` (
  `id_saida_crediario` int(11) NOT NULL,
  `id_caixa` int(11) NOT NULL,
  `valor_pago` float NOT NULL,
  `data_recebimento` date NOT NULL,
  `id_compra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `level` int(5) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id_user`, `user`, `pass`, `level`, `tipo`) VALUES
(1, 'GestorWeb', '123', 0, 'Administrador '),
(2, 'Benson', '1833', 3, 'Analista '),
(3, 'Haurio Vieira', '218864', 1, 'Gerente'),
(4, 'Paulo', '123', 2, 'Vendedor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL,
  `data_venda` date DEFAULT NULL,
  `valor_venda` float NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `tipo_pagamento` varchar(30) DEFAULT NULL,
  `id_caixa` int(11) DEFAULT NULL,
  `vendedor` varchar(25) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id_venda`, `data_venda`, `valor_venda`, `id_cliente`, `tipo_pagamento`, `id_caixa`, `vendedor`, `status`) VALUES
(2, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(3, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(4, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(5, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(6, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(7, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(8, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(9, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(10, '2018-03-08', 98.65, 1, 'Cartao', 2, 'Haurio Vieira', 'finalizada'),
(11, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(12, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(13, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(36, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(37, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(38, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(39, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(40, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(41, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(42, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(43, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(44, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(45, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(46, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(47, '2018-03-14', 98.65, 1, 'Crediario', 2, NULL, 'finalizada'),
(48, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(49, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(50, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(51, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(52, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(53, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(54, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(55, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(56, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(57, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(58, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(59, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(60, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(61, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(62, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(63, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(64, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(65, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(66, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(67, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(68, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(69, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(70, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(71, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(72, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(73, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(74, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(75, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(76, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(77, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(78, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(79, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(80, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(81, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(82, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(83, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(84, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(85, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(86, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(87, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(88, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(89, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(90, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(91, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(92, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(93, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(94, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(95, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(96, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada'),
(97, '2018-03-15', 3.93, 1, 'Dinheiro', 2, 'GestorWeb', 'finalizada'),
(98, NULL, 0, NULL, NULL, NULL, NULL, 'iniciada');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bairro`
--
ALTER TABLE `bairro`
  ADD PRIMARY KEY (`id_bairro`),
  ADD KEY `id_cidade` (`id_cidade`);

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
  ADD PRIMARY KEY (`id_caixa`);

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indexes for table `chaveacesso`
--
ALTER TABLE `chaveacesso`
  ADD PRIMARY KEY (`id_chave`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id_cidade`),
  ADD KEY `id_estado` (`id_estado`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id_compra`);

--
-- Indexes for table `despesas`
--
ALTER TABLE `despesas`
  ADD PRIMARY KEY (`id_despesa`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id_empresa`);

--
-- Indexes for table `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id_fornecedor`),
  ADD KEY `id_bairro` (`id_bairro`);

--
-- Indexes for table `itens_venda_produto`
--
ALTER TABLE `itens_venda_produto`
  ADD KEY `id_venda` (`id_venda`),
  ADD KEY `id_produto` (`id_produto`);

--
-- Indexes for table `parcela_cartao`
--
ALTER TABLE `parcela_cartao`
  ADD PRIMARY KEY (`id_parc_venda`);

--
-- Indexes for table `parcela_compra`
--
ALTER TABLE `parcela_compra`
  ADD PRIMARY KEY (`id_parc_compra`);

--
-- Indexes for table `parcela_venda`
--
ALTER TABLE `parcela_venda`
  ADD PRIMARY KEY (`id_parc_venda`),
  ADD KEY `cod_venda` (`cod_venda`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- Indexes for table `tbl_cartao`
--
ALTER TABLE `tbl_cartao`
  ADD PRIMARY KEY (`id_venda_cartao`);

--
-- Indexes for table `tbl_cartao_debito`
--
ALTER TABLE `tbl_cartao_debito`
  ADD PRIMARY KEY (`id_debito`);

--
-- Indexes for table `tbl_entrada`
--
ALTER TABLE `tbl_entrada`
  ADD PRIMARY KEY (`id_entrada`);

--
-- Indexes for table `tbl_entrada_cartao`
--
ALTER TABLE `tbl_entrada_cartao`
  ADD PRIMARY KEY (`id_entrada_cartao`);

--
-- Indexes for table `tbl_entrada_crediario`
--
ALTER TABLE `tbl_entrada_crediario`
  ADD PRIMARY KEY (`id_crediario`);

--
-- Indexes for table `tbl_entrada_venda`
--
ALTER TABLE `tbl_entrada_venda`
  ADD PRIMARY KEY (`id_entrada_venda`);

--
-- Indexes for table `tbl_registrar_despesa`
--
ALTER TABLE `tbl_registrar_despesa`
  ADD PRIMARY KEY (`id_registro_despesa`);

--
-- Indexes for table `tbl_saida`
--
ALTER TABLE `tbl_saida`
  ADD PRIMARY KEY (`id_saida`);

--
-- Indexes for table `tbl_saida_crediario`
--
ALTER TABLE `tbl_saida_crediario`
  ADD PRIMARY KEY (`id_saida_crediario`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id_venda`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bairro`
--
ALTER TABLE `bairro`
  MODIFY `id_bairro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `caixa`
--
ALTER TABLE `caixa`
  MODIFY `id_caixa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `chaveacesso`
--
ALTER TABLE `chaveacesso`
  MODIFY `id_chave` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id_cidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `compras`
--
ALTER TABLE `compras`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `despesas`
--
ALTER TABLE `despesas`
  MODIFY `id_despesa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id_empresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `estados`
--
ALTER TABLE `estados`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `parcela_cartao`
--
ALTER TABLE `parcela_cartao`
  MODIFY `id_parc_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `parcela_compra`
--
ALTER TABLE `parcela_compra`
  MODIFY `id_parc_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `parcela_venda`
--
ALTER TABLE `parcela_venda`
  MODIFY `id_parc_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_cartao`
--
ALTER TABLE `tbl_cartao`
  MODIFY `id_venda_cartao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_cartao_debito`
--
ALTER TABLE `tbl_cartao_debito`
  MODIFY `id_debito` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_entrada`
--
ALTER TABLE `tbl_entrada`
  MODIFY `id_entrada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_entrada_cartao`
--
ALTER TABLE `tbl_entrada_cartao`
  MODIFY `id_entrada_cartao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_entrada_crediario`
--
ALTER TABLE `tbl_entrada_crediario`
  MODIFY `id_crediario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_entrada_venda`
--
ALTER TABLE `tbl_entrada_venda`
  MODIFY `id_entrada_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_registrar_despesa`
--
ALTER TABLE `tbl_registrar_despesa`
  MODIFY `id_registro_despesa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_saida`
--
ALTER TABLE `tbl_saida`
  MODIFY `id_saida` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_saida_crediario`
--
ALTER TABLE `tbl_saida_crediario`
  MODIFY `id_saida_crediario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `id_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `bairro`
--
ALTER TABLE `bairro`
  ADD CONSTRAINT `bairro_ibfk_1` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id_cidade`);

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`);

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`id_bairro`) REFERENCES `bairro` (`id_bairro`);

--
-- Limitadores para a tabela `itens_venda_produto`
--
ALTER TABLE `itens_venda_produto`
  ADD CONSTRAINT `itens_venda_produto_ibfk_1` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`),
  ADD CONSTRAINT `itens_venda_produto_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`);

--
-- Limitadores para a tabela `parcela_venda`
--
ALTER TABLE `parcela_venda`
  ADD CONSTRAINT `parcela_venda_ibfk_1` FOREIGN KEY (`cod_venda`) REFERENCES `venda` (`id_venda`),
  ADD CONSTRAINT `parcela_venda_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
