import java.sql.*;

public class PopulateConsul1 {

    private String hmo_url;
    private String user;
    private String pass;

    public PopulateConsul1(String hmo, String user, String pass){
        
        this.hmo_url = hmo;
        this.user = user;
        this.pass = pass;
    }

    public void consultations1(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.hmo_url, this.user, this.pass);

            // consultation information
            Object[][] consulInfo = {
                    // example data
                    { 1001, 2001, 3001, "2024-11-15 10:00:00", 9, "2024-11-22 00:00:00", "2024-11-29 00:00:00" },
                    { 1002, 2002, 3002,  "2024-11-16 11:15:00", 8, "2024-11-22 00:00:00", "2024-11-27 00:00:00" },
                    { 1003, 2003, 3003,  "2024-11-17 09:30:00", 10, "2024-11-22 00:00:00", "2024-12-01 00:00:00" },
                    { 1004, 2004, 3004,  "2024-11-18 13:00:00", 7, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1005, 2005, 3005,  "2024-11-19 14:45:00", 6, "2024-11-22 00:00:00", "2025-01-22 00:00:00" },
                    { 1006, 2006, 3006,  "2024-11-20 08:00:00", 10, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1007, 2007, 3007, "2024-11-21 10:00:00", 8, "2024-11-22 00:00:00", "2024-11-29 00:00:00" },
                    { 1008, 2008, 3008,  "2024-11-22 09:00:00", 9, "2024-11-22 00:00:00", "2024-11-24 00:00:00" },
                    { 1009, 2009, 3009, "2024-11-23 12:30:00", 8, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1010, 2010, 3010,  "2024-11-24 15:00:00", 10, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1011, 2011, 3011, "2024-11-25 11:30:00", 8, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1012, 2012, 3012, "2024-11-26 10:45:00", 6, "2024-11-22 00:00:00", "2024-12-22 00:00:00" },
                    { 1013, 2013, 3013,  "2024-11-27 09:00:00", 9, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1014, 2014, 3014, "2024-11-28 08:15:00", 10, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1015, 2015, 3015, "2024-11-29 14:00:00", 9, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1016, 2016, 3016, "2024-11-30 13:15:00", 7, "2024-11-22 00:00:00", "2024-11-27 00:00:00" },
                    { 1017, 2017, 3017,  "2024-12-01 10:00:00", 8, "2024-11-22 00:00:00", "2025-01-22 00:00:00" },
                    { 1018, 2018, 3018, "2024-12-02 11:30:00", 9, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1019, 2019, 3019, "2024-12-03 09:30:00", 10, "2024-11-22 00:00:00", "2025-08-22 00:00:00" },
                    { 1020, 2020, 3020, "2024-12-04 15:00:00", 6, "2024-11-22 00:00:00","2025-11-21 00:00:00" },

                    { 1021, 2052, 3019, "2024-11-25 10:30:00", 9, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1022, 2053, 3020, "2024-11-25 14:00:00", 8, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1023, 2054, 3021, "2024-11-26 09:30:00", 7, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1024, 2055, 3022, "2024-11-26 11:00:00", 10, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1025, 2056, 3023, "2024-11-26 15:30:00", 3, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1026, 2057, 3024, "2024-11-27 10:00:00", 6, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1027, 2058, 3025, "2024-11-27 13:30:00", 7, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1028, 2059, 3026, "2024-11-27 16:00:00", 8, "2024-11-22 00:00:00", "2025-11-21 00:00:00" },
                    { 1029, 2060, 3027, "2024-11-28 09:00:00", 6, "2024-11-22 00:00:00", "2025-11-21 00:00:00" }

                };

            String query = "INSERT INTO consultations (consultationID, patientID, doctorID, consultationDate, " +
                    "satisfactionRating, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

            for (Object[] i : consulInfo) {
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
                    // example data
                    { 1001, "PhilHealth Diagnostic Center", "123 Rizal Avenue, Manila, Metro Manila, 1000",
                            "09123456789" },
                    { 1002, "Healthway Laboratory", "456 Quezon Boulevard, Quezon City, Metro Manila, 1100",
                         "09234567890" },
                    { 1003, "Cebu Medical Diagnostic Laboratory", "789 Colon Street, Cebu City, Cebu, 6000",
                         "09345678901" },
                    { 1004, "Davao Health Services", "101 Bonifacio Street, Davao City, Davao del Sur, 8000",
                         "09456789012" },
                    { 1005, "Iloilo Diagnostic Center", "202 Jaro Road, Iloilo City, Iloilo, 5000", "09567890123" },
                    { 1006, "Baguio Medical Testing Laboratory", "303 Session Road, Baguio City, Benguet, 2600",
                         "09678901234" },
                    { 1007, "Cagayan de Oro Diagnostic Services",
                         "404 Divisoria Street, Cagayan de Oro City, Misamis Oriental, 9000", "09789012345" },
                    { 1008, "Bacolod Clinical Laboratory", "505 Lacson Street, Bacolod City, Negros Occidental, 6100",
                         "09890123456" },
                    { 1009, "Zamboanga Diagnostic and Imaging",
                         "606 Gov. Alvarez Avenue, Zamboanga City, Zamboanga del Sur, 7000", "09901234567" },
                    { 1010, "General Santos Laboratory Services",
                            "707 Pioneer Avenue, General Santos City, South Cotabato, 9500", "09109876543" }
                    

            };

            String query1 = "INSERT INTO laboratory (laboratoryID, name, address, phoneNumber) VALUES (?, ?, ?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

            for (Object[] i : labInfo) {
                insert1.setInt(1, (int) i[0]); // lab id
                insert1.setString(2, (String) i[1]); // name
                insert1.setString(3, (String) i[2]); // address
                insert1.setString(4, (String) i[3]); // phone numbert1
                insert1.executeUpdate();
            }

            insert1.close();

            // lab req information
            Object[][] labReqInfo = {
                    // example data
                    { 1009, 1001, 3006 },
                    { 1002, 1002, 3005 },
                    { 1003, 1003, 3002 },
                    { 1006, 1004, 3007 },
                    { 1001, 1005, 3003 },
                    { 1007, 1006, 3010 },
                    { 1005, 1007, 3004 },
                    { 1004, 1008, 3009 },
                    { 1008, 1009, 3001 },
                    { 1010, 1010, 3008 }
            };

            String query2 = "INSERT INTO labRequest (laboratoryID, consultationID, issuedBy) VALUES (?, ?, ?)";

            PreparedStatement insert2 = connect.prepareStatement(query2);

            for (Object[] i : labReqInfo) {
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
            System.out.println("Consultation data loaded");
        }
    }
}
