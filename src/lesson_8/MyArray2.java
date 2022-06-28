package lesson_8;

public class MyArray2 {
    private int[] arr;
    private int capacity;

    //new int[5];
    public MyArray2(int size) {
        this.capacity = 0;
        this.arr = new int[size];
    }

    // = {1,2,3,4,5};
    public MyArray2(int[] init) {
        this.capacity = init.length;
        this.arr = init;
    }

    void display() {
        for (int i = 0; i < this.capacity; ++i) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public int get(int idx) {
        return arr[idx];
    }

    public void set(int value, int idx) {
        arr[idx] = value;
    }

    boolean delete(int value) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                --capacity;
                return true;
            }
        }
        return false;
    }

    boolean deleteAll(int value) {
        boolean success = false;
        for (int i = 0; i < capacity; i++) {
            if (arr[i] == value) {
                delete(i--);
                success = true;
            }
        }
        return success;
    }

    void deleteAll() {
        capacity = 0;
    }

    void insert(int index, int value) {
        int[] temp = arr;
        if (capacity >= arr.length) {
            arr = new int[capacity * 2];
            System.arraycopy(temp, 0, arr, 0, index);
        }
        System.arraycopy(temp, index, arr, index + 1, capacity - index);
        arr[index] = value;
        capacity++;
    }

    void append(int value) {
        if (this.capacity == this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        this.arr[this.capacity++] = value;
    }

    public boolean isInArray(int value) { // O(n)
        for (int i = 0; i < this.capacity; i++)
            if (this.arr[i] == value)
                return true;
        return false;
    }

    //O(log(N))
    public boolean hasValue(int value) {
        int low = 0;
        int high = this.capacity - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public void sortBubble() {
        for (int iter = 0; iter < capacity; iter++)
            for (int idx = 0; idx < capacity - 1; idx++)
                if (this.arr[idx] > this.arr[idx + 1])
                    swap(idx, idx + 1);
    }

    public void sortSelect() {
        for (int idx = 0; idx < capacity; idx++) {
            int curr = idx;
            for (int srch = idx + 1; srch < capacity; srch++)
                if (this.arr[srch] < this.arr[curr])
                    curr = srch;
            if (curr != idx)
                swap(idx, curr);
        }
    }

    public void sortInsert() {
        for (int curr = 1; curr < capacity; curr++) {
            int temp = this.arr[curr];
            int move = curr;
            while (move > 0 && this.arr[move - 1] >= temp) {
                this.arr[move] = this.arr[move - 1];
                move--;
            }
            this.arr[move] = temp;
        }
    }

    int getMax() {
        if (capacity == 0) throw new RuntimeException("Empty array");
        if (capacity == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < capacity; i++) {
            if (r < arr[i])
                r = arr[i];
        }
        return r;
    }

    int getMin() {
        if (capacity == 0) throw new RuntimeException("Empty array");
        if (capacity == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < capacity; i++) {
            if (r > arr[i])
                r = arr[i];
        }
        return r;
    }

    int pigeon() {
        int c = 0;
        int min = getMin();
        int max = getMax();
        int[] freq = new int[max - min + 1];
        for (int i = 0; i < capacity; i++) {
            c++;
            freq[arr[i] - min]++;
        }

        int arrIndex = 0;
        for (int i = 0; i < freq.length; i++)
            for (int elems = freq[i]; elems > 0; elems--) {
                c++;
                arr[arrIndex++] = i + min;
            }
        return c;
    }

    public int sortDoubleBubble() {
        int c = 0;
        boolean flag = false;
        for (int i = 0; i < capacity; i++) {
//            for (int j = (j % 2 == 0) ? 0 : 1; j < capacity - 1; j += 2) {
            for (int j = 0; j < capacity - 1 - i; j++) {
                c++;
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return c;
    }
}