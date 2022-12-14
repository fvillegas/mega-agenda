# mega-agenda
```
/**
 * Controller / RestController -> UI / API 
 * Service -> logica de negocio
 * Mapper -> DAL / data access layer
 */
```
# Database

```
CREATE USER mega-agenda WITH PASSWORD "top-secret-password";
CREATE DATABASE mega-agenda WITH OWNER "mega-agenda";
ALTER DATABASE mega-agenda SET timezone TO 'UTC';
```

For the specif database create extension

```
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
```

ADD ENVIRONMENT VARIABLES
```
CALENDAR_DBUSER
CALENDAR_DBPASSWORD
```

# JWT certificates
Create certificates in PROJECT_DIRECTORY/src/main/resources/jwt:
```
openssl req -newkey rsa:2048 -new -nodes -x509 -days 3650 -keyout key.pem -out cert.pem
```

# Documentation
MyBatis: 
- https://mybatis.org/mybatis-3/sqlmap-xml.html
- https://medium.com/@hsvdahiya/mybatis-annotations-result-mapping-spring-79944ff74b84

