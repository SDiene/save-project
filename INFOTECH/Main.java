import connection.Connection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = Connection.DbConnector();
		conn.getConnection();
	}

}
