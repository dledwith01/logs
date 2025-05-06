package dledwith.logs;

import org.mindrot.jbcrypt.BCrypt;

/**
 * A collection of miscellaneous methods.
 */
public class Utilities {
	
	/**
	 * 
	 * @param plainString String to be hashed
	 * @return an encrypted version of plainString
	 */
	public static String hashString(String plainString) {
		String salt = BCrypt.gensalt(12);
		return BCrypt.hashpw(plainString, salt);
	}
	
	/**
	 * 
	 * @param plainString
	 * @param hashedString
	 * @return If the plainString and the hashedString match, return true. Otherwise return false.
	 */
	public static boolean verifyString(String plainString, String hashedString) {
		return BCrypt.checkpw(plainString, hashedString);
	}

}
