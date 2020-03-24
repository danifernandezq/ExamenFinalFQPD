package manufacturing;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		System.out.println("Probando");
		Conector instancia = Conector.getInstancia();
		//EJERCICIO 1
		try {
			ArrayList<String> listDetails = instancia.getDetails();
			for(String datos:listDetails) {
				System.out.println(datos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//EJERCICIO 2
		try {
			ArrayList<String> listaMails = instancia.getMails();
			for(String mails:listaMails) {
				System.out.println(mails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//EJERCICIO 3
		
		try {
			ArrayList<String> listInfo = instancia.getDetails();
			for(String info:listInfo) {
				System.out.println(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}