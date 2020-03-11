public class ArraySorter implements PriorityQueue {
    Comparable[] inputArr;
    int size;
    int numberOfElements;
    int tail;
    int head;
    boolean desc;

    public ArraySorter(int queueSize) {
        this.size = queueSize;
        this.inputArr = new Comparable[queueSize];
        this.numberOfElements = 0;
        this.head = 0;
        this.tail = 0;
    }

    public static void main(String[] args) {
        ArraySorter as = new ArraySorter(10);

        as.enqueue(11);
        as.enqueue(10);
        as.enqueue(19);
        as.enqueue(1);

//        as.dequeue();

        as.enqueue(54);

        as.sort(true);

        for (int i = 0; i < as.numberOfElements; i++) {
            System.out.println(as.inputArr[i]);
        }
    }

    public void enqueue(Comparable item) {
        //OverFlow
        if (numberOfElements >= size) {
            return;
        }
        inputArr[tail] = item;
        numberOfElements++;
        tail++;
    }

    public Comparable dequeue() {
        //Underflow
        if (numberOfElements <= 0) {
            return null;
        }
        Comparable firstOut = inputArr[this.head];
        inputArr[this.head] = null;
        numberOfElements--;
        this.head++;

        return firstOut;
    }

    public boolean sortAscending() {
        return this.desc == false;
    }

    public boolean sortDescending() {
        return this.desc == true;
    }

    public void sort(boolean desc) {
        this.desc = desc;
        int n = numberOfElements;

        for (int i = n / 2 - 1; i >= 0; i--) {
            this.heapify(this.inputArr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            Comparable temp = this.inputArr[0];
            this.inputArr[0] = this.inputArr[i];
            this.inputArr[i] = temp;

            this.heapify(this.inputArr, i, 0);
        }
    }

    void heapify(Comparable[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (this.sortAscending()) {
            if (l < n && arr[l].compareTo(arr[largest]) > 0) {
                largest = l;
            }

            if (r < n && arr[r].compareTo(arr[largest]) > 0) {
                largest = r;
            }
        }

        if (this.sortDescending()) {
            if (l < n && arr[l].compareTo(arr[largest]) < 0) {
                largest = l;
            }

            if (r < n && arr[r].compareTo(arr[largest]) < 0) {
                largest = r;
            }
        }

        if (largest != i) {
            Comparable swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            this.heapify(arr, n, largest);
        }
    }
}
