# Rolodex Contact Manager

## Project Description
The Rolodex Contact Manager is a full‑stack Java Spring MVC application designed to help users create, organize, update, and manage different types of contacts.  
The system supports **Family**, **Business**, and **Friend** contacts, each with unique fields and behaviors, while sharing a common object‑oriented structure.  
The project demonstrates strong use of **OOP principles**, **MVC architecture**, **form validation**, **Thymeleaf templating**, and clean separation of concerns.

## Video Demo
- https://youtu.be/6ruqx6ZjGB0

## Project Tasks

### Task 1: Set up the development environment
- Install Java, Maven, and Spring Boot dependencies  
- Configure Git and GitHub repository  
- Establish MVC project structure  

### Task 2: Plan the project
- Define the scope: multi‑type contact management  
- Identify shared vs. unique fields for each contact type  
- Design class hierarchy using inheritance and composition  

### Task 3: Implement core features
- Build the base Contact model and specialized subclasses  
- Implement controllers for Add, Edit, Delete, and List operations  
- Create Thymeleaf views for each contact type  
- Add validation, error handling, and dropdown population  
- Apply PRG (Post/Redirect/Get) where appropriate  

### Task 4: Test the application
- Test form submissions for all contact types  
- Validate error handling and form repopulation  
- Test CRUD operations end‑to‑end  
- Debug issues with model attributes and redirects  

### Task 5: Document the project
- Write a comprehensive README  
- Add comments to controllers, services, and models  
- Document OOP structure and MVC flow  

### Task 6: Finalize and submit
- Review code for clarity and maintainability  
- Ensure consistent UI and UX  
- Push final version to GitHub  

## Object‑Oriented Programming Features Applied

The Rolodex project uses core OOP principles to keep the application organized, scalable, and easy to maintain. Each contact type shares common behavior while still supporting its own unique details, allowing the system to grow without duplication or complexity.

### Inheritance
A shared base structure defines common fields and behaviors for all contacts. Family, Business, and Friend contacts extend this foundation, reducing repetition and keeping the design consistent.

### Polymorphism
The application treats all contact types through a common interface, allowing the service layer to work with them interchangeably. This enables flexible processing without needing separate logic for each type.

### Encapsulation
Each class protects its internal data by exposing only what is necessary. Contact details are managed through controlled access, ensuring data integrity and preventing unintended modification.

### Abstraction
Complex operations are hidden behind simple, clear interfaces. Saving, updating, or retrieving contacts is handled through defined contracts, allowing the rest of the application to use these operations without knowing the underlying implementation.

### Composition
Contacts contain structured components such as an address object rather than scattering address fields across multiple classes. This keeps the design modular, easier to update, and more reflective of real‑world relationships.

## Project Skills Learned
- Object‑Oriented Programming (inheritance, polymorphism, composition, abstraction)  
- Spring MVC architecture and controller‑view‑model flow  
- Form handling, validation, and error messaging  
- Thymeleaf templating and dynamic dropdown population  
- Clean separation of concerns using Services and Models  
- Git and GitHub for version control  
- Debugging and iterative refinement  

## Language Used
- **Java (Spring MVC)**  
- **HTML + Thymeleaf**  
- **CSS/Bootstrap**  
- **Maven**  

## Development Process Used
- **Agile Methodology**  
  - Iterative development  
  - Frequent testing and refinement  
  - Incremental feature implementation  
  - Continuous feedback and UI improvements  

## Link to Project
Rolodex Contact Manager Repository  
https://github.com/username/rolodex-project
