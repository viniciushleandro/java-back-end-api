create schema if not exists users;

create table users.user (
    id bigserial primary key,
    name varchar(100) not null,
    cpf varchar(100) not null,
    address varchar(100) not null,
    email varchar(100) not null,
    telephone varchar(100) not null,
    date_register timestamp not null
);