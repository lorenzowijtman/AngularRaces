-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema zpalladb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zpalladb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zpalladb` DEFAULT CHARACTER SET utf8 ;
USE `zpalladb` ;

-- -----------------------------------------------------
-- Table `zpalladb`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `group_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `group_id_UNIQUE` (`id` ASC),
  INDEX `fk_Group_Group1_idx` (`group_id` ASC),
  CONSTRAINT `fk_Group_Group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `zpalladb`.`Group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `nick_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Player_in_Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Player_in_Group` (
  `player_id` INT NOT NULL,
  `group_id` INT NOT NULL,
  `score` INT NULL,
  `is_admin` TINYINT NOT NULL,
  `budget` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`player_id`, `group_id`),
  INDEX `fk_Player_has_Group_Group1_idx` (`group_id` ASC),
  INDEX `fk_Player_has_Group_Player_idx` (`player_id` ASC),
  CONSTRAINT `fk_Player_has_Group_Player`
    FOREIGN KEY (`player_id`)
    REFERENCES `zpalladb`.`Player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Player_has_Group_Group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `zpalladb`.`Group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Rules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Rules` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `decription` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Rules_in_Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Rules_in_Group` (
  `Rules_id` INT NOT NULL,
  `Group_id` INT NOT NULL,
  `points` INT NOT NULL,
  PRIMARY KEY (`Rules_id`, `Group_id`),
  INDEX `fk_Rules_has_Group_Group1_idx` (`Group_id` ASC),
  INDEX `fk_Rules_has_Group_Rules1_idx` (`Rules_id` ASC),
  CONSTRAINT `fk_Rules_has_Group_Rules1`
    FOREIGN KEY (`Rules_id`)
    REFERENCES `zpalladb`.`Rules` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rules_has_Group_Group1`
    FOREIGN KEY (`Group_id`)
    REFERENCES `zpalladb`.`Group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Race`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Race` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `date_UNIQUE` (`date` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Race_team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Race_team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Racer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Racer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `salary` DECIMAL(8,2) NOT NULL,
  `Race_team_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Racer_Race_team1_idx` (`Race_team_id` ASC),
  CONSTRAINT `fk_Racer_Race_team1`
    FOREIGN KEY (`Race_team_id`)
    REFERENCES `zpalladb`.`Race_team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Race_result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Race_result` (
  `Races_id` INT NOT NULL,
  `Racer_id` INT NOT NULL,
  `place` INT NOT NULL,
  PRIMARY KEY (`Races_id`, `Racer_id`),
  INDEX `fk_Races_has_Racer_Racer1_idx` (`Racer_id` ASC),
  INDEX `fk_Races_has_Racer_Races1_idx` (`Races_id` ASC),
  CONSTRAINT `fk_Races_has_Racer_Races1`
    FOREIGN KEY (`Races_id`)
    REFERENCES `zpalladb`.`Race` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Races_has_Racer_Racer1`
    FOREIGN KEY (`Racer_id`)
    REFERENCES `zpalladb`.`Racer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Races_results_has_Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Races_results_has_Group` (
  `Races_results_Races_id` INT NOT NULL,
  `Races_results_Racer_id` INT NOT NULL,
  `Group_id` INT NOT NULL,
  PRIMARY KEY (`Races_results_Races_id`, `Races_results_Racer_id`, `Group_id`),
  INDEX `fk_Races_results_has_Group_Group1_idx` (`Group_id` ASC),
  INDEX `fk_Races_results_has_Group_Races_results1_idx` (`Races_results_Races_id` ASC, `Races_results_Racer_id` ASC),
  CONSTRAINT `fk_Races_results_has_Group_Races_results1`
    FOREIGN KEY (`Races_results_Races_id` , `Races_results_Racer_id`)
    REFERENCES `zpalladb`.`Race_result` (`Races_id` , `Racer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Races_results_has_Group_Group1`
    FOREIGN KEY (`Group_id`)
    REFERENCES `zpalladb`.`Group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zpalladb`.`Racer_selection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zpalladb`.`Racer_selection` (
  `Player_in_Group_player_id` INT NOT NULL,
  `Player_in_Group_group_id` INT NOT NULL,
  `Racer_id` INT NOT NULL,
  PRIMARY KEY (`Player_in_Group_player_id`, `Player_in_Group_group_id`, `Racer_id`),
  INDEX `fk_Player_in_Group_has_Racer_Racer1_idx` (`Racer_id` ASC),
  INDEX `fk_Player_in_Group_has_Racer_Player_in_Group1_idx` (`Player_in_Group_player_id` ASC, `Player_in_Group_group_id` ASC),
  CONSTRAINT `fk_Player_in_Group_has_Racer_Player_in_Group1`
    FOREIGN KEY (`Player_in_Group_player_id` , `Player_in_Group_group_id`)
    REFERENCES `zpalladb`.`Player_in_Group` (`player_id` , `group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Player_in_Group_has_Racer_Racer1`
    FOREIGN KEY (`Racer_id`)
    REFERENCES `zpalladb`.`Racer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
