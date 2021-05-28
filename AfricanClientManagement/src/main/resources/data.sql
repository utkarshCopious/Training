DROP TABLE IF EXISTS Client_Service;

CREATE TABLE Client_Service (
  id BIGINT (512) PRIMARY KEY,
  firstname VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
  phone BIGINT(512) NOT NULL,
  address VARCHAR(512) NOT NULL);

insert into Client_Service values(10000000000001,'Raghav', 'Sacchar', 9890989098, '1234567');
insert into Client_Service values(10000000000002,'Aman', 'Singh', 9890989097, '1234568');
insert into Client_Service values(10000000000003,'Pardon', 'Mhalanga', 9800989098, '1234590');

