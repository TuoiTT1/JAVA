-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema book_store
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema book_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `book_store` DEFAULT CHARACTER SET utf8 ;
USE `book_store` ;

-- -----------------------------------------------------
-- Table `book_store`.`PUBLISHER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`PUBLISHER` ;

CREATE TABLE IF NOT EXISTS `book_store`.`PUBLISHER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `PublisherName` VARCHAR(100) NOT NULL,
  `URL` VARCHAR(100) NULL,
  `PublisherAddress` VARCHAR(100) NULL,
  `PublisherPhone` VARCHAR(10) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_store`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`Role` ;

CREATE TABLE IF NOT EXISTS `book_store`.`Role` (
  `ID` INT NOT NULL,
  `RoleName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_store`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`User` ;

CREATE TABLE IF NOT EXISTS `book_store`.`User` (
  `ID` INT NOT NULL,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Role_ID` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_store`.`CUSTOMER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`CUSTOMER` ;

CREATE TABLE IF NOT EXISTS `book_store`.`CUSTOMER` (
  `ID` INT NOT NULL,
  `CustomerEmail` VARCHAR(100) NOT NULL,
  `CustomerName` VARCHAR(50) NOT NULL,
  `CustomerPhone` INT NULL,
  `CustomerAddress` VARCHAR(100) NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `User_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `CustomerEmail_UNIQUE` ON `book_store`.`CUSTOMER` (`CustomerEmail` ASC);


-- -----------------------------------------------------
-- Table `book_store`.`WAREHOUSE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`WAREHOUSE` ;

CREATE TABLE IF NOT EXISTS `book_store`.`WAREHOUSE` (
  `ID` INT NOT NULL,
  `WarehouseName` VARCHAR(100) NOT NULL,
  `WarehousePhone` VARCHAR(10) NULL,
  `WarehouseAddress` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_store`.`AUTHOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`AUTHOR` ;

CREATE TABLE IF NOT EXISTS `book_store`.`AUTHOR` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `AuthorName` VARCHAR(45) NOT NULL,
  `AuthorAddress` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_store`.`BOOK`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`BOOK` ;

CREATE TABLE IF NOT EXISTS `book_store`.`BOOK` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Year` INT NULL,
  `Title` VARCHAR(100) NOT NULL,
  `Price` FLOAT NULL,
  `PublisherId` INT NOT NULL,
  `AuthorId` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_store`.`SHOOPING_BASKETS_BOOKS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`SHOOPING_BASKETS_BOOKS` ;

CREATE TABLE IF NOT EXISTS `book_store`.`SHOOPING_BASKETS_BOOKS` (
  `ID` INT NOT NULL,
  `Count` INT NOT NULL,
  `BOOK_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_store`.`WAREHOUSES_BOOKS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_store`.`WAREHOUSES_BOOKS` ;

CREATE TABLE IF NOT EXISTS `book_store`.`WAREHOUSES_BOOKS` (
  `ID` INT NOT NULL,
  `count` INT NOT NULL,
  `WAREHOUSE_ID` INT NOT NULL,
  `BOOK_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
