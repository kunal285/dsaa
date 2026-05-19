# RailwayReservationSystem

## Folder Structure

`	ext
RailwayReservationSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\railway\reservation/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ Ticket.java
â”‚       â”œâ”€â”€ ReservationManager.java
â”‚       â”œâ”€â”€ Reservable.java
â”‚       â””â”€â”€ Reservable.java
â””â”€â”€ README.md
`

## Interfaces

- Reservable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.railway.reservation.Main

## Sample Output

`	ext
=== Railway Reservation System ===
Stored record:
Ticket details printed here
`