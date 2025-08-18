--
-- subquery
--

--
-- 1) select (subquery) from t;
--    insert into t values(val1, val2, (subquery), val3);

--
-- 2) from 절의 서브쿼리
-- 
SELECT NOW() AS n, SYSDATE() AS s, (3 + 1) AS r FROM DUAL;

SELECT 
    a.n, a.s, a.r
FROM
    (SELECT NOW() AS n, SYSDATE() AS s, (3 + 1) AS r FROM DUAL) a;

--
-- 3) where 절의 서브쿼리
--

-- 예제1) 현재, 'Fai Bale'이 근무하는 부서에서 근무하는 직원의 사번, 전체 이름을 출력해보세요.

-- SOL1: 두 개의 쿼리로 해결
-- 1st query: 'Fai Bale'이 근무하는 부서번호 가져오기
-- 2nd query: 1st query에서 구한 부서번호를 가지고 동료들 가져오기

SELECT 
    dept_no
FROM
    employees a,
    dept_emp b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND CONCAT(a.first_name, ' ', a.last_name) = 'Fai Bale';

-- 'd004'

SELECT 
    a.emp_no, a.first_name
FROM
    employees a,
    dept_emp b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND b.dept_no = 'd004';

-- SOL2: 서브쿼리로 해결
SELECT 
    a.emp_no, a.first_name
FROM
    employees a,
    dept_emp b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND b.dept_no = (SELECT 
            dept_no
        FROM
            employees a,
            dept_emp b
        WHERE
            a.emp_no = b.emp_no
                AND b.to_date = '9999-01-01'
                AND CONCAT(a.first_name, ' ', a.last_name) = 'Fai Bale');
                    
--  3-1) 단일행 연산자: =, >, <, >=, <=, !=, <>

--  예제2) 현재 전체사원의 평균연봉보다 적은 급여를 받는 사원의 이름(first_name), 급여(salary)를 출력하세요.
-- 72012.2359
SELECT 
    a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND b.salary < (SELECT 
            AVG(salary)
        FROM
            salaries
        WHERE
            to_date = '9999-01-01')
ORDER BY b.salary DESC;

--  예제3) 현재, 직책별 평균급여 증에 가장 적은 평균급여의 직책의 직책이름과 그 평균 급여를 출력하세요.

-- 1) 직책별 평균 급여
 SELECT 
    a.title, AVG(b.salary)
FROM
    titles a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY a.title;

-- 2) 직책별 가장 적은 평균급여
SELECT 
    MIN(avg_salary)
FROM
    (SELECT 
        a.title, AVG(b.salary) AS avg_salary
    FROM
        titles a, salaries b
    WHERE
        a.emp_no = b.emp_no
            AND a.to_date = '9999-01-01'
            AND b.to_date = '9999-01-01'
    GROUP BY a.title) a;
    
    -- SOL1: where절(having절)의 서브쿼리 사용
    SELECT 
    a.title, AVG(b.salary)
FROM
    titles a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY a.title
HAVING AVG(b.salary) = (SELECT 
        MIN(avg_salary)
    FROM
        (SELECT 
            a.title, AVG(b.salary) AS avg_salary
        FROM
            titles a, salaries b
        WHERE
            a.emp_no = b.emp_no
                AND a.to_date = '9999-01-01'
                AND b.to_date = '9999-01-01'
        GROUP BY a.title) a);
        
-- SOL2: top-k (limit, 보통 order by 뒤에 온다)
 SELECT 
    a.title, AVG(b.salary)
FROM
    titles a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY a.title
ORDER BY AVG(b.salary) ASC
LIMIT 0 , 1;

    
--  3-2) 복수행 연산자: in, not, in, (비교연산자)any, (비교연산자)all

--  (비교연산자)any 사용법
--  1. =any : in
--  2. >any, >=any : 최소값
--  3. <any, <=any : 최대값
--  4. <>any, !=any: not in
  
--  (비교연산자)all 사용법
--  1. =all:(X)
--  2. >all, >=all: 최대값
--  3. <all, <=all: 최솟값
--  4. <>all, !=all

-- 예제4) 현재 급여가 5000 이상인 직원 이름(first_name)과 급여(salary)를 출력
-- 둘리 60000
-- 마이콜 80000

-- SOL1: join
SELECT 
    a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND b.salary > 50000
ORDER BY b.salary ASC;

-- SOL2: subquery where(in)
SELECT 
    a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND (a.emp_no , b.salary) IN (SELECT 
            emp_no, salary
        FROM
            salaries
        WHERE
            to_date = '9999-01-01'
                AND salary > 50000)
ORDER BY b.salary ASC;   

-- SOL3: subquery:where(any)
SELECT 
    a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND (a.emp_no , b.salary) = ANY (SELECT 
            emp_no, salary
        FROM
            salaries
        WHERE
            to_date = '9999-01-01'
                AND salary > 50000)
ORDER BY b.salary ASC;
        
   -- 예제5) 현재, 각 부서별로 최고 급여를 받고 있는 직원의 부서이름(dept_name), 이름(first_name), 연봉(salary)
   -- 총무 둘리 40000
   -- 개발 마이콜 50000
   
SELECT 
    a.dept_no, MAX(b.salary)
FROM
    dept_emp a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY a.dept_no;

-- SOL1: where절 subquery(in)
SELECT 
    dept_name, c.first_name, d.salary
FROM
    departments a,
    dept_emp b,
    employees c,
    salaries d
WHERE
    a.dept_no = b.dept_no
        AND b.emp_no = c.emp_no
        AND c.emp_no = d.emp_no
        AND b.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND (a.dept_no , d.salary) IN (SELECT 
            a.dept_no, MAX(b.salary)
        FROM
            dept_emp a,
            salaries b
        WHERE
            a.emp_no = b.emp_no
                AND a.to_date = '9999-01-01'
                AND b.to_date = '9999-01-01'
        GROUP BY a.dept_no);
     
-- SOL2: from절 subquery(in)
SELECT 
    *
FROM
    departments a,
    dept_emp b,
    employees c,
    salaries d,
    (SELECT 
        a.dept_no, MAX(b.salary) AS max_salary
    FROM
        dept_emp a, salaries b
    WHERE
        a.emp_no = b.emp_no
            AND a.to_date = '9999-01-01'
            AND b.to_date = '9999-01-01'
    GROUP BY a.dept_no) e
WHERE
    a.dept_no = b.dept_no
        AND b.emp_no = c.emp_no
        AND c.emp_no = d.emp_no
        AND a.dept_no = e.dept_no
        AND b.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND d.salary = e.max_salary
