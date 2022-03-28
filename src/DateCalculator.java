import java.time.Instant;
import java.util.Calendar;
import java.util.Date;


/**
 * @author Aabishkar Aryal
 *  This class is used to calculate the input date and return the date after the calculation
 *  
 */
public class DateCalculator {

    /**
     * method to increase date
     * 
     * @param date    - date to be increased
     * @param days    - number of days to be increased
     * @param months  - number of months to be increased
     * @param years   - number of years to be increased
     * @param hours   - number of hours to be increased
     * @param minutes - number of minutes to be increased
     * @param seconds - number of seconds to be increased
     * @return Instant - increased date
     */
    public Instant increaseDate(Instant date, int days, int months, int years, int hours, int minutes, int seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(date));
        cal.add(Calendar.DATE, days);
        cal.add(Calendar.MONTH, months);
        cal.add(Calendar.YEAR, years);
        cal.add(Calendar.HOUR, hours);
        cal.add(Calendar.MINUTE, minutes);
        cal.add(Calendar.SECOND, seconds);
        return cal.getTime().toInstant();
    }

    /**
     * method to decrease date
     * 
     * @param date    - date to be decreased
     * @param days    - number of days to be decreased
     * @param months  - number of months to be decreased
     * @param years   - number of years to be decreased
     * @param hours   - number of hours to be decreased
     * @param minutes - number of minutes to be decreased
     * @param seconds - number of seconds to be decreased
     * @return Instant - decreased date
     */
    public Instant decreaseDate(Instant date, int days, int months, int years, int hours, int minutes, int seconds) {
        // System.out.println("decrease date");
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(date));
        cal.add(Calendar.DATE, -days);
        cal.add(Calendar.MONTH, -months);
        cal.add(Calendar.YEAR, -years);
        cal.add(Calendar.HOUR, -hours);
        cal.add(Calendar.MINUTE, -minutes);
        cal.add(Calendar.SECOND, -seconds);
        return cal.getTime().toInstant();
    }

    /**
     * snaps the date to the lowest day, month, year, hour, minute, second
     * method to snap date
     * 
     * @param date - date to be snapped
     * @param unit - unit to be snapped
     * @return Instant - snapped date
     */
    public Instant snapDate(Instant date, char unit) {
        if (unit == 'd') {
            Calendar cal = Calendar.getInstance();
            cal.setTime(Date.from(date));
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime().toInstant();
        } else if (unit == 'n') {
            Calendar cal = Calendar.getInstance();
            cal.setTime(Date.from(date));
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime().toInstant();

        } else if (unit == 'y') {
            Calendar cal = Calendar.getInstance();
            cal.setTime(Date.from(date));
            cal.set(Calendar.DAY_OF_YEAR, 1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime().toInstant();

        } else if (unit == 'h') {
            Calendar cal = Calendar.getInstance();
            cal.setTime(Date.from(date));
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime().toInstant();

        } else if (unit == 'm') {
            Calendar cal = Calendar.getInstance();
            cal.setTime(Date.from(date));
            cal.set(Calendar.SECOND, 0);
            return cal.getTime().toInstant();

        }

        else {
            // System.out.println("invalid unit");
            return date;
        }

    }
}