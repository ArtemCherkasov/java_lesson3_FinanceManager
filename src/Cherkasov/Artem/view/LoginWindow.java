package Cherkasov.Artem.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import Cherkasov.Artem.model.DataStoreImpl;
import Cherkasov.Artem.model.User;

public class LoginWindow extends JFrame {
	
	private JButton loginButton;
	private JButton createUserButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel messageLabel;
    private JPanel loginPanel;
    private JTextField loginInput;
    private JPasswordField passwordInput;
    DataStoreImpl dataStoreImpl;

    public LoginWindow() {
    	super("Finance manager: login");
    	dataStoreImpl = new DataStoreImpl();
    	initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        loginPanel = new JPanel();
        loginLabel = new JLabel();
        passwordLabel = new JLabel();
        loginInput = new JTextField();
        passwordInput = new JPasswordField();
        loginButton = new JButton();
        createUserButton = new JButton();
        messageLabel = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        loginLabel.setText("login:");
        passwordLabel.setText("password:");
        loginButton.setText("Login");
        
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	loginButtonClicked(e);
            }
        });
        
        createUserButton.setText("create");
        
        createUserButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		createUserWindow(e);
        	}
		});

        messageLabel.setForeground(new Color(243, 4, 35));
        messageLabel.setText("");

        GroupLayout jPanel1Layout = new GroupLayout(loginPanel);
        loginPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordLabel)
                    .addComponent(loginLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(loginInput)
                        .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(createUserButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(messageLabel)
                .addGap(23, 23, 23)
                .addComponent(loginButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createUserButton)
                .addGap(31, 31, 31))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                        

    private void loginButtonClicked(MouseEvent evt) {                                      
    	User user = new User();
		user.setLogin(loginInput.getText());
		user.setPassword(passwordInput.getPassword());
		
		if (!dataStoreImpl.loginUser(user.getLogin(), user.getPassword())){
			messageLabel.setText("Incorrect login or Password");
		} else {
			MainWindow mainWindow = new MainWindow(dataStoreImpl, dataStoreImpl.getUser(user.getLogin()));
			this.setVisible(false);
			mainWindow.setVisible(true);
		}
    }
    
    private void createUserWindow(MouseEvent evt) {
    	CreateUser createUser = new CreateUser(dataStoreImpl);
    	createUser.setVisible(true);
    }

}
