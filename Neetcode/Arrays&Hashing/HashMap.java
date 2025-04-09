public class HashMap {

    private class ListNode {
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        ListNode() {
            this.key = -1;
            this.val = -1;
        }
    }

    private final ListNode[] map;

    public HashMap() {
        map = new ListNode[10000];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ListNode();
        }
    }

    private ListNode hash(int key) {
        return map[key % map.length];
    }

    public void put(int key, int val) {
        ListNode curr = hash(key);
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = val;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, val);
    }

    public int get(int key) {
        ListNode curr = hash(key);
        while (curr.next != null) {
            if (curr.next.key == key) {
                return curr.next.val;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        ListNode curr = hash(key);
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // Similar to operations:
        // ["MyHashMap","put","put","get","get","put","get","remove","get"]
        // With parameters: [[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]

        // Create a new HashMap instance
        HashMap myMap = new HashMap();
        System.out.println("Created new HashMap");

        // Operations sequence
        myMap.put(1, 1);
        System.out.println("put(1, 1)");

        myMap.put(2, 2);
        System.out.println("put(2, 2)");

        int val1 = myMap.get(1);
        System.out.println("get(1): " + val1); // Should return 1

        int val2 = myMap.get(3);
        System.out.println("get(3): " + val2); // Should return -1 (not found)

        myMap.put(2, 1);
        System.out.println("put(2, 1)"); // Update value of key 2

        int val3 = myMap.get(2);
        System.out.println("get(2): " + val3); // Should return 1 (updated value)

        myMap.remove(2);
        System.out.println("remove(2)");

        int val4 = myMap.get(2);
        System.out.println("get(2): " + val4); // Should return -1 (removed)
    }
}
