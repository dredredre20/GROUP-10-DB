import java.sql.*;

public class PopulatePatient {
    public static void main(String[] args){

        String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
        String user = "root";
        String pass = "hello_peak17+11";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);


            // patient basic information
            Object[][] patientInfo = {
                //example data
                {1009, "Chu", "Andre", "M", "2004-04-17 17:00:00", "09176710417", 
                "Blk 6, Lot 9 Cardiff Street, Mission Hills, Mandaluyong City, Metro Manila, 1870", "O+", "None"}
            };  

            String query = "INSERT INTO patients (patientID, patientLastName, patientFirstName, sex, birthday," +
                            "phoneNumber, address,  bloodType, allergies) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

                for (Object[] i: patientInfo){
                    insert.setInt(1, (int) i[0]); //patient id
                    insert.setString(2, (String) i[1]); //pLastname
                    insert.setString(3, (String) i[2]); //pFirstname
                    insert.setString(4, (String) i[3]); //sex
                    insert.setTimestamp(5, Timestamp.valueOf(i[4].toString())); //birthday          
                    insert.setString(6, (String) i[5]); //phone num
                    insert.setString(7, (String) i[6]); //address
                    insert.setString(8, (String) i[7]); //blood type
                    insert.setString( 9, (String) i[8]); //allergies

                    insert.executeUpdate();
                }

            insert.close();


            // contact person information
            Object[][] contactInfo = {
                //example data
                {1009, "Arlene", "Chu", "09945678109", "Mother"}
            };  

            String query1 = "INSERT INTO contactPerson (patientID, firstName, lastName, phoneNumber, relationship)" 
                             + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

                for (Object[] i: contactInfo){
                    insert1.setInt(1, (int) i[0]); // patient id
                    insert1.setString(2, (String) i[1]); // first name
                    insert1.setString(3, (String) i[2]); //last name
                    insert1.setString(4, (String) i[3]); // phone num
                    insert1.setString(5, (String) i[4]); // relationship
                    insert1.executeUpdate();
                }

            insert1.close();
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
