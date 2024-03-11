## Structura proiectului
- `Problem.java`: Clasa principală care definește o problemă de logistică și gestionează depozitele, vehiculele și alocația clienților.
- `Depot.java`: Clasa care reprezintă un depozit și conține informații despre vehiculele sale.
- `Vehicle.java`: Clasa abstractă pentru vehiculele utilizate în sistem, cum ar fi camioanele și dronele.
- `Truck.java`: Clasa care extinde clasa Vehicle și definește comportamentul specific al camioanelor.
- `Drone.java`: Clasa care extinde clasa Vehicle și definește comportamentul specific al dronelor.
- `Client.java`: Clasa care definește clienții și informațiile asociate acestora.


### Problem
- Clasa principală care gestionează depozitele, vehiculele și clienții.
- Metode principale:
  - `addDepot(Depot depot)`: Adaugă un depozit la problemă.
  - `allocateClients(List<Client> clients)`: Alocă clienții la vehiculele disponibile.
  - Altele: `getDepots()`, `getVehicles()`, `toString()`, etc.

### Depot
- Clasa care reprezintă un depozit și conține informații despre vehiculele sale.
- Metode principale:
  - `addVehicle(Vehicle vehicle)`: Adaugă un vehicul la depozit.
  - Altele: `getName()`, `getVehicles()`, `toString()`, etc.

### Vehicle
- Clasa abstractă pentru toate tipurile de vehicule din sistem.
- Metode principale:
  - Constructor și getter/setter pentru nume, clienți, depozit și timp curent.
  - Altele: `equals()`, `hashCode()`, `toString()`, etc.

### Truck
- Clasa care extinde clasa Vehicle și definește comportamentul specific al camioanelor.
- Metode principale:
  - Constructor și getter/setter pentru capacitatea camionului.
  - Altele: Moștenite de la Vehicle.

### Drone
- Clasa care extinde clasa Vehicle și definește comportamentul specific al dronelor.
- Metode principale:
  - Constructor și getter/setter pentru durata de zbor a dronului.
  - Altele: Moștenite de la Vehicle.

### Client
- Clasa care definește clienții și informațiile asociate acestora.
- Metode principale:
  - Constructor și getter/setter pentru nume, timp de început, timp de sfârșit și tipul clientului.
  - Altele: `equals()`, `hashCode()`, `toString()`, etc.