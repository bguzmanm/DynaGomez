package cl.awakelab.model.cnx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection connection = null;
	
	private Conexion() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "kupita");
			
		} catch (ClassNotFoundException | SQLException e) {
				
			System.out.println("Error al conectar con la Base de Datos");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		
		if (connection == null) {
			new Conexion();
		}
		
		return connection;
	}
	
	

}
