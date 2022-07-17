use address_db;
CREATE TABLE customer_address (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(30),
    last_name varchar(30),
    address1 varchar(255),
	address2 varchar(255),
    city varchar(30),
	state varchar(30),
	zip varchar(10),
	PRIMARY KEY (id)
);