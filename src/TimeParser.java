
import java.time.Instant;


/**
 * @author Aabishkar Aryal
 */
public class TimeParser {

    public static void main(String[] args) {
        /**
         * Inputs for testing
         * String testInput1 = "now()+10d+5m+5s";
         * String testInput2 = "now()+2y+12mon-10m+12h@mon";
         * String tesInput3 = "now()-1y@mon";
         * String testInput4 = "now()@d";
         * String testInput5 = "now()-1d";
         * String testInput6 = "now()-1mon-1d";
         */
        String input = "now()+1y+10d-5m+5s";
        Instant parsedDate = parse(input);
        System.out.println("result: " + parsedDate.toString());

    }

    /**
     * @param input - input string
     * @return Instant - parsed date
     */

    public static Instant parse(String input) {

        String reg = "((?<=[\\+|\\-|\\@|=])|(?=[\\+|\\-|\\@|=]))";

        /**
         * String to keep track of current operator
         */
        String currentOperator = "";

        String[] res = input.split(reg);
        // System.out.println(Arrays.toString(res));
        // Date date = new Date();
        Instant date = Instant.now();
        // System.out.println("input: "+ date);
        DateCalculator calculate = new DateCalculator();

        /**
         * check if last character is a operator or unit
         */

        for (String string : res) {
            if (string.equals("+") || string.equals("-") || string.equals("@")) {

                currentOperator = string;
            }

            else {
                /**
                 * a char to keep track of unit
                 * d = days 
                 * n = months [last char of the unit "mon" is n]
                 * y = years
                 * h = hours
                 * m = minutes
                 * s = seconds
                 */
                char currentUnit = string.charAt(string.length() - 1);
                if (currentUnit == 'd'
                        || currentUnit == 'm'
                        || currentUnit == 'y'
                        || currentUnit == 'h'
                        || currentUnit == 'n'
                        || currentUnit == 's') {

                    if (currentUnit == 'd') {
                        // removing digits to extract only the unit
                        String digits = string.replaceAll("[^0-9.]", "");
                        // System.out.println(digits +" " + currentOperator+" days");
                        if (currentOperator.equals("+")) {
                            date = calculate.increaseDate(date, Integer.parseInt(digits), 0, 0, 0, 0, 0);
                        } else if (currentOperator.equals("-")) {

                            date = calculate.decreaseDate(date, Integer.parseInt(digits), 0, 0, 0, 0, 0);
                        } else if (currentOperator.equals("@")) {
                            date = calculate.snapDate(date, currentUnit);
                        }

                    } else if (currentUnit == 'n') {
                        // removing digits to extract only the unit
                        String digits = string.replaceAll("[^0-9.]", "");
                        // System.out.println(digits +" " + currentOperator+" month");
                        if (currentOperator.equals("+")) {
                            date = calculate.increaseDate(date, 0, Integer.parseInt(digits), 0, 0, 0, 0);
                        } else if (currentOperator.equals("-")) {
                            date = calculate.decreaseDate(date, 0, Integer.parseInt(digits), 0, 0, 0, 0);
                        } else if (currentOperator.equals("@")) {
                            date = calculate.snapDate(date, currentUnit);
                        }
                    } else if (currentUnit == 'y') {
                        // removing digits to extract only the unit
                        String digits = string.replaceAll("[^0-9.]", "");
                        // System.out.println(digits +" " + currentOperator+" year");
                        if (currentOperator.equals("+")) {
                            date = calculate.increaseDate(date, 0, 0, Integer.parseInt(digits), 0, 0, 0);
                        } else if (currentOperator.equals("-")) {
                            date = calculate.decreaseDate(date, 0, 0, Integer.parseInt(digits), 0, 0, 0);
                        } else if (currentOperator.equals("@")) {
                            date = calculate.snapDate(date, currentUnit);
                        }
                    } else if (currentUnit == 'h') {
                        // removing digits to extract only the unit
                        String digits = string.replaceAll("[^0-9.]", "");
                        // System.out.println(digits +" " + currentOperator+" hour");
                        if (currentOperator.equals("+")) {
                            date = calculate.increaseDate(date, 0, 0, 0, Integer.parseInt(digits), 0, 0);
                        } else if (currentOperator.equals("-")) {
                            date = calculate.decreaseDate(date, 0, 0, 0, Integer.parseInt(digits), 0, 0);
                        } else if (currentOperator.equals("@")) {
                            date = calculate.snapDate(date, currentUnit);
                        }
                    } else if (currentUnit == 'm') {
                        // removing digits to extract only the unit
                        String digits = string.replaceAll("[^0-9.]", "");
                        // System.out.println(digits +" " + currentOperator+" minutes");
                        if (currentOperator.equals("+")) {
                            date = calculate.increaseDate(date, 0, 0, 0, 0, Integer.parseInt(digits), 0);
                        } else if (currentOperator.equals("-")) {
                            // System.out.println("in minus minutes method");
                            date = calculate.decreaseDate(date, 0, 0, 0, 0, Integer.parseInt(digits), 0);
                        } else if (currentOperator.equals("@")) {
                            date = calculate.snapDate(date, currentUnit);
                        }
                    } else if (currentUnit == 's') {
                        // removing digits to extract only the unit
                        String digits = string.replaceAll("[^0-9.]", "");
                        // System.out.println(digits +" " + currentOperator+" seconds");
                        if (currentOperator.equals("+")) {
                            date = calculate.increaseDate(date, 0, 0, 0, 0, 0, Integer.parseInt(digits));
                        } else if (currentOperator.equals("-")) {
                            date = calculate.decreaseDate(date, 0, 0, 0, 0, 0, Integer.parseInt(digits));
                        } else if (currentOperator.equals("@")) {
                            // do nothing
                        }
                    }

                } else {
                    /**
                     * System.out.println("Invalid input");
                     */

                }

            }

        }
        return date;

    }

}
