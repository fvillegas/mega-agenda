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
