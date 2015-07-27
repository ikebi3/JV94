import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.DatatypeConverter;


public class DbConnect {

	public void connect() throws SQLException {


		String url = "JDBC://localhost:3306";
		String user = "root";
		String password = "";
		String userid = "6";
		String userpw = "aaa";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println(con);
		Statement sta = con.createStatement();
		String sql = "SELECT id FROM sales.users WHERE id=" + userid + ";";

		ResultSet rs = sta.executeQuery(sql);
		rs.next();
		String salt = rs.getString(4);
		String hashedpw = hash(userpw+salt);
		sql = "SELECT * FROM sales.users WHERE id=" + userid + "AND pw=\'" + hashedpw + "\';";
		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getString(3));
	}

	public String hash(String s) {

		byte[] input = s.getBytes();

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("md5");

		} catch(NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		byte[] hashed = md.digest(input);

		String ret = DatatypeConverter.printHexBinary(hashed);
		return ret.toLowerCase();

	}
}
