public class PopulateData {
    public static void main(String[] args) {
        Transactions transactions = new Transactions("jdbc:mysql://127.0.0.1:3306/hmo", "root", "password");
        PopulateDoctor doctor = new PopulateDoctor();
        PopulatePatient patient = new PopulatePatient();
        PopulateConsul1 consultations1 = new PopulateConsul1();
        PopulateConsul2 consultations2 = new PopulateConsul2();

        // Call the populate methods IF not called yet, otherwise leave commented out
        //doctor.doctor();
        //patient.Patient();
        //consultations1.consultations1();
        //consultations2.consultations2();
    }
}
