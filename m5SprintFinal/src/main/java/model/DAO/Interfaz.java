package model.DAO;

import java.sql.SQLException;
import java.util.List;

import modelo.Capacitacion;

public interface Interfaz {
	
    void almacenarCapacitacion(Capacitacion capacitacion) throws SQLException;
    
    List<Capacitacion> obtenerCapacitaciones() throws SQLException;
    
}
