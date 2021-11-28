//first name, last name, phone number, address, password
//order number

//text file: Customer name, customer Phone customer address, order number, items ordered (receipt)

public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String password;

    public Customer(String firstName, String lastName, String phoneNumber, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}

