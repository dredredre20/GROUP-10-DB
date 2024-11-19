import java.sql.*;

public class PopulateConsul1 {
    public void consultations1(){

        String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
        String user = "root";
        String pass = "hello_peak17+11";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);

            // consultation information
            Object[][] consulInfo = {
                //example data
                {1782, 1009, 123, "2024-08-19 13:00:00", 100, "2024-08-19 13:30:00", "2024-08-23 14:00:00"}
            };  

            String query = "INSERT INTO consultations (consultationID, patientID, doctorID, consultationDate, " +   
                            "satisfactionRating, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

                for (Object[] i: consulInfo){
                    insert.setInt(1, (int) i[0]); // consultation id
                    insert.setInt(2, (int) i[1]); // patient id
                    insert.setInt(3, (int) i[2]); // doctor id
                    insert.setTimestamp(4, Timestamp.valueOf(i[3].toString())); // consultation date
                    insert.setInt(5, (int) i[4]); // satisfaction rating
                    insert.setTimestamp(6, Timestamp.valueOf(i[5].toString())); // start date  
                    insert.setTimestamp(7, Timestamp.valueOf(i[6].toString())); // end date       

                    insert.executeUpdate();
                }

            insert.close();


            // lab info
            Object[][] labInfo = {
                //example data
                {1456, "Charte's Cardiology Lab", "Poblacion 2, Gerona, Laguna, 1920", "09817231012"}
            };  

            String query1 = "INSERT INTO laboratory (laboratoryID, name, address, phoneNumber) VALUES (?, ?, ?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

                for (Object[] i: labInfo){
                    insert1.setInt(1, (int) i[0]); // lab id
                    insert1.setString(2, (String) i[1]); // name
                    insert1.setString(3, (String) i[2]); // address
                    insert1.setString(4, (String) i[3]);  //phone numbert1
                    insert1.executeUpdate();
                }

            insert1.close();


            // lab req information
            Object[][] labReqInfo = {
                //example data
                {1456, 1782, 123}
            };  

            String query2 = "INSERT INTO labRequest (laboratoryID, consultationID, issuedBy) VALUES (?, ?, ?)";

            PreparedStatement insert2 = connect.prepareStatement(query2);

                for (Object[] i: labReqInfo){
                    insert2.setInt(1, (int) i[0]); // lab id
                    insert2.setInt(2, (int) i[1]); // consul id
                    insert2.setInt(3, (int) i[2]); // doc id
                    insert2.executeUpdate();
                }

            insert2.close();
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
