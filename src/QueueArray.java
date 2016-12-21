
public class QueueArray<T> implements QueueADT<T> {

	private T[] array; //Holds the elements in the queue
	private int start, top, size; //Tracks the start, top, and size of the queue
	
	/**
	 * This is the default constructor, is creates a T array with size 25
	 * start is set to 0, top is set to -1, size is set to 0
	 */
	public QueueArray(){
		array = (T[]) new Object[25];
		start = 0;
		top = -1;
		size = 0;
	}
	/**
	 * This is the overloaded constructor, is creates a T array with custom size
	 * start is set to 0, top is set to -1, size is set to 0
	 */
	public QueueArray(int s){
		array = (T[]) new Object[s];
		start = 0;
		top = -1;
		size = 0;
	}
	
	/**
	 * This method adds an element to the queue. It effectively creates a circular
	 * array. Finally, it increments the size after adding
	 * @param- the element to add the to queue
	 */
	public void enqueue(T element) {
		
		if(size == array.length)
			doubleArraySize();
			
		if(top == array.length-1)
			top = -1;
				
		array[++top] = element;
		size++;
	}
	/**
	 * This method doubles the size of the array.
	 */
	private void doubleArraySize() {
		T[] newArray = (T[]) new Object[array.length*2];
		int index = 0;
		while(start!=top){
			newArray[index] = array[start];
			index++;
			if(start == array.length)
				start = 0;
			else{
				start++;
			}
		}
		array = newArray;
	}
	
	/**
	 * This method removes the first element from the queue
	 * @return- the first element's value
	 */
	public T dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("Queue is Empty");
		size--;
		T element = array[start++];
		if(start == array.length)
			start = 0;
		return element;
	}

	/**
	 * This method gets the first element on the queue
	 * @return- the first element's value
	 */
	public T peekFront() {
		if(isEmpty())
			throw new IllegalArgumentException("Queue is Empty");
		return array[start];
	}

	/**
	 * This method gets the number of elements in the queue
	 * @return- the logical size of the queue
	 */
	public int size() {
		return size;
			
	}
	/**
	 * This method checks if the queue is empty
	 * @return	true- if the queue is empty
	 * 			false- if the queue is non empty 
	 */
	public boolean isEmpty() {
		return size == 0;
	}	
	
	/**
	 * This method gets the string representation of the queue
	 * @return- Each of the elements on the queue
	 */
	public String toString(){
		String output = "";
		for(T element:array){
			output+=element.toString()+"\n";
		}
		return output;
	}
}
