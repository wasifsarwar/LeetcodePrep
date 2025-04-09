public class HashSet {
    private class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    private final ListNode[] set;

    public HashSet() {
        set = new ListNode[1000];
        for (int i = 0; i < set.length; i++) {
            set[i] = new ListNode(0);
        }
    }

    private ListNode hash(int key) {
        return set[key % set.length];
    }

    public void add(int key) {
        ListNode curr = hash(key);
        while (curr.next != null) {
            if (curr.next.key == key)
                return;
            curr = curr.next;
        }
        curr.next = new ListNode(key);
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

    public boolean contains(int key) {
        ListNode curr = hash(key);
        while (curr.next != null) {
            if (curr.next.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
