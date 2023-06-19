-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2023 at 05:36 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tmd_dpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `tscore`
--

CREATE TABLE `tscore` (
  `username` varchar(255) NOT NULL,
  `score` int(50) NOT NULL,
  `standing` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tscore`
--

INSERT INTO `tscore` (`username`, `score`, `standing`) VALUES
('a', 9100, 157),
('aaa', 330, 8),
('b', 0, 0),
('bintang', 760, 18),
('c', 0, 0),
('d', 0, 0),
('fajar', 700, 8),
('rehan', 1920, 39),
('s', 60, 1),
('w', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tscore`
--
ALTER TABLE `tscore`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
