
public class LoginInfo {
	static String username = null;
	static String password = null;
	
	LoginInfo(String username){
		this.username = username;
	}
	
	public static String getUsername() {
		return username;
	}
}
