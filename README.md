# springbatch-mybatis-oracle-demo

# Introduction
This demo is based on spring boot(2.0.5.RELEASE) + spring batch + mybatis + oracle(12c)

# init
#### 1. create a bussness table like people
```
CREATE TABLE PERSON(	
    "PEOPLE_ID" NUMBER NOT NULL PRIMARY KEY, 
    "FIRST_NAME" VARCHAR2(20 BYTE), 
    "LAST_NAME" VARCHAR2(20 BYTE)
)
```
#### 2. user authorization
You may need to add the authorization of the user when you see the following exception
##### exception:
`ORA-01950: 对表空间 'USERS' 无权限 解决方法`
##### tips:
`alter user tester quota unlimited on USERS;`
 
#### 3. set isolation level
You may need to set the isolation level of the oracle database when you see the following exception
##### exception:
`PreparedStatementCallback; SQL [INSERT into BATCH_JOB_INSTANCE(JOB_INSTANCE_ID, JOB_NAME, JOB_KEY, VERSION) values (?, ?, ?, ?)]; ORA-08177: 无法连续访问此事务处理`
##### tips:
`set global TRANSACTION ISOLATION LEVEL READ COMMITTED;`

# start
Like other spring boot demos, you can run from the main() method in the Application class.
