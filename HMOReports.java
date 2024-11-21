import java.sql.*;


// Generating reports
public class HMOReports {

    private String url;
    private String user;
    private String pass;

    public HMOReports(String url, String user, String pass) {
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


    // monthly performance evaluation
    public void monthlyPerformanceEvaluation(int year, int month){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            String query = "SELECT " +
                        "d.doctorID, " +
                        "d.lastName, " +
                        "d.firstName, " +
                        "dw.maxPatientLoad AS max_capacity, " +
                        "COUNT(c.consultationID) AS patient_load, " +
                        "ROUND((COUNT(c.consultationID) / dw.maxPatientLoad) * 100, 2) AS capacity_utilization_percentage, " +
                        "AVG(c.satisfactionRating) AS avg_satisfaction_from_patients " +
                        "FROM doctors d " +
                        "JOIN consultations c ON d.doctorID = c.doctorID " +
                        "JOIN doctorWorkInfo dw ON d.doctorID = dw.doctorID " +
                        "WHERE YEAR(c.startDate) = ? AND MONTH(c.startDate) = ? " +
                        "GROUP BY d.doctorID " +
                        "ORDER BY capacity_utilization_percentage DESC, avg_satisfaction_from_patients DESC";
            

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


    // yearly performance evaluation
    public void YearlyPerformanceEvaluation(int year){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            String query = "SELECT " +
                        "d.doctorID, " +
                        "d.lastName, " +
                        "d.firstName, " +
                        "dw.maxPatientLoad AS max_capacity, " +
                        "COUNT(c.consultationID) AS patient_load, " +
                        "ROUND((COUNT(c.consultationID) / dw.maxPatientLoad) * 100, 2) AS capacity_utilization_percentage, " +
                        "AVG(c.satisfactionRating) AS avg_satisfaction_from_patients " +
                        "FROM doctors d " +
                        "JOIN consultations c ON d.doctorID = c.doctorID " +
                        "JOIN doctorWorkInfo dw ON d.doctorID = dw.doctorID " +
                        "WHERE YEAR(c.startDate) = ? " +
                        "GROUP BY d.doctorID " +
                        "ORDER BY capacity_utilization_percentage DESC, avg_satisfaction_from_patients DESC";

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
