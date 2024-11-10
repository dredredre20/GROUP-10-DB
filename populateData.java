import java.sql.*;

public class populateData {

    public static void main(String[] args){

        String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
        String user = "root";
        String pass = "edit this";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);
            System.out.println("Connceted to HMO database!");



            //Inserting values into address table
            Object[][] addressData = {
                {1128301398, "Blk 6, Lot 9 Cardiff Street, Mission Hills", "Mandaluyong City", "Manila", "1870"},
                {1811001002, "Cardiff Avenue, Marcos Highway", "Marikina", "Pasig", "1920"}, 
                {1121381012, "Blk 12, Lot 20 Tariff Hills, Brgy. San Jose", "Taytay", "Rizal", "1756"}
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
            insert_Address.close(); //close connection


            //Inserting values into department table
            Object[][] departmentData = {
                {1, "Radiology Lab", "09127612981", 1811001002, "radlab2004@gmail.com", 20}
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
            insert_dep.close(); //close connection


            //Inserting values into the doctor table 
            Object[][] doctorData = {
                {0111201110, "Chu", "Li yei", 1, "M", 97000, "1989-05-20 8:23:40", "09218021001",
                 1121381012, "1100-1002-1717", "Radiologist", "Chest Radiation", "12:00-17:00"}

            };

            String doc_query = "INSERT INTO doctors (doctorID, doctorLastName, doctorFirstName, departmentID, sex, salary, birthday," + 
                                "phoneNumber, addressID, licenseNumber, field, specialization, workingHours)" + 
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert_doc = connect.prepareStatement(doc_query);
            for (Object[] i: doctorData){
                insert_doc.setInt(1, (int) i[0]); //doctor id
                insert_doc.setString(2, (String) i[1]); //last name
                insert_doc.setString(3, (String) i[2]); //first name
                insert_doc.setInt(4, (int) i[3]); // department id
                insert_doc.setString(5, (String) i[4]); //sex
                insert_doc.setInt(6, (int) i[5]); //salary
                insert_doc.setTimestamp(7, Timestamp.valueOf(i[6].toString())); //birthday                
                insert_doc.setString(8, (String) i[7]); //phone number
                insert_doc.setInt(9, (int) i[8]); //address id
                insert_doc.setString(10, (String) i[9]); //license number
                insert_doc.setString(11, (String) i[10]); //field
                insert_doc.setString(12, (String) i[11]); //specialization
                insert_doc.setString(13, (String) i[12]); //working hours

                insert_doc.executeUpdate(); 

            }
            insert_doc.close(); //close connection


            //Inserting values into patient table
            Object [][] patientData = {
                {1234328500,"Chu", "Andre", "M", "2004-04-17 17:00:00", "09176710417", 1128301398, "Arlene Chu", "09945678109", "O+", "None"}
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
                insertQuery.setTimestamp(5, Timestamp.valueOf(entry[4].toString())); //birthday          
                insertQuery.setString(6, (String) entry[5]); //phone num
                insertQuery.setInt(7, (int) entry[6]); //address id
                insertQuery.setString(8, (String) entry[7]); //contact name
                insertQuery.setString(9, (String) entry[8]); //contact num
                insertQuery.setString(10, (String) entry[9]); //blood type
                insertQuery.setString(11, (String) entry[10]); //allergies
                insertQuery.executeUpdate();
            }

            insertQuery.close(); //close connection

            
            //Inserting values into consultations table
            Object[][] consultData = {
                {18, 1234328500, "2024-08-17 12:20:00", 82, "2024-08-17 15:30:00", "Yearly Lung X-Ray", 0111201110, "No abnormalities"}
            };
            String consult_query = "INSERT INTO consultations (consultationID, patientID, startDate, satisfactionRating," 
                                    + "endDate, reason, doctorID, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insert_consult = connect.prepareStatement(consult_query);

            for (Object[] j: consultData){
                insert_consult.setInt(1, (int) j[0]); //consultation id
                insert_consult.setInt(2, (int) j[1]);  //patient id
                insert_consult.setTimestamp(3, Timestamp.valueOf(j[2].toString())); //start date                
                insert_consult.setInt(4, (int) j[3]); //rating        
                insert_consult.setTimestamp(5, Timestamp.valueOf(j[4].toString()));  //end date              
                insert_consult.setString(6, (String) j[5]); //reason       
                insert_consult.setInt(7, (int) j[6]);  //doctor id                                                      
                insert_consult.setString(8, (String) j[7]); //notes
                insert_consult.executeUpdate();
            }
            insert_consult.close(); //close connection


            //Inserting head doctor value
            Object[][] headDocData = {
                {0111201110}
            };
            String headDoc_query = "UPDATE departments SET headDoctor = ? WHERE departmentID = 1";

            PreparedStatement insert_hDoc = connect.prepareStatement(headDoc_query);
            for (Object[] k: headDocData){
                insert_hDoc.setInt(1, (int) k[0]); //doctor id
                insert_hDoc.executeUpdate();
            }
            insert_hDoc.close(); //close connection



            connect.close(); //close connection to the DB

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
