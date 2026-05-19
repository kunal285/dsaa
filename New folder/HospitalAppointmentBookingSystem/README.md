# HospitalAppointmentBookingSystem

## Folder Structure

`	ext
HospitalAppointmentBookingSystem/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\hospital\appointments/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ Appointment.java
â”‚       â”œâ”€â”€ AppointmentManager.java
â”‚       â”œâ”€â”€ Schedulable.java
â”‚       â””â”€â”€ Schedulable.java
â””â”€â”€ README.md
`

## Interfaces

- Schedulable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.hospital.appointments.Main

## Sample Output

`	ext
=== Hospital Appointment Booking System ===
Stored record:
Appointment details printed here
`