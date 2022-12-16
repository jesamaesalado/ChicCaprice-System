-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 02, 2022 at 02:56 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` int(15) NOT NULL,
  `NAME` varchar(15) NOT NULL,
  `PRICE` int(15) NOT NULL,
  `QUANTITY` int(15) NOT NULL,
  `CATEGORY` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cashiertransactions`
--

CREATE TABLE `cashiertransactions` (
  `ctransactionID` int(11) NOT NULL,
  `inventoryID` int(11) NOT NULL,
  `quantity` int(15) NOT NULL,
  `total` int(15) NOT NULL,
  `UID` int(15) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashiertransactions`
--

INSERT INTO `cashiertransactions` (`ctransactionID`, `inventoryID`, `quantity`, `total`, `UID`, `date`, `time`) VALUES
(9, 135, 151, 64, 1, '64', 5);

-- --------------------------------------------------------

--
-- Table structure for table `ctransaction`
--

CREATE TABLE `ctransaction` (
  `ctransactionID` int(11) NOT NULL,
  `inventoryID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ctransaction`
--

INSERT INTO `ctransaction` (`ctransactionID`, `inventoryID`, `quantity`, `total`, `UID`, `date`, `time`) VALUES
(1, 156, 2, 3000, 28, '2022-02-06', '07:48 AM'),
(2, 137, 5, 7500, 28, '2022-02-07', '08:03 AM'),
(3, 160, 2, 8812, 28, '2022-02-07', '08:03 AM'),
(4, 135, 31, 37200, 28, '2022-02-06', '09:11 AM'),
(5, 136, 5, 7000, 28, '2022-02-06', '09:16 AM'),
(6, 156, 4, 13000, 28, '2022-02-06', '09:16 AM'),
(7, 169, 5, 7500, 28, '2022-02-06', '09:34 AM'),
(8, 171, 5, 12000, 28, '2022-02-06', '09:34 AM'),
(9, 170, 9, 8100, 28, '2022-02-06', '09:42 AM'),
(10, 172, 5, 15600, 28, '2022-02-06', '09:43 AM'),
(11, 136, 5, 7000, 28, '2022-02-06', '10:23 AM'),
(12, 136, 6, 8400, 28, '2022-02-06', '10:35 AM'),
(13, 175, 9, 10800, 18, '2022-02-06', '12:42 PM'),
(14, 172, 4, 16800, 18, '2022-02-06', '12:43 PM'),
(15, 170, 3, 2700, 28, '2022-02-06', '05:35 PM'),
(16, 171, 2, 4500, 28, '2022-02-06', '05:35 PM'),
(17, 172, 4, 6000, 28, '2022-02-06', '05:53 PM'),
(18, 178, 2, 46848468, 18, '2022-02-06', '07:34 PM'),
(19, 177, 2, 46849338, 18, '2022-02-06', '07:34 PM');

-- --------------------------------------------------------

--
-- Table structure for table `ctransactions`
--

CREATE TABLE `ctransactions` (
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `Bid` int(15) NOT NULL,
  `Book Name` varchar(30) NOT NULL,
  `Category` varchar(15) NOT NULL,
  `Quantity` int(15) NOT NULL,
  `Price` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`Bid`, `Book Name`, `Category`, `Quantity`, `Price`) VALUES
(1, 'A place to Remember', 'Romance', 150, 1999),
(5, 'Rain in Espanya', 'Romance', 150, 780),
(6, 'Our Yesterday\'s Escape', 'Romance', 150, 550),
(7, 'Espresso Love', 'Fiction', 78, 980),
(8, 'Island Trap', 'Romance', 150, 870),
(9, 'Temptation Island', 'Romance', 150, 999),
(10, 'Exclusively Mine ', 'Fiction', 150, 500),
(11, 'Bride of Alfonso', 'Romance', 99, 1000),
(21, 'mirror', 'tragic', 500, 500),
(22, 'dsfds', 'sdfd', 232, 9000),
(23, 'dsfds', 'sdfd', 232, 9000),
(100, 'Mirror', 'Fantasy', 100, 700),
(3453, 'fdgdfg', 'dfgdfg', 4535, 435);

-- --------------------------------------------------------

--
-- Table structure for table `manage_categories`
--

CREATE TABLE `manage_categories` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manage_categories`
--

INSERT INTO `manage_categories` (`id`, `name`, `description`) VALUES
(1, 'Rain in Espanya', 'Romance'),
(2, 'Safe Sky Archer', 'Tragic'),
(3, 'A walk to Remember', 'Romance'),
(4, 'Titans High', 'Ficton'),
(5, 'fgfgd', 'dgfdg'),
(213, 'uoyiuuu', 'uiyuuiyi');

-- --------------------------------------------------------

--
-- Table structure for table `manage_sellers`
--

CREATE TABLE `manage_sellers` (
  `id` int(15) NOT NULL,
  `name` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `gender` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manage_sellers`
--

INSERT INTO `manage_sellers` (`id`, `name`, `password`, `gender`) VALUES
(5, 'kaye', '1234', 'Female'),
(6, 'kaye', 'kaye', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `InventoryID` int(11) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `BuyingPrice` int(11) NOT NULL,
  `SellingPrice` int(11) NOT NULL,
  `StockQuantity` int(11) NOT NULL,
  `Threshold` int(11) NOT NULL,
  `UnitofMeasure` varchar(11) NOT NULL,
  `PublishedDate` varchar(50) NOT NULL,
  `Availability` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`InventoryID`, `ProductName`, `Category`, `BuyingPrice`, `SellingPrice`, `StockQuantity`, `Threshold`, `UnitofMeasure`, `PublishedDate`, `Availability`) VALUES
(136, 'Chasing in the Wild', 'Mature', 1200, 1400, 234, 20, 'pieces', '09/22/2002', 'Available'),
(137, 'Golden Sceneries if Tomorrow', 'Fiction', 1234, 1500, 9, 20, 'pieces', '10/06/2020', 'Available'),
(156, 'Avenues in the Diamond', 'Fiction', 1200, 1500, 200, 20, 'pieces', '09/22/2002', 'Available'),
(169, 'Rain in Espanya', 'Mature', 1200, 1500, 94, 20, 'pieces', '09/13/2002', 'Available'),
(170, 'Gentle Wind of Vengeance', 'Mature', 700, 900, 87, 20, 'pieces', '06/23/2017', 'Available'),
(171, 'Wind of Vengeance', 'Mature', 700, 900, 76, 20, 'pieces', '06/23/2017', 'Available'),
(172, 'Saudade', 'Fiction', 1300, 1500, 90, 20, 'pieces', '09/22/2002', 'Available'),
(173, 'My Super Hater ', 'Fantasy', 1300, 1500, 88, 20, 'pieces', '08/15/2022', 'Available'),
(174, 'Our Yesterday\'s Escape', 'Mature', 1000, 1200, 99, 20, 'pieces', '07/14/2012', 'Available'),
(175, 'Yesterdays Escape', 'Mature', 1000, 1200, 90, 20, 'pieces', '07/14/2012', 'Available'),
(176, 'Yesterdays Escape', 'Mature', 1000, 1200, 99, 20, 'pieces', '07/14/2012', 'Available'),
(177, 'dsdf', 'dfgd', 345345, 435, 532, 345, 'dgfgdfg', 'dgf', 'Available'),
(178, 'sdsf', 'dsf', 324, 23424234, 234232, 20, 'dfdg', 'dfgdf', 'Available'),
(179, 'Saudade', 'Mature', 1200, 1500, 89, 20, 'pieces', '09/22/2002', 'Available'),
(180, 'Safe Sky Archer', 'Fiction', 1300, 1500, 89, 20, 'pieces', '09/22/2002', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `products_sold`
--

CREATE TABLE `products_sold` (
  `transctionId` int(15) NOT NULL,
  `productname` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `registrar`
--

CREATE TABLE `registrar` (
  `id` int(11) NOT NULL,
  `Firstname` varchar(50) NOT NULL,
  `Lastname` char(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Usertype` varchar(50) NOT NULL COMMENT 'Cashier, Staff',
  `Status` varchar(50) NOT NULL COMMENT 'Active, Inactive'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registrar`
--

INSERT INTO `registrar` (`id`, `Firstname`, `Lastname`, `Username`, `Password`, `Email`, `Usertype`, `Status`) VALUES
(39, 'lorgem', 'bosque', 'lorgemm', '1234', 'lorgem@gmail.com', 'Staff', 'active'),
(41, 'dsf', 'dsf', 'sdf', 'fdgf', 'fgdg', 'Select Role', 'active'),
(44, 'ara', 'secuya', 'araara', '1234', 'ara@gmail.com', 'Staff', 'active'),
(46, 'Christian', 'maderazo', 'chris', '1234', 'chris@gmail.com', 'Staff', 'active'),
(48, 'kyxx', 'formoso', 'kyxxl', '1234', 'kyxl@gmail.com', 'Staff', 'active'),
(52, 'chris', 'maderazo', 'christian', '1234', 'CHRISTIAN@gmail.com', 'Staff', 'active'),
(57, 'lorgem', 'bosque', 'lorgemm', '1234', 'lorgem@gmail.com', 'Cashier', 'active'),
(58, 'lorgem', 'bosque', 'lorgemm', '1234', 'lorgem@gmail.com', 'Cashier', 'active'),
(59, 'ara', 'secuya', 'ara ara', '1234', 'ara@gmail.com', 'Staff', 'active'),
(60, 'Ara', 'Secuya', 'ara ara', 'ara', 'ara@gmail.com', 'Staff', 'active'),
(61, 'Christine', 'Martonia', 'tinytin', 'tin', 'tin@gmail.com', 'Cashier', 'active'),
(62, 'elena', 'lara', 'mariae', 'lara', 'elena@gmail.com', 'Staff', 'active'),
(63, 'Christine', 'Martonia', 'tinytin', 'tin', 'Christine@gmail.com', 'Staff', 'Inactive'),
(64, 'Ara', 'Secuya', 'ara ara', 'ara', 'ara@gmail.com', 'Cashier', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `stransactions`
--

CREATE TABLE `stransactions` (
  `StransactionsID` int(11) NOT NULL,
  `InventoryID` int(11) NOT NULL,
  `ProductName` varchar(15) NOT NULL,
  `Quantity` float NOT NULL,
  `TypeofTransaction` varchar(50) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Time` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stransactions`
--

INSERT INTO `stransactions` (`StransactionsID`, `InventoryID`, `ProductName`, `Quantity`, `TypeofTransaction`, `UserID`, `Date`, `Time`) VALUES
(22, 131, '', 6000, 'EDIT', 2, '2022-24-05', '07:51 PM'),
(23, 133, '', 3434, 'EDIT', 2, '2022-24-05', '07:52 PM'),
(24, 134, '', 456, 'ADD', 3, '2022-24-05', '08:13 PM'),
(25, 132, '', 5654, 'EDIT', 4, '2022-24-05', '08:20 PM'),
(26, 133, '', 3434, 'ADD', 3, '2022-24-05', '08:24 PM'),
(27, 133, '', 3434, 'ADD', 3, '2022-24-05', '08:24 PM'),
(28, 133, '', 3434, 'EDIT', 3, '2022-24-05', '08:26 PM'),
(51, 1, '', 56464, 'ADD', 3, '2022-24-05', '09:51 PM'),
(52, 4343, '', 123, 'ADD', 3, '2022-24-05', '09:54 PM'),
(53, 65, '', 100, 'ADD', 3, '2022-24-05', '10:27 PM'),
(54, 137, '', 100, 'ADD', 3, '2022-24-05', '10:53 PM'),
(55, 138, '', 100, 'ADD', 3, '2022-24-05', '11:09 PM'),
(56, 138, '', 200, 'EDIT', 48, '2022-25-05 07:54 AM', '07:54 AM'),
(57, 143, '', 100, 'ADD', 48, '2022-25-05 08:13 AM', '08:13 AM'),
(58, 144, '', 100, 'ADD', 48, '2022-25-05 08:39 AM', '08:39 AM'),
(59, 144, '', 200, 'EDIT', 48, '2022-25-05 08:40 AM', '08:40 AM'),
(60, 136, '', 200, 'EDIT', 48, '2022-25-05 08:42 AM', '08:42 AM'),
(61, 145, '', 100, 'ADD', 48, '2022-25-05 08:43 AM', '08:43 AM'),
(62, 145, '', 200, 'EDIT', 48, '2022-25-05 08:45 AM', '08:45 AM'),
(63, 145, '', 200, 'EDIT', 48, '2022-25-05 08:45 AM', '08:45 AM'),
(64, 146, '', 453, 'ADD', 48, '2022-25-05 08:46 AM', '08:46 AM'),
(65, 145, '', 300, 'EDIT', 48, '2022-25-05 08:55 AM', '08:55 AM'),
(66, 147, '', 435, 'ADD', 48, '2022-25-05 08:55 AM', '08:55 AM'),
(67, 147, '', 435, 'EDIT', 48, '2022-25-05 08:56 AM', '08:56 AM'),
(68, 146, '', 453, 'EDIT', 48, '2022-25-05 08:56 AM', '08:56 AM'),
(69, 148, '', 2334, 'ADD', 48, '2022-25-05 09:15 AM', '09:15 AM'),
(70, 149, '', 100, 'ADD', 48, '2022-30-05 08:43 AM', '08:43 AM'),
(71, 149, '', 20032, 'EDIT', 48, '2022-30-05 09:39 AM', '09:39 AM'),
(72, 149, '', 20032, 'EDIT', 48, '2022-30-05 09:40 AM', '09:40 AM'),
(73, 154, '', 434, 'ADD', 48, '2022-30-05 09:40 AM', '09:40 AM'),
(74, 145, '', 4000, 'EDIT', 29, '2022-30-05 12:42 PM', '12:42 PM'),
(75, 155, '', 45, 'ADD', 29, '2022-30-05 12:42 PM', '12:42 PM'),
(76, 156, '', 200, 'ADD', 29, '2022-30-05 03:05 PM', '03:05 PM'),
(77, 136, '', 300, 'EDIT', 29, '2022-30-05 03:06 PM', '03:06 PM'),
(78, 157, '', 34545, 'ADD', 29, '2022-30-05 03:07 PM', '03:07 PM'),
(79, 156, '', 200, 'EDIT', 29, '2022-31-05 12:31 PM', '12:31 PM'),
(80, 158, '', 4353, 'ADD', 29, '2022-31-05 12:31 PM', '12:31 PM'),
(81, 159, '', 456, 'ADD', 29, '2022-31-05 02:46 PM', '02:46 PM'),
(82, 160, '', 546, 'ADD', 29, '2022-31-05 02:48 PM', '02:48 PM'),
(83, 160, '', 4545, 'EDIT', 29, '2022-31-05 02:49 PM', '02:49 PM'),
(84, 160, '', 434, 'EDIT', 29, '2022-31-05 02:53 PM', '02:53 PM'),
(85, 159, 'fsdf', 500, 'EDIT', 29, '2022-01-06 08:59 AM', '08:59 AM'),
(86, 167, 'fgh', 657, 'ADD', 29, '2022-01-06 10:00 AM', '10:00 AM'),
(87, 168, 'wer', 435, 'ADD', 29, '2022-01-06 10:15 AM', '10:15 AM'),
(88, 169, 'Rain in Espanya', 99, 'ADD', 29, '2022-02-06 09:28 AM', '09:28 AM'),
(89, 172, 'Saudade', 89, 'ADD', 29, '2022-02-06 09:42 AM', '09:42 AM'),
(90, 173, 'My Super Hater ', 88, 'ADD', 29, '2022-02-06 10:42 AM', '10:42 AM'),
(91, 177, 'dsdf', 534, 'ADD', 33, '2022-02-06 12:48 PM', '12:48 PM'),
(92, 178, 'sdsf', 234234, 'ADD', 29, '2022-02-06 06:17 PM', '06:17 PM'),
(93, 179, 'Saudade', 89, 'ADD', 29, '2022-02-06 07:28 PM', '07:28 PM'),
(94, 178, 'sdsf', 234234, 'EDIT', 33, '2022-02-06 07:33 PM', '07:33 PM'),
(95, 172, 'Saudade', 90, 'EDIT', 29, '2022-02-06 07:58 PM', '07:58 PM'),
(96, 180, 'Safe Sky Archer', 89, 'ADD', 29, '2022-02-06 07:59 PM', '07:59 PM');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UID` int(11) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `role` varchar(40) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UID`, `firstname`, `lastname`, `username`, `password`, `email`, `role`, `status`) VALUES
(1, 'Lorgem', 'formoso', 'gem', 'gem', 'gem@gmail.com', 'Admin', 'active'),
(2, 'jerica kaye', 'libradilla', 'kaye', '1234', 'kaye@gmail.com', 'cashier', 'inactive'),
(14, 'chris', 'maderazo', 'christian', '1234', 'christian@gmail.com', 'Admin', 'inactive'),
(18, 'ara', 'secuya', 'ara ara', '1234', 'ara@gmail.com', 'Admin', 'inactive'),
(19, 'christian', 'maderazo', 'christian', '1234', 'christian@gmail.com', 'Admin', 'inactive'),
(20, 'Christian', 'Maderazo', 'christian', 'gwapo', 'christian@gmail.com', 'Admin', 'inactive'),
(22, 'aron', 'balais', 'aronn', '1234', 'aron@gmail.com', 'Admin', 'inactive'),
(24, 'asd', 'sad', 'sad', 'asd', 'sad', 'asd', 'inactive'),
(26, 'rewr', 'ewrew', 'wer', 'ewr', 'ewr', 'wer', 'inactive'),
(28, 'lorgemm', 'bosque', 'lorgemm', '1234', 'lorgem@gmail.com', 'Cashier', 'active'),
(29, 'lorgem', 'formoso', '@lorgem', '1234', 'formoso@gmail.com', 'Staff', 'active'),
(33, 'Christine', 'Martonia', 'tinytin', 'tin', 'tin@gmail.com', 'Staff', 'inactive'),
(34, 'Ara', 'Secuya', 'ara ara', 'ara', 'ara@gmail.com', 'Cashier', 'active'),
(36, 'ssad', 'qwe', 'wqe', 'wqe', 'wqeqwe', 'wqe', 'inactive'),
(39, 'Christian', 'Maderazo', 'christian', 'gwapo', 'christian@gmail.com', 'Cashier', 'Inactive');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cashiertransactions`
--
ALTER TABLE `cashiertransactions`
  ADD PRIMARY KEY (`ctransactionID`);

--
-- Indexes for table `ctransaction`
--
ALTER TABLE `ctransaction`
  ADD PRIMARY KEY (`ctransactionID`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`Bid`);

--
-- Indexes for table `manage_categories`
--
ALTER TABLE `manage_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manage_sellers`
--
ALTER TABLE `manage_sellers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`InventoryID`);

--
-- Indexes for table `products_sold`
--
ALTER TABLE `products_sold`
  ADD PRIMARY KEY (`transctionId`);

--
-- Indexes for table `registrar`
--
ALTER TABLE `registrar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stransactions`
--
ALTER TABLE `stransactions`
  ADD PRIMARY KEY (`StransactionsID`),
  ADD KEY `trasactions` (`InventoryID`),
  ADD KEY `trasactions1` (`UserID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cashiertransactions`
--
ALTER TABLE `cashiertransactions`
  MODIFY `ctransactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `ctransaction`
--
ALTER TABLE `ctransaction`
  MODIFY `ctransactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `Bid` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3454;

--
-- AUTO_INCREMENT for table `manage_categories`
--
ALTER TABLE `manage_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=214;

--
-- AUTO_INCREMENT for table `manage_sellers`
--
ALTER TABLE `manage_sellers`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `InventoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=181;

--
-- AUTO_INCREMENT for table `registrar`
--
ALTER TABLE `registrar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `stransactions`
--
ALTER TABLE `stransactions`
  MODIFY `StransactionsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cashiertransactions`
--
ALTER TABLE `cashiertransactions`
  ADD CONSTRAINT `cashiertrans` FOREIGN KEY (`inventoryID`) REFERENCES `products` (`InventoryID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
