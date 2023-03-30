package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int Arr[] = {-3, 3, 5, -3, -7, 9, -2, 10, -5, -2};

        int cur_sum = Arr[0];
        int max = Arr[0];

        for (int i = 1 ; i < Arr.length ; i++) {
            if (cur_sum + Arr[i] < 0) {
                cur_sum = 0;
            } else {
                cur_sum += Arr[i];
            }

            max = Math.max(cur_sum, max);
        }

        System.out.println(max);

    }

}