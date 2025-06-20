import task.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TaskManager {

    public final HashMap<Integer, Task> tasks = new HashMap<>();
    public final HashMap<Integer, Subtask> subTasks = new HashMap<>();
    public final HashMap<Integer, Epic> epicTasks = new HashMap<>();
    private static int idCounter = 1;

    public ArrayList<Task> listAllTasks() {
        if (tasks.size() == 0) {
            System.out.println("Список задач пуст");
        }
        ArrayList<Task> taskList = new ArrayList<>();
        for (Task task : tasks.values()) {  //Тут IDEA предлагает сделать формат return new ArrayList<>(tasks.values());
            taskList.add(task); // но мы такое еще не проходили, пробежался циклом
        }
        return taskList;
    }

    public ArrayList<Subtask> listAllSubTasks() {
        if (subTasks.size() == 0) {
            System.out.println("Список подзадач пусть");
        }
        ArrayList<Subtask> subTaskList = new ArrayList<>();
        for (Subtask subtask : subTasks.values()) {
            subTaskList.add(subtask);
        }
        return subTaskList;
    }

    public ArrayList<Epic> listAllEpics() {
        if (epicTasks.size() == 0) {
            System.out.println("Список комплексных задач пуст");
        }
        ArrayList<Epic> epicTaskList = new ArrayList<>();
        for (Epic epic : epicTasks.values()) {
            epicTaskList.add(epic);
        }
        return epicTaskList;
    }

    void addTask(Task task) {
        task.setId(idCounter);
        tasks.put(idCounter, task);
        idCounter++;
    }

    void addSubTask(Subtask subTask) {
        subTask.setId(idCounter);
        subTasks.put(idCounter, subTask);
        idCounter++;
        int epicOfSubtask = subTask.getEpicId();
        Epic epic = epicTasks.get(epicOfSubtask);
        if (epic != null) {
            epic.addSubtask(subTask); // Остается вопрос, нужно ли сюда добавлять обновление статуса эпика
        }                             // в изначальной версии не добавил

    }

    void addEpicTask(Epic epic) {
        epic.setId(idCounter);
        epicTasks.put(idCounter, epic);
        idCounter++;
    }

    void updateTask(Task task) {
        int idToUpdateTask = 0;
        for (Task taskCheck : tasks.values()) {
            if (Objects.equals(taskCheck.getName(), task.getName())) {
                idToUpdateTask = taskCheck.getId();
            }
        }
        if (idToUpdateTask > 0) {
            task.setId(idToUpdateTask);
            tasks.put(idToUpdateTask, task);
        }
    }

    void updateEpic(Epic epic) {
        int idToUpdateEpic = 0;
        for (Epic epicCheck : epicTasks.values()) {
            if (Objects.equals(epicCheck.getName(), epic.getName())) {
                idToUpdateEpic = epicCheck.getId();
            }
            if (idToUpdateEpic > 0) {
                epic.setId(idToUpdateEpic);
                epicTasks.put(idToUpdateEpic, epic);
            }
        }
    }

    void updateSub (Subtask subtask) {
        int idToUpdateSub = 0;
        for (Subtask subCheck : subTasks.values()) {
            if (Objects.equals(subCheck.getName(), subtask.getName())) {
                idToUpdateSub = subCheck.getId();
            }
            if (idToUpdateSub > 0) {
                subtask.setId(idToUpdateSub);
                subTasks.put(idToUpdateSub, subtask);
            }
        }
    }

    Task getTaskById(int taskId) {
        return tasks.get(taskId);
    }

    Subtask getSubTaskById(int subTaskId) {
        return subTasks.get(subTaskId);
    }

    Epic getEpicById(int epicId) {
        return epicTasks.get(epicId);
    }

    void removeTaskById(int id) {
        tasks.remove(id);
    }

    void removeSubTaskById(int id) {
        subTasks.remove(id);
    }

    void removeEpicById(int id) {
        epicTasks.remove(id);
        ArrayList<Integer> deletedSubTasks = new ArrayList<>();
        for (Subtask subTaskToDelete : subTasks.values()) {
            if (subTaskToDelete.getEpicId() == id) {
                deletedSubTasks.add(subTaskToDelete.getId());
            }
        }

        for (int idDeletedSubTasks : deletedSubTasks) {
            subTasks.remove(idDeletedSubTasks);
        }
    }

    ArrayList<Subtask> getSubtasksFromEpicId(int id) {
        ArrayList<Subtask> subtasksFromEpicId = new ArrayList<>();
        for (Subtask wantedSub : subTasks.values()) {
            if (wantedSub.getEpicId() == id) {
                subtasksFromEpicId.add(wantedSub);
            }
        }
        return subtasksFromEpicId;
    }

    private void changeEpicStatus(Epic epic) {
        int newCount = 0;
        int doneCount = 0;
        int total = subTasks.size();
        ArrayList<Integer> subTaskProgress = epic.getSubTasksId();
        for (Integer subIds : subTaskProgress) {
            Subtask subTask = subTasks.get(subIds);
            switch (subTask.getStatus()) {
                case NEW:
                    newCount++;
                    break;
                case IN_PROGRESS:
                    break;
                case DONE:
                    doneCount++;
                    break;
            }
        }
    if (newCount == total) {
        epic.setStatus(TaskStatus.NEW);
    } else if (doneCount == total) {
        epic.setStatus(TaskStatus.DONE);
    } else {
        epic.setStatus(TaskStatus.IN_PROGRESS);
    }
    }

    void deleteTasks() {
        tasks.clear();
    }

    void deleteSubTasks() {
        subTasks.clear();
    }

    void deleteEpicTasks() {
        epicTasks.clear();
        subTasks.clear();
    }


}