package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
		   public static Connection DbConnector(){
			   String password = "12345678";
		         Connection conn = null;
		         Statement st;
		         try{
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		        }catch(Exception er_dv){
		            System.out.println("Erreur driver: "+er_dv.getMessage());
		        }
		         try{
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SENTECH?useSSL=false", "root",password);
            System.out.println("Vous etes Bien connecter à votre base de donnée");
            return conn;
        }catch(Exception err_conn){
            System.out.println("Erreur de connexion");
        }
         st=conn.createStatement();
        return null;
    }

		private Statement createStatement() {
			// TODO Auto-generated method stub
			return null;
		}

		public void getConnection() {
			// TODO Auto-generated method stub
			
		}            

    
}