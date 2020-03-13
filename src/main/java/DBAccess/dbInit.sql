-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

DROP SCHEMA IF EXISTS `cupcake`;

CREATE SCHEMA IF NOT EXISTS`cupcake`;
USE `cupcake`;

DROP TABLE IF EXISTS `cupcake`.`ordertails`;
DROP TABLE IF EXISTS `cupcake`.`topping`;
DROP TABLE IF EXISTS `cupcake`.`bottom`;
DROP TABLE IF EXISTS `cupcake`.`users`;

CREATE TABLE `users`(
`name` VARCHAR(55),
`email` VARCHAR(200),
`password` VARCHAR(60),
`balance` INT,

PRIMARY KEY (`email`)
);

CREATE TABLE `bottom`(
`bname` VARCHAR(25),
`bPrice` INT(25),
PRIMARY KEY (`bname`)
);

CREATE TABLE `topping`(
`tname` VARCHAR(25),
`tPrice` INT(25),
PRIMARY KEY (`tname`)
);

-- CREATE TABLE `invoices`(
	-- `email` VARCHAR(45),
    -- `id` INT,
    -- `date` DATETIME NOT NULL DEFAULT current_timestamp,
   --  `total` int,
-- 	FOREIGN KEY (email) REFERENCES Users(email)
-- );

CREATE TABLE `ordertails`(
	`email` VARCHAR(45),
    `tname` VARCHAR(45),
    `bname` VARCHAR(45),
    `qty` int,
    `total` int,
    FOREIGN KEY (email) REFERENCES Users(email)
);



INSERT INTO cupcake.topping VALUES
("orange", 20),
("blue", 25),
("cool", 12);

INSERT INTO cupcake.bottom VALUES
("test", 20),
("noget", 20),
("data", 12);
