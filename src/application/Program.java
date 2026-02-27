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

        Reservation reservation = null;
        if (!checkOut.isAfter(checkIn)) {
            IO.println("Error in reservation: Check-out date must be after check-in date ");
        } else {
            reservation = new Reservation(number, checkIn, checkOut);
            IO.println("Reservation: " + reservation);

            IO.println();
            IO.println("Enter data to update the reservation: ");
            IO.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            IO.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtf);

            LocalDate now = LocalDate.now(ZoneId.systemDefault());

            if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
                IO.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkOut.isAfter(checkIn)) {
                IO.println("Error in reservation: Check-out date must be after check-in date ");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                IO.println("Reservation: " + reservation);
        }
    }
        sc.close();
    }
}
