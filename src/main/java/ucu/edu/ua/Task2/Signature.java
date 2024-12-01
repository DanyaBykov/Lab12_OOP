package ucu.edu.ua.Task2;

import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    public Consumer<T> consumer;
    private boolean isFrozen = false;

    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        consumer.accept(arg);
    }

    @Override
    public void freeze() {
        if (!isFrozen) {
            super.freeze();
            isFrozen = true;
        }
    }

    public void stamp(String key, String value) {
        setHeader(key, value);
    }
}
