import java.io.IOException;

import jxl.read.biff.BiffException;

/**
 * 
 * @author Courtney Fennell
 * 
 * This class acts as a starter for the entire program. It starts the program by containing the main method and running it
 *
 */
public class Starter {


	public Starter(){
		
	}
	
	public static void main(String[] args) {;
		Starter start=new Starter();
		start.createLogin();
	}
	
	public void createLogin(){
		new LoginGUI(this);
	}
	public void startMain(Student student){;
		try {
			new MainFrameGUI(student);
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
