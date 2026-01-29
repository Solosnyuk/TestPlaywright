package generate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.ThreadLocalRandom;

public class DateGenerate {
    public static String generateRandomDateFromCurrentMonth() {
        LocalDate now = LocalDate.now();
        LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());

        long randomDay = ThreadLocalRandom.current()
                .nextLong(firstDay.toEpochDay(), lastDay.toEpochDay() + 1);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return randomDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }
}
