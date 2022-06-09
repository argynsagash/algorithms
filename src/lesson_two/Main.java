package lesson_two;

public class Main {
    public static void main(String[] args) {
        MyArr arr = new MyArr(3);
        arr.display();
        System.out.println("----------");
        arr.insert(2,1);
        arr.insert(0,1);
        arr.insert(1,2);
        arr.display();
    }
}
