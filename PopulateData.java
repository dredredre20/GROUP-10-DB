public class PopulateData {
    public static void main(String[] args) {
        PopulateDoctor doctor = new PopulateDoctor();
        PopulatePatient patient = new PopulatePatient();
        PopulateConsul1 consultations1 = new PopulateConsul1();
        PopulateConsul2 consultations2 = new PopulateConsul2();

        // Call the populate methods
        doctor.doctor();
        patient.Patient();
        consultations1.consultations1();
        consultations2.consultations2();
    }
}