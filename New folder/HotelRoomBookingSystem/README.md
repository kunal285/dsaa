# HotelRoomBookingSystem

## Folder Structure

`	ext
HotelRoomBookingSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\hotel\booking/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ HotelBooking.java
â”‚       â”œâ”€â”€ BookingManager.java
â”‚       â”œâ”€â”€ Bookable.java
â”‚       â””â”€â”€ Bookable.java
â””â”€â”€ README.md
`

## Interfaces

- Bookable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.hotel.booking.Main

## Sample Output

`	ext
=== Hotel Room Booking System ===
Stored record:
HotelBooking details printed here
`