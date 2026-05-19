# OnlineShoppingSystem

## Folder Structure

`	ext
OnlineShoppingSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\shopping\cart/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ CartItem.java
â”‚       â”œâ”€â”€ ShoppingCart.java
â”‚       â”œâ”€â”€ Discountable.java
â”‚       â””â”€â”€ Discountable.java
â””â”€â”€ README.md
`

## Interfaces

- Discountable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.shopping.cart.Main

## Sample Output

`	ext
=== Online Shopping System ===
Stored record:
CartItem details printed here
`