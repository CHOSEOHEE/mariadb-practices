-- table 생성: DDL
create table pet (
	name varchar(100),
    owner varchar(50),
    species varchar(50),
    gender char(1),
    birth date,
    death date
);

select * from pet;