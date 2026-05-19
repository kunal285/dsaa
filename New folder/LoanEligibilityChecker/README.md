# LoanEligibilityChecker

## Folder Structure

`	ext
LoanEligibilityChecker/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\finance\loans/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ LoanApplication.java
â”‚       â”œâ”€â”€ LoanManager.java
â”‚       â”œâ”€â”€ Eligible.java
â”‚       â””â”€â”€ Eligible.java
â””â”€â”€ README.md
`

## Interfaces

- Eligible

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.finance.loans.Main

## Sample Output

`	ext
=== Loan Eligibility Checker ===
Stored record:
LoanApplication details printed here
`