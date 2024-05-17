
import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;

public class DayOfTheWeekTest{

//    @Test
//    void todaysDayIsShouldFormatInThePresentTense(){
//        int today_ = 4; // change based on the current day, starting from 0 - Sunday to 6 - Saturday
//        Date currentDate = new Date();
//
//        // Create a Calendar instance and set it to the current date
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(currentDate);
//
//        // Extract the year, month, and day from the Calendar instance
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1; // Adding 1 because months are zero-based
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        DayOfTheWeek today = new DayOfTheWeek(day, month, year);
//        assertEquals(today.doomsday(), today_);
//
//    }

    @Test
    void theGivenDateShouldBeAWednesday(){
        DayOfTheWeek birthday = new DayOfTheWeek(16, 9, 1998);
        assertEquals(birthday.doomsday(), 3);
    }

    @Test
    void signingOfTheDeclarationOfIndependenceShouldBeAThursday(){
        DayOfTheWeek signingOfTheDeclarationOfIndependence = new DayOfTheWeek(4,7,1776);
        assertEquals(signingOfTheDeclarationOfIndependence.doomsday(), 4);
    }

    @Test
    void fallOfTheBerlinWallShouldBeAThursday(){
        DayOfTheWeek fallOfTheBerlinWall = new DayOfTheWeek(9,11,1989);
        assertEquals(fallOfTheBerlinWall.doomsday(), 4);
    }

    @Test
    void firstDayOfTheGregorianCalendarInHollandAndFlandersShouldBeASaturday(){
        DayOfTheWeek firstDayOfTheGregorianCalendar = new DayOfTheWeek(1,1,1583);
        assertEquals(firstDayOfTheGregorianCalendar.doomsday(), 6);
    }

    @Test
    void BattleOfWaterlooShouldBeASunday(){
        DayOfTheWeek BattleOfWaterloo = new DayOfTheWeek(18,6,1815);
        assertEquals(BattleOfWaterloo.doomsday(), 0);
    }

    @Test
    void newYear2050WillBeASaturday(){
        DayOfTheWeek newYear2050 = new DayOfTheWeek(1,1,2050);
        assertEquals(newYear2050.doomsday(), 6);
    }

    @Test
    void independenceDay2100WillBeASunday(){
        DayOfTheWeek independenceDay2100 = new DayOfTheWeek(4,7,2100);
        assertEquals(independenceDay2100.doomsday(), 0);
    }


    @Test
    void endOfLongplayerCompositionWillBeATuesday(){
        DayOfTheWeek endOfLongplayerComposition = new DayOfTheWeek(31,12,2999);
        assertEquals(endOfLongplayerComposition.doomsday(), 2);
    }

    @Test
    void invalidYearInputShouldThrowAnException(){

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DayOfTheWeek invalidYear = new DayOfTheWeek(31,12,1299);
                    invalidYear.doomsday();
                }
        );

        assertEquals("Invalid input. Please enter a valid year between (1583 - 9999)", exception.getMessage());
    }

    @Test
    void invalidDateInputShouldThrowAnException(){

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DayOfTheWeek invalidDate = new DayOfTheWeek(30,2,2000);
                    invalidDate.doomsday();
                }
        );

        assertEquals("Invalid date, date should be between (1 - 29)", exception.getMessage());
    }

    @Test
    void invalidMonthInputShouldThrowAnException(){

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DayOfTheWeek invalidMonth = new DayOfTheWeek(3,0,2299);
                    invalidMonth.doomsday();
                }
        );

        assertEquals("Month out of range, should be between (1-12)", exception.getMessage());
    }


}