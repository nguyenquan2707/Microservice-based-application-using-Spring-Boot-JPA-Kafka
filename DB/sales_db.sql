-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 30, 2020 at 09:05 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sales_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `card_payment`
--

CREATE TABLE `card_payment` (
  `id` int(5) NOT NULL,
  `order_id` int(5) NOT NULL,
  `issuing_bank` varchar(50) NOT NULL,
  `card_type` varchar(30) NOT NULL,
  `card_expiry_date` date NOT NULL,
  `amount` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Table structure for table `cheque_payment`
--

CREATE TABLE `cheque_payment` (
  `id` int(5) NOT NULL,
  `order_id` int(5) NOT NULL,
  `bank_name` varchar(30) NOT NULL,
  `bank_branch` varchar(100) CHARACTER SET utf8 NOT NULL,
  `cheque_no` int(20) NOT NULL,
  `cheque_date` date NOT NULL,
  `amount` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Table structure for table `customer_vs_total_sale`
--

CREATE TABLE `customer_vs_total_sale` (
  `customer_id` int(5) NOT NULL,
  `total_sale` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(5) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `unit` varchar(5) CHARACTER SET utf8 NOT NULL,
  `stock_quantity` int(3) NOT NULL,
  `unit_price` int(5) NOT NULL,
  `tax_percentage` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(5) NOT NULL,
  `delivery_address` varchar(100) NOT NULL,
  `order_date` date NOT NULL,
  `total` int(5) NOT NULL,
  `customerId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

--
-- Table structure for table `orderLine`
--

CREATE TABLE `orderLine` (
  `id` int(5) NOT NULL,
  `amount` int(5) NOT NULL,
  `itemId` int(5) NOT NULL,
  `line_total` int(5) NOT NULL,
  `orderId` int(5) NOT NULL,
  `quantity` int(3) NOT NULL,
  `tax_amount` int(3) NOT NULL,
  `tax_percentage` int(3) NOT NULL,
  `unit` varchar(5) NOT NULL,
  `unit_cost` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `card_payment`
--
ALTER TABLE `card_payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `cheque_payment`
--
ALTER TABLE `cheque_payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cheque_payment_ibfk_1` (`order_id`);

--
-- Indexes for table `customer_vs_total_sale`
--
ALTER TABLE `customer_vs_total_sale`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `orders_ibfk_1` (`customerId`);

--
-- Indexes for table `orderLine`
--
ALTER TABLE `orderLine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `OrderLine_ibfk_1` (`orderId`),
  ADD KEY `OrderLine_ibfk_2` (`itemId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `card_payment`
--
ALTER TABLE `card_payment`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cheque_payment`
--
ALTER TABLE `cheque_payment`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orderLine`
--
ALTER TABLE `orderLine`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `card_payment`
--
ALTER TABLE `card_payment`
  ADD CONSTRAINT `card_payment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `cheque_payment`
--
ALTER TABLE `cheque_payment`
  ADD CONSTRAINT `cheque_payment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer_vs_total_sale` (`customer_id`) ON DELETE CASCADE;

--
-- Constraints for table `orderLine`
--
ALTER TABLE `orderLine`
  ADD CONSTRAINT `OrderLine_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `OrderLine_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `item` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
