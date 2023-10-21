package Frontend_Team_1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CourseView {

	private JFrame frmTutorMatch;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseView window = new CourseView();
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
	public CourseView() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Schedule ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(179, 11, 95, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Courses:");
		lblNewLabel.setBounds(10, 140, 56, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSCI-3584", "CSCI-3550", "CSCI-3700", "CSCI-2400", "CSCI-2530"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(62, 136, 120, 22);
		frmTutorMatch.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Remove Course");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBounds(23, 169, 159, 19);
		frmTutorMatch.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Course");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(23, 61, 159, 23);
		frmTutorMatch.getContentPane().add(btnNewButton_1);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setBounds(227, 42, 60, 14);
		frmTutorMatch.getContentPane().add(lblDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 42, 126, 146);
		frmTutorMatch.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Search:");
		lblNewLabel_2.setBounds(10, 36, 46, 14);
		frmTutorMatch.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(61, 36, 121, 20);
		frmTutorMatch.getContentPane().add(textField);
		textField.setColumns(10);
		
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
