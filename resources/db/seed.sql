DELETE from payments;
DELETE from gift_lists;
DELETE from users;

INSERT INTO users (id, name, email, password) VALUES (1, 'marian', 'mariano.grimaux@gmail.com', '1234');
INSERT INTO users (id, name, email, password) VALUES (2, 'matt', 'matiasberrueta@gmail.com', '1234');
INSERT INTO users (id, name, email, password) VALUES (3, 'dummy1', 'dm@gmail.com', '1234');
INSERT INTO users (id, name, email, password) VALUES (4, 'dummy2', 'dm2@gmail.com', '1234');

INSERT INTO gift_lists (id, list_name, due_date, to_name, to_mail, owner_id) VALUES (1, 'pp gift',   '20181231', 'pp', 'pp@hotmail.com', 1);
INSERT INTO gift_lists (id, list_name, due_date, to_name, to_mail, owner_id) VALUES (2, 'moni gift', '20181231', 'moni', 'moni@hotmail.com', 2);

INSERT INTO payments (id, amount, payer_id, gift_list_id) VALUES (1, 12.21, 1, 1);
INSERT INTO payments (id, amount, payer_id, gift_list_id) VALUES (2, 22.15, 2, 1);
INSERT INTO payments (amount, payer_id, gift_list_id) VALUES (32.21, 3, 1);
INSERT INTO payments (amount, payer_id, gift_list_id) VALUES (44.42, 4, 1);
INSERT INTO payments (amount, payer_id, gift_list_id) VALUES (12.26, 1, 2);
INSERT INTO payments (amount, payer_id, gift_list_id) VALUES (21.25, 2, 2);
INSERT INTO payments (amount, payer_id, gift_list_id) VALUES (43.24, 2, 2);
INSERT INTO payments (amount, payer_id, gift_list_id) VALUES (11.23, 1, 2);
