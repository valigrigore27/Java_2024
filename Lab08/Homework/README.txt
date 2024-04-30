Am creat un model orientat pe obiecte al datelor, prin crearea celor doua clase Autor.java su Book.java.
Apoi am implementat si cealalta calasa DAO (Book) care are aceleasi functionalitati ca si Autor si anume metode de extragere a tuturor cartilor din databse, de stergere a cartilor, adaugarea unei carti...
Am utilizat un pool de conexiuni (Apache Commons DBCP) adaugand dependentele necesare in pom.xml si am creat si clasa DatabaseConnectionPool pentru a realiza conexiunea la baza de date.

CsvDataImporter este o clasa ce aextrage liniile din fisierul csv pe care il am in proiect si face parsarea acestora prin virgula pastrand doar coloanele de care am nevoie pentru a crea obiecte pe care sa le pun in baza mea de date.

Tema a fost realizata in echipa impreuna cu colegul meu Andriesei Beniamin-Andrei.