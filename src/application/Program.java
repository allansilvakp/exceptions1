package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    void main() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
                IO.print("Room number: ");
                int number = sc.nextInt();
                IO.print("Check-in date (dd/MM/yyyy): ");
                LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
                IO.print("Check-out date (dd/MM/yyyy): ");
                LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

                Reservation reservation = new Reservation(number, checkIn, checkOut);
                IO.println("Reservation: " + reservation);

                IO.println();
                IO.println("Enter data to update the reservation: ");
                IO.print("Check-in date (dd/MM/yyyy): ");
                checkIn = LocalDate.parse(sc.next(), dtf);
                IO.print("Check-out date (dd/MM/yyyy): ");
                checkOut = LocalDate.parse(sc.next(), dtf);

                reservation.updateDates(checkIn, checkOut);
                IO.println("Reservation: " + reservation);
        }
        catch (DateTimeParseException e) {
            IO.println("Invalid date format");
        }
        catch (DomainException e) {
            IO.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            IO.println("Unexpected error! ");
        }

        sc.close();
    }
}
