class Patient {
    int patientID;
    String lastName, firstName;
    String sex, birthday;
    String contactNumber;
    String emergencyContactPerson;
    String emergencyContactNumber;
    String bloodType;
    String allergies;
    int addressID;
    Address pAddress;

    //initialize patient details
    public Patient(int patientID, String lastName, String firstName, String sex, String birthday, String contactNumber, String emergencyContactPerson, 
        String emergencyContactNumber,String address, String bloodType, String allergies, int addressID, Address pAddress, String streetAddress, String city,
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
        this.addressID = addressID;

        //create an address for the patient
        this.pAddress = new Address(addressID, streetAddress, city, province, postalCode);

    }

    //when address is updated
    public void updateAddress(String streetAddress, String city, String province, String postalCode) {
        this.pAddress = new Address(this.addressID, streetAddress, city, province, postalCode);
    }

    //return the address
    public Address getAddress(){
        return pAddress;
    }

    //return the addressID
    public int getAddressID(){
        return addressID;
    }



}
