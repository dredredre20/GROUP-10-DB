import java.sql.*;

public class populateData {

    public static void main(String[] args){

        String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
        String user = "root";
        String pass = ""; //insert own password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);
            System.out.println("Connceted to HMO database!");



            //Inserting values into address table
            Object[][] addressData = {
                {1128301398, "Blk 6, Lot 9", "Mandaluyong City", "Manila", "1870"},
                {1811001002, "Cardiff Avenue, Marcos Highway", "Marikina", "Pasig", "1920"}
            };

            String address_query = "INSERT INTO address (addressID, streetAddress, city, province, postalCode)" 
                                    + " VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement insert_Address = connect.prepareStatement(address_query);

            for (Object[] add: addressData){
                insert_Address.setInt(1, (int) add[0]); //address ID
                insert_Address.setString(2, (String) add[1]); //street address              
                insert_Address.setString(3, (String) add[2]); //city 
                insert_Address.setString(4, (String) add[3]); //province        
                insert_Address.setString(5, (String) add[4]); //postal code     
                insert_Address.executeUpdate();
            }
            insert_Address.close();


            //Inserting values into department table
            Object[][] departmentData = {
                {0000000001, "Radiology Lab", "09127612981", 1811001002, "radlab2004@gmail.com", 20}
            };

            String dep_query = "INSERT INTO departments (departmentID, departmentName, phoneNumber, addressID, email, capacity)" +
                                "VALUES (?, ?, ?, ?, ?, ?)"; 
            PreparedStatement insert_dep = connect.prepareStatement(dep_query);

            for (Object[] put: departmentData){
                insert_dep.setInt(1,(int) put[0]); //department id
                insert_dep.setString(2, (String) put[1]); //department name
                insert_dep.setString(3, (String) put[2]); //phone num
                insert_dep.setInt(4, (int) put[3]); //address id
                insert_dep.setString(5, (String) put[4]); //email
                insert_dep.setInt(6, (int) put[5]); //capacity

                insert_dep.executeUpdate();
            }
            insert_dep.close();


            //Inserting values into patient table
            Object [][] patientData = {
                {1234328500,"Chu", "Andre", "M", "2004-04-17", "09176710417", 1128301398, "Arlene Chu", "09945678109", "O+", "None"}
            };

            String update_query = "INSERT INTO patients (patientID, patientLastName, patientFirstName, sex, birthday," +
                                    "phoneNumber, addressID, contactPersonName, contactPersonNumber, bloodType, allergies)" +  
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insertQuery = connect.prepareStatement(update_query);

            for (Object[] entry: patientData){
                insertQuery.setInt(1, (int) entry[0]); //patient id
                insertQuery.setString(2, (String) entry[1]); //pLastname
                insertQuery.setString(3, (String) entry[2]); //pFirstname
                insertQuery.setString(4, (String) entry[3]); //sex
                insertQuery.setString(5, (String) entry[4]); //birthday
                insertQuery.setString(6, (String) entry[5]); //phone num
                insertQuery.setInt(7, (int) entry[6]); //address id
                insertQuery.setString(8, (String) entry[7]); //contact name
                insertQuery.setString(9, (String) entry[8]); //contact num
                insertQuery.setString(10, (String) entry[9]); //blood type
                insertQuery.setString(11, (String) entry[10]); //allergies
                insertQuery.executeUpdate();
            }

            insertQuery.close();
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
