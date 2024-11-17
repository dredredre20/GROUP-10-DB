class doctors {
    int doctorID;
    String doctorLastName;
    String doctorFirstName;
    String sex;
    String birthday;
    String phoneNumber;
    String address;
    String email;

    public doctors(int doctorID, String doctorLastName, String doctorFirstName, String sex, int salary, String birthday, String phoneNumber,
     String streetAddress, String city, String province, String postalCode, String email){

        this.doctorID = doctorID;
        this.doctorLastName = doctorLastName;
        this.doctorFirstName = doctorFirstName;
        this.sex =sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = streetAddress + ", " + city + ", " + province + ", " +  postalCode;
        this.email = email;

    }
    
}
