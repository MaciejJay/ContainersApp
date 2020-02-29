INSERT INTO ROLE (id, authority)
VAlUES (nextval('role_seq'), 'ADMIN');

INSERT INTO `USER` (username, first_name, last_name, email, role_id)
VALUES ('username', 'firstName', 'lastName', 'userMail', 1);

INSERT INTO CONTAINER_SHIPOWNER (id, prefix, short_name, full_name)
VALUES (nextval('Container_shipowner_seq'), 'APMU', 'Maersk', 'Maersk Line');

INSERT INTO CONTAINER (no_container, container_type, container_shipowner_id)
VALUES ('123456789', '40', 1);

INSERT INTO CONTAINER_DAMAGE (id, add_date, PIN, container_status, description, user_username, container_no_container)
VALUES (nextval('damage_seq'), '2020-02-15', '123', 'CONTAINER_UNUSABLE', 'podloga w znacznym stopniu zniszczona', 'username', '123456789');

INSERT INTO damage_type_mapping(damage_id, type_enums) VALUES (1, 'BROKEN');
INSERT INTO damage_type_mapping(damage_id, type_enums) VALUES (1, 'BENT');

commit ;