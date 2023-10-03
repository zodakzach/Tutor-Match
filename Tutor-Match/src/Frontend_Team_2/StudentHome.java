package Frontend_Team_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class StudentHome extends JFrame 
{
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					StudentHome studentProfileframe = new StudentHome();
					studentProfileframe.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
    public StudentHome() 
    {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentHome.class.getResource("/resources/tutorMatchIcon_v2.png")));
		setTitle("tutor.match");
    	// Initialize components
    	initComponents();
    	
    	// Event handler
    	createEvents();
    }
    
	private void createEvents() 
	{
		
		
	}

	private void initComponents() 
	{


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JTabbedPane studentProfilePane = new JTabbedPane(JTabbedPane.BOTTOM);
		
// PANELS
		
		JPanel coursesPanel = new JPanel();
		coursesPanel.setToolTipText("Courses\r\n");
		studentProfilePane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/coursesIcon.png")), coursesPanel, null);
		
		JPanel schedulePanel = new JPanel();
		schedulePanel.setToolTipText("View / Update Schedule");
		studentProfilePane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/calendarIcon.png")), schedulePanel, null);
		
		JPanel sessionPanel = new JPanel();
		sessionPanel.setToolTipText("View Tutors");
		studentProfilePane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/tutorIcon.png")), sessionPanel, null);
		
		JPanel accountPanel = new JPanel();
		studentProfilePane.addTab("", new ImageIcon(StudentHome.class.getResource("/resources/accountIcon.png")), accountPanel, "Account");
		
// LAYOUT	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(studentProfilePane, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
					.addGap(351))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(studentProfilePane, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addContainerGap())
		);
		

		contentPane.setLayout(gl_contentPane);
		
	}
}
