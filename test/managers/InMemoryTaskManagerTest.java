package managers;

import model.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import status.Status;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void init() {
        taskManager = Managers.getDeafault();
    }

    @Test
    void addNewTask_ShouldSaveTask() {
        // prepare
        Task task = new Task("Name", "Desct1");
        Task expectedTask = new Task("Name", "Desct1");
        expectedTask.setId(1);

        // do
        taskManager.createTask(task);

        // check
        Assertions.assertNotNull(taskManager.getTaskById(1));
        Assertions.assertEquals(expectedTask, task);

    }

    @Test
    void updateTask_shouldUpdateTaskWithSpecificatedId() {
        // prepare
        taskManager.createTask(new Task("Task1", "Task des"));
        Task newTask = new Task("Task2", "Updated", Status.DONE, 1);


        // do
        taskManager.updateTask(newTask);

        // check
        Assertions.assertEquals(taskManager.getTaskById(1), newTask);
    }

    @Test
    void
}
