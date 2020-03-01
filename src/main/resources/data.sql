SET session_replication_role = replica;

insert into USERS (username, first_name, last_name, email, role_id)
values ('wichni', 'Jakub', 'Wichniarek', 'jakubwichniarek@yahoo.pl', 1),
        ('przydan', 'Patryk', 'Przydanek', 'przydan@hotmail.com', 1),
        ('maciej', 'Maciej', 'Jasinski', 'maciejj95@op.pl', 2),
        ('piotrek', 'Piotr', 'Misko', 'miskopiotr@gmail.com', 2);

INSERT INTO ROLE(id, authority)
VALUES (1, 'ADMIN'),
        (2, 'USER');

INSERT INTO CONTAINER_FORM(id, container_no, container_ship_owner, container_type, user_username, add_date, auto_generated_pin)
VALUES (nextval('container_form_seq'), 'MRKU 1234567', 'Maersk', '40DV', 'wichni', '2020-01-14', '123'),
         (nextval('container_form_seq'), 'MSCU 0987654','MSC', '20DV', 'maciej', '2020-01-11', '234'),
         (nextval('container_form_seq'), 'APLU 2340987','APL', '40HC', 'wichni', '2020-01-14', '345'),
         (nextval('container_form_seq'), 'MRKU 9875432','Maersk', '40HC', 'przydan', '2020-01-14', '456'),
         (nextval('container_form_seq'), 'AZLU 1356789','Hapag', '40DV', 'piotrek', '2020-01-04', '678'),
         (nextval('container_form_seq'), 'MSCU 0864213','MSC', '40DV', 'piotrek', '2020-01-04', '567');


INSERT INTO DAMAGE (id, description, image, damage_type_id, side_id, container_form_id)
VALUES (nextval('damage_seq'), 'podloga w znacznym stopniu zniszczona', null, 3, 2, 1),
     (nextval('damage_seq'), 'dziura w dachu', null, 4, 4, 2),
     (nextval('damage_seq'), 'dziura w podlodze', null, 4, 5, 3),
     (nextval('damage_seq'), 'złamany rygiel', null, 2, 8, 4),
     (nextval('damage_seq'), 'dziura na prawym boku', null, 4, 2, 5),
     (nextval('damage_seq'), 'uszkodzony rygiel na prawych drzwiach', null, 8, 1, 6);


INSERT INTO DAMAGE_TYPE(id, damage_type)
VALUES (nextval('damage_type_seq'), 'BENT'),
         (nextval('damage_type_seq'), 'BROKEN'),
         (nextval('damage_type_seq'), 'CRACKED'),
         (nextval('damage_type_seq'), 'HOLE'),
         (nextval('damage_type_seq'), 'MISSING'),
         (nextval('damage_type_seq'), 'BRUISE'),
         (nextval('damage_type_seq'), 'CUT'),
         (nextval('damage_type_seq'), 'DENT'),
         (nextval('damage_type_seq'), 'LOOSE'),
         (nextval('damage_type_seq'), 'RUSTY');

INSERT INTO SIDE(id, side)
VALUES (nextval('side_seq'), 'LEFT'),
        (nextval('side_seq'), 'RIGHT'),
        (nextval('side_seq'), 'DOWN'),
        (nextval('side_seq'), 'UP'),
        (nextval('side_seq'), 'CENTER'),
        (nextval('side_seq'), 'FRONT'),
        (nextval('side_seq'), 'BACK'),
        (nextval('side_seq'), 'DOOR');


SET session_replication_role = DEFAULT;

commit ;