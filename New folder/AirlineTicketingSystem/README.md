# AirlineTicketingSystem

## Folder Structure

`	ext
AirlineTicketingSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\airline\booking/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ FlightBooking.java
â”‚       â”œâ”€â”€ AirlineManager.java
â”‚       â”œâ”€â”€ CheckIn.java
â”‚       â””â”€â”€ CheckIn.java
â””â”€â”€ README.md
`

## Interfaces

- CheckIn

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.airline.booking.Main

## Sample Output

`	ext
=== Airline Ticketing System ===
Stored record:
FlightBooking details printed here
`