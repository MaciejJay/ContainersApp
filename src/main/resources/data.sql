insert into user (id, user_name, first_name, last_name, e_mail)
values (nextval('user_seq'), 'userName', 'firstName', 'lastName', 'userMail');

INSERT INTO CONTAINER_SHIPOWNER (id, prefix, short_name, full_name)
VALUES (nextval('Container_shipowner_seq'), 'APMU', 'Maersk', 'Maersk Line');

INSERT INTO CONTAINER (id, no_container, container_no_pin, container_type, container_shipowner_id)
VALUES (nextval('container_seq'), '0923850WER', '123456789', '40', 1);

INSERT INTO CONTAINER_DAMAGE (id, add_date, container_status, description, user_id, container_id)
VALUES (nextval('damage_seq'), '2020-02-15', '2345', 'podloga w znacznym stopniu zniszczona', 1, 1);

INSERT INTO DAMAGE_TYPE (id, damage_type)
VALUES (nextval('damage_type_seq'), 'HOLE');


commit ;