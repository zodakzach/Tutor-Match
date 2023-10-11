package Frontend_Team_1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Login {

	private JFrame frmTutorMatch;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmTutorMatch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTutorMatch = new JFrame();
		frmTutorMatch.setTitle("Tutor Match");
		frmTutorMatch.setBounds(100, 100, 450, 300);
		frmTutorMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTutorMatch.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(10, 26, 46, 14);
		frmTutorMatch.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(83, 23, 341, 20);
		frmTutorMatch.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblPassword.setBounds(10, 64, 77, 14);
		frmTutorMatch.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("Login");
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRegister.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRegister.setBounds(282, 186, 89, 23);
		frmTutorMatch.getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancel.setBounds(48, 186, 89, 23);
		frmTutorMatch.getContentPane().add(btnCancel);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(83, 61, 341, 20);
		frmTutorMatch.getContentPane().add(txtPassword);
		
		JRadioButton circleStudent = new JRadioButton("Student");
		circleStudent.setSelected(true);
		circleStudent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		circleStudent.setBounds(53, 101, 109, 23);
		frmTutorMatch.getContentPane().add(circleStudent);
		
		JRadioButton circleTutor = new JRadioButton("Tutor");
		circleTutor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		circleTutor.setBounds(53, 134, 109, 23);
		frmTutorMatch.getContentPane().add(circleTutor);
	}

}
