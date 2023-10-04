package Frontend_Team_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.List;

@SuppressWarnings("serial")
public class StudentHome extends JFrame 
{
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
	private ArrayList<Choice> choices;
	private String []selection;
	private String skip = "-";
	private JLabel course1Label;
	private JLabel course2Label;
	private JLabel course3Label;
	private JLabel course4Label;
	private JLabel course5Label;
	private JLabel course6Label;
	private JLabel course7Label;
	private JLabel course8Label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					StudentHome studentProfileframe = new StudentHome();
					studentProfileframe.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

// Create the frame.
    public StudentHome() 
    {
    	// Initialize components
    	initComponents();
    	
    	// Event handler
    	createEvents();
    }
    
	private void createEvents() 
	{
		logoutButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				layeredLogoutPane.removeAll();
				layeredLogoutPane.add(logoutConfirmPanel);
				layeredLogoutPane.repaint();
				layeredLogoutPane.revalidate();
			}
		});
		
		confirmLogoutButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,  "Goodbye!");
				System.exit(0);
			}
		});
		
		cancelLogoutButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				layeredLogoutPane.removeAll();
				layeredLogoutPane.add(logoutPanel);
				layeredLogoutPane.repaint();
				layeredLogoutPane.revalidate();
			}
		});

		saveCourseChangesButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				selection = new String[8];
				
				for (int i = 0; i < choices.size(); i++) 
				{
					if(choices.get(i).getSelectedItem() != skip)
					{
						selection[i] = choices.get(i).getSelectedItem();
					}
				}
				
				JOptionPane.showMessageDialog(null,  "Courses Updated!");
				layeredCoursesPane.removeAll();
				layeredCoursesPane.add(myCoursesPanel);
				layeredCoursesPane.repaint();
				layeredCoursesPane.revalidate();
			}
		});
		
		editCoursesButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				layeredCoursesPane.removeAll();
				layeredCoursesPane.add(editCoursesPanel);
				layeredCoursesPane.repaint();
				layeredCoursesPane.revalidate();
			}
		});
		
		updateProfileButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// update profile
				JOptionPane.showMessageDialog(null,  "Profile Updated!");
				accountLayeredPane.removeAll();
				accountLayeredPane.add(accountPane);
				accountLayeredPane.repaint();
				accountLayeredPane.revalidate();
			}
		});
		
		editProfileButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				accountLayeredPane.removeAll();
				accountLayeredPane.add(editProfilePane);
				accountLayeredPane.repaint();
				accountLayeredPane.revalidate();
			}
		});
	}

	private void initComponents() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentHome.class.getResource("/resources/tutorMatchIcon_v2.png")));
		setTitle("tutor.match Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 354);
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
		coursesTabPanel.setBackground(new Color(0, 165, 255));
		studentProfileTabbedPane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/coursesIcon.png")), coursesTabPanel, "My courses");
		
		scheduleTabPanel = new JPanel();
		scheduleTabPanel.setBackground(new Color(0, 165, 255));
		scheduleTabPanel.setToolTipText("View / Update Schedule");
		studentProfileTabbedPane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/calendarIcon.png")), scheduleTabPanel, "View Schedule");
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
		studentProfileTabbedPane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/tutorIcon.png")), sessionTabPanel, "Schedule Tutor Session");
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
		
		JPanel accountTabPanel = new JPanel();
		accountTabPanel.setBorder(new CompoundBorder());
		accountTabPanel.setForeground(new Color(0, 0, 0));
		accountTabPanel.setBackground(new Color(0, 165, 255));
		accountTabPanel.setToolTipText("Account");
		studentProfileTabbedPane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/accountIcon.png")), accountTabPanel, "Account");
		studentProfileTabbedPane.setForegroundAt(3, new Color(0, 165, 255));
		studentProfileTabbedPane.setBackgroundAt(3, new Color(0, 165, 255));
		
		JPanel logoutTabPanel = new JPanel();
		logoutTabPanel.setBackground(new Color(0, 165, 255));
		logoutTabPanel.setToolTipText("");
		studentProfileTabbedPane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/logoutIcon.png")), logoutTabPanel, "Logout");
		accountTabPanel.setLayout(new CardLayout(0, 0));
		
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
		profilePictureLabel.setIcon(new ImageIcon(StudentHome.class.getResource("/resources/profilePicTempIcon.png")));
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
		

		
// LAYOUT	
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(studentProfileTabbedPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(studentProfileTabbedPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		coursesTabPanel.setLayout(new CardLayout(0, 0));
		
		layeredCoursesPane = new JLayeredPane();
		coursesTabPanel.add(layeredCoursesPane, "name_702669511287000");
		
		myCoursesPanel = new JPanel();
		layeredCoursesPane.setLayer(myCoursesPanel, 2);
		myCoursesPanel.setLayout(null);
		myCoursesPanel.setBackground(new Color(0, 165, 255));
		myCoursesPanel.setBounds(0, 0, 432, 205);
		layeredCoursesPane.add(myCoursesPanel);
		
		JLabel myCoursesLabel = new JLabel("My Courses");
		myCoursesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myCoursesLabel.setFont(new Font("Source Code Pro", Font.BOLD, 36));
		myCoursesLabel.setBounds(101, 11, 220, 46);
		myCoursesPanel.add(myCoursesLabel);
		
		editCoursesButton = new JButton("Edit Courses");
		editCoursesButton.setFont(new Font("Arial", Font.PLAIN, 12));
		editCoursesButton.setBackground(new Color(0, 165, 255));
		editCoursesButton.setBounds(148, 171, 131, 23);
		myCoursesPanel.add(editCoursesButton);
		
//**********************************************************************************************************
		// ArrayList<Jlabel> labels = new ArrayList<Jlabel>;
		
//********************************************************************

		course1Label = new JLabel("Physics");
		course1Label.setBounds(82, 57, 83, 29);
		myCoursesPanel.add(course1Label);
		
		course2Label = new JLabel("Biology");
		course2Label.setBounds(82, 86, 83, 29);
		myCoursesPanel.add(course2Label);
		
		course3Label = new JLabel("Java");
		course3Label.setBounds(82, 114, 83, 29);
		myCoursesPanel.add(course3Label);
		
		course4Label = new JLabel("Web Design");
		course4Label.setBounds(82, 143, 83, 29);
		myCoursesPanel.add(course4Label);
		
		course5Label = new JLabel("Calculus");
		course5Label.setBounds(263, 57, 83, 29);
		myCoursesPanel.add(course5Label);
		
		course6Label = new JLabel("English");
		course6Label.setBounds(263, 86, 83, 29);
		myCoursesPanel.add(course6Label);
		
		course7Label = new JLabel("Astronomy");
		course7Label.setBounds(263, 114, 83, 29);
		myCoursesPanel.add(course7Label);
		
		course8Label = new JLabel("Ethics");
		course8Label.setBounds(263, 143, 83, 29);
		myCoursesPanel.add(course8Label);
		
		editCoursesPanel = new JPanel();
		editCoursesPanel.setBackground(new Color(0, 165, 255));
		layeredCoursesPane.setLayer(editCoursesPanel, 0);
		editCoursesPanel.setBounds(0, 0, 432, 205);
		layeredCoursesPane.add(editCoursesPanel);
		editCoursesPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Courses");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 165, 255));
		lblNewLabel.setBounds(80, 0, 280, 50);
		editCoursesPanel.add(lblNewLabel);
		
// CHOICES
		choices = new ArrayList<Choice>();
		
		choices.add(new Choice());
		choices.get(0).setBounds(90, 64, 82, 20);
		editCoursesPanel.add(choices.get(0));
		
		choices.add(new Choice());
		choices.get(1).setBounds(90, 90, 82, 20);
		editCoursesPanel.add(choices.get(1));
		
		choices.add(new Choice());
		choices.get(2).setBounds(90, 116, 82, 20);
		editCoursesPanel.add(choices.get(2));
		
		choices.add(new Choice());
		choices.get(3).setBounds(265, 64, 82, 20);
		editCoursesPanel.add(choices.get(3));
		
		choices.add(new Choice());
		choices.get(4).setBounds(265, 116, 82, 20);
		editCoursesPanel.add(choices.get(4));
		
		choices.add(new Choice());
		choices.get(5).setBounds(265, 90, 82, 20);
		editCoursesPanel.add(choices.get(5));
		
		choices.add(new Choice());
		choices.get(6).setBounds(90, 143, 82, 20);
		editCoursesPanel.add(choices.get(6));
		
		choices.add(new Choice());
		choices.get(7).setBounds(265, 142, 82, 20);
		editCoursesPanel.add(choices.get(7));
		
		populateChoice(choices);
		
		saveCourseChangesButton = new JButton("Update Courses");
		saveCourseChangesButton.setBackground(new Color(0, 165, 255));
		saveCourseChangesButton.setBounds(149, 171, 131, 23);
		editCoursesPanel.add(saveCourseChangesButton);

	}
	
	
	private void populateChoice(ArrayList<Choice> c)
	{
		// classes = courseList.get()
		String[] classes = {" - ", "Math", "Biology", "Science", "Health"};
		
		for (int i = 0; i < c.size(); i++) 
		{
			for(String s : classes)
			{
				c.get(i).add(s);
			}
		}
	}
}
