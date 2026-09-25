module com.example.proyectoconexionbdg3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.proyectoconexionbdg3 to javafx.fxml;
    opens com.example.proyectoconexionbdg3.controllers to javafx.fxml;
    exports com.example.proyectoconexionbdg3.controllers to javafx.fxml;
    exports com.example.proyectoconexionbdg3;
}