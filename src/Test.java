import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

// public class Test {

//     public static void main(String[] args) {
//         // Assuming you retrieve the date/time strings from the database
//         String checkinText = "Saturday January 2024, 11:11:11"; // Replace with your actual string from the database
//         String checkoutText = "Sunday January 2024, 11:11:11"; // Replace with your actual string from the database

//         // Define the date format
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMMM uuuu',' HH:mm:ss",Locale.ENGLISH);

//         try {
//             // Parse the strings into Date objects
//             Date checkinDate = (Date)formatter.parse(checkinText);
//             Date checkoutDate = (Date) formatter.parse(checkoutText);

//             // Calculate the difference in days
//             long millisecondsDifference = checkoutDate.getTime() - checkinDate.getTime();
//             long daysDifference = millisecondsDifference / (1000 * 60 * 60 * 24);

//             // Print the result
//             System.out.println("Number of days between checkin and checkout: " + daysDifference);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

public class Test {

    public static void main(String[] args) {
        // // Get the current date and time
        // LocalDateTime currentDateTime = LocalDateTime.now();

        // // Define a custom formatter with the desired pattern
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
        // HH:mm:ss");

        // // Format the date and time using the formatter
        // String formattedDateTime = currentDateTime.format(formatter);

        // // Print the formatted date and time
        // System.out.println("Current Date and Time: " + formattedDateTime);

        String s1 = "2024-01-20 21:36:49";
        // Define the formatter with the pattern matching the string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the string into LocalDateTime object
        LocalDateTime givenDateTime = LocalDateTime.parse(s1, formatter);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Calculate the difference in days
        long daysDifference = ChronoUnit.DAYS.between(givenDateTime, currentDateTime);

        // Print the result
        System.out.println(
                "Number of days between the given date and time and the current date and time: " + daysDifference);
    }
}


// // Get the current date and time
        // LocalDateTime currentDateTime = LocalDateTime.now();

        // // Define a custom formatter with the desired pattern
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
        // HH:mm:ss");

        // // Format the date and time using the formatter
        // String formattedDateTime = currentDateTime.format(formatter);