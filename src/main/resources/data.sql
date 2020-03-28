SET session_replication_role = replica;

insert into USERS (username, first_name, last_name, email, role_id)
values ('wichni', 'Jakub', 'Wichniarek', 'jakubwichniarek@yahoo.pl', 1),
        ('przydan', 'Patryk', 'Przydanek', 'przydan@hotmail.com', 1),
        ('maciej', 'Maciej', 'Jasinski', 'maciejj95@op.pl', 2),
        ('piotrek', 'Piotr', 'Misko', 'miskopiotr@gmail.com', 2);

INSERT INTO ROLE(id, authority)
VALUES (nextval('role_seq'), 'ADMIN'),
        (nextval('role_seq'), 'USER');

INSERT INTO CONTAINER(container_id_number, container_type, container_ship_owner)
VALUES ('MRKU 1234567', '40DV', 'Maersk'),
        ('MSCU 0987654', '20DV', 'MSC'),
        ('APLU 2340987', '40HC', 'APL'),
        ('MRKU 9875432', '40HC', 'Maersk'),
        ('AZLU 1356789', '40DV', 'Hapag'),
        ('MSCU 0864213', '40DV', 'MSC');

INSERT INTO CONTAINER_RAPORT(id, container_container_id_number, user_username, add_date, container_no_pin)
VALUES (nextval('container_raport_seq'), 'MRKU 1234567', 'wichni', '2020-01-14', '123'),
         (nextval('container_raport_seq'), 'MSCU 0987654', 'maciej', '2020-01-11', '234'),
         (nextval('container_raport_seq'), 'APLU 2340987', 'wichni', '2020-01-14', '345'),
         (nextval('container_raport_seq'), 'MRKU 9875432', 'przydan', '2020-01-14', '456'),
         (nextval('container_raport_seq'), 'MRKU 9875432', 'przydan', '2020-01-14', '678'),
         (nextval('container_raport_seq'), 'MRKU 9875432', 'przydan', '2020-01-14', '543'),
         (nextval('container_raport_seq'), 'AZLU 1356789', 'piotrek', '2020-01-04', '321'),
         (nextval('container_raport_seq'), 'MSCU 0864213', 'piotrek', '2020-01-04', '120');


INSERT INTO DAMAGE (id, description, image, damage_type, side, container_raport_id)
VALUES (nextval('damage_seq'), 'podloga w znacznym stopniu zniszczona', null, 'CRACKED', 'CENTER', 1),
     (nextval('damage_seq'), 'dziura w dachu', null, 'HOLE', 'UP', 2),
     (nextval('damage_seq'), 'dziura w podlodze', null, 'HOLE', 'DOWN', 3),
     (nextval('damage_seq'), 'złamany rygiel', null, 'BROKEN', 'DOOR', 4),
     (nextval('damage_seq'), 'dziura na prawym boku', null, 'HOLE', 'RIGHT', 5),
     (nextval('damage_seq'), 'uszkodzony rygiel na prawych drzwiach', null, 'DENT', 'DOOR', 6);


SET session_replication_role = DEFAULT;

commit ;