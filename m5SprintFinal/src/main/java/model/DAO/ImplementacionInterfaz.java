package model.DAO;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Capacitacion;
import conexion.ConexionDB;

public class ImplementacionInterfaz implements Interfaz {
	
    private Connection conn;

    public ImplementacionInterfaz() throws SQLException {
        this.conn = ConexionDB.getConnection();  // Usamos la clase Conexion
    }
    
    @Override
    public void almacenarCapacitacion(Capacitacion capacitacion) throws SQLException {
        String sql = "INSERT INTO capacitaciones (nombre, detalle) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, capacitacion.getNombreCapacitacion());
            statement.setString(2, capacitacion.getDetalleCapacitacion());
            statement.executeUpdate();
        }
    }
    
    

    @Override
    public List<Capacitacion> obtenerCapacitaciones() throws SQLException {
        List<Capacitacion> capacitaciones = new ArrayList<>();
        String sql = "SELECT * FROM capacitaciones";
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
            	Capacitacion capacitacion = new Capacitacion();
                capacitacion.setIdCapacitacion(resultSet.getInt("id"));
                capacitacion.setNombreCapacitacion(resultSet.getString("nombre"));
                capacitacion.setDetalleCapacitacion(resultSet.getString("detalle"));

                capacitaciones.add(capacitacion);
            }
        }
        return capacitaciones;
    }


}


	
    

