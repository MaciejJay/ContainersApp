SET session_replication_role = replica;

insert into USERS (username, first_name, last_name, email, role_id)
values ('wichni', 'Jakub', 'Wichniarek', 'jakubwichniarek@yahoo.pl', 1),
        ('przydan', 'Patryk', 'Przydanek', 'przydan@hotmail.com', 1),
        ('maciej', 'Maciej', 'Jasinski', 'maciejj95@op.pl', 2),
        ('piotrek', 'Piotr', 'Misko', 'miskopiotr@gmail.com', 2);

INSERT INTO ROLE(id, authority)
VALUES (nextval('role_seq'), 'ADMIN'),
        (nextval('role_seq'), 'USER');

INSERT INTO CONTAINER_REPORT(id, container_no, container_type)

-- INSERT INTO CONTAINER_SHIPOWNER (id, short_name, full_name)
-- VALUES (nextval('Container_shipowner_seq'), 'Maersk', 'Maersk Line'),
--        (nextval('Container_shipowner_seq'), 'MSC', 'Mediterranean Shipping Company'),
--        (nextval('Container_shipowner_seq'), 'APL', 'American President Lines'),
--        (nextval('Container_shipowner_seq'), 'Hapag', 'Hapag Lloyd Container Line'),
--        (nextval('Container_shipowner_seq'), 'CMA CMG', 'Compagnie Maritime d Affretement Compagnie Generale Maritime');
-- INSERT INTO CONTAINER (no_container, container_no_pin, container_type, container_shipowner_id)
-- VALUES ('MRKU 1234567', '123', '40DV', 1),
--          ('MSCU 0987654', '234', '20DV', 2),
--          ('APLU 2340987', '345', '40HC', 3),
--          ('MRKU 9875432', '987', '40HC', 1),
--          ('AZLU 1356789', '997', '40DV', 4),
--          ('MSCU 0864213', '765', '20DV', 2);

INSERT INTO DAMAGE (id, description, image, damage_type_id, side_id)
VALUES (nextval('damage_seq'), 'podloga w znacznym stopniu zniszczona', null, 3, 2),
     (nextval('damage_seq'), 'dziura w dachu', null, 4, 4),
     (nextval('damage_seq'), 'dziura w podlodze', null, 4, 5),
     (nextval('damage_seq'), 'złamany rygiel', null, 2, 8),
     (nextval('damage_seq'), 'dziura na prawym boku', null, 4, 2),
     (nextval('damage_seq'), 'uszkodzony rygiel na prawych drzwiach', null, 8, 1);

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