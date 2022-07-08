# code-assessment
code-assessment


Please add below properties in application.properties file if file is blank.

server.port=8082
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:test
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

go to CodeAssessmentApplication.java and run this as java appliaction to run the project.

for login into db use http://localhost:8082/h2-console/login.do link


![image](https://user-images.githubusercontent.com/106257104/177987614-63ffe747-0f3f-4d9e-baba-d0118d95a278.png)

we have two endpoints for app

http://localhost:8082/upload first we will access upload rest service to upload given csv file.

![image](https://user-images.githubusercontent.com/106257104/177987899-c59c5f60-7fec-4340-9761-96c5384095b9.png)

http://localhost:8082/getFlightInfo to access flight info on the bases of day.

![image](https://user-images.githubusercontent.com/106257104/177988127-0c79b7d0-388d-44d5-afc0-0ba10a645d34.png)


unit test available if we don't want to use postman client.
