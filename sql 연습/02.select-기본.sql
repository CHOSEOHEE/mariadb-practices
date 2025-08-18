--
-- select 연습
--

-- 예제01 : departments 테이블의 모든 데이터를 출력.
select * from departments;

-- 프로젝션(Projection)
-- 예제02 : employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select first_name, gender, hire_date from employees;

-- as(alias, 별칭, 생략가능)
-- 예제03: employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select first_name as '이름',
 gender as '성별',
 hire_date as '입사일' from employees;

-- as(alias, 별칭, 생략가능)
-- 예제04: employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select concat(first_name, ' ', last_name) as '전체이름',
 gender as '성별', 
 hire_date as '입사일' from employees; 

-- distinct
-- 예제05: titles 테이블에서 모든 직급의 이름 출력
select (title) from titles;

-- 예제06: titles 테이블에서 직급은 어떤 것들이 있는지 직급이름을 한번씩만 출력
select distinct(title) from titles;

--
-- where
--

-- 예제07: employees 테이블에서 1991년 이전에 입사한 직원의 이름, 성별, 입사일을 출력
SELECT 
    first_name AS '이름', gender AS '성별', hire_date AS '입사일'
FROM
    employees
WHERE
    hire_date < '1991-01-01';

-- 논리연산
-- 예제08: employees 테이블에서 1989년 이전에 입사한 여직원의 이름, 입사일을 출력
select first_name as '이름', gender as '성별', hire_date as '입사일' 
from employees 
where hire_date <= '1988-12-31'
and gender = 'F';

-- 예제09: dept_emp 테이블에서 부서 번호가 d005 이거나 d009에 속한 사원이 사번, 부서번호 출력
SELECT 
    emp_no, dept_no
FROM
    dept_emp
WHERE
    dept_no = 'd005' OR dept_no = 'd009';

SELECT 
    emp_no, dept_no
FROM
    dept_emp
WHERE
    dept_no IN ('d005' , 'd009');

-- LIKE 검색 
-- 예제10: employees 테이블에서 1989년에 입사한 직원의 이름, 입사일을 출력
SELECT 
    first_name AS '이름', hire_date AS '입사일'
FROM
    employees
WHERE
    hire_date LIKE '1989-%';
    
    SELECT 
    first_name AS '이름', hire_date AS '입사일'
FROM
    employees
WHERE
    hire_date BETWEEN '1989-01-01' AND '1989-12-31';
    
SELECT 
    first_name AS '이름', hire_date AS '입사일'
FROM
    employees
WHERE
    hire_date LIKE '1989-%';
    
--
-- order by
--

-- 예제11: employees 테이블에서 직원의 이름, 성별, 입사일을 입사가 빠른 순으로 출력
select first_name as '이름',
 gender as '성별',
 hire_date as '입사일'
 from employees
 order by hire_date asc;

-- 예제12: salaries 테이블에서 2001년 월급이 가장 높은 순을 사번, 월급을 출력
SELECT 
    emp_no, salary, from_date, to_date
FROM
    salaries
WHERE
    from_date LIKE '2001-%'
        AND to_date LIKE '2001-%'
order by salary desc;

-- 예제13: 남자 직원의 이름, 성별, 입사일을 선임 순(입사일이 작은 순)으로 출력하세요.
SELECT 
    first_name, gender, hire_date
FROM
    employees
WHERE
    gender = 'm'
ORDER BY hire_date ASC;

