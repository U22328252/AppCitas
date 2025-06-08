# AppCitas

AppCitas is a small web application for managing medical appointments. It is organized as a standard NetBeans project using Ant for its build process. The application persists information in a MySQL database and presents a simple JSP based web interface.

## Prerequisites

- JDK 17 or later
- MySQL 8.x
- Apache Ant or NetBeans IDE (for building and running)

## Database setup

1. Create a database named `sistema_citas` in your MySQL server.
2. Import the SQL script located at `database/App_citas.sql` into this database. It contains the tables and initial data required by the application.
3. Adjust the connection parameters in `src/java/DataAccessObject/Conexion.java` if your MySQL credentials differ.

## Running the application

1. Open the project in NetBeans or build it using Ant:

   ```bash
   ant clean build
   ```

2. Deploy the generated WAR (`dist/AppCitas.war`) to a servlet container such as Apache Tomcat, or run it directly from NetBeans.

After deployment the web interface can be accessed from your browser. The default pages are located under the `web` folder and include simple JSP views such as `listarPacientes.jsp`.

## Project modules

The Java source code is divided into several modules under `src/java`:

- **BusinessEntity** – Plain Java objects representing the domain entities (e.g. `PacienteBE`, `CitaBE`).
- **DataAccessObject** – DAO classes and `Conexion.java` for database interaction.
- **BusinessLogic** – The business layer containing services that operate on the DAOs.
- **web** – JSP pages and static resources found in the `web` directory.

These modules collectively implement a basic appointment scheduling system, illustrating a layered architecture for educational purposes.
