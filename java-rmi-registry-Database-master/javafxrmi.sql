-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 08 août 2019 à 00:11
-- Version du serveur :  10.1.36-MariaDB
-- Version de PHP :  7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `javafxrmi`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `type`) VALUES
(1, 'admin', 'admin', '1'),
(2, 'user', 'user', '2'),
(3, 'users', 'users', '3');

-- --------------------------------------------------------

--
-- Structure de la table `block`
--

CREATE TABLE `block` (
  `id` int(11) NOT NULL,
  `nomBlock` varchar(20) NOT NULL,
  `nbrChambre` int(11) NOT NULL,
  `nbrPCCh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `block`
--

INSERT INTO `block` (`id`, `nomBlock`, `nbrChambre`, `nbrPCCh`) VALUES
(1, 'block1', 500, 4),
(2, 'block2', 500, 4),
(3, 'block3', 500, 4),
(4, 'block4', 500, 3);

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `id` int(11) NOT NULL,
  `idStudent` int(11) NOT NULL,
  `nameStudent` varchar(20) NOT NULL,
  `idBlock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`id`, `idStudent`, `nameStudent`, `idBlock`) VALUES
(1, 1, 'amine', 1),
(1, 2, 'amine', 1),
(1, 3, 'ine', 1);

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL,
  `trav` varchar(50) NOT NULL,
  `Dat_trav` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `historique`
--

