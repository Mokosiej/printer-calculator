package history;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<Operation> operations;

    public History() {
        this.operations = new ArrayList<>();
    }

    public void addOperation(Operation operation) {
        cleanOldOperations();
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        cleanOldOperations();
        return new ArrayList<>(operations);
    }

    private void cleanOldOperations() {
        LocalDateTime now = LocalDateTime.now();
        operations.removeIf(operation -> operation.getTimestamp().isBefore(now.minusHours(24)));
    }
}

