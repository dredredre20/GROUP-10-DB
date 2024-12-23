import java.sql.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;

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
    public JScrollPane monthlyPerformanceEvaluation(int year, int month){
        Vector columns = new Vector();
        Vector rows = new Vector();
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
                ResultSet result = access.executeQuery();
                
    
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
    
            access.close();
    
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
    
    
        // yearly performance evaluation
        public JScrollPane YearlyPerformanceEvaluation(int year){
        Vector columns = new Vector();
        Vector rows = new Vector();
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
            ResultSet result = access.executeQuery();
                
    
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
    
    
            access.close();
    
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
    
    
    
        // monthly acconomodations 
        public JScrollPane monthlyPatientAccomodations(int year, int month){
            Vector columns = new Vector();
            Vector rows = new Vector();
    
            try {
    
                Class.forName("com.mysql.cj.jdbc.Driver");
    
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
    
    
                // sub query will retrieve total count of unique patients in the entire data set
    
                String query = "SELECT " +
                            "YEAR(c.consultationDate) AS year, " +
                            "MONTH(c.consultationDate) AS month, " +
                            "COUNT(DISTINCT c.patientID) AS avg_patients_per_month, " +
                            "COUNT(c.consultationID) AS total_consultations, " +
                            "ROUND(COUNT(DISTINCT c.patientID) * 100.0 /(SELECT COUNT(DISTINCT patientID) FROM consultations), 2) AS patient_percentage " +
                            "FROM consultations c " +
                            "WHERE YEAR(c.consultationDate) = ? AND MONTH(c.consultationDate) = ? " +
                            "GROUP BY YEAR(c.consultationDate), MONTH(c.consultationDate) " +
                            "ORDER BY patient_percentage DESC, total_consultations DESC";
                
    
                PreparedStatement access = connect.prepareStatement(query);
    
                access.setInt(1, year);
                access.setInt(2, month);
                ResultSet result = access.executeQuery();
                
    
                int records = result.getMetaData().getColumnCount();
                for(int i=1; i<=records; i++)
                    columns.addElement(result.getMetaData().getColumnName(i));
    
                while (result.next()) {
                    Vector row = new Vector(records);
    
                    for (int i=1; i<=records; i++)
                        row.addElement(result.getObject(i));
                      rows.addElement(row);
                }
    
                JTable table = new JTable(rows, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
                scrollPane.setPreferredSize(new Dimension(800, 800));
    
    
                access.close();
    
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
    
        // yearly patient accomodations
        public JScrollPane yearlyPatientAccomodations(int year){
            Vector columns = new Vector();
            Vector rows = new Vector();
    
            try {
    
                Class.forName("com.mysql.cj.jdbc.Driver");
    
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
    
                String query = "SELECT " +
                            "YEAR(c.consultationDate) AS year, " +
                            "COUNT(DISTINCT c.patientID) AS avg_patients_per_month, " +
                            "COUNT(c.consultationID) AS total_consultations, " +
                            "ROUND(COUNT(DISTINCT c.patientID) * 100.0 /(SELECT COUNT(DISTINCT patientID) FROM consultations), 2) AS patient_percentage " +
                            "FROM consultations c " +
                            "WHERE YEAR(c.consultationDate) = ? " +
                            "GROUP BY YEAR(c.consultationDate) " +
                            "ORDER BY patient_percentage DESC, total_consultations DESC";
    
                PreparedStatement access = connect.prepareStatement(query);
    
                access.setInt(1, year);
                ResultSet result = access.executeQuery();
                
    
    
                int records = result.getMetaData().getColumnCount();
                for(int i=1; i<=records; i++)
                    columns.addElement(result.getMetaData().getColumnName(i));
    
                while (result.next()) {
                    Vector row = new Vector(records);
    
                    for (int i=1; i<=records; i++)
                        row.addElement(result.getObject(i));
                      rows.addElement(row);
                }
    
                JTable table = new JTable(rows, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
                scrollPane.setPreferredSize(new Dimension(800, 800));
    
                
                access.close();
    
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
    
        
        // monthly health risk report
        public JScrollPane monthlyHealthRiskReport(int year, int month){
            Vector columns = new Vector();
            Vector rows = new Vector();
    
            try {
    
                Class.forName("com.mysql.cj.jdbc.Driver");
    
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
                String query = "SELECT YEAR(c.consultationDate) as year, MONTH(c.consultationDate) as month, " + 
                                "p.sex, " + 
                                "TIMESTAMPDIFF(YEAR, p.birthday, c.consultationDate) as age, " + 
                                "d.diagnosisDescription, " + 
                                "d.severity, " + 
                                "COUNT(d.diagnosisDescription) AS diagnosis_count " + 
                                "FROM patients p " +
                                "JOIN consultations c ON p.patientID = c.patientID " +
                                "JOIN diagnosis d ON c.consultationID = d.consultationID " +
                                "WHERE YEAR(c.consultationDate) = ? AND MONTH(c.consultationDate) = ? " +
                                "GROUP BY YEAR(c.consultationDate), MONTH(c.consultationDate), p.sex, age, d.diagnosisDescription, d.severity " + 
                                "ORDER BY year, month, diagnosis_count DESC;"; 
                               
                               // Select age, gender, medicine and previous diagnosis that may increase patient susceptibility
    
                PreparedStatement access = connect.prepareStatement(query);
    
                access.setInt(1, year);
                access.setInt(2, month);
                ResultSet result = access.executeQuery();            
    
                int records = result.getMetaData().getColumnCount();
                for(int i=1; i<=records; i++)
                    columns.addElement(result.getMetaData().getColumnName(i));
    
                while (result.next()) {
                    Vector row = new Vector(records);
    
                    for (int i=1; i<=records; i++)
                        row.addElement(result.getObject(i));
                      rows.addElement(row);
                }
    
                JTable table = new JTable(rows, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
                scrollPane.setPreferredSize(new Dimension(800, 800));
    
                access.close();
    
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
    
         // yearly health risk report
        public JScrollPane yearlyHealthRiskReport(int year){
            Vector columns = new Vector();
            Vector rows = new Vector();
    
            try {
    
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
                String query = "SELECT YEAR(c.consultationDate) as year, " + 
                                "p.sex, " + 
                                "TIMESTAMPDIFF(YEAR, p.birthday, c.consultationDate) as age, " + 
                                "d.diagnosisDescription, " + 
                                "d.severity, " + 
                                "COUNT(d.diagnosisDescription) AS diagnosis_count " + 
                                "FROM patients p " +
                                "JOIN consultations c ON p.patientID = c.patientID " +
                                "JOIN diagnosis d ON c.consultationID = d.consultationID " +
                                "WHERE YEAR(c.consultationDate) = ? " +
                                "GROUP BY YEAR(c.consultationDate), p.sex, age, d.diagnosisDescription, d.severity " + 
                                "ORDER BY year, diagnosis_count DESC;";
    
                PreparedStatement access = connect.prepareStatement(query);
    
                access.setInt(1, year);
                ResultSet result = access.executeQuery();            
    
                int records = result.getMetaData().getColumnCount();
                for(int i=1; i<=records; i++)
                    columns.addElement(result.getMetaData().getColumnName(i));
    
                while (result.next()) {
                    Vector row = new Vector(records);
    
                    for (int i=1; i<=records; i++)
                        row.addElement(result.getObject(i));
                      rows.addElement(row);
                }
    
                JTable table = new JTable(rows, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
                scrollPane.setPreferredSize(new Dimension(800, 800));
    
                access.close();
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
    
    
         // monthly commission report
        public JScrollPane monthlyCommissionReport(int year, int month){
            Vector columns = new Vector();
            Vector rows = new Vector();
    
            try {
    
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
                String query = "SELECT " + "AVG(dw.salary) AS average_salary, ds.name, ds.field " +
                               "FROM doctors d " + 
                               "JOIN doctorWorkInfo dw ON d.doctorID = dw.doctorID " +
                               "JOIN doctorSpecializations ds ON d.doctorID = ds.doctorID " + 
                               "JOIN consultations c ON d.doctorID = c.doctorID " + 
                               "WHERE YEAR(c.consultationDate) = ? AND MONTH(c.consultationDate) = ? " +
                               "GROUP BY ds.name, ds.field " +
                               "ORDER BY ds.name, average_salary DESC; ";
    
                PreparedStatement access = connect.prepareStatement(query);
    
                access.setInt(1, year);
                access.setInt(2, month);
                ResultSet result = access.executeQuery();            
                int records = result.getMetaData().getColumnCount();
                for(int i=1; i<=records; i++)
                    columns.addElement(result.getMetaData().getColumnName(i));
    
                while (result.next()) {
                    Vector row = new Vector(records);
    
                    for (int i=1; i<=records; i++)
                        row.addElement(result.getObject(i));
                      rows.addElement(row);
                }
    
                JTable table = new JTable(rows, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
                scrollPane.setPreferredSize(new Dimension(800, 800));
    
                
                access.close();
    
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
    
         // yearly commission report
        public JScrollPane yearlyCommissionReport(int year){
    
            Vector columns = new Vector();
            Vector rows = new Vector();
    
            try {
    
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connect = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
                String query = "SELECT " + "AVG(dw.salary) AS average_salary, ds.name, ds.field " +
                               "FROM doctors d " + 
                               "JOIN doctorWorkInfo dw ON d.doctorID = dw.doctorID " +
                               "JOIN doctorSpecializations ds ON d.doctorID = ds.doctorID " +
                               "JOIN consultations c ON d.doctorID = c.doctorID " + 
                               "WHERE YEAR(c.consultationDate) = ? " +
                               "GROUP BY ds.name, ds.field  " +
                               "ORDER BY ds.name, average_salary DESC; ";
    
                PreparedStatement access = connect.prepareStatement(query);
    
                access.setInt(1, year);
                ResultSet result = access.executeQuery();            
                
    
    
                int records = result.getMetaData().getColumnCount();
                for(int i=1; i<=records; i++)
                    columns.addElement(result.getMetaData().getColumnName(i));
    
                while (result.next()) {
                    Vector row = new Vector(records);
    
                    for (int i=1; i<=records; i++)
                        row.addElement(result.getObject(i));
                      rows.addElement(row);
                }
    
                JTable table = new JTable(rows, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
                scrollPane.setPreferredSize(new Dimension(800, 800));
    
                
                access.close();
    
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
