package Frontend_Team_1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

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
		setTitle("Tutor Match");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(271, 98, 107, 34);
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(65, 98, 107, 34);
		btnRegister.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Tutor Match");
		lblNewLabel.setBounds(175, 60, 117, 22);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
	}

}
