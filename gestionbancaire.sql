-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 09 Juillet 2017 à 23:54
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionbancaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `agences`
--

CREATE TABLE `agences` (
  `code_agence` int(11) NOT NULL,
  `nom_agence` varchar(256) NOT NULL,
  `date_creation` date NOT NULL,
  `ville` varchar(256) NOT NULL,
  `adresse` varchar(256) NOT NULL,
  `inactif` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `nom_client` varchar(256) NOT NULL,
  `prenom_client` varchar(256) NOT NULL,
  `image_client` varchar(256) NOT NULL DEFAULT 'rien',
  `code_agence` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `cin_client` varchar(256) NOT NULL,
  `inactif` bit(1) NOT NULL DEFAULT b'0',
  `image` blob NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comptes`
--

CREATE TABLE `comptes` (
  `code_compte` int(11) NOT NULL,
  `solde_compte` double NOT NULL,
  `id_client` int(11) NOT NULL,
  `inactif` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comptes_courants`
--

CREATE TABLE `comptes_courants` (
  `decouvert_autorise` double NOT NULL,
  `code_compte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comptes_epargnes`
--

CREATE TABLE `comptes_epargnes` (
  `taux_interet` double NOT NULL,
  `code_compte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `employes`
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
-- Contenu de la table `employes`
--

INSERT INTO `employes` (`id`, `id_agence`, `nom`, `prenom`, `date_naissance`, `login`, `password`) VALUES
(3, 1, 'chla', 'aymen', '2017-05-01', 'siege', 'siege');

-- --------------------------------------------------------

--
-- Structure de la table `transactions`
--

CREATE TABLE `transactions` (
  `date_transaction` date NOT NULL,
  `type_transaction` int(11) NOT NULL,
  `montant_transaction` double NOT NULL,
  `code_compte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agences`
--
ALTER TABLE `agences`
  ADD PRIMARY KEY (`code_agence`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `cin_client` (`cin_client`),
  ADD KEY `code_agence` (`code_agence`);

--
-- Index pour la table `comptes`
--
ALTER TABLE `comptes`
  ADD PRIMARY KEY (`code_compte`),
  ADD KEY `cin_client` (`id_client`);

--
-- Index pour la table `comptes_courants`
--
ALTER TABLE `comptes_courants`
  ADD KEY `code_compte` (`code_compte`);

--
-- Index pour la table `comptes_epargnes`
--
ALTER TABLE `comptes_epargnes`
  ADD KEY `code_compte` (`code_compte`);

--
-- Index pour la table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_agence` (`id_agence`);

--
-- Index pour la table `transactions`
--
ALTER TABLE `transactions`
  ADD KEY `code_compte` (`code_compte`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agences`
--
ALTER TABLE `agences`
  MODIFY `code_agence` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT pour la table `comptes`
--
ALTER TABLE `comptes`
  MODIFY `code_compte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT pour la table `employes`
--
ALTER TABLE `employes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
