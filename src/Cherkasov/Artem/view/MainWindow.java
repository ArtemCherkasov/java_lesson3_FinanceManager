package Cherkasov.Artem.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import Cherkasov.Artem.model.Account;
import Cherkasov.Artem.model.DataStoreImpl;
import Cherkasov.Artem.model.Record;
import Cherkasov.Artem.model.User;

public class MainWindow extends javax.swing.JFrame {

	private JButton addAccountButton;
    private JButton addTransactionButton;
    private JComboBox<ComboItem> accountList;
    private JLabel usetNameLabel;
    private JLabel userSurnameLabel;
    private JLabel accountsLabel;
    private JLabel fundsLabel;
    private JLabel transactionLabel;
    private JLabel userNameOutputLabel;
    private JLabel userSurnameOutputLabel;
    private JLabel fundsOutputLabel;
    private JList transactionList;
    private DefaultListModel<String> listModel;
    private JPanel panel;
    private JScrollPane transactionScrollPanel;
    private DataStoreImpl dataStoreImpl;
    private User user;
    private Account account;
    private UpdateAccountCallBack callBack;
	
    public MainWindow(DataStoreImpl dataStoreImpl, User user) {
    	super("Finance manager");
    	this.dataStoreImpl = dataStoreImpl;
    	this.user = user;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panel = new JPanel();
        usetNameLabel = new JLabel();
        userSurnameLabel = new JLabel();
        accountsLabel = new JLabel();
        accountList = new JComboBox();
        fundsLabel = new JLabel();
        addAccountButton = new javax.swing.JButton();
        transactionLabel = new JLabel();
        transactionScrollPanel = new javax.swing.JScrollPane();
        transactionList = new JList();
        listModel = new DefaultListModel<String>();
        transactionList.setModel(listModel);
        addTransactionButton = new javax.swing.JButton();
        userNameOutputLabel = new JLabel();
        userSurnameOutputLabel = new JLabel();
        fundsOutputLabel = new JLabel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        usetNameLabel.setFont(new Font("DejaVu Sans", 0, 18));
        usetNameLabel.setText("User name:");
        userSurnameLabel.setFont(new Font("DejaVu Sans", 0, 18));
        userSurnameLabel.setText("User surname:");
        accountsLabel.setFont(new Font("DejaVu Sans", 0, 18));
        accountsLabel.setText("Accounts:");
        accountList.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fundsLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        fundsLabel.setText("Funds:");
        addAccountButton.setText("Add account");
        transactionLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        transactionLabel.setText("Transaction:");
        userNameOutputLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); 
        userNameOutputLabel.setText(user.getName());
        userSurnameOutputLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); 
        userSurnameOutputLabel.setText(user.getSurname());
        fundsOutputLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18));

        callBack = new UpdateAccountCallBack() {
			@Override
			public void onConfirm() {
				loadAccounts();
				loadTransactions();
			}
			
		};

        transactionScrollPanel.setViewportView(transactionList);
        addTransactionButton.setText("Add transaction");
        
        addTransactionButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		addTransactionWindow(e);
        	}
		});
        
        addAccountButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		addAccount();
        		loadAccounts();
        		loadTransactions();
        	}
		});
        
        accountList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object item = accountList.getSelectedItem();

				if(((ComboItem)item) != null){
					account = ((ComboItem)item).getAccount();
					fundsOutputLabel.setText(account.getFunds().toString());
					loadTransactions();
				}
				
			}
			
		});
        
        loadAccounts();
        loadTransactions();

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(transactionLabel)
                    .addComponent(accountsLabel)
                    .addComponent(userSurnameLabel)
                    .addComponent(usetNameLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(transactionScrollPanel, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addTransactionButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(addAccountButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accountList, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fundsLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fundsOutputLabel))
                    .addComponent(userNameOutputLabel)
                    .addComponent(userSurnameOutputLabel))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usetNameLabel)
                    .addComponent(userNameOutputLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(userSurnameLabel)
                    .addComponent(userSurnameOutputLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(accountsLabel)
                    .addComponent(accountList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fundsLabel)
                    .addComponent(fundsOutputLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addAccountButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(transactionLabel)
                    .addComponent(transactionScrollPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTransactionButton)
                .addContainerGap(70, Short.MAX_VALUE))
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
        setResizable(false);
        
    }                        
    
    private void addTransactionWindow(MouseEvent evt) {
    	AddTransaction addTransaction = new AddTransaction(this, true, dataStoreImpl, account, callBack);
    	addTransaction.setVisible(true);
    }
    
    private void addAccount(){
    	Account account = new Account();
    	account.setFunds(0.0);
    	dataStoreImpl.addAccount(user, account);
    }
    
    private void loadAccounts(){
    	Set<Account> accounts = dataStoreImpl.getAccounts(user);
    	accountList.removeAllItems();
    	for(Account account: accounts){
    		accountList.addItem(new ComboItem("account id: " + account.getId(), account));
    	}
    }
    
    private void loadTransactions(){
    	Set<Record> records = dataStoreImpl.getRecords(account);
    	listModel.removeAllElements();
    	
    	for (Record record: records){
    		listModel.addElement(record.getDate() + " " + record.getCategory().getDescription() + " " + record.getFunds());
    	}
    }
               
}

