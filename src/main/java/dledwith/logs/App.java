package dledwith.logs;

public class App {
    public static void main(String[] args) {
        
    	//TODO
    	User user = new User("dledwith", "password");
    	System.out.println(Utilities.verifyString("password", user.getHashedPassword()));
    	
    }
}
