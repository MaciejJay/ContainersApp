insert into user (id, user_name, first_name, last_name, e_mail)
values (nextval('user_seq'), 'userName', 'firstName', 'lastName', 'userMail');

commit ;