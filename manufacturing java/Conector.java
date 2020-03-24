package manufacturing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector {
	/** 
	 * Atributos de clase 
	 */
	private static Connection con;
	private static Conector INSTANCE = null;
	
	/**
	 * Constructor
	 */
	private Conector(){ 
		
	}
	
	/**
	 * Crear instancia 
	 */
	
	private synchronized static void crearInstancia() {
		if(INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}
	
	/**
	 * Obtener instancia
	 */
	
	public static Conector getInstancia() {
		if (INSTANCE == null ) {
			crearInstancia(); 
		}
		return INSTANCE;	
	}

	/** 
	 * Crear Conexion 
	 */
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "root";
		String password = "162014290599";//Poner su password
		String dataBase = "manufacturing";
		try {
			// Importando la libreria de conexion de mysql
			Class.forName("com.mysql.jdbc.Driver");
			// Url de conexion
			String urlConexion = "jdbc:mysql://"+host+"/"+dataBase+"?user="+user+"&password="+password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste :') ");
			
		}catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
	//EJERCICIO 1
	
	public ArrayList<String> getDetails() throws SQLException {
		ArrayList<String> listaDetails = new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select *\r\n" + 
				"from invoice\r\n" + 
				"inner join clients on clients.username = invoice.clientusername and clientusername = 'nc1'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaDetails.add(rs.getString("datos"));
		}
		rs.close();
		return listaDetails;
	}
	
	
	//EJERCICIO 2
	public ArrayList<String> getMails() throws SQLException {
		ArrayList<String> listaMails = new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select email\r\n" + 
				"from employee\r\n" + 
				"inner join attendance on employee.username=attendance.empusername where (attendance.date <= 2018-09-31 or  attendance.date >= 2018-09-31)");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaMails.add(rs.getString("mails"));
		}
		rs.close();
		return listaMails;
	}
	
	
	//EJERCICIO 3
	public ArrayList<String> getInfo() throws SQLException {
		ArrayList<String> listaInfo = new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select username, password\r\n" + 
				"from users\r\n" + 
				"inner join delivery on users.username = delivery.clntusername and delivery.modeoftransport = 'Bus'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaInfo.add(rs.getString("info"));
		}
		rs.close();
		return listaInfo;
	}
	
	
}