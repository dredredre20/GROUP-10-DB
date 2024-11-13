class consultations {
    int consultationID;
    int patientID;
    String startDate;
    int satisfactionRating;
    String endDate;
    String reason;
    int doctorID;
    String treatmentNote;
    String medicinePrescription;

    public consultations(int consultationID, int patientID, String startDate, int satisfactionRating, String endDate, 
            String reason, int doctorID, String treatmentNote, String medicinePrescription){
        
        this.consultationID = consultationID;
        this.patientID = patientID; 
        this.startDate = startDate;
        this.satisfactionRating = satisfactionRating;
        this.endDate = endDate;
        this.reason = reason;
        this.doctorID = doctorID;
        this.treatmentNote = treatmentNote;
        this.medicinePrescription = medicinePrescription;


    }
 
}
