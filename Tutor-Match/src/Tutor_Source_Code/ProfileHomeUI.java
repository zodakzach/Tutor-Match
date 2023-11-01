package Tutor_Source_Code;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ProfileHomeUI extends JFrame {
	private ArrayList<Choice> choices;
	private Account student;

	private JPanel contentPane;
	private JButton confirmLogoutButton;
	private JButton cancelLogoutButton;
	private JButton logoutButton;
	private JLayeredPane layeredLogoutPane;
	private JPanel logoutPanel;
	private JPanel logoutConfirmPanel;
	private JPanel coursesTabPanel;
	private JPanel scheduleTabPanel;
	private JLayeredPane layeredSessionPane;
	private JButton saveCourseChangesButton;
	private JLayeredPane layeredCoursesPane;
	private JButton editCoursesButton;
	private JPanel editCoursesPanel;
	private JPanel myCoursesPanel;
	private JLayeredPane accountLayeredPane;
	private JPanel accountPane;
	private JButton editProfileButton;
	private JButton updateProfileButton;
	private JPanel editProfilePane;
	private JPanel scheduleSessionPanel;
	private static CourseListDB course_database_master;

	private ArrayList<Course> courseList;
	private ArrayList<String> courseNames;
	private ArrayList<JLabel> courseLabels;

// Create the frame.
	public ProfileHomeUI(Account student_account, CourseListDB course_db) {
		this.student = student_account;

		course_database_master = course_db;

		courseList = course_database_master.getCourseList(student.getID().toString());

		// Initialize components
		initComponents();

		// Event handler
		createEvents();
	}

	private void createEvents() {
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredLogoutPane.removeAll();
				layeredLogoutPane.add(logoutConfirmPanel);
				layeredLogoutPane.repaint();
				layeredLogoutPane.revalidate();
			}
		});

		confirmLogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Goodbye!");
				System.exit(0);
			}
		});

		cancelLogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredLogoutPane.removeAll();
				layeredLogoutPane.add(logoutPanel);
				layeredLogoutPane.repaint();
				layeredLogoutPane.revalidate();
			}
		});

		saveCourseChangesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Course> selectedCourses = new ArrayList<>();

				for (Choice choice : choices) {
					String[] selectedOption = choice.getSelectedItem().split("\\s+");

					Course course = new Course(selectedOption[0], Integer.parseInt(selectedOption[1]),
							selectedOption[2]);

					if (course != null) {
						selectedCourses.add(course);
					}
				}

				course_database_master.addCourseList(student.getID().toString(), selectedCourses);
				
				courseList = course_database_master.getCourseList(student.getID().toString());
				
				courseNames.clear();
				for (Course courses : courseList) {
					courseNames.add(courses.toString());
				}
				for (JLabel label : courseLabels) {
					myCoursesPanel.remove(label);
				}
				courseLabels.clear();
				createCourseLabels();
				
				JOptionPane.showMessageDialog(null, "Courses Updated!");
				layeredCoursesPane.removeAll();
				layeredCoursesPane.add(myCoursesPanel);
				layeredCoursesPane.repaint();
				layeredCoursesPane.revalidate();
				myCoursesPanel.revalidate();
			}
		});

		editCoursesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredCoursesPane.removeAll();
				layeredCoursesPane.add(editCoursesPanel);
				layeredCoursesPane.repaint();
				layeredCoursesPane.revalidate();
			}
		});

		updateProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update profile
				JOptionPane.showMessageDialog(null, "Profile Updated!");
				accountLayeredPane.removeAll();
				accountLayeredPane.add(accountPane);
				accountLayeredPane.repaint();
				accountLayeredPane.revalidate();
			}
		});

		editProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountLayeredPane.removeAll();
				accountLayeredPane.add(editProfilePane);
				accountLayeredPane.repaint();
				accountLayeredPane.revalidate();
			}
		});

	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ProfileHomeUI.class.getResource("/resources/tutorMatchIcon_v2.png")));
		setTitle("tutor.match Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 165, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

// PANELS

		JTabbedPane studentProfileTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		studentProfileTabbedPane.setBorder(null);
		studentProfileTabbedPane.setBackground(new Color(0, 165, 255));

		coursesTabPanel = new JPanel();
		coursesTabPanel.setToolTipText("My Courses");
		coursesTabPanel.setForeground(new Color(0, 0, 0));
		coursesTabPanel.setBackground(new Color(0, 160, 254));
		studentProfileTabbedPane.addTab("",
				new ImageIcon(ProfileHomeUI.class.getResource("/resources/coursesIcon.png")), coursesTabPanel,
				"My courses");

		scheduleTabPanel = new JPanel();
		scheduleTabPanel.setBackground(new Color(0, 165, 255));
		scheduleTabPanel.setToolTipText("View / Update Schedule");
		studentProfileTabbedPane.addTab("",
				new ImageIcon(ProfileHomeUI.class.getResource("/resources/calendarIcon.png")), scheduleTabPanel,
				"View Schedule");
		scheduleTabPanel.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredSchedulePane = new JLayeredPane();
		scheduleTabPanel.add(layeredSchedulePane, "name_704146260075500");

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 422, 205);
		layeredSchedulePane.add(panel);
		panel.setLayout(null);

		JPanel sessionTabPanel = new JPanel();
		sessionTabPanel.setBackground(new Color(0, 165, 255));
		sessionTabPanel.setToolTipText("View Tutors");
		studentProfileTabbedPane.addTab("", new ImageIcon(ProfileHomeUI.class.getResource("/resources/tutorIcon.png")),
				sessionTabPanel, "Schedule Tutor Session");
		sessionTabPanel.setLayout(new CardLayout(0, 0));

		layeredSessionPane = new JLayeredPane();
		sessionTabPanel.add(layeredSessionPane, "name_698607889984400");
		layeredSessionPane.setLayout(null);

		scheduleSessionPanel = new JPanel();
		scheduleSessionPanel.setBounds(0, 0, 422, 205);
		layeredSessionPane.add(scheduleSessionPanel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-10056, -10038, 422, 205);
		layeredSessionPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(-10056, -10038, 422, 205);
		layeredSessionPane.add(panel_2);

		JPanel logoutTabPanel = new JPanel();
		logoutTabPanel.setBackground(new Color(0, 165, 255));
		logoutTabPanel.setToolTipText("");
		studentProfileTabbedPane.addTab("", new ImageIcon(ProfileHomeUI.class.getResource("/resources/logoutIcon.png")),
				logoutTabPanel, "Logout");
		logoutTabPanel.setLayout(new CardLayout(0, 0));

		layeredLogoutPane = new JLayeredPane();
		layeredLogoutPane.setForeground(new Color(0, 165, 255));
		layeredLogoutPane.setBackground(new Color(0, 165, 255));
		logoutTabPanel.add(layeredLogoutPane, "name_700723181025100");

		logoutPanel = new JPanel();
		layeredLogoutPane.setLayer(logoutPanel, 1);
		logoutPanel.setForeground(new Color(0, 165, 255));
		logoutPanel.setBackground(new Color(0, 165, 255));
		logoutPanel.setBounds(0, 0, 432, 205);
		layeredLogoutPane.add(logoutPanel);
		logoutPanel.setLayout(null);

		logoutButton = new JButton("Sign Out");
		logoutButton.setBounds(122, 49, 192, 109);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Arial", Font.BOLD, 24));
		logoutButton.setBackground(new Color(0, 165, 255));
		logoutPanel.add(logoutButton);

		logoutConfirmPanel = new JPanel();
		logoutConfirmPanel.setBackground(new Color(0, 165, 255));
		layeredLogoutPane.setLayer(logoutConfirmPanel, 0);
		logoutConfirmPanel.setBounds(0, 0, 432, 205);
		layeredLogoutPane.add(logoutConfirmPanel);
		logoutConfirmPanel.setLayout(null);

		confirmLogoutButton = new JButton("Yes");
		confirmLogoutButton.setBackground(new Color(0, 165, 255));
		confirmLogoutButton.setBounds(84, 122, 89, 23);
		logoutConfirmPanel.add(confirmLogoutButton);

		cancelLogoutButton = new JButton("No");
		cancelLogoutButton.setBackground(new Color(0, 165, 255));
		cancelLogoutButton.setBounds(265, 122, 89, 23);
		logoutConfirmPanel.add(cancelLogoutButton);

		JLabel confirmationQuestionLabel = new JLabel("Are you sure you want to sign out?");
		confirmationQuestionLabel.setBackground(new Color(0, 165, 255));
		confirmationQuestionLabel.setFont(new Font("Arial", Font.BOLD, 20));
		confirmationQuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmationQuestionLabel.setBounds(23, 34, 399, 65);
		logoutConfirmPanel.add(confirmationQuestionLabel);

		JPanel accountTabPanel = new JPanel();
		accountTabPanel.setBorder(new CompoundBorder());
		accountTabPanel.setForeground(new Color(0, 0, 0));
		accountTabPanel.setBackground(new Color(0, 165, 255));
		accountTabPanel.setToolTipText("Account");
		accountTabPanel.setLayout(new CardLayout(0, 0));
		studentProfileTabbedPane.addTab("", new ImageIcon(ProfileHomeUI.class.getResource("/resources/accountIcon.png")),
				accountTabPanel, "Account");
		
		accountLayeredPane = new JLayeredPane();
		accountTabPanel.add(accountLayeredPane, "name_704714767136400");

		accountPane = new JPanel();
		accountPane.setBackground(new Color(0, 165, 255));
		accountPane.setBounds(0, 0, 422, 205);
		accountLayeredPane.add(accountPane);
		accountPane.setLayout(null);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(44, 32, 48, 18);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
		accountPane.add(nameLabel);

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(44, 74, 46, 18);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
		accountPane.add(emailLabel);

		JLabel profilePicLabel = new JLabel("[Profile Picture]");
		profilePicLabel.setHorizontalAlignment(SwingConstants.CENTER);
		profilePicLabel.setBounds(305, 128, 82, 14);
		profilePicLabel.setFont(new Font("Arial", Font.ITALIC, 12));
		accountPane.add(profilePicLabel);

		JLabel profilePictureLabel = new JLabel("");
		profilePictureLabel
				.setIcon(new ImageIcon(ProfileHomeUI.class.getResource("/resources/profilePicTempIcon.png")));
		profilePictureLabel.setBounds(313, 62, 99, 55);
		profilePictureLabel.setBackground(Color.WHITE);
		accountPane.add(profilePictureLabel);

		JLabel hoursLoggedLabel = new JLabel("Total Hours: ");
		hoursLoggedLabel.setBounds(43, 114, 91, 18);
		hoursLoggedLabel.setFont(new Font("Arial", Font.BOLD, 15));
		accountPane.add(hoursLoggedLabel);

		JLabel numberOfSessionsLabel = new JLabel("Number of Sessions: ");
		numberOfSessionsLabel.setBounds(44, 154, 151, 18);
		numberOfSessionsLabel.setFont(new Font("Arial", Font.BOLD, 15));
		accountPane.add(numberOfSessionsLabel);

		editProfileButton = new JButton("Edit Profile");
		editProfileButton.setBackground(new Color(0, 165, 255));
		editProfileButton.setBounds(288, 171, 106, 23);
		accountPane.add(editProfileButton);

		editProfilePane = new JPanel();
		accountLayeredPane.setLayer(editProfilePane, 0);
		editProfilePane.setBackground(new Color(0, 165, 255));
		editProfilePane.setBounds(0, 0, 422, 205);
		accountLayeredPane.add(editProfilePane);
		editProfilePane.setLayout(null);

		updateProfileButton = new JButton("Update Profile");
		updateProfileButton.setBackground(new Color(0, 165, 255));
		updateProfileButton.setBounds(158, 171, 117, 23);
		editProfilePane.add(updateProfileButton);

