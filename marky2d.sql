-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2024 at 12:06 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `marky2d`
--

-- --------------------------------------------------------

--
-- Table structure for table `studententry`
--

CREATE TABLE `studententry` (
  `s_StudentNo` int(20) NOT NULL,
  `s_LastName` varchar(50) NOT NULL,
  `s_FirstName` varchar(50) NOT NULL,
  `s_MIddleName` varchar(50) NOT NULL,
  `s_Program` varchar(50) NOT NULL,
  `s_Section` varchar(50) NOT NULL,
  `s_Address` varchar(50) NOT NULL,
  `Contact_no` varchar(50) NOT NULL,
  `u_image` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studententry`
--

INSERT INTO `studententry` (`s_StudentNo`, `s_LastName`, `s_FirstName`, `s_MIddleName`, `s_Program`, `s_Section`, `s_Address`, `Contact_no`, `u_image`) VALUES
(1, 'Ababon', 'Jhandel', 'P.', 'BSBA', 'C', 'purok kaka', '0999999999999', 'src/userimages/8.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`) VALUES
(3, 'mark', 'espinosa', 'markk', 'mark', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'user', 'active'),
(4, 'markk', 'espinossaa', 'markkk', 'marky', 'x3Xnt1ft5jDNCqERO9ECZhqziCnKUqZCKreChi8mhkY=', 'admin', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `violation`
--

CREATE TABLE `violation` (
  `student_no` int(20) NOT NULL,
  `s_name` varchar(50) NOT NULL,
  `s_program` varchar(50) NOT NULL,
  `s_section` varchar(50) NOT NULL,
  `ay_code` varchar(50) NOT NULL,
  `s_violation` varchar(50) NOT NULL,
  `s_sanction` varchar(50) NOT NULL,
  `s_type` varchar(50) NOT NULL,
  `u_image` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `violation`
--

INSERT INTO `violation` (`student_no`, `s_name`, `s_program`, `s_section`, `ay_code`, `s_violation`, `s_sanction`, `s_type`, `u_image`) VALUES
(1, 'Jhandel Ababon', 'BSBA', 'A', '2024-2025 2nd SEM', 'Cheating', '1st WARNING ', 'Minor Offense', 'src/userimages/7.jpg'),
(2, 'Ace Bacus', 'BSIT', 'B', '2024-2025 2nd SEM', 'Alcohol', '1st WARNING', 'Minor Offense', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `studententry`
--
ALTER TABLE `studententry`
  ADD PRIMARY KEY (`s_StudentNo`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `violation`
--
ALTER TABLE `violation`
  ADD PRIMARY KEY (`student_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `studententry`
--
ALTER TABLE `studententry`
  MODIFY `s_StudentNo` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `violation`
--
ALTER TABLE `violation`
  MODIFY `student_no` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
