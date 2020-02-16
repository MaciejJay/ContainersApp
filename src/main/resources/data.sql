insert into user (id, user_name, first_name, last_name, e_mail)
values (nextval('user_seq'), 'userName', 'firstName', 'lastName', 'userMail');

INSERT INTO CONTAINER_SHIPOWNER (id, prefix, short_name, full_name)
VALUES (nextval('Container_shipowner_seq'), 'APMU', 'Maersk', 'Maersk Line');

INSERT INTO CONTAINER_SHIPOWNER (id, prefix, short_name, full_name)
VALUES (nextval('Container_shipowner_seq'), 'PRZY', 'Przydan', 'BigContainers');

INSERT INTO CONTAINER (no_container, container_no_pin, container_type, container_shipowner_id)
VALUES ('APMU7236487', '123456789', '40', 1);

INSERT INTO CONTAINER (no_container, container_no_pin, container_type, container_shipowner_id)
VALUES ('APMU7236423', '987654321', '40', 1);

INSERT INTO CONTAINER_DAMAGE (id, add_date, container_status, description, user_id, container_no_container)
VALUES (nextval('damage_seq'), '2020-02-15', '0', 'podloga w znacznym stopniu zniszczona', 1, 'APMU7236487');

INSERT INTO DAMAGE_TYPE (id, damage_type)
VALUES (nextval('damage_type_seq'), 'HOLE');


commit ;