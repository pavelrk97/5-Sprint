package managers;

public class Managers {
    public static InMemoryHistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static InMemoryTaskManager getDeafault() {
        return new InMemoryTaskManager();
    }
}
