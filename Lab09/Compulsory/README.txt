Am adaugat in pom.xml dependenta necesara pentru hibernate.

Am creat o persistence unity utilizand Hibernate si am adaugat cele necesare in fisierul persistence.xml

Am creat clasele entitati (Author si Book) punandu-le intr-un pachet "models".

Am creat si o clasa EntityManagerFactorySingleton pentru a realiza conexiunea la baza de date.

Clasele repo sunt AuthorRepoository si BookRepository ce implementeaza metode ca si create, findById, findByName ce apeleaza metode deja implementate cum ar fi .find, .createQuery...

In clasa Main testez aplicatia prin crearea de noi carti si autori si apelarea functiilor de find pentru a gasi autori si carti dupa nume sau id.


Tema a fost realizata in echipa impreuna cu colegul meu Andriesei Beniamin-Andrei.