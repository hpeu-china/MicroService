--创建product表
CREATE TABLE IF NOT EXISTS `product`(
   `id` INT,
   `name` VARCHAR(20),
   `price` DECIMAL(10,2),
   `desc` VARCHAR(20),
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--创建account表
CREATE TABLE IF NOT EXISTS `account`(
   `name` VARCHAR(20),
   `password` VARCHAR(20) NOT NULL,
   PRIMARY KEY ( `name` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
