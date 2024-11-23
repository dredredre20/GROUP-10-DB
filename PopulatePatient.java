import java.sql.*;

public class PopulatePatient {    

    private String hmo_url;
    private String user;
    private String pass;

    public PopulatePatient(String hmo, String user, String pass){
        
        this.hmo_url = hmo;
        this.user = user;
        this.pass = pass;
    }

    public void Patient(){


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.hmo_url, this.user, this.pass);

            // patient basic information
            Object[][] patientInfo = {
                    // example data
                    {  2001, "Garcia", "Juan", "M", "1990-05-15 00:00:00", "09171234567",
                     "123 Mabini St, Quezon City, Metro Manila, 1100", "O+", "None" },
                    {  2002, "Reyes", "Maria", "F", "1985-03-22 00:00:00", "09281234567",
                     "456 Santo Niño St, Cebu City, Cebu, 6000", "A-", "Penicillin" },
                    {  2003, "Santos", "Andres", "M", "1978-11-30 00:00:00", "09351234567",
                     "789 P. Burgos St, Davao City, Davao del Sur, 8000", "B+", "None" },
                    {  2004, "Dela Cruz", "Josefa", "F", "1992-07-05 00:00:00", "09451234567",
                     "321 E. Rodriguez Ave, Makati City, Metro Manila, 1223", "AB-", "Peanuts" },
                    {  2005, "Bautista", "Carlos", "M", "1983-12-10 00:00:00", "09551234567",
                     "654 P. Gil St, Taguig City, Metro Manila, 1634", "O-", "None" },
                    {  2006, "Lopez", "Ana", "F", "2000-01-01 00:00:00", "09651234567",
                     "987 Quezon Ave, Quezon City, Metro Manila, 1103", "A+", "Shellfish" },
                    {  2007, "Mendoza", "Ricardo", "M", "1995-09-18 00:00:00", "09751234567",
                     "135 Malolos St, Pasig City, Metro Manila, 1600", "B-", "Dust mites" },
                    {  2008, "Fernandez", "Liza", "F", "1998-04-25 00:00:00", "09851234567",
                     "246 Bagumbayan St, Pasay City, Metro Manila, 1300", "AB+", "None" },
                    {  2009, "Jimenez", "Eduardo", "M", "1975-08-13 00:00:00", "09951234567",
                     "357 M. Roxas St, Manila, Metro Manila, 1000", "O+", "Lactose" },
                    {  2010, "Chavez", "Beatrice", "F", "1989-02-20 00:00:00", "09191234567",
                     "159 Quezon St, Davao City, Davao del Sur, 8000", "A-", "Sulfa drugs" },
                    {  2011, "Alvarez", "Carlos", "M", "1994-06-21 00:00:00", "09181234567",
                     "22 Alabang St, Muntinlupa, Metro Manila, 1781", "B+", "None" },
                    {  2012, "Rodriguez", "Claudia", "F", "1987-03-14 00:00:00", "09231234567",
                     "34 San Isidro St, Manila, Metro Manila, 1011", "A-", "Peanuts" },
                    {  2013, "Flores", "Ricardo", "M", "1989-08-07 00:00:00", "09321234567",
                     "45 P. Zamora St, Quezon City, Metro Manila, 1101", "O+", "None" },
                    {  2014, "Cruz", "Sofia", "F", "1993-11-30 00:00:00", "09421234567",
                     "56 EDSA, Mandaluyong, Metro Manila, 1550", "AB-", "Shellfish" },
                    {  2015, "Martinez", "Juan", "M", "1982-02-18 00:00:00", "09521234567",
                     "67 P. Ocampo St, Pasay City, Metro Manila, 1300", "O-", "None" },
                    {  2016, "Garcia", "Elena", "F", "1999-07-13 00:00:00", "09621234567",
                     "78 San Antonio St, Pasig City, Metro Manila, 1600", "A+", "None" },
                    {  2017, "Perez", "Fernando", "M", "1985-09-22 00:00:00", "09721234567",
                     "89 P. Gomez St, Caloocan City, Metro Manila, 1400", "B-", "None" },
                    {  2018, "Santos", "Irene", "F", "1991-05-04 00:00:00", "09821234567",
                     "90 Tandang Sora St, Quezon City, Metro Manila, 1123", "AB+", "Peanuts" },
                    {  2019, "Ramos", "Vicente", "M", "1986-12-11 00:00:00", "09921234567",
                     "101 Quezon St, Makati City, Metro Manila, 1210", "O+", "None" },
                    {  2020, "Tan", "Elizabeth", "F", "1990-04-06 00:00:00", "09191234567",
                     "112 T. Alonzo St, Taguig City, Metro Manila, 1630", "A-", "Sulfa drugs" },
                    {  2021, "Delos Santos", "Michael", "M", "1983-10-15 00:00:00", "09291234567",
                     "123 M. Claro St, Manila, Metro Manila, 1008", "B+", "Lactose" },
                    {  2022, "Villar", "Andrea", "F", "1997-03-03 00:00:00", "09391234567",
                     "134 Katipunan Ave, Quezon City, Metro Manila, 1105", "O-", "None" },
                    {  2023, "Javier", "Ricardo", "M", "1990-11-20 00:00:00", "09491234567",
                     "145 Tarlac St, Makati City, Metro Manila, 1215", "AB+", "Dust mites" },
                    {  2024, "Suarez", "Jacqueline", "F", "1981-05-17 00:00:00", "09591234567",
                     "156 T. Cordero St, Quezon City, Metro Manila, 1111", "A+", "None" },
                    {  2025, "Garcia", "Fernando", "M", "1993-01-25 00:00:00", "09691234567",
                     "167 Bagumbayan St, Taguig City, Metro Manila, 1635", "B-", "None" },
                    {  2026, "Nunez", "Richelle", "F", "1995-02-18 00:00:00", "09791234567",
                     "178 Bonifacio St, Paranaque, Metro Manila, 1700", "O+", "None" },
                    {  2027, "Zamora", "Alvin", "M", "1988-09-10 00:00:00", "09891234567",
                     "189 N. Ramirez St, Manila, Metro Manila, 1001", "A-", "Penicillin" },
                    {  2028, "Santiago", "Carla", "F", "1987-11-13 00:00:00", "09991234567",
                     "200 N. San Juan St, Pasig City, Metro Manila, 1602", "B+", "None" },
                    {  2029, "Lozano", "Jocelyn", "F", "1994-12-25 00:00:00", "09191234568",
                     "211 San Juan St, Caloocan City, Metro Manila, 1402", "AB-", "Shellfish" },
                    {  2030, "Romero", "Julian", "M", "1981-06-22 00:00:00", "09291234568",
                     "222 Sampaloc St, Quezon City, Metro Manila, 1113", "O-", "None" },
                    {  2031, "Santos", "Veronica", "F", "1996-04-14 00:00:00", "09391234568",
                     "233 Villanueva St, Mandaluyong, Metro Manila, 1551", "A+", "None" },
                    {  2032, "Javier", "Luis", "M", "1990-07-19 00:00:00", "09491234568",
                     "244 Aurora Blvd, Pasay City, Metro Manila, 1301", "B-", "Peanuts" },
                    {  2033, "Cruz", "Rafael", "M", "1989-10-22 00:00:00", "09591234568",
                     "255 P. Camus St, Pasig City, Metro Manila, 1603", "O+", "None" },
                    {  2034, "Martinez", "Sarah", "F", "1992-12-05 00:00:00", "09691234568",
                     "266 E. Santos St, Caloocan City, Metro Manila, 1403", "A-", "Lactose" },
                    {  2035, "Bautista", "Maria", "F", "1995-08-12 00:00:00", "09791234568",
                     "277 G. Herrera St, Pasig City, Metro Manila, 1610", "B+", "Dust mites" },
                    {  2036, "Flores", "Paolo", "M", "1984-01-01 00:00:00", "09891234568",
                     "288 H. Ponce St, Makati City, Metro Manila, 1217", "O-", "None" },
                    {  2037, "Villar", "Ruth", "F", "1997-11-18 00:00:00", "09991234568",
                     "299 N. Lucena St, Pasig City, Metro Manila, 1608", "AB+", "Shellfish" },
                    {  2038, "Cortes", "Luis", "M", "1986-02-02 00:00:00", "09191234569",
                     "310 S. Magtibay St, Quezon City, Metro Manila, 1108", "A+", "None" },
                    {  2039, "Alvarado", "Gloria", "F", "1994-10-13 00:00:00", "09291234569",
                     "321 M. Gamboa St, Manila, Metro Manila, 1009", "B-", "Peanuts" },
                    {  2040, "Romero", "Victoria", "F", "1985-09-27 00:00:00", "09391234569",
                     "332 San Lorenzo St, Mandaluyong, Metro Manila, 1552", "O+", "None" },
                    {  2041, "Santos", "Angelina", "F", "1989-05-08 00:00:00", "09491234569",
                     "343 F. Salvador St, Taguig City, Metro Manila, 1637", "A-", "None" },
                    {  2042, "Lopez", "Eduardo", "M", "1996-06-03 00:00:00", "09591234569",
                     "354 M. Velasquez St, Makati City, Metro Manila, 1218", "AB+", "Dust mites" },
                    {  2043, "Zamora", "Betty", "F", "1987-07-25 00:00:00", "09691234569",
                     "365 P. Cuenca St, Pasig City, Metro Manila, 1604", "B+", "None" },
                    {  2044, "Ramos", "Bernardo", "M", "1992-08-30 00:00:00", "09791234569",
                     "376 P. Garcia St, Pasig City, Metro Manila, 1615", "O-", "Lactose" },
                    {  2045, "Alvarez", "Evelyn", "F", "1990-01-17 00:00:00", "09891234569",
                     "387 L. Cruz St, Paranaque, Metro Manila, 1701", "A+", "Shellfish" },
                    {  2046, "Delos Santos", "Mark", "M", "1982-04-22 00:00:00", "09991234569",
                     "398 S. Pagasa St, Manila, Metro Manila, 1012", "B-", "None" },
                    {  2047, "Chavez", "Adela", "F", "1997-09-04 00:00:00", "09191234570",
                     "409 P. Salazar St, Quezon City, Metro Manila, 1109", "O+", "None" },
                    {  2048, "Romero", "Leonardo", "M", "1993-03-10 00:00:00", "09291234570",
                     "410 S. dela Cruz St, Makati City, Metro Manila, 1219", "A-", "Peanuts" },
                    {  2049, "Cortez", "Francesca", "F", "1988-12-09 00:00:00", "09391234570",
                     "421 P. Galang St, Mandaluyong, Metro Manila, 1553", "B+", "None" },
                    {  2050, "Gonzales", "Erika", "F", "1991-01-28 00:00:00", "09491234570",
                            "432 P. Ortega St, Taguig City, Metro Manila, 1640", "AB-", "Shellfish" }, 



                    { 2051, "Villanueva", "Roberto", "M", "1988-07-15 00:00:00", "09491234571", 
                     "443 Rizal Ave, Makati City, Metro Manila, 1220", "A+", "None" },
                    { 2052, "Torres", "Isabella", "F", "1993-04-22 00:00:00", "09591234571", 
                     "454 Bonifacio St, Quezon City, Metro Manila, 1114", "B-", "Penicillin" },
                    { 2053, "Aquino", "Miguel", "M", "1986-11-30 00:00:00", "09691234571", 
                     "465 Mabini St, Pasig City, Metro Manila, 1605", "O+", "Sulfa drugs" },
                    { 2054, "Lim", "Patricia", "F", "1995-02-14 00:00:00", "09791234571", 
                     "476 Luna St, Manila, Metro Manila, 1013", "AB+", "None" },
                    { 2055, "Pascual", "Antonio", "M", "1984-09-08 00:00:00", "09891234571", 
                     "487 Quirino Ave, Paranaque, Metro Manila, 1702", "A-", "Shellfish" },
                    { 2056, "Mercado", "Carmen", "F", "1991-12-25 00:00:00", "09991234571", 
                     "498 Aurora Blvd, San Juan, Metro Manila, 1500", "B+", "None" },
                    { 2057, "Aguilar", "Ramon", "M", "1987-03-17 00:00:00", "09191234573", 
                     "509 Roxas Blvd, Pasay City, Metro Manila, 1302", "O-", "Lactose" },
                    { 2058, "Dimaculangan", "Teresa", "F", "1994-06-30 00:00:00", "09291234573", 
                     "510 Shaw Blvd, Mandaluyong, Metro Manila, 1554", "AB-", "None" },
                    { 2059, "Yap", "Gabriel", "M", "1989-01-05 00:00:00", "09391234573", 
                     "521 Commonwealth Ave, Quezon City, Metro Manila, 1121", "A+", "Peanuts" },
                    { 2060, "Espiritu", "Margarita", "F", "1992-08-12 00:00:00", "09491234573", 
                        "532 Ortigas Ave, Pasig City, Metro Manila, 1606", "B-", "None" }
            };

