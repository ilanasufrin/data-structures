//this is the professor's file

public interface Queue<E> extends Collection<E> {
 // Basic operations
 int size();
 void enqueue(E element);
 E dequeue() throws InvalidOperationException;    
 boolean isEmpty();

 // Output operations
 String toString();
 void PrettyPrint();
 
 
boolean contains(Node<E> element);
}
