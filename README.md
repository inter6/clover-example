clover-example
==============

[![CircleCI](https://circleci.com/gh/inter6/clover-example.svg?style=svg)](https://circleci.com/gh/inter6/clover-example)

[Clover](http://openclover.org/)로 Java 코드 테스트 및 정적 분석을 수행하는 예제 프로젝트 


준비물
----

- JDK 8
- Maven 3


사용법
----

### 실행

```bash
mvn spring-boot:run
```

Browser에서 ```http://localhost:8080/api/health``` 호출


### 테스트

```Checkstyle```, ```PMD```, ```Findbugs```, ```Clover```를 수행한다.

```bash
mvn -P test clean checkstyle:checkstyle pmd:pmd compile findbugs:findbugs clover:setup test clover:aggregate clover:clover
```

이 후, 아래의 경로에서 결과를 확인할 수 있다.

- Checkstyle : ```target/checkstyle-result.xml```
- PMD : ```target/pmd.xml```
- Findbugs : ```target/findbugs.xml```
- Clover : ```target/site/clover/index.html```


### 팩키징

```bash
mvn clean package
```

이 후, ```target/clover-example-1.0-SNAPSHOT.jar```가 생성되고 다음과 같이 실행시킬 수 있다.

```bash
java -jar target/clover-example-1.0-SNAPSHOT.jar
```
