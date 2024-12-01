import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.Task2.Signature;

public class SignatureTest {
    private Signature<String> signature;
    private StringBuilder output;

    @BeforeEach
    public void setUp() {
        output = new StringBuilder();
        Consumer<String> consumer = output::append;
        signature = new Signature<>(consumer);
    }

    @Test
    public void testApply() {
        signature.apply("Test Argument");
        assertEquals("Test Argument", output.toString(), "Consumer should process the argument");
    }

    @Test
    public void testFreeze() {
        signature.freeze();
        assertNotNull(signature.getId(), "ID should be generated after freeze");
    }

    @Test
    public void testStamp() {
        signature.stamp("key", "value");
        assertEquals("value", signature.getHeader("key"), "Header value should be set correctly");
    }
}
