package HeapOrPriorityQueues;
/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class TopKSongsWithUpdatesSolution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        for (String string : strings) {
            System.out.println(string);
        }

        TopKSongsWithUpdates s = new TopKSongsWithUpdates(3);

        s.registerPlays("Boolean Rhapsody", 100);
        s.registerPlays("Boolean Rhapsody", 193); // Total 293
        s.registerPlays("Coding In The Deep", 75);
        s.registerPlays("Coding In The Deep", 75); // Total 150
        s.registerPlays("All About That Base Case", 200);
        s.registerPlays("All About That Base Case", 90); // Total 290
        s.registerPlays("All About That Base Case", 1); // Total 291
        s.registerPlays("Here Comes The Bug", 223);
        s.registerPlays("Oops! I Broke Prod Again", 274);
        s.registerPlays("All the Single Brackets", 132);
        s.topK();
    }
}

class Song {
    String song;
    int plays;

    public Song(String song, int plays) {
        this.song = song;
        this.plays = plays;
    }
}

public class TopKSongsWithUpdates {
    Map<String, Integer> map;
    PriorityQueue<Song> maxHeap;
    int K;

    public TopKSongsWithUpdates(int k) {
        map = new HashMap<>();
        this.K = k;
        maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.plays, a.plays)); // Max heap: larger values first
    }

    public void registerPlays(String song, int plays) {
        if (map.containsKey(song)) {
            map.put(song, map.get(song) + plays);
        } else {
            map.put(song, plays);
        }
    }

    public List<String> topK() {
        List<String> result = new ArrayList<>();

        // Debug: Print map contents
        System.out.println("Map contents:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Add all songs to the max heap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.offer(new Song(entry.getKey(), entry.getValue()));
        }

        // Debug: Print heap contents
        System.out.println("\nHeap contents before polling:");
        PriorityQueue<Song> tempHeap = new PriorityQueue<>(maxHeap);
        while (!tempHeap.isEmpty()) {
            Song song = tempHeap.poll();
            System.out.println(song.song + ": " + song.plays);
        }

        // Get top K songs
        for (int i = 0; i < K && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll().song);
        }

        // Debug: Print final result
        System.out.println("\nFinal result:");
        System.out.println(result);

        return result;
    }
}

/**
 * Your previous Plain Text content is preserved below:
 * 
 * Hello! Your interview question is below. Write code in this pad just like you
 * would normally – your AI Interviewer will be able to see it.
 * 
 * # Top Songs Class With Updates
 * 
 * Implement a `TopSongs` class that receives an integer `k > 0` during
 * initialization and has two methods:
 * 
 * - `register_plays(title, plays)` indicates that a song was played a given
 * number of times. It returns nothing. The method can be called with the same
 * title multiple times, meaning that we should **add** the new plays to the
 * total number of plays for that song.
 * - `top_k()` returns the (up to) `k` registered song titles with the most
 * plays, in any order, and breaking ties arbitrarily.
 * 
 * ```
 * Example:
 * s = TopSongs(3)
 * s.register_plays("Boolean Rhapsody", 100)
 * s.register_plays("Boolean Rhapsody", 193) # Total 293
 * s.register_plays("Coding In The Deep", 75)
 * s.register_plays("Coding In The Deep", 75) # Total 150
 * s.register_plays("All About That Base Case", 200)
 * s.register_plays("All About That Base Case", 90) # Total 290
 * s.register_plays("All About That Base Case", 1) # Total 291
 * s.register_plays("Here Comes The Bug", 223)
 * s.register_plays("Oops! I Broke Prod Again", 274)
 * s.register_plays("All the Single Brackets", 132)
 * s.top_k() # Returns ["All About That Base Case", "Boolean Rhapsody", "Oops! I
 * Broke Prod Again"]
 * ```
 * 
 * Constraints:
 * 
 * - The number of songs is at most 10^5
 * - Each element in songs is a tuple with a string and an integer
 */