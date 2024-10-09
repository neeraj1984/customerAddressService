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