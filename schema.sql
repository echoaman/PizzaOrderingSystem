DROP DATABASE IF EXISTS test;

CREATE DATABASE test;
USE test;

CREATE TABLE users (
	uid INT NOT NULL AUTO_INCREMENT,
    uname VARCHAR(20) UNIQUE NOT NULL,
    pwd VARCHAR(20) NOT NULL,
    PRIMARY KEY (uid)
);


CREATE TABLE pizza (
	pid INT NOT NULL AUTO_INCREMENT,
    pname VARCHAR(20) NOT NULL,
    cost INT NOT NULL,
    PRIMARY KEY (pid)
);

CREATE TABLE order_master (
	oid INT NOT NULL AUTO_INCREMENT,
    uid INT NOT NULL,
    order_time DATETIME DEFAULT now(),
    total INT NOT NULL,
    order_status BIT(1) DEFAULT 0,
    PRIMARY KEY (oid),
    FOREIGN KEY (uid) REFERENCES users(uid)
);

CREATE TABLE order_slave (
	oid INT NOT NULL AUTO_INCREMENT,
    uid INT NOT NULL,
    order_time DATETIME,
    total INT NOT NULL,
    order_status BIT(1) DEFAULT 0,
    PRIMARY KEY (oid),
    FOREIGN KEY (uid) REFERENCES users(uid)
);

CREATE TABLE order_detail (
	oid INT NOT NULL,
    pid INT NOT NULL,
    cost INT NOT NULL
);