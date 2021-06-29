-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2021 at 04:55 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `products`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category_title` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category_title`) VALUES
(1, 'Mobile_Phones'),
(2, 'Laptops'),
(3, 'Smart Watch');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `comment_text` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `comment_text`, `create_date`, `product_id`) VALUES
(4, 'zfdfsd', '2021-04-25 12:27:49', 4),
(5, 'ad', '2021-04-25 12:28:05', 5),
(6, 'comment', '2021-04-23 19:54:13', 2),
(7, 'comment work', '2021-04-23 19:54:32', 3),
(14, 'dsaasas', '2021-04-23 21:17:17', 1),
(15, 'dasdsa', '2021-04-25 12:28:12', 1),
(16, 'asda', '2021-04-25 12:28:16', 1),
(17, 'm,.', '2021-04-26 17:00:28', 1),
(18, 'l.,\'', '2021-04-26 17:00:32', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(22);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `category_id`, `img_url`, `name`, `price`) VALUES
(1, 2, 'https://img.zoommer.ge/zoommer-images/thumbs/0130278_apple-mgn63lla-macbook-air-13-m1-chip-space-grey_550.png', 'MackBook Pro', 4500),
(2, 2, 'https://img.zoommer.ge/zoommer-images/thumbs/0130310_apple-myd82lla-macbook-pro-13-m1-chip-2020-space-grey_550.png', 'MackBook Air ', 3800),
(3, 3, 'https://img.zoommer.ge/zoommer-images/thumbs/0120169_fitbit-charge-4-purple_550.png', 'Fitbit Charge 4', 300),
(4, 2, 'https://img.zoommer.ge/zoommer-images/thumbs/0135975_acer-chromebook-cb315-3h-c2c3-nxhkbaa002-silver_550.jpeg', 'Acer Chromebook', 2800),
(5, 2, 'https://img.zoommer.ge/zoommer-images/thumbs/0136053_lenovo-ideapad-1-81vu000jus-ice-blue_550.jpeg', 'Lenovo Ideapad', 1500),
(6, 1, 'https://img.zoommer.ge/zoommer-images/thumbs/0127592_apple-iphone-12-pro-single-sim-128gb-pacific-blue_550.png', 'Apple iPhone 12 Pro', 3900),
(7, 1, 'https://img.zoommer.ge/zoommer-images/thumbs/0135151_samsung-galaxy-s21-ultra-dual-sim-12gb-ram-256gb-5g-black_550.png', 'Samsung Galaxy S21', 2800),
(8, 1, 'https://img.zoommer.ge/zoommer-images/thumbs/0133207_oneplus-8t-dual-sim-8gb-ram-128gb-5g-global-version-lunar-silver_550.png', 'Oneplus 8 Pro', 2700),
(9, 1, 'https://img.zoommer.ge/zoommer-images/thumbs/0130255_google-pixel-4a-g025e-single-sim-6gb-ram-128gb-5g_550.png', 'Google Pixel 5', 2500),
(10, 3, 'https://img.zoommer.ge/zoommer-images/thumbs/0126239_apple-watch-series-se-gps-mydp2-40mm-space-gray-aluminum-case-with-black-sport-band_550.png', 'Apple Watch Series SE', 800),
(11, 3, 'https://img.zoommer.ge/zoommer-images/thumbs/0112372_samsung-sm-820-44mm-galaxy-watch-active-2-black_550.png', 'Galaxy Watch Active 2 black', 700),
(12, 3, 'https://img.zoommer.ge/zoommer-images/thumbs/0131259_xiaomi-amazfit-gts-black_550.png', 'Xiaomi Amazfit GTS Black', 500),
(13, 3, 'https://img.zoommer.ge/zoommer-images/thumbs/0126239_apple-watch-series-se-gps-mydp2-40mm-space-gray-aluminum-case-with-black-sport-band_550.png', 'Apple Watch Series 6', 345),
(19, 2, 'https://img.zoommer.ge/zoommer-images/thumbs/0130310_apple-myd82lla-macbook-pro-13-m1-chip-2020-space-grey_550.png', 'MackBook Air 13.5', 4800);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
