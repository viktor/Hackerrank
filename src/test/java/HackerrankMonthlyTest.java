import org.hackerrank.monthkit.SockMerchant;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hackerrank.Utils.print;

public class HackerrankMonthlyTest {

    @Test
    void sockMerchantTest(){
        int result = SockMerchant.sockMerchant(9, Arrays.asList(1, 1, 3, 1, 2, 1, 3, 3, 3, 3) );
        System.out.println(result);
    }

    @Test
    void pageCount() {
        int totalPages = 6, p = 2;
        int limit = totalPages%2==0 ? totalPages+1 : totalPages;
        int leftToRight = 0, rightToLeft = 0;
        boolean leftSide = false, rightSide = false;

        for (int page = 1; page < p && page < limit; page+=2){
            leftSide = true;
            leftToRight++;
        }

        for (int page = totalPages; page > 1 && page > p; page-=2){
            rightSide = true;
            rightToLeft++;
        }

        int response = (leftSide && rightSide) ? Math.min(leftToRight, rightToLeft) :
                leftSide ? leftToRight : rightToLeft;

        print("response: %s \n", response);
        print("left: %s , right: %s \n", leftSide, rightSide);
        print("totalPages: %s \n", totalPages);
        print("leftToRight %s \n", leftToRight);
        print("rightToLeft: %s \n", rightToLeft);
    }


}
