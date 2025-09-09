--
-- JDBC Test SQL
--

desc dept;

-- select 
select id, name from dept where name like '%개발%';

-- insert
insert into dept(name) values('UX팀');

-- delete
delete from dept where id = 11;

-- update
update dept set name = '서비스개발팀' where id =2;
select * from emp;

--
-- email application
--

desc email;

-- count
select count(*) from email;

-- findAll
select id, first_name, last_name, email from email order by id desc;

-- deleteByEmail
 delete from email where email = 'dooly@gmail.com';
 
 -- deleteByEmail
 delete
 
-- insert
 insert into email(first_name, last_name, email) values ('둘', '리', 'dooly@gmail.com');
 
 --
 -- bookshop application
 --
 
 -- deleteBybook
 delete from book where bookshop;
 
 -- insert
 insert into bookshop(id, name) values ('제목: ','작가: ');
 insert into bookshop(id, title, status) values ('아이디:', '제목: ', '대여유무: ');
 
 --
 -- guestbook
 --
 
 desc guestbook;
 alter table guestbook modify id int not null auto_increment;
 -- insert
 insert into guestbook values(null, '둘리', '1234', 'ㅎㅇ', now());
 
 
 -- findAll
 select * from guestbook order by id desc;
 
 -- deleteByIdAndPassword
 delete from guestbook where id = 1 and password = '1234';
 
 
 --
 -- mysite: user
 --
 
 desc user;
 
 -- 회원가입
 insert into user(name, email, password, gender, join_date) values ('둘리', 'dooly@gmail.com', password('1234'), 'male', current_date());
 
 -- 회원리스트
 select * from user;
 
 -- 삭제
 delete from user where id = 3;
 