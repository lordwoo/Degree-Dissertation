-- This file can be used to setup the database tables for the application.
-- SQL statements were written for PostgreSQL DMBS, and may not function correctly
-- on other DBMS'.

-- DROP TABLE patient;
-- DROP TABLE "user";

CREATE TABLE "user"
(
	username	VARCHAR(20) PRIMARY KEY,
	"password"	VARCHAR(20) NOT NULL
);

CREATE TABLE patient
(
	username	VARCHAR(20) REFERENCES "user"(username) PRIMARY KEY,
	gender		CHAR(1) NOT NULL CHECK (gender IN ('M', 'F')),
	age		INT NOT NULL,
	weight		DOUBLE PRECISION NOT NULL,
	prediction	BOOLEAN NOT NULL,
	timeassessed	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);