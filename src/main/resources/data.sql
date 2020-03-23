SET session_replication_role = replica;

insert into USERS (username, first_name, last_name, email, password, role_id, was_released)
values ('wichni', 'Jakub', 'Wichniarek', 'wichniarekjakub89@gmail.com', '123456', 1, false ),
        ('przydan', 'Patryk', 'Przydanek', 'przydan@hotmail.com','123456', 1, false ),
        ('maciej', 'Maciej', 'Jasinski', 'maciejj95@op.pl','123456', 2, false ),
        ('piotrek', 'Piotr', 'Misko', 'miskopiotr@gmail.com','123456', 2, false ),
        ('test', 'test', 'test', 'testowykontenerowy@gmail.com','kontenery', 1, false );

INSERT INTO ROLE(id, authority)
VALUES (nextval('role_seq'), 'ADMIN'),
        (nextval('role_seq'), 'USER');

INSERT INTO CONTAINER(container_id_number, container_type, container_ship_owner, container_no_pin)
VALUES ('MRKU 1234567', '40DV', 'Maersk', '123'),
        ('MSCU 0987654', '20DV', 'MSC', '234'),
        ('APLU 2340987', '40HC', 'APL', '345'),
        ('MRKU 9875432', '40HC', 'Maersk', '456'),
        ('AZLU 1356789', '40DV', 'Hapag', '678'),
        ('MSCU 0864213', '40DV', 'MSC', '567');

INSERT INTO CONTAINER_FORM(id, container_container_id_number, user_username, add_date)
VALUES (nextval('container_form_seq'), 'MRKU 1234567', 'wichni', '2020-01-14'),
         (nextval('container_form_seq'), 'MSCU 0987654', 'maciej', '2020-01-11'),
         (nextval('container_form_seq'), 'APLU 2340987', 'wichni', '2020-01-14'),
         (nextval('container_form_seq'), 'MRKU 9875432', 'przydan', '2020-01-14'),
         (nextval('container_form_seq'), 'AZLU 1356789', 'piotrek', '2020-01-04'),
         (nextval('container_form_seq'), 'MSCU 0864213', 'piotrek', '2020-01-04');


INSERT INTO DAMAGE (id, description, image, damage_type, side, container_form_id)
VALUES (nextval('damage_seq'), 'podloga w znacznym stopniu zniszczona', null, 'CRACKED', 'CENTER', 1),
     (nextval('damage_seq'), 'dziura w dachu', null, 'HOLE', 'UP', 2),
     (nextval('damage_seq'), 'dziura w podlodze', null, 'HOLE', 'DOWN', 3),
     (nextval('damage_seq'), 'złamany rygiel', null, 'BROKEN', 'DOOR', 4),
     (nextval('damage_seq'), 'dziura na prawym boku', null, 'HOLE', 'RIGHT', 5),
     (nextval('damage_seq'), 'uszkodzony rygiel na prawych drzwiach', null, 'DENT', 'DOOR', 6);


SET session_replication_role = DEFAULT;

commit ;