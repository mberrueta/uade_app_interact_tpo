package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listCreationForm extends JPanel {
	private JTextField nameField;
	private JTextField targetEmailField;
	private JTextField targetNameFielld;
	private JTextField expectedAmountField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public listCreationForm() {
		setLayout(null);
		
		JButton create = new JButton("Create");
		create.setBounds(424, 388, 117, 25);
		add(create);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.setBounds(575, 388, 117, 25);
		add(Cancel);
		
		JLabel lblNewList = new JLabel("New List");
		lblNewList.setBounds(338, 12, 70, 15);
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
		
		
		JButton addParticipant = new JButton("Add person");
		addParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addParticipant.setBounds(424, 294, 117, 25);
		add(addParticipant);
		

        String[] columnNames = { "French", "Spanish", "Italian" };
        String[][] tableData = {{"un",     "uno",     "uno"     },
                                {"deux",   "dos",     "due"     },
                                {"trois",  "tres",    "tre"     },
                                { "quatre", "cuatro",  "quattro"},
                                { "cinq",   "cinco",   "cinque" },
                                { "six",    "seis",    "sei"    },
                                { "sept",   "siete",   "sette"  } };
        
        JButton removePerson = new JButton("Remove person");
        removePerson.setBounds(424, 245, 117, 25);
        add(removePerson);
 
        table = new JTable(tableData, columnNames);
		table.setToolTipText("");
		table.setBounds(58, 377, 279, -129);
		add(table);

	}
}
