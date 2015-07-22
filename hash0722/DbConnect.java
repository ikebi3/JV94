import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.DatatypeConverter;

public class DbConnect {

	void connect() throws SQLException {

		String url = "JDBC:mysql://localhost:3306";
		String user = "root";
		String password = "";

		Connection con = DriverManager.getConnection(url, user, password);
		Statement sta = con.createStatement();
		String sql = "SHOW DATABASES;";
		ResultSet rs = sta.executeQuery(sql);

		hash("aaa","bbb");

		System.out.println("ttt01");
	}

	String hash(String userPw, String salt) {
		byte[] b = (userPw+salt).getBytes();

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		byte[] pwhash = md.digest(b);
		String ret = DatatypeConverter.printHexBinary(pwhash);

		return ret.toLowerCase();
	}
}