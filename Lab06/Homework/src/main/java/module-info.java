module org.example.homework {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;


    opens org.example.homework to javafx.fxml;
    exports org.example.homework;
}