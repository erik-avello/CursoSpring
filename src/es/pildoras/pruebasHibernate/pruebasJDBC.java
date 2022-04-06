package es.pildoras.pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class pruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl = "jdbc:mysql://localhost:3306/relacioneshibernate?useSSL=false";
		String usuario = "root";
		String pass = "";
		
		try {
			
			System.out.println("Intentando conectar con la bd "+ jdbcUrl);
			Connection miConexion = DriverManager.getConnection(jdbcUrl,usuario,pass);
			System.out.println("Conexion exitosa");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
