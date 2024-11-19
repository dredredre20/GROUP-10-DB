import java.sql.*;


// Capacity Utilization Reports
public class NumPatientReports {

    Connection connect;
    String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
    String user = "root";
    String pass = "hello_peak17+11";

    public void MonthlyCapacityUtilization(int year, int month){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "SELECT d.doctorID, d.lastName, d.firstName, dw.maxPatientLoad AS max_capacity,\n" + //
                                "\t\tCOUNT(c.consultationID) AS avg_patient_load, \n" + //
                                "        ROUND((COUNT(c.consultationID) / dw.maxPatientLoad) * 100, 2) AS capacity_utilization_percentage\n" + //
                                "FROM doctors d \n" + //
                                "JOIN consultations c ON d.doctorID = c.doctorID\n" + //
                                "JOIN doctorWorkIndo dw ON d.doctorID = dw.doctorID\n" + //
                                "WHERE YEAR(c.startDate) = ? AND MONTH(c.startDate) = ?\n" + //
                                "GROUP BY d.doctorID\n" + //
                                "ORDER BY capacity_utilization_percentage DESC;";

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


    public void YearlyCapacityUtilization(int year){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            String query = "SELECT d.doctorID, d.lastName, d.firstName, dw.maxPatientLoad AS max_capacity,\n" + //
                                "\t\tCOUNT(c.consultationID) AS avg_patient_load, \n" + //
                                "        ROUND((COUNT(c.consultationID) / dw.maxPatientLoad) * 100, 2) AS capacity_utilization_percentage\n" + //
                                "FROM doctors d \n" + //
                                "JOIN consultations c ON d.doctorID = c.doctorID\n" + //
                                "JOIN doctorWorkIndo dw ON d.doctorID = dw.doctorID\n" + //
                                "WHERE YEAR(c.startDate) = ?\n" + //
                                "GROUP BY d.doctorID\n" + //
                                "ORDER BY capacity_utilization_percentage DESC;";

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
