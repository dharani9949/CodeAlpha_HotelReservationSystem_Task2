import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    double price;
    boolean booked;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room[] rooms = {
                new Room(101, "Standard", 1000),
                new Room(102, "Deluxe", 2000),
                new Room(103, "Suite", 3000)
        };

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        System.out.println(
                                "Room No: " + room.roomNumber +
                                " | Category: " + room.category +
                                " | Price: ₹" + room.price +
                                " | Status: " + (room.booked ? "Booked" : "Available"));
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number to Book: ");
                    int bookRoom = sc.nextInt();

                    boolean found = false;

                    for (Room room : rooms) {

                        if (room.roomNumber == bookRoom) {

                            found = true;

                            if (!room.booked) {

                                room.booked = true;

                                System.out.println("Payment Successful!");
                                System.out.println("Room Booked Successfully.");

                            } else {
                                System.out.println("Room Already Booked.");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Room Not Found.");
                    }

                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel Booking: ");
                    int cancelRoom = sc.nextInt();

                    found = false;

                    for (Room room : rooms) {

                        if (room.roomNumber == cancelRoom) {

                            found = true;

                            if (room.booked) {

                                room.booked = false;
                                System.out.println("Booking Cancelled Successfully.");

                            } else {
                                System.out.println("This Room Is Not Booked.");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Room Not Found.");
                    }

                    break;

                case 4:
                    System.out.println("\nBooking Details:");

                    for (Room room : rooms) {

                        if (room.booked) {

                            System.out.println(
                                    "Room No: " + room.roomNumber +
                                    " | Category: " + room.category +
                                    " | Price: ₹" + room.price);
                        }
                    }

                    break;

                case 5:
                    System.out.println("Thank You For Using Hotel Reservation System.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}