package Algorithms.GCD;

public class 최소공배수_구하기 {

    public static void main(String[] args) {

        // 최소공배수 : a * b / 최대공약수(a,b)
        int a = 15;
        int b = 10;
        System.out.println( a * b / gcd(a,b) );

    }

    static int gcd(int a, int b) {
        if ( b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
