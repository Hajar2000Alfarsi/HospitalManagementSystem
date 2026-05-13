package Utils;

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
}
