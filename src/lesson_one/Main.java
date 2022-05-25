package lesson_one;

public class Main {
    public static void main(String[] args) {
        //check
        System.out.println(exponentiation(2,6));
        System.out.println(exponentiation(0,200));
        System.out.println(exponentiation(50,0));
    }

    public static long exponentiation(long number, int stage) {
        if (stage == 0) return 1;
        if (number == 0) return 0;
        long sum = number;
        for (int i = 1; i < stage; i++) {
            sum = sum*number;
        }
        return sum;
    }
}
