CREATE DATABASE zeroj;
USE zeroj;
CREATE TABLE: CREATE TABLE `customer` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) DEFAULT NULL,
  `contact` VARCHAR(256) DEFAULT NULL,
  `telephone` VARCHAR(256) DEFAULT NULL,
  `email` VARCHAR(256) DEFAULT NULL,
  `remark` TEXT,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

	
INSERT INTO customer(`name`, contact, telephone, email, remark) VALUES
		("customer1", "Jack", 10086, "jack@gmail.com"),
		("customer2", "Rose", 10010, "rose@gmail.com");
		
SHOW CREATE TABLE customer;