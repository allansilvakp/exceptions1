package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    void main() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        IO.print("Room number: ");
        int number = sc.nextInt();
        IO.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
        IO.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dtf);


        if (!checkOut.isAfter(checkIn)) {
            IO.println("Error in reservation: Check-out date must be after check-in date ");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            IO.println("Reservation: " + reservation);

            IO.println();
            IO.println("Enter data to update the reservation: ");
            IO.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            IO.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtf);

                String error = reservation.updateDates(checkIn, checkOut);
                if (error != null) {
                    IO.println("Error in reservation: " + error);
                }
                else {
                    IO.println("Reservation: " + reservation);
                }
    }
        sc.close();
    }
}
