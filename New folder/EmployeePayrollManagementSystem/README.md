# EmployeePayrollManagementSystem

## Folder Structure

`	ext
EmployeePayrollManagementSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\company\hr/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ Employee.java
â”‚       â”œâ”€â”€ PayrollManager.java
â”‚       â”œâ”€â”€ Payable.java
â”‚       â””â”€â”€ Payable.java
â””â”€â”€ README.md
`

## Interfaces

- Payable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.company.hr.Main

## Sample Output

`	ext
=== Employee Payroll Management System ===
Stored record:
Employee details printed here
`