-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 05, 2020 at 02:52 PM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.24-0ubuntu0.18.04.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mf76OCdxkb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Bill`
--

CREATE TABLE `Bill` (
  `billId` int(11) NOT NULL,
  `receiptNumber` int(11) NOT NULL,
  `distributorId` int(11) NOT NULL,
  `isBillPaid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Bill`
--

INSERT INTO `Bill` (`billId`, `receiptNumber`, `distributorId`, `isBillPaid`) VALUES
(1, 12345, 1, 0),
(2, 54321, 3, 0),
(3, 98765, 4, 0),
(4, 56789, 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Brand`
--

CREATE TABLE `Brand` (
  `brandId` int(11) NOT NULL,
  `brandName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `isActive` int(10) NOT NULL,
  `distributorId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Brand`
--

INSERT INTO `Brand` (`brandId`, `brandName`, `isActive`, `distributorId`) VALUES
(1, 'McDowells Whiskey', 1, 1),
(2, 'Officer\'s Choice Blue Whiskey', 1, 1),
(3, 'Blender\'s Pride Whiskey', 1, 3),
(4, 'White-Mischief Vodka', 1, 4),
(5, 'Old Monk Rum', 0, 5),
(6, 'Budweiser Beer', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` (`categoryId`, `categoryName`, `quantity`) VALUES
(1, 'Mini', 90),
(2, 'Quarter', 180),
(3, 'Half', 360),
(4, 'Full', 720);

-- --------------------------------------------------------

--
-- Table structure for table `Distributor`
--

CREATE TABLE `Distributor` (
  `distributorId` int(11) NOT NULL,
  `distributorName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `zip` int(6) NOT NULL,
  `state` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `contactNumber` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Distributor`
--

INSERT INTO `Distributor` (`distributorId`, `distributorName`, `city`, `zip`, `state`, `contactNumber`) VALUES
(1, 'Desh Videsh Traders', 'Akola', 444002, 'Maharashtra', 9876543210),
(3, 'Ashok Traders', 'Nagpur', 440001, 'Maharashtra', 99887776655),
(4, 'Swami Samarth Wine Distributors', 'Akola', 444002, 'Maharashtra', 9876598765),
(5, 'Bharat Traders', 'Nagpur', 440001, 'Maharashtra', 1234567890);

-- --------------------------------------------------------

--
-- Table structure for table `Purchase`
--

CREATE TABLE `Purchase` (
  `billId` int(11) NOT NULL,
  `brandId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `purchasePrice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Purchase`
--

INSERT INTO `Purchase` (`billId`, `brandId`, `categoryId`, `quantity`, `purchasePrice`) VALUES
(1, 1, 1, 30, 50),
(1, 1, 2, 100, 140),
(1, 2, 1, 50, 40),
(1, 2, 2, 90, 130),
(2, 3, 2, 50, 300),
(2, 6, 3, 50, 140),
(2, 6, 4, 60, 200),
(3, 4, 2, 200, 120),
(4, 5, 2, 150, 130);

-- --------------------------------------------------------

--
-- Table structure for table `Stock`
--

CREATE TABLE `Stock` (
  `brandId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `sellingPrice` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Stock`
--

INSERT INTO `Stock` (`brandId`, `categoryId`, `sellingPrice`, `quantity`) VALUES
(1, 1, 90, 30),
(1, 2, 170, 100),
(2, 1, 90, 50),
(2, 2, 160, 90),
(3, 2, 340, 50),
(4, 2, 140, 200),
(5, 2, 150, 150),
(6, 3, 160, 50),
(6, 4, 240, 60);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Bill`
--
ALTER TABLE `Bill`
  ADD PRIMARY KEY (`billId`),
  ADD KEY `fk_bill_distributorId` (`distributorId`);

--
-- Indexes for table `Brand`
--
ALTER TABLE `Brand`
  ADD PRIMARY KEY (`brandId`),
  ADD KEY `fk_distributorId` (`distributorId`);

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `Distributor`
--
ALTER TABLE `Distributor`
  ADD PRIMARY KEY (`distributorId`);

--
-- Indexes for table `Purchase`
--
ALTER TABLE `Purchase`
  ADD PRIMARY KEY (`billId`,`brandId`,`categoryId`),
  ADD KEY `fk_purchase_brandId` (`brandId`),
  ADD KEY `fk_purchase_categoryId` (`categoryId`);

--
-- Indexes for table `Stock`
--
ALTER TABLE `Stock`
  ADD PRIMARY KEY (`brandId`,`categoryId`),
  ADD KEY `fk_stock_categoryId` (`categoryId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Bill`
--
ALTER TABLE `Bill`
  MODIFY `billId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Brand`
--
ALTER TABLE `Brand`
  MODIFY `brandId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `Category`
--
ALTER TABLE `Category`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Distributor`
--
ALTER TABLE `Distributor`
  MODIFY `distributorId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Bill`
--
ALTER TABLE `Bill`
  ADD CONSTRAINT `fk_bill_distributorId` FOREIGN KEY (`distributorId`) REFERENCES `Distributor` (`distributorid`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `Brand`
--
ALTER TABLE `Brand`
  ADD CONSTRAINT `fk_distributorId` FOREIGN KEY (`distributorId`) REFERENCES `Distributor` (`distributorid`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `Purchase`
--
ALTER TABLE `Purchase`
  ADD CONSTRAINT `fk_purchase_billId` FOREIGN KEY (`billId`) REFERENCES `Bill` (`billid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_purchase_brandId` FOREIGN KEY (`brandId`) REFERENCES `Brand` (`brandid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_purchase_categoryId` FOREIGN KEY (`categoryId`) REFERENCES `Category` (`categoryid`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `Stock`
--
ALTER TABLE `Stock`
  ADD CONSTRAINT `fk_stock_brandId` FOREIGN KEY (`brandId`) REFERENCES `Brand` (`brandid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_stock_categoryId` FOREIGN KEY (`categoryId`) REFERENCES `Category` (`categoryid`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
