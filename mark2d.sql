-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2024 at 05:02 AM
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
-- Database: `mark2d`
--

-- --------------------------------------------------------

--
-- Table structure for table `studententry`
--

CREATE TABLE `studententry` (
  `s_studentno` int(20) NOT NULL,
  `s_LastName` varchar(20) NOT NULL,
  `s_FirstName` varchar(50) NOT NULL,
  `s_MiddleName` varchar(50) NOT NULL,
  `s_Program` varchar(50) NOT NULL,
  `s_Section` varchar(50) NOT NULL,
  `s_Address` varchar(50) NOT NULL,
  `Contact_no` varchar(50) NOT NULL,
  `u_image` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tran`
--

CREATE TABLE `tbl_tran` (
  `t_id` int(20) NOT NULL,
  `s_studentno` int(20) NOT NULL,
  `student_no` int(20) NOT NULL,
  `date` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `u_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE `tbl_users` (
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
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`) VALUES
(1, 'mark', 'espinosa', 'markk', 'marky', 'x3Xnt1ft5jDNCqERO9ECZhqziCnKUqZCKreChi8mhkY=', 'admin', 'active');

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
(1, 'markkkk', 'qweqweqwe', 'qweqwe', '2024-2025 2nd SEM', 'Threatening', '1st WARNING ', 'Minor Offense', 'src/userimages/7.jpg'),
(2, 'qweqwess', 'qweqw', 'eqweqwe', '2024-2025 2nd SEM', 'Alcohol', '2nd WARNING ', 'Major Offense', 'src/userimages/21.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `studententry`
--
ALTER TABLE `studententry`
  ADD PRIMARY KEY (`s_studentno`);

--
-- Indexes for table `tbl_tran`
--
ALTER TABLE `tbl_tran`
  ADD PRIMARY KEY (`t_id`),
  ADD KEY `uid` (`s_studentno`),
  ADD KEY `sid` (`student_no`),
  ADD KEY `id` (`u_id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
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
  MODIFY `s_studentno` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `tbl_tran`
--
ALTER TABLE `tbl_tran`
  MODIFY `t_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `violation`
--
ALTER TABLE `violation`
  MODIFY `student_no` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123213124;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_tran`
--
ALTER TABLE `tbl_tran`
  ADD CONSTRAINT `id` FOREIGN KEY (`u_id`) REFERENCES `tbl_users` (`u_id`),
  ADD CONSTRAINT `sid` FOREIGN KEY (`student_no`) REFERENCES `violation` (`student_no`),
  ADD CONSTRAINT `uid` FOREIGN KEY (`s_studentno`) REFERENCES `studententry` (`s_StudentNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
