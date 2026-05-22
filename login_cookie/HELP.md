# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.6/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.6/gradle-plugin/packaging-oci-image.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/4.0.6/specification/configuration-metadata/annotation-processor.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.6/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.6/reference/using/devtools.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.6/reference/web/servlet.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Database 초기화
```sql
CREATE DATABASE auth_db DEFAULT CHARACTER SET utf8mb4;
CREATE USER 'auth_user'@'%' IDENTIFIED BY 'qwer1234!';
GRANT ALL PRIVILEGES ON auth_db.* TO 'auth_user'@'%';
FLUSH PRIVILEGES;

create table member(
    id          bigint          private key auto_increment,
    sign_id     varchar(20)     not null,
    password    varchar(200)    not null,
    email       varchar(200)    not null unique,
    role        varchar(200)    not null,
    valid_email boolean         default false,
    create_at   datetime        not null,
    update_at   datetime        null,
    delete_at   datetime        null
);
```
### 모델링
```
====================================
member 테이블
컬럼명   데이터형          졔약
id      bigint          기본키
name    varchar(20)     not null
tel     varchar(30)     null
addr1   varchar(200)    null
addr2   varchar(200)    null
lanes   varchar(200)    null
size    varchar(50)     null
------------------------------------
SwimPool 클래스, 테이블명 swim_pool
id : 23
name : 은평구립수영장
tel : 02-1111-2222
addr1 : 서울시 은평구 은평로1
addr2 : 32-22
lanes : 50M * 4, 100 * 2
size : 350m2
====================================

====================================
teacher 테이블
컬럼명   데이터형          졔약
id      bigint          기본키
name    varchar(20)     not null
main    varchar(30)     not null
birth_year  varchar(4)  null
swimpool_id bigint      null
------------------------------------
Teacher 클래스, 테이블명 teacher
id : 89
name : 박태환
main : 자유형
birthYear : 1990
swimPoolId : 23
====================================
```