-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2022 at 05:05 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cc.db`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `confirm_password` varchar(255) NOT NULL,
  `account_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`user_id`, `first_name`, `last_name`, `address`, `email`, `phone_number`, `account_name`, `password`, `confirm_password`, `account_type`) VALUES
(9, 'Kent James', 'Sumayang', 'Carbon Public Market', '21103859@usc.edu.ph', '09505880114', 'Kent', '123', '123', 'admin'),
(10, 'Clint Anthony ', 'Savilla', 'Tabon, Dalaguete, Cebu', '21103859@usc.edu.ph', '09505880114', 'Clintoy', '123', '123', 'user'),
(11, 'Kent James', 'Sumayang', 'Carbon, Public, Market', '21103859@usc.edu.ph', '09505880114', 'Kentoy', '123', '123', 'admin'),
(12, 'Julencio', 'Estorco', 'Negros, Canlaon, City', '21103859@usc.edu.ph', '09505880114', 'Juls', '123', '123', 'user'),
(13, 'Jomel', 'Calungsod', 'Boljoon, Cebu, City', '21103859@usc.edu.ph', '09505880114', 'Jomel', '123', '123', 'admin'),
(14, 'chanext', 'Misa', 'cebu', 'ggwp@gmail.com', '1234563789', 'Chanext', '11111', '11111', 'user'),
(15, 'Jessa Mea', 'Tano', 'Negros, Oriental, Philippines', '21103859@usc.edu.ph', '09505880114', 'Jessa M', '123', '123', 'user'),
(16, 'Rogina', 'Rolloque', 'Boljoon, Cebu', '21103859@usc.edu.ph', '09505880114', 'Rogina', '123', '123', 'user'),
(17, 'Michael', 'Ditchon', 'Tabon, Dalaguete, Cebu', '21103859@usc.edu.ph', '09505880114', 'Michael', '12345678', '12345678', 'user'),
(18, 'Hadrian', 'Evarula', 'Talaytay Argao Cebu', 'hadrian@gmail.com', '09166627293', 'Haddy', '123456', '123456', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
