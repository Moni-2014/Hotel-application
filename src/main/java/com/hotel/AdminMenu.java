package com.hotel;

import com.hotel.api.AdminResource;
import com.hotel.exception.InvalidRoomTypeException;
import com.hotel.model.customer.Customer;
import com.hotel.model.room.Room;
import com.hotel.model.room.enums.RoomType;

import java.util.Collection;
import java.util.Scanner;


public class AdminMenu {

    private final AdminResource adminResource;

    public AdminMenu(AdminResource adminResource) {
        this.adminResource = adminResource;
    }
    public void adminMenu() {
        String line;
        final Scanner scanner = new Scanner(System.in);

        printMenu();

        try {
            do {
                line = scanner.nextLine();

                if (line.length() == 1) {
                    switch (line.charAt(0)) {
                        case '1':
                            displayAllCustomers();
                            break;
                        case '2':
                            displayAllRooms();
                            break;
                        case '3':
                            displayAllReservations();
                            break;
                        case '4':
                            addRoom();
                            break;
                        case '5':
                            MainMenu.printMainMenu();
                            break;
                        default:
                            System.out.println("Unknown action\n");
                            break;
                    }
                } else {
                    System.out.println("Error: Invalid action\n");
                }
            } while (line.charAt(0) != '5' || line.length() != 1);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Empty input received. Exiting program...");
        }
    }

    private static void printMenu() {
        System.out.print("""

                Admin Menu
                --------------------------------------------
                1. See all Customers
                2. See all Rooms
                3. See all Reservations
                4. Add a Room
                5. Back to Main Menu
                --------------------------------------------
                Please select a number for the menu option:
                """);
    }

    private void addRoom() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter room number:");
        final String roomNumber = scanner.nextLine();

        System.out.println("Enter price per night:");
        final double roomPrice = enterRoomPrice(scanner);

        System.out.println("Enter room type: 1 for single bed, 2 for double bed:");
        final RoomType roomType = enterRoomType(scanner);

        adminResource.addRoom(roomNumber, roomPrice, roomType);
        System.out.println("Room added successfully!");

        System.out.println("Would like to add another room? y/n");
        addAnotherRoom();
    }

    private static double enterRoomPrice(final Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException exp) {
            System.out.println("Invalid room price! Please, enter a valid double number. " +
                    "Decimals should be separated by point (.)");
            return enterRoomPrice(scanner);
        }
    }

    private static RoomType enterRoomType(final Scanner scanner) {
        try {
            return RoomType.valueOfLabel(scanner.nextLine());
        } catch (InvalidRoomTypeException exp) {
            System.out.println(exp.getMessage());
            return enterRoomType(scanner);
        }
    }

    private void addAnotherRoom() {
        final Scanner scanner = new Scanner(System.in);

        try {
            String anotherRoom;

            anotherRoom = scanner.nextLine();

            while ((anotherRoom.charAt(0) != 'y' && anotherRoom.charAt(0) != 'n')
                    || anotherRoom.length() != 1) {
                System.out.println("Please enter y (Yes) or n (No)");
                anotherRoom = scanner.nextLine();
            }

            if (anotherRoom.charAt(0) == 'y') {
                addRoom();
            } else if (anotherRoom.charAt(0) == 'n') {
                printMenu();
            } else {
                addAnotherRoom();
            }
        } catch (StringIndexOutOfBoundsException ex) {
            addAnotherRoom();
        }
    }

    private void displayAllRooms() {
        Collection<Room> rooms = adminResource.getAllRooms();

        if(rooms.isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            adminResource.getAllRooms().forEach(System.out::println);
        }
    }

    private void displayAllCustomers() {
        Collection<Customer> customers = adminResource.getAllCustomers();

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            customers.forEach(System.out::println);
        }
    }

    private void displayAllReservations() {
        adminResource.displayAllReservations();
    }
}
