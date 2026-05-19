# InventoryManagementSystem

## Folder Structure

`	ext
InventoryManagementSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\inventory\stock/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ InventoryItem.java
â”‚       â”œâ”€â”€ InventoryManager.java
â”‚       â”œâ”€â”€ Storable.java
â”‚       â””â”€â”€ Storable.java
â””â”€â”€ README.md
`

## Interfaces

- Storable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.inventory.stock.Main

## Sample Output

`	ext
=== Inventory Management System ===
Stored record:
InventoryItem details printed here
`