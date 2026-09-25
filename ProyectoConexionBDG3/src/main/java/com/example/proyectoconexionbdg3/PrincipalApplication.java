package com.example.proyectoconexionbdg3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class PrincipalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Connection con = ConexionBD.conectar();

        FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("principal.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Prueba de conexion BD");
        stage.setScene(scene);
        stage.show();
    }
}