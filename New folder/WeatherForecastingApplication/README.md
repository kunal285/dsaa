# WeatherForecastingApplication

## Folder Structure

`	ext
WeatherForecastingApplication/
â”œâ”€â”€ src/
â”‚   â””â”€â”€ com\weather\app/
â”‚       â”œâ”€â”€ Main.java
â”‚       â”œâ”€â”€ WeatherForecast.java
â”‚       â”œâ”€â”€ ForecastManager.java
â”‚       â”œâ”€â”€ Forecastable.java
â”‚       â””â”€â”€ Forecastable.java
â””â”€â”€ README.md
`

## Interfaces

- Forecastable

## How To Run In VS Code Terminal

1. Open this project folder in VS Code.
2. Run: mkdir out
3. Compile: javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
4. Run: java -cp out com.weather.app.Main

## Sample Output

`	ext
=== Weather Forecasting Application ===
Stored record:
WeatherForecast details printed here
`