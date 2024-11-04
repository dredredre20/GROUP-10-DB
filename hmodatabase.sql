CREATE DATABASE IF NOT EXISTS `HMO`;
USE `HMO`;

DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `patientID` int(10) NOT NULL,
  `patientLastName` varchar(50) NOT NULL,
  `patientFirstName` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `birthday` datetime NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contactPersonName` varchar(50) NOT NULL,
  `contactPersonNumber` varchar(50) NOT NULL,
  `bloodType` varchar(2) NOT NULL,
  `allergies` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`patientID`)
  );

DROP TABLE IF EXISTS `consultations`;
CREATE TABLE `consultations` (
  `consultationID` int(10) NOT NULL,
  `patientID` int(10) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `reason` varchar(100) NOT NULL,
  `doctorID` datetime NOT NULL,
  `notes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`consultationID`),
  FOREIGN KEY (`patientID`) REFERENCES `patients` (`patientID`)
  );

DROP TABLE IF EXISTS `doctors`;
CREATE TABLE `doctors` (
  `doctorID` int(10) NOT NULL,
  `doctorLastName` varchar(50) NOT NULL,
  `doctorFirstName` varchar(50) NOT NULL,
  `departmentID` int(10) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `birthday` datetime NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `licenseNumber` varchar(50) NOT NULL,
  `field` varchar(50) NOT NULL,
  `specialization` varchar(50) NOT NULL,
  `consultations` int(10) DEFAULT NULL,
  `workingHours` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`doctorID`),
  FOREIGN KEY (`consultations`) REFERENCES `consultations` (`consultationID`)
  );
  
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `departmentID` int(10) NOT NULL,
  `departmentName` varchar(50) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `headDoctor` int(10) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `capacity` int(3) NOT NULL,
  PRIMARY KEY (`departmentID`),
  FOREIGN KEY (`headDoctor`) REFERENCES `doctors` (`doctorID`)
  );
  
ALTER TABLE `doctors`
ADD FOREIGN KEY (`departmentID`) REFERENCES `departments` (`departmentID`);