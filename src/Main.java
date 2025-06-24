import Manager.TaskManager;
import task.*;

public class Main {

    public static void main(String[] args) {

        TaskManager t = new TaskManager();

        t.addTask(new Task("Проверка", "Добавления", TaskStatus.NEW));
        t.addTask(new Task("Повторная", "Проверка добавления", TaskStatus.IN_PROGRESS ));
        t.addEpicTask(new Epic("ЭпикПроверка", "Добавления", TaskStatus.NEW));
        t.addEpicTask(new Epic("ЭпикПовторная", "Проверка", TaskStatus.NEW));
        t.addSubTask(new Subtask("Проверка статуса эпика id3", "Проверка описания сабтаск", TaskStatus.DONE, 3));
        t.addSubTask(new Subtask("Проверка статуса эпика id3", "Проверка описания сабтаск", TaskStatus.IN_PROGRESS, 3));
        t.addSubTask(new Subtask("Проверка статуса эпика id4.1", "Проверка описания сабтаск", TaskStatus.DONE, 4));
        t.addSubTask(new Subtask("Проверка статуса эпика id4.2", "Проверка описания сабтаск", TaskStatus.DONE, 4));
        t.addSubTask(new Subtask("12", "Проверка описания сабтаск", TaskStatus.NEW, 4));
        t.updateTask(new Task("Проверка", "Обновлёёёённый таск", TaskStatus.IN_PROGRESS));
        t.updateTask(new Task("Повторная", "Проверка обновления", TaskStatus.DONE));
        System.out.println("-----------------");
        System.out.println(t.listAllTasks());
        System.out.println(t.listAllEpics());
        t.updateSub(new Subtask("12", "Изменения статуса на Done", TaskStatus.DONE, 4));
        t.removeSubTaskById(6);
        System.out.println(t.listAllEpics());

    }
}
