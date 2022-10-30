# Hospital Manager

Back-end projects for Software Engineering courses.

## Environment

### Local

| soft            | version |
|:----------------|:--------|
| jdk             | 11      |
| Spring Boot     | 2.7.5   |
| Spring Security | 2.7.5   |
| mybatis         | 3.5.11  |
| mybatis-plus    | 3.5.2   |
| jwt             | 4.2.1   |
| swagger         | 3.0.0   |
| fastjson        | 1.2.83* |

### Online

| soft   | version  |
|:-------|:---------|
| docker | 20.10.18 |
| mysql  | 8.0      |
| redis  | 7.0.5    |

## Document Tree

```
hostpital
└─src
   ├─main
   │  ├─java
   │  │  └─com.soft_engin.hospital
   │  │                     ├─config
   │  │                     ├─controller       
   │  │                     ├─entity        # 对应数据库的字段
   │  │                     ├─filter
   │  │                     ├─mapper
   │  │                     ├─model         # 对应前端所需的字段
   │  │                     ├─pojo          # 各种bean用的字段
   │  │                     ├─service
   │  │                     └─utils
   │  └─resources
   │      └─mapper
   └─test
      └─java
          └─com.soft_engin.hospital
```

## Interface

create by [swagger](https://swagger.io/)
>step1: run this project  
>step2: http://localhost:8081/swagger-ui/

debug on [Apifox](https://www.apifox.cn/)
> step1: run this project  
> step2: use Apifox