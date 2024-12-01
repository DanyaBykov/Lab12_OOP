package ucu.edu.ua.Task2;

public class Main {
    public static void main(String[] args) {
        Signature<String> task1 = new Signature<>(s -> System.out.println("Task1: " + s));
        Signature<String> task2 = new Signature<>(s -> System.out.println("Task2: " + s));

        Group<String> group = new Group<>();
        group.addTask(task1).addTask(task2);

        group.apply("Sample Argument");

        System.out.println("Group Headers: " + group.getHeaders());
        System.out.println("Task1 Headers: " + task1.getHeaders());
        System.out.println("Task2 Headers: " + task2.getHeaders());
    }
}