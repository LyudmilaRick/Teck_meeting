-- liquibase formatted sql

-- changeSet rickln: 8.3
CREATE TABLE employee
(
    id           INT,
    name         varchar(255),
    department   INT,
    salary       FLOAT
);
