# VehicleRentalSystem

## Folder Structure

`	ext
VehicleRentalSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\rental\vehicles/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ Vehicle.java
â”‚       â”œâ”€â”€ RentalManager.java
â”‚       â”œâ”€â”€ Rentable.java
â”‚       â””â”€â”€ Rentable.java
â””â”€â”€ README.md
`

## Interfaces

- Rentable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.rental.vehicles.Main

## Sample Output

`	ext
=== Vehicle Rental System ===
Stored record:
Vehicle details printed here
`