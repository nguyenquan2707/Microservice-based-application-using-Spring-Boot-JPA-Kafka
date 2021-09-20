-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 01, 2021 at 11:46 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `card_expiry_date` varchar(12) NOT NULL,
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
  `cheque_date` varchar(12) NOT NULL,
  `amount` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- --------------------------------------------------------

ALTER TABLE `card_payment`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `cheque_payment`
  ADD PRIMARY KEY (`id`);

-- --------------------------------------------------------
--
-- AUTO_INCREMENT for table `card_payment`
--
ALTER TABLE `card_payment`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cheque_payment`
--
ALTER TABLE `cheque_payment`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

-- --------------------------------------------------------
--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `mobile_no` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);
 
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

-- --------------------------------------------------------

--
-- Table structure for table `customer_vs_total_sale`
--

CREATE TABLE `customer_vs_total_sale` (
  `customer_id` int(5) NOT NULL,
  `total_sale` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;



--
-- Indexes for table `customer_vs_total_sale`
--
ALTER TABLE `customer_vs_total_sale`
  ADD PRIMARY KEY (`customer_id`);

--
-- Constraints for table `customer_vs_total_sale`
--
ALTER TABLE `customer_vs_total_sale`
  ADD CONSTRAINT `customer_vs_total_sale_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE;
  

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

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

  
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `name`, `unit`, `stock_quantity`, `unit_price`, `tax_percentage`) VALUES
(1, 'Amul Milk', 'ltr', 94, 21, 5),
(7, 'Almond Milk', 'ltr', 10, 70, 3),
(9, 'Butter Milk', 'ltr', 80, 70, 3);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(5) NOT NULL,
  `delivery_address` varchar(100) NOT NULL,
  `order_date` varchar(100) NOT NULL,
  `total` int(5) NOT NULL,
  `customerId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;


--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
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
-- Indexes for table `orderLine`
--
ALTER TABLE `orderLine`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for table `orderLine`
--
ALTER TABLE `orderLine`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Constraints for table `orderLine`
--
ALTER TABLE `orderLine`
  ADD CONSTRAINT `OrderLine_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `OrderLine_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `item` (`id`) ON DELETE CASCADE;


--
-- Constraints for table `card_payment`
--
ALTER TABLE `card_payment`
  ADD CONSTRAINT `card_payment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `cheque_payment`
--
ALTER TABLE `cheque_payment`
  ADD CONSTRAINT `fk_ch_payment_orderid_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_order_cid_cust_id` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE;

-- --------------------------------------------------------
 
INSERT INTO `customer` (`id`, `name`, `mobile_no`, `address`) VALUES
(31, 'Pinaki Pal', '7384709073', 'Nadia, WB');

INSERT INTO `customer_vs_total_sale` (`customer_id`, `total_sale`) VALUES
(31, 2);
 
INSERT INTO `order` (`id`, `delivery_address`, `order_date`, `total`, `customerId`) VALUES
(35, 'MSD, WB', '21-01-2021', 5500, 31);

INSERT INTO `orderLine` (`id`, `amount`, `itemId`, `line_total`, `orderId`, `quantity`, `tax_amount`, `tax_percentage`, `unit`, `unit_cost`) VALUES
(29, 220, 1, 440, 35, 2, 3, 0, 'ltr', 20);

INSERT INTO `cheque_payment` (`id`, `order_id`, `bank_name`, `bank_branch`, `cheque_no`, `cheque_date`, `amount`) VALUES
(35, 35, 'UBI', 'bpc', 1234, '22-09-2020', 440);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
