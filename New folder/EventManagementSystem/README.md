# EventManagementSystem

## Folder Structure

`	ext
EventManagementSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\events\manager/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ EventSchedule.java
â”‚       â”œâ”€â”€ EventManager.java
â”‚       â”œâ”€â”€ Schedulable.java
â”‚       â””â”€â”€ Schedulable.java
â””â”€â”€ README.md
`

## Interfaces

- Schedulable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.events.manager.Main

## Sample Output

`	ext
=== Event Management System ===
Stored record:
EventSchedule details printed here
`