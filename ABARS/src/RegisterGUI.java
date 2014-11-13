import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import jxl.read.biff.BiffException;

/**
 * Course: SE 300- 01
 * Term: Fall 2014
 * Final Project
 * @author courtneyfennell
 * @created October 29, 2014
 */
@SuppressWarnings("serial")
public class RegisterGUI extends JPanel {

	Student currStudent;
	ArrayList<GradedCourse> gradedCourses;
	ArrayList<Course> allCourses;
	int i = 0;
	CourseDatabase cd;
	
	//this is where a student can add a class
/** This constructor creates the panel that displays all the classes a student can choose to register for
 * 
 * @param student
 * @throws BiffException
 * @throws IOException
 */
	public RegisterGUI(Student student) throws BiffException, IOException{
		currStudent = student;
		cd = new CourseDatabase();
		allCourses = cd.getCourseList();
		gradedCourses = currStudent.getCoursesTaken();
		i = gradedCourses.size();

		//add layout manager
		this.setLayout(new GridLayout((30), 2));
		//TODO figure out how to set the layout so that it works for all students
		
		this.add(new JLabel("Course Name:"));
		this.add(new JLabel("Credits:"));

		//continue from same spot for the rest of the courses without grades
		for(;i<allCourses.size();i++){

			Course currCourse = allCourses.get(i);
			JRadioButton currLabel = new JRadioButton(currCourse.getCourseNum());


			this.add(currLabel);

			JLabel creditsLabel = new JLabel(Integer.toString(currCourse.getCredits()));
			this.add(creditsLabel);
		}
	}
}


