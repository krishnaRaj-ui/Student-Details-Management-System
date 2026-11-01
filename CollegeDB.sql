CREATE DATABASE CollegeDB;

USE CollegeDB;

CREATE TABLE Student (
    Student_ID INT PRIMARY KEY,
    Student_Name VARCHAR(100) NOT NULL,
    Marks_CGPA DECIMAL(5,2) NOT NULL
);

INSERT INTO Student
(Student_ID, Student_Name, Marks_CGPA)
VALUES
(101, 'Rahul', 85.50),
(102, 'Arun', 90.00);

SELECT * FROM Student;
