-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 17 mars 2021 à 11:07
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `crainfocom`
--

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur`
--

DROP TABLE IF EXISTS `collaborateur`;
CREATE TABLE IF NOT EXISTS `collaborateur` (
  `id_coll` int(11) NOT NULL AUTO_INCREMENT,
  `nom_coll` varchar(300) COLLATE utf8_bin NOT NULL,
  `societe_coll` varchar(300) COLLATE utf8_bin NOT NULL,
  `poste_coll` varchar(300) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_coll`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `collaborateur`
--

INSERT INTO `collaborateur` (`id_coll`, `nom_coll`, `societe_coll`, `poste_coll`) VALUES
(11, 'ILHAM', 'InfoCom', 'dev'),
(12, 'IBRAHIM', 'InfoCom', 'dev'),
(13, 'MICHELLE', 'Dev', 'InfoCom'),
(16, 'PATRICK', 'InfoCom', 'Dev');

-- --------------------------------------------------------

--
-- Structure de la table `notedefrais`
--

DROP TABLE IF EXISTS `notedefrais`;
CREATE TABLE IF NOT EXISTS `notedefrais` (
  `id_frais` int(11) NOT NULL AUTO_INCREMENT,
  `raison_frais` varchar(300) COLLATE utf8_bin NOT NULL,
  `prix_frais` int(11) NOT NULL,
  `date_frais` varchar(300) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_frais`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `notedefrais`
--

INSERT INTO `notedefrais` (`id_frais`, `raison_frais`, `prix_frais`, `date_frais`) VALUES
(1, 'Consommation', 59, '13/02/2004'),
(3, 'Transport', 59, '13/02/2004'),
(4, 'Transport', 59, '13/02/2004');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
