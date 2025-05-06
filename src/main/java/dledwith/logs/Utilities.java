package dledwith.logs;

import org.mindrot.jbcrypt.BCrypt;

public class Utilities {
	
	public static String hashString(String plainString) {
		String salt = BCrypt.gensalt(12);
		return BCrypt.hashpw(plainString, salt);
	}
	
	public static boolean verifyString(String plainString, String hashedString) {
		return BCrypt.checkpw(plainString, hashedString);
	}

}
