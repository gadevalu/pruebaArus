package com.testbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_TablaEmpleados {
	
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
    public void testCrearEmpleado() {
        // Código para crear un registro en la tabla
        try {
            String insertQuery = "INSERT INTO empleado (Nombre, Apellido, id_departamento, salario) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Francisco");
            preparedStatement.setString(2, "Rodriguez");
            preparedStatement.setInt(3, 1);
            preparedStatement.setInt(4, 600);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLeerEmpleado() {
        // Código para leer un registro de la tabla
        try {
            String selectQuery = "SELECT * FROM empleado WHERE Nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, "Juan");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("idEmpleado: " + resultSet.getInt("idEmpleado"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Apellido: " + resultSet.getString("Apellido"));
                System.out.println("id_departamento: " + resultSet.getInt("id_departamento"));
                System.out.println("Salario: " + resultSet.getInt("salario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testActualizarEmpleado() {
        // Código para actualizar un registro en la tabla
        try {
            String updateQuery = "UPDATE empleado SET Nombre = ?, Apellido = ?, id_departamento= ?, salario= ? WHERE idEmpleado = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "Marcos");
            preparedStatement.setString(2, "Rodriguez");
            preparedStatement.setInt(3, 2);
            preparedStatement.setInt(4, 700);
            preparedStatement.setInt(5, 2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEliminarEmpleado() {
        // Código para eliminar un registro de la tabla
        try {
            String deleteQuery = "DELETE FROM empleado WHERE idEmpleado = ?";
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
