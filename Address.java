class Address {
    int addressID;
    String streetAddress;
    String city;
    String province;
    String postalCode;

    //initialize address details
    public Address(int addressID, String streetAddress, String city, String province, String postalCode){
        this.addressID = addressID;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode; 

    }
}
