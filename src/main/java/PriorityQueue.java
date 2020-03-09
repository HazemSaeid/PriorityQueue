import java.util.Comparator;

public interface PriorityQueue {
     void enqueue(Comparable item );
     Comparable dequeue();
     void sortAscending();
     void sortDescending();
     void sort(Comparator<Comparable>comparator );
}
