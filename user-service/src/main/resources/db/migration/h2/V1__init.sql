SET MODE ORACLE;
DROP TABLE IF EXISTS "USERS";
DROP SEQUENCE IF EXISTS USER_ID_SEQUENCE;
CREATE SEQUENCE USER_ID_SEQUENCE START WITH 1000 INCREMENT BY 1;
CREATE TABLE "USERS"
(
   "ID" BIGINT DEFAULT USER_ID_SEQUENCE.NEXTVAL PRIMARY KEY,
   "NAME" VARCHAR (30) NOT NULL,
   "AGE" INTEGER,
   "ADDRESS_ID" INTEGER
);
