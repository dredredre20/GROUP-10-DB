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

    public void addDoctor(String last, String first, String sex, Timestamp birthday, String phoneNumber, String address, String email) {
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

//SELECT queries return a JScrollPane to be displayed on the application which must be referenced in the Controller object that sets it as a parameter in a View function
//ex. (in Controller file) view.patientOld(transactions.viewPatient());
    public JScrollPane viewDoctor() {
	Vector columns = new Vector();
	Vector rows = new Vector();
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
	    ResultSet result = connect.createStatement().executeQuery("SELECT * FROM doctors");
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
}
