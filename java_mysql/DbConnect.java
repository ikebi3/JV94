import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	void con() throws SQLException {

		String url = "JDBC:mysql://localhost:3306/";
		String user = "root";
		String password = "";

		Connection con = DriverManager.getConnection(url, user, password);

		Statement sta = con.createStatement();

		String sql = "show databases;";

		ResultSet rs = sta.executeQuery(sql);

		rs.next();
		System.out.println(rs.getString(1));
	}
}