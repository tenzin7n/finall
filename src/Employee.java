public class Employee extends Person {
    private String position;
    private String shift;

    // Default constructor
    public Employee() {
        super();
    }

    // Parameterized constructor
    public Employee(String name, int age, String id, String position, String shift) {
        super(name, age, id); // Call the Person class constructor
        this.position = position;
        this.shift = shift;
    }

    // Getters and setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
