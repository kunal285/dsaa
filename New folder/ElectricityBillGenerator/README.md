# ElectricityBillGenerator

## Folder Structure

`	ext
ElectricityBillGenerator/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\utility\billing/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ ElectricityBill.java
â”‚       â”œâ”€â”€ BillingManager.java
â”‚       â”œâ”€â”€ Billable.java
â”‚       â””â”€â”€ Billable.java
â””â”€â”€ README.md
`

## Interfaces

- Billable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.utility.billing.Main

## Sample Output

`	ext
=== Electricity Bill Generator ===
Stored record:
ElectricityBill details printed here
`