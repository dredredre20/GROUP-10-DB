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

    private JTextArea	textArea = new JTextArea(12, 48);

    private JScrollPane	scrollPane = new JScrollPane(textArea);

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
	this.textArea.setEditable(false);
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

    public void setTextArea(String text) {
	this.textArea.setText(text);
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

    public void mainMenu() {
	this.setMenu(000);
	this.button1.setText("Appoint Patient Consultation"); 	//appoint
	this.button2.setText("Update Patient Record");		//update
	this.button2.setText("Update Consultation");  	      	//consult
	this.button3.setText("Remove Unused/Dated Records");  	//remove
	this.button4.setText("Assign Doctor to Department");  	//assign
	this.button5.setText("Configure Department");         	//config
	this.button6.setText("Generate Reports");             	//report

	this.frame.add(this.button1);
	this.frame.add(this.button2);
	this.frame.add(this.button3);
	this.frame.add(this.button4);
	this.frame.add(this.button5);
	this.frame.add(this.button6);
    }

    public void appoint() {
	this.setMenu(100);
	this.button1.setText("Appoint for outdated/new user");
	this.button2.setText("Appoint for existing user");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
    }

    public void appointNew() {
	this.setMenu(110);
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
	this.label12.setText("Contact Person: ");
	this.label13.setText("Contact Person's Phone Number: ");
	this.label14.setText("Allergies: ");

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
	this.frame.add(textField5);
	this.frame.add(label8);
	this.frame.add(textField6);
	this.frame.add(label9);
	this.frame.add(textField7);
	this.frame.add(label10);
	this.frame.add(textField8);
	this.frame.add(label11);
	this.frame.add(textField9);
	this.frame.add(label12);
	this.frame.add(textField10);
	this.frame.add(label13);
	this.frame.add(textField11);
	this.frame.add(label14);
	this.frame.add(textField12);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void appointOld() {
	this.setMenu(120);
	this.label1.setText("Input patient ID: ");
	this.label2.setText("List of patients: ");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }

    public void appointPatient() {
	this.setMenu(101);
	this.label1.setText("Input available time (mm/dd/yyyy hh:mm): ");
	this.label2.setText("From ");
	this.label3.setText("To ");
	this.label4.setText("List of available doctors: ");
	this.label5.setText("Input doctor ID to select: ");
	this.button1.setText("Book Consultation");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(label2);
	this.frame.add(textField1);
	this.frame.add(label3);
	this.frame.add(textField2);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label4);
	this.frame.add(scrollPane);
	this.frame.add(label5);
	this.frame.add(textField3);
	this.frame.add(button1);
	this.frame.add(result2);
    }

    public void update() {
	this.setMenu(200);
	this.label1.setText("Input patient ID: ");
	this.label2.setText("List of patients: ");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }
					//the patient data is placed on the text fields by default
    public void updatePatient() {
	this.setMenu(210);
	this.label1.setText("Input Patient Data to update");
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
	this.label12.setText("Contact Person: ");
	this.label13.setText("Contact Person's Phone Number: ");
	this.label14.setText("Blood Type");
	this.label15.setText("Allergies: ");

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
	this.frame.add(textField5);
	this.frame.add(label8);
	this.frame.add(textField6);
	this.frame.add(label9);
	this.frame.add(textField7);
	this.frame.add(label10);
	this.frame.add(textField8);
	this.frame.add(label11);
	this.frame.add(textField9);
	this.frame.add(label12);
	this.frame.add(textField10);
	this.frame.add(label13);
	this.frame.add(textField11);
	this.frame.add(label14);
	this.frame.add(textField12);
	this.frame.add(label15);
	this.frame.add(textField13);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void consult() {
	this.setMenu(300);
	this.label1.setText("Input consultation ID");
	this.label2.setText("List of consultations");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }
					//can only update rating and notes
    public void consultUpdate() {
	this.setMenu(310);
	this.label1.setText("Update satisfaction rating: ");
	this.label2.setText("Update notes: ");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(textField2);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void remove() {
	this.setMenu(400);
	this.button1.setText("Remove patient records");
	this.button2.setText("Remove consultation records");
	this.button3.setText("Remove doctor records");

	this.frame.add(back);
	this.frame.add(button1);
	this.frame.add(button2);
	this.frame.add(button3);
    }

    public void removePatient() {
	this.setMenu(410);
	this.label1.setText("Input patient ID");
	this.label2.setText("List of patients");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }

    public void removeConsult() {
	this.setMenu(420);
	this.label1.setText("Input consultation ID");
	this.label2.setText("List of consultations");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }

    public void removeDoctor() {
	this.setMenu(430);
	this.label1.setText("Input doctor ID");
	this.label2.setText("List of doctors");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }

    public void assign() {
	this.setMenu(500);
	this.label1.setText("Input doctor ID to select");
	this.label2.setText("List of doctors");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }

    public void assignDep() {
	this.setMenu(510);
	this.label1.setText("Input department ID to assign doctor to");
	this.label2.setText("List of departments");
	
	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }

    public void config() {
	this.setMenu(600);
	this.label1.setText("Input department ID to configure");
	this.label2.setText("List of departments");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(confirm);
	this.frame.add(result1);
	this.frame.add(label2);
	this.frame.add(scrollPane);
    }

    public void configDep() {
	this.setMenu(610);
	this.label1.setText("Department name: ");
	this.label2.setText("Phone Number: ");
	this.label3.setText("Address: ");
	this.label4.setText("Street: ");
	this.label5.setText("City: ");
	this.label6.setText("Province: ");
	this.label7.setText("Postal Code: ");
	this.label8.setText("Email: ");
	this.label9.setText("Capacity: ");

	this.frame.add(back);
	this.frame.add(label1);
	this.frame.add(textField1);
	this.frame.add(label2);
	this.frame.add(textField2);
	this.frame.add(label3);
	this.frame.add(textField3);
	this.frame.add(label4);
	this.frame.add(textField4);
	this.frame.add(label5);
	this.frame.add(textField5);
	this.frame.add(label6);
	this.frame.add(textField6);
	this.frame.add(label7);
	this.frame.add(textField7);
	this.frame.add(label8);
	this.frame.add(textField8);
	this.frame.add(label9);
	this.frame.add(textField9);
	this.frame.add(confirm);
	this.frame.add(result1);
    }

    public void report() {
	this.setMenu(700);
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
	this.frame.add(scrollPane);
    }
}