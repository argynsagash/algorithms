package lesson_3;

public class Queue {
    private int maxSize; // СЂР°Р·РјРµСЂ
    private int[] queue; // РјРµСЃС‚Рѕ С…СЂР°РЅРµРЅРёСЏ
    private int head;    // РѕС‚СЃСЋРґР° СѓС…РѕРґСЏС‚
    private int tail;    // СЃСЋРґР° РїСЂРёС…РѕРґСЏС‚
    private int items;   // С‚РµРєСѓС‰РµРµ РєРѕР»РёС‡РµСЃС‚РІРѕ

    public Queue(int s) {
        maxSize = s;
        queue = new int[maxSize];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() { return (items == 0); }
    public boolean isFull() { return (items == maxSize); }
    public int size() { return items; }

    public void insert(int i) {
        if (isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            if (tail >= head) {
                System.arraycopy(queue, 0, tmpArr, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
                System.arraycopy(queue, head, tmpArr,
                        maxSize - (queue.length - head), queue.length - head);
                head = maxSize - head - 1;
            }
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }
        queue[++tail] = i;
        ++items;
    }

    public int remove() {
        int temp =  queue[head++];
        head %= maxSize;
        items--;
        return temp;
    }

    public int peek(){
        return queue[head];
    }
}
