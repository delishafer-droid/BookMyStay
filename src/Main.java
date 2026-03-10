// Use Case 4 – Room Search & Availability Check

import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0); // Example: unavailable
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}
class Room {

    private String type;
    private int beds;
    private double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void displayDetails() {
        System.out.println("Room Type : " + type);
        System.out.println("Beds      : " + beds);
        System.out.println("Price     : $" + price);
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {
        System.out.println("       Book My Stay ");
        RoomInventory inventory = new RoomInventory();

        Room single = new Room("Single Room", 1, 100.0);
        Room doubleRoom = new Room("Double Room", 2, 180.0);
        Room suite = new Room("Suite Room", 3, 300.0);

        Room[] rooms = {single, doubleRoom, suite};

        System.out.println("\nAvailable Rooms:\n");

        for (Room room : rooms) {

            int availability = inventory.getAvailability(room.getType());

            if (availability > 0) {   // Show only available rooms
                room.displayDetails();
                System.out.println("Available Rooms: " + availability);
                System.out.println();
            }
        }
    }
}