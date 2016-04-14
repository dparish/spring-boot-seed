create table USER (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	birth_date TIMESTAMP
);

INSERT INTO USER (first_name, last_name, birth_date)
    VALUES ('David', 'Parish', parsedatetime('07-25-1969', 'MM-dd-yyyy'))