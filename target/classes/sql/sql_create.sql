-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ssafytrip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafytrip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ssafytrip` ;

-- -----------------------------------------------------
-- Table `ssafytrip`.`sidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`sidos` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `sido_code` INT NULL DEFAULT NULL,
  `sido_name` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  UNIQUE INDEX `sido_code_UNIQUE` (`sido_code` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`guguns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`guguns` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `gugun_name` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `guguns_sido_to_sidos_cdoe_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `gugun_code_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `guguns_sido_to_sidos_cdoe_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `ssafytrip`.`sidos` (`sido_code`))
ENGINE = InnoDB
AUTO_INCREMENT = 235
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`contenttypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`contenttypes` (
  `content_type_id` INT NOT NULL,
  `content_type_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_type_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`attractions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`attractions` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `content_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(500) NULL DEFAULT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `area_code` INT NULL DEFAULT NULL,
  `si_gun_gu_code` INT NULL DEFAULT NULL,
  `first_image1` VARCHAR(100) NULL DEFAULT NULL,
  `first_image2` VARCHAR(100) NULL DEFAULT NULL,
  `map_level` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `tel` VARCHAR(20) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(100) NULL DEFAULT NULL,
  `homepage` VARCHAR(1000) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `attractions_typeid_to_types_typeid_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attractions_sido_to_sidos_code_fk_idx` (`area_code` ASC) VISIBLE,
  INDEX `attractions_sigungu_to_guguns_gugun_fk_idx` (`si_gun_gu_code` ASC) VISIBLE,
  CONSTRAINT `attractions_area_to_sidos_code_fk`
    FOREIGN KEY (`area_code`)
    REFERENCES `ssafytrip`.`sidos` (`sido_code`),
  CONSTRAINT `attractions_sigungu_to_guguns_gugun_fk`
    FOREIGN KEY (`si_gun_gu_code`)
    REFERENCES `ssafytrip`.`guguns` (`gugun_code`),
  CONSTRAINT `attractions_typeid_to_types_typeid_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `ssafytrip`.`contenttypes` (`content_type_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 56644
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gender` INT NOT NULL,
  `age` INT NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`board` (
  `board_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL,
  `content` VARCHAR(200) NOT NULL,
  `author` VARCHAR(16) NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` INT NOT NULL,
  `hit` INT default 0,
  `type` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`board_id`),
  INDEX `fk_board_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_board_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`b_bookmark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`board_bookmark` (
  `board_bookmark_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `board_id` INT NOT NULL,
  PRIMARY KEY (`board_bookmark_id`),
  INDEX `fk_board_bookmark_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_board_bookmark_board1_idx` (`board_id` ASC) VISIBLE,
  CONSTRAINT `fk_board_bookmark_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `ssafytrip`.`board` (`board_id`),
  CONSTRAINT `fk_board_bookmark_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`board_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`board_comment` (
  `board_comment_id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NULL DEFAULT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `board_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`board_comment_id`),
  INDEX `fk_board_comment_board1_idx` (`board_id` ASC) VISIBLE,
  INDEX `fk_board_comment_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_board_comment_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `ssafytrip`.`board` (`board_id`),
  CONSTRAINT `fk_board_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`tourplan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`tour_plan` (
  `tour_plan_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `plan_title` VARCHAR(10) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `hit` INT default 0,
  PRIMARY KEY (`tour_plan_id`),
  INDEX `fk_tour_plan_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_tour_plan_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`plan_attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`plan_attraction` (
  `plan_attraction_id` INT NOT NULL AUTO_INCREMENT,
  `attractions_no` INT NOT NULL,
  `tour_plan_id` INT NOT NULL,
  `sequence` INT NOT NULL,
  PRIMARY KEY (`plan_attraction_id`),
  INDEX `fk_plan_attraction_attractions1_idx` (`attractions_no` ASC) VISIBLE,
  INDEX `fk_plan_attraction_tour_plan1_idx` (`tour_plan_id` ASC) VISIBLE,
  CONSTRAINT `fk_plan_attraction_attractions1`
    FOREIGN KEY (`attractions_no`)
    REFERENCES `ssafytrip`.`attractions` (`no`),
  CONSTRAINT `fk_plan_attraction_tour_plan1`
    FOREIGN KEY (`tour_plan_id`)
    REFERENCES `ssafytrip`.`tour_plan` (`tour_plan_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`t_bookmark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`plan_bookmark` (
  `plan_bookmark_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `tour_plan_id` INT NOT NULL,
  PRIMARY KEY (`plan_bookmark_id`),
  INDEX `fk_plan_bookmark_copy1_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_plan_bookmark_copy1_tour_plan1_idx` (`tour_plan_id` ASC) VISIBLE,
  CONSTRAINT `fk_plan_bookmark_copy1_tour_plan1`
    FOREIGN KEY (`tour_plan_id`)
    REFERENCES `ssafytrip`.`tourplan` (`tour_plan_id`),
  CONSTRAINT `fk_plan_bookmark_copy1_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafytrip`.`t_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`plan_comment` (
  `plan_comment_id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NULL DEFAULT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `tour_plan_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`plan_comment_id`),
  INDEX `fk_plan_comment_tour_plan1_idx` (`tour_plan_id` ASC) VISIBLE,
  INDEX `fk_plan_comment_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_plan_comment_tour_plan1`
    FOREIGN KEY (`tour_plan_id`)
    REFERENCES `ssafytrip`.`tour_plan` (`tour_plan_id`),
  CONSTRAINT `fk_plan_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
