# SmartHomeDeviceControlSystem

## Folder Structure

`	ext
SmartHomeDeviceControlSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\smarthome\devices/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ SmartDevice.java
â”‚       â”œâ”€â”€ DeviceManager.java
â”‚       â”œâ”€â”€ Switchable.java
â”‚       â””â”€â”€ Configurable.java
â””â”€â”€ README.md
`

## Interfaces

- Switchable
- Configurable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.smarthome.devices.Main

## Sample Output

`	ext
=== Smart Home Device Control System ===
Stored record:
SmartDevice details printed here
`