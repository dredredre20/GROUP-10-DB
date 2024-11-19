CREATE DATABASE IF NOT EXISTS `HMO`;
USE `HMO`;
  
  
DROP TABLE IF EXISTS `doctors`;
CREATE TABLE `doctors` (
  `doctorID` int(10) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `birthday` datetime NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
	`email` varchar(50) NOT NULL,
	PRIMARY KEY (`doctorID`)
  );

DROP TABLE IF EXISTS `doctorWorkInfo`;
CREATE TABLE `doctorWorkInfo`(
	`doctorID` int(10) NOT NULL,
	`salary` int(10) NOT NULL,
    `licenseNumber` varchar(50) NOT NULL,
	`workingHours` varchar(50) DEFAULT NULL,
    `maxPatientLoad` int(2) NOT NULL,
    `currentPatientLoad` int(2) NOT NULL,
    PRIMARY KEY (`doctorID`),
    FOREIGN KEY (`doctorID`) REFERENCES `doctors` (`doctorID`)
);

DROP TABLE IF EXISTS `doctorSpecializations`;
CREATE TABLE `doctorSpecializations`(
	`doctorID` int(10) NOT NULL,
	`name` varchar(50) NOT NULL,
    `certificateDate` date NOT NULL,
    `expiryDate` date NOT NULL,
    PRIMARY KEY (`doctorID`),
    FOREIGN KEY (`doctorID`) REFERENCES `doctors` (`doctorID`)
);
  

DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `patientID` int(10) NOT NULL AUTO_INCREMENT,
  `patientLastName` varchar(50) NOT NULL,
  `patientFirstName` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `birthday` datetime NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `bloodType` varchar(2) NOT NULL,
  `allergies` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`patientID`)
  );
  
  DROP TABLE IF EXISTS `contactPerson`;
  CREATE TABLE `contactPerson`(
	`patientID` int(10) NOT NULL,
	`firstName` varchar(50) NOT NULL, 
    `lastName` varchar(50) NOT NULL, 
    `phoneNumber` varchar(50) NOT NULL,
    `relationship` varchar(50) NOT NULL,
	PRIMARY KEY (`patientID`),
    FOREIGN KEY (`patientID`) REFERENCES `patients` (`patientID`)
  );
  
  
DROP TABLE IF EXISTS `consultations`;
CREATE TABLE `consultations` (
  `consultationID` int(10) NOT NULL,
  `patientID` int(10) NOT NULL,
  `doctorID` int(10) NOT NULL,
  `consultationDate` datetime NOT NULL,
  `satisfactionRating` int(3) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  PRIMARY KEY (`consultationID`),
  FOREIGN KEY (`patientID`) REFERENCES `patients` (`patientID`),
  FOREIGN KEY(`doctorID`) REFERENCES `doctors` (`doctorID`)
  );
  
DROP TABLE IF EXISTS `laboratory`;
  CREATE TABLE `laboratory`(
	`laboratoryID` int(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`address` varchar(100),
	`phoneNumber` varchar(50),
	PRIMARY KEY (`laboratoryID`)
  );
  
  DROP TABLE IF EXISTS `labRequest`;
  CREATE TABLE `labRequest`(
	`laboratoryID` int(10),
	`consultationID` int(10),
	`issuedBy` int(10),
    PRIMARY KEY (`laboratoryID`, `consultationID`),
    FOREIGN KEY (`laboratoryID`) REFERENCES `laboratory` (`laboratoryID`),
    FOREIGN KEY(`issuedBy`) REFERENCES `doctors` (`doctorID`), 
	FOREIGN KEY (`consultationID`) REFERENCES `consultations` (`consultationID`)
  );
  
DROP TABLE IF EXISTS `complaints`;
  CREATE TABLE `complaints`(
	`complaintDescription` varchar(50),
	`recommendedSpecialization` varchar(100),
	PRIMARY KEY (`complaintDescription`)
  );
  
  DROP TABLE IF EXISTS `consultationComplaints`;
  CREATE TABLE `consultationComplaints`(
	`consultationID` int(10) NOT NULL,
    `complaintDescription` varchar(50) NOT NULL,
    PRIMARY KEY(`consultationID`, `complaintDescription`),
	FOREIGN KEY (`consultationID`) REFERENCES `consultations` (`consultationID`),
    FOREIGN KEY(`complaintDescription`) REFERENCES `complaints` (`complaintDescription`)
    
  );
  
  DROP TABLE IF EXISTS `diagnosis`;
  CREATE TABLE `diagnosis` (
	`consultationID` int(10) NOT NULL,
	`diagnosisDescription` varchar(100),
	`severity` varchar(50),
	PRIMARY KEY (`consultationID`, `diagnosisDescription`),
	FOREIGN KEY (`consultationID`) REFERENCES `consultations` (`consultationID`)
  );
  
DROP TABLE IF EXISTS `medicine`;
  CREATE TABLE `medicine`(
	`medicineID` int(10) NOT NULL AUTO_INCREMENT,
	`brandName` varchar(50), 
	`commonName` varchar(50), 
	`quantity` int(3), 
	`availability` int(3),
    PRIMARY KEY(`medicineID`)
  );
  
  DROP TABLE IF EXISTS `prescription`;
  CREATE TABLE `prescription`(
	`medicineID` int(10) NOT NULL,
    `consultationID` int(10) NOT NULL,
    `dosage` varchar(50) NOT NULL, 
    `frequency` varchar(50) NOT NULL, 
    `startDate` date, 
	`endDate` date, 
	`notes` varchar(100), 
    PRIMARY KEY (`medicineID`, `consultationID`), 
	FOREIGN KEY (`consultationID`) REFERENCES `consultations` (`consultationID`),
	FOREIGN KEY (`medicineID`) REFERENCES `medicine` (`medicineID`)
  );
  
  
  
  
  
  

