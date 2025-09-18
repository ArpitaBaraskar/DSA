import java.util.*;

class Task {
    int userId, taskId, priority, version;
    Task(int u, int t, int p, int v) {
        userId = u;
        taskId = t;
        priority = p;
        version = v;
    }
}

class TaskManager {
    private PriorityQueue<Task> pq;
    private Map<Integer, Task> map;
    private int versionCounter;

    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        versionCounter = 0;
        pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority;
            if (b.taskId != a.taskId) return b.taskId - a.taskId;
            return b.version - a.version;
        });
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        versionCounter++;
        Task t = new Task(userId, taskId, priority, versionCounter);
        map.put(taskId, t);
        pq.offer(t);
    }

    public void edit(int taskId, int newPriority) {
        if (!map.containsKey(taskId)) return;
        versionCounter++;
        Task old = map.get(taskId);
        Task updated = new Task(old.userId, taskId, newPriority, versionCounter);
        map.put(taskId, updated);
        pq.offer(updated);
    }

    public void rmv(int taskId) {
        map.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task t = pq.poll();
            Task latest = map.get(t.taskId);
            if (latest == null) continue;
            if (latest.version != t.version) continue;
            map.remove(t.taskId);
            return t.userId;
        }
        return -1;
    }
}
