package lesson_two;

class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public int getElement(int index) {
        return this.arr[index];
    }

    //task 3
    void insert(int idx, int value) {
        size++;
        int[] temp = new int[size];
        System.arraycopy(this.arr, 0, temp, 0, this.size - 1);
        System.arraycopy(this.arr, idx, temp, idx + 1, this.size - 1 - idx);
        this.arr = new int[this.size];
        temp[idx] = value;
        System.arraycopy(temp, 0, this.arr, 0, temp.length - 1);
    }

    public void setElement(int index, int elem) {
        this.arr[index] = elem;
    }

    public void delete(int value) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                break;
            }
        }
        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    //task 1
    public boolean deleteAll(int value) {
        boolean b = false;
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                b = true;
                break;
            }
        }
        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
        return b;
    }

    //task 2
    public boolean deleteAll() {
        this.arr = new int[0];
        return true;
    }


    public int getSize() {
        return this.size;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.arr[i]);
            System.out.print(" ");
        }

    }

    public boolean find(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    //task 5  O(n в квадрате)
    public void sortBubble() {
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (this.arr[in] > this.arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }
    // O(n в квадрате)
    public void sortSelect() {
        int out, in, mark;
        for (out = 0; out < this.size; out++) {
            mark = out;
            for (in = out + 1; in < this.size; in++) {
                if (this.arr[in] < this.arr[mark]) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }
}