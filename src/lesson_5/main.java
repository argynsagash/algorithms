package lesson_5;

public class main {
    public static void main(String[] args) {
        System.out.println(exponentiation(2,3));
    }

    public static long exponentiation(long number, int stage) {
        if (stage == 0) return 1;
        if (number == 0) return 0;
        return number*exponentiation(number,--stage);
    }
}
