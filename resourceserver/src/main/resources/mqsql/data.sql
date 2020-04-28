create database userservice;
use userservice;

create table permission (id int primary key auto_increment, permission_name varchar(50) unique key not null);

create table invoices (id int primary key auto_increment, user_id int, foreign key(user_id) references users(id), invoice_number int(15), date_of_invoice varchar(50), description varchar(200), amount varchar(100), status varchar(50));

create table role (id int primary key auto_increment, role_name varchar(50) unique key not null);

create table role_permission(id int primary key auto_increment, role_id int, foreign key(role_id) 
references role(id),permission_id int, foreign key(permission_id) references permission(id));

desc permission;


create table users (id int primary key auto_increment, first_name varchar(50) not null, last_name varchar(50),
email_id varchar(50) not null, password varchar(1000), mobile varchar(20), country varchar(50), 
user_type varchar(20));

create table role_users (id int primary key auto_increment, role_id int, foreign key(role_id) references role(id),
user_id int, foreign key(user_id) references users(id));

insert into permission (permission_name) values ('view_permission');

insert into permission (permission_name) values ('create_role');
insert into permission (permission_name) values ('edit_role');
insert into permission (permission_name) values ('view_role');
insert into permission (permission_name) values ('delete_role');

insert into permission (permission_name) values ('assign_permissions_to_role');
insert into permission (permission_name) values ('view_permissions_by_role');

insert into permission (permission_name) values ('create_users');
insert into permission (permission_name) values ('edit_users');
insert into permission (permission_name) values ('view_users');
insert into permission (permission_name) values ('delete_users');

insert into permission (permission_name) values ('assign_users_to_role');
insert into permission (permission_name) values ('view_users_by_role');

insert into role (role_name) values ('Administrator');

insert into role_permission (role_id, permission_id) values (1,1); 
insert into role_permission (role_id, permission_id) values (1,2); 
insert into role_permission (role_id, permission_id) values (1,3); 
insert into role_permission (role_id, permission_id) values (1,4); 


insert into role_permission (role_id, permission_id) values (1,5); 
insert into role_permission (role_id, permission_id) values (1,6); 
insert into role_permission (role_id, permission_id) values (1,7); 
insert into role_permission (role_id, permission_id) values (1,8); 

insert into role_permission (role_id, permission_id) values (1,9); 
insert into role_permission (role_id, permission_id) values (1,10); 
insert into role_permission (role_id, permission_id) values (1,11); 
insert into role_permission (role_id, permission_id) values (1,12); 

insert into role_permission (role_id, permission_id) values (1,13); 

select * from role_permission; 

insert into users (first_name, last_name, email_id, password, mobile, country, user_type) values 
('Prvi', 'Prvic', 'prvi@gmail.com','$2y$12$U9VFvF/e4XtvXv8qQn7GmOOlAOnXAb0Al.qTOvbI3Gi0yMyiqaYNW',
'+48980293842','SRB', 'super_admin');

insert into users (first_name, last_name, email_id, password, mobile, country, user_type) values 
('Drugi', 'Drugic', 'drugi@gmail.com','$2y$12$U9VFvF/e4XtvXv8qQn7GmOOlAOnXAb0Al.qTOvbI3Gi0yMyiqaYNW','+48980293842','SRB','admin');

select * from role_users;

insert into role_users (role_id,user_id) values (1,2);

select * from users where email_id='prvi@gmail.com';
select * from users where email_id='drugi@gmail.com';

select p.permission_name from users u
inner join role_users r_u on u.id=r_u.user_id
inner join role r on r_u.role_id=r.id
inner join role_permission r_p on r_p.role_id=r.id
inner join permission p on p.id=r_p.permission_id where u.email_id='drugi@gmail.com';

update users set password='$2a$10$eUB5vV/xWXrcR61TqcWRXOCfl37r3fk.UXNXEzx7xTol5inz5xZ.2';

select * from users;

select * from role;

update users 
set first_name='Bojan', last_name='Martinovic', email_id='bojan@tana.com', mobile='48980293842', country='SRB'
where id=1;

update users 
set first_name='Majkan', last_name='Majkic', email_id='majkan@tana.com', mobile='48980293842', country='SRB'
where id=2;