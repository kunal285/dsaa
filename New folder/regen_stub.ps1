Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'
$root = Split-Path -Parent $PSCommandPath

function Write-TextFile([string]$Path, [string]$Content) {
  $dir = Split-Path -Parent $Path
  if (-not (Test-Path $dir)) { New-Item -ItemType Directory -Path $dir -Force | Out-Null }
  [System.IO.File]::WriteAllText($Path, $Content, (New-Object System.Text.UTF8Encoding($false)))
}

function J([string]$s) { if ($null -eq $s) { return '' } ; return $s.Replace('\\','\\\\').Replace('"','\\"') }

function ProjectFiles([string]$pkg, [string]$entity, [string]$exception, [string]$iface, [string]$base, [string]$manager, [string]$main) {
  return @{
    Interface = @"
package $pkg;
public interface $iface {
    String describe();
}
"@;
    Exception = @"
package $pkg;
public class $exception extends Exception {
    public $exception(final String message) { super(message); }
}
"@;
    Base = @"
package $pkg;
public abstract class $base {
    private static int nextId = 1;
    private final int id;
    private String name;
    protected $base(final String name) throws $exception {
        if (name == null || name.trim().isEmpty()) throw new $exception("Name cannot be blank.");
        this.id = nextId++;
        this.name = name.trim();
    }
    public final int getId() { return id; }
    public final String getName() { return name; }
    public final void setName(final String name) throws $exception {
        if (name == null || name.trim().isEmpty()) throw new $exception("Name cannot be blank.");
        this.name = name.trim();
    }
    public abstract String getType();
    public String baseInfo() { return getType() + "[id=" + id + ", name=" + name + "]"; }
}
"@;
    Manager = @"
package $pkg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class $manager<T> {
    private final ArrayList<T> items = new ArrayList<>();
    public void add(final T item) { items.add(item); }
    public List<T> getAll() { return Collections.unmodifiableList(items); }
}
"@;
    Main = $main
  }
}

# Generate each project directly
$projects = @()
$projects += @{ Folder='UniversityStudentManagementSystem'; Pkg='com.university.management' }
$projects += @{ Folder='OnlineShoppingSystem'; Pkg='com.shopping.cart' }
$projects += @{ Folder='RailwayReservationSystem'; Pkg='com.railway.reservation' }
$projects += @{ Folder='EmployeePayrollManagementSystem'; Pkg='com.company.hr' }
$projects += @{ Folder='LibraryManagementSystem'; Pkg='com.library.system' }
$projects += @{ Folder='BankingSystemWithTransactionHistory'; Pkg='com.bank.accounts' }
$projects += @{ Folder='VehicleRentalSystem'; Pkg='com.rental.vehicles' }
$projects += @{ Folder='InventoryManagementSystem'; Pkg='com.inventory.stock' }
$projects += @{ Folder='HospitalAppointmentBookingSystem'; Pkg='com.hospital.appointments' }
$projects += @{ Folder='SmartHomeDeviceControlSystem'; Pkg='com.smarthome.devices' }
$projects += @{ Folder='AirlineTicketingSystem'; Pkg='com.airline.booking' }
$projects += @{ Folder='OnlineQuizManagementSystem'; Pkg='com.quiz.app' }
$projects += @{ Folder='CustomerFeedbackAndRatingSystem'; Pkg='com.feedback.system' }
$projects += @{ Folder='FoodDeliveryAppSimulation'; Pkg='com.fooddelivery.app' }
$projects += @{ Folder='ParcelTrackingSystem'; Pkg='com.parcel.tracking' }
$projects += @{ Folder='ElectricityBillGenerator'; Pkg='com.utility.billing' }
$projects += @{ Folder='EventManagementSystem'; Pkg='com.events.manager' }
$projects += @{ Folder='HotelRoomBookingSystem'; Pkg='com.hotel.booking' }
$projects += @{ Folder='LoanEligibilityChecker'; Pkg='com.finance.loans' }
$projects += @{ Folder='WeatherForecastingApplication'; Pkg='com.weather.app' }

foreach ($p in $projects) {
  $pkgPath = $p.Pkg.Replace('.', [System.IO.Path]::DirectorySeparatorChar)
  $dir = Join-Path (Join-Path $root $p.Folder) (Join-Path 'src' $pkgPath)
  New-Item -ItemType Directory -Path $dir -Force | Out-Null
}

# Explicit per-project files will be written by an embedded hashtable script below.
