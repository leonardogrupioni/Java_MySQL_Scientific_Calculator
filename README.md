# 🧮 Scientific Calculator with MySQL

This repository contains a Java-based **Scientific Calculator** with **MySQL database integration**. The project was developed as part of academic studies in Java programming and database persistence. It supports both **basic arithmetic operations** and **scientific functions**, storing calculation history in a MySQL database for later retrieval.

## 🚀 Features

- 🧠 **Basic operations**: Addition, subtraction, multiplication, and division
- 🧮 **Scientific operations**: Exponentiation, square roots, trigonometric functions, and more
- 🗃️ **MySQL persistence**: Save and retrieve operation history from a database
- 🧪 **JUnit test classes** for validating functionalities
- 💻 **Modular design** with OOP concepts

## 🧩 Technologies

- Java (Swing GUI + JDBC)
- MySQL (with `.sql` scripts to create and test the database)
- BlueJ project structure
- JAR MySQL Connector (`mysql-connector-j-9.1.0.jar`)

## 📁 Project Structure

```
Calculadora/
├── CalcBasica.java             # Class for basic operations
├── CalcCientifica.java         # Class for scientific operations
├── CalculadoraApp.java         # Main application logic and GUI
├── Database.java               # Class handling MySQL database interaction
├── TestaCalcBasica.java        # Unit test for basic calculator
├── TestaCalcCientifica.java    # Unit test for scientific calculator
├── CONSULTAS_SQL.sql           # Sample SQL queries
├── CREATE_DATABASE_TABLES.sql  # SQL script to create required tables
├── mysql-connector-j-9.1.0.jar # MySQL JDBC connector
```

## 🛠️ Setup

1. Clone this repository.
2. Import it into **BlueJ** or your favorite Java IDE.
3. Create the database and tables using `CREATE_DATABASE_TABLES.sql`.
4. Add the `mysql-connector-j-9.1.0.jar` to your project's build path.
5. Update the database connection details in `Database.java`.
6. Run `CalculadoraApp` to launch the calculator GUI.

## 💡 Example SQL Table

```sql
CREATE TABLE calculo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tipo VARCHAR(50),
  expressao VARCHAR(255),
  resultado VARCHAR(100),
  data_execucao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 👨‍💻 Author

**Leonardo Fajardo Grupioni**  
📌 Academic project for studies in OOP and database integration.