package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;

public class ListCreationForm extends JPanel implements ActionListener, KeyListener {
	private JTextField nameField;
	private JTextField targetEmailField;
	private JTextField targetNameField;
	private JTextField expectedAmountField;
	private JTable giftersTable;
	private JTable searchTable;
	private JTextField searchField;
    private MainController controller;
    private JTextField dueDate;

    /**
	 * Create the panel.
	 */
	public ListCreationForm() {
		setLayout(null);
		
		JButton create = new JButton("Create");
		create.setBounds(633, 632, 117, 25);
		create.addActionListener(this);
		add(create);
		
		JButton cancel = new JButton("Cancel");
        cancel.setBounds(762, 632, 117, 25);
		cancel.addActionListener(this);
		add(cancel);
		
		JLabel lblNewList = new JLabel("New List");
		lblNewList.setBounds(413, 12, 70, 15);
		add(lblNewList);
		
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
		
		JLabel lblGifters = new JLabel("Gifters:");
		lblGifters.setBounds(396, 60, 70, 15);
		add(lblGifters);
		
		JLabel lblSearchByName = new JLabel("Search by name");
		lblSearchByName.setBounds(12, 403, 147, 15);
		add(lblSearchByName);
		
		JLabel lblDueDate = new JLabel("Due date:");
		lblDueDate.setBounds(12, 208, 129, 15);
		add(lblDueDate);
		
		nameField = new JTextField();
		nameField.setBounds(179, 86, 172, 19);
		add(nameField);
		nameField.setColumns(10);
		
		targetEmailField = new JTextField();
		targetEmailField.setColumns(10);
		targetEmailField.setBounds(179, 117, 172, 19);
		add(targetEmailField);
		
		targetNameField = new JTextField();
		targetNameField.setColumns(10);
		targetNameField.setBounds(179, 148, 172, 17);
		add(targetNameField);
		
		expectedAmountField = new JTextField();
		expectedAmountField.setColumns(10);
		expectedAmountField.setBounds(179, 177, 172, 19);
		add(expectedAmountField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(396, 87, 427, 213);
		add(scrollPane);
        String[] columnNames = { "id","UserName", "Email"};
        Object[][] tableData = {};
        DefaultTableModel model = new DefaultTableModel(tableData, columnNames);
		giftersTable = new JTable(model);
		giftersTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        giftersTable.getColumnModel().getColumn(0).setMinWidth(0);
        giftersTable.getColumnModel().getColumn(0).setMaxWidth(0);
        giftersTable.getColumnModel().getColumn(0).setWidth(0);
		scrollPane.setViewportView(giftersTable);
		
		JButton addUser = new JButton("+");
		addUser.setBounds(451, 430, 44, 30);
        addUser.addActionListener(this);
		add(addUser);
		
		JButton btnRemoveUser = new JButton("-");
		btnRemoveUser.setBounds(835, 83, 44, 25);
		btnRemoveUser.addActionListener(this);
		add(btnRemoveUser);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 430, 427, 164);
		add(scrollPane_1);
		
		searchTable = new JTable((TableModel) null);
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String[] tableRows2 ={};
		
        String[] columnNames2 = { "id","UserName", "Email"};
        Object[][] tableData2 = {{}};
        DefaultTableModel searchModel = new DefaultTableModel(tableData2, columnNames);
		searchTable = new JTable(searchModel);
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_1.setViewportView(searchTable);
		
		searchField = new JTextField();
		searchField.addKeyListener(this);
		searchField.setBounds(163, 401, 188, 19);
		add(searchField);
		
		dueDate = new JTextField();
		dueDate.setColumns(10);
		dueDate.setBounds(179, 208, 172, 19);
		add(dueDate);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        DefaultTableModel giftersTableModel = (DefaultTableModel) giftersTable.getModel();
        switch (e.getActionCommand()) {
			case "Remove":
                int gifterToRemove = giftersTable.getSelectedRow();
                giftersTableModel.removeRow(gifterToRemove);
                revalidate();
                break;
			case "+":
			    //** Take row from search table  and add it to gifters **
                int selectedColumn = searchTable.getSelectedColumn();
                DefaultTableModel searchTableModel = (DefaultTableModel) searchTable.getModel();
                int selectedRow = searchTable.getSelectedRow();
                Object[] dataToAdd =  new Object[]{searchTableModel.getValueAt(selectedRow,0), searchTableModel.getValueAt(selectedRow,1), searchTableModel.getValueAt(selectedRow,2)};
                DefaultTableModel giftersModel = (DefaultTableModel) giftersTable.getModel();
                giftersModel.addRow(dataToAdd);
            break;
            case "Create":
                ArrayList<String> userIdsToAdd = new ArrayList<>();
                for (int i = 0 ; i < giftersTable.getRowCount() ; i++) {
                    userIdsToAdd.add(giftersTableModel.getValueAt(i,0).toString());
                }
                this.controller.saveList(nameField.getText(), targetEmailField.getText(), targetNameField.getText(), expectedAmountField.getText(), dueDate.getText(), userIdsToAdd);
                this.controller.onActionPerformed();
            default:
                // GET SELECTED ID
                //table.getValueAt(table.getSelectedRow(),0);
                System.out.println("show user form");
        }
    }

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) {
        ArrayList<String[]> userInfo = this.controller.getUserInfoForList(searchField.getText());
        DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
        for ( int i = 0; i < model.getRowCount();i++) {
            System.out.println("removing row " + i);
            model.removeRow(i);
        }
	    if (searchField.getText().length() >1) {
            if (!userInfo.isEmpty()) {
                for (Object[] values : userInfo)  {
                    model.addRow(values);
                }
            }
        }
	}


    public void setController(MainController mainController) {
	    controller = mainController;
    }
}



