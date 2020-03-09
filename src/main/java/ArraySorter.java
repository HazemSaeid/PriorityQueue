import java.lang.reflect.Array;
import java.util.Comparator;

public class ArraySorter implements PriorityQueue {
    Comparable[] inputArr;
    int size, head, tail, numberOfElements;

    public ArraySorter(int queueSize){
        this.size = queueSize;
        this.inputArr = new Comparable[queueSize];
        this.numberOfElements = 0;
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue(Comparable item) {
        if(numberOfElements >= size) return; //OverFlow
        inputArr[tail] = item;
        numberOfElements++;
        tail++;
    }

    public Comparable dequeue() {
        if(numberOfElements <= 0) return null; //underflow
        Comparable firstOut = inputArr[this.head];
        inputArr[this.head] = null;
        numberOfElements--;
        this.head++;
        return firstOut;
    }

    public void sortAscending() {

    }

    public void sortDescending() {

    }

    public void sort(Comparator<Comparable> comparator) {

    }

    public static void main(String[] args) {
        ArraySorter as = new ArraySorter(10);
        as.enqueue(10);
        as.enqueue(11);
        as.enqueue(19);
        as.enqueue(1);
        as.dequeue();
        as.dequeue();
        as.dequeue();
    }
}
