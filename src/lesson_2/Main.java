package lesson_2;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(3);
        arr.display();
        System.out.println("----------");
        arr.insert(2,1);
        arr.insert(0,1);
        arr.insert(1,2);
        arr.display();
    }
}
