INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}user'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Masha', 'masha@gmail.com', '{noop}masha'),
       ('Dasha', 'dasha@gmail.com', '{noop}dasha'),
       ('Sasha', 'sasha@gmail.com', '{noop}sasha'),
       ('Pasha', 'pasha@gmail.com', '{noop}pasha');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2),
       ('USER', 3),
       ('USER', 4),
       ('USER', 5),
       ('USER', 6);

INSERT INTO VOTES (USER_ID, RESTAURANT_ID, VOTE_DATE)
VALUES (2, 100, '2020-02-01'),
       (3, 300, '2020-02-01'),
       (4, 100, '2020-02-01'),
       (5, 200, '2020-02-01'),
       (6, 100, '2020-02-01'),
       (2, 100, now()),
       (3, 300, now()),
       (4, 100, now()),
       (5, 200, now()),
       (6, 100, now());

INSERT INTO RESTAURANTS (NAME, LUNCH_DATE)
VALUES ('GRUZINSKIY', now()),
       ('RUSSKIY', now()),
       ('ARMANSKIY', now());

INSERT INTO MEALS (NAME, PRICE, RESTAURANT_ID)
VALUES ('BLINCHIK', 75, 1),
       ('SELEDKA', 100, 1),
       ('KASHA', 55, 2),
       ('UTKA', 150, 2),
       ('KOMPOT', 20, 3),
       ('BANAN', 4, 3);