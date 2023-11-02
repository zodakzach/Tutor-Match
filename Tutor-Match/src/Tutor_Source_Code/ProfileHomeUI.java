package Tutor_Source_Code;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JLabel newNameLabel;
	private JTextField newEmailTextField;
	private JLabel newEmailLabel;
	private JTextField newNameTextFIeld;
	private JLabel newPasswordLabel;
	private JPasswordField passwordField;
	private JSeparator separator;
	
	private SessionsDB master_sessions_DB = new SessionsDB("src/Databases/sessions.json");
	private List<Session> accountSessions;
	
	private int numOfSessions;
	private int totalSessionHours;

// Create the frame.
	public ProfileHomeUI(Account student_account, CourseListDB course_db) {
		this.student = student_account;

		course_database_master = course_db;

		courseList = course_database_master.getCourseList(student.getID().toString());
		
		if (student.getTutor()) {
			accountSessions = master_sessions_DB.getSessionsByTutorId(student.getID());
		}
		else {
			accountSessions = master_sessions_DB.getSessionsByStudentId(student.getID());
		}
		
		numOfSessions = accountSessions.size();
		
		for (Session session : accountSessions) {
			totalSessionHours += session.getSessionLengthHours();
		}

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
		setBounds(100, 100, 870, 606);
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
		scheduleTabPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLayeredPane layeredSchedulePane = new JLayeredPane();
		scheduleTabPanel.add(layeredSchedulePane);
		layeredSchedulePane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		layeredSchedulePane.add(panel, "name_47979929479004");
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel sessionTabPanel = new JPanel();
		sessionTabPanel.setBackground(new Color(0, 165, 255));
		sessionTabPanel.setToolTipText("View Tutors");
		studentProfileTabbedPane.addTab("", new ImageIcon(ProfileHomeUI.class.getResource("/resources/tutorIcon.png")),
				sessionTabPanel, "Schedule Tutor Session");
		sessionTabPanel.setLayout(new GridLayout(0, 1, 0, 0));

		layeredSessionPane = new JLayeredPane();
		sessionTabPanel.add(layeredSessionPane);
		layeredSessionPane.setLayout(new CardLayout(0, 0));

		scheduleSessionPanel = new JPanel();
		layeredSessionPane.add(scheduleSessionPanel, "name_47960629225894");

		JPanel accountTabPanel = new JPanel();
		accountTabPanel.setBorder(new CompoundBorder());
		accountTabPanel.setForeground(new Color(0, 0, 0));
		accountTabPanel.setBackground(new Color(255, 255, 255));
		accountTabPanel.setToolTipText("Account");
		accountTabPanel.setLayout(new CardLayout(0, 0));
		studentProfileTabbedPane.addTab("", new ImageIcon(ProfileHomeUI.class.getResource("/resources/accountIcon.png")),
				accountTabPanel, "Account");
		studentProfileTabbedPane.setBackgroundAt(3, new Color(123, 112, 116));
		
		accountLayeredPane = new JLayeredPane();
		accountLayeredPane.setBackground(new Color(0, 165, 255));
		accountTabPanel.add(accountLayeredPane, "name_704714767136400");
		accountLayeredPane.setLayout(new CardLayout(0, 0));

		accountPane = new JPanel();
		accountPane.setBackground(new Color(245, 252, 255));
		accountLayeredPane.add(accountPane, "name_46145700595681");
						GridBagLayout gbl_accountPane = new GridBagLayout();
						gbl_accountPane.columnWidths = new int[]{274, 274};
						gbl_accountPane.rowHeights = new int[]{169, 169, 174, 0};
						gbl_accountPane.columnWeights = new double[]{0.0, 0.0};
						gbl_accountPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
						accountPane.setLayout(gbl_accountPane);
								
										JLabel nameLabel = new JLabel("Name: " + student.getName());
										nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
										GridBagConstraints gbc_nameLabel = new GridBagConstraints();
										gbc_nameLabel.fill = GridBagConstraints.BOTH;
										gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
										gbc_nameLabel.gridx = 0;
										gbc_nameLabel.gridy = 0;
										accountPane.add(nameLabel, gbc_nameLabel);
						
								JLabel emailLabel = new JLabel("Email: " + student.getEmail());
								emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
								GridBagConstraints gbc_emailLabel = new GridBagConstraints();
								gbc_emailLabel.fill = GridBagConstraints.BOTH;
								gbc_emailLabel.insets = new Insets(0, 0, 5, 0);
								gbc_emailLabel.gridx = 1;
								gbc_emailLabel.gridy = 0;
								accountPane.add(emailLabel, gbc_emailLabel);
										
												JLabel numberOfSessionsLabel = new JLabel("Number of Sessions: " + numOfSessions);
												numberOfSessionsLabel.setFont(new Font("Arial", Font.BOLD, 15));
												GridBagConstraints gbc_numberOfSessionsLabel = new GridBagConstraints();
												gbc_numberOfSessionsLabel.fill = GridBagConstraints.BOTH;
												gbc_numberOfSessionsLabel.insets = new Insets(0, 0, 5, 5);
												gbc_numberOfSessionsLabel.gridx = 0;
												gbc_numberOfSessionsLabel.gridy = 1;
												accountPane.add(numberOfSessionsLabel, gbc_numberOfSessionsLabel);
								
										JLabel hoursLoggedLabel = new JLabel("Total Hours: " + totalSessionHours);
										hoursLoggedLabel.setFont(new Font("Arial", Font.BOLD, 15));
										GridBagConstraints gbc_hoursLoggedLabel = new GridBagConstraints();
										gbc_hoursLoggedLabel.fill = GridBagConstraints.BOTH;
										gbc_hoursLoggedLabel.insets = new Insets(0, 0, 5, 0);
										gbc_hoursLoggedLabel.gridx = 1;
										gbc_hoursLoggedLabel.gridy = 1;
										accountPane.add(hoursLoggedLabel, gbc_hoursLoggedLabel);
						
								editProfileButton = new JButton("Edit Profile");
								editProfileButton.setBackground(new Color(0, 170, 254));
								GridBagConstraints gbc_editProfileButton = new GridBagConstraints();
								gbc_editProfileButton.fill = GridBagConstraints.BOTH;
								gbc_editProfileButton.gridwidth = 2;
								gbc_editProfileButton.gridx = 0;
								gbc_editProfileButton.gridy = 2;
								accountPane.add(editProfileButton, gbc_editProfileButton);

		editProfilePane = new JPanel();
		editProfilePane.setForeground(new Color(251, 255, 252));
		accountLayeredPane.setLayer(editProfilePane, 0);
		editProfilePane.setBackground(new Color(0, 175, 254));
		accountLayeredPane.add(editProfilePane, "name_46145736954630");
		editProfilePane.setLayout(new GridLayout(0, 1, 0, 0));
		
		newNameLabel = new JLabel("Set Name:");
		editProfilePane.add(newNameLabel);
		
		newNameTextFIeld = new JTextField();
		editProfilePane.add(newNameTextFIeld);
		newNameTextFIeld.setColumns(10);
		
		newEmailLabel = new JLabel("Set Email:");
		editProfilePane.add(newEmailLabel);
		
		newEmailTextField = new JTextField();
		editProfilePane.add(newEmailTextField);
		newEmailTextField.setColumns(10);
		
		newPasswordLabel = new JLabel("Set Password:");
		editProfilePane.add(newPasswordLabel);
		
		passwordField = new JPasswordField();
		editProfilePane.add(passwordField);
		
		separator = new JSeparator();
		editProfilePane.add(separator);

		updateProfileButton = new JButton("Update Profile");
		updateProfileButton.setBackground(new Color(0, 165, 255));
		editProfilePane.add(updateProfileButton);
		coursesTabPanel.setLayout(new GridLayout(0, 1, 0, 0));

		layeredCoursesPane = new JLayeredPane();
		layeredCoursesPane.setForeground(new Color(0, 160, 254));
		coursesTabPanel.add(layeredCoursesPane);

//**********************************************************************************************************
		// ArrayList<Jlabel> labels = new ArrayList<Jlabel>;

//********************************************************************
		courseNames = new ArrayList<String>(); 

		if (courseList != null) {
			for (Course courses : courseList) {
				courseNames.add(courses.toString());
			}
		} else {
			courseNames.add("No Courses in Course List");
		}

		// Define an ArrayList to hold your JLabels
		courseLabels = new ArrayList<JLabel>();
		layeredCoursesPane.setLayout(new CardLayout(0, 0));
		
		myCoursesPanel = new JPanel();
		layeredCoursesPane.setLayer(myCoursesPanel, 2);
		myCoursesPanel.setBackground(new Color(247, 255, 245));
		layeredCoursesPane.add(myCoursesPanel, "name_53789701024350");
		myCoursesPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
		JLabel myCoursesLabel = new JLabel("My Courses");
		myCoursesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myCoursesLabel.setFont(new Font("Source Code Pro", Font.BOLD, 36));
		myCoursesPanel.add(myCoursesLabel);
		
		createCourseLabels();
		contentPane.setLayout(new CardLayout(0, 0));
						
		editCoursesButton = new JButton("Edit Courses");
		editCoursesButton.setForeground(new Color(0, 0, 0));
		myCoursesPanel.add(editCoursesButton);
		editCoursesButton.setFont(new Font("Arial", Font.PLAIN, 12));
		editCoursesButton.setBackground(new Color(0, 160, 254));

		editCoursesPanel = new JPanel();
		editCoursesPanel.setBackground(new Color(248, 255, 238));
		layeredCoursesPane.setLayer(editCoursesPanel, 0);
		layeredCoursesPane.add(editCoursesPanel, "name_53789718395237");
		editCoursesPanel.setLayout(new GridLayout(0, 1, 0, 5));
		
				JLabel lblNewLabel = new JLabel("Update Courses");
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBackground(new Color(0, 165, 255));
				editCoursesPanel.add(lblNewLabel);
		
		saveCourseChangesButton = new JButton("Update Courses");
		saveCourseChangesButton.setBackground(new Color(0, 165, 255));
		editCoursesPanel.add(saveCourseChangesButton);
		
				JPanel logoutTabPanel = new JPanel();
				logoutTabPanel.setBackground(new Color(0, 165, 255));
				logoutTabPanel.setToolTipText("");
				studentProfileTabbedPane.addTab("", new ImageIcon(ProfileHomeUI.class.getResource("/resources/logoutIcon.png")),
						logoutTabPanel, "Logout");
						logoutTabPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
						layeredLogoutPane = new JLayeredPane();
						layeredLogoutPane.setForeground(new Color(0, 165, 255));
						layeredLogoutPane.setBackground(new Color(0, 165, 255));
						logoutTabPanel.add(layeredLogoutPane);
								layeredLogoutPane.setLayout(new CardLayout(0, 0));
						
								logoutPanel = new JPanel();
								layeredLogoutPane.setLayer(logoutPanel, 1);
								logoutPanel.setForeground(new Color(0, 165, 255));
								logoutPanel.setBackground(new Color(0, 165, 255));
								layeredLogoutPane.add(logoutPanel, "name_46999670751652");
										logoutPanel.setLayout(new GridLayout(0, 1, 0, 0));
								
										logoutButton = new JButton("Sign Out");
										logoutButton.setForeground(new Color(0, 170, 254));
										logoutButton.setFont(new Font("Arial", Font.BOLD, 24));
										logoutButton.setBackground(new Color(0, 165, 255));
										logoutPanel.add(logoutButton);
										
												logoutConfirmPanel = new JPanel();
												logoutConfirmPanel.setBackground(new Color(0, 165, 255));
												layeredLogoutPane.setLayer(logoutConfirmPanel, 0);
												layeredLogoutPane.add(logoutConfirmPanel, "name_46999750770048");
														logoutConfirmPanel.setLayout(new GridLayout(0, 1, 0, 0));
																		
																				JLabel confirmationQuestionLabel = new JLabel("Are you sure you want to sign out?");
																				logoutConfirmPanel.add(confirmationQuestionLabel);
																				confirmationQuestionLabel.setBackground(new Color(0, 165, 255));
																				confirmationQuestionLabel.setFont(new Font("Arial", Font.BOLD, 20));
																				confirmationQuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
																						
																								confirmLogoutButton = new JButton("Yes");
																								confirmLogoutButton.setBackground(new Color(0, 165, 255));
																								logoutConfirmPanel.add(confirmLogoutButton);
																				
																						cancelLogoutButton = new JButton("No");
																						cancelLogoutButton.setBackground(new Color(0, 165, 255));
																						logoutConfirmPanel.add(cancelLogoutButton);
																		contentPane.add(studentProfileTabbedPane, "name_47726137797831");

// CHOICES
		choices = new ArrayList<Choice>();

		for (int i = 0; i < 6; i++) {
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
