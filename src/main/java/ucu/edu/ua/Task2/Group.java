package ucu.edu.ua.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Group<T> extends Task<T> {
    public String groupUuid;
    private List<Task<T>> tasks;
    private boolean isFrozen = false;
    private final Map<String, String> headers = new HashMap<>();

    public Group() {
        tasks = new ArrayList<>();
    }

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        if (!isFrozen) {
            isFrozen = true;
            groupUuid = UUID.randomUUID().toString();
            setHeader("groupUuid", groupUuid);
            for (Task<T> task : tasks) {
                task.freeze();
                if (task instanceof Signature) {
                    ((Signature<T>) task).stamp("groupUuid", groupUuid);
                }
            }

            tasks = Collections.unmodifiableList(tasks);
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        for (Task<T> task : tasks) {
            task.apply(arg);
        }
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getTaskCount() {
        return tasks.size();
    }
}
