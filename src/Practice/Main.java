package Practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int a = 15;
        int b = 10;
        System.out.println(gcd(a, b));

    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}