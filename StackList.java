//my implementation of a generic StackList using the professor's Stack class

public class StackList<E> implements Stack<E> {

	 static class Node<E> implements Comparable<Node<E>>
	 {
		private E e;
		public Node(E e) { this.e = e; }
		public E get() { return e; }
		

		public String toString() { return "\"" + e +"\"";}
		
		@Override
		public int compareTo(Node o) //Not used 
		{
			return 0;
		} 
	 }
	
 public StackList() { }
 
 
SortedLinkedSet<Node<E>> myList = new SortedLinkedSet<Node<E>>();

 // Basic operations



 public int size() {
	return myList.size();
		
 }
 

 public void push(E element) { 
	 Node<E> elem = new Node<E>(element);
	 myList.addLast(elem);
	 
 }
 

 public E pop() throws InvalidOperationException {
	 
	if(!myList.isEmpty()) {
		return myList.removeBack().get();
	}
	else {
		throw new InvalidOperationException("There are no elements in the stack");
	}
	
 }
 

 public boolean isEmpty() {
	 boolean empty = myList.isEmpty();
		return empty; 
}

 // Output operations
 public String toString() {
	 return myList.toString();
 }
 
 

 public void PrettyPrint() { 
	 System.out.printf(this.toString() + "\n");
 }
 
 @Override
 public boolean contains(E element) {
 	return false;
 }

 @Override
 public boolean add(E element) {
 	Node<E> elem = new Node<E>(element);
 	myList.addLast(elem);
 	return false;
 }

 @Override
 public boolean remove(E element) {
 	
 	myList.removeFront();
 	return false;
 }

 @Override
 public int compareTo(E o) { //Not used!!
 	return 0;
 }
  
 
}