INSERT INTO `historique` (`id`, `idUser`, `ip`, `trav`, `Dat_trav`) VALUES
(1, 1, '127.0.0.1', 'admin has logged in', '2019-06-05'),
(2, 1, '127.0.0.1', 'admin has logged in', '2019-06-05'),
(3, 1, '127.0.0.1', 'admin has Block Add', '2019-06-05'),
(4, 1, '127.0.0.1', 'admin has logged in', '2019-06-06'),
(5, 1, '127.0.0.1', 'admin has logged in', '2019-06-06'),
(6, 1, '127.0.0.1', 'admin has logged in', '2019-06-06'),
(7, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(8, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(9, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(10, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(11, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(12, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(13, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(14, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(15, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(16, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(17, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(18, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(19, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(20, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(21, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(22, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(23, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(24, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(25, 1, '127.0.0.1', 'admin has Block Add', '2019-06-07'),
(26, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(27, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(28, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(29, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(30, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(31, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(32, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(33, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(34, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(35, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(36, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(37, 2, '127.0.0.1', 'user has logged in', '2019-06-07'),
(38, 2, '127.0.0.1', 'user has logged in', '2019-06-07'),
(39, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(40, 2, '127.0.0.1', 'user has logged in', '2019-06-07'),
(41, 2, '127.0.0.1', 'user has logged in', '2019-06-07'),
(42, 2, '127.0.0.1', 'user has logged in', '2019-06-07'),
(43, 3, '127.0.0.1', 'users has logged in', '2019-06-07'),
(44, 2, '127.0.0.1', 'user has logged in', '2019-06-07'),
(45, 2, '127.0.0.1', 'user has logged in', '2019-06-07'),
(46, 3, '127.0.0.1', 'users has logged in', '2019-06-07'),
(47, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(48, 1, '127.0.0.1', 'admin has logged in', '2019-06-07'),
(49, 1, '127.0.0.1', 'admin has logged in', '2019-06-09'),
(50, 2, '127.0.0.1', 'user has logged in', '2019-06-09'),
(51, 3, '127.0.0.1', 'users has logged in', '2019-06-09'),
(52, 3, '127.0.0.1', 'users has logged in', '2019-06-09'),
(53, 3, '127.0.0.1', 'users has logged in', '2019-06-09'),
(54, 3, '127.0.0.1', 'users has logged in', '2019-06-09'),
(55, 3, '127.0.0.1', 'users has logged in', '2019-06-09'),
(56, 2, '127.0.0.1', 'user has logged in', '2019-06-09'),
(57, 1, '127.0.0.1', 'admin has logged in', '2019-06-09'),
(58, 1, '127.0.0.1', 'admin has logged in', '2019-06-09'),
(59, 2, '127.0.0.1', 'user has logged in', '2019-06-09'),
(60, 1, '127.0.0.1', 'admin has logged in', '2019-06-09'),
(61, 1, '127.0.0.1', 'admin has logged in', '2019-06-09'),
(62, 1, '127.0.0.1', 'admin has logged in', '2019-06-09'),
(63, 3, '127.0.0.1', 'users has logged in', '2019-06-09'),
(64, 1, '127.0.0.1', 'admin has logged in', '2019-06-10'),
(65, 2, '127.0.0.1', 'user has logged in', '2019-06-11'),
(66, 1, '127.0.0.1', 'admin has logged in', '2019-06-11'),
(67, 1, '127.0.0.1', 'admin has logged in', '2019-06-16'),
(68, 3, '127.0.0.1', 'users has logged in', '2019-06-16'),
(69, 1, '127.0.0.1', 'admin has logged in', '2019-07-01'),
(70, 1, '127.0.0.1', 'admin has logged in', '2019-07-07');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL,
  `idStudent` varchar(20) NOT NULL,
  `Date_Res` date NOT NULL,
  `N_bac` varchar(20) NOT NULL,
  `Date_bac` date NOT NULL,
  `W_bac` varchar(10) NOT NULL,
  `N_ins_univ` varchar(10) NOT NULL,
  `code` varchar(10) NOT NULL,
  `Anne` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `idStudent`, `Date_Res`, `N_bac`, `Date_bac`, `W_bac`, `N_ins_univ`, `code`, `Anne`) VALUES
(1, '1', '2018-06-05', '123543', '2011-06-09', '14', '242323', 'E2', '3 anne'),
(3, '2', '2019-06-05', '123543', '2011-06-09', '14', '242323', 'E1', '3 anne'),
(4, '3', '2019-06-05', '123543', '2010-06-09', '14', '242323', 'E2', '3 anne');

-- --------------------------------------------------------

--
-- Structure de la table `ipvalid`
--

CREATE TABLE `ipvalid` (
  `id` int(11) NOT NULL,
  `ip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `dob` date NOT NULL,
  `age` int(3) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `tel1` varchar(15) NOT NULL,
  `tel2` varchar(15) DEFAULT NULL,
  `address` varchar(30) NOT NULL,
  `img` varchar(50) NOT NULL,
  `statu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`sid`, `name`, `gender`, `dob`, `age`, `nic`, `tel1`, `tel2`, `address`, `img`, `statu`) VALUES
(1, 'damine', 'male', '2019-06-11', 24, '2323', '2233', '3333', '333', '/image/1.png', 1),
(2, 'amine', 'male', '2019-06-04', 24, '2323', '12', '233', 'dlsq', '/image/1.png', 1),
(3, 'mine', 'male', '2019-06-11', 24, '2323', '2233', '3333', '333', '/image/1.png', 0),
(4, 'amine', 'male', '2019-06-11', 24, '2323', '2233', '3333', '333', '/image/1.png', 1);

-- --------------------------------------------------------

--
-- Structure de la table `univ`
--

CREATE TABLE `univ` (
  `code` varchar(11) NOT NULL,
  `name` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `univ`
--

INSERT INTO `univ` (`code`, `name`) VALUES
('E11', 'mi'),
('E2', 'st'),
('E3', 'droit');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `username` varchar(16) NOT NULL,
  `password` varchar(12) NOT NULL,
  `privilege` int(11) NOT NULL,
  `idBlock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`username`, `password`, `privilege`, `idBlock`) VALUES
('a', 'a', 1, 1),
('as', 'as', 2, 1),
('b', 'b', 1, 2),
('bs', 'bs', 2, 2),
('c', 'c', 1, 3),
('cs', 'cs', 2, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `block`
--
ALTER TABLE `block`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`id`,`idStudent`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ipvalid`
--
ALTER TABLE `ipvalid`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`sid`);

--
-- Index pour la table `univ`
--
ALTER TABLE `univ`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `block`
--
ALTER TABLE `block`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `historique`
--
ALTER TABLE `historique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `ipvalid`
--
ALTER TABLE `ipvalid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `student`
--
ALTER TABLE `student`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
