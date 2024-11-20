import java.sql.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class Transactions {

    private String url;
    private String user;
    private String pass;

    public Transactions(String url, String user, String pass) {
	this.url = url;
	this.user = user;
	this.pass = pass;
    }

    public String getUrl() {
	return this.url;
    }

    public String getUser() {
	return this.user;
    }

    public String getPass() {
	return this.pass;
    }


    public int addDoctor(String last, String first, String sex, Timestamp birthday, String phoneNumber, String address, String email) {
	try {
	    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String query = "INSERT INTO doctors (doctorID, lastName, firstName, sex, birthday, phoneNumber, address, email)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement insert = connect.prepareStatement(query);
		
	    insert.setNull(1,0);
	    insert.setString(2, last);
	    insert.setString(3, first);
	    insert.setString(4, sex);
	    insert.setTimestamp(5, birthday);
	    insert.setString(6, phoneNumber);
	    insert.setString(7, address);
	    insert.setString(8, email);
            insert.executeUpdate();
	    insert.close();

	    String statement = "SELECT doctorID FROM doctors WHERE lastName = '" + last + "' AND firstName = '" + first + "' AND sex = '" + sex + "' AND phoneNumber = '" + phoneNumber + "' AND address = '" + address + "' AND email = '" + email + "'";
	    ResultSet result = connect.createStatement().executeQuery(statement);
	    int ID = 0;
	    while (result.next())
		ID = (int) result.getObject(1);
	    if (ID != 0)
		return ID;

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }

	return 0;
    }    

    public void editDoctor(int ID, String last, String first, String sex, Timestamp birthday, String phoneNumber, String address, String email) {
	try {
	    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String statement = "UPDATE doctors SET lastName = '" + last + "', firstName = '" + first + "', sex = '" + sex + "', phoneNumber = '" + phoneNumber + "', address = '" + address + "', email = '" + email + "' WHERE doctorID = " + ID;
            connect.createStatement().executeUpdate(statement);

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }    

    public JScrollPane viewRecord(String name) {
	Vector columns = new Vector();
	Vector rows = new Vector();
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
	    ResultSet result = connect.createStatement().executeQuery("SELECT * FROM " + name);
	    int records = result.getMetaData().getColumnCount();
	    for(int i=1; i<=records; i++)
		columns.addElement(result.getMetaData().getColumnName(i));
	    while (result.next()) {
		Vector row = new Vector(records);
		for(int i=1; i<=records; i++)
		    row.addElement(result.getObject(i));
	  	rows.addElement(row);
	    }
	    JTable table = new JTable(rows, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	    scrollPane.setPreferredSize(new Dimension(800, 800));
	    return scrollPane;

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
	    return null;
    }    

    public JScrollPane viewRecord2(String name, String key, int value) {
	Vector columns = new Vector();
	Vector rows = new Vector();
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
	    ResultSet result = connect.createStatement().executeQuery("SELECT * FROM " + name + " WHERE " + key + " = " + value);
	    int records = result.getMetaData().getColumnCount();
	    for(int i=1; i<=records; i++)
		columns.addElement(result.getMetaData().getColumnName(i));
	    while (result.next()) {
		Vector row = new Vector(records);
		for(int i=1; i<=records; i++)
		    row.addElement(result.getObject(i));
	  	rows.addElement(row);
	    }
	    JTable table = new JTable(rows, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	    scrollPane.setPreferredSize(new Dimension(800, 800));
	    return scrollPane;

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
	    return null;
    }    

    public String doctorAttribute(String attribute, int ID) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
	    ResultSet result = connect.createStatement().executeQuery("SELECT " + attribute + " FROM doctors WHERE doctorID = " + ID);
	    String selection = "";
	    while (result.next())
		selection = (String) result.getObject(1).toString();
	    if (selection != "")
		return selection;

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
	    return "";
    }

    public boolean doctorID(int ID) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String statement = "SELECT * FROM doctors WHERE doctorID = " + ID;
            connect.createStatement().executeQuery(statement);

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
	    return false;
        }
	return true;
    }    

    public void addDoctorWork(int ID, int salary, int licenseNumber, int startTime, int endTime, int max) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String query = "INSERT INTO doctorWorkInfo (doctorID, salary, licenseNumber, workingStart, workingEnd, maxPatientLoad, currentPatientLoad)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement insert = connect.prepareStatement(query);
		
	    insert.setInt(1,ID);
	    insert.setInt(2, salary);
	    insert.setInt(3, licenseNumber);
	    insert.setInt(4, startTime);
	    insert.setInt(5, endTime);
	    insert.setInt(6, max);
	    insert.setInt(7, 0);
            insert.executeUpdate();
	    insert.close();

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void editDoctorWork(int ID, int salary, int licenseNumber, int startTime, int endTime, int max) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
	    String statement = "UPDATE doctorWorkInfo SET salary = '" + salary + "', licenseNumber = '" + licenseNumber + "', workingStart = '" + startTime + "', workingEnd = '" + endTime + "', maxPatientLoad = '" + max + "' WHERE doctorID = " + ID;
            connect.createStatement().executeUpdate(statement);

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void addDoctorSpecial(int ID, String name, String field, Timestamp certificateDate, Timestamp expiryDate) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String query = "INSERT INTO doctorSpecializations (doctorID, name, field, certificateDate, expiryDate)" +
                            "VALUES (?, ?, ?, ?, ?)";
	    PreparedStatement insert = connect.prepareStatement(query);
		
	    insert.setInt(1,ID);
	    insert.setString(2,name);
	    insert.setString(3,field);
	    insert.setTimestamp(4,certificateDate);
	    insert.setTimestamp(5,expiryDate);
            insert.executeUpdate();
	    insert.close();

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void removeDoctorSpecial(int ID, String name) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String statement = "DELETE FROM doctorSpecializations WHERE doctorID = " + ID + " AND name = '" + name + "'";
	    connect.createStatement().executeUpdate(statement);

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public JScrollPane viewDoctorSpecial(int ID) {
	Vector columns = new Vector();
	Vector rows = new Vector();
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
	    ResultSet result = connect.createStatement().executeQuery("SELECT * FROM doctorSpecializations WHERE doctorID = " + ID);
	    int records = result.getMetaData().getColumnCount();
	    for(int i=1; i<=records; i++)
		columns.addElement(result.getMetaData().getColumnName(i));
	    while (result.next()) {
		Vector row = new Vector(records);
		for(int i=1; i<=records; i++)
		    row.addElement(result.getObject(i));
	  	rows.addElement(row);
	    }
	    JTable table = new JTable(rows, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	    scrollPane.setPreferredSize(new Dimension(800, 800));
	    return scrollPane;

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
	    return null;
    }    

    // for viewing complaints
    public JScrollPane viewComplaints() {

	    Vector columns = new Vector();
	    Vector rows = new Vector();

	    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

	        ResultSet result = connect.createStatement().executeQuery("SELECT complaintDescription FROM complaints" +
                            "ORDER BY complaintDescription");

	        int records = result.getMetaData().getColumnCount();

	    for(int i=1; i<=records; i++)

		    columns.addElement(result.getMetaData().getColumnName(i));
            
	    while (result.next()) {
        
		    Vector row = new Vector(records);
            
		for(int i=1; i<=records; i++)

		    row.addElement(result.getObject(i));

	  	    rows.addElement(row);
	    }
	        JTable table = new JTable(rows, columns);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

	        scrollPane.setPreferredSize(new Dimension(800, 800));
	        return scrollPane;

	    } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
	        return null;
    }

    // add lab request
    public void addLabReq(int labID, int consultID, int docID) {
        try {
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
                String statement = "INSERT INTO labRequest (laboratoryID, consultationID, issuedBy)" +
                                "VALUES (?, ?, ?)";

                PreparedStatement insert = connect.prepareStatement(statement);
            
                insert.setInt(1, labID);
                insert.setInt(2, consultID);
                insert.setInt(3, docID);

                insert.executeUpdate();
                insert.close();
    
        } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
                e.printStackTrace();
                
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }

    } 


    // adding diagnosis
    public void addDiagnosis(int consultID, String diagDesrciption, String severity) {
        try {
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
                String statement = "INSERT INTO diagnosis (consultationID, diagnosisDescription, severity)" +
                                "VALUES (?, ?, ?)";

                PreparedStatement insert = connect.prepareStatement(statement);
            
                insert.setInt(1, consultID);
                insert.setString(2, diagDesrciption);
                insert.setString(3, severity);

                insert.executeUpdate();
                insert.close();
    
        } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
                e.printStackTrace();
                
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }

    }


    // adding prescription
    public void addPrescription(int consultID, int medicineID, String dosage, String frequency, Timestamp startDate, Timestamp endDate, String notes){
        try {
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
                String statement = "INSERT INTO diagnosis (medicineID, consultationID, dosage, frequency, startDate, endDate, notes)" +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement insert = connect.prepareStatement(statement);
            
                insert.setInt(1, medicineID);
                insert.setInt(2, consultID);
                insert.setString(3, dosage);
		insert.setString(4, frequency);
                insert.setTimestamp(5, startDate);
                insert.setTimestamp(6, endDate);
                insert.setString(7, notes);
                insert.executeUpdate();
                insert.close();
    
        } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
                e.printStackTrace();
                
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }

    }

    public void removeRecord(String record, String key, String value) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String statement = "DELETE FROM " + record + " WHERE " + key + " = '" + value + "'";
	    connect.createStatement().executeUpdate(statement);

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void removeRecord2(String record, String key, String value, String key2, int value2) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String statement = "DELETE FROM " + record + " WHERE " + key + " = '" + value + "' AND " + key2 + " = '" + value2 + "'";
	    connect.createStatement().executeUpdate(statement);

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void editRecord(String record, String key, String value, String IDName, int ID) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String statement = "UPDATE " + record + " SET " + key + " = '" + value + "' WHERE " + IDName + " = " + ID;
	    connect.createStatement().executeUpdate(statement);

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public String getRecordAttribute(String record, String attribute, String IDName, String ID) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
	    ResultSet result = connect.createStatement().executeQuery("SELECT " + attribute + " FROM " + record + " WHERE " + IDName + " = '" + ID + "'");
	    String selection = "";
	    while (result.next())
		selection = (String) result.getObject(1).toString();
	    if (selection != "")
		return selection;

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
	    return "";
    }



