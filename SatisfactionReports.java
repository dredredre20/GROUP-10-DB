import java.sql.*;


// Satisfaction Reports
public class SatisfactionReports {

    Connection connect;
    String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
    String user = "root";
    String pass = "hello_peak17+11";

    public void MonthlyReportSatisfactionRating(int year, int month){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "SELECT d.doctorID, d.lastName, d.firstName, AVG(c.satisfactionRating) AS avg_satisfaction_from_patients\n" + //
                                "FROM doctors d\n" + //
                                "JOIN consultations c ON d.doctorID = c.doctorID\n" + //
                                "WHERE YEAR(c.startDate) = ? AND MONTH(c.startDate) = ?\n" + //
                                "GROUP BY d.doctorID\n" + //
                                "ORDER BY avg_satisfaction_from_patients DESC;";

            PreparedStatement access = connect.prepareStatement(query);

            access.setInt(1, year);
            access.setInt(2, month);
            access.executeUpdate();
            
            access.close();

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


    public void YearlySatisfactionRatiing(int year){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "SELECT d.doctorID, d.lastName, d.firstName, AVG(c.satisfactionRating) AS avg_satisfaction_from_patients\n" + //
                                "FROM doctors d\n" + //
                                "JOIN consultations c ON d.doctorID = c.doctorID\n" + //
                                "WHERE YEAR(c.startDate) = ?\n" + //
                                "GROUP BY d.doctorID\n" + //
                                "ORDER BY avg_satisfaction_from_patients DESC;";

            PreparedStatement access = connect.prepareStatement(query);

            access.setInt(1, year);
            access.executeUpdate();
            
            access.close();

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
