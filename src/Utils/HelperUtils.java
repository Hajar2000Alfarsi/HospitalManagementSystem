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


}
