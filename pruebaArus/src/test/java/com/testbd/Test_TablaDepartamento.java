package com.testbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_TablaDepartamento {
	
	private Connection connection;

    @Before
    public void setUp() {
        // Establecer la conexión a la base de datos
        String jdbcURL = "jdbc:mysql://localhost:3306/test_arus";
        String usuarioDB = "root";
        String contraseñaDB = "gio*";
        try {
            connection = DriverManager.getConnection(jdbcURL, usuarioDB, contraseñaDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCrearDepartamento() {
        // Código para crear un registro en la tabla
        try {
            String insertQuery = "INSERT INTO departamento (Nombre, Ubicacion) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Contabilidad");
            preparedStatement.setString(2, "2 piso");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLeerDepartamento() {
        // Código para leer un registro de la tabla
        try {
            String selectQuery = "SELECT * FROM departamento WHERE Nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, "Sistemas");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("iddepartamento: " + resultSet.getInt("iddepartamento"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Ubicacion: " + resultSet.getString("Ubicacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testActualizarDepartamento() {
        // Código para actualizar un registro en la tabla
        try {
            String updateQuery = "UPDATE departamento SET Nombre = ? WHERE iddepartamento = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "Cartera");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEliminarDepartamento() {
        // Código para eliminar un registro de la tabla
        try {
            String deleteQuery = "DELETE FROM departamento WHERE iddepartamento = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, 2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        // Cerrar la conexión a la base de datos
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
