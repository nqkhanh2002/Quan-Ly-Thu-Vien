-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2021 at 07:56 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql6424812`
--

-- --------------------------------------------------------

--
-- Table structure for table `ctphieumuonsach`
--

CREATE TABLE `ctphieumuonsach` (
  `MACTPHIEUMUONSACH` int(11) NOT NULL,
  `MAPHIEUMUONSACH` int(11) NOT NULL,
  `MASACH` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ctphieutrasach`
--

CREATE TABLE `ctphieutrasach` (
  `MACTPHIEUTRASACH` int(11) NOT NULL,
  `MAPHIEUTRASACH` int(11) NOT NULL,
  `SONGAYTRATRE` int(11) NOT NULL,
  `TIENPHAT` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `loaidocgia`
--

CREATE TABLE `loaidocgia` (
  `MALOAIDOCGIA` int(11) NOT NULL,
  `TENLOAIDOCGIA` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaidocgia`
--

INSERT INTO `loaidocgia` (`MALOAIDOCGIA`, `TENLOAIDOCGIA`) VALUES
(1, 'X'),
(2, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `phieumuonsach`
--

CREATE TABLE `phieumuonsach` (
  `MAPHIEUMUONSACH` int(11) NOT NULL,
  `NGAYMUON` varchar(30) NOT NULL,
  `MADOCGIA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phieuthutienphat`
--

CREATE TABLE `phieuthutienphat` (
  `ID` int(11) NOT NULL,
  `MADOCGIA` int(11) NOT NULL,
  `TIENTHU` int(11) NOT NULL,
  `CONLAI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phieutrasach`
--

CREATE TABLE `phieutrasach` (
  `MAPHIEUTRASACH` int(11) NOT NULL,
  `NGAYTRA` varchar(30) NOT NULL,
  `MAPHIEUMUONSACH` int(11) NOT NULL,
  `TIENPHATKYNAY` double NOT NULL,
  `TIENNOKYNAY` double NOT NULL,
  `TONGNO` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `MATACGIA` int(10) NOT NULL,
  `TENTACGIA` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`MATACGIA`, `TENTACGIA`) VALUES
(1, 'Nam Cao'),
(2, 'Vũ Trọng Phụng'),
(3, 'Phung Quan'),
(4, 'Nguyen Hong'),
(5, 'Bao Ninh');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `ID` int(10) NOT NULL,
  `TENTK` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `MATKHAU` varchar(100) NOT NULL,
  `SDT` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`ID`, `TENTK`, `EMAIL`, `MATKHAU`, `SDT`) VALUES
(1, 'Minh', 'minh.ngntri@gmail.com', '12345678', '012345678');

-- --------------------------------------------------------

--
-- Table structure for table `thedocgia`
--

CREATE TABLE `thedocgia` (
  `MADOCGIA` int(11) NOT NULL,
  `HOTEN` varchar(50) NOT NULL,
  `MALOAIDOCGIA` int(11) NOT NULL,
  `DIACHI` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `NGAYSINH` text NOT NULL,
  `NGAYLAPTHE` text NOT NULL,
  `TUOI` int(11) DEFAULT NULL,
  `NGAYHETHAN` text NOT NULL,
  `TONGNODOCGIA` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `thedocgia`
--

INSERT INTO `thedocgia` (`MADOCGIA`, `HOTEN`, `MALOAIDOCGIA`, `DIACHI`, `EMAIL`, `NGAYSINH`, `NGAYLAPTHE`, `TUOI`, `NGAYHETHAN`, `TONGNODOCGIA`) VALUES
(1, 'Trần Phúc Long', 2, 'TPHCM', 'tranphuclong@gmail.com', '08/11/2000', '13/07/2021', NULL, '13/01/2022', 0),
(2, 'Ngọc Hân', 2, 'Hà Nội', 'han@gmail.com', '11/07/2001', '01/07/2021', NULL, '01/01/2022', 0),
(3, 'Hà Giang', 1, 'HCM', 'giang@gmail.com', '11/07/2001', '14/07/2021', NULL, '14/01/2022', 0),
(4, 'Sơn Ngọc Minh', 2, 'Hà Tĩnh', 'minh@gmail.com', '08/07/2000', '02/07/2021', NULL, '02/01/2022', 0),
(5, 'Phạm Minh Đức', 1, 'Bình Dương', 'duc@gmail.com', '01/07/1999', '02/07/2021', NULL, '02/01/2022', 0),
(6, 'Nguyễn Văn Hoàng', 1, 'Khánh Hòa', 'hoang@gmail.com', '01/05/2001', '02/07/2021', NULL, '02/01/2022', 0),
(7, 'Nguyễn Minh Đăng', 2, 'Hà Nội', 'dang122@gmail.com', '16/01/2001', '09/07/2021', NULL, '09/01/2022', 0);

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `MATHELOAI` int(10) NOT NULL,
  `TENTHELOAI` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`MATHELOAI`, `TENTHELOAI`) VALUES
(1, 'Truyện ngắn'),
(2, 'Tiểu thuyết'),
(3, 'Truyện cười');

-- --------------------------------------------------------

--
-- Table structure for table `thongtinsach`
--

CREATE TABLE `thongtinsach` (
  `MASACH` int(10) NOT NULL,
  `TENSACH` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `MATHELOAI` int(10) NOT NULL,
  `MATACGIA` int(10) NOT NULL,
  `NAMXUATBAN` year(4) NOT NULL,
  `NHAXUATBAN` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYNHAP` text COLLATE utf8_unicode_ci NOT NULL,
  `TRIGIA` double NOT NULL,
  `TINHTRANG` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TRANGTHAI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thongtinsach`
--

INSERT INTO `thongtinsach` (`MASACH`, `TENSACH`, `MATHELOAI`, `MATACGIA`, `NAMXUATBAN`, `NHAXUATBAN`, `NGAYNHAP`, `TRIGIA`, `TINHTRANG`, `TRANGTHAI`) VALUES
(1, 'Toi la Betto', 1, 4, 2003, 'NXB Kim Dong', '12/2/2018', 100000, 'Mới', 0),
(2, 'Tuổi thơ dữ dội', 1, 3, 1998, 'NXB Sach Moi', '18/6/2021', 90000, 'Cũ', 0),
(3, 'Chí Phèo', 1, 1, 1985, 'NXB The he moi', '09/5/1999', 45000, 'Mới', 0),
(4, 'Vợ Nhặt', 1, 1, 2009, 'NXB The he moi', '14/04/2019', 80000, 'Cũ', 0),
(5, 'Số đỏ', 1, 2, 2003, 'NXB Kim Dong', '19/08/2020', 90000, 'Cũ', 0),
(6, 'Bi Vo', 1, 4, 2001, 'NXB The he moi', '1/11/2013', 78000, 'Cũ', 0),
(7, 'Canh Dong Bat Tan', 2, 5, 2016, 'NXB Kim Dong', '8/9/2018', 75000, 'Cũ', 0),
(8, 'Noi Buon Chien Tranh', 1, 5, 2010, 'NXB eBook', '20/10/2017', 30000, 'Mới', 0),
(9, 'Giong to', 2, 2, 2011, 'NXB Kim Dong', '19/9/2017', 28000, 'Mới', 0),
(10, 'Song Mon', 2, 3, 2015, 'NXB PPP', '07/05/2004', 95000, 'Mới', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ctphieumuonsach`
--
ALTER TABLE `ctphieumuonsach`
  ADD PRIMARY KEY (`MACTPHIEUMUONSACH`),
  ADD KEY `FK_MAPHIEUMUONSACH` (`MAPHIEUMUONSACH`),
  ADD KEY `FK2_MASACH` (`MASACH`);

--
-- Indexes for table `ctphieutrasach`
--
ALTER TABLE `ctphieutrasach`
  ADD PRIMARY KEY (`MACTPHIEUTRASACH`),
  ADD KEY `FK_MAPHIEUTRASACH` (`MAPHIEUTRASACH`);

--
-- Indexes for table `loaidocgia`
--
ALTER TABLE `loaidocgia`
  ADD PRIMARY KEY (`MALOAIDOCGIA`);

--
-- Indexes for table `phieumuonsach`
--
ALTER TABLE `phieumuonsach`
  ADD PRIMARY KEY (`MAPHIEUMUONSACH`),
  ADD KEY `FK2_MADOCGIA` (`MADOCGIA`);

--
-- Indexes for table `phieuthutienphat`
--
ALTER TABLE `phieuthutienphat`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `MADOCGIA` (`MADOCGIA`);

--
-- Indexes for table `phieutrasach`
--
ALTER TABLE `phieutrasach`
  ADD PRIMARY KEY (`MAPHIEUTRASACH`),
  ADD KEY `FK3_MAPHIEUMUONSACH` (`MAPHIEUMUONSACH`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MATACGIA`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `thedocgia`
--
ALTER TABLE `thedocgia`
  ADD PRIMARY KEY (`MADOCGIA`),
  ADD KEY `MALOAIDOCGIA` (`MALOAIDOCGIA`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`MATHELOAI`);

--
-- Indexes for table `thongtinsach`
--
ALTER TABLE `thongtinsach`
  ADD PRIMARY KEY (`MASACH`),
  ADD KEY `FK_MATACGIA` (`MATACGIA`),
  ADD KEY `FK_MATHELOAI` (`MATHELOAI`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ctphieumuonsach`
--
ALTER TABLE `ctphieumuonsach`
  MODIFY `MACTPHIEUMUONSACH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ctphieutrasach`
--
ALTER TABLE `ctphieutrasach`
  MODIFY `MACTPHIEUTRASACH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loaidocgia`
--
ALTER TABLE `loaidocgia`
  MODIFY `MALOAIDOCGIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `phieumuonsach`
--
ALTER TABLE `phieumuonsach`
  MODIFY `MAPHIEUMUONSACH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieuthutienphat`
--
ALTER TABLE `phieuthutienphat`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieutrasach`
--
ALTER TABLE `phieutrasach`
  MODIFY `MAPHIEUTRASACH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `MATACGIA` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `thedocgia`
--
ALTER TABLE `thedocgia`
  MODIFY `MADOCGIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `theloai`
--
ALTER TABLE `theloai`
  MODIFY `MATHELOAI` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `thongtinsach`
--
ALTER TABLE `thongtinsach`
  MODIFY `MASACH` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctphieumuonsach`
--
ALTER TABLE `ctphieumuonsach`
  ADD CONSTRAINT `FK2_MASACH` FOREIGN KEY (`MASACH`) REFERENCES `thongtinsach` (`MASACH`),
  ADD CONSTRAINT `FK_MAPHIEUMUONSACH` FOREIGN KEY (`MAPHIEUMUONSACH`) REFERENCES `phieumuonsach` (`MAPHIEUMUONSACH`);

--
-- Constraints for table `ctphieutrasach`
--
ALTER TABLE `ctphieutrasach`
  ADD CONSTRAINT `FK_MAPHIEUTRASACH` FOREIGN KEY (`MAPHIEUTRASACH`) REFERENCES `phieutrasach` (`MAPHIEUTRASACH`);

--
-- Constraints for table `phieumuonsach`
--
ALTER TABLE `phieumuonsach`
  ADD CONSTRAINT `FK2_MADOCGIA` FOREIGN KEY (`MADOCGIA`) REFERENCES `thedocgia` (`MADOCGIA`);

--
-- Constraints for table `phieuthutienphat`
--
ALTER TABLE `phieuthutienphat`
  ADD CONSTRAINT `phieuthutienphat_ibfk_1` FOREIGN KEY (`MADOCGIA`) REFERENCES `thedocgia` (`MADOCGIA`);

--
-- Constraints for table `phieutrasach`
--
ALTER TABLE `phieutrasach`
  ADD CONSTRAINT `FK3_MAPHIEUMUONSACH` FOREIGN KEY (`MAPHIEUMUONSACH`) REFERENCES `phieumuonsach` (`MAPHIEUMUONSACH`);

--
-- Constraints for table `thedocgia`
--
ALTER TABLE `thedocgia`
  ADD CONSTRAINT `thedocgia_ibfk_1` FOREIGN KEY (`MALOAIDOCGIA`) REFERENCES `loaidocgia` (`MALOAIDOCGIA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