//adding patient 
    public int addPatient(String last, String first, String sex, Timestamp birthday , String phoneNumber, String address, String bloodType, String allergies){
        try {
	    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String query = "INSERT INTO patients (patientID, patientLastName, patientFirstName, sex, birthday, phoneNumber, address, bloodType, allergies)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement insert = connect.prepareStatement(query);
            
	        insert.setNull(1,0);
	        insert.setString(2, last);
	        insert.setString(3, first);
	        insert.setString(4, sex);
	        insert.setTimestamp(5, birthday);
	        insert.setString(6, phoneNumber);
	        insert.setString(7, address);
	        insert.setString(8, bloodType);
            insert.setString(9, allergies);
                insert.executeUpdate();
	        insert.close();

	        String statement = "SELECT doctorID FROM doctors WHERE lastName = '" + last + "' AND firstName = '" + first + "' AND sex = '" + sex + "' AND phoneNumber = '" + phoneNumber + "' AND address = '" + address + "'";
	        ResultSet result = connect.createStatement().executeQuery(statement);

	        int ID = 0;

	        while (result.next())
		        ID = (int) result.getObject(1);
	        if (ID != 0)
		        return ID;

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }

	return 0;
    }


    //adding lab
    public void addLab(String labName, String street, String city, String province, String postalCode, String phoneNum){
        try {
	    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            String address = street + ", " + city  + ", " + province + ", " + postalCode;

            String query = "INSERT INTO laboratory (laboratoryID, name, address, phoneNumber)" +
                            "VALUES (?, ?, ?, ?)";
	        PreparedStatement insert = connect.prepareStatement(query);
            
	        insert.setNull(1,0);
	        insert.setString(2, labName);
	        insert.setString(3, address);
	        insert.setString(4, phoneNum);

                insert.executeUpdate();
	        insert.close();

	    } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }


    //editing lab details
    public void editLab(int labID, String labName, String street, String city, String province, String postalCode, String phoneNum) {
        try {
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());


                String address = street + ", " + city  + ", " + province + ", " + postalCode;

                String statement = "UPDATE laboratory SET name = '" + labName + "', address = '" + address + "', phoneNumber = '" + phoneNum + "' WHERE = " + labID; 
                
                connect.createStatement().executeQuery(statement);
    
        } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
                e.printStackTrace();
                
            } catch (SQLException e) {
                System.err.println("Database connection error:");
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
                e.printStackTrace();
            }
    }

    // add chief complaint 
    public int addComplaint(String description, String recSpecialization){
        try {
	    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            String query = "INSERT INTO complaints (complaintDescription, recommendedSpecialization)" +
                            "VALUES (?, ?)";
	        PreparedStatement insert = connect.prepareStatement(query);
            
	        insert.setString(1, description);
	        insert.setString(2, recSpecialization);

                insert.executeUpdate();
	        insert.close();

            String statement = "SELECT * FROM complaints WHERE complaintDescription = '" +  description + "', recommendedSpecialization = '" + recSpecialization + "'";
	        ResultSet result = connect.createStatement().executeQuery(statement);

	        int ID = 0;

	        while (result.next())
		        ID = (int) result.getObject(1);
	        if (ID != 0)
		        return ID;

	    } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }

        return 0;
    }

	// edit chief complaint 
    public void editComplaint(String description, String recSpecialization){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            String query = "UPDATE complaints SET complaintDescription = '" + description + "', recommendedSpecialization = '" + recSpecialization;
	        connect.createStatement().executeQuery(query);

	    } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    // add medicine
    public void addMedicine(String brandName, String commonName, int quantity, int availability){
        try {
	    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            String query = "INSERT INTO medicine (medicineID, brandName, commonName, quantity, availability)" +
                            "VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement insert = connect.prepareStatement(query);
            
	        insert.setNull(1,0);
	        insert.setString(2, brandName);
	        insert.setString(3, commonName);
	        insert.setInt(4, quantity);
            insert.setInt(5, availability);

                insert.executeUpdate();
	        insert.close();

	    } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    // edit medicine
    public void editMedicine(String brandName, String commonName, int quantity, int availability){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            String query = "UPDATE medicine SET brandName = '" + brandName + "', commonName = '" + commonName + "', quantity = '" + quantity + "', availability = '" + availability;
	        connect.createStatement().executeQuery(query);

	    } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

     // book consultation
    public void bookAppointment(Timestamp from, Timestamp to, String complaint, int doctorID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
            String query = "INSERT INTO consultations (consultationID, patientID, doctorID, consultationDate, satisfactionRating, startDate, endDate)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement insert = connect.prepareStatement(query);
		
	    insert.setNull(1,0); // not final
        insert.setNull(2,0); // not final
        insert.setNull(3,0); // not final
	    insert.setNull(4, 0); // not final
	    insert.setNull(5, 0); // not final
	    insert.setTimestamp(6, from);
	    insert.setTimestamp(7, to);
            insert.executeUpdate();
	    insert.close();

	} catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Database connection error:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }
}
