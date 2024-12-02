package ucu.edu.ua.Task2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class GroupTest {
    private Group<String> group;
    private Signature<String> task1;
    private Signature<String> task2;
    private StringBuilder output1;
    private StringBuilder output2;

    @Test
    public void testApply() {
        output1 = new StringBuilder();
        output2 = new StringBuilder();
        task1 = new Signature<>(output1::append);
        task2 = new Signature<>(output2::append);
        group = new Group<>();
        group.addTask(task1).addTask(task2);

        group.apply("Test Argument");
        assertNotNull(group.getHeader("groupUuid"), "Group UUID should be set");
        assertEquals(group.getHeader("groupUuid"), task1.getHeader("groupUuid"), "Task1 should have the same group UUID");
        assertEquals(group.getHeader("groupUuid"), task2.getHeader("groupUuid"), "Task2 should have the same group UUID");
        assertEquals("Test Argument", output1.toString(), "Task1 should process the argument");
        assertEquals("Test Argument", output2.toString(), "Task2 should process the argument");
    }

    @Test
    public void testFreeze() {
        output1 = new StringBuilder();
        output2 = new StringBuilder();
        task1 = new Signature<>(output1::append);
        task2 = new Signature<>(output2::append);
        group = new Group<>();
        group.addTask(task1).addTask(task2);

        group.freeze();
        assertNotNull(group.getHeader("groupUuid"), "Group UUID should be set after freeze");
        assertEquals(group.getHeader("groupUuid"), task1.getHeader("groupUuid"), "Task1 should have the same group UUID after freeze");
        assertEquals(group.getHeader("groupUuid"), task2.getHeader("groupUuid"), "Task2 should have the same group UUID after freeze");
    }

    @Test
    public void testAddTask() {
        output1 = new StringBuilder();
        output2 = new StringBuilder();
        task1 = new Signature<>(output1::append);
        task2 = new Signature<>(output2::append);
        group = new Group<>();
        group.addTask(task1).addTask(task2);

        Signature<String> task3 = new Signature<>(output1::append);
        group.addTask(task3);
        assertEquals(3, group.getTaskCount(), "Group should contain 3 tasks");
    }
}
