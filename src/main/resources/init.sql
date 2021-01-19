CREATE TABLE addresses (
   id serial primary key,
   first_name varchar(100) not null,
   last_name varchar(100) not null,
   email_address varchar(100) unique not null,
   date_of_birth date not null,
   street varchar(100) not null,
   postal_code int not null,
   country varchar(100) not null
);
