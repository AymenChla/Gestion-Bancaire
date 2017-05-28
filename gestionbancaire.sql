-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2017 at 03:23 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionbancaire`
--

-- --------------------------------------------------------

--
-- Table structure for table `agences`
--

CREATE TABLE `agences` (
  `code_agence` int(11) NOT NULL,
  `nom_agence` varchar(256) NOT NULL,
  `date_creation` date NOT NULL,
  `ville` varchar(256) NOT NULL,
  `adresse` varchar(256) NOT NULL,
  `inactif` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agences`
--

INSERT INTO `agences` (`code_agence`, `nom_agence`, `date_creation`, `ville`, `adresse`, `inactif`) VALUES
(9, 'tijari', '2017-05-28', 'casablanca', '178d tu jds', 1),
(11, 'marajjk', '2017-05-28', 'casablanca', 'aklkds', 0);

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `nom_client` varchar(256) NOT NULL,
  `prenom_client` varchar(256) NOT NULL,
  `image_client` varchar(256) NOT NULL DEFAULT 'rien',
  `code_agence` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `cin_client` varchar(256) NOT NULL,
  `inactif` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`nom_client`, `prenom_client`, `image_client`, `code_agence`, `id_client`, `cin_client`, `inactif`) VALUES
('chla&&', 'aymen', 'rien', 1, 4, '1', b'1'),
('hh', 'aaa', 'rien', 1, 5, '3', b'0'),
('farabi', 'youssef', 'rien', 2, 7, '1311317816', b'1'),
('fggd', 'gfdgd', 'rien', 1, 8, '54', b'0'),
('hello', 'jslajsa', 'rien', 9, 11, '545', b'0'),
('chla', 'freenemya', 'rien', 1, 10, '1311317817', b'0'),
('', '', 'rien', 9, 12, '', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `comptes`
--

CREATE TABLE `comptes` (
  `code_compte` int(11) NOT NULL,
  `solde_compte` double NOT NULL,
  `id_client` int(11) NOT NULL,
  `inactif` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comptes`
--

INSERT INTO `comptes` (`code_compte`, `solde_compte`, `id_client`, `inactif`) VALUES
(36, -99, 4, b'0'),
(37, 18421, 4, b'0'),
(38, 2200, 8, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `comptes_courants`
--

CREATE TABLE `comptes_courants` (
  `decouvert_autorise` double NOT NULL,
  `code_compte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comptes_courants`
--

INSERT INTO `comptes_courants` (`decouvert_autorise`, `code_compte`) VALUES
(100, 36);

-- --------------------------------------------------------

--
-- Table structure for table `comptes_epargnes`
--

CREATE TABLE `comptes_epargnes` (
  `taux_interet` double NOT NULL,
  `code_compte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comptes_epargnes`
--

INSERT INTO `comptes_epargnes` (`taux_interet`, `code_compte`) VALUES
(20, 37),
(10, 38);

-- --------------------------------------------------------

--
-- Table structure for table `employes`
--

CREATE TABLE `employes` (
  `id` int(11) NOT NULL,
  `id_agence` int(11) DEFAULT NULL,
  `nom` varchar(256) NOT NULL,
  `prenom` varchar(256) NOT NULL,
  `date_naissance` date NOT NULL,
  `login` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employes`
--

INSERT INTO `employes` (`id`, `id_agence`, `nom`, `prenom`, `date_naissance`, `login`, `password`) VALUES
(3, 1, 'chla', 'aymen', '2017-05-01', 'admin', 'admin'),
(4, 2, 'farabi', 'youssef', '2017-05-03', 'agence', 'agence');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `date_transaction` date NOT NULL,
  `type_transaction` int(11) NOT NULL,
  `montant_transaction` double NOT NULL,
  `code_compte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`date_transaction`, `type_transaction`, `montant_transaction`, `code_compte`) VALUES
('2017-05-28', 2, 1200, 34),
('2017-05-28', 2, 100, 34),
('2017-05-28', 2, 9200, 34),
('2017-05-28', 2, 920, 34),
('2017-05-28', 2, 600, 35),
('2017-05-28', 2, 500, 35),
('2017-05-28', 1, 200, 35),
('2017-05-28', 2, 2005, 35),
('2017-05-28', 2, 2099, 36),
('2017-05-28', 2, 5219, 37),
('2017-05-28', 2, 200, 38),
('2017-05-28', 1, 200, 38),
('2017-05-28', 1, 922, 37),
('2017-05-28', 2, 922, 37);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agences`
--
ALTER TABLE `agences`
  ADD PRIMARY KEY (`code_agence`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `cin_client` (`cin_client`),
  ADD KEY `code_agence` (`code_agence`);

--
-- Indexes for table `comptes`
--
ALTER TABLE `comptes`
  ADD PRIMARY KEY (`code_compte`),
  ADD KEY `cin_client` (`id_client`);

--
-- Indexes for table `comptes_courants`
--
ALTER TABLE `comptes_courants`
  ADD KEY `code_compte` (`code_compte`);

--
-- Indexes for table `comptes_epargnes`
--
ALTER TABLE `comptes_epargnes`
  ADD KEY `code_compte` (`code_compte`);

--
-- Indexes for table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_agence` (`id_agence`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD KEY `code_compte` (`code_compte`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agences`
--
ALTER TABLE `agences`
  MODIFY `code_agence` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `comptes`
--
ALTER TABLE `comptes`
  MODIFY `code_compte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT for table `employes`
--
ALTER TABLE `employes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
