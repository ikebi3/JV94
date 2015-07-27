import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	public void connect() throws SQLException {

		String url = "JDBC://localhost:3306";
		String user = "root";
		String password = "";
		Connection con = DriverManager.getConnection(url, user, password);

		Statement sta = con.createStatement();
		String sql = "SELECT * FROM sales.users WHERE id=? AND pw=?;";

		PreparedStatement psta = con.prepareStatement(sql);
		psta.setString(1, "2");
		psta.setString(2, "as3456677ab3c3eaa3");

		ResultSet rs = psta.executeQuery();
		rs.next();
	}

}
