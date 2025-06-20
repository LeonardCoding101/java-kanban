import task.*;

public class Main {

    public static void main(String[] args) {

        TaskManager t = new TaskManager();

        t.addEpicTask(new Epic("Чек", "Эпика", TaskStatus.NEW));
        t.addEpicTask(new Epic("Проверка", "Удаления", TaskStatus.NEW));
        t.addTask(new Task("Проверка", "Обновления таска", TaskStatus.NEW));
        t.addSubTask(new Subtask("Проверка сабтаск", "Проверка описания сабтаск", TaskStatus.DONE, 1));
        t.addSubTask(new Subtask("Проверка сабтаск", "Проверка описания сабтаск", TaskStatus.DONE, 1));
        t.addSubTask(new Subtask("Проверка сабтаск2", "Проверка описания сабтаск2", TaskStatus.DONE, 2));
        t.addSubTask(new Subtask("Проверка сабтаск2", "Проверка описания сабтаск2", TaskStatus.DONE, 2));
        t.updateTask(new Task("Проверка", "Обновлёёёённый таск", TaskStatus.IN_PROGRESS));
        System.out.println("-----------------");
        System.out.println(t.listAllTasks());
        System.out.println(t.getSubtasksFromEpicId(2));

    }
}
