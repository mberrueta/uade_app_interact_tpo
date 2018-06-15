CREATE DATABASE IF NOT EXISTS app_interact_tpo

DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS gift_list;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS subscription;


 CREATE TABLE IF NOT EXISTS user (
   id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(40) NOT NULL,
   email VARCHAR(40) NOT NULL,
   password VARCHAR(250) NOT NULL,
   birth_date DATE DEFAULT null;
 );

CREATE TABLE IF NOT EXISTS gift_list (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  list_name VARCHAR(40) NOT NULL,
  due_date DATE NOT NULL,
  to_name VARCHAR(40) NOT NULL,
  to_mail VARCHAR(40) NOT NULL,
  owner_id INT(8) NOT NULL, 
  expected_amount FLOAT NOT NULL DEFAULT 0,
  current_amount FLOAT NOT NULL DEFAULT 0,
  delivered BIT NOT NULL DEFAULT 0,
  FOREIGN KEY (owner_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS subscription (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT(8) NOT NULL,
  payment_id int(8)  DEFAULT NULL,
  active smallint NOT NULL DEFAULT 1,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (payment_id) REFERENCES payment(id)
);


CREATE TABLE IF NOT EXISTS payment (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  amount FLOAT(8,2) NOT NULL DEFAULT 0,
  subscription_id INT(8) NOT NULL,
  date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (subscription_id) REFERENCES subscription(id))
  ;


CREATE TABLE IF NOT EXISTS gift_list_subscription (
  gift_list_id INT(8) NOT NULL,
  subscription_id INT(8) NOT NULL,
  PRIMARY KEY (gift_list_id,  subscription_id),
  FOREIGN KEY (gift_list_id) REFERENCES gift_list(id),
  FOREIGN KEY (subscription_id) REFERENCES subscription(id)
);

