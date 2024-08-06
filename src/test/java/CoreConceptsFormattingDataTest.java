import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hackerrank.Utils.print;

public class CoreConceptsFormattingDataTest {

    @Test
    void stringFormats(){
        print(String.format("%s %d %c", "string", 10, 'c'));
    }

    @Test
    void dateFormats(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/dd HH:mm");
        DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime now = LocalDateTime.now();
        print("full date: %s \n", fmt.format(now));
        print("month day hour: %s \n", fmt2.format(now));
        print("hour: %s \n", hour.format(now));
    }

    @Test
    void decimalFormat() throws ParseException {
        DecimalFormat fmt = new DecimalFormat("$0.00");
        DecimalFormat fmt2 = new DecimalFormat("€0.00");

        print("\n\n Decimal format for Currency \n");
        print("decimal format usd %s \n", fmt.format(1000.01D));
        print("decimal format eur %s \n", fmt2.format(100.50D));
        print("parsed value: %d ", fmt.parse("$1.0"));

        print("\n\n Decimal format for percentages \n");
        DecimalFormat fmt3 = new DecimalFormat("0.0%");
        print("format 1D: %s \n", fmt3.format(1D));
        print("format 0.5D: %s \n", fmt3.format(0.5D));
        print("format 2D: %s \n", fmt3.format(2D));
        print("format 0.01D: %s \n", fmt3.format(0.01D));
    }

}
