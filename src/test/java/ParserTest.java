import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void stringSplit_string_stringArray() {
        assertEquals("[todo, return, book]", Arrays.toString(new Parser().parse("todo return book")));
    }
}