// LAYOUT	

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(studentProfileTabbedPane, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(studentProfileTabbedPane, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
					.addGap(33))
		);
		contentPane.setLayout(gl_contentPane);
		coursesTabPanel.setLayout(null);

		layeredCoursesPane = new JLayeredPane();
		layeredCoursesPane.setForeground(new Color(0, 160, 254));
		layeredCoursesPane.setBounds(0, 0, 529, 292);
		coursesTabPanel.add(layeredCoursesPane);

//**********************************************************************************************************
		// ArrayList<Jlabel> labels = new ArrayList<Jlabel>;

//********************************************************************
		courseNames = new ArrayList<String>(); // Replace with your actual list of course names

		if (courseList != null) {
			for (Course courses : courseList) {
				courseNames.add(courses.toString());
			}
		} else {
			courseNames.add("No Courses in Course List");
		}

		// Define an ArrayList to hold your JLabels
		courseLabels = new ArrayList<JLabel>();
		
		myCoursesPanel = new JPanel();
		layeredCoursesPane.setLayer(myCoursesPanel, 2);
		myCoursesPanel.setBackground(new Color(247, 255, 245));
		myCoursesPanel.setBounds(0, 0, 529, 294);
		layeredCoursesPane.add(myCoursesPanel);
		myCoursesPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
		JLabel myCoursesLabel = new JLabel("My Courses");
		myCoursesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myCoursesLabel.setFont(new Font("Source Code Pro", Font.BOLD, 36));
		myCoursesPanel.add(myCoursesLabel);
		
		createCourseLabels();
						
		editCoursesButton = new JButton("Edit Courses");
		editCoursesButton.setForeground(new Color(0, 0, 0));
		myCoursesPanel.add(editCoursesButton);
		editCoursesButton.setFont(new Font("Arial", Font.PLAIN, 12));
		editCoursesButton.setBackground(new Color(0, 160, 254));

		editCoursesPanel = new JPanel();
		editCoursesPanel.setBackground(new Color(248, 255, 238));
		layeredCoursesPane.setLayer(editCoursesPanel, 0);
		editCoursesPanel.setBounds(0, 0, 529, 294);
		layeredCoursesPane.add(editCoursesPanel);
		editCoursesPanel.setLayout(new GridLayout(0, 1, 0, 5));
		
				JLabel lblNewLabel = new JLabel("Update Courses");
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBackground(new Color(0, 165, 255));
				editCoursesPanel.add(lblNewLabel);
		
		saveCourseChangesButton = new JButton("Update Courses");
		saveCourseChangesButton.setBackground(new Color(0, 165, 255));
		editCoursesPanel.add(saveCourseChangesButton);

// CHOICES
		choices = new ArrayList<Choice>();

		for (int i = 0; i < 8; i++) {
		    Choice choice = new Choice();
		    editCoursesPanel.add(choice);
		    choices.add(choice);
		}

		populateChoice(choices);

	}

	private void populateChoice(ArrayList<Choice> c) {
		for (int i = 0; i < c.size(); i++) {
			for (Course course : course_database_master.getCourseList("ECU Course Catalog")) {
				c.get(i).add(course.toString());
			}
		}
	}

	private void createCourseLabels() {
		for (String courseName : courseNames) {
			JLabel courseLabel = new JLabel("<html><div style='text-align: center;" + "px;'>" + courseName + "</div></html>");

		    courseLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
			myCoursesPanel.add(courseLabel);

			// Add the created label to the ArrayList for future reference
			courseLabels.add(courseLabel);
		}
	}
}
