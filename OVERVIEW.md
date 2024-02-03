# Video Rental Store Application

## Overview

Welcome to the Video Rental Store Application! This project aims to provide a seamless and efficient solution for renting films.

## Technologies Used

- Programming Language: Java
- Framework: Spring Boot
- Database: None(In-memory store data, for simplicity, not suitable for production)

## Implementation Details

- The application adheres to the **open/closed** principle, allowing for easy extension of functionality without modifying existing code. New film types can be added by creating new classes without altering the existing ones,
which follows the **dependency inversion** principle where high-level modules should not depend upon low-level modules they should depend on abstractions(Controllers>>Services>Repositories) in a DDD(Domain-driven design).
- ControllerAdvice to catch exceptions and return user-friendly messages. 
- The application contains some examples of integration and unit tests.

## Corners Cut
1. **Actual database due to additional implementations like table/model structure, ORM framework, integration testing(test containers).**
2. **Mapper pattern, too much boilerplate code or implement mapstruct and lombok.**
