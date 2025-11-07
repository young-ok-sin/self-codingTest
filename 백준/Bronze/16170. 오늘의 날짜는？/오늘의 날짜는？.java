import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println(utcNow.getYear());
        System.out.println(utcNow.getMonthValue());
        System.out.println(utcNow.getDayOfMonth());
    }
}
