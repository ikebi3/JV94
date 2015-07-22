import java.sql.SQLException;

public class DBC {

	public static void main(String[] args) {

		DbConnect dbc = new DbConnect();

		try {

			dbc.connect();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}