package Tutor_Source_Code;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Tutor_Source_Code.Schedule.ACCESS;

import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.ListModel;

@SuppressWarnings("serial")
public class ProfileHomeUI extends JFrame {
	
	/*
	 * ACCOUNT RELATED
	 */
	private Account student;
	private List<Session> accountSessions;
	private Schedule schedule;
	private ArrayList<Course> courseList;
	private int numOfSessions;
	private int totalSessionHours;
	
	/*
	 * DATABASES
	 */
	private static SessionsDB sessions_DB_master = new SessionsDB("src/Databases/sessions.json");
	private static AccountDB account_DB_master = new AccountDB("src/Databases/accounts.json");
	private static CourseListDB course_database_master;

	/*
	 * BUTTONS
	 */
	private JButton confirmLogoutButton;
	private JButton cancelLogoutButton;
	private JButton logoutButton;
	private JButton editProfileButton;
	private JButton updateProfileButton;
	private JButton editCoursesButton;
	private JButton saveCourseChangesButton;
	private JButton changeAvailabilityButton;
	private JButton btnNewButton;
	
	/*
	 * PANELS
	 */
	private JPanel logoutPanel;
	private JPanel logoutConfirmPanel;
	private JPanel coursesTabPanel;
	private JPanel scheduleTabPanel;
	private JPanel editProfilePane;
	private JPanel scheduleSessionPanel;
	private JPanel changeAvailabilityPanel;
	private JPanel contentPane;
	private JPanel editCoursesPanel;
	private JPanel myCoursesPanel;
	private JPanel accountPane;

	/*
	 * LAYEREDPANES
	 */
	private JLayeredPane layeredLogoutPane;
	private JLayeredPane layeredSessionPane;
	private JLayeredPane layeredCoursesPane;
	private JLayeredPane accountLayeredPane;
	private JLayeredPane layeredSchedulePane;

	/*
	 * LABELS
	 */
	private JLabel newNameLabel;
	private JLabel newPasswordLabel;
	private JLabel newEmailLabel;
	private JLabel nameLabel;
	private JLabel emailLabel; 
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	/*
	 * LISTS
	 */
	private ArrayList<Choice> choices;
	private ArrayList<String> courseNames;
	private ArrayList<JLabel> courseLabels;
	private JList<JCheckBox> mondayList;
	private JList<JCheckBox> tuesdayList;
	private JList<JCheckBox> wednesdayList;
	private JList<JCheckBox> thursdayList;
	private JList<JCheckBox> fridayList;
	private JList<JCheckBox> saturdayList;
	private JList<JCheckBox> sundayList;

	
	/*
	 * TEXTFIELDS
	 */
	private JTextField newEmailTextField;
	private JTextField newNameTextFIeld;
	
	/*
	 * PASSFIELDS
	 */
	private JPasswordField passwordField;
	
