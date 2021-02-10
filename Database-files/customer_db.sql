-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 10, 2021 at 07:44 AM
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
-- Database: `customer_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `mobile_no` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `mobile_no`, `address`) VALUES
(46, 'Pinaki Pal', '8759161626', 'Berhampore, WB');

-- --------------------------------------------------------

--
-- Table structure for table `customer_vs_total_sale`
--

DROP TABLE IF EXISTS `customer_vs_total_sale`;
CREATE TABLE IF NOT EXISTS `customer_vs_total_sale` (
  `customer_id` int(5) NOT NULL,
  `total_sale` int(3) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `customer_vs_total_sale`
--

INSERT INTO `customer_vs_total_sale` (`customer_id`, `total_sale`) VALUES
(46, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_vs_total_sale`
--
ALTER TABLE `customer_vs_total_sale`
  ADD CONSTRAINT `fk_cust_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
