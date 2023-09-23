package Frontend_Team_2;

import java.awt.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class SignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public SignUpPage(Point location, boolean isMaximized) {

		if (isMaximized) {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		}

	
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

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(277, 69, 324, 444);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);

		passwordField = new JPasswordField();

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Name:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);

		passwordField_1 = new JPasswordField();

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Account Type:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
		buttonGroup.add(rdbtnNewRadioButton);

		JRadioButton rdbtnTutor = new JRadioButton("Tutor");
		buttonGroup.add(rdbtnTutor);

		JButton btnNewButton = new JButton("Sign Up");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup().addGap(34).addComponent(btnNewButton,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(35).addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 100,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(rdbtnNewRadioButton).addGap(36)
														.addComponent(rdbtnTutor))))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1_1_1).addComponent(lblNewLabel_1_1)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textField)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
										.addComponent(passwordField).addComponent(passwordField_1)))))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1_2)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1_1_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1_1_1_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnTutor))
						.addGap(18).addComponent(btnNewButton).addContainerGap(21, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.add(panel);
	}

}
