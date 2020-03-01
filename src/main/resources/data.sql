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
VALUES (nextval('container_form_seq'), 'MRKU 1234567', '40DV', 'wichni', '2020-01-14', '123'),
         (nextval('container_form_seq'), 'MSCU 0987654', '20DV', 'maciej', '2020-01-11', '234'),
         (nextval('container_form_seq'), 'APLU 2340987', '40HC', 'wichni', '2020-01-14', '345'),
         (nextval('container_form_seq'), 'MRKU 9875432', '40HC', 'przydan', '2020-01-14', '456'),
         (nextval('container_form_seq'), 'AZLU 1356789', '40DV', 'piotrek', '2020-01-04', '678'),
         (nextval('container_form_seq'), 'MSCU 0864213', '40DV', 'piotrek', '2020-01-04', '567');


INSERT INTO DAMAGE (id, description, image, damage_type, side, container_form_id)
VALUES (nextval('damage_seq'), 'podloga w znacznym stopniu zniszczona', null, 'CRACKED', 'CENTER', 1),
     (nextval('damage_seq'), 'dziura w dachu', null, 'HOLE', 'UP', 2),
     (nextval('damage_seq'), 'dziura w podlodze', null, 'HOLE', 'DOWN', 3),
     (nextval('damage_seq'), 'złamany rygiel', null, 'BROKEN', 'DOOR', 4),
     (nextval('damage_seq'), 'dziura na prawym boku', null, 'HOLE', 'RIGHT', 5),
     (nextval('damage_seq'), 'uszkodzony rygiel na prawych drzwiach', null, 'DENT', 'DOOR', 6);


SET session_replication_role = DEFAULT;

commit ;