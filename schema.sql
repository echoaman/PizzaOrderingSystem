DROP TRIGGER IF EXISTS order_master.master_ins;
DROP TRIGGER IF EXISTS order_master.master_up;
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
    order_status BIT(1) DEFAULT 0,
    PRIMARY KEY (oid),
    FOREIGN KEY (uid) REFERENCES users(uid)
);

CREATE TABLE order_slave (
	oid INT NOT NULL AUTO_INCREMENT,
    uid INT NOT NULL,
    order_time DATETIME DEFAULT now(),
    order_status BIT(1) DEFAULT 0,
    PRIMARY KEY (oid),
    FOREIGN KEY (uid) REFERENCES users(uid)
);

CREATE TABLE order_detail (
	oid INT NOT NULL,
    pid INT NOT NULL
);

INSERT INTO pizza(pname,cost) VALUES ('pizza1', 300);
INSERT INTO pizza(pname,cost) VALUES ('pizza2', 400);
INSERT INTO pizza(pname,cost) VALUES ('pizza3', 500);

-- Write to master and update slave

CREATE TRIGGER master_ins
AFTER INSERT ON order_master
FOR EACH ROW
	INSERT INTO order_slave(uid,order_time) VALUES(NEW.uid, NEW.order_time);
    
-- Write to slave if master updated

DELIMITER $$
CREATE TRIGGER master_up
BEFORE UPDATE ON order_master
FOR EACH ROW
	BEGIN
		IF NEW.order_status <> OLD.order_status THEN
			UPDATE order_slave 
            SET order_slave.order_status = 1
            WHERE order_slave.oid = NEW.oid;
		END IF;
	END
	$$

DELIMITER ;