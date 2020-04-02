INSERT INTO ROLE(id, authority)
VALUES (1, 'ADMIN'),
       (2, 'USER');

insert into USERS (username, first_name, last_name, email, password, role_id, was_released)
values ('wichni', 'Jakub', 'Wichniarek', 'wichniarekjakub89@gmail.com', '123456', 1, false ),
       ('przydan', 'Patryk', 'Przydanek', 'przydan@hotmail.com','123456', 1, false ),
       ('maciej', 'Maciej', 'Jasinski', 'maciejj95@op.pl','123456', 2, false ),
       ('piotrek', 'Piotr', 'Misko', 'miskopiotr@gmail.com','123456', 2, false ),
       ('test', 'test', 'test', 'testowykontenerowy@gmail.com','kontenery', 1, false );



commit ;