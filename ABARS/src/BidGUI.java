
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import jxl.read.biff.BiffException;
/**
 * Course: SE 300- 01
 * Term: Fall 2014
 * Final Project
 * @author courtneyfennell
 * @created November 7, 2014
 */

@SuppressWarnings("serial")
public class BidGUI extends JPanel {
	Student currStudent;
	ArrayList<BidCourse> bidCourses;

	/**This panel displays all of the classes that the student has bid for before the auction runs
	 * 
	 * @param student
	 * @throws BiffException
	 * @throws IOException
	 */
	public BidGUI(Student student) throws BiffException, IOException{
		//this is where a student can drop a class

		currStudent = student;
		//TODO implement a method in Student class
		//bidCourses = currStudent.getBidCourse();

		//display all courses
		//for(int i = 0;i<bidCourses.size();i++){
		//TODO WIP

	}
/**
 * This action listener listens for the class to be chosen
 * @author courtneyfennell
 *
 */
	class DropListener implements ActionListener { // Inner class
		public void actionPerformed(ActionEvent e) {

			//currStudent.dropCourse(chosencourse);

		}
	}
}
