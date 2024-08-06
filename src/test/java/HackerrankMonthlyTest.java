import org.hackerrank.monthkit.SockMerchant;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HackerrankMonthlyTest {

    @Test
    void sockMerchantTest(){
        int result = SockMerchant.sockMerchant(9, Arrays.asList(1, 1, 3, 1, 2, 1, 3, 3, 3, 3) );
        System.out.println(result);
    }

}
