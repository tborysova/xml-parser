# xml-parser

Spring Boot application accepts XML documents, validate against an XSD schema, parse, and store data in the database.

The XML documents are in the following format:
 
 ```xml
<?xml version="1.0" encoding="UTF-8"?>
<epaperRequest>
  <deviceInfo name="Browser" id="test@comp">
    <screenInfo width="1280" height="752" dpi="160" />
    <osInfo name="Browser" version="1.0" />
    <appInfo>
      <newspaperName>abb</newspaperName>
      <version>1.0</version>
    </appInfo>
  </deviceInfo>
  <getPages editionDefId="11" publicationDate="2017-06-06" />
</epaperRequest>
```

Installation

> git clone https://github.com/tborysova/xml-parser.git

* Set up database name and password

*  mvn clean install 

*  mvn package

*  java -jar target/xml-parser-0.0.1-SNAPSHOT.jar

Locally 

* Create database in PostgreSQL and set user/password in application.properties.

* mvn clean install

* mvn spring-boot:run




**REST API**


## POST

XML documents can be sent to the application via HTTP POST requests

* URL - http://localhost:8080/api/epapers
* Body - upload XML in request body with variable "fileName"

<img width="650" alt="postman" src="https://user-images.githubusercontent.com/108882766/206400627-6eeaaa39-8c92-4d0f-b8f0-80a03f43c327.png">




## GET

* URL - http://localhost:8080/api/epapers?size=1&page=7&sort=id
* Get content of the DB with possibility of sorting, paging and filtering.



<img width="650" alt="postman_get" src="https://user-images.githubusercontent.com/108882766/206408271-e6077b29-bd65-4c05-83ae-0ed6d31811f9.png">