            String query = "INSERT INTO patients (patientID, patientLastName, patientFirstName, sex, birthday," +
                    "phoneNumber, address,  bloodType, allergies) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

            for (Object[] i : patientInfo) {
                insert.setInt(1, (int) i[0]); // patient id
                insert.setString(2, (String) i[1]); // pLastname
                insert.setString(3, (String) i[2]); // pFirstname
                insert.setString(4, (String) i[3]); // sex
                insert.setTimestamp(5, Timestamp.valueOf(i[4].toString())); // birthday
                insert.setString(6, (String) i[5]); // phone num
                insert.setString(7, (String) i[6]); // address
                insert.setString(8, (String) i[7]); // blood type
                insert.setString(9, (String) i[8]); // allergies

                insert.executeUpdate();
            }

            insert.close();

            // contact person information
            Object[][] contactInfo = {
                    // example data
                    { 2001, "Maria", "Garcia", "09181234568", "Mother" },
                    { 2002, "Juan", "Reyes", "09281234568", "Father" },
                    { 2003, "Antonio", "Santos", "09351234568", "Brother" },
                    { 2004, "Jose", "Dela Cruz", "09451234568", "Father" },
                    { 2005, "Luisa", "Bautista", "09551234568", "Wife" },
                    { 2006, "Pedro", "Lopez", "09651234568", "Father" },
                    { 2007, "Lina", "Mendoza", "09751234568", "Mother" },
                    { 2008, "Ricardo", "Fernandez", "09851234568", "Husband" },
                    { 2009, "Juan", "Jimenez", "09951234568", "Brother" },
                    { 2010, "Carlos", "Chavez", "09191234568", "Father" },
                    { 2011, "Emilia", "Alvarez", "09181234569", "Mother" },
                    { 2012, "Carlos", "Rodriguez", "09231234569", "Husband" },
                    { 2013, "Lilia", "Flores", "09321234569", "Sister" },
                    { 2014, "Jose", "Cruz", "09421234569", "Brother" },
                    { 2015, "Diana", "Martinez", "09521234569", "Wife" },
                    { 2016, "Martha", "Garcia", "09621234569", "Mother" },
                    { 2017, "Emilio", "Perez", "09721234569", "Father" },
                    { 2018, "Carmen", "Santos", "09821234569", "Sister" },
                    { 2019, "Martha", "Ramos", "09921234569", "Wife" },
                    { 2020, "Benjamin", "Tan", "09191234569", "Father" },
                    { 2021, "Jose", "Delos Santos", "09291234569", "Brother" },
                    { 2022, "Violeta", "Villar", "09391234569", "Mother" },
                    { 2023, "Mariano", "Javier", "09491234569", "Father" },
                    { 2024, "Raul", "Suarez", "09591234569", "Husband" },
                    { 2025, "Elsa", "Garcia", "09691234569", "Mother" },
                    { 2026, "Manuel", "Nunez", "09791234569", "Father" },
                    { 2027, "Teresita", "Zamora", "09891234569", "Sister" },
                    { 2028, "Pedro", "Santiago", "09991234569", "Husband" },
                    { 2029, "Rodolfo", "Lozano", "09191234570", "Father" },
                    { 2030, "Santiago", "Romero", "09291234570", "Brother" },
                    { 2031, "Adela", "Santos", "09391234570", "Mother" },
                    { 2032, "Esteban", "Javier", "09491234570", "Father" },
                    { 2033, "Josefina", "Cruz", "09591234570", "Wife" },
                    { 2034, "Rafael", "Martinez", "09691234570", "Father" },
                    { 2035, "Armando", "Bautista", "09791234570", "Husband" },
                    { 2036, "Carlos", "Flores", "09891234570", "Father" },
                    { 2037, "Veronica", "Villar", "09991234570", "Sister" },
                    { 2038, "Lilia", "Cortes", "09191234571", "Mother" },
                    { 2039, "Antonio", "Alvarado", "09291234571", "Father" },
                    { 2040, "Benedicta", "Romero", "09391234571", "Wife" },
                    { 2041, "Marco", "Santos", "09491234571", "Brother" },
                    { 2042, "Ricardo", "Lopez", "09591234571", "Father" },
                    { 2043, "Virginia", "Zamora", "09691234571", "Mother" },
                    { 2044, "Eduardo", "Ramos", "09791234571", "Father" },
                    { 2045, "Francesca", "Alvarez", "09891234571", "Sister" },
                    { 2046, "Cristina", "Delos Santos", "09991234571", "Mother" },
                    { 2047, "Rodolfo", "Chavez", "09191234572", "Father" },
                    { 2048, "Maria", "Romero", "09291234572", "Mother" },
                    { 2049, "Nina", "Cortez", "09391234572", "Sister" },
                    { 2050, "Gregoria", "Gonzales", "09491234572", "Mother" }, 
                    { 2051, "Elena", "Villanueva", "09191234573", "Wife" },
                    { 2052, "Ramon", "Torres", "09291234573", "Father" },
                    { 2053, "Teresa", "Aquino", "09391234573", "Mother" },
                    { 2054, "Benjamin", "Lim", "09491234573", "Brother" },
                    { 2055, "Maricel", "Pascual", "09591234573", "Sister" },
                    { 2056, "Felipe", "Mercado", "09691234573", "Husband" },
                    { 2057, "Rosario", "Aguilar", "09791234573", "Mother" },
                    { 2058, "Martin", "Dimaculangan", "09891234573", "Father" },
                    { 2059, "Victoria", "Yap", "09991234573", "Wife" },
                    { 2060, "Leonardo", "Espiritu", "09191234574", "Husband" }
            };

            String query1 = "INSERT INTO contactPerson (patientID, firstName, lastName, phoneNumber, relationship)"
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

            for (Object[] i : contactInfo) {
                insert1.setInt(1, (int) i[0]); // patient id
                insert1.setString(2, (String) i[1]); // first name
                insert1.setString(3, (String) i[2]); // last name
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
            System.out.println("Patient data loaded");
        }
    }
}
