import java.io.*;
import java.util.*;

public class Ride {
    private String name;
    private int maxRiders;
    private int numOfCycles;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;

    public Ride(String name, int maxRiders) {
        this.name = name;
        this.maxRiders = maxRiders;
        this.numOfCycles = 0;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Add visitor to queue
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println(visitor.getName() + " added to the queue.");
    }

    // Remove visitor from queue
    public void removeVisitorFromQueue() {
        Visitor removed = visitorQueue.poll();
        if (removed != null) {
            System.out.println(removed.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
    }

    // Print visitors in the queue
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (Visitor visitor : visitorQueue) {
                System.out.println("Visitor: " + visitor.getName() + ", Ticket: " + visitor.getTicketType());
            }
        }
    }

    // Add visitor to ride history
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to the ride history.");
    }

    // Check if visitor is in ride history
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // Get number of visitors in ride history
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // Print ride history
    public void printRideHistory() {
        System.out.println("Ride History:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println("Visitor: " + visitor.getName() + ", Ticket: " + visitor.getTicketType());
        }
    }

    // Sort ride history using Comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted.");
    }

    // Run one ride cycle
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned. Cannot run the ride.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
            return;
        }
        int riders = Math.min(maxRiders, visitorQueue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = visitorQueue.poll();
            addVisitorToHistory(visitor);
        }
        numOfCycles++;
        System.out.println("Ride completed one cycle with " + riders + " visitors. Total cycles: " + numOfCycles);
    }

    // Export ride history to a file
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getTicketType() + "," + visitor.getContactNumber() + "\n");
            }
            System.out.println("Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Import ride history from a file
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    Visitor visitor = new Visitor(details[0], 0, "N/A", details[1], details[2]);
                    addVisitorToHistory(visitor);
                }
            }
            System.out.println("Ride history imported from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Set the operator
    public void setOperator(Employee operator) {
        this.operator = operator;
    }
}