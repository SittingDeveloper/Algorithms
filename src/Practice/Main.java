package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int temp = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.stream().mapToInt(e -> e).sum();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        temp = arr.stream().mapToInt(e -> e).sum();


    }
}