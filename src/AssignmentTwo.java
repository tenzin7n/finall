import java.io.*;

public class AssignmentTwo {

    public static void main(String[] args) throws IOException {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() throws IOException {
        Ride rollerCoaster = new Ride("Roller Coaster", 5);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of visitors to add to the queue:");
        int numVisitors = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numVisitors; i++) {
            System.out.println("Enter Visitor Details (name, age, id, ticketType, contactNumber):");
            String[] details = reader.readLine().split(",");
            String name = details[0].trim();
            int age = Integer.parseInt(details[1].trim());
            String id = details[2].trim();
            String ticketType = details[3].trim();
            String contactNumber = details[4].trim();

            Visitor visitor = new Visitor(name, age, id, ticketType, contactNumber);
            rollerCoaster.addVisitorToQueue(visitor);
        }

        System.out.println("Current Queue:");
        rollerCoaster.printQueue();

        System.out.println("Removing the first visitor from the queue...");
        rollerCoaster.removeVisitorFromQueue();

        System.out.println("Updated Queue:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        Ride rollerCoaster = new Ride("Roller Coaster", 5);

        Visitor v1 = new Visitor("Alice", 25, "V101", "Regular", "1234567890");
        Visitor v2 = new Visitor("Bob", 30, "V102", "VIP", "9876543210");

        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);

        System.out.println("Checking if Alice is in the history: " + rollerCoaster.checkVisitorFromHistory(v1));

        System.out.println("Ride History:");
        rollerCoaster.printRideHistory();
    }

    public void partFive() throws IOException {
        Ride rollerCoaster = new Ride("Roller Coaster", 5);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of visitors to add to the queue:");
        int numVisitors = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numVisitors; i++) {
            System.out.println("Enter Visitor Details (name, age, id, ticketType, contactNumber):");
            String[] details = reader.readLine().split(",");
            String name = details[0].trim();
            int age = Integer.parseInt(details[1].trim());
            String id = details[2].trim();
            String ticketType = details[3].trim();
            String contactNumber = details[4].trim();

            Visitor visitor = new Visitor(name, age, id, ticketType, contactNumber);
            rollerCoaster.addVisitorToQueue(visitor);
        }

        System.out.println("Running one cycle of the ride...");
        rollerCoaster.runOneCycle();

        System.out.println("Ride History After One Cycle:");
        rollerCoaster.printRideHistory();
    }

    public void partSix() throws IOException {
        Ride rollerCoaster = new Ride("Roller Coaster", 5);

        Visitor v1 = new Visitor("Alice", 25, "V101", "Regular", "1234567890");
        Visitor v2 = new Visitor("Bob", 30, "V102", "VIP", "9876543210");

        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);

        rollerCoaster.exportRideHistory("ride_history.csv");
        System.out.println("Ride history exported to ride_history.csv");
    }

    public void partSeven() throws IOException {
        Ride rollerCoaster = new Ride("Roller Coaster", 5);

        rollerCoaster.importRideHistory("ride_history.csv");

        System.out.println("Imported Ride History:");
        rollerCoaster.printRideHistory();
    }
}
