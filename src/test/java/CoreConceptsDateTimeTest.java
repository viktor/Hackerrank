
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.hackerrank.Utils.print;

public class CoreConceptsDateTimeTest {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Test
    void datetimes(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.from(fmt.parse("2024/08/01 01:10:01"));

        print("localDateTime: %s localDateTime: %s \n", now, dateTime);
        print("today is: %s , %s ,%s, %s, \n", now.getDayOfWeek(), now.getDayOfMonth(), now.getMonth(), now.getYear());
        print("and Aug 5: %s, %s ", dateTime.getDayOfWeek(), dateTime.getDayOfMonth());

        print("\n\n Duration Between \n");
        Duration duration = Duration.between(dateTime, now);
        print("the diff between dates is: %s secs \n", duration.getSeconds());

        print("\n\n Period Between \n");
        Period period = Period.between(LocalDate.now(), LocalDate.of(2024, 8, 1));
        print("the diff between dates is: %s days , %s months, %s years \n", period.getDays(), period.getMonths(), period.getYears());
    }

}
