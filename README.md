<h1 align="center">📘 Student Management System (Java + MySQL)</h1>

<p align="center">
A console-based Student Management System built using <b>Java</b>, <b>MySQL</b>, and <b>JDBC</b>.  
This project allows adding, viewing, updating, deleting, and searching student records.
</p>

---

<h2>🚀 Features</h2>

- ➕ Add Student  
- 📋 View All Students  
- 🔍 Search Student by ID  
- ✏️ Update Student  
- 🗑 Delete Student  
- 🚫 Prevent Duplicate IDs  
- 📊 Clean Table-Style Output  

---

<h2>🛠 Technologies Used</h2>

| Technology | Purpose |
|-----------|---------|
| **Java** | Core application logic |
| **MySQL** | Database storage |
| **JDBC** | Java–MySQL connection |
| **Eclipse IDE** | Development environment |

---

<h2>🗄 Database Setup</h2>

Run the SQL script included in the project:

student.sql

This will create:

- **Database:** `school`  
- **Table:** `student`  

### 📌 Table Structure:

| Column | Type | Description |
|--------|------|-------------|
| **id** | INT (Primary Key) | Unique Student ID |
| **name** | VARCHAR(50) | Full Name |
| **gender** | VARCHAR(20) | Gender |
| **marks** | INT | Student Marks |

---

<h2>▶ How to Run the Project</h2>

1. Install **Java**, **MySQL**, and **Eclipse**  
2. Open this project in Eclipse  
3. Add MySQL JDBC Driver:  
   `mysql-connector-j-9.5.0.jar`  
4. Update database credentials inside `DBConnection.java`:
---java

Connection con = DriverManager.getConnection(<br>
    "jdbc:mysql://localhost:3306/school",<br>
    "root",<br>
    "YOUR_PASSWORD"<br>
);<br>
5. Run Main.java<br>
6. Use the console menu to interact with the program
<h2>📁 Project Structure</h2>
SchoolManagementSystem/
 ├── src/<br>
 │   ├── com/student/db/DBConnection.java<br>
 │   └── com/student/main/Main.java<br>
 ├── bin/<br>
 ├── student.sql<br>
 ├── mysql-connector-j-9.5.0.jar<br>
 ├── .gitignore<br>
 ├── .classpath<br>
 ├── .project<br>
 └── README.md<br>
<h2>🧪 Sample Menu Output</h2>
1. Add Student<br>
2. View All Students<br>
3. Search Student by ID<br>
4. Update Student<br>
5. Delete Student<br>
6. Exit<br>
Enter your choice:<br>
<h2>🧪 Sample Menu Output</h2>
---------------------------------------------------------------<br>
ID     NAME            GENDER      MARKS<br>
---------------------------------------------------------------<br>
101    Prasad          male        500<br>
102    Akash           male        600<br>
---------------------------------------------------------------
