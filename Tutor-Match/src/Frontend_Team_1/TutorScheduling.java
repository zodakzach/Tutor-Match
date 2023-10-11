package Frontend_Team_1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class TutorScheduling {

	private JFrame frmTutorMatch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutorScheduling window = new TutorScheduling();
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
	public TutorScheduling() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Tutor View");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(179, 11, 95, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Students:");
		lblNewLabel.setBounds(10, 42, 56, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jimmy Randall ", "John Wick", "Bob Builder"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(62, 38, 120, 22);
		frmTutorMatch.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Remove Student");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBounds(23, 133, 159, 19);
		frmTutorMatch.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send Reminder");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(23, 165, 159, 23);
		frmTutorMatch.getContentPane().add(btnNewButton_1);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setBounds(227, 42, 60, 14);
		frmTutorMatch.getContentPane().add(lblDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 42, 126, 146);
		frmTutorMatch.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		frmTutorMatch.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("System");
		mnNewMenu.setBorderPainted(true);
		mnNewMenu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Logout");
		mnNewMenu.add(mnNewMenu_1);
	}
}
