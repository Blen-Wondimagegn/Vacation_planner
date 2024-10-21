# Vacation Planner Web Application


## Overview


The **Vacation Planner Web Application** is a simple, interactive tool designed to help users manage vacations. It allows users to view a list of vacations, search by vacation title, create new vacations, edit or delete existing vacations, and notify users of the vacation start date via email. The application is built using Spring Boot, Thymeleaf for dynamic HTML rendering, and supports basic CRUD operations for vacations.


## Features


1. **View Vacation List**: Users can view a list of vacations, including details such as the title, hotel, start date, end date, and destination.

2. **Search Functionality**: Users can search for vacations by entering keywords related to the vacation title.

3. **Create New Vacation**: Users can create a new vacation using the "Create New Vacation" button.

4. **Edit Vacation**: Existing vacations can be edited.

5. **Delete Vacation**: Users can delete a vacation from the list.

6. **Review Vacation**: Users can add reviews to vacations.

7. **Email Notifications**: Users can notify themselves of the start date of a vacation by entering their email and receiving a notification.


## Project Structure


- `src/main/java/org/blenwondimagegn/vacationplanner`:

    - Contains the Java classes for controllers, services, and entities.


- `src/main/resources/templates/`:

    - Contains Thymeleaf templates for the user interface, such as the vacation list and forms.


- `src/main/resources/static/css/`:

    - Contains CSS styles for the application.


- `src/main/resources/static/js/`:

    - Contains JavaScript files for handling UI interactions.


- `src/main/resources/static/images/`:

    - Contains images used in the application (e.g., logo).


## Getting Started


### Prerequisites


- **Java 8 or higher**: Ensure you have Java Development Kit (JDK) installed on your machine.

- **Maven**: The project uses Maven for dependency management and building.

- **MySQL** (or another relational database): A MySQL database is required to store vacation data.


### Installation


1. **Clone the repository**:

   ```bash

   git clone https://github.com/yourusername/vacation-planner-app.git

   cd vacation-planner-app
   ```


2. **Configure MySQL Database**:

    - Create a new database in MySQL (e.g., `vacation_planner_db`).

    - Update the database configurations in `src/main/resources/application.properties`:

      ```properties

      spring.datasource.url=jdbc:mysql://localhost:3306/vacation_planner_db

      spring.datasource.username=root

      spring.datasource.password=yourpassword

      spring.jpa.hibernate.ddl-auto=update

      ```


3. **Build and Run the Application**:

    - Use Maven to build the project:

      ```bash

      mvn clean install

      ```

    - Run the application:

      ```bash

      mvn spring-boot:run

      ```


4. **Access the Application**:

    - Open your web browser and go to:

      ```

      http://localhost:8080

      ```


### Folder Structure


- **Controllers**: Handle incoming web requests (e.g., displaying the vacation list, handling notifications).

- **Services**: Business logic (e.g., sending email notifications).

- **Repositories**: Interface with the database (e.g., fetching and saving vacation data).

- **Thymeleaf Templates**: HTML views with Thymeleaf tags for dynamic content rendering.

- **Static Files**: CSS, JS, and image files.


### Application Properties


Modify the `application.properties` file to configure database and other settings.


```properties

spring.datasource.url=jdbc:mysql://localhost:3306/vacation_planner_db

spring.datasource.username=root

spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update

```


## Key Endpoints


| Endpoint            | Description                            | Method |

|---------------------|----------------------------------------|--------|

| `/vacations`         | Displays a list of all vacations       | GET    |

| `/vacations/search`  | Search vacations by title              | GET    |

| `/vacations/new`     | Create a new vacation                  | GET    |

| `/vacations/edit/{id}` | Edit an existing vacation            | GET    |

| `/vacations/delete/{id}` | Delete a vacation                 | GET    |

| `/vacations/{id}/reviews` | View reviews for a vacation      | GET    |

| `/vacations/notify`  | Notify user via email about start date | POST   |


## Email Notification Feature


To send notifications via email, ensure you have an SMTP email server configured in `application.properties`. Example configuration for Gmail:


```properties

spring.mail.host=smtp.gmail.com

spring.mail.port=587

spring.mail.username=your-email@gmail.com

spring.mail.password=your-password

spring.mail.properties.mail.smtp.auth=true

spring.mail.properties.mail.smtp.starttls.enable=true

```


## Technologies Used


- **Spring Boot**: Backend framework for building the application.

- **Thymeleaf**: Template engine for dynamic HTML rendering.

- **MySQL**: Database for storing vacation information.

- **CSS/JavaScript**: Frontend styling and interactions.

- **Spring Mail**: For sending email notifications.


## How to Use


1. **View Vacations**: On the home page, you can see a list of all available vacations.

2. **Search Vacations**: Use the search bar to find vacations by title.

3. **Create New Vacation**: Click the "Create New Vacation" button to add a new vacation to the list.

4. **Edit or Delete Vacations**: Use the "Edit" and "Delete" links in the vacation list to modify or remove vacations.

5. **Notify Start Date**: Enter your email address and click "Notify" to receive an email notification of the vacation start date.


## Future Enhancements


- **User Authentication**: Add user login and registration functionality.

- **Vacation Reviews**: Enhance the review system with rating features.

- **Excursion Management**: Add the ability to manage excursions for each vacation.

- **Responsive Design**: Make the web interface more responsive for mobile devices.


## License


This project is licensed under the MIT License.


---


By following this guide, you should be able to install, configure, and run the **Vacation Planner Web Application**. 