
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
import javax.swing.border.BevelBorder;
import java.awt.Button;
import javax.swing.JTextField;

public class TutorHome {

	private JFrame frmTutorMatch;
	private JFrame frmTutorMatch_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutorHome window = new TutorHome();
					window.frmTutorMatch_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TutorHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmTutorMatch_1 = new JFrame();
		frmTutorMatch_1.setTitle("Tutor Match");
		frmTutorMatch_1.setBounds(100, 100, 450, 300);
		frmTutorMatch_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTutorMatch_1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses:");
		lblNewLabel.setBounds(23, 42, 43, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSCI-3584", "CSCI-3550", "CSCI-3700", "CSCI-2400", "CSCI-2530"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(76, 38, 106, 22);
		frmTutorMatch_1.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Edit Course List");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(23, 165, 159, 23);
		frmTutorMatch_1.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tutor View");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(179, 11, 95, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1_2 = new JButton("View Students");
		btnNewButton_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1_2.setBounds(23, 131, 159, 23);
		frmTutorMatch_1.getContentPane().add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Name: ");
		lblNewLabel_2.setBounds(250, 42, 46, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ratings:");
		lblNewLabel_3.setBounds(250, 67, 46, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(300, 39, 86, 20);
		frmTutorMatch_1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 67, 86, 20);
		frmTutorMatch_1.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		frmTutorMatch_1.setJMenuBar(menuBar);
		
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
	}

}

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
import javax.swing.border.BevelBorder;
import java.awt.Button;
import javax.swing.JTextField;

public class TutorHome {

	private JFrame frmTutorMatch;
	private JFrame frmTutorMatch_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutorHome window = new TutorHome();
					window.frmTutorMatch_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TutorHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmTutorMatch_1 = new JFrame();
		frmTutorMatch_1.setTitle("Tutor Match");
		frmTutorMatch_1.setBounds(100, 100, 450, 300);
		frmTutorMatch_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTutorMatch_1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses:");
		lblNewLabel.setBounds(23, 42, 43, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSCI-3584", "CSCI-3550", "CSCI-3700", "CSCI-2400", "CSCI-2530"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(76, 38, 106, 22);
		frmTutorMatch_1.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Edit Course List");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBounds(23, 165, 159, 23);
		frmTutorMatch_1.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tutor View");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(179, 11, 95, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1_2 = new JButton("View Students");
		btnNewButton_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1_2.setBounds(23, 131, 159, 23);
		frmTutorMatch_1.getContentPane().add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Name: ");
		lblNewLabel_2.setBounds(250, 42, 46, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ratings:");
		lblNewLabel_3.setBounds(250, 67, 46, 14);
		frmTutorMatch_1.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(300, 39, 86, 20);
		frmTutorMatch_1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 67, 86, 20);
		frmTutorMatch_1.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		frmTutorMatch_1.setJMenuBar(menuBar);
		
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
	}

}
>>>>>>> 844a20f5ebea7351113ed8d9ea6a115dc0bf678e
