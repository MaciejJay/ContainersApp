insert into user (username, first_name, last_name, email)
values ('username', 'firstName', 'lastName', 'userMail');

INSERT INTO CONTAINER_SHIPOWNER (id, prefix, short_name, full_name)
VALUES (nextval('Container_shipowner_seq'), 'APMU', 'Maersk', 'Maersk Line');

INSERT INTO CONTAINER_SHIPOWNER (id, prefix, short_name, full_name)
VALUES (nextval('Container_shipowner_seq'), 'PRZY', 'Przydan', 'BigContainers');

INSERT INTO CONTAINER (no_container, prefix, container_no_pin, container_type, container_shipowner_id)
VALUES ('236487', 'APMU', '123456789', '40', 1);

INSERT INTO CONTAINER_DAMAGE (id, add_date, container_status, description, user_username, container_no_container)
VALUES (nextval('damage_seq'), '2020-02-15', '0', 'podloga w znacznym stopniu zniszczona', 'username' , '236487');

INSERT INTO DAMAGE_TYPE (id, damage_type)
VALUES (nextval('damage_type_seq'), 'HOLE');


commit ;