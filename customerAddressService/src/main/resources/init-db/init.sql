/*
This file will be used by docker-compose command to create the table and insert the values
*/

CREATE TABLE customer_address (
    id SERIAL NOT NULL PRIMARY KEY ,
    first_name varchar(30),
    last_name varchar(30),
    address1 varchar(255),
	address2 varchar(255),
    city varchar(30),
	state varchar(30),
	zip varchar(10)
);


insert into customer_address (id, first_name, last_name, address1, address2, city, state, zip) values
(1,'Neeraj', 'Joshi', 'PJR Enclave', 'Road Number 7', 'Hyderabad','Telangana', '500050');