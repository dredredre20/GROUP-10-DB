class doctorWorkInfo {
    int doctorID;
    int salary;
    String licenseNumber;
    String workingHours;
    int maxPatientLoad;
    int currentPatientLoad;
    
    public doctorWorkInfo(int doctorID, int salary, String licenseNumber, String workingHours, int maxPatientLoad, int currentPatientLoad){

        this.doctorID = doctorID;
        this.licenseNumber = licenseNumber; 
        this.salary = salary; 
        this.workingHours = workingHours; 
        this.maxPatientLoad = maxPatientLoad; 
        this.currentPatientLoad = currentPatientLoad;
    }


}
