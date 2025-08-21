package OpangaNetworksPrep;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class LoadBalancer {
    private List<String> servers;
    private int currentIndex;

    public LoadBalancer(List<String> servers) {
        // We use a synchronized list to handle concurrent modifications,
        // but still need to synchronize access to `currentIndex` and during iteration.
        this.servers = Collections.synchronizedList(new ArrayList<>(servers));
        this.currentIndex = 0;
    }

    public String getServer() {
        synchronized (this) {
            if (servers.isEmpty()) {
                throw new IllegalStateException("No servers available in the load balancer.");
            }
            // Get the server at the current index
            String server = servers.get(currentIndex);
            // Move the index to the next position, wrapping around if necessary
            currentIndex = (currentIndex + 1) % servers.size();
            return server;
        }
    }

    public void addServer(String server) {
        // Adding a server is a modification, so it must be synchronized
        // to prevent conflicts with other threads trying to get or remove servers.
        synchronized (this) {
            servers.add(server);
        }
    }

    public void removeServer(String server) {
        // Removing a server is also a modification.
        synchronized (this) {
            // Important: Removing a server can mess up the currentIndex.
            // A simple strategy is to reset the index to 0 to avoid an
            // IndexOutOfBoundsException if the removed server was the last one
            // or if the list size changes.
            if (servers.remove(server)) {
                // To be safe, reset index if it's now out of bounds.
                if (currentIndex >= servers.size()) {
                    currentIndex = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer(new ArrayList<>(Arrays.asList("server1", "server2", "server3")));
        System.out.println(lb.getServer());
        System.out.println(lb.getServer());
        System.out.println(lb.getServer());
        System.out.println(lb.getServer()); // Should wrap around to server1

        System.out.println("\n--- Testing after removing a server ---");
        lb.removeServer("server3");
        System.out.println(lb.getServer()); // Continues round-robin on the smaller list
        System.out.println(lb.getServer());
        System.out.println(lb.getServer());

        System.out.println("\n--- Testing after adding a server ---");
        lb.addServer("server4");
        System.out.println(lb.getServer());
        System.out.println(lb.getServer());
        System.out.println(lb.getServer());
    }
}
