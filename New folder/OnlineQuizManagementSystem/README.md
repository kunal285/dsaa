# OnlineQuizManagementSystem

## Folder Structure

`	ext
OnlineQuizManagementSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\quiz\app/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ QuizAttempt.java
â”‚       â”œâ”€â”€ QuizManager.java
â”‚       â”œâ”€â”€ Scorable.java
â”‚       â””â”€â”€ Scorable.java
â””â”€â”€ README.md
`

## Interfaces

- Scorable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.quiz.app.Main

## Sample Output

`	ext
=== Online Quiz Management System ===
Stored record:
QuizAttempt details printed here
`