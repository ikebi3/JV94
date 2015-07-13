import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		DbConnect d = new DbConnect();

		try {

			d.con();

		} catch(SQLException e) {

			e.printStackTrace();
		}
	}
}