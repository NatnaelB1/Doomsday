
import java.util.Calendar;
import java.util.Date;

/**
 * <p> Doomsday algorithm is a mathematical method for calculating the day of the week for any given date.
 * It was devised by John Horton Conway and named after the day of the week, doomsday, upon which certain years are based.
 * The algorithm relies on knowing the doomsday for each month, which is a specific day of the week that falls on certain
 *  dates within each month. By using simple calculations based on the known doomsdays, you can determine the day of
 *  the week for any date.
 *
 * <p>Special days
 * 4/4, 6/6, 8/8, 10/10, 12/12, 5/9, 9/5, 7/11, 11/7 - are all same day of the week in a year
 * <p>Jan 3rd, Feb 28th also share the same day of the week with the dates above if the year is not leap year.
 * If year is leap year then Jan 4th and Feb 29th share the same day of the week.
 * 14th of March shares same day of the week with the dates above
 *
 * <p>How do we know the special day for a year?
 * <p>- Special day is the next day of the week compared to the previous year except leap years, which will be two days
 * after the previous year.
 * <p>1700 - Sunday, 1800 - Friday, 1900 - Wednesday, 2000 - Tuesday and the pattern repeats over and over again
 * - Every 27 years the Special day pattern repeats, for example 1700 - Sunday and 1728, 1756, 1784 are also similar.
 * */

public class DayOfTheWeek {
    int date;
    int month;
    int year;

    public DayOfTheWeek(int date, int month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int doomsday(){

        // check validity of the given day
        if (!validateInput().equals("Valid date")){
            throw new IllegalArgumentException(validateInput());
        }

        // Holds the value of the special day of the week for the start of the given year's century
        int centuryStartSD = centurySD();
        // Stop the calculation here if special day us -1, special day must be one of the 4 days
        // 2 - Tuesday, 0 - Sunday, 5 - Friday, 3 - Wednesday
        if (centuryStartSD == -1){
            throw new IllegalArgumentException("Error estimating the special day of the century");
        }

        // Store how many leap years there are starting from the start of the century to the given year
        int leapYears = Math.floorDiv((year % 100), 4);

        // Calculate how many years from the start of the century have passed and add the leap years in between
        int ly = (year % 100) + leapYears;

        // Calculate the doomsday of the year by counting up from the start of the century
        int doomsdayForGivenYr = ((ly % 7) + centuryStartSD) % 7;

        // Find the day of the month that is the same day of the week as the year as the other special days of every month
        int monthSpecialDay = monthSelector();

        // count up or down from the month's special day to find which day of the week our given day is
        int dayOfTheWeek = calculateDoomsday(doomsdayForGivenYr, monthSpecialDay);

        // Print the result
        printFormat(dayOfTheWeek);

        return dayOfTheWeek;
    }

    /**
     * Check if the input day is a valid day and if day is within range (1583AD - 9999AD)
     * **/
    private String validateInput(){
        if (month < 1 || month > 12){
            return "Month out of range, should be between (1-12)";
        }
        if (year < 1583 || year > 10000){
            return "Invalid input. Please enter a valid year between (1583 - 9999)";
        }

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

        if (date < 1 || date > maxDay){
            return "Invalid date, date should be between (1 - " + maxDay +")";
        }

        return "Valid date";
    }


    /**
     * Estimates the start of the centuries special day
     * **/
    private int centurySD(){
        if (year % 400 < 100){
            return 2; // Tuesday
        }
        if (year % 400 >= 100 && year % 400 < 200){
            return 0; // Sunday
        }
        if (year % 400 >= 200 && year % 400 < 300){
            return 5; // Friday
        }
        if (year % 400 >= 300){
            return 3; // Wednesday
        }
        else{
            return -1;
        }
    }


    /**
     *  Since we know which day of the week our pi day is, we can calculate the day of the week for a given date by
     *  counting forward from Pi Day if the given date is later in the month, or counting backward if the given date is
     *  earlier in the month.
     * **/
    private int calculateDoomsday(int specialDayOfTheYear, int piDay){
        // If given date is later day in the given month than the pi-day
        if (date > piDay){
            int dateDifference = date - piDay;
            int dateDifferenceWithAWeek = dateDifference % 7;
            return (specialDayOfTheYear + dateDifferenceWithAWeek) % 7;
        }
        // If given date is later day in the given month than the pi-day
        else if (date < piDay){
            int dateDifference = piDay - date;
            int dateDifferenceWithAWeek = dateDifference % 7;
            if (specialDayOfTheYear - dateDifferenceWithAWeek < 0){
                return 7 + (specialDayOfTheYear - dateDifferenceWithAWeek);
            }
            return (specialDayOfTheYear - dateDifferenceWithAWeek) % 7;
        }
        // If given date is the pi-day, just return the pi date
        return specialDayOfTheYear;
    }

    /**
     * <p>Based on the month, get the date that has similar day of the week as the year's special day
     *
     * <p>To be a leap year, the year number must be divisible by four – except for end-of-century years,
     * which must be divisible by 400. This means that the year 2000 was a leap year, although 1900 was not.
     * **/
    private int monthSelector() {
        int piDay; // pi days all share the same day of the week in a year

        switch (month) {
            case 1: piDay = isLeapYear() ? 4 : 3; break; // January
            case 2: piDay = isLeapYear() ? 29 : 28; break; // February
            case 3: piDay = 14; break; // March
            case 4: piDay = 4; break; // April
            case 5: piDay = 9; break; // May
            case 6: piDay = 6; break; // June
            case 7: piDay = 11; break; // July
            case 8: piDay = 8; break; // August
            case 9: piDay = 5; break; // September
            case 10: piDay = 10; break; // October
            case 11: piDay = 7; break; // November
            case 12: piDay = 12; break; // December
            default: return -1;
        }
        return piDay;
    }

    // Given a year estimates if it is a leap year
    private boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private void printFormat(int dayOfTheWeek){

        String weekDay; // return day

        switch (dayOfTheWeek) {
            case 0 -> weekDay = "Sunday \n";
            case 1 -> weekDay = "Monday \n";
            case 2 -> weekDay = "Tuesday \n";
            case 3 -> weekDay = "Wednesday \n";
            case 4 -> weekDay = "Thursday \n";
            case 5 -> weekDay = "Friday \n";
            case 6 -> weekDay = "Saturday \n";
            default -> {
                System.out.println(dayOfTheWeek);
                weekDay = "Oops something went wrong (Invalid inputs)";
            }
        }

        Date currentDate = new Date();

        // Create a Calendar instance and set it to the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Extract the year, month, and day from the Calendar instance
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Adding 1 because months are zero-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (this.year == year && this.month == month && this.date == day) {
            System.out.println("Today " + this.date + "/" + this.month + "/" + this.year + " is a " + weekDay);
        } else if (this.year < year || (this.year == year && this.month < month) || (this.year == year && this.month == month && this.date < day)) {
            System.out.println("The day " + this.date + "/" + this.month + "/" + this.year + " was a " + weekDay);
        } else {
            System.out.println("The day " + this.date + "/" + this.month + "/" + this.year + " will be a " + weekDay);
        }

    }

}

