class Patient {
    int patientID;
    String lastName, firstName;
    String sex, birthday;
    String contactNumber;
    String emergencyContactPerson;
    String emergencyContactNumber;
    String bloodType;
    String allergies;
    String address;

    //initialize patient details
    public Patient(int patientID, String lastName, String firstName, String sex, String birthday, String contactNumber, String emergencyContactPerson, 
        String emergencyContactNumber,String address, String bloodType, String allergies, String streetAddress, String city,
        String province, String postalCode) {
        
        this.patientID = patientID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.emergencyContactPerson = emergencyContactPerson;
        this.emergencyContactNumber = emergencyContactNumber;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.address = streetAddress + city + province + postalCode;
    }
}
