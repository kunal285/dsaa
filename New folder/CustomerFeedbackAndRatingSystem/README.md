# CustomerFeedbackAndRatingSystem

## Folder Structure

`	ext
CustomerFeedbackAndRatingSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\feedback\system/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ CustomerFeedback.java
â”‚       â”œâ”€â”€ FeedbackManager.java
â”‚       â”œâ”€â”€ Reviewable.java
â”‚       â””â”€â”€ Reviewable.java
â””â”€â”€ README.md
`

## Interfaces

- Reviewable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.feedback.system.Main

## Sample Output

`	ext
=== Customer Feedback and Rating System ===
Stored record:
CustomerFeedback details printed here
`