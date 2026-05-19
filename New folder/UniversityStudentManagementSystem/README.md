# UniversityStudentManagementSystem

## Folder Structure

```text
UniversityStudentManagementSystem/
|-- src/
|   `-- com/university/management/
|       |-- Main.java
|       |-- Student.java
|       |-- Course.java
|       |-- Department.java
|       |-- StudentManager.java
|       |-- PersonRecord.java
|       |-- UniversityException.java
|       |-- ExamEligibility.java
|       `-- ScholarshipEligibility.java
`-- README.md
```

## Interfaces

- ExamEligibility
- ScholarshipEligibility

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: `mkdir out`
3. Compile: `javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })`
4. Run: `java -cp out com.university.management.Main`

## Sample Output

```text
=== University Student Management System ===
Stored record:
Student [ID=1, Name=Demo Student], attendance=82, gpa=8.07, familyIncome=250000.0, courses=3
Department summary: Department [ID=2, Name=Computer Science], headOfDepartment=Dr. Mehta, courseCount=3
Calculated GPA: 8.07
Exam eligible: true
Scholarship eligible: true
```
