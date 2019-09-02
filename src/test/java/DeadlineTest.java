import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void testStringConversion() {
        assertEquals("[D][n] return book (by: 01/01/2019 1500)", new Deadline("return book","01/01/2019 1500").toString());
    }
}
