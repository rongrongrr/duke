import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void testStringConversion() {
        assertEquals("[T][n] return book", new Todo("return book").toString());
    }
}
