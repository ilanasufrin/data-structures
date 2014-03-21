//this interface was written by the professor

public interface Collection<T> extends Comparable<T> {
    // Basic operations
    int size();
    boolean isEmpty();
    boolean contains(T element);
    boolean add(T element);
    boolean remove(T element);
    @Override
    public int compareTo(T o);

    // Output operations
    void PrettyPrint();
}
