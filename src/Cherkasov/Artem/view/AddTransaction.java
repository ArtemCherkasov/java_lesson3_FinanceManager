package Cherkasov.Artem.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import Cherkasov.Artem.model.Account;
import Cherkasov.Artem.model.Category;
import Cherkasov.Artem.model.DataStoreImpl;
import Cherkasov.Artem.model.Record;

@SuppressWarnings("serial")
public class AddTransaction extends JDialog {
	
	private JButton addTransactionButton;
	private JComboBox<ComboItem> categoriesList;
    private JLabel categoryLabel;
    private JLabel fundsLabel;
    private JRadioButton replenishmentRadio;
    private JRadioButton withdrawalRadio;
    private JTextField fundsInput;
    private ButtonGroup group;
    private DataStoreImpl dataStoreImpl;
    private Account account;
    private Category category;
    private UpdateAccountCallBack callBack;

    public AddTransaction(java.awt.Frame parent, boolean modal, DataStoreImpl dataStoreImpl, Account account, UpdateAccountCallBack callBack) {
        
    	super(parent, modal);
        this.dataStoreImpl = dataStoreImpl;
        this.account = account;
        this.callBack = callBack;
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        replenishmentRadio = new JRadioButton();
        withdrawalRadio = new JRadioButton();
        categoryLabel = new JLabel();
        categoriesList = new JComboBox<ComboItem>();
        addTransactionButton = new JButton();
        fundsLabel = new JLabel();
        fundsInput = new JTextField();
        group = new ButtonGroup();
        setTitle("Finance manager: add transaction");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        replenishmentRadio.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        replenishmentRadio.setText("Replenishment");
        withdrawalRadio.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        withdrawalRadio.setText("Withdrawal");
        replenishmentRadio.setSelected(true);
        categoryLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        categoryLabel.setText("Category:");
        addTransactionButton.setText("Add transaction");
        fundsLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        fundsLabel.setText("Funds:");
        fundsInput.setText("0.0");
        group.add(replenishmentRadio);
        group.add(withdrawalRadio);
        
        loadCategories();
        
        addTransactionButton.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
        		
        		Object item = categoriesList.getSelectedItem();
        		
        		
        		if(((ComboItem)item) != null){
        			
        			category = ((ComboItem)item).getCategory();
        			Record record = new Record();
            		record.setFunds(replenishmentRadio.isSelected()?Double.valueOf(fundsInput.getText()):-1*Double.valueOf(fundsInput.getText()));
            		record.setCategory(category);
            		dataStoreImpl.addRecord(account, record);
            		fundsInput.setText("0.0");
            		callBack.onConfirm();
            		
        		}

        	}
        	
		});

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(fundsLabel)
                            .addComponent(categoryLabel))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoriesList, 0, 196, Short.MAX_VALUE)
                            .addComponent(fundsInput)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(addTransactionButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(replenishmentRadio)
                            .addComponent(withdrawalRadio))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(replenishmentRadio)
                .addGap(18, 18, 18)
                .addComponent(withdrawalRadio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fundsLabel)
                    .addComponent(fundsInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(categoriesList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(addTransactionButton)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    
    private void loadCategories(){
    	
    	Set<Category> categories = dataStoreImpl.getCategories();
    	categoriesList.removeAllItems();
    	
    	for(Category category: categories){
    		
    		categoriesList.addItem(new ComboItem(category.getDescription(), category));
    		
    	}
    	
    }
                   
}