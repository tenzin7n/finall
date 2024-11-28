public class Visitor extends Person {
    private String ticketType;
    private String contactNumber;

    // Default constructor
    public Visitor() {
        super();
    }

    // Parameterized constructor
    public Visitor(String name, int age, String id, String ticketType, String contactNumber) {
        super(name, age, id); // Call the Person class constructor
        this.ticketType = ticketType;
        this.contactNumber = contactNumber;
    }

    // Getters and setters
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
