//my implementation of a SortedLinkedSet using the professor's Set and Collection files


public class SortedLinkedSet<T extends Comparable<T>> implements Set<T>, Collection<T> {
    /**
     * Private Data
     */
    protected SortedLinkedSetNode<T> firstNode;

    /**
     * Constructors
     */
    public SortedLinkedSet(SortedLinkedSetNode<T> n) { firstNode = n ; }
    public SortedLinkedSet() { firstNode = null; }

    /**
     * Copy Constructor
     */
    public SortedLinkedSet(SortedLinkedSet<T> copy) {
	    
    	//this may be wrong, not necessarily copying the value
    	while (firstNode.getNext() != null && copy.firstNode.getNext() != null) {
	    	 firstNode = copy.firstNode;
	    	 firstNode = firstNode.getNext();
	    	 copy.firstNode = copy.firstNode.getNext();
	    }
    	

    }

    /**
     * Getters and Setters
     */
    public SortedLinkedSetNode<T> getFirstNode() {
	return firstNode;
    }
	
    /**
     * return the size of the list
     */
    public int size() {
	if (firstNode == null) return 0;
	else return firstNode.size();
    }

    /**
     * Find the minimum element of the list
     */    
    public T min() throws SortedLinkedSetException {
	if (firstNode == null) throw new SortedLinkedSetException("Empty");
	else return firstNode.min();
    }

    /**
     * Find the maximum element of the list
     */    
    public T max() throws SortedLinkedSetException {
	if (firstNode == null) throw new SortedLinkedSetException("Empty");
	else return firstNode.max();
    }

    /**
     * Determine whether the list is empty
     */    
    public boolean isEmpty() {
	return ( firstNode == null ? true : false );
    }

    /**
     * Determine whether the list contains element el
     */    
    public boolean contains(T el) {
	if (firstNode == null) { return false; }
	else return firstNode.contains(el);
    }
    
  

    
    public boolean add(T el) {
		if (firstNode == null || el.compareTo(firstNode.getValue()) > 0 ) {
		    //the new element will become the new first node
		    firstNode = new SortedLinkedSetNode<T>(el, firstNode);
		    return true;
		} else { 
		    return firstNode.add(el);
		}
	    }
    
    
    
    /**
     * Remove element el to the list (maintaining sort order)
     */    
    public boolean remove(T el) { 
	if (firstNode == null) {
	    return false;
	} else if (firstNode.getValue().equals(el)) { 
	    firstNode = firstNode.getNext();
	    return true;
	} else {
	    return firstNode.remove(el); 
	}
    }

    /**
     * Joins two lists together and takes out the repeats by adding everything in the first list and then, while
     * iterating over the second list, checks for duplicates.
     */    
    public SortedLinkedSet<T> unionWith(final SortedLinkedSet<T> other){
        final SortedLinkedSet<T> union = new SortedLinkedSet<T>();

        SortedLinkedSetNode<T> currentNode = firstNode;
        while (currentNode != null){
            if (!union.contains(currentNode.value)){
                union.add(currentNode.value);}
            currentNode = currentNode.next;
        }
        currentNode = other.firstNode;
        while (currentNode != null){
            if (!union.contains(currentNode.value)){
                union.add(currentNode.value);}
            currentNode = currentNode.next;
        }
        return union;
    }
    

    /**
     * Checks to see if a node in list 1 is in list 2, and if so, adds it to the intersection list. 
     */    
    public SortedLinkedSet<T> intersectWith(SortedLinkedSet<T> other) {
    final SortedLinkedSet<T> intersect = new SortedLinkedSet<T>();

    SortedLinkedSetNode<T> currentNode = firstNode;
    while (currentNode != null) {
        if (other.contains(currentNode.value)) {
            intersect.add(currentNode.value);
        }
        currentNode = currentNode.next;
    }
    currentNode = other.firstNode;
    while (currentNode != null) {
        if (this.contains(currentNode.value)) {
            intersect.add(currentNode.value);
        }
        currentNode = currentNode.next;
    }
    return intersect;
    
    }
    

    public SortedLinkedSet<T> setDifferenceWith(final SortedLinkedSet<T> other) {
    	SortedLinkedSetNode<T> currentNode = firstNode;
    	
    	SortedLinkedSet<T> setDiff = new SortedLinkedSet<T>();
    	SortedLinkedSet<T> intersection = new SortedLinkedSet<T>();
    	intersection = this.intersectWith(other);
    	
    	while (currentNode != null) {
            if (!(intersection.contains(currentNode.value))) {
                setDiff.add(currentNode.value);
            }
            currentNode = currentNode.next;
        }
        
    	return setDiff;
    }


    @Override 
    public String toString() {
	if(firstNode == null) {
	    return "[]";
	} else {
	    return "[" + firstNode.toString() + "]";
	}
    }

    // Output operations
    public void PrettyPrint() {
	System.out.printf(this.toString() + "\n");
    }
	
    public int compareTo(T o) {
    	return 0;
    }
    
    
 //adds a new element at the beginning of the list. note that these are ONLY in this file so that I can later use them in my StackList and QueueList classes 
public void addFirst(T element) {
		if (firstNode == null) {
			
			
			SortedLinkedSetNode<T> newNode = new SortedLinkedSetNode<T>(element);
			SortedLinkedSet<T> myList = new SortedLinkedSet<T>(newNode);
	//		myList.firstNode.value = element;
			firstNode = newNode;
		//	return myList;
		}
		else{
			
			
			SortedLinkedSetNode<T> n = new SortedLinkedSetNode<T>(element);
            n.next = firstNode;
            firstNode = n;
			
		}
	}

// appends a new element to the end of the list
public void addLast(T element) {
	if(firstNode == null) {
		
		SortedLinkedSetNode<T> temp = new SortedLinkedSetNode<T>(element);
		firstNode = temp;
	
	}
	else {
	
	SortedLinkedSetNode<T> currentNode = firstNode;
	
	while (currentNode.next != null) {
		currentNode = currentNode.next;
	}
	
	currentNode.next = new SortedLinkedSetNode<T>(element);
	}
}

//removes the first element in the list
public T removeFront() {
	
	if(firstNode == null){
		T empty = null;
		
		return empty;
	}
	else {
		SortedLinkedSetNode<T> currentNode = firstNode;
		
		T val = firstNode.value;
		
		firstNode.next = null;
		firstNode = null;
		firstNode = currentNode.next;
		
		return val;
	}
}

//removes the last element in the list 
public T removeBack() {
	
	if(firstNode == null){
		T empty = null;
		return empty;
	}
	else {	
	SortedLinkedSetNode<T> currentNode = firstNode;
	
	if( currentNode.size() == 1 ){
		T val = firstNode.value;
		firstNode = null;
		return val;
		
	}else{
	
			while (currentNode.next.next != null) {
		
				currentNode = currentNode.next;
			}
		
		T val = currentNode.next.value;
		currentNode.next = currentNode;
		currentNode.next = null;	
		return val;
		}
	}
}
}

	
