package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ListCreationForm extends JPanel implements ActionListener {
	private JTextField nameField;
	private JTextField targetEmailField;
	private JTextField targetNameFielld;
	private JTextField expectedAmountField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListCreationForm() {
		setLayout(null);
		
		JButton create = new JButton("Create");
		create.setBounds(450, 504, 117, 25);
		add(create);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.setBounds(591, 504, 117, 25);
		add(Cancel);
		
		JLabel lblNewList = new JLabel("New List");
		lblNewList.setBounds(334, 36, 70, 15);
		add(lblNewList);
		
		nameField = new JTextField();
		nameField.setBounds(179, 86, 114, 19);
		add(nameField);
		nameField.setColumns(10);
		
		targetEmailField = new JTextField();
		targetEmailField.setColumns(10);
		targetEmailField.setBounds(179, 117, 114, 19);
		add(targetEmailField);
		
		targetNameFielld = new JTextField();
		targetNameFielld.setColumns(10);
		targetNameFielld.setBounds(179, 148, 114, 17);
		add(targetNameFielld);
		
		expectedAmountField = new JTextField();
		expectedAmountField.setColumns(10);
		expectedAmountField.setBounds(179, 177, 114, 19);
		add(expectedAmountField);
		
		JLabel listNameLabek = new JLabel("Name");
		listNameLabek.setEnabled(false);
		listNameLabek.setBounds(12, 88, 70, 15);
		add(listNameLabek);
		
		JLabel targetEmail = new JLabel("Target Emaill");
		targetEmail.setBounds(12, 119, 92, 15);
		add(targetEmail);
		
		JLabel lblTargetName = new JLabel("target name");
		lblTargetName.setBounds(12, 150, 114, 15);
		add(lblTargetName);
		
		JLabel lblExpectedAmount = new JLabel("Expected amount");
		lblExpectedAmount.setBounds(12, 181, 129, 15);
		add(lblExpectedAmount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 259, 427, 164);
		add(scrollPane);
        String[] columnNames = { "id","UserName", "Email"};
        String[][] tableData = {{"1", "un",     "uno@asd"},
                                {"2", "deux",   "dos@asd"},
                                {"3", "trois",  "tres@asd"},
                                {"4", "quatre", "cuatro@asd"}};
		table = new JTable(tableData, columnNames);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setWidth(0);
		scrollPane.setViewportView(table);
		
		JButton addUser = new JButton("Add user");
		addUser.setBounds(465, 324, 117, 37);
        addUser.addActionListener(this);
		add(addUser);
		
		JLabel lblGifters = new JLabel("Gifters:");
		lblGifters.setBounds(29, 232, 70, 15);
		add(lblGifters);
		
		JButton btnRemoveUser = new JButton("Remove user");
		btnRemoveUser.setBounds(468, 398, 117, 25);
		btnRemoveUser.addActionListener(this);
		add(btnRemoveUser);

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            default:
                // GET SELECTED ID
                //table.getValueAt(table.getSelectedRow(),0);
                System.out.println("show user form");
        }
    }

}
