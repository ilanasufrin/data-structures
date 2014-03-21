//this is the professor's file

public interface Stack<E> extends Collection<E> {
 // Basic operations
 int size();
 void push(E element);
 E pop() throws InvalidOperationException;    
 boolean isEmpty();

 // Output operations
 String toString();
 void PrettyPrint();
}
