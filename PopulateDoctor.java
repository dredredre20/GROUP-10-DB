import java.sql.*;

public class PopulateDoctor {
    
    public void doctor(){
        
        String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
        String user = "root";
        String pass = "hello_peak17+11";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);


            // doctor basic information 
            Object[][] doctorBasic = {
                //example data
                {123, "Wei Yi", "Li", "F", "1989-05-20 8:23:40", "09178716100", 
                "Cardiff Avenue, Marcos Highway, Marikina, Pasig City, 1920", "docLi@gmail.com"}
            };  

            String query = "INSERT INTO doctors (doctorID, lastName, firstName, sex, birthday, phoneNumber, address, email)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

                for (Object[] i: doctorBasic){
                    insert.setInt(1, (int) i[0]); //doctor id
                    insert.setString(2, (String) i[1]); //last name
                    insert.setString(3, (String) i[2]); //first name
                    insert.setString(4, (String) i[3]); //sex
                    insert.setTimestamp(5, Timestamp.valueOf(i[4].toString())); //birthday          
                    insert.setString(6, (String) i[5]); //phone number
                    insert.setString(7, (String) i[6]); //address
                    insert.setString(8, (String) i[7]); //email

                    insert.executeUpdate();
                }

            insert.close();
            

            
            //doctor work information
            Object[][] doctorWork = {
                //example data
                {123, 189000, "201-2101-0012", 1200, 1800, 35, 14}
            };  

            String query1 = "INSERT INTO doctorWorkInfo (doctorID, salary, licenseNumber, workingStart, workingEnd, maxPatientLoad, currentPatientLoad)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

                for (Object[] i: doctorWork){
                    insert1.setInt(1, (int) i[0]); //doctorID
                    insert1.setInt(2, (int) i[1]); //salary
                    insert1.setString(3, (String) i[2]); //license number
                    insert1.setInt(4, (int) i[3]); //working start
                    insert1.setInt(5, (int) i[4]); //working end
                    insert1.setInt(6, (int) i[5]); //max patient load
                    insert1.setInt(7, (int) i[6]); //current patient load

                    insert1.executeUpdate();
                }

            insert1.close();



            // doctor specialization
            Object[][] doctorSpecial = {
                //example data
                {123, "Heart Surgeon", "2022-08-19", "2027-08-19"}
            };  

            String query2 = "INSERT INTO doctorSpecializations (doctorID, name, certificateDate, expiryDate)" +
                            "VALUES (?, ?, ?, ?)";

            PreparedStatement insert2 = connect.prepareStatement(query2);

                for (Object[] i: doctorSpecial){
                    insert2.setInt(1, (int) i[0]); //doctorID
                    insert2.setString(2, (String) i[1]); //name
                    insert2.setString(3, (String)i[2]); //certificate date
                    insert2.setString(4, (String)i[3]); //expiry date

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
