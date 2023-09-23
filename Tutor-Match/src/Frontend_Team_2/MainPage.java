package Frontend_Team_2;
import java.awt.*;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

    private JPanel mainPanel;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private boolean isMaximized;

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

    public MainPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 876, 622);
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0, 165, 255));
        mainPanel.setBorder(UIManager.getBorder("Button.border"));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(277, 69, 324, 444);

        JLabel titleLabel = new JLabel("Tutor-Match");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        emailTextField = new JTextField();
        emailTextField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        JLabel signUpLabel = new JLabel("Don't have an account?");

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Point location = getLocationOnScreen();
                System.out.println(getExtendedState());
                SignUpPage signUpPage = new SignUpPage(location, isMaximized);
                signUpPage.setVisible(true);

                // Close the LoginPage
                dispose();
            }
        });
        
        signUpButton.setBorderPainted(false);
        signUpButton.setHorizontalTextPosition(SwingConstants.LEFT);
        signUpButton.setHorizontalAlignment(SwingConstants.LEFT);
        
        GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup().addGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(loginPanelLayout.createSequentialGroup().addGap(6).addComponent(titleLabel,
                        GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                .addGroup(loginPanelLayout.createSequentialGroup().addGap(35).addGroup(loginPanelLayout
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup().addComponent(emailLabel)
                                .addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE))
                        .addGroup(loginPanelLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(loginPanelLayout.createSequentialGroup().addComponent(passwordLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED, 213,
                                                        Short.MAX_VALUE))
                                        .addGroup(loginPanelLayout.createSequentialGroup().addComponent(signUpLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(signUpButton))
                                        .addGroup(loginPanelLayout.createParallelGroup(Alignment.TRAILING, false)
                                                .addComponent(emailTextField, Alignment.LEADING)
                                                .addComponent(passwordField, Alignment.LEADING)
                                                .addComponent(loginButton, Alignment.LEADING,
                                                        GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))))
                        .addPreferredGap(ComponentPlacement.RELATED)))
                .addGap(0)));
        loginPanelLayout.setVerticalGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup().addGap(14)
                    .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addGap(32).addComponent(emailLabel).addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED).addComponent(passwordLabel)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(66).addGroup(loginPanelLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(signUpLabel).addComponent(signUpButton))
                    .addContainerGap(55, Short.MAX_VALUE)));
        mainPanel.add(loginPanel);
    }
}
