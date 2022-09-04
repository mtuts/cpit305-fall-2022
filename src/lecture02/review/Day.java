package lecture02.review;

public class Day {
    int id;
    public static String[] dayOfWeek;

    static {
        dayOfWeek = new String[7];
        dayOfWeek[0] = "Saturday";
        dayOfWeek[1] = "Sunday";
        dayOfWeek[2] = "Monday";
        // ...
    }

    public static String getDay(int i) {
        return dayOfWeek[i];
    }


}
