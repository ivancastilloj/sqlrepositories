package curso.postgres;
import java.sql.*;

public class postgress {
	
	 public void connectDatabase() {
	        
	        try {
	            // We register the PostgreSQL driver
	            // Registramos el driver de PostgresSQL
	            try {
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException ex) {
	                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
	            }
	            Connection conn= DriverManager.getConnection(
	    		        "jdbc:postgresql://localhost:5432/libreria",
	    		        "root", "1234");
	            boolean valid = conn.isValid(50000);
	            System.out.println(valid ? "TEST OK" : "TEST FAIL");
	        } catch (java.sql.SQLException sqle) { 
	            System.out.println("Error al conectar con la base de datos de PostgreSQL");
	        }
	    }

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		postgress javaPostgreSQLBasic = new postgress();
		
        javaPostgreSQLBasic.connectDatabase();
      
		
	}

}
