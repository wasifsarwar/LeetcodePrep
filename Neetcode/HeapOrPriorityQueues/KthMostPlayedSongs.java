package HeapOrPriorityQueues;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/**
 * Your previous Plain Text content is preserved below:
 * 
 * Hello! Your interview question is below. Write code in this pad just like you
 * would normally – your AI Interviewer will be able to see it.
 * 
 * # K Most Played
 * 
 * You are given a list of `(title, plays)` tuples where the first element is
 * the name of a song, and the second is the number of times the song has been
 * played. You are also given a positive integer `k`. Return the `k` most played
 * songs from the list, in any order.
 * 
 * - If the list has fewer than `k` songs, return all of them.
 * - Break ties in any way you want.
 * - You can assume that song titles have a length of at most `50`.
 * 
 * ```
 * Example:
 * songs = [["All the Single Brackets", 132],
 * ["Oops! I Broke Prod Again", 274],
 * ["Coding In The Deep", 146],
 * ["Boolean Rhapsody", 193],
 * ["Here Comes The Bug", 291],
 * ["All About That Base Case", 291]]
 * k = 3
 * Output: ["All About That Base Case", "Here Comes The Bug", "Oops! I Broke
 * Prod Again"]. Any order of these (excellent) songs would be valid.
 * ```
 * 
 * Constraints:
 * 
 * - The length of songs is at most 10^5
 * - Each element in songs is a tuple with a string and an integer
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Song {
    String song;
    int plays;

    public Song(String song, int plays) {
        this.song = song;
        this.plays = plays;
    }
}

class Solution {

    public static List<String> kMostPlayedSongs(List<Song> songs, int k) {
        List<String> result = new ArrayList<>();
        PriorityQueue<Song> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.plays, b.plays));

        for (Song song : songs) {
            minHeap.offer(song);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            if (minHeap.size() > 0)
                result.add(minHeap.poll().song);
        }

        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {

        Song singleBrackets = new Song("all the single brackets", 132);
        Song britney = new Song("oops i did it again", 274);
        Song codingIn = new Song("Coding in the deep", 146);
        Song booleanRhap = new Song("Boolean Rhapsody", 193);
        Song beatles = new Song("here comes the bug", 291);
        Song allAboutBass = new Song("All about the base case", 291);

        List<Song> songs = Arrays.asList(new Song[] {
                singleBrackets, britney, codingIn, booleanRhap, beatles, allAboutBass
        });

        System.out.println(kMostPlayedSongs(songs, 3));

    }

}