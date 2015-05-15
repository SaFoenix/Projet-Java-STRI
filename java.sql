-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 15 Mai 2015 à 23:06
-- Version du serveur :  5.6.17-log
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `java`
--

-- --------------------------------------------------------

--
-- Structure de la table `borne`
--

CREATE TABLE IF NOT EXISTS `borne` (
  `IdBorne` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdBorne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `connecter`
--

CREATE TABLE IF NOT EXISTS `connecter` (
  `IdOrdinateur` int(11) NOT NULL DEFAULT '0',
  `IdRouteur` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdOrdinateur`,`IdRouteur`),
  KEY `FK_Routeur_Ordinateur` (`IdRouteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `connecterborne`
--

CREATE TABLE IF NOT EXISTS `connecterborne` (
  `IdBorne` int(11) NOT NULL DEFAULT '0',
  `IdTablette` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdBorne`,`IdTablette`),
  KEY `FK_Tablette_Borne` (`IdTablette`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contenir`
--

CREATE TABLE IF NOT EXISTS `contenir` (
  `IdSociete` int(11) NOT NULL DEFAULT '0',
  `IdLocal` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdSociete`,`IdLocal`),
  KEY `FK_Contenir_local` (`IdLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contenirequipement`
--

CREATE TABLE IF NOT EXISTS `contenirequipement` (
  `IdSalle` int(11) NOT NULL DEFAULT '0',
  `IdEquipement` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdSalle`,`IdEquipement`),
  KEY `FK_ContenirEquipement` (`IdEquipement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contenirsalle`
--

CREATE TABLE IF NOT EXISTS `contenirsalle` (
  `IdSAlle` int(11) NOT NULL DEFAULT '0',
  `IdLocal` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdSAlle`,`IdLocal`),
  KEY `FK_ContenirLocal_Salle` (`IdLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `equipement`
--

CREATE TABLE IF NOT EXISTS `equipement` (
  `IdEquipement` int(11) NOT NULL DEFAULT '0',
  `Nom` varchar(50) DEFAULT NULL,
  `MAC` varchar(50) DEFAULT NULL,
  `Marque` varchar(50) DEFAULT NULL,
  `Power` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`IdEquipement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `local`
--

CREATE TABLE IF NOT EXISTS `local` (
  `IdLocal` int(11) NOT NULL DEFAULT '0',
  `NumeroLocal` int(11) DEFAULT NULL,
  `Lieux` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ordinateur`
--

CREATE TABLE IF NOT EXISTS `ordinateur` (
  `IdOrdinateur` int(11) NOT NULL DEFAULT '0',
  `RAM` varchar(10) DEFAULT NULL,
  `CPU` varchar(50) DEFAULT NULL,
  `GPU` varchar(50) DEFAULT NULL,
  `HDD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdOrdinateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `os`
--

CREATE TABLE IF NOT EXISTS `os` (
  `IdOs` int(11) NOT NULL DEFAULT '0',
  `Version` float DEFAULT NULL,
  `NomOs` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IdOs`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `routeur`
--

CREATE TABLE IF NOT EXISTS `routeur` (
  `IdRouteur` int(11) NOT NULL DEFAULT '0',
  `NombreDePort` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdRouteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `IdSalle` int(11) NOT NULL DEFAULT '0',
  `Numero` int(11) DEFAULT NULL,
  `NombreOrdinateur` int(11) DEFAULT NULL,
  `Etage` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `societe`
--

CREATE TABLE IF NOT EXISTS `societe` (
  `IdSociete` int(11) NOT NULL DEFAULT '0',
  `Nom` varchar(50) DEFAULT NULL,
  `Lieux` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdSociete`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tablette`
--

CREATE TABLE IF NOT EXISTS `tablette` (
  `IdTablette` int(11) NOT NULL DEFAULT '0',
  `Capacite` varchar(50) DEFAULT NULL,
  `Modele` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdTablette`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `connecter`
--
ALTER TABLE `connecter`
  ADD CONSTRAINT `FK_Ordinateur_Routeur` FOREIGN KEY (`IdOrdinateur`) REFERENCES `equipement` (`IdEquipement`),
  ADD CONSTRAINT `FK_Routeur_Ordinateur` FOREIGN KEY (`IdRouteur`) REFERENCES `equipement` (`IdEquipement`);

--
-- Contraintes pour la table `connecterborne`
--
ALTER TABLE `connecterborne`
  ADD CONSTRAINT `FK_Tablette_Borne` FOREIGN KEY (`IdTablette`) REFERENCES `equipement` (`IdEquipement`),
  ADD CONSTRAINT `FK_Borne_Tablette` FOREIGN KEY (`IdBorne`) REFERENCES `equipement` (`IdEquipement`);

--
-- Contraintes pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD CONSTRAINT `FK_Contenir` FOREIGN KEY (`IdSociete`) REFERENCES `societe` (`IdSociete`),
  ADD CONSTRAINT `FK_Contenir_local` FOREIGN KEY (`IdLocal`) REFERENCES `local` (`IdLocal`);

--
-- Contraintes pour la table `contenirequipement`
--
ALTER TABLE `contenirequipement`
  ADD CONSTRAINT `FK_ContenirEquipement` FOREIGN KEY (`IdEquipement`) REFERENCES `equipement` (`IdEquipement`),
  ADD CONSTRAINT `FK_ContenirSalle_Equipement` FOREIGN KEY (`IdSalle`) REFERENCES `salle` (`IdSalle`);

--
-- Contraintes pour la table `contenirsalle`
--
ALTER TABLE `contenirsalle`
  ADD CONSTRAINT `FK_ContenirSalle` FOREIGN KEY (`IdSAlle`) REFERENCES `salle` (`IdSalle`),
  ADD CONSTRAINT `FK_ContenirLocal_Salle` FOREIGN KEY (`IdLocal`) REFERENCES `local` (`IdLocal`);

--
-- Contraintes pour la table `ordinateur`
--
ALTER TABLE `ordinateur`
  ADD CONSTRAINT `FK_Ordinateur_equipement` FOREIGN KEY (`IdOrdinateur`) REFERENCES `equipement` (`IdEquipement`);

--
-- Contraintes pour la table `routeur`
--
ALTER TABLE `routeur`
  ADD CONSTRAINT `FK_Routeur_Equipement` FOREIGN KEY (`IdRouteur`) REFERENCES `equipement` (`IdEquipement`);

--
-- Contraintes pour la table `tablette`
--
ALTER TABLE `tablette`
  ADD CONSTRAINT `Fk_Tablette_Equipement` FOREIGN KEY (`IdTablette`) REFERENCES `equipement` (`IdEquipement`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
