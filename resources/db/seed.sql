USE app_interact_tpo;

DELETE from payment;
DELETE from gift_list;
DELETE from user;

INSERT INTO user (id, name, email, password) VALUES (1, 'marian', 'mariano.grimaux@gmail.com', '1234');
INSERT INTO user (id, name, email, password) VALUES (2, 'matt', 'matiasberrueta@gmail.com', '1234');
INSERT INTO user (id, name, email, password) VALUES (3, 'dummy1', 'dm@gmail.com', '1234');
INSERT INTO user (id, name, email, password) VALUES (4, 'dummy2', 'dm2@gmail.com', '1234');

INSERT INTO gift_list (id, list_name, due_date, to_name, to_mail, owner_id) VALUES (1, 'pp gift',   '20181231', 'pp', 'pp@hotmail.com', 1);
INSERT INTO gift_list (id, list_name, due_date, to_name, to_mail, owner_id) VALUES (2, 'moni gift', '20181231', 'moni', 'moni@hotmail.com', 2);

INSERT INTO payment (id, amount, date) VALUES (1, 12.21,'20180701');
INSERT INTO payment (id, amount, date) VALUES (2, 22.15,'20180701');
INSERT INTO payment (amount, date) VALUES (32.21,'20180701');
INSERT INTO payment (amount, date) VALUES (44.42,'20180701');
INSERT INTO payment (amount, date) VALUES (12.26,'20180701');
INSERT INTO payment (amount, date) VALUES (21.25,'20180701');
INSERT INTO payment (amount, date) VALUES (43.24,'20180701');
INSERT INTO payment (amount, date) VALUES (11.23,'20180701');
