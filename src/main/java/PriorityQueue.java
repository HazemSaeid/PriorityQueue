import java.util.Comparator;

public interface PriorityQueue {
     void enqueue(Comparable item );
     Comparable dequeue();
     boolean sortAscending();
     boolean sortDescending();
     void sort(boolean desc);
}
