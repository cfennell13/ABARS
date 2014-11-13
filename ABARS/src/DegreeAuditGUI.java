import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jxl.read.biff.BiffException;

/**
 * Course: SE 300- 01
 * Term: Fall 2014
 * Final Project
 * @author courtneyfennell
 * @created October 29, 2014
 */
@SuppressWarnings("serial")
public class DegreeAuditGUI extends JPanel {

	//change to JScrollPane
	//import javax.swing.JScrollPane;

	Student currStudent;
	ArrayList<GradedCourse> gradedCourses;
	ArrayList<Course> allCourses;
	CourseDatabase cd;

	int i;
	/**This is the constructor for the degree audit GUI Panel that displays the degree audit page
	 * 
	 * @param Student1
	 * @throws BiffException
	 * @throws IOException
	 */
	public DegreeAuditGUI(Student Student1) throws BiffException, IOException{
		cd = new CourseDatabase();
		currStudent = Student1;
		//get all courses
		allCourses = cd.getCourseList();
		//get graded courses
		gradedCourses = currStudent.getCoursesTaken();


		//set up the panel
		this.setLayout(new GridLayout(allCourses.size()+1, 3));
		this.add(Box.createHorizontalStrut(5));

		//add labels to columns
		this.add(new JLabel("Course Name:"));
		this.add(new JLabel("Grade:"));
		this.add(new JLabel("Credits:"));

		//display all the graded courses
		for(i = 0; i<gradedCourses.size();i++){
			this.add(Box.createHorizontalStrut(5));
			GradedCourse course =gradedCourses.get(i);

			String currCourse = course.getCourseNum();
			JLabel currLabel = new JLabel(currCourse);
			this.add(currLabel);

			JLabel currGradeLabel = new JLabel(course.getGrade());
			this.add(currGradeLabel);

			JLabel creditsLabel = new JLabel(Integer.toString(course.getCredits()));
			this.add(creditsLabel);
		}

		//continue from same spot for the rest of the courses without grades
		for(;i<allCourses.size();i++){

			this.add(Box.createHorizontalStrut(5));
			Course currCourse = allCourses.get(i);
			JLabel currLabel = new JLabel(currCourse.getCourseNum());

			//display na for classes without grades
			this.add(currLabel);
			this.add(new JLabel("NA"));

			JLabel creditsLabel = new JLabel(Integer.toString(currCourse.getCredits()));
			this.add(creditsLabel);
		}

	}

}
