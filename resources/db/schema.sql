DROP TABLE gifts;
DROP TABLE payments;
DROP TABLE gift_lists;
DROP TABLE products;
DROP TABLE people;
DROP TABLE users;
DROP TABLE product_categories;

CREATE TABLE IF NOT EXISTS product_categories (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40) NOT NULL,
  description VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS users (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40) NOT NULL,
  encrypted_pass VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS people (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(40) NOT NULL,
  last_name VARCHAR(40) NOT NULL,
  email VARCHAR(40) NOT NULL,
  phone VARCHAR(40) NOT NULL,
  address VARCHAR(200) NOT NULL,
  user_id INT(8) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE IF NOT EXISTS products (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40) NOT NULL,
  product_category_id INT(8) NOT NULL,
  value FLOAT(8,2) NOT NULL DEFAULT 0,
  description VARCHAR(255),
  image_path VARCHAR(100),
  FOREIGN KEY (product_category_id) REFERENCES product_categories(id)
);


CREATE TABLE IF NOT EXISTS gift_lists (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  list_name VARCHAR(40) NOT NULL,
  due_date DATE NOT NULL,
  to_person_id INT(8) NOT NULL,
  FOREIGN KEY (to_person_id) REFERENCES people(id)
);


CREATE TABLE IF NOT EXISTS payments (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  amount FLOAT(8,2) NOT NULL DEFAULT 0,
  product_id INT(8) NOT NULL,
  person_id INT(8) NOT NULL,
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (person_id) REFERENCES people(id)
);


CREATE TABLE IF NOT EXISTS gifts (
  id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  percent FLOAT(8,2) NOT NULL DEFAULT 0,
  product_id INT(8) NOT NULL,
  from_person_id INT(8) NOT NULL,
  gift_list_id INT(8) NOT NULL,
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (from_person_id) REFERENCES people(id),
  FOREIGN KEY (gift_list_id) REFERENCES gift_lists(id)
);
