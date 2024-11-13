class departments {
    int departmentID;
    String departmentName;
    String phoneNumber;
    String address;
    String email;
    int capacity;

    //Initialize details
    public departments (int departmentID, String departmentName, String phoneNumber, 
                    String address, String streetAddress, String city, String province, String postalCode,
                    String email, int capacity){

        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.phoneNumber = phoneNumber;
        this.address = address + streetAddress + city + province + postalCode;
        this.email = email;
        this.capacity = capacity;
    }

}





