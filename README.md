# TPO Aplicaciones Interactivas

## Pre requisites

- Docker
- Docker Compose
- gradle (`brew install gradle`  or `apt install gradle`)
- Java v 1.8
- Git

## Install

```shell
git clone https://github.com/mberrueta/uade_app_interact_tpo.git
cd uade_app_interact_tpo
docker-compose up

gradle :test -i --tests "edu.uade.appl_interact.*"

java -jar releases/uade_app_interact_tpo.jar

```

## Access db

```shell
# create schema
$ docker exec tpo-app-interact-mysql /bin/sh -c 'mysql -u tpo -psecret app_interact_tpo < /tmp/tp_sql/db/schema.sql'

# seed
$ docker exec tpo-app-interact-mysql /bin/sh -c 'mysql -u tpo -psecret app_interact_tpo < /tmp/tp_sql/db/seed.sql'

# get inside mysql 
$ docker exec -it uadeappinteracttpo_db_1 mysql -utpo -psecret
mysql> USE app_interact_tpo;
-- show databases;
-- show tables;
# get into image bash
$ docker exec tpo-app-interact-mysql bash
```

## Organization

```shell
$tree

├── docker-compose.yml <- DB configuration
├── pom.xml <- Maven configuration. (It execute schema and seed also)
├── README.md <- this file
├── resources
│   └── db
│       ├── schema.sql <- tables creation
│       └── seed.sql <- fill database
├── src
│   ├── main
│   │   ├── java
│   │   │   └── edu
│   │   │       └── uade
│   │   │           ├── appl_interact
│   │   │           │   ├── controllers <- All the controllers 
│   │   │           │   ├── exeptions <- All the custom exceptions
│   │   │           │   ├── model
│   │   │           │   │   ├── dao
│   │   │           │   │   │   └── impl <- All the Data access objects (e.g. UserDao)
│   │   │           │   │   ├── entities  <- All the System entities (e.g. User)
│   │   │           │   │   ├── factories <- All the factories
│   │   │           │   │   │   ├── DaoFactory.java <- Instantiate the correct data access object
│   │   │           │   │   │   └── EntityManager.java <- CRUD operations for entities
│   │   │           │   │   └── services <- All the services
│   │   │           │   └── ui
│   │   │           └── lib
│   │   │               └── db
│   │   │                   ├── DBConnection.java <- Data base execution
│   │   │                   └── Transaction.java <- Execute things in transaction
│   │   └── resources
│   │       └── log4j.properties <- Log configuration

```
