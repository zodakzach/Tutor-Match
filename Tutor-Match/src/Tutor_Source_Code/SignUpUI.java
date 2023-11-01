package Tutor_Source_Code;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SignUpUI extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JPasswordField passwordPasswordField;
	private JTextField emailTextField;
	private JPasswordField confirmPasswordPasswordField;
	private JRadioButton studentRadioButton = new JRadioButton("Student");
	private JRadioButton tutorRadioButton = new JRadioButton("Tutor");
	private JButton signUpButton = new JButton("Sign Up");

	private static AccountDB student_database_master;
	private static CourseListDB course_database_master;

	private final ButtonGroup accountTypeButtonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */

	public SignUpUI(Point location, boolean isMaximized, AccountDB student_db, CourseListDB course_db) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 165, 255));
		contentPane.setBorder(UIManager.getBorder("Button.border"));

		if (location == null) {
			int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
			int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

			int middleX = (screenWidth - getWidth()) / 2;
			int middleY = (screenHeight - getHeight()) / 2;

			location = new Point(middleX, middleY);
		} else {
			setLocation(location.x, location.y);
		}

		if (isMaximized) {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		}

		student_database_master = student_db;
		course_database_master = course_db;

		InitComponents();

		createEvents();

	}

	public void InitComponents() {
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(277, 69, 324, 444);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		passwordPasswordField = new JPasswordField();

		JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
		confirmPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		confirmPasswordPasswordField = new JPasswordField();

		JLabel signUpLabel = new JLabel("Sign Up");
		signUpLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		signUpLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel accountTypeLabel = new JLabel("Account Type:");
		accountTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);

		accountTypeButtonGroup.add(studentRadioButton);

		accountTypeButtonGroup.add(tutorRadioButton);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup().addGap(34).addComponent(signUpButton,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addGap(35).addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(accountTypeLabel, GroupLayout.PREFERRED_SIZE, 100,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(studentRadioButton).addGap(36)
														.addComponent(tutorRadioButton))))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(confirmPasswordLabel).addComponent(passwordLabel)
										.addComponent(emailLabel)
										.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(signUpLabel, GroupLayout.PREFERRED_SIZE, 101,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordPasswordField).addComponent(confirmPasswordPasswordField)
										.addComponent(nameTextField).addComponent(emailTextField,
												GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(signUpLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(nameLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(emailLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(passwordLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(passwordPasswordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(confirmPasswordLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(confirmPasswordPasswordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(accountTypeLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(studentRadioButton)
						.addComponent(tutorRadioButton))
				.addGap(18).addComponent(signUpButton).addContainerGap(36, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.add(panel);
	}

	public void createEvents() {
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String email = emailTextField.getText();
							String password = new String(confirmPasswordPasswordField.getPassword());
							String name = nameTextField.getText();

							if (!student_database_master.isEmailTaken(email)) {
								if (tutorRadioButton.isSelected()) {
									// The "Tutor" radio button is selected.
									student_database_master.addAccount(email, password, name, true);

								} else if (studentRadioButton.isSelected()) {
									// The "Student" radio button is selected.
									student_database_master.addAccount(email, password, name, false);

								} else {
									// Neither radio button is selected.
									System.out.println("Select an Account Type");
								}

								// Checks to see if account was properly added to database before redirecting to homepage.
								if (student_database_master.isLoginValid(email, password)) {
									Account personalized_account = student_database_master.getAccountByEmail(email);

									var profileHomeUI = new ProfileHomeUI(personalized_account, course_database_master);
									profileHomeUI.setVisible(true);

									dispose();
								} else {
									System.out.println("Failed to Sign-up");
								}
							}
							else {
								System.out.println("Account registered with that email already!");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
}
