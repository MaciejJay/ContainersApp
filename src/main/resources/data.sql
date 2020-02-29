SET session_replication_role = replica;

insert into USERS (username, first_name, last_name, email, role_id)
values ('wichni', 'Jakub', 'Wichniarek', 'jakubwichniarek@yahoo.pl', 1),
        ('przydan', 'Patryk', 'Przydanek', 'przydan@hotmail.com', 1),
        ('maciej', 'Maciej', 'Jasinski', 'maciejj95@op.pl', 2),
        ('piotrek', 'Piotr', 'Misko', 'miskopiotr@gmail.com', 2);

INSERT INTO ROLE(id, authority)
VALUES (nextval('role_seq'), 'ADMIN'),
        (nextval('role_seq'), 'USER');

INSERT INTO CONTAINER_FORM(id, container_no, container_type, user_username, add_date, auto_generated_pin)
VALUES (nextvalue('container_report_seq'), 'MRKU 1234567', '40DV', 'wichni', '2020-01-14', '123'),
         (nextvalue('container_report_seq'), 'MSCU 0987654', '20DV', 'maciej', '2020-01-11', '234'),
         (nextvalue('container_report_seq'), 'APLU 2340987', '40HC', 'wichni', '2020-01-14', '345'),
         (nextvalue('container_report_seq'), 'MRKU 9875432', '40HC', 'przydan', '2020-01-14', '456'),
         (nextvalue('container_report_seq'), 'AZLU 1356789', '40DV', 'piotrek', '2020-01-04', '678'),
         (nextvalue('container_report_seq'), 'MSCU 0864213', '40DV', 'piotrek', '2020-01-04', '567');


INSERT INTO DAMAGE (id, description, image, damage_type_id, side_id, container_form_id)
VALUES (nextval('damage_seq'), 'podloga w znacznym stopniu zniszczona', null, 3, 2, 1),
     (nextval('damage_seq'), 'dziura w dachu', null, 4, 4, 2),
     (nextval('damage_seq'), 'dziura w podlodze', null, 4, 5, 3),
     (nextval('damage_seq'), 'złamany rygiel', null, 2, 8, 4),
     (nextval('damage_seq'), 'dziura na prawym boku', null, 4, 2, 5),
     (nextval('damage_seq'), 'uszkodzony rygiel na prawych drzwiach', null, 8, 1, 6);


INSERT INTO DAMAGE_TYPE(id, type_enums)
VALUES (1, 'BENT'),
         (2, 'BROKEN'),
         (3, 'CRACKED'),
         (4, 'HOLE'),
         (5, 'MISSING'),
         (6, 'BRUISE'),
         (7, 'CUT'),
         (8, 'DENT'),
         (9, 'LOOSE'),
         (10, 'RUSTY');

INSERT INTO SIDE(id, side_enums)
VALUES (1, 'LEFI'),
        (2, 'RIGHT'),
        (3, 'DOWN'),
        (4, 'UP'),
        (5, 'CENTER'),
        (6, 'FRONT'),
        (7, 'BACK'),
        (8, 'DOOR');


SET session_replication_role = DEFAULT;

commit ;