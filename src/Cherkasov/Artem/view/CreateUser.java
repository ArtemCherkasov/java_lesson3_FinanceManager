package Cherkasov.Artem.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import Cherkasov.Artem.model.DataStoreImpl;
import Cherkasov.Artem.model.User;

public class CreateUser extends javax.swing.JFrame {

	private JButton createButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JPanel panel;
    private JTextField loginInput;
    private JPasswordField passwordInput;
    private JTextField nameInput;
    private JTextField surnameInput;
    private DataStoreImpl dataStoreImpl;
	
    public CreateUser(DataStoreImpl dataStoreImpl) {
    	
    	super("Finance manager: create user");
    	this.dataStoreImpl = dataStoreImpl;
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new JPanel();
        loginLabel = new JLabel();
        passwordLabel = new JLabel();
        nameLabel = new JLabel();
        surnameLabel = new JLabel();
        loginInput = new JTextField();
        passwordInput = new JPasswordField();
        nameInput = new JTextField();
        surnameInput = new JTextField();
        createButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);

        loginLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 14));
        loginLabel.setText("login:");

        passwordLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 14));
        passwordLabel.setText("password:");

        nameLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 14));
        nameLabel.setText("name:");

        surnameLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 14));
        surnameLabel.setText("surname:");

        loginInput.setToolTipText("");

        createButton.setText("Create user");
        
        createButton.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
        		
        		createUser(e);
        		
        	}
        	
		});

        GroupLayout jPanel1Layout = new GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(surnameLabel)
                            .addComponent(nameLabel)
                            .addComponent(passwordLabel)
                            .addComponent(loginLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(loginInput, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameInput, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(createButton)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(surnameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(createButton)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        
    }
    
    private void createUser(MouseEvent evt) {                                      
    	
    	if(
    			(!loginInput.getText().isEmpty()) &&
    			(passwordInput.getPassword().length != 0) &&
    			(!nameInput.getText().isEmpty()) &&
    			(!surnameInput.getText().isEmpty())
    	)    		
    	{
    		
    		User user = new User();
        	user.setLogin(loginInput.getText());
        	user.setPassword(passwordInput.getPassword());
        	user.setName(nameInput.getText());
        	user.setSurname(surnameInput.getText());
        	
        	dataStoreImpl.addUser(user);
    		
        	loginInput.setText("");
        	passwordInput.setText("");
        	nameInput.setText("");
        	surnameInput.setText("");
        	
    	}
    	
    }
    
}