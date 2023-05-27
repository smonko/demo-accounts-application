# PosAm FullStack Academy Demo app

## accounts-application (Backend + API)

Simple Java demo app to simulate backend and API

Front end is available at https://github.com/smonko/demo-accounts-web 

### Build with:
- SpringBoot 3.0.6
- Java JDK 17
- MySql
- H2


### How to use

Build with maven
```
$ mvn clean install -U 
```

Run
```
java -jar accounts-application-0.0.1-SNAPSHOT.jar
```

Run with config
```
java -jar  accounts-application-0.0.1-SNAPSHOT.jar --spring.config.location=../config/application.yml
```

### Feature flags
Configuration options to simulate featurea flags and toogle some functionality

```
features:
  canaryflag: true
  datastream: true
  dbdata: true
  messaging: false
```

**canaryflag** - no real function. Just to demonstrate canary deployment. Check */feature-flags*  
**datastream** - activate api endpoints with built-in data set
**dbdata** - activate api which get data from database.
**messaging** - activate messaging simulation. NOT Implemented YET!

### API Endpoints
Show feature flags
```
@RequestMapping(path = "/feature-flags", produces="application/json")
```

**datastream** set to ***true***
Show account with specific ID
```
@RequestMapping("/accounts/{id}")
```

Show all accounts
```
@RequestMapping("/accounts")
```

**dbdata** set to ***true***
Show account with specific ID
```
@RequestMapping("/userbyid/{id}")
```

Show account with specific email
```
@RequestMapping("/userbyemail/{email}")
```

Show all accounts
```
@RequestMapping("/usersall")
```

### Use in memory DB
Modify application.yml to look like this

```
spring:
  ...
  # jpa:
  #   show-sql: true
  #   hibernate:
  #     ddl-auto: update
  # datasource:
  #   url: jdbc:mysql://localhost:3306/usersdb
  #   username: "dbadmin@localhost"
  #   password: "adminpass"
  #   hikari:
  #     data-source-properties:
  #       serverTimezone: "GMT"
  #       useSSL: false
# In memory DB - for dbdata flag set to false
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password: password
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
```

### Copyrights
(C) Stefan Monko (monkos@posam.sk)