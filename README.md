COMP3005 
Assignment 3 Question 1
Hasib Khodayar
101225523
 
## Set Up PostgreSQL Database:

### Step 1:
Install PostgreSQL if you haven't already. You can download it from [here](https://www.postgresql.org/download/).

### Step 2:
Open `pgAdmin`, the management tool for PostgreSQL.

### Step 3:
Create a new database called `Asn3db`.
- Right-click on `Databases` → `Create` → `Database…`
- Enter `Asn3db` in the Database field.

### Step 4:
Create and populate a table called `students`.
- Open a SQL Query tool and run the SQL file provided


## Java CRUD Application using JDBC:

### Step 1:
Set up a new Java project in an IDE.

### Step 2:
Add the JDBC driver to your project.
- Download the PostgreSQL JDBC driver from [here](https://jdbc.postgresql.org/).
- Add the `.jar` file to your project as an external library.
- Alternativly you can create a maven project and add the JDBC driver in your pom.xml file as a dependancy

### Step 3: 
- Add the Assign3Q1 class file into your project
- Open the application source code and navigate to the "Assign3Q1" Constructor method where the code 
connects with the database.

- You must make sure that the URL is on the correct host and port,  you can check these in PGAdmin by right-clicking 
on your postgres version --> properties --> connection

- You must also make sure the application is connecting to the database
in which you created the students table

- Example:  String url = "jdbc:postgresql://localhost:5433/postgres"; 
- Here the host is "localhost", port is "5433" and database is "postgres"

- After this you have to input the correct username and password in the
given fields. In my case the username was just database name

- Example: String user = "postgres";
- String password = "Hasib123";

- After all this is setup and you have succesfully connected to the database You may simply run the code.

## DEMO VIDEO LINK:
- On youtube: https://youtu.be/sdRHN9oYkN4