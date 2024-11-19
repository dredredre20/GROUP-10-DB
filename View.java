import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View{

    private int		menu; //used for determining actions
    private int		select;
    private JFrame 	frame;

    private JButton	back = new JButton("Back");
    private JButton	confirm = new JButton("Confirm");
    private JButton 	button1 = new JButton();
    private JButton	button2 = new JButton();
    private JButton 	button3 = new JButton();
    private JButton	button4 = new JButton();
    private JButton 	button5 = new JButton();
    private JButton	button6 = new JButton();
    private JButton	button7 = new JButton();

    private JTextField	textField1 = new JTextField();
    private JTextField	textField2 = new JTextField();
    private JTextField	textField3 = new JTextField();
    private JTextField	textField4 = new JTextField();
    private JTextField	textField5 = new JTextField();
    private JTextField	textField6 = new JTextField();
    private JTextField	textField7 = new JTextField();
    private JTextField	textField8 = new JTextField();
    private JTextField	textField9 = new JTextField();
    private JTextField	textField10 = new JTextField();
    private JTextField	textField11 = new JTextField();
    private JTextField	textField12 = new JTextField();
    private JTextField	textField13 = new JTextField();
    private JTextField	textField14 = new JTextField();
    private JTextField	textField15 = new JTextField();
    private JTextField	textField16 = new JTextField();
    private JTextField	textField17 = new JTextField();
    private JTextField	textField18 = new JTextField();

    private JTextArea	textArea1 = new JTextArea(12, 48);
    private JTextArea	textArea2 = new JTextArea(12, 48);

    private JScrollPane	scrollPane1 = new JScrollPane(textArea1);
    private JScrollPane	scrollPane2 = new JScrollPane(textArea2);

    private JLabel	label1 = new JLabel();
    private JLabel	label2 = new JLabel();
    private JLabel	label3 = new JLabel();
    private JLabel	label4 = new JLabel();
    private JLabel	label5 = new JLabel();
    private JLabel	label6 = new JLabel();
    private JLabel	label7 = new JLabel();
    private JLabel	label8 = new JLabel();
    private JLabel	label9 = new JLabel();
    private JLabel	label10 = new JLabel();
    private JLabel	label11 = new JLabel();
    private JLabel	label12 = new JLabel();
    private JLabel	label13 = new JLabel();
    private JLabel	label14 = new JLabel();
    private JLabel	label15 = new JLabel();
    private JLabel	label16 = new JLabel();
    private JLabel	label17 = new JLabel();
    private JLabel	label18 = new JLabel();
    private JLabel	label19 = new JLabel();
    private JLabel	label20 = new JLabel();
    private JLabel	label21 = new JLabel();
    private JLabel	label22 = new JLabel();


    private JLabel 	result1 = new JLabel();
    private JLabel 	result2 = new JLabel();

    private JRadioButton	radio1 = new JRadioButton();
    private JRadioButton	radio2 = new JRadioButton();

    private ButtonGroup		bg = new ButtonGroup();

    public View() {
	this.frame = new JFrame("HMO Consultation Database");
	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.frame.setLayout(new FlowLayout());
	this.frame.setSize(700, 300);
	this.textField1.setColumns(10);
	this.textField2.setColumns(10);
	this.textField3.setColumns(10);
	this.textField4.setColumns(10);
	this.textField5.setColumns(10);
	this.textField6.setColumns(10);
	this.textField7.setColumns(10);
	this.textField8.setColumns(10);
	this.textField9.setColumns(10);
	this.textField10.setColumns(10);
	this.textField11.setColumns(10);
	this.textField12.setColumns(10);
	this.textField13.setColumns(10);
	this.textField14.setColumns(10);
	this.textField15.setColumns(10);
	this.textField16.setColumns(10);
	this.textField17.setColumns(10);
	this.textField18.setColumns(10);
	this.textArea1.setEditable(false);
	this.textArea2.setEditable(false);
	this.mainMenu();
	this.frame.setVisible(true);
    }

    public void setMenu(int menu) {
	this.menu = menu;
    }

    public int getMenu() {
	return this.menu;
    }

    public void setSelect(int select) {
	this.select = select;
    }

    public int getSelect() {
	return this.select;
    }

    public void refresh() {
	this.frame.getContentPane().removeAll();
	frame.repaint();
    }

    public void setVisible() {
	this.frame.setVisible(true);
    }

    public void setText1(String text) {
	this.textField1.setText(text);
    }

    public void setText2(String text) {
	this.textField2.setText(text);
    }

    public void setText3(String text) {
	this.textField3.setText(text);
    }

    public void setText4(String text) {
	this.textField4.setText(text);
    }

    public void setText5(String text) {
	this.textField5.setText(text);
    }

    public void setText6(String text) {
	this.textField6.setText(text);
    }

    public void setText7(String text) {
	this.textField7.setText(text);
    }

    public void setText8(String text) {
	this.textField8.setText(text);
    }

    public void setText9(String text) {
	this.textField9.setText(text);
    }

    public void setText10(String text) {
	this.textField10.setText(text);
    }

    public void setText11(String text) {
	this.textField11.setText(text);
    }

    public void setText12(String text) {
	this.textField12.setText(text);
    }

    public void setText13(String text) {
	this.textField13.setText(text);
    }

    public void setText14(String text) {
	this.textField14.setText(text);
    }

    public void setText15(String text) {
	this.textField15.setText(text);
    }

    public void setText16(String text) {
	this.textField16.setText(text);
    }

    public void setText17(String text) {
	this.textField17.setText(text);
    }

    public void setText18(String text) {
	this.textField18.setText(text);
    }

    public String getText1() {
	return this.textField1.getText();
    }

    public String getText2() {
	return this.textField2.getText();
    }
	
    public String getText3() {
	return this.textField3.getText();
    }

    public String getText4() {
	return this.textField4.getText();
    }

    public String getText5() {
	return this.textField5.getText();
    }

    public String getText6() {
	return this.textField6.getText();
    }

    public String getText7() {
	return this.textField7.getText();
    }

    public String getText8() {
	return this.textField8.getText();
    }

    public String getText9() {
	return this.textField9.getText();
    }

    public String getText10() {
	return this.textField10.getText();
    }

    public String getText11() {
	return this.textField11.getText();
    }

    public String getText12() {
	return this.textField12.getText();
    }

    public String getText13() {
	return this.textField13.getText();
    }

    public String getText14() {
	return this.textField14.getText();
    }

    public String getText15() {
	return this.textField15.getText();
    }

    public String getText16() {
	return this.textField16.getText();
    }

    public String getText17() {
	return this.textField17.getText();
    }

    public String getText18() {
	return this.textField18.getText();
    }

    public void setTextArea1(String text) {
	this.textArea1.setText(text);
    }

    public void setTextArea2(String text) {
	this.textArea2.setText(text);
    }

    public void setResult1(String result) {
	this.result1.setText(result);
    }

    public void setResult2(String result) {
	this.result2.setText(result);
    }

    public boolean isButtonSelected(JRadioButton button) {
	return button.isSelected();
    }

    public JRadioButton getRadio1() {
	return this.radio1;
    }

    public JRadioButton getRadio2() {
	return this.radio2;
    }

    public void setBack(ActionListener actionListener) {
	this.back.addActionListener(actionListener);
    }

    public void setConfirm(ActionListener actionListener) {
	this.confirm.addActionListener(actionListener);
    }

    public void setButton1(ActionListener actionListener) {
	this.button1.addActionListener(actionListener);
    }

    public void setButton2(ActionListener actionListener) {
	this.button2.addActionListener(actionListener);
    }

    public void setButton3(ActionListener actionListener) {
	this.button3.addActionListener(actionListener);
    }

    public void setButton4(ActionListener actionListener) {
	this.button4.addActionListener(actionListener);
    }

    public void setButton5(ActionListener actionListener) {
	this.button5.addActionListener(actionListener);
    }

    public void setButton6(ActionListener actionListener) {
	this.button6.addActionListener(actionListener);
    }

    public void setButton7(ActionListener actionListener) {
	this.button7.addActionListener(actionListener);
    }

    public void mainMenu() {
	this.setMenu(0000);
	this.button1.setText("Patient log-in/sign up"); 	//patient
	this.button2.setText("Update Patient Record");		//pUpdate
	this.button3.setText("Update Consultation");  	      	//consult
	this.button4.setText("Remove Unused/Dated Records");  	//remove
	this.button5.setText("Doctor log-in/sign-up");  	//doctor
	this.button6.setText("Update References");		//refer
	this.button7.setText("Generate Reports");             	//report

	this.frame.add(this.button1);
	this.frame.add(this.button2);
	this.frame.add(this.button3);
	this.frame.add(this.button4);
	this.frame.add(this.button5);
	this.frame.add(this.button6);
	this.frame.add(this.button7);
    }

    public void patient() {
	this.setMenu(1000);
	this.button1.setText("Sign up");
	this.button2.setText("Log-in with ID");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
    }

    public void patientNew() {
	this.setMenu(1100);
	this.label1.setText("Input Patient Data");
	this.label2.setText("Last Name: ");
	this.label3.setText("First Name: ");
	this.label4.setText("Sex: ");
	this.label5.setText("Birthday (mm/dd/yyyy): ");
	this.label6.setText("Phone Number: ");
	this.label7.setText("Home Address: ");
	this.label8.setText("Street: ");
	this.label9.setText("City: ");
	this.label10.setText("Province: ");
	this.label11.setText("Postal Code: ");
	this.label12.setText("Contact Person's Last Name: ");
	this.label13.setText("Contact Person's First Name: ");
	this.label14.setText("Contact Person's Phone Number: ");
	this.label15.setText("Relationship with contact person: ");
	this.label16.setText("Allergies: ");

	this.radio1.setText("Male");
	this.radio2.setText("Female");
	this.bg.add(radio1);
	this.bg.add(radio2);
	this.radio1.setSelected(true);

	//blood type is input in update 
	//(we assume that the patient doesn't know their blood type)

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(radio1);
	this.frame.add(radio2);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(label8);
	this.frame.add(textField5);
	this.frame.add(label9);
	this.frame.add(textField6);
	this.frame.add(label10);
	this.frame.add(textField7);
	this.frame.add(label11);
	this.frame.add(textField8);
	this.frame.add(label12);
	this.frame.add(textField9);
	this.frame.add(label13);
	this.frame.add(textField10);
	this.frame.add(label14);
	this.frame.add(textField11);
	this.frame.add(label15);
	this.frame.add(textField12);
	this.frame.add(label16);
	this.frame.add(textField13);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void patientOld() {
	this.setMenu(1200);
	this.label1.setText("Input patient ID: ");
	this.label2.setText("List of patients: ");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void patientMenu() {
	this.setMenu(1300);
	this.button1.setText("Edit patient record");
	this.button2.setText("Book Consultation");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
    }

    public void patientMenuEdit() {
	this.setMenu(1010);
	this.button1.setText("Add contact person");
	this.button2.setText("Remove contact person");
	this.button3.setText("Edit patient information");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
	this.frame.add(button3);
    }

    public void patientMenuEditAddC() {
	this.setMenu(1011);
	this.label1.setText("Contact Person's Last Name: ");
	this.label2.setText("Contact Person's First Name: ");
	this.label3.setText("Contact Person's Phone Number: ");
	this.label4.setText("Relationship with contact person: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(textField2);
	this.frame.add(label3);
	this.frame.add(textField3);
	this.frame.add(label4);
	this.frame.add(textField4);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void patientMenuEditRemoveC() {
	this.setMenu(1012);
	this.label1.setText("Input contact person's last name: ");
	this.label2.setText("Input contact person's first name: ");
	this.label3.setText("List of contact persons: ");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(textField2);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label3);
	this.frame.add(scrollPane1);
    }

    public void patientMenuEditPatient() {
	this.setMenu(1013);
	this.label1.setText("Input Patient Data");
	this.label2.setText("Last Name: ");
	this.label3.setText("First Name: ");
	this.label4.setText("Sex: ");
	this.label5.setText("Birthday (mm/dd/yyyy): ");
	this.label6.setText("Phone Number: ");
	this.label7.setText("Home Address: ");
	this.label8.setText("Street: ");
	this.label9.setText("City: ");
	this.label10.setText("Province: ");
	this.label11.setText("Postal Code: ");
	this.label12.setText("Contact Person's Last Name: ");
	this.label13.setText("Contact Person's First Name: ");
	this.label14.setText("Contact Person's Phone Number: ");
	this.label15.setText("Relationship with contact person: ");
	this.label16.setText("Blood type: ");
	this.label17.setText("Allergies: ");

	this.radio1.setText("Male");
	this.radio2.setText("Female");
	this.bg.add(radio1);
	this.bg.add(radio2);
	this.radio1.setSelected(true);

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(radio1);
	this.frame.add(radio2);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(label8);
	this.frame.add(textField5);
	this.frame.add(label9);
	this.frame.add(textField6);
	this.frame.add(label10);
	this.frame.add(textField7);
	this.frame.add(label11);
	this.frame.add(textField8);
	this.frame.add(label12);
	this.frame.add(textField9);
	this.frame.add(label13);
	this.frame.add(textField10);
	this.frame.add(label14);
	this.frame.add(textField11);
	this.frame.add(label15);
	this.frame.add(textField12);
	this.frame.add(label16);
	this.frame.add(textField13);
	this.frame.add(label17);
	this.frame.add(textField14);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void patientMenuConsult() {
	this.setMenu(1020);
	this.label1.setText("Input available time (mm/dd/yyyy hh:mm): ");
	this.label2.setText("From ");
	this.label3.setText("To ");
	this.label4.setText("Input complaint (leave blank if not in list): ");
	this.label5.setText("List of chief complaints: ");
	this.label6.setText("Input doctor ID to select: ");
	this.label7.setText("List of available doctors: ");
	this.button1.setText("Book Consultation");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(textField3);
	this.frame.add(label5);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(scrollPane2);
	this.frame.add(button1);
	this.frame.add(result2);
    }

    public void pUpdate() {
	this.setMenu(2000);
	this.label1.setText("Input patient ID: ");
	this.label2.setText("List of patients: ");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }
					//the patient data is placed on the text fields by default
    public void pUpdateData() {
	this.setMenu(2100);
	this.label1.setText("Input Patient Data");
	this.label2.setText("Last Name: ");
	this.label3.setText("First Name: ");
	this.label4.setText("Sex: ");
	this.label5.setText("Birthday (mm/dd/yyyy): ");
	this.label6.setText("Phone Number: ");
	this.label7.setText("Home Address: ");
	this.label8.setText("Street: ");
	this.label9.setText("City: ");
	this.label10.setText("Province: ");
	this.label11.setText("Postal Code: ");
	this.label12.setText("Contact Person's Last Name: ");
	this.label13.setText("Contact Person's First Name: ");
	this.label14.setText("Contact Person's Phone Number: ");
	this.label15.setText("Relationship with contact person: ");
	this.label16.setText("Blood type: ");
	this.label17.setText("Allergies: ");

	this.radio1.setText("Male");
	this.radio2.setText("Female");
	this.bg.add(radio1);
	this.bg.add(radio2);
	this.radio1.setSelected(true);

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(radio1);
	this.frame.add(radio2);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(label8);
	this.frame.add(textField5);
	this.frame.add(label9);
	this.frame.add(textField6);
	this.frame.add(label10);
	this.frame.add(textField7);
	this.frame.add(label11);
	this.frame.add(textField8);
	this.frame.add(label12);
	this.frame.add(textField9);
	this.frame.add(label13);
	this.frame.add(textField10);
	this.frame.add(label14);
	this.frame.add(textField11);
	this.frame.add(label15);
	this.frame.add(textField12);
	this.frame.add(label16);
	this.frame.add(textField13);
	this.frame.add(label17);
	this.frame.add(textField14);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void consult() {
	this.setMenu(3000);
	this.label1.setText("Input consultation ID");
	this.label2.setText("List of consultations");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }
					//can only update rating and notes
    public void consultUpdate() {
	this.setMenu(3100);
	this.button1.setText("Update satisfaction rating");
	this.button2.setText("Add laboratory request");
	this.button3.setText("Add diagnosis");
	this.button4.setText("Add prescription");
	
	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
	this.frame.add(button3);
	this.frame.add(button4);
    }

    public void consultUpdateRating() {
	this.setMenu(3110);
	this.label1.setText("Input satisfaction rating: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void consultUpdateLab() {
	this.setMenu(3120);
	this.label1.setText("Input laboratory ID to select: ");
	this.label2.setText("List of laboratories");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void consultUpdateDia() {
	this.setMenu(3130);
	this.label1.setText("Input diagnosis description: ");
	this.label2.setText("Input diagnosis severity: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(textField2);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void consultUpdatePre() {
	this.setMenu(3140);
	this.label1.setText("Input medicine ID: ");
	this.label2.setText("List of medicines: ");
	this.label3.setText("Input dosage: ");
	this.label4.setText("Input frequency: ");
	this.label5.setText("Input start and end dates (mm/dd/yyyy): ");
	this.label6.setText("From ");
	this.label7.setText("To ");
	this.label8.setText("Input notes: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(textField3);
	this.frame.add(label5);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(textField5);
	this.frame.add(label8);
	this.frame.add(textField6);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void remove() {
	this.setMenu(4000);
	this.button1.setText("Remove patient records");
	this.button2.setText("Remove consultation records");
	this.button3.setText("Remove doctor records");
	this.button4.setText("Remove laboratory records");
	this.button5.setText("Remove chief complaints records");
	this.button6.setText("Remove medicine records");
		

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
	this.frame.add(button3);
	this.frame.add(button4);
	this.frame.add(button5);
	this.frame.add(button6);
    }

    public void removePatient() {
	this.setMenu(4100);
	this.label1.setText("Input patient ID");
	this.label2.setText("List of patients");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void removeConsult() {
	this.setMenu(4200);
	this.label1.setText("Input consultation ID");
	this.label2.setText("List of consultations");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void removeDoctor() {
	this.setMenu(4300);
	this.label1.setText("Input doctor ID");
	this.label2.setText("List of doctors");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void removeLab() {
	this.setMenu(4400);
	this.label1.setText("Input laboratory ID");
	this.label2.setText("List of laboratories");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void removeComplaint() {
	this.setMenu(4500);
	this.label1.setText("Input chief complaint description");
	this.label2.setText("List of chief complaints");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void removeMedicine() {
	this.setMenu(4600);
	this.label1.setText("Input medicine ID");
	this.label2.setText("List of medicines");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void doctor() {
	this.setMenu(5000);
	this.button1.setText("Sign up");
	this.button2.setText("Log-in with ID");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
    }

    public void doctorNew() {
	this.setMenu(5100);
	this.label1.setText("Input Doctor Data");
	this.label2.setText("Last Name: ");
	this.label3.setText("First Name: ");
	this.label4.setText("Sex: ");
	this.label5.setText("Birthday (mm/dd/yyyy): ");
	this.label6.setText("Phone Number: ");
	this.label7.setText("Home Address: ");
	this.label8.setText("Street: ");
	this.label9.setText("City: ");
	this.label10.setText("Province: ");
	this.label11.setText("Postal Code: ");
	this.label12.setText("Email: ");
	this.label13.setText("Salary: ");
	this.label14.setText("License Number: ");
	this.label15.setText("Working Hours (hh:mm) (24h format): ");
	this.label16.setText("From: ");
	this.label17.setText("To");
	this.label18.setText("Max Patient Load: ");
	this.label19.setText("Specialization: ");
	this.label20.setText("Specialization Field: ");
	this.label21.setText("Specialization Certificate Date (mm/dd/yyyy): ");
	this.label22.setText("Specialization Expiry Date (mm/dd/yyyy): ");


	this.radio1.setText("Male");
	this.radio2.setText("Female");
	this.bg.add(radio1);
	this.bg.add(radio2);
	this.radio1.setSelected(true);

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(radio1);
	this.frame.add(radio2);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(label8);
	this.frame.add(textField5);
	this.frame.add(label9);
	this.frame.add(textField6);
	this.frame.add(label10);
	this.frame.add(textField7);
	this.frame.add(label11);
	this.frame.add(textField8);
	this.frame.add(label12);
	this.frame.add(textField9);
	this.frame.add(label13);
	this.frame.add(textField10);
	this.frame.add(label14);
	this.frame.add(textField11);
	this.frame.add(label15);
	this.frame.add(label16);
	this.frame.add(textField12);
	this.frame.add(label17);
	this.frame.add(textField13);
	this.frame.add(label18);
	this.frame.add(textField14);
	this.frame.add(label19);
	this.frame.add(textField15);
	this.frame.add(label20);
	this.frame.add(textField16);
	this.frame.add(label21);
	this.frame.add(textField17);
	this.frame.add(label22);
	this.frame.add(textField18);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void doctorOld() {
	this.setMenu(5200);
	this.label1.setText("Input doctor ID to select");
	this.label2.setText("List of doctors");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
    }

    public void doctorMenu() {
	this.setMenu(5300);
	this.button1.setText("Add specializations");
	this.button2.setText("Remove specialization");
	this.button3.setText("Edit doctor record");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
	this.frame.add(button3);
    }

    public void doctorMenuAdd() {
	this.setMenu(5010);
	this.label1.setText("Specialization: ");
	this.label2.setText("Specialization Field: ");
	this.label3.setText("Specialization Certificate Date (mm/dd/yyyy): ");
	this.label4.setText("Specialization Expiry Date (mm/dd/yyyy): ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(textField2);
	this.frame.add(label3);
	this.frame.add(textField3);
	this.frame.add(label4);
	this.frame.add(textField4);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void doctorMenuRemove() {
	this.setMenu(5020);
	this.label1.setText("Input specialization to remove: ");
	this.label2.setText("List of specializations: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void doctorMenuEdit() {
	this.setMenu(5030);
	this.label1.setText("Input Doctor Data");
	this.label2.setText("Last Name: ");
	this.label3.setText("First Name: ");
	this.label4.setText("Sex: ");
	this.label5.setText("Birthday (mm/dd/yyyy): ");
	this.label6.setText("Phone Number: ");
	this.label7.setText("Home Address: ");
	this.label8.setText("Street: ");
	this.label9.setText("City: ");
	this.label10.setText("Province: ");
	this.label11.setText("Postal Code: ");
	this.label12.setText("Email: ");
	this.label13.setText("Salary: ");
	this.label14.setText("License Number: ");
	this.label15.setText("Working Hours (hh:mm) (24h format): ");
	this.label16.setText("From: ");
	this.label17.setText("To");
	this.label18.setText("Max Patient Load: ");

	this.radio1.setText("Male");
	this.radio2.setText("Female");
	this.bg.add(radio1);
	this.bg.add(radio2);
	this.radio1.setSelected(true);

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(radio1);
	this.frame.add(radio2);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(label8);
	this.frame.add(textField5);
	this.frame.add(label9);
	this.frame.add(textField6);
	this.frame.add(label10);
	this.frame.add(textField7);
	this.frame.add(label11);
	this.frame.add(textField8);
	this.frame.add(label12);
	this.frame.add(textField9);
	this.frame.add(label13);
	this.frame.add(textField10);
	this.frame.add(label14);
	this.frame.add(textField11);
	this.frame.add(label15);
	this.frame.add(label16);
	this.frame.add(textField12);
	this.frame.add(label17);
	this.frame.add(textField13);
	this.frame.add(label18);
	this.frame.add(textField14);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void refer() {
	this.setMenu(6000);
	this.button1.setText("Add laboratory");
	this.button2.setText("Edit laboratory");
	this.button3.setText("Add chief complaint");
	this.button4.setText("Edit chief complaint");
	this.button5.setText("Add medicine");
	this.button6.setText("Edit medicine");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
	this.frame.add(button3);
	this.frame.add(button4);
	this.frame.add(button5);
	this.frame.add(button6);
    }

    public void referLabAdd() {
	this.setMenu(6100);
	this.label1.setText("Input laboratory data: ");
	this.label2.setText("Laboratory name: ");
	this.label3.setText("Home Address: ");
	this.label4.setText("Street: ");
	this.label5.setText("City: ");
	this.label6.setText("Province: ");
	this.label7.setText("Postal Code: ");
	this.label8.setText("Phone Number: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(label4);
	this.frame.add(textField2);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(textField5);
	this.frame.add(label8);
	this.frame.add(textField6);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referLabEdit() {
	this.setMenu(6200);
	this.label1.setText("Input laboratory ID: ");
	this.label2.setText("List of laboratories: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referLabEditData() {
	this.setMenu(6210);
	this.label1.setText("Edit laboratory data: ");
	this.label2.setText("Laboratory name: ");
	this.label3.setText("Home Address: ");
	this.label4.setText("Street: ");
	this.label5.setText("City: ");
	this.label6.setText("Province: ");
	this.label7.setText("Postal Code: ");
	this.label8.setText("Phone Number: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(label4);
	this.frame.add(textField2);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(label6);
	this.frame.add(textField4);
	this.frame.add(label7);
	this.frame.add(textField5);
	this.frame.add(label8);
	this.frame.add(textField6);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referComp() {
	this.setMenu(6300);
	this.label1.setText("Input chief complaint data: ");
	this.label2.setText("Description: ");
	this.label3.setText("Category: ");
	this.label4.setText("Recommended Specialization: ");
	this.label5.setText("List of specializations: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(textField3);
	this.frame.add(label5);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referCompEdit() {
	this.setMenu(6400);
	this.label1.setText("Input chief complaint description: ");
	this.label2.setText("List of chief complaints: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referCompEditData() {
	this.setMenu(6410);
	this.label1.setText("Edit chief complaint data: ");
	this.label2.setText("Description: ");
	this.label3.setText("Category: ");
	this.label4.setText("Recommended Specialization: ");
	this.label5.setText("List of specializations: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(textField3);
	this.frame.add(label5);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referMed() {
	this.setMenu(6500);
	this.label1.setText("Input medicine data: ");
	this.label2.setText("Brand name: ");
	this.label3.setText("Common name: ");
	this.label4.setText("Quantity: ");
	this.label5.setText("Availability: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(textField3);
	this.frame.add(label5);
	this.frame.add(textField4);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referMedEdit() {
	this.setMenu(6600);
	this.label1.setText("Input medicine ID: ");
	this.label2.setText("List of chief complaints: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(scrollPane1);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void referMedEditData() {
	this.setMenu(6610);
	this.label1.setText("Edit medicine data: ");
	this.label2.setText("Brand name: ");
	this.label3.setText("Common name: ");
	this.label4.setText("Quantity: ");
	this.label5.setText("Availability: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(label4);
	this.frame.add(textField3);
	this.frame.add(label5);
	this.frame.add(textField4);
	this.frame.add(confirm);
	this.frame.add(result1);
    }


    public void report() {
	this.setMenu(7000);
	this.label1.setText("Generate monthly/yearly reports");
	this.button1.setText("HMO Consultations Report");
	this.button2.setText("Department Performance Evaluation Report");
	this.button3.setText("Health Risks Based on Patient Demographics Report");
	this.button4.setText("Something");
	
	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
	this.frame.add(button3);
	this.frame.add(button4);
	this.frame.add(result1);
	this.frame.add(scrollPane1);
    }
}
