import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class CoreConceptsExceptionsTest {

    /**
     * During compile time, we are expecting a FileNotFoundException is a checked exception
     */
    @Test
    void checkException(){
        try{
            Class.forName("com.somefake.FakeClass");
        } catch (ClassNotFoundException e) {
            Assertions.assertEquals(ClassNotFoundException.class, e.getClass());
        }
    }

    /**
     * User inputs, strings, non excepted values after compilation
     */
    @Test
    void uncheckedException(){
        String nullStr = null;
        Assertions.assertThrows(NullPointerException.class, () -> nullStr.toString());
    }


}
