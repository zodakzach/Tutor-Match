package Frontend_Team_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ComponentOrientation;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("Button.border"));

		setContentPane(contentPane);
		
		JButton lblCreateAccount = new JButton("Create Account");
		
		JLabel lblTitle = new JLabel("Tutor-Match");
		lblTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 60));
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton lblLogin = new JButton("Login");
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCreateAccount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
					.addGap(80))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(25))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCreateAccount, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
