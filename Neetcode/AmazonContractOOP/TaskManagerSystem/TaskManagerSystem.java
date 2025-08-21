package AmazonContractOOP.TaskManagerSystem;

import java.util.*;

public class TaskManagerSystem {
    /**
     * 🎯 Problem 3: Task Management System (Medium)
     * Time: 25-30 minutes
     * Initial Requirements:
     * 
     * Create, update, and delete tasks
     * Tasks have priority levels (Low, Medium, High)
     * Tasks can be assigned to users
     * Track task status (Todo, In Progress, Done)
     * Filter tasks by assignee, priority, or status
     * 
     * Design Challenge:
     * Design a system that can easily:
     * 
     * Add new task types with different behaviors
     * Implement different notification strategies
     * Add workflow rules (task dependencies)
     * Support different project methodologies (Agile, Waterfall)
     * 
     * Key OOD Concepts to Demonstrate:
     * 
     * State Pattern (task status transitions)
     * Observer Pattern (notifications)
     * Command Pattern (task operations)
     * Template Method (different project workflows)
     * 
     * Extension Questions:
     * 
     * "How would you implement task dependencies?"
     * "What if tasks need approval workflows?"
     * "How would you handle recurring tasks?"
     * "How would you scale notifications for thousands of users?"
     */

    List<Task> tasks;

    public TaskManagerSystem() {
        this.tasks = new ArrayList<>();
    }

    public Task createTask(Task task) {
        this.tasks.add(task);
        return task;
    }

    public synchronized Task updateTask(Task task) {
        Iterator<Task> it = tasks.iterator();

        while (it.hasNext()) {
            Task t = it.next();
            if (t.getId().equals(task.getId())) {
                it.remove();
                tasks.add(task);
                break;
            }
        }
        return task;
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasksByAssignee(String assignee) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.assignee.equals(assignee)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Task> getByStatus(Status status) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.status.equals(status)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Task> getByPriority(Priority priority) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.priority.equals(priority)) {
                result.add(t);
            }
        }
        return result;
    }

    class Task {
        String id;
        String title;
        String description;
        Priority priority;
        Status status;
        String assignee;

        public String getId() {
            return this.id;
        }

    }

    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }

}
