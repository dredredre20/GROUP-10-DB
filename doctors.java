class doctors {
    int doctorID;
    String doctorLastName;
    String doctorFirstName;
    int departmentID;
    String sex;
    int salary;
    String birthday;
    String phoneNumber;
    String address;
    String licenseNumber;
    String field;
    String specialization;
    String workingHours;

    public doctors(int doctorID, String doctorLastName, String doctorFirstName, int departmentID, String sex, int salary, String birthday, String phoneNumber,
     String address, String streetAddress, String city, String province, String postalCode,
     String licenseNumber, String field, String specialization, String workingHours){

        this.doctorID = doctorID;
        this.doctorLastName = doctorLastName;
        this.doctorFirstName = doctorFirstName;
        this.departmentID = departmentID;
        this.sex =sex;
        this.salary = salary;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = streetAddress + city + province + postalCode;
        this.licenseNumber = licenseNumber;
        this.field = field;
        this.specialization = specialization;
        this.workingHours = workingHours;
    }
    
}
