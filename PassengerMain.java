class Passenger {
    private String name;
    private String id;

    public Passenger(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class Flight {
    private final int MAX_SEATS;
    private Passenger[] seats;

    public Flight(int maxSeats) {
        this.MAX_SEATS = maxSeats;
        seats = new Passenger[MAX_SEATS];
    }

    public boolean bookSeat(Passenger p) {

        for (Passenger passenger : seats) {
            if (passenger != null && passenger.getId().equals(p.getId())) {
                System.out.println("Passenger " + p.getName() + " already booked!");
                return false;
            }
        }

        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                System.out.println("Passenger " + p.getName() + " booked successfully.");
                return true;
            }
        }

        System.out.println("Flight Full! Booking failed for Passenger: " + p.getName());
        return false;
    }

    public void displaySeats() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < MAX_SEATS; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            if (seats[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println(seats[i].getName());
            }
        }
    }
}

public class PassengerMain {
    public static void main(String[] args) {

        Flight flight = new Flight(5);

        Passenger p1 = new Passenger("Aman", "P101");
        Passenger p2 = new Passenger("Rahul", "P102");
        Passenger p3 = new Passenger("Riya", "P103");
        Passenger p4 = new Passenger("Sita", "P104");
        Passenger p5 = new Passenger("John", "P105");
        Passenger p6 = new Passenger("Extra", "P106");

        flight.bookSeat(p1);
        flight.bookSeat(p2);
        flight.bookSeat(p3);
        flight.bookSeat(p4);
        flight.bookSeat(p5);

        flight.bookSeat(p6);
        flight.bookSeat(p1);

        flight.displaySeats();
    }
}