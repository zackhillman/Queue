
public interface QueueADT<T> {
	
	public void enqueue(T element); //Adds element to the queue
	public T dequeue(); //Removes element from the queue
	public T peekFront(); //Returns the first element in the queue 
	public int size(); //Returns the number of elements in the queue
	public boolean isEmpty(); //Checks if the queue is empty
	public String toString(); //Gets the string representation of the queue
}
