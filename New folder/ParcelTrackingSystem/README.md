# ParcelTrackingSystem

## Folder Structure

`	ext
ParcelTrackingSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\parcel\tracking/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ Parcel.java
â”‚       â”œâ”€â”€ TrackingManager.java
â”‚       â”œâ”€â”€ Trackable.java
â”‚       â””â”€â”€ Trackable.java
â””â”€â”€ README.md
`

## Interfaces

- Trackable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.parcel.tracking.Main

## Sample Output

`	ext
=== Parcel Tracking System ===
Stored record:
Parcel details printed here
`