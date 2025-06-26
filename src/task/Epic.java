package task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {


    private ArrayList<Integer> subTasksId = new ArrayList<>(); // тут изменил значение с final, чтобы при апдейте эпика
    // вызывался метод setSubTasksId и обновлялся статус эпика соответственно
    public Epic(String name, String description, TaskStatus status) {
        super(name, description, status);

    }

    public void addSubtaskId(Subtask subTask) {
        subTasksId.add(subTask.getId());
    }

    public ArrayList<Integer> getSubTasksId() {
        return subTasksId;
    }

    public ArrayList<Integer> setSubTasksId(ArrayList<Integer> subTasksId) {
        this.subTasksId = subTasksId;
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

    @Override
    public String toString() {
        return "Epic{" +
                "subTasksId=" + subTasksId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
