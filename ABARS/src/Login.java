import java.io.IOException;

/**
 * 
 * @author Matthew
 * @date October 30, 2014
 * Make a Login object with the username and password as parameters
 * Then use the ValidateLogin method
 */
public class Login {
	
	private String username, password;
	
	/**
	 * @author Matthew Alpert
	 * @param username - input username
	 * @param password - input password
	 * Constructor for the login class. Must have a username and password input
	 */
	public Login(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	
	/**
	 * @author Matthew Alpert
	 * @return the student associated with the input login information
	 */
	public Student ValidateLoginStudent(){

		StudentDatabase studentDB = null;
		try {
			studentDB = new StudentDatabase(); //creates temporary student database
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return studentDB.Validate(username, password);
		
	}
	
	
	/**
	 * @author Matthew Alpert
	 * @return true if the input login information is valid, and false if the input login information is false
	 * Secondary method
	 */
	public boolean ValidateLoginBoolean(){
		
		StudentDatabase studentDB = null;
		try {
			studentDB = new StudentDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(studentDB.Validate(username, password) != null){
			return true;
		}else{
			return false;
		}
			
	}
}
