Am creat o baza de date relationala "biblioteca" folosind PostgreSQL.
Am scris un script SQL in aceasta baza de date pentru a crea doua tabele (carti si autori). In pom.xml am adaugat driver-ul bazei de date pentru  PostgreSQL in sectiunea dependencies.
Am mai creat o clasa Singleton pentru a face conexiunea la baza de date cu un URL, un USER si cu PASSWORD.
In clasa AutorDAO creez metode in care fac interogarile de care am nevoie (select, delete, insert).(Am si clasa Autor care contine id-ul si numele autorului respectiv).
In clasa Main ma conectez la baza de date, si testez interogarile implementate in clasa DAO, dupa care ma deconectez de la baza de date.