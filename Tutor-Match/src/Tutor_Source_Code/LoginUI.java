package Tutor_Source_Code;

// import org.mindrot.jbcrypt.BCrypt;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class LoginUI extends JFrame 
{
	private static AccountDB student_database_master;
	private static CourseListDB course_database_master;
	
	private String login_email;
	private String login_password;
	
	private JPanel mainPanel;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private static boolean isMaximized;
	private JButton signUpButton;
	private JButton loginButton;
	private static LoginUI mainFrame;
	
//	protected static AccountDatabase student_database;
//	protected static GetCourseList course_database;

/*
 * Main Function
 */
	public static void __PROGRAM_INIT__(AccountDB student_db, CourseListDB course_db) 
	{
		student_database_master = student_db;
		course_database_master = course_db;
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					mainFrame = new LoginUI();
					mainFrame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Constructor
	 */
	public LoginUI() 
	{
		// Initialize components
		initComponents();

		// Doesn't work yet, but the idea is to check the state of the window to set
		// isMaximized to true or false.
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowStateChanged(WindowEvent e) 
			{
				// Check if the window is maximized
				if ((e.getNewState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) 
				{
					isMaximized = true;
				} 
				else 
				{
					isMaximized = false;
				}
			}
		});

		// Event handler
		createEvents();
	}

/*
 * ******************************************************************** 
 * This method contains all of the code for creating and initializing components
 */
	private void initComponents() 
	{
		setTitle("tutor.match");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(LoginUI.class.getResource("/resources/tutorMatchIcon_v2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 622);
		setFont(new Font("Source Serif Pro", Font.BOLD, 12));

// PANELS

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 165, 255));
		mainPanel.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(mainPanel);

		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

// LABELS

		JLabel signUpLabel = new JLabel("Don't have an account?");
		signUpLabel.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel titleLabel = new JLabel("tutor.match");
		titleLabel.setForeground(new Color(0, 165, 255));
		titleLabel.setFont(new Font("Source Serif Pro", Font.BOLD, 44));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

// TEXT FIELDS **********************************************************************

		emailTextField = new JTextField();
		
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		emailTextField.setColumns(10);

		passwordField = new JPasswordField();
		
		passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
		

// BUTTONS

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Arial", Font.BOLD, 12));

		signUpButton = new JButton("Sign Up");
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setFont(new Font("Arial", Font.BOLD, 12));
		signUpButton.setBorderPainted(false);
		signUpButton.setHorizontalTextPosition(SwingConstants.LEFT);
		signUpButton.setHorizontalAlignment(SwingConstants.LEFT);

// LAYOUT             
		GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
		loginPanelLayout.setHorizontalGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(loginPanelLayout.createSequentialGroup().addGroup(loginPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(loginPanelLayout.createSequentialGroup().addGap(6).addComponent(titleLabel,
								GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
						.addGroup(loginPanelLayout.createSequentialGroup().addGap(35).addGroup(loginPanelLayout
								.createParallelGroup(Alignment.LEADING).addComponent(emailLabel)
								.addGroup(loginPanelLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(passwordLabel)
												.addGroup(loginPanelLayout
														.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(emailTextField, Alignment.LEADING)
														.addGroup(Alignment.LEADING, loginPanelLayout
																.createSequentialGroup().addComponent(signUpLabel)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(signUpButton).addGap(12))
														.addComponent(loginButton, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
														.addComponent(passwordField, Alignment.LEADING)))))
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGap(0)));
		loginPanelLayout.setVerticalGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(loginPanelLayout.createSequentialGroup().addGap(14)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE).addGap(32)
						.addComponent(emailLabel).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(passwordLabel).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(32)
						.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(36).addGroup(loginPanelLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(signUpLabel).addComponent(signUpButton))
						.addContainerGap(93, Short.MAX_VALUE)));
		loginPanel.setLayout(loginPanelLayout);
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel
				.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_mainPanel.createSequentialGroup().addGap(289).addComponent(loginPanel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(244, Short.MAX_VALUE)));
		gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup().addGap(60)
						.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(100, Short.MAX_VALUE)));
		mainPanel.setLayout(gl_mainPanel);
	}

/*
 * *************************************************************************
 * This method contains all of the code for creating events
 */
	private void createEvents() {

// BUTTONS

		loginButton.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) 
			{
				
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							login_email = emailTextField.getText();
							login_password = new String(passwordField.getPassword());
																	
							if(student_database_master.isLoginValid(login_email, login_password))
							{
				// **************************************************************************
				// Here is where we could check tutor boolean so we display tutor profile
								Account personalized_account = student_database_master.getAccountByEmail(login_email);
								
								var profileHomeUI = new ProfileHomeUI(personalized_account, course_database_master);
								profileHomeUI.setVisible(true);
								
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Incorrect Login Information!");
							}
							
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				});
				
			}
		});

		signUpButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Point location = getLocationOnScreen();
				System.out.println(getExtendedState());
				
				SignUpUI signUpPage = new SignUpUI(location, isMaximized, student_database_master, course_database_master);
				dispose();
				signUpPage.setVisible(true);
			}
		});
	}

}
