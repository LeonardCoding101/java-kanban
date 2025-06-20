package task;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    private final ArrayList<Integer> subTasksId = new ArrayList<>();

    public Epic(String name, String description, TaskStatus status) {
        super(name, description, status);

    }
    public void addSubtask(Subtask subTask) {
        subTasksId.add(subTask.getId());
    }
    public ArrayList<Integer> getSubTasksId() {
        return subTasksId;
    }

    public void removeSubTask(int subTaskId) {
        subTasksId.remove(subTaskId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subTasksId, epic.subTasksId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subTasksId);
    }
}
