package curso.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Consultar {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
		Statement  st= conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM libros");
		while(rs.next()) {
			
			System.out.println("Título: "+ rs.getString(2));
			System.out.println("Autor: "+ rs.getString(3));
			System.out.println("Precio: "+ rs.getFloat(4)+"€");
			System.out.println("Fecha de publicación: "+ rs.getDate(5));
			System.out.println("");
		}
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Introduzca el titulo");
//	     String id = null;
//	     String titulo=sc.nextLine();
//	 	System.out.println("Introduzca el autor");
//	     String autor=sc.nextLine();
//	     System.out.println("Introduzca el precio");
//	     float precio=sc.nextFloat();
//	     String foto=null;
//		int insertar=st.executeUpdate("INSERT INTO libros values (id,titulo,autor,precio,null,foto)");
//		System.out.println("Filas insertadas "+ insertar);
	PreparedStatement ps=conn.prepareStatement("SELECT * FROM libros WHERE titulo=?");
	ps.setString(1, "SE LO QUE ESTAS PENSANDO");
	ResultSet rs1=ps.executeQuery();
	while(rs1.next()) {
		System.out.println("Título: "+ rs1.getString(2));
		System.out.println("Autor: "+ rs1.getString(3));
		System.out.println("Precio: "+ rs1.getFloat(4)+"€");
		System.out.println("Fecha de publicación: "+ rs1.getDate(5));
		System.out.println("");
	}
	
	CallableStatement cs= conn.prepareCall("{call ListaLibrosPorAutor(?)}");
	cs.setString(1, "John Verdon");
	ResultSet rs2=cs.executeQuery();
	while(rs2.next()) {
		System.out.println("Título: "+ rs2.getString(2).trim()+" - "+rs2.getString(3).trim()+" - "+rs2.getString(4).trim()+" - "+rs2.getString(5).trim()+"\n");
		
	}
	
	}

	
}
