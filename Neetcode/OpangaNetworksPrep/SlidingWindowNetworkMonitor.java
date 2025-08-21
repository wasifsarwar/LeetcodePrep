package OpangaNetworksPrep;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowNetworkMonitor {
    private final int windowSizeSeconds;
    private final Map<String, Queue<Long>> requestsLog;

    public SlidingWindowNetworkMonitor(int windowSizeSeconds) {
        this.windowSizeSeconds = windowSizeSeconds;
        this.requestsLog = new HashMap<>();
    }

    public void addEvent(long timestamp, String eventType) {
        requestsLog.computeIfAbsent(eventType, k -> new ArrayDeque<>()).offer(timestamp);
    }

    public int getEventCount(long currentTime) {
        long windowStart = currentTime - this.windowSizeSeconds;
        int total = 0;
        // Iterate over the queues directly
        for (Queue<Long> timeStamps : requestsLog.values()) {
            while (!timeStamps.isEmpty() && timeStamps.peek() < windowStart) {
                timeStamps.poll();
            }
            total += timeStamps.size();
        }
        return total;
    }

    public int getEventCount(long currentTime, String eventType) {
        if (!requestsLog.containsKey(eventType)) {
            return 0;
        }
        long windowStart = currentTime - this.windowSizeSeconds;
        Queue<Long> timeStamps = requestsLog.get(eventType);
        while (!timeStamps.isEmpty() && timeStamps.peek() < windowStart) {
            timeStamps.poll();
        }
        return timeStamps.size();
    }

    public static void main(String[] args) {
        SlidingWindowNetworkMonitor monitor = new SlidingWindowNetworkMonitor(300); // 5 minute window
        monitor.addEvent(1000, "error");
        monitor.addEvent(1100, "warning");
        monitor.addEvent(1200, "error"); // This event is within the window [1200, 1500]

        // --- Test Case 1 ---
        // Window at time 1500 is [1200, 1500].
        System.out.println("--- Testing at time 1500 ---");
        System.out.println("Total events: " + monitor.getEventCount(1500)); // Expected: 3? No, event at 1000, 1100,
                                                                            // 1200. Window is 300. 1500-300=1200. So
                                                                            // event at 1000, 1100 are out. Expected: 1?
                                                                            // No, addEvent adds 1000, 1100, 1400 in
                                                                            // example. Let's use example.

        // Resetting with example values
        monitor = new SlidingWindowNetworkMonitor(300);
        monitor.addEvent(1000, "error");
        monitor.addEvent(1100, "warning");
        monitor.addEvent(1400, "error");

        System.out.println("Total events (should be 3): " + monitor.getEventCount(1500));
        System.out.println("Error events (should be 2): " + monitor.getEventCount(1500, "error"));
        System.out.println("Warning events (should be 1): " + monitor.getEventCount(1500, "warning"));

        // --- Test Case 2 ---
        // Window at time 1600 is [1300, 1600]. The event at 1100 is now outside.
        System.out.println("\n--- Testing at time 1600 ---");
        System.out.println("Total events (should be 1): " + monitor.getEventCount(1600));
        System.out.println("Error events (should be 1): " + monitor.getEventCount(1600, "error"));
        System.out.println("Warning events (should be 0): " + monitor.getEventCount(1600, "warning"));
    }
}
