// Use Case 5 – Booking Request (First-Come-First-Served)
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName + " | Room Type: " + roomType);
    }
}

class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation r) {
        requestQueue.add(r);
    }

    public void displayRequests() {

        System.out.println("\nBooking Requests in Queue:");

        for (Reservation r : requestQueue) {
            r.displayReservation();
        }
    }
}

class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("       Book My Stay v5.1");

        BookingRequestQueue queue = new BookingRequestQueue();

        System.out.print("Enter number of booking requests: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for request " + i);

            System.out.print("Guest Name: ");
            String name = sc.nextLine();

            System.out.print("Room Type (Single/Double/Suite): ");
            String room = sc.nextLine();

            Reservation reservation = new Reservation(name, room);

            queue.addRequest(reservation);
        }

        queue.displayRequests();

        sc.close();
    }
}