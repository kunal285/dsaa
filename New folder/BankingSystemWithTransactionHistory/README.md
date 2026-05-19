# BankingSystemWithTransactionHistory

## Folder Structure

`	ext
BankingSystemWithTransactionHistory/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\bank\accounts/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ BankAccount.java
â”‚       â”œâ”€â”€ BankManager.java
â”‚       â”œâ”€â”€ Transactable.java
â”‚       â””â”€â”€ Transactable.java
â””â”€â”€ README.md
`

## Interfaces

- Transactable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.bank.accounts.Main

## Sample Output

`	ext
=== Banking System with Transaction History ===
Stored record:
BankAccount details printed here
`