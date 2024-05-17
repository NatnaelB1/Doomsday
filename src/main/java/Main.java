import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("        ▒▒▒▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒        ▒▒▒▒▒      ▒▒▒    ▒▒▒    ");
        System.out.println("        ▒▒▒        ▒▒▒   ▒▒▒       ▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒  ▒▒▒▒           ▒▒▒        ▒▒▒    ▒▒▒     ▒▒▒    ▒▒▒  ▒▒▒     ");
        System.out.println("        ▒▒▒         ▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒         ▒▒▒  ▒▒▒       ▒▒▒     ▒▒▒▒       ");
        System.out.println("        ▒▒▒        ▒▒▒   ▒▒▒       ▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒           ▒▒▒▒  ▒▒▒        ▒▒▒   ▒▒▒▒▒▒▒▒▒▒▒▒▒      ▒▒        ");
        System.out.println("        ▒▒▒▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒    ▒▒▒       ▒▒▒      ▒▒       \n");

        System.out.println("      ▒▒▒▒      ▒▒▒         ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒   ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒        ");
        System.out.println("   ▒▒▒    ▒▒▒   ▒▒▒         ▒▒▒            ▒▒▒       ▒▒▒  ▒▒▒       ▒▒▒       ▒▒▒            ▒▒▒       ▒▒▒       ▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒        ");
        System.out.println("  ▒▒▒      ▒▒▒  ▒▒▒         ▒▒▒    ▒▒▒▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒ ▒▒▒▒▒▒▒▒        ▒▒▒            ▒▒▒       ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒        ");
        System.out.println("  ▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒         ▒▒▒       ▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒    ▒▒▒          ▒▒▒            ▒▒▒       ▒▒▒       ▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒        ");
        System.out.println("  ▒▒▒      ▒▒▒  ▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒       ▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒       ▒▒▒       ▒▒▒       ▒▒▒  ▒▒▒   ▒▒▒   ▒▒▒      \n");

        System.out.println("DayOfTheWeek Calculator: tells what day of the week the day entered was/is/will be starting " +
                "from near the start of the use of the Gregorian calendar \n");


        Scanner scanner = new Scanner(System.in);

        // Input month
        int month;
        do {
            System.out.print("Enter the month (1-12): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 12.");
                scanner.next();
            }
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        // Input year
        int year;
        do {
            System.out.print("Enter the year (1583 - 9999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next();
            }
            year = scanner.nextInt();
        } while (year < 1583 || year > 10000);

        // Validate the day input based on the month and leap year
        int maxDay;
        switch (month) {
            case 2: // February
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    maxDay = 29; // Leap year
                } else {
                    maxDay = 28; // Non-leap year
                }
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                maxDay = 30;
                break;
            default: // other months
                maxDay = 31;
                break;
        }

        // Input day
        int day;
        do {
            System.out.print("Enter the day (1-" + maxDay + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid day.");
                scanner.next();
            }
            day = scanner.nextInt();
        } while (day < 1 || day > maxDay);

        // Print the validated input
        System.out.println("You entered: " + month + "/" + day + "/" + year);

        scanner.close();
        DayOfTheWeek inputDay = new DayOfTheWeek(day, month, year);
        inputDay.doomsday();


    }
}

