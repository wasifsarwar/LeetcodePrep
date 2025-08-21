package OpangaNetworksPrep;

import java.util.*;

public class NetworkProblems {

    /**
     * Problem: You have a list of network devices, each with a status
     * (online/offline)
     * and last_seen timestamp. Find all devices that have been offline for more
     * than
     * a given threshold.
     * 
     * Input:
     * devices = [
     * {"id": "device1", "status": "online", "last_seen": 1640995200},
     * {"id": "device2", "status": "offline", "last_seen": 1640991600},
     * {"id": "device3", "status": "offline", "last_seen": 1640995800}
     * ]
     * threshold_seconds = 7200 # 2 hours
     * 
     * Expected output: ["device2"]
     */

    class Device {
        String id;
        String status; // "online" or "offline"
        long lastSeen; // Unix timestamp in seconds

        // Constructor and getters/setters
    }

    public List<String> findOfflineDevices(List<Device> devices, int thresholdSeconds, long currentTime) {
        // Your implementation here
        List<String> res = new ArrayList<>();
        for (Device device : devices) {
            long lastSeen = device.lastSeen;
            if (device != null && "offline".equals(device.status)) {
                if (currentTime - lastSeen > thresholdSeconds) {
                    res.add(device.id);
                }
            }
        }
        return res;
    }

    public static boolean isRateLimited(String userId, long currentTime,
            Map<String, List<Long>> requestsLog, int limitPerHour) {

        List<Long> timeList = requestsLog.computeIfAbsent(userId, k -> new ArrayList<>());

        Iterator<Long> iterator = timeList.iterator();
        long windowStart = currentTime - 3600; // 1 hour = 3600s
        while (iterator.hasNext()) {
            long times = iterator.next();
            if (times <= windowStart) {
                iterator.remove();
            }
        }

        if (timeList.size() < limitPerHour) {
            timeList.add(currentTime);
            return false;
        }

        return true;
    }

    /**
     * Problem: Given a list of network measurements, calculate the average for each
     * metric type.
     * 
     * measurements = [
     * {"metric": "latency", "value": 100, "timestamp": 1640991600},
     * {"metric": "latency", "value": 120, "timestamp": 1640991700},
     * {"metric": "throughput", "value": 50, "timestamp": 1640991600},
     * {"metric": "throughput", "value": 60, "timestamp": 1640991700}
     * ]
     * 
     * Expected output: {"latency": 110, "throughput": 55}
     */

    class Measurement {
        String metric; // "latency", "throughput", etc.
        double value;
        long timestamp;

        // Constructor and getters/setters
    }

    public Map<String, Double> calculateAverages(List<Measurement> measurements) {
        // Return map of metric -> average value
        Map<String, Double> res = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> sums = new HashMap<>();
        for (Measurement m : measurements) {
            sums.put(m.metric, sums.getOrDefault(m.metric, 0.0) + (Double) m.value);
            counts.put(m.metric, counts.getOrDefault(m.metric, 0) + 1);
        }

        for (String metricKey : sums.keySet()) {
            res.put(metricKey, sums.get(metricKey) / counts.get(metricKey));
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
