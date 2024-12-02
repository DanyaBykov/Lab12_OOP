package ucu.edu.ua.Task1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class Task1Test {
    private ATM atm;

    @Test
    public void testProcessExactAmount() {
        atm = new ATM();
        atm.process(155);
    }

    @Test
    public void testProcessAmountWithRemainder() {
        atm = new ATM();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            atm.process(157);
        });
        assertEquals("Can't process 2", exception.getMessage());
    }

    @Test
    public void testProcessZeroAmount() {
        atm = new ATM();
        atm.process(0);
    }

    @Test
    public void testProcessNegativeAmount() {
        atm = new ATM();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            atm.process(-1);
        });
        assertEquals("Can't process -1", exception.getMessage());
    }
}
