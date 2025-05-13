CREATE DATABASE zoan_db;
USE zoan_db;

CREATE TABLE user (
    email_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    college_id VARCHAR(100) NOT NULL,
    phone_no INT NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    image VARCHAR(512),
    user_email VARCHAR(255) NOT NULL
);

INSERT INTO user (email_id, name, college_id, phone_no, password)
VALUES (
    'abhinaypuppala04@gmail.com',
    'Abhinay',
    '21211A12A0',
    8125913804,
    'Abhinay@12345'
);

ALTER TABLE user MODIFY COLUMN phone_no BIGINT NOT NULL;

commit;
select * from user;