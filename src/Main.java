import Model.Epic;
import Model.Subtask;
import Model.Task;
import task.TaskManager;
import status.Status;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        // Создайте две задачи
        System.out.println("2 tasl");
        taskManager.createTask(new Task("Zad 1", "Zad - 1", Status.NEW));
        taskManager.createTask(new Task("zad 2", "Zhpa 2", Status.NEW));

        // Создайте эпик с двумя подзадачами
        taskManager.createEpic(new Epic("epic sk 4", "ny da     mmmmm"));
        taskManager.createSubtask(new Subtask("Put your name ", "subT 1 ep", Status.NEW, 1));
        taskManager.createSubtask(new Subtask("Name 2 ", "Subt 2", Status.NEW, 1));
        System.out.println("  ");

        // Создайте эпик с одной подзадачей
        taskManager.createEpic(new Epic("Model.Epic", "Epiocc createsd"));
        taskManager.createSubtask(new Subtask("SubToE[ic", "SubtSk", Status.NEW, 2));
        System.out.println("  ");

        // Распечатайте списки эпиков
        System.out.println(taskManager.getAllTasks());
        System.out.println(taskManager.getAllSubtasks());
        System.out.println(taskManager.getAllEpics());
        System.out.println(" ");

        // Измените статусы созданных объектов, распечатайте их.
        taskManager.getTaskById(1).setStatus(Status.IN_PROGRESS);
        taskManager.getTaskById(2).setStatus(Status.DONE);

        taskManager.getSubtaskById(1).setStatus(Status.IN_PROGRESS);
        Epic epic1 = taskManager.getEpicById(1);
        epic1.setStatus(taskManager.calculateStatus(epic1));
        System.out.println(epic1);

        taskManager.getSubtaskById(3).setStatus(Status.DONE);
        Epic epic2 = taskManager.getEpicById(2);
        epic2.setStatus(taskManager.calculateStatus(epic2));

        System.out.println(taskManager.getAllTasks());
        System.out.println(taskManager.getAllSubtasks());
        System.out.println(taskManager.getAllEpics());

        // Обновление таски по id
        System.out.println("\n---");
        taskManager.createTask(new Task("for change", "descr", Status.NEW));
        System.out.println(taskManager.getAllTasks());
        Task taskNew = new Task("New new", "new descr", Status.DONE, 3);
        taskManager.updateTask(taskNew);
        System.out.println(taskManager.getAllTasks());

        // обновим эпики оп id
        System.out.println("\n---");
        System.out.println(taskManager.getAllEpics());
        Epic epicForUpp = new Epic("newnew", "updated", 1);
        taskManager.updateEpic(epicForUpp);
        System.out.println(taskManager.getAllEpics());

        // обновим сабы по id
        System.out.println(taskManager.getAllEpics());
        System.out.println(taskManager.getAllSubtasks());
        Subtask subForUp = new Subtask("New Sub ", "Updatetion", Status.NEW, 1);
        System.out.println("---");
        subForUp.setId(2);
        taskManager.updateSubtask(subForUp);
        System.out.println(taskManager.getAllEpics());
        System.out.println(taskManager.getAllSubtasks());




    }
}

