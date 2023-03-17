package Algorithms.GCD;

// 유클리드 호제법 이라고도 부름
public class 최대공약수_구하기 {

    public static void main(String[] args) {

        int a = 15;
        int b = 10;
        System.out.println(gcd(a,b));

    }

    static int gcd(int a, int b) {
        if ( b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
