import manager.TaskManager;
import task.*;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        manager.addTask(new Task("Проверка", "Добавления", TaskStatus.NEW));
        manager.addTask(new Task("Повторная", "Проверка добавления", TaskStatus.IN_PROGRESS));
        manager.updateTask(new Task("Повторная", "Проверка обновления тасков", TaskStatus.DONE));
        manager.addEpic(new Epic("ЭпикПроверка", "Добавления", TaskStatus.NEW));
        manager.addEpic(new Epic("ЭпикПовторная", "Проверка", TaskStatus.NEW));
        manager.addSubTask(new Subtask("Проверка статуса эпика id3", "Проверка описания сабтаск", TaskStatus.DONE, 3));
        manager.addSubTask(new Subtask("Проверка статуса эпика id3", "Проверка описания сабтаск", TaskStatus.IN_PROGRESS, 3));
        manager.addSubTask(new Subtask("Проверка статуса эпика id4.1", "Проверка описания сабтаск", TaskStatus.DONE, 4));
        manager.addSubTask(new Subtask("Проверка статуса эпика id4.2", "Проверка описания сабтаск", TaskStatus.DONE, 4));
        manager.addSubTask(new Subtask("12", "Проверка описания сабтаск", TaskStatus.NEW, 4));
        manager.updateTask(new Task("Проверка", "Обновлёёёённый таск", TaskStatus.IN_PROGRESS));
        manager.updateTask(new Task("Повторная", "Проверка обновления", TaskStatus.DONE));

        System.out.println("-----------------");
        System.out.println(manager.listAllTasks());
        System.out.println(manager.listAllEpics());
        manager.updateEpic(new Epic("ЭпикПроверка", "Обновления Эпика", TaskStatus.IN_PROGRESS));
        manager.updateSubTask(new Subtask("12", "Изменения статуса на Done", TaskStatus.DONE, 4));
        manager.removeSubTaskById(6);
        System.out.println(manager.listAllEpics());
        System.out.println(manager.listAllEpics());
        System.out.println(manager.listAllSubTasks());
        System.out.println("-----------------");
        System.out.println(manager.getEpicById(3));
        System.out.println(manager.getSubtasksFromEpicId(3));
        System.out.println("------------------");
        System.out.println(manager.getTaskById(2));
        manager.removeTaskById(2);
        System.out.println(manager.listAllTasks());
        manager.removeEpicById(3);
        System.out.println(manager.getEpicById(3));
        System.out.println("-----------------");
        System.out.println();
        manager.deleteEpicTasks();
        manager.deleteSubTasks();
        manager.deleteTasks();
        manager.listAllEpics();
        manager.listAllTasks();
        manager.listAllSubTasks();
    }
}
