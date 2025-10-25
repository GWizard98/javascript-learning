package learning.basics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumTest {
    @Test
    void sumsTwoNumbers() {
        assertEquals(5, Sum.sum(2, 3));
    }
}