	/*
	 * LAYOUT RELATED
	 */
	private JSeparator separator;
	private CardLayout scheduleCardLayout;	

	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	
    // Create a HashMap to store the checkboxes for each day
    HashMap<String, DefaultListModel<JCheckBox>> checkBoxModelsMap = new HashMap<>();
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;




// Create the frame.
	public ProfileHomeUI(Account student_account, CourseListDB course_db) {
		// Set the 'student' property to the provided 'student_account'
		this.student = student_account;

		// Initialize 'course_database_master' using the 'course_db' parameter
		course_database_master = course_db;

		// Retrieve the list of courses associated with the student and store it in 'courseList'
		courseList = course_database_master.getCourseList(student.getID().toString());

		// Check if the student is a tutor
		if (student.getTutor()) {
		    // If the student is a tutor, fetch their sessions and schedule
		    accountSessions = sessions_DB_master.getSessionsByTutorId(student.getID());
		    schedule = student.getSchedule();
		} else {
		    // If the student is not a tutor, fetch their sessions and set the schedule to null
		    accountSessions = sessions_DB_master.getSessionsByStudentId(student.getID());
		    schedule = null;
		}

		// Calculate the number of sessions in 'accountSessions' and store it in 'numOfSessions'
		numOfSessions = accountSessions.size();

		// Initialize 'totalSessionHours' to calculate the sum of session hours
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
				// Initialize an ArrayList to store selected courses
				ArrayList<Course> selectedCourses = new ArrayList<>();

				// Iterate through the 'choices' list
				for (Choice choice : choices) {
				    // Split the selected item's text based on white space
				    String[] selectedOption = choice.getSelectedItem().split("\\s+");

				    // Create a 'Course' object using the parsed information
				    Course course = new Course(selectedOption[0], Integer.parseInt(selectedOption[1]), selectedOption[2]);

				    // Check if the 'course' object is not null and add it to 'selectedCourses'
				    if (course != null) {
				        selectedCourses.add(course);
				    }
				}

				// Add the selected courses to a database
				course_database_master.addCourseList(student.getID().toString(), selectedCourses);

				// Update the course list from the database for the student
				courseList = course_database_master.getCourseList(student.getID().toString());

				// Clear the 'courseNames' ArrayList and populate it with course names as strings
				courseNames.clear();
				for (Course courses : courseList) {
				    courseNames.add(courses.toString());
				}

				// Remove any existing JLabel components from 'myCoursesPanel'
				for (JLabel label : courseLabels) {
				    myCoursesPanel.remove(label);
				}

				// Clear the 'courseLabels' ArrayList and create new JLabel components
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
				//Updates student account in DB with new name, email, and password.
				account_DB_master.updateAccount(student.getID(), newEmailTextField.getText(), new String(passwordField.getPassword()), newNameTextFIeld.getText());
				
				//update student account with the updated account from DB
				student = account_DB_master.getAccountById(student.getID().toString());
				

				JOptionPane.showMessageDialog(null, "Profile Updated!");
				accountLayeredPane.removeAll();
				accountLayeredPane.add(accountPane);
					
				nameLabel.setText(student.getName());
				emailLabel.setText(student.getEmail());
				
				accountLayeredPane.repaint();
				accountLayeredPane.revalidate();
			}
		});

		editProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newNameTextFIeld.setText(student.getName());
				newEmailTextField.setText(student.getEmail());
				passwordField.setText(student.getPassword());
				
				
				accountLayeredPane.removeAll();
				accountLayeredPane.add(editProfilePane);
				accountLayeredPane.repaint();
				accountLayeredPane.revalidate();
			}
		});
		
		//Button only exists for tutor accounts
		if(changeAvailabilityButton != null) 
		{
			changeAvailabilityButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scheduleCardLayout.show(layeredSchedulePane, "panel2");
				}
			});
		}
	


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

		layeredSchedulePane = new JLayeredPane();
		scheduleTabPanel.add(layeredSchedulePane);
		scheduleCardLayout = new CardLayout(0,0);
		layeredSchedulePane.setLayout(scheduleCardLayout);

		JPanel schedulePanel = new JPanel();
		layeredSchedulePane.add(schedulePanel, "panel1");
		GridBagLayout gbl_schedulePanel = new GridBagLayout();
		gbl_schedulePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_schedulePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_schedulePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_schedulePanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		schedulePanel.setLayout(gbl_schedulePanel);
		
		changeAvailabilityPanel = new JPanel();
		changeAvailabilityPanel.setBackground(new Color(244, 254, 255));
		layeredSchedulePane.add(changeAvailabilityPanel, "panel2");
		GridBagLayout gbl_changeAvailabilityPanel = new GridBagLayout();
		gbl_changeAvailabilityPanel.columnWidths = new int[]{120, 120, 120, 131, 120, 120, 120};
		gbl_changeAvailabilityPanel.rowHeights = new int[]{75, 36, 200, 0, 50};
		gbl_changeAvailabilityPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_changeAvailabilityPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		changeAvailabilityPanel.setLayout(gbl_changeAvailabilityPanel);
		
		        
		        lblNewLabel_1 = new JLabel("Weekly Availability");
		        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		        gbc_lblNewLabel_1.gridwidth = 3;
		        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		        gbc_lblNewLabel_1.gridx = 2;
		        gbc_lblNewLabel_1.gridy = 0;
		        changeAvailabilityPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		        
		        lblNewLabel_2 = new JLabel("Monday");
		        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		        gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		        gbc_lblNewLabel_2.gridx = 0;
		        gbc_lblNewLabel_2.gridy = 1;
		        changeAvailabilityPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		        
		        lblNewLabel_3 = new JLabel("Tuesday");
		        lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		        gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTH;
		        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		        gbc_lblNewLabel_3.gridx = 1;
		        gbc_lblNewLabel_3.gridy = 1;
		        changeAvailabilityPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		        
		        lblNewLabel_4 = new JLabel("Wednesday");
		        lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		        gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTH;
		        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		        gbc_lblNewLabel_4.gridx = 2;
		        gbc_lblNewLabel_4.gridy = 1;
		        changeAvailabilityPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		        
		        lblNewLabel_5 = new JLabel("Thursday");
		        lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		        gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTH;
		        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		        gbc_lblNewLabel_5.gridx = 3;
		        gbc_lblNewLabel_5.gridy = 1;
		        changeAvailabilityPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		        
		        lblNewLabel_6 = new JLabel("Friday");
		        lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		        gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTH;
		        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		        gbc_lblNewLabel_6.gridx = 4;
		        gbc_lblNewLabel_6.gridy = 1;
		        changeAvailabilityPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		        
		        lblNewLabel_7 = new JLabel("Saturday");
		        lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		        gbc_lblNewLabel_7.anchor = GridBagConstraints.SOUTH;
		        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		        gbc_lblNewLabel_7.gridx = 5;
		        gbc_lblNewLabel_7.gridy = 1;
		        changeAvailabilityPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		        
		        lblNewLabel_8 = new JLabel("Sunday");
		        lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		        gbc_lblNewLabel_8.anchor = GridBagConstraints.SOUTH;
		        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		        gbc_lblNewLabel_8.gridx = 6;
		        gbc_lblNewLabel_8.gridy = 1;
		        changeAvailabilityPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		        

		        // Days of the week
		        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

		        // Initialize checkboxes for each day
		        for (String day : daysOfWeek) 
		        {
		            DefaultListModel<JCheckBox> checkBoxModel = new DefaultListModel<>();
		            
		            for (int i = 0; i < 24; i++) 
		            {
		                JCheckBox checkBox = new JCheckBox(String.format("%02d:00", i));
		             // Add a custom property to indicate the day
		                checkBox.putClientProperty("day", day);
		                
		                checkBoxModel.addElement(checkBox);
		            }
		            checkBoxModelsMap.put(day, checkBoxModel);
		        }

		        mondayList = new JList<JCheckBox>(checkBoxModelsMap.get("Monday"));
		        mondayList.setValueIsAdjusting(true);
                mondayList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		        //int[] indices = {1, 2,3,4,5};
		        //mondayList.setSelectedIndices(indices);
		        mondayList.setVisibleRowCount(12);

		        mondayList.setCellRenderer(new CheckboxListCellRenderer());		        
		                // Allow multiple selections
		                
		                        JScrollPane scrollPane = new JScrollPane(mondayList);
		                        
		                        		GridBagConstraints gbc_list = new GridBagConstraints();
		                        		gbc_list.insets = new Insets(0, 0, 5, 5);
		                        		gbc_list.fill = GridBagConstraints.BOTH;
		                        		gbc_list.gridx = 0;
		                        		gbc_list.gridy = 2;
		                        		changeAvailabilityPanel.add(scrollPane, gbc_list);
		                        		
		                        		scrollPane_1 = new JScrollPane((Component) null);
		                        		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		                        		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		                        		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		                        		gbc_scrollPane_1.gridx = 1;
		                        		gbc_scrollPane_1.gridy = 2;
		                        		changeAvailabilityPanel.add(scrollPane_1, gbc_scrollPane_1);
		                        		
		                        		tuesdayList = new JList<JCheckBox>(checkBoxModelsMap.get("Tuesday"));
		                        		tuesdayList.setValueIsAdjusting(true);
		                        		tuesdayList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		                		        tuesdayList.setCellRenderer(new CheckboxListCellRenderer());		        

		                        		scrollPane_1.setViewportView(tuesdayList);
		                        		
		                        		scrollPane_2 = new JScrollPane((Component) null);
		                        		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		                        		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		                        		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		                        		gbc_scrollPane_2.gridx = 2;
		                        		gbc_scrollPane_2.gridy = 2;
		                        		changeAvailabilityPanel.add(scrollPane_2, gbc_scrollPane_2);
		                        		
		                        		wednesdayList = new JList<JCheckBox>(checkBoxModelsMap.get("Wednesday"));
		                        		wednesdayList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		                		        wednesdayList.setCellRenderer(new CheckboxListCellRenderer());		        

		                        		scrollPane_2.setViewportView(wednesdayList);
		                        		
		                        		scrollPane_3 = new JScrollPane((Component) null);
		                        		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		                        		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		                        		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		                        		gbc_scrollPane_3.gridx = 3;
		                        		gbc_scrollPane_3.gridy = 2;
		                        		changeAvailabilityPanel.add(scrollPane_3, gbc_scrollPane_3);
		                        		
		                        		thursdayList = new JList<JCheckBox>(checkBoxModelsMap.get("Thursday"));
		                        		thursdayList.setValueIsAdjusting(true);
		                        		thursdayList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		                		        thursdayList.setCellRenderer(new CheckboxListCellRenderer());		        

		                        		scrollPane_3.setViewportView(thursdayList);
		                        		
		                        		scrollPane_4 = new JScrollPane((Component) null);
		                        		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		                        		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 5);
		                        		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		                        		gbc_scrollPane_4.gridx = 4;
		                        		gbc_scrollPane_4.gridy = 2;
		                        		changeAvailabilityPanel.add(scrollPane_4, gbc_scrollPane_4);
		                        		
		                        		fridayList = new JList<JCheckBox>(checkBoxModelsMap.get("Friday"));
		                        		fridayList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		                		        fridayList.setCellRenderer(new CheckboxListCellRenderer());		        

		                        		scrollPane_4.setViewportView(fridayList);
		                        		
		                        		scrollPane_5 = new JScrollPane((Component) null);
		                        		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		                        		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 5);
		                        		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		                        		gbc_scrollPane_5.gridx = 5;
		                        		gbc_scrollPane_5.gridy = 2;
		                        		changeAvailabilityPanel.add(scrollPane_5, gbc_scrollPane_5);
		                        		
		                        		saturdayList = new JList<JCheckBox>(checkBoxModelsMap.get("Saturday"));
		                        		saturdayList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		                		        saturdayList.setCellRenderer(new CheckboxListCellRenderer());		        

		                        		scrollPane_5.setViewportView(saturdayList);
		                        		
		                        		scrollPane_6 = new JScrollPane((Component) null);
		                        		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		                        		gbc_scrollPane_6.insets = new Insets(0, 0, 5, 0);
		                        		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		                        		gbc_scrollPane_6.gridx = 6;
		                        		gbc_scrollPane_6.gridy = 2;
		                        		changeAvailabilityPanel.add(scrollPane_6, gbc_scrollPane_6);
		                        		
		                        		sundayList = new JList<JCheckBox>(checkBoxModelsMap.get("Sunday"));
		                        		sundayList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		                		        sundayList.setCellRenderer(new CheckboxListCellRenderer());		        

		                        		scrollPane_6.setViewportView(sundayList);
		                        		
		                        		btnNewButton_1 = new JButton("Clear Day");
		                        		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		                        		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		                        		gbc_btnNewButton_1.gridx = 0;
		                        		gbc_btnNewButton_1.gridy = 3;
		                        		changeAvailabilityPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		                        		
		                        		btnNewButton_2 = new JButton("Clear Day");
		                        		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		                        		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		                        		gbc_btnNewButton_2.gridx = 1;
		                        		gbc_btnNewButton_2.gridy = 3;
		                        		changeAvailabilityPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		                        		
		                        		btnNewButton_3 = new JButton("Clear Day");
		                        		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		                        		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		                        		gbc_btnNewButton_3.gridx = 2;
		                        		gbc_btnNewButton_3.gridy = 3;
		                        		changeAvailabilityPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		                        		
		                        		btnNewButton_4 = new JButton("Clear Day");
		                        		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		                        		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		                        		gbc_btnNewButton_4.gridx = 3;
		                        		gbc_btnNewButton_4.gridy = 3;
		                        		changeAvailabilityPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		                        		
		                        		btnNewButton_5 = new JButton("Clear Day");
		                        		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		                        		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		                        		gbc_btnNewButton_5.gridx = 4;
		                        		gbc_btnNewButton_5.gridy = 3;
		                        		changeAvailabilityPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		                        		
		                        		btnNewButton_6 = new JButton("Clear Day");
		                        		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		                        		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		                        		gbc_btnNewButton_6.gridx = 5;
		                        		gbc_btnNewButton_6.gridy = 3;
		                        		changeAvailabilityPanel.add(btnNewButton_6, gbc_btnNewButton_6);
		                        		
		                        		btnNewButton_7 = new JButton("Clear Day");
		                        		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		                        		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		                        		gbc_btnNewButton_7.gridx = 6;
		                        		gbc_btnNewButton_7.gridy = 3;
		                        		changeAvailabilityPanel.add(btnNewButton_7, gbc_btnNewButton_7);
		                        		
		                        		btnNewButton = new JButton("Save Availability");
		                        		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		                        		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		                        		gbc_btnNewButton.gridx = 3;
		                        		gbc_btnNewButton.gridy = 4;
		                        		changeAvailabilityPanel.add(btnNewButton, gbc_btnNewButton);
	

		/*
		 *  Checks to see if  account is a tutor and if so it generates the Change Availability button so that tutors can change their availabilities 
		 *  Students wont need that option
		 */
		if (student.getTutor()) {
			changeAvailabilityButton = new JButton("Change Availability");
			GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
			gbc_btnNewButton1.gridx = 13;
			gbc_btnNewButton1.gridy = 14;
			schedulePanel.add(changeAvailabilityButton, gbc_btnNewButton1);

		}

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
								
										nameLabel = new JLabel("Name: " + student.getName());
										nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
										GridBagConstraints gbc_nameLabel = new GridBagConstraints();
										gbc_nameLabel.fill = GridBagConstraints.BOTH;
										gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
										gbc_nameLabel.gridx = 0;
										gbc_nameLabel.gridy = 0;
										accountPane.add(nameLabel, gbc_nameLabel);
						
								emailLabel = new JLabel("Email: " + student.getEmail());
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

		// Inits courseNames list to hold courses as strings
		courseNames = new ArrayList<String>(); 

		/*
		 * Checks if there are courses in students courseList and if so it converts them all to strings and adds them to the courseNames list
		 * This courseNames list is used to generate the courseLabels
		 */
		if (courseList != null) {
			for (Course courses : courseList) {
				courseNames.add(courses.toString());
			}
		} else {
			courseNames.add("No Courses in Course List");
		}

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
		
		// CREATES THE COURSE LABELS FOR THE FIRST TIME WITH COURSENAMES FROM COURSELIST
		courseLabels = new ArrayList<JLabel>();
		createCourseLabels();
		//**************************************************************************
		
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
        // Retrieve the list of courses from the "ECU Course Catalog" using the 'course_database_master'
        ArrayList<Course> courses = course_database_master.getCourseList("ECU Course Catalog");

	    // Iterate through the ArrayList of Choice components
	    for (int i = 0; i < c.size(); i++) {
	    	
	        // Iterate through the retrieved list of courses
	        for (Course course : courses) {	
	            // Add the string representation of each course to the current Choice component
	            c.get(i).add(course.toString());
	        }
	    }
	}


	private void createCourseLabels() {
	    for (String courseName : courseNames) {
	        // Create a new JLabel with HTML-formatted text
	        JLabel courseLabel = new JLabel("<html><div style='text-align: center;'>" + courseName + "</div></html>");

	        // Center the text within the label
	        courseLabel.setHorizontalAlignment(SwingConstants.CENTER);

	        // Add the created label to the 'myCoursesPanel'
	        myCoursesPanel.add(courseLabel);

	        // Add the created label to the 'courseLabels' ArrayList for future reference
	        courseLabels.add(courseLabel);
	    }
	}
	
	class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer<Object> {

		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			String text = "";
			boolean state = false;
			JCheckBox checkBox = null;
			
			setComponentOrientation(list.getComponentOrientation());
			setFont(list.getFont());
			setBackground(list.getBackground());
			setForeground(list.getForeground());
			setEnabled(list.isEnabled());
			
			if (value instanceof JCheckBox) {
				checkBox = (JCheckBox) value;
				text = checkBox.getText();
				
				state = checkBoxModelsMap.get(checkBox.getClientProperty("day")).get(index).isSelected();
			}
			setText(value == null ? "" : text);
			if(isSelected) 
			{
				this.setSelected(isSelected);
				checkBoxModelsMap.get(checkBox.getClientProperty("day")).get(index).setSelected(isSelected);

			}else 
			{
				this.setSelected(state);
			}
			
			return this;
		}
	}
}

