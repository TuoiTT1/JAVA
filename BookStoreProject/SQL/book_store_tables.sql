-- MySQL Workbench Synchronization
-- Generated: 2020-10-11 23:13
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: TuoiTran

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

ALTER SCHEMA `db_book_store`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Account` (
  `Email` VARCHAR(100) NOT NULL,
  `Address_ID` INT(11) NOT NULL,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(50) NOT NULL,
  `FirstName` VARCHAR(50) NULL DEFAULT NULL,
  `LastName` VARCHAR(50) NULL DEFAULT NULL,
  `Phone` VARCHAR(15) NULL DEFAULT NULL,
  `Birthday` DATE NULL DEFAULT NULL,
  `Admin` TINYINT(4) NOT NULL,
  `CreateDate` DATETIME NOT NULL,
  PRIMARY KEY (`Email`),
  INDEX `fk_Account_Address_idx` (`Address_ID` ASC),
  CONSTRAINT `fk_Account_Address`
    FOREIGN KEY (`Address_ID`)
    REFERENCES `db_book_store`.`Address` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Address` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Num` VARCHAR(255) NULL DEFAULT NULL,
  `Ward` VARCHAR(255) NULL DEFAULT NULL,
  `Distric` VARCHAR(255) NULL DEFAULT NULL,
  `City` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Customer` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Coin` INT(11) NULL DEFAULT NULL,
  `Account_Email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Customer_Account1_idx` (`Account_Email` ASC),
  CONSTRAINT `fk_Customer_Account1`
    FOREIGN KEY (`Account_Email`)
    REFERENCES `db_book_store`.`Account` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Employee` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Position` VARCHAR(45) NULL DEFAULT NULL,
  `Account_Email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Employee_Account1_idx` (`Account_Email` ASC),
  CONSTRAINT `fk_Employee_Account1`
    FOREIGN KEY (`Account_Email`)
    REFERENCES `db_book_store`.`Account` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Category` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Book` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Author` VARCHAR(255) NOT NULL,
  `YearOfPublication` INT(11) NULL DEFAULT NULL,
  `Publisher` VARCHAR(255) NULL DEFAULT NULL,
  `ImageURL` VARCHAR(45) NULL DEFAULT NULL,
  `Description` VARCHAR(45) NULL DEFAULT NULL,
  `Price` FLOAT(11) NULL DEFAULT NULL,
  `Quantity` INT(11) NOT NULL,
  `isDeleted` TINYINT(4) NULL DEFAULT NULL,
  `Category_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Book_Category1_idx` (`Category_ID` ASC),
  CONSTRAINT `fk_Book_Category1`
    FOREIGN KEY (`Category_ID`)
    REFERENCES `db_book_store`.`Category` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Cart` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Customer_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Cart_Customer1_idx` (`Customer_ID` ASC),
  CONSTRAINT `fk_Cart_Customer1`
    FOREIGN KEY (`Customer_ID`)
    REFERENCES `db_book_store`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`BookOrder` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Quantity` INT(11) NOT NULL,
  `Cart_ID` INT(11) NOT NULL,
  `Book_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_BookOrder_Cart1_idx` (`Cart_ID` ASC),
  INDEX `fk_BookOrder_Book1_idx` (`Book_ID` ASC),
  CONSTRAINT `fk_BookOrder_Cart1`
    FOREIGN KEY (`Cart_ID`)
    REFERENCES `db_book_store`.`Cart` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookOrder_Book1`
    FOREIGN KEY (`Book_ID`)
    REFERENCES `db_book_store`.`Book` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Order` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CreateDate` DATETIME NOT NULL,
  `isBill` TINYINT(4) NULL DEFAULT NULL,
  `ShippingInfo_ID` INT(11) NOT NULL,
  `Cart_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Order_ShippingInfo1_idx` (`ShippingInfo_ID` ASC),
  INDEX `fk_Order_Cart1_idx` (`Cart_ID` ASC),
  CONSTRAINT `fk_Order_ShippingInfo1`
    FOREIGN KEY (`ShippingInfo_ID`)
    REFERENCES `db_book_store`.`ShippingInfo` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Cart1`
    FOREIGN KEY (`Cart_ID`)
    REFERENCES `db_book_store`.`Cart` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`ShippingInfo` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Phone` VARCHAR(15) NULL DEFAULT NULL,
  `Receiver` VARCHAR(100) NULL DEFAULT NULL,
  `Address_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ShippingInfo_Address1_idx` (`Address_ID` ASC),
  CONSTRAINT `fk_ShippingInfo_Address1`
    FOREIGN KEY (`Address_ID`)
    REFERENCES `db_book_store`.`Address` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Bill` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CreateDate` DATETIME NOT NULL,
  `TotalCash` DOUBLE NULL DEFAULT NULL,
  `Employee_ID` INT(11) NOT NULL,
  `Order_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Bill_Employee1_idx` (`Employee_ID` ASC),
  INDEX `fk_Bill_Order1_idx` (`Order_ID` ASC),
  CONSTRAINT `fk_Bill_Employee1`
    FOREIGN KEY (`Employee_ID`)
    REFERENCES `db_book_store`.`Employee` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bill_Order1`
    FOREIGN KEY (`Order_ID`)
    REFERENCES `db_book_store`.`Order` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`BookRating` (
  `ID` INT(11) NOT NULL,
  `rating` INT(11) NOT NULL,
  `Book_ID` INT(11) NOT NULL,
  `Customer_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_BookRating_Book1_idx` (`Book_ID` ASC),
  INDEX `fk_BookRating_Customer1_idx` (`Customer_ID` ASC),
  CONSTRAINT `fk_BookRating_Book1`
    FOREIGN KEY (`Book_ID`)
    REFERENCES `db_book_store`.`Book` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookRating_Customer1`
    FOREIGN KEY (`Customer_ID`)
    REFERENCES `db_book_store`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Sale` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `StartDate` DATETIME NOT NULL,
  `EndDate` DATETIME NOT NULL,
  `Description` VARCHAR(255) NULL DEFAULT NULL,
  `Discount` FLOAT(11) NOT NULL,
  `Employee_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Sale_Employee1_idx` (`Employee_ID` ASC),
  CONSTRAINT `fk_Sale_Employee1`
    FOREIGN KEY (`Employee_ID`)
    REFERENCES `db_book_store`.`Employee` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`BookSale` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Sale_ID` INT(11) NOT NULL,
  `Book_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_BookSale_Sale1_idx` (`Sale_ID` ASC),
  INDEX `fk_BookSale_Book1_idx` (`Book_ID` ASC),
  CONSTRAINT `fk_BookSale_Sale1`
    FOREIGN KEY (`Sale_ID`)
    REFERENCES `db_book_store`.`Sale` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookSale_Book1`
    FOREIGN KEY (`Book_ID`)
    REFERENCES `db_book_store`.`Book` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_book_store`.`Store` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `UpdateDate` DATETIME NOT NULL,
  `ReasonUpdate` VARCHAR(255) NULL DEFAULT NULL,
  `Employee_ID` INT(11) NOT NULL,
  `Book_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Store_Employee1_idx` (`Employee_ID` ASC),
  INDEX `fk_Store_Book1_idx` (`Book_ID` ASC),
  CONSTRAINT `fk_Store_Employee1`
    FOREIGN KEY (`Employee_ID`)
    REFERENCES `db_book_store`.`Employee` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Store_Book1`
    FOREIGN KEY (`Book_ID`)
    REFERENCES `db_book_store`.`Book` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
