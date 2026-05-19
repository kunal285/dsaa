# LibraryManagementSystem

## Folder Structure

`	ext
LibraryManagementSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\library\system/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ BookItem.java
â”‚       â”œâ”€â”€ LibraryManager.java
â”‚       â”œâ”€â”€ Borrowable.java
â”‚       â””â”€â”€ Borrowable.java
â””â”€â”€ README.md
`

## Interfaces

- Borrowable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.library.system.Main

## Sample Output

`	ext
=== Library Management System ===
Stored record:
BookItem details printed here
`