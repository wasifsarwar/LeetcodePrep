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

class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        for (String string : strings) {
            System.out.println(string);
        }

        TopSongs topSongs = new TopSongs(3);
        topSongs.registerPlays("Boolean Rhapsody", 193);
        topSongs.registerPlays("Coding In The Deep", 146);
        System.out.println(topSongs.topK());
        topSongs.registerPlays("All About That Base Case", 291);
        topSongs.registerPlays("Here Comes The Bug", 223);
        topSongs.registerPlays("Oops! I Broke Prod Again", 274);
        topSongs.registerPlays("All the Single Brackets", 132);
        System.out.println(topSongs.topK());
        System.out.println(topSongs.topK());
    }
}

class TopSongs {
    int K;

    class Song {
        String song;
        int plays;

        public Song(String song, int plays) {
            this.song = song;
            this.plays = plays;
        }
    }

    PriorityQueue<Song> minHeap;

    public TopSongs(int k) {
        this.K = k;
        this.minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.plays, a.plays));
    }

    public void registerPlays(String song, int plays) {
        Song currentSong = new Song(song, plays);
        minHeap.offer(currentSong);
        if (minHeap.size() > K) {
            minHeap.poll();
        }
    }

    public List<String> topK() {
        List<String> result = new ArrayList<>();
        PriorityQueue<Song> temp = new PriorityQueue<>(this.minHeap);
        int i = 0;
        while (i < this.K && !temp.isEmpty()) {

            Song currentSong = temp.poll();
            result.add(currentSong.song);
            i++;

        }
        return result;
    }

}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you
// would normally – your AI Interviewer will be able to see it.

// # Top Songs Class

// Implement a `TopSongs` class that receives an integer `k > 0` during
// initialization and has two methods:

// - `register_plays(title, plays)` indicates that a song was played a given
// number of times. It returns nothing. The method is never called with the same
// title twice.
// - `top_k()` returns the (up to) `k` registered song titles with the most
// plays, in any order, and breaking ties arbitrarily.

// ```
// Example:
// s = TopSongs(3)
// s.register_plays("Boolean Rhapsody", 193)
// s.register_plays("Coding In The Deep", 146)
// s.top_k() # Returns ["Coding In The Deep", "Boolean Rhapsody"]
// s.register_plays("All About That Base Case", 291)
// s.register_plays("Here Comes The Bug", 223)
// s.register_plays("Oops! I Broke Prod Again", 274)
// s.register_plays("All the Single Brackets", 132)
// s.top_k() # Returns ["All About That Base Case", "Here Comes The Bug", "Oops!
// I Broke Prod Again"]
// ```

// Constraints:

// - The number of songs is at most 10^5
// - Each element in songs is a tuple with a string and an integer
