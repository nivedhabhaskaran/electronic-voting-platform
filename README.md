# Electronic Voting Platform - REST API

A secure, scalable, and transparent electronic voting system built using Spring Boot and MySQL.

## 🎯 About This Project

This project was developed as part of my academic coursework in Web Frameworks and REST API. I designed and implemented a RESTful API to support an electronic voting system with features such as voter registration, secure authentication, vote casting, and real-time result reporting.

It demonstrates my skills in backend development, API design, database integration, and Java Spring Boot.

## 🚀 Features

- ✅ Voter registration & authentication
- ✅ Admin and super admin roles
- ✅ Election setup & candidate management
- ✅ Secure vote submission with role-based access
- ✅ JWT-based authentication & authorization
- ✅ RESTful API structure
- ✅ Real-time result calculation
- ✅ Swagger/OpenAPI documentation

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Security
- MySQL
- Maven
- Eclipse IDE

## 💻 Running the Project

1. Clone the repository:

```bash
git clone https://github.com/nivedhabhaskaran/electronic-voting-platform.git
cd electronic-voting-platform
Configure database credentials in src/main/resources/application.properties.

Build and run:
bash
mvn clean install
mvn spring-boot:run

📌 Key API Endpoints
Method	Endpoint	Description
POST	/api/register	Register a voter
POST	/api/login	User/admin login
GET	/api/elections	List elections
POST	/api/vote	Cast a vote
GET	/api/results	View election results

✍️ Author
👤 Nivedha B
B.Tech - Information Technology (IT)
2nd Year, IT-C
GitHub

