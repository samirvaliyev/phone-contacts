# PHONE CONTACTS PROJECT

## Start Project

1. Open terminal
2. Write this command: `docker-compose up`
3. Open resource package: [application-db.yaml](https://github.com/samirvaliyev/phone-contacts/blob/main/src/main/resources/application-db.yaml)
4. Change `ddl-auto` `validate` to `create` & create tables to DB: 
5. `run` PhoneContactsApplication.java file
6. After creating tables replace `create` to `validate`

# All Services API

## Postman JSON File
Download the [contact-phones.postman_collection.json](https://github.com/samirvaliyev/phone-contacts/blob/main/postman/contact-phones.postman_collection.json) file from the Postman folder and import it into Postman.


## user

* **create-user** _->_ `localhost:5788/v1/user/sign-up` [POST]
* **login-user** _->_ `localhost:5788/v1/auth/login` [POST]


## contact

* **create-contact** _->_ `localhost:5788/v1/contact` [POST]
* **get-all-contacts** _->_ `localhost:5788/v1/contact/all` [GET]
* **update-contact** _->_ `localhost:5788/v1/contact/{id}` [PUT]
* **delete-contact** _->_ `localhost:5788/v1/contact/delete/{id}` [DELETE]


## Swagger API
http://localhost:5788/swagger-ui/index.html


## Adminer Database
http://localhost:8580/

- Username: root
- Password: password


## Use Technologies

* Spring Boot
* Spring Security
* JWT
* MySQL
* Spring Data Jpa & Hibernate
* Gradle
* Docker
* Postman
* Spring MVC with Swagger

