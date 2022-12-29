Simple rest web based calculator caches the results of its computations

Requirments
1. JDK 1.7 or higher
2. Maven 3.3.*

How to run project
1. Open command line on project directory
2. Type "mvn spring-boot:run" (witour qoutes) and press enter
3. Now web app should be available by the following urls:


%hostname%:%port%/calculator/add/{a}/{b}/{c}
%hostname%:%port%/calculator/substract/{a}/{b}/{c}
%hostname%:%port%/calculator/multiply/{a}/{b}/{c}
%hostname%:%port%/calculator/divide/{a}/{b}/{c}


Technologies used:
- Spring Boot 1.3.5.RELEASE
- Ehcache 2.10.2
- logback 1.0.13
- Maven