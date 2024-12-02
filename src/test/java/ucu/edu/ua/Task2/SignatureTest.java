package ucu.edu.ua.Task2;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class SignatureTest {
    private Signature<String> signature;
    private StringBuilder output;

    @Test
    public void testApply() {
        output = new StringBuilder();
        Consumer<String> consumer = output::append;
        signature = new Signature<>(consumer);

        signature.apply("Test Argument");
        assertEquals("Test Argument", output.toString(), "Consumer should process the argument");
    }

    @Test
    public void testFreeze() {
        output = new StringBuilder();
        Consumer<String> consumer = output::append;
        signature = new Signature<>(consumer);

        signature.freeze();
        assertNotNull(signature.getId(), "ID should be generated after freeze");
    }

    @Test
    public void testStamp() {
        output = new StringBuilder();
        Consumer<String> consumer = output::append;
        signature = new Signature<>(consumer);

        signature.stamp("key", "value");
        assertEquals("value", signature.getHeader("key"), "Header value should be set correctly");
    }
}
