package Frontend_Team_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuItem;


public class StudentHome {

	private JFrame frmTutorMatch;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome window = new StudentHome();
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
	public StudentHome() {
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
		
		JLabel lblNewLabel = new JLabel("Courses:");
		lblNewLabel.setBounds(23, 42, 43, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSCI-3584", "CSCI-3550", "CSCI-3700", "CSCI-2400", "CSCI-2530"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(76, 38, 106, 22);
		frmTutorMatch.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Edit Course List");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(23, 165, 159, 23);
		frmTutorMatch.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Student View");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(170, 11, 95, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel_1);
		
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
		
		JMenu mnChangeView = new JMenu("Change View");
		mnChangeView.setBorderPainted(true);
		mnChangeView.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		menuBar.add(mnChangeView);
		
		JLabel lblNewLabel_2 = new JLabel("Name: ");
		lblNewLabel_2.setBounds(250, 42, 46, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ratings:");
		lblNewLabel_3.setBounds(250, 67, 46, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(306, 39, 86, 20);
		frmTutorMatch.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(306, 64, 86, 20);
		frmTutorMatch.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1_2 = new JButton("View Tutors");
		btnNewButton_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1_2.setBounds(23, 131, 159, 23);
		frmTutorMatch.getContentPane().add(btnNewButton_1_2);
	}
}
