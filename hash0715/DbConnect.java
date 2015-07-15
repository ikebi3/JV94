import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;


public class DbConnect {

	public String hash (String s) {

		byte[] input = s.getBytes();

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("md5");
		} catch(NoSuchAlgorithmException e) {

			e.printStackTrace();

		}

		byte[] hashed = md.digest(input);

		String ret = DatatypeConverter.printHexBinary(hashed);

		return ret;
	}

}
