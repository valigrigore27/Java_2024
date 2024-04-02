Am creat clasa PositionalGameGUI unde am cate un Label de linii si coloane pentru desenarea grilei, doua optiuni '+' si '-' oentru fiecare astfel de Label si un buton pentru crearea jocului. Am mai creat un buton de "New Game" in cazul in carte introduc de la tastatura numarul de linii si coloane. 
Apoi adaug panoul de configurare în partea de sus a root-ului. Creez o zonă de desenare (canvas) și o adaug în centrul root.

Creez butoanele de Load Save si Exit pe care le adaug in control panel.
Apoi deseez cu negru liniile orizontale si verticale in functie de numColumns si numLines date la Label.
In Main creez un obiect de tip PositionalGameGUI,creez o scenă cu elementul root al interfeței grafice și setez dimensiunile scenei la 600x600 pixeli.

Lansez aplicația JavaFX, apelând metoda launch(args).