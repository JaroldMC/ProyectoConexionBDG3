package com.example.proyectoconexionbdg3.controllers;

import com.example.proyectoconexionbdg3.ConexionBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipalController {

    @FXML
    private Label lblEstado;

    @FXML
    void probarConexion(ActionEvent event) {
        Connection con = ConexionBD.conectar();
        if (con != null) {
            if (lblEstado != null) {
                lblEstado.setText("Conectado");
            }
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "¡Conexión establecida correctamente!");
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            if (lblEstado != null) {
                lblEstado.setText("Error de conexión");
            }
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo conectar a la base de datos.");
        }
    }

    @FXML
    void obtenerEstudiante(ActionEvent event) {
        String sql = "SELECT * FROM estudiante";

        try (Connection connection = ConexionBD.conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("--- Lista de estudiantes ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");

                System.out.println(id + " | " + nombre + " | " + correo);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar estudiantes: " + e.getMessage());
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error SQL", "Ocurrió un error al consultar: " + e.getMessage());
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}