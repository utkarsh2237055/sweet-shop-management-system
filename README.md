TDD Kata: Sweet Shop Management System
Objective

The goal of this kata is to design, build, and test a full-stack Sweet Shop Management System.
This project demonstrates skills in backend API development, database integration, authentication, testing using TDD, and modern development practices, including responsible AI usage.

Core Requirements
1. Backend API (RESTful)

The backend serves as the core of the application, handling business logic, security, and persistence.

Technology Chosen:
Java with Spring Boot (Java 17, Spring Boot 3.x)

Database:

H2 (in-memory) for testing

Can be switched to PostgreSQL/MySQL for production

Uses Spring Data JPA & Hibernate

User Authentication:

User registration and login supported

JWT (JSON Web Token) based authentication

Role-based authorization (USER, ADMIN)

Protected endpoints using Spring Security

API Endpoints
Authentication

POST /api/auth/register → Register a new user

POST /api/auth/login → Login and receive JWT token

Sweets (Protected)

POST /api/sweets → Add a new sweet (Admin only)

GET /api/sweets → View all available sweets

GET /api/sweets/search → Search sweets by:

name

category

price range

PUT /api/sweets/{id} → Update sweet details

DELETE /api/sweets/{id} → Delete a sweet (Admin only)

Inventory (Protected)

POST /api/sweets/{id}/purchase → Purchase a sweet (decrease quantity)

POST /api/sweets/{id}/restock → Restock a sweet (Admin only)

Each Sweet contains:

id (UUID)

name

category

price

quantity

createdAt

updatedAt

2. Frontend Application

🚧 Status: Optional / Future Enhancement
(Current submission focuses on backend + testing)

Planned frontend features:

User login & registration

Sweet listing dashboard

Search and filtering

Purchase button (disabled if quantity = 0)

Admin UI for managing sweets

Proposed Tech: React / Angular / Vue

Process & Technical Guidelines
1. Test-Driven Development (TDD)

Tests were written before implementation

Followed the Red → Green → Refactor cycle

Covered:

Service layer

Controller layer

Repository integration

Used JUnit 5, Mockito, and Spring Boot Test

2. Clean Coding Practices

Layered architecture:

Controller

Service

Repository

DTOs

Security

Followed SOLID principles

Meaningful class & method names

Centralized exception handling

DTOs used instead of exposing entities

3. Git & Version Control

Git used for version control

Frequent commits with descriptive messages

Commit history reflects incremental TDD workflow

4. AI Usage Policy (Important)

AI tools were used responsibly as assistive co-developers, not as a replacement for understanding.

AI Co-authorship

For commits where AI assistance was used, the AI was added as a co-author in the commit message.

Example:

git commit -m "feat: add JWT authentication filter

Used an AI assistant to help scaffold JWT filter logic
and review Spring Security configuration.

Co-authored-by: ChatGPT <ai@users.noreply.github.com>"

Deliverables
1. Public Git Repository

GitHub repository containing complete source code and tests

2. README.md

Includes:

Project overview

Setup instructions

API details

Testing information

AI usage disclosure

3. Test Report

Tests executed using Maven:

mvn clean test


Includes:

Controller tests

Service tests

Repository integration tests

Test results available in:

target/surefire-reports/

4. (Optional – Brownie Points)

Deployment not included in this submission

Backend can be deployed to:

Render

Railway

AWS

Heroku

Setup Instructions (Backend)
Prerequisites

Java 17+

Maven 3.9+

Eclipse / IntelliJ / VS Code

Steps
git clone <repository-url>
cd sweet-shop
mvn clean install
mvn spring-boot:run

Access

API Base URL: http://localhost:8080

H2 Console: http://localhost:8080/h2-console

My AI Usage
Tools Used

ChatGPT

How I Used AI

Generating boilerplate for entities, DTOs, and services

Debugging Spring Security & JWT configuration issues

Writing and refining unit and integration tests

Improving code structure and error handling

Assisting with README documentation

Reflection
