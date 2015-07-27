import java.sql.SQLException;


public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		DbConnect dbc = new DbConnect();

		try {
			dbc.connect();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
