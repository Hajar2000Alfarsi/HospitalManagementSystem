package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class HelperUtils {
    // Check if Object is null
    public static boolean isNull(Object obj){
        return obj == null;
    }

    // Check if String is null or empty
    public static boolean isNull(String str){
        return str == null || str.trim().isEmpty();
    }

    //Check if Object is NOT null
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    // Check if String is NOT null and NOT empty
    public static boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

    //String Validation Methods

    // Check string is not null and not empty
    public static boolean isValidString(String str){
        return str != null && !str.trim().isEmpty();
    }

    // Check minimum length
    public static boolean isValidString(String str, int minLength){
        if (!isValidString(str)){
            return false;
        }
        return str.trim().length() >= minLength;
    }

    //Check length range
    public static boolean  isValidString(String str, int minLength, int maxLength){
        if (!isValidString(str)) {
            return false;
        }

        int length = str.trim().length();

        return length >= minLength && length <= maxLength;
    }

    // Validate using regex pattern
    public static boolean isValidString(String str, String regex) {
        if (!isValidString(str)) {
            return false;
        }
        return str.matches(regex);
    }

    //ID Generation Methods

    //generates random UUID
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    //generates ID with prefix (e.g., "PAT-12345")
    public static String generateId(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            prefix = "ID";
        }

        return prefix + "-" + (int)(Math.random()*100000);
    }

    // custom length
    public static String generateId(String prefix, int length) {
        //Create String to take random number from it
        String number = "0123456789";
        StringBuilder id =  new StringBuilder(prefix + "-");

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            id.append(number.charAt(random.nextInt(number.length())));
        }
        return id.toString();
    }

    //with both prefix and suffix
    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0,8) + "-" + suffix;
    }

    //Date Validation Methods

    //checks not null and valid
    public static boolean isValidate(Date date) {
        return date != null;
    }

    //parses and validates string date
    public static boolean isValidDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()){
            return false;
        }

        //ensure date in the same format like yyyy-mm-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //setLenient to avoid correct the date
        sdf.setLenient(false);

        //Convert text to date
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    //range check
    public static boolean isValidateDate(Date date, Date minDate, Date maxDate) {
        if (date == null || minDate == null || maxDate == null) {
            return false;
        }

        return !date.before(minDate) && !date.after(maxDate);
    }

    //future date
    public static boolean isFutureDate(Date date) {
        if (date == null) return false;
        return date.after(new Date());
    }

    //past date
    public static boolean isPastDate(Date date){
        if (date == null) return false;
        return date.before(new Date());
    }

}
