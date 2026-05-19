# FoodDeliveryAppSimulation

## Folder Structure

`	ext
FoodDeliveryAppSimulation/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\fooddelivery\app/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ FoodOrder.java
â”‚       â”œâ”€â”€ DeliveryManager.java
â”‚       â”œâ”€â”€ Deliverable.java
â”‚       â””â”€â”€ Deliverable.java
â””â”€â”€ README.md
`

## Interfaces

- Deliverable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.fooddelivery.app.Main

## Sample Output

`	ext
=== Food Delivery App Simulation ===
Stored record:
FoodOrder details printed here
`