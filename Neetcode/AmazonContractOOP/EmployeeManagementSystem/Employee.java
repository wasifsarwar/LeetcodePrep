package AmazonContractOOP.EmployeeManagementSystem;

import java.util.*;

public class Employee {
    int id;
    String name;
    String title;
    String department;
    int salary;
    Employee manager;
    Set<Employee> directReports;

    public Employee(String name, String title, String department, int salary) {
        if (name == null || salary < 0)
            throw new IllegalArgumentException();
        this.id = new Random().nextInt();
        this.name = name;
        this.title = title;
        this.department = department;
        this.salary = salary;
        this.directReports = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getDirectReports() {
        return new ArrayList<>(this.directReports);
    }

    public void addDirectReport(Employee sub) {
        if (sub == null)
            throw new IllegalArgumentException();
        if (sub == this)
            throw new IllegalArgumentException();
        if (wouldCreateCycle(sub)) {
            throw new IllegalArgumentException("Cannot create circular reporting structure");
        }
        if (this.directReports.contains(sub)) {
            return;
        }
        if (sub.manager != null) {
            sub.manager.directReports.remove(sub);
        }
        sub.manager = this;
        this.directReports.add(sub);
    }

    public void removeDirectReport(Employee sub) {
        if (this.directReports.contains(sub)) {
            this.directReports.remove(sub);
            sub.manager = null;
        }
    }

    public void setManager(Employee newManager) {
        if (this.manager == newManager) {
            return;
        }

        if (this.manager != null) {
            this.manager.directReports.remove(this);
        }

        this.manager = newManager;
        if (newManager != null) // only add if new manager
            newManager.directReports.add(this);
    }

    private boolean wouldCreateCycle(Employee potentialSub) {
        Employee current = this.manager;
        while (current != null) {
            if (current == potentialSub) {
                return true;
            }
            current = current.manager;
        }
        return false;
    }

    public Employee lowestCommonManager(Employee e1, Employee e2) {
        if (e1 == null || e2 == null) {
            return null;
        }

        if (e1 == e2)
            return e1; // same employee

        Set<Employee> e1Manager = new HashSet<>();
        Employee current = e1;
        while (current != null) {
            e1Manager.add(current);
            current = current.manager;
        }

        Employee curr2 = e2;
        while (curr2 != null) {
            if (e1Manager.contains(curr2)) {
                return curr2;
            }
            curr2 = curr2.manager;
        }

        return null;
    }

    public List<Employee> getAllSubordEmployees() {
        List<Employee> result = new ArrayList<>();
        Queue<Employee> queue = new LinkedList<>();
        for (Employee directReport : directReports)
            queue.offer(directReport);
        while (!queue.isEmpty()) {
            Employee cur = queue.poll();
            result.add(cur);
            for (Employee sub : cur.directReports) {
                queue.offer(sub);
            }

        }
        return result;

    }
}
