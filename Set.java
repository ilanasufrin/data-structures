//this is the professor's file



public interface Set<T> extends Collection<T> {
    // Basic operations
    int size();
    boolean isEmpty();
    boolean contains(T element);
    boolean add(T element);
    boolean remove(T element);
 
    // Output operations
    void PrettyPrint();
    String toString();
}
