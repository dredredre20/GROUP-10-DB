import java.sql.*;

public class PopulateConsul2 {
    
    public void consultations2(){

        String hmo_url = "jdbc:mysql://127.0.0.1:3306/hmo";
        String user = "root";
        String pass = "hello_peak17+11";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(hmo_url, user, pass);


            // complaint info
            Object[][] comp = {
                //example data
                {"heart pain", "Cardiologist"}
            };  

            String query = "INSERT INTO complaints (complaintDescription, recommendedSpecialization) VALUES (?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

                for (Object[] i: comp){
                    insert.setString(1, (String) i[0]); //complaint description
                    insert.setString(2, (String) i[1]); // rec specialization

                    insert.executeUpdate();
                }

            insert.close();

            

            //consultation complaints
            Object[][] comp1 = {
                //example data
                {1782, "heart pain"}
            };  

            String query1 = "INSERT INTO consultationComplaints (consultationID, complaintDescription) VALUES (?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

                for (Object[] i: comp1){
                    insert1.setInt(1, (int) i[0]); // consult id
                    insert1.setString(2, (String) i[1]); // complaint descriptiont1
                    insert1.executeUpdate();
                }

            insert1.close();


            // diagnosis
            Object[][] diag = {
                //example data
                {1782, "lack of exercise", "mild"}
            };  

            String query2 = "INSERT INTO diagnosis (consultationID, diagnosisDescription, severity) VALUES (?, ?, ?)";

            PreparedStatement insert2 = connect.prepareStatement(query2);

                for (Object[] i: diag){
                    insert2.setInt(1, (int) i[0]); // consult id
                    insert2.setString(2, (String) i[1]); // diagnosis description            
                    insert2.setString(3, (String) i[2]); // severityt2
                    insert2.executeUpdate();
                }

            insert2.close();



            // Medicine
            Object[][] med = {
                //example data
                {42513, "Baxter", "Nitroglycerin", 30, 15}
            };  

            String query3 = "INSERT INTO medicine (medicineID, brandName, commonName, quantity, availability) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement insert3 = connect.prepareStatement(query3);

                for (Object[] i: med){
                    insert3.setInt(1, (int) i[0]); // medicine id
                    insert3.setString(2, (String) i[1]); // brand name          
                    insert3.setString(3, (String) i[2]); // common name
                    insert3.setInt(4, (int) i[3]); //quantity
                    insert3.setInt(5, (int) i[4]); //availability 
                    insert3.executeUpdate();
                }

            insert3.close();


            
            // prescription
            Object[][] pres = {
                //example data
                {42513, 1782, "Once", "Per day", "2024-08-26", "2024-09-01", "Mild pain only. Should be resolved with medication"}
            };  

            String query4 = "INSERT INTO prescription (medicineID, consultationID, dosage, frequency, startDate, endDate, notes)" + 
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert4 = connect.prepareStatement(query4);

                for (Object[] i: pres){
                    insert4.setInt(1, (int) i[0]); // medicine id
                    insert4.setInt(2, (int) i[1]); // consult id
                    insert4.setString(3, (String) i[2]); // dosage     
                    insert4.setString(4, (String) i[3]); // frequency
                    insert4.setString(5, (String) i[4]); // start date          
                    insert4.setString(6, (String) i[5]); // end date
                    insert4.setString(7, (String) i[6]); // notes  
                    insert4.executeUpdate();
                }

            insert4.close();


        
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
