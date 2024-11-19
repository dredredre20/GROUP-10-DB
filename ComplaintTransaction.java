import java.sql.*;
import java.util.*;


// Transactions 
public class ComplaintTransaction {
    Connection connect;
    String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
    String user = "root";
    String pass = "hello_peak17+11";
    

    public List<String> getComplaintList(){
        List<String> complaints =  new ArrayList<>();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "SELECT complaintDescription FROM complaints" +
                            "ORDER BY complaintDescription";

            PreparedStatement statement = connect.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                complaints.add(rs.getString("complaintDescription"));
            }

            connect.close();

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

        return complaints;
    }


    public void addNewComplaint (String description, String recSpecialization){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "INSERT INTO complaints (complaintDescription, recommendedSpecialization)" +
                            "VALUES (?, ?)";
            PreparedStatement ex_query = connect.prepareStatement(query);
            
            ex_query.setString(1, description);
            ex_query.setString(2, recSpecialization);
            ex_query.executeUpdate();

            connect.close();


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



    public void updateComplaintDetails (String description, String recSpecialization){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "UPDATE complaints " +
                            "SET complaintDescription = ?, recommendedSpecialization = ?" +
                            "WHERE complaintDescription = ?";
            
            PreparedStatement ex = connect.prepareStatement(query);
            ex.setString(1, description);
            ex.setString(2, recSpecialization);
            ex.setString(3, description);
            ex.executeQuery();

            connect.close();

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



    public void createConsultation (int patientID, int doctorID, Timestamp consultationDate){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "INSERT INTO (patientID, doctorID, consultationDate) VALUES (?, ?, ?)";

            PreparedStatement i = connect.prepareStatement(query);
            i.setInt(1, patientID);
            i.setInt(2, doctorID);
            i.setTimestamp(3, consultationDate);
            i.executeUpdate();

            connect.close();


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