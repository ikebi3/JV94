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

		String sql = "select * from hage.user;";
//		String sql = "select * from mysql.user;";
		String sqlsub = "show columns from hage.user;";

		ResultSet rs = sta.executeQuery(sql);
		ResultSet rs2 = sta.executeQuery(sqlsub);

		rs2.next();
		System.out.println(rs2.getString(1)+"|");

		while(rs.next()) {

			System.out.print(rs.getString(1)+ "|" );
			System.out.print(rs.getString(2)+ "|" );
			System.out.print(rs.getString(3)+ "|" );
			System.out.print(rs.getString(4)+ "|" );
			System.out.print(rs.getString(5)+ "|" );
			System.out.println(rs.getString(6)+ "|" );

		}
//		rs.beforeFirst();
//		while(rs.next()) {
//
//			System.out.println(rs.getString(2)+ "|" );
//		}

//		rs.next();
//		System.out.println(rs.getString(1));

	}
}