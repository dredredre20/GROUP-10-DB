import java.sql.*;

public class PopulateDoctor {

    private String hmo_url;
    private String user;
    private String pass;

    public PopulateDoctor(String hmo, String user, String pass){
        
        this.hmo_url = hmo;
        this.user = user;
        this.pass = pass;
    }
    
    public void doctor(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(this.hmo_url, this.user, this.pass);

            // doctor basic information
            Object[][] doctorBasic = {
                    // example data
                    {  3001, "Garcia", "Juan", "M", "1985-06-15 00:00:00", "09123456789",
                     "123 Health Street, Manila, Metro Manila, 1000", "juan.garcia@email.com" },
                    {  3002, "Santos", "Maria", "F", "1990-03-20 00:00:00", "09234567890",
                     "456 Wellness Road, Quezon City, Metro Manila, 1100", "maria.santos@email.com" },
                    {  3003, "Reyes", "Carlos", "M", "1982-10-10 00:00:00", "09345678901",
                     "789 Medical Ave, Cebu City, Cebu, 6000", "carlos.reyes@email.com" },
                    {  3004, "Bautista", "Angela", "F", "1987-05-25 00:00:00", "09456789012",
                     "101 Bonifacio Street, Davao City, Davao del Sur, 8000", "angela.bautista@email.com" },
                    {  3005, "De la Cruz", "Jose", "M", "1993-01-30 00:00:00", "09567890123",
                     "202 Jaro Road, Iloilo City, Iloilo, 5000", "jose.delacruz@email.com" },
                    {  3006, "Tan", "Liza", "F", "1989-07-12 00:00:00", "09678901234",
                     "303 Session Road, Baguio City, Benguet, 2600", "liza.tan@email.com" },
                    {  3007, "Morales", "Ricardo", "M", "1980-11-18 00:00:00", "09789012345",
                     "404 Divisoria Street, Cagayan de Oro City, Misamis Oriental, 9000",
                     "ricardo.morales@email.com" },
                    {  3008, "Lopez", "Ana", "F", "1986-09-05 00:00:00", "09890123456",
                     "505 Lacson Street, Bacolod City, Negros Occidental, 6100", "ana.lopez@email.com" },
                    {  3009, "Gonzalez", "Miguel", "M", "1995-02-14 00:00:00", "09901234567",
                     "606 Gov. Alvarez Avenue, Zamboanga City, Zamboanga del Sur, 7000",
                     "miguel.gonzalez@email.com" },
                    {  3010, "Cruz", "Sofia", "F", "1992-12-20 00:00:00", "09109876543",
                     "707 Pioneer Avenue, General Santos City, South Cotabato, 9500", "sofia.cruz@email.com" },
                    {  3011, "Mendoza", "Luis", "M", "1988-03-22 00:00:00", "09219876543",
                     "808 Roxas Boulevard, Makati City, Metro Manila, 1200", "luis.mendoza@email.com" },
                    {  3012, "Diaz", "Jasmin", "F", "1994-06-09 00:00:00", "09310987654",
                     "909 Shaw Boulevard, Mandaluyong City, Metro Manila, 1550", "jasmin.diaz@email.com" },
                    {  3013, "Fernandez", "Tomas", "M", "1983-08-17 00:00:00", "09421234567",
                     "101 Ayala Avenue, Makati City, Metro Manila, 1226", "tomas.fernandez@email.com" },
                    {  3014, "Javier", "Isabel", "F", "1991-04-11 00:00:00", "09532345678",
                     "202 Commonwealth Avenue, Quezon City, Metro Manila, 1128", "isabel.javier@email.com" },
                    {  3015, "Alvarez", "Daniel", "M", "1980-09-25 00:00:00", "09643456789",
                     "303 Market Street, Taguig City, Metro Manila, 1630", "daniel.alvarez@email.com" },
                    {  3016, "Serrano", "Megan", "F", "1987-02-18 00:00:00", "09754567890",
                     "404 East Avenue, Quezon City, Metro Manila, 1104", "megan.serrano@email.com" },
                    {  3017, "Castro", "William", "M", "1993-05-22 00:00:00", "09865678901",
                     "505 Katipunan Avenue, Quezon City, Metro Manila, 1100", "william.castro@email.com" },
                    {  3018, "Delgado", "Olivia", "F", "1986-01-10 00:00:00", "09976789012",
                     "606 Bonifacio Ave, Davao City, Davao del Sur, 8000", "olivia.delgado@email.com" },
                    {  3019, "Valencia", "Ethan", "M", "1984-11-30 00:00:00", "09123478901",
                     "707 Philippine Street, Makati City, Metro Manila, 1200", "ethan.valencia@email.com" },
                    {  3020, "Vega", "Charlotte", "F", "1991-07-05 00:00:00", "09234589012",
                     "808 Ortigas Avenue, Pasig City, Metro Manila, 1600", "charlotte.vega@email.com" },
                    {  3021, "Navarro", "Elijah", "M", "1996-12-14 00:00:00", "09345690123",
                     "909 Taft Avenue, Manila, Metro Manila, 1000", "elijah.navarro@email.com" },
                    {  3022, "Perez", "Isabella", "F", "1982-08-29 00:00:00", "09456701234",
                     "101 Paranaque Road, Paranaque City, Metro Manila, 1700", "isabella.perez@email.com" },
                    {  3023, "Ramos", "Jack", "M", "1990-03-10 00:00:00", "09567812345",
                     "202 Malate Street, Manila, Metro Manila, 1004", "jack.ramos@email.com" },
                    {  3024, "Quinto", "Grace", "F", "1985-12-01 00:00:00", "09678923456",
                     "303 Fairview Avenue, Quezon City, Metro Manila, 1121", "grace.quinto@email.com" },
                    {  3025, "Santiago", "Benjamin", "M", "1989-05-17 00:00:00", "09789034567",
                            "404 San Juan Street, San Juan City, Metro Manila, 1500", "benjamin.santiago@email.com" }, 


                    { 3026, "Lim", "Victoria", "F", "1988-04-15 00:00:00", "09789945678", 
                     "505 McKinley Road, BGC, Taguig City, Metro Manila, 1634", "victoria.lim@email.com" },
                    { 3027, "Torres", "Adrian", "M", "1992-08-22 00:00:00", "09891056789", 
                     "606 Escolta Street, Manila, Metro Manila, 1006", "adrian.torres@email.com" },
                    { 3028, "Villanueva", "Monica", "F  ", "1983-11-30 00:00:00", "09902167890", 
                     "707 Alabang Hills, Muntinlupa City, Metro Manila, 1780", "monica.villanueva@email.com" },
                    { 3029, "Ocampo", "Rafael", "M", "1990-02-14 00:00:00", "09113278901", 
                     "808 Greenhills, San Juan City, Metro Manila, 1502", "rafael.ocampo@email.com" },
                    { 3030, "Mercado", "Diana", "F", "1986-07-19 00:00:00", "09224389012", 
                        "909 Paseo de Roxas, Makati City, Metro Manila, 1227", "diana.mercado@email.com" }
            };

            String query = "INSERT INTO doctors (doctorID, lastName, firstName, sex, birthday, phoneNumber, address, email)"
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

            for (Object[] i : doctorBasic) {
                insert.setInt(1, (int) i[0]); // doctor id
                insert.setString(2, (String) i[1]); // last name
                insert.setString(3, (String) i[2]); // first name
                insert.setString(4, (String) i[3]); // sex
                insert.setTimestamp(5, Timestamp.valueOf(i[4].toString())); // birthday
                insert.setString(6, (String) i[5]); // phone number
                insert.setString(7, (String) i[6]); // address
                insert.setString(8, (String) i[7]); // email

                insert.executeUpdate();
            }

            insert.close();

            // doctor work information
            Object[][] doctorWork = {
                    // example data
                    { 3001, 45000, "D123456", 0700, 1700, 25, 15 },
                    { 3002, 48000, "D234567", 0700, 1800, 20, 18 },
                    { 3003, 55000, "D345678", 0700, 1600, 30, 25 },
                    { 3004, 47000, "D456789", 0700, 1700, 20, 17 },
                    { 3005, 49000, "D567890", 0700, 1800, 22, 20 },
                    { 3006, 46000, "D678901", 0700, 1600, 25, 23 },
                    { 3007, 51000, "D789012", 0700, 1700, 30, 28 },
                    { 3008, 53000, "D890123", 0700, 1800, 18, 15 },
                    { 3009, 52000, "D901234", 0700, 1600, 25, 22 },
                    { 3010, 54000, "D012345", 0700, 1700, 20, 18 },
                    { 3011, 55000, "D123457", 0700, 1800, 22, 21 },
                    { 3012, 47000, "D234568", 0700, 1700, 28, 26 },
                    { 3013, 48000, "D345679", 0700, 1600, 30, 25 },
                    { 3014, 49000, "D456790", 0700, 1700, 25, 23 },
                    { 3015, 51000, "D567891", 0700, 1800, 20, 19 },
                    { 3016, 53000, "D678902", 0700, 1700, 25, 24 },
                    { 3017, 46000, "D789013", 0700, 1600, 30, 28 },
                    { 3018, 52000, "D890124", 0700, 1800, 22, 21 },
                    { 3019, 54000, "D901235", 0700, 1700, 18, 16 },
                    { 3020, 55000, "D012346", 0700, 1700, 30, 29 },
                    { 3021, 48000, "D123458", 0700, 1800, 22, 20 },
                    { 3022, 47000, "D234569", 0700, 1600, 25, 22 },
                    { 3023, 49000, "D345680", 0700, 1800, 20, 17 },
                    { 3024, 51000, "D456791", 0700, 1700, 28, 26 },
                    { 3025, 53000, "D567892", 0700, 1600, 30, 27 }, 
                    { 3026, 52000, "D678903", 0700, 1700, 25, 20 },
                    { 3027, 49000, "D789014", 0700, 1800, 28, 25 },
                    { 3028, 54000, "D890125", 0700, 1600, 22, 19 },
                    { 3029, 51000, "D901236", 0700, 1700, 30, 27 },
                    { 3030, 53000, "D012347", 0700, 1800, 25, 23 }
            };

            String query1 = "INSERT INTO doctorWorkInfo (doctorID, salary, licenseNumber, workingStart, workingEnd, maxPatientLoad, currentPatientLoad)"
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

            for (Object[] i : doctorWork) {
                insert1.setInt(1, (int) i[0]); // doctorID
                insert1.setInt(2, (int) i[1]); // salary
                insert1.setString(3, (String) i[2]); // license number
                insert1.setInt(4, (int) i[3]); // working start
                insert1.setInt(5, (int) i[4]); // working end
                insert1.setInt(6, (int) i[5]); // max patient load
                insert1.setInt(7, (int) i[6]); // current patient load

                insert1.executeUpdate();
            }

            insert1.close();

            // doctor specialization
            Object[][] doctorSpecial = {
                    // example data
                { 3001, "Cardiologist", "Cardiology", "2015-06-01 00:00:00", "2025-06-01 00:00:00" },
                    { 3002, "Pediatrician", "General Pediatrics", "2016-07-15 00:00:00", "2026-07-15 00:00:00" },
                    { 3003, "Surgeon", "Orthopedic Surgery", "2014-10-20 00:00:00", "2024-10-20 00:00:00" },
                    { 3004, "Obstetrician", "Gynecologic Surgery", "2017-04-10 00:00:00",
                    "2027-04-10 00:00:00" },
                    { 3005, "Endocrinologist", "Endocrinology", "2018-05-12 00:00:00", "2028-05-12 00:00:00" },

                    { 3006, "Pediatrician", "Neonatology", "2015-09-25 00:00:00", "2025-09-25 00:00:00" },
                    { 3007, "Ophthalmologist", "Retina and Vitreous Surgery", "2016-12-30 00:00:00",
                    "2026-12-30 00:00:00" },
                    { 3008, "Surgeon", "Plastic Surgery", "2014-03-11 00:00:00", "2024-03-11 00:00:00" },
                    { 3009, "Dermatologist", "Dermatologic Surgery", "2013-08-07 00:00:00", "2023-08-07 00:00:00" },
                    { 3010, "Physician", "General Family Medicine", "2016-11-02 00:00:00",

                    "2026-11-02 00:00:00" },
                    { 3011, "Psychiatrist", "General Psychiatry", "2014-01-17 00:00:00", "2024-01-17 00:00:00" },
                    { 3012, "Anesthesiologist", "General Anesthesiology", "2017-02-14 00:00:00",
                    "2027-02-14 00:00:00" },
                    { 3013, "Physician", "Trauma and Emergency Care", "2018-03-05 00:00:00",
                    "2028-03-05 00:00:00" },
                    { 3014, "Orthopedist", "Spine Surgery", "2013-10-22 00:00:00", "2023-10-22 00:00:00" },
                    { 3015, "Urologist", "General Urology", "2016-09-08 00:00:00", "2026-09-08 00:00:00" },


                    { 3016, "Dermatologist", "Reconstructive Surgery", "2015-12-15 00:00:00",
                    "2025-12-15 00:00:00" },
                    { 3017, "Otorhinolaryngologist", "Head and Neck Surgery", "2018-01-09 00:00:00",
                    "2028-01-09 00:00:00" },
                    { 3018, "Gastroenterologist", "Gastroenterology", "2017-08-19 00:00:00", "2027-08-19 00:00:00" },
                    { 3019, "Neurologist", "Stroke Neurology", "2014-04-03 00:00:00", "2024-04-03 00:00:00" },


                    { 3020, "Dermatologist", "Cosmetic Dermatology", "2015-11-25 00:00:00", "2025-11-25 00:00:00" },
                    { 3021, "Pediatrician", "Pediatric Cardiology", "2016-06-12 00:00:00", "2026-06-12 00:00:00" },
                    { 3022, "Surgeon", "General Surgery", "2014-05-17 00:00:00", "2024-05-17 00:00:00" },
                    { 3023, "Obstetrician", "Maternal-Fetal Medicine", "2016-10-22 00:00:00",
                    "2026-10-22 00:00:00" },
                    { 3024, "Psychiatrist", "Child and Adolescent Psychiatry", "2018-07-11 00:00:00",
                    "2028-07-11 00:00:00" },
                    { 3025, "Ophthalmologist", "Cataract Surgery", "2017-09-14 00:00:00", "2027-09-14 00:00:00" }, 



                    { 3026, "Cardiologist", "Interventional Cardiology", "2016-08-15 00:00:00", "2026-08-15 00:00:00" },
                    { 3027, "Pulmonologist", "Critical Care Medicine", "2017-03-22 00:00:00", "2027-03-22 00:00:00" },
                    { 3028, "Nephrologist", "Transplant Nephrology", "2015-11-30 00:00:00", "2025-11-30 00:00:00" },
                    { 3029, "Hematologist", "Medical Oncology", "2016-09-14 00:00:00", "2026-09-14 00:00:00" },
                    { 3030, "Rheumatologist", "Pediatric Rheumatology", "2017-07-19 00:00:00", "2027-07-19 00:00:00" }
            };

            String query2 = "INSERT INTO doctorSpecializations (doctorID, name, field, certificateDate, expiryDate)" +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement insert2 = connect.prepareStatement(query2);

            for (Object[] i : doctorSpecial) {
                insert2.setInt(1, (int) i[0]); // doctorID
                insert2.setString(2, (String) i[1]); // name
                insert2.setString(3, (String) i[2]); // field
                insert2.setTimestamp(4, Timestamp.valueOf(i[3].toString())); // certificate date
                insert2.setTimestamp(5, Timestamp.valueOf(i[4].toString())); // expiry date

                insert2.executeUpdate();
            }

            insert2.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Doctor data loaded");
        }
    }
}
