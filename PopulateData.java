public class PopulateData {
    public static void main(String[] args) {

	//ENTER DATABASE HERE 

	String hmo = "jdbc:mysql://127.0.0.1:3306/hmo";
	String user = "root";
	String pass = "password";
        Transactions transactions = new Transactions(hmo, user, pass);
        PopulateDoctor doctor = new PopulateDoctor("hmo, user, pass);
        PopulatePatient patient = new PopulatePatient(hmo, user, pass);
        PopulateConsul1 consultations1 = new PopulateConsul1(hmo, user, pass);
        PopulateConsul2 consultations2 = new PopulateConsul2(hmo, user, pass);

        doctor.doctor();
        patient.Patient();
        consultations1.consultations1();
        consultations2.consultations2();
    }
}
