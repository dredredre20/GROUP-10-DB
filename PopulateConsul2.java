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
                    // example data
                    { "Abdominal pain", "Gastroenterologist" },
                    { "Skin rash", "Dermatologist" },
                    { "Chronic headaches", "Neurologist" },
                    { "Joint pain", "Rheumatologist" },
                    { "Severe back pain", "Orthopedist" },
                    { "Chest pain", "Cardiologist" },
                    { "Shortness of breath", "Pulmonologist" },
                    { "Persistent cough", "Pulmonologist" },
                    { "High blood pressure", "Cardiologist" },
                    { "Vision problems", "Ophthalmologist" },
                    { "Hearing loss", "Audiologist" },
                    { "Depression", "Psychiatrist" },
                    { "Anxiety", "Psychologist" },
                    { "Diabetes management", "Endocrinologist" },
                    { "Thyroid issues", "Endocrinologist" },
                    { "Urinary problems", "Urologist" },
                    { "Gynecological pain", "Gynecologist" },
                    { "Infertility concerns", "Reproductive Endocrinologist" },
                    { "Pregnancy checkup", "Obstetrician" },
                    { "Weight management", "Dietitian" }
            };

            String query = "INSERT INTO complaints (complaintDescription, recommendedSpecialization) VALUES (?, ?)";

            PreparedStatement insert = connect.prepareStatement(query);

            for (Object[] i : comp) {
                insert.setString(1, (String) i[0]); // complaint description
                insert.setString(2, (String) i[1]); // rec specialization

                insert.executeUpdate();
            }

            insert.close();

            // consultation complaints
            Object[][] comp1 = {
                    // example data
                    { "1001", "Abdominal pain" },
                    { "1002", "Skin rash" },
                    { "1003", "Chronic headaches" },
                    { "1004", "Joint pain" },
                    { "1005", "Severe back pain" },
                    { "1006", "Chest pain" },
                    { "1007", "Shortness of breath" },
                    { "1008", "Persistent cough" },
                    { "1009", "High blood pressure" },
                    { "1010", "Vision problems" },
                    { "1011", "Hearing loss" },
                    { "1012", "Depression" },
                    { "1013", "Anxiety" },
                    { "1014", "Diabetes management" },
                    { "1015", "Thyroid issues" },
                    { "1016", "Urinary problems" },
                    { "1017", "Gynecological pain" },
                    { "1018", "Infertility concerns" },
                    { "1019", "Pregnancy checkup" },
                    { "1020", "Weight management" }
            };

            String query1 = "INSERT INTO consultationComplaints (consultationID, complaintDescription) VALUES (?, ?)";

            PreparedStatement insert1 = connect.prepareStatement(query1);

            for (Object[] i : comp1) {
                insert1.setInt(1, (int) i[0]); // consult id
                insert1.setString(2, (String) i[1]); // complaint descriptiont1
                insert1.executeUpdate();
            }

            insert1.close();

            // diagnosis
            Object[][] diag = {
                    // example data
                    { "1001", "Suspected appendicitis or gastritis", "Severe" },
                    { "1002", "Contact dermatitis or eczema", "Mild" },
                    { "1003", "Migraine with aura", "Moderate" },
                    { "1004", "Osteoarthritis or rheumatoid arthritis", "Chronic" },
                    { "1005", "Herniated disc or muscle strain", "Severe" },
                    { "1006", "Angina or possible myocardial infarction", "Critical" },
                    { "1007", "Asthma exacerbation or pulmonary embolism", "Severe" },
                    { "1008", "Chronic bronchitis or pneumonia", "Moderate" },
                    { "1009", "Uncontrolled hypertension", "Moderate" },
                    { "1010", "Cataracts or macular degeneration", "Chronic" },
                    { "1011", "Noise-induced hearing loss", "Moderate" },
                    { "1012", "Major depressive disorder", "Severe" },
                    { "1013", "Generalized anxiety disorder", "Moderate" },
                    { "1014", "Type 2 diabetes with complications", "Chronic" },
                    { "1015", "Hyperthyroidism or hypothyroidism", "Mild" },
                    { "1016", "Urinary tract infection", "Mild" },
                    { "1017", "Endometriosis or pelvic inflammatory disease", "Moderate" },
                    { "1018", "Polycystic ovary syndrome (PCOS)", "Chronic" },
                    { "1019", "Routine prenatal checkup", "Mild" },
                    { "1020", "Obesity-related metabolic syndrome", "Moderate" }
            };

            String query2 = "INSERT INTO diagnosis (consultationID, diagnosisDescription, severity) VALUES (?, ?, ?)";

            PreparedStatement insert2 = connect.prepareStatement(query2);

            for (Object[] i : diag) {
                insert2.setInt(1, (int) i[0]); // consult id
                insert2.setString(2, (String) i[1]); // diagnosis description
                insert2.setString(3, (String) i[2]); // severityt2
                insert2.executeUpdate();
            }

            insert2.close();

            // Medicine
            Object[][] med = {
                    // example data
                    { "1001", "Tylenol", "Acetaminophen", 100, 25 },
                    { "1002", "Advil", "Ibuprofen", 200, 150 },
                    { "1003", "Amoxil", "Amoxicillin", 50, 10 },
                    { "1004", "Lipitor", "Atorvastatin", 500, 300 },
                    { "1005", "Zocor", "Simvastatin", 100, 50 },
                    { "1006", "Glucophage", "Metformin", 250, 100 },
                    { "1007", "Ventolin", "Albuterol", 300, 50 },
                    { "1008", "Zithromax", "Azithromycin", 120, 60 },
                    { "1009", "Norvasc", "Amlodipine", 150, 75 },
                    { "1010", "Plavix", "Clopidogrel", 200, 120 },
                    { "1011", "Synthroid", "Levothyroxine", 100, 20 },
                    { "1012", "Xanax", "Alprazolam", 80, 15 },
                    { "1013", "Prozac", "Fluoxetine", 100, 40 },
                    { "1014", "Crestor", "Rosuvastatin", 250, 180 },
                    { "1015", "Augmentin", "Amoxicillin/Clavulanic Acid", 100, 30 },
                    { "1016", "Nexium", "Esomeprazole", 150, 50 },
                    { "1017", "Lyrica", "Pregabalin", 75, 25 },
                    { "1018", "Coumadin", "Warfarin", 50, 10 },
                    { "1019", "Zoloft", "Sertraline", 200, 120 },
                    { "1020", "Prilosec", "Omeprazole", 300, 180 },
                    { "1021", "Flonase", "Fluticasone", 400, 250 },
                    { "1022", "Claritin", "Loratadine", 500, 300 },
                    { "1023", "Allegra", "Fexofenadine", 200, 100 },
                    { "1024", "Singulair", "Montelukast", 100, 30 },
                    { "1025", "Lantus", "Insulin Glargine", 50, 15 },
                    { "1026", "Humalog", "Insulin Lispro", 75, 25 },
                    { "1027", "Januvia", "Sitagliptin", 200, 150 },
                    { "1028", "Tamiflu", "Oseltamivir", 120, 50 },
                    { "1029", "Levaquin", "Levofloxacin", 100, 40 },
                    { "1030", "Diflucan", "Fluconazole", 80, 30 }
            };

            String query3 = "INSERT INTO medicine (medicineID, brandName, commonName, quantity, availability) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement insert3 = connect.prepareStatement(query3);

            for (Object[] i : med) {
                insert3.setInt(1, (int) i[0]); // medicine id
                insert3.setString(2, (String) i[1]); // brand name
                insert3.setString(3, (String) i[2]); // common name
                insert3.setInt(4, (int) i[3]); // quantity
                insert3.setInt(5, (int) i[4]); // availability
                insert3.executeUpdate();
            }

            insert3.close();

            // prescription
            Object[][] pres = {
                    // example data
                    { "1003", "1001", "500 mg", "3 times a day", "2024-11-22", "2024-11-29",
                            "Take after meals to avoid stomach upset." },
                    { "1002", "1002", "200 mg", "Twice a day", "2024-11-22", "2024-11-27",
                            "Apply topical cream if itching persists." },
                    { "1019", "1003", "50 mg", "As needed", "2024-11-22", "2024-12-01",
                            "Avoid triggers like bright lights or loud noises." },
                    { "1014", "1004", "10 mg", "Once daily", "2024-11-22", "2025-11-21",
                            "Take at the same time each day to ensure effectiveness." },
                    { "1010", "1005", "20 mg", "Twice a day", "2024-11-22", "2025-01-22",
                            "Use a hot compress for added pain relief." },
                    { "1006", "1006", "10 mg", "Once daily", "2024-11-22", "2025-11-21",
                            "Monitor chest pain and seek immediate help if it worsens." },
                    { "1007", "1007", "90 mcg", "Every 4-6 hours", "2024-11-22", "2024-11-29",
                            "Use inhaler as prescribed for breathing difficulties." },
                    { "1008", "1008", "500 mg", "Once daily for 3 days", "2024-11-22", "2024-11-24",
                            "Take with a full glass of water." },
                    { "1009", "1009", "5 mg", "Once daily", "2024-11-22", "2025-11-21",
                            "Check blood pressure weekly for monitoring." },
                    { "1011", "1010", "50 mcg", "Once daily", "2024-11-22", "2025-11-21",
                            "Schedule an eye exam every 6 months." },
                    { "1012", "1012", "0.25 mg", "As needed", "2024-11-22", "2024-12-22",
                            "Avoid alcohol while taking this medication." },
                    { "1013", "1013", "20 mg", "Once daily", "2024-11-22", "2025-11-21",
                            "Regular follow-up is needed to monitor mood changes." },
                    { "1014", "1014", "500 mg", "Twice a day", "2024-11-22", "2025-11-21",
                            "Monitor blood sugar levels regularly." },
                    { "1015", "1015", "25 mcg", "Once daily", "2024-11-22", "2025-11-21",
                            "Take on an empty stomach for better absorption." },
                    { "1003", "1016", "500 mg", "3 times a day", "2024-11-22", "2024-11-27",
                            "Drink plenty of water to aid recovery." },
                    { "1017", "1017", "75 mg", "Twice daily", "2024-11-22", "2025-01-22",
                            "Use a heating pad for added comfort." },
                    { "1018", "1018", "2.5 mg", "Once daily", "2024-11-22", "2025-11-21",
                            "Discuss fertility options during follow-up." },
                    { "1019", "1019", "Prenatal vitamins", "Once daily", "2024-11-22", "2025-08-22",
                            "Maintain a healthy diet and stay hydrated." },
                    { "1020", "1020", "Metformin 500 mg", "Twice a day", "2024-11-22", "2025-11-21",
                            "Regular exercise is recommended alongside medication." }
            };

            String query4 = "INSERT INTO prescription (medicineID, consultationID, dosage, frequency, startDate, endDate, notes)"
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement insert4 = connect.prepareStatement(query4);

            for (Object[] i : pres) {
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
