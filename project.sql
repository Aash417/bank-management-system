-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 09, 2021 at 05:29 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
CREATE TABLE IF NOT EXISTS `bank` (
  `pin` int(4) DEFAULT NULL,
  `balance` varchar(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `cardno` varchar(17) DEFAULT NULL,
  `pin` int(4) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
CREATE TABLE IF NOT EXISTS `signup` (
  `name` varchar(30) DEFAULT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `date` int(2) DEFAULT NULL,
  `month` varchar(12) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `marital` varchar(10) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `pincode` int(6) DEFAULT NULL,
  `state` varchar(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `signup2`
--

DROP TABLE IF EXISTS `signup2`;
CREATE TABLE IF NOT EXISTS `signup2` (
  `religion` varchar(15) DEFAULT NULL,
  `category` varchar(15) DEFAULT NULL,
  `income` varchar(10) DEFAULT NULL,
  `education` varchar(15) DEFAULT NULL,
  `occupation` varchar(15) DEFAULT NULL,
  `Accno` varchar(11) DEFAULT NULL,
  `PANno` varchar(10) DEFAULT NULL,
  `senior` varchar(5) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `signup3`
--

DROP TABLE IF EXISTS `signup3`;
CREATE TABLE IF NOT EXISTS `signup3` (
  `account` varchar(30) DEFAULT NULL,
  `cardno` varchar(17) DEFAULT NULL,
  `pin` int(5) DEFAULT NULL,
  `service_required` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
