
public class QueueLinkedList<T> implements QueueADT<T>{

	private ListNode<T> head; //This is the reference to the head of the linked list
	
	/**
	 * This is the default constructor, it sets head to null
	 */
	public QueueLinkedList(){
		head = null;
	}
	/**
	 * This method adds an element to the queue. 
	 * It increments the size after adding
	 * @param- the element to add the to queue
	 */
	public void enqueue(T element) {
		if(head != null){
			ListNode<T> node = head;
			while(node.getNext()!=null)
				node = node.getNext();
			
			node.setNext(new ListNode<T>(element,null));
		}else{
			head = new ListNode<T>(element,head);
		}
	}
	/**
	 * This method removes the first element from the queue
	 * @return- the first element's value
	 */
	public T dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("Queue is Empty");
		T element = head.getValue();
		head = head.getNext();
		return element;
	}
	/**
	 * This method gets the first element on the queue
	 * @return- the first element's value
	 */
	public T peekFront() {
		if(isEmpty())
			throw new IllegalArgumentException("Queue is Empty");
		return head.getValue();
	}
	/**
	 * This method gets the number of elements in the queue
	 * @return- the logical size of the queue
	 */
	public int size() {
		int count = 0;
		ListNode<T> node = head;
		while(node!=null){
			node = node.getNext();
			count++;
		}
		return count;
	}
	/**
	 * This method checks if the queue is empty
	 * @return	true- if the queue is empty
	 * 			false- if the queue is non empty 
	 */
	public boolean isEmpty() {
		return head==null;
	}
	/**
	 * This method gets the string representation of the queue
	 * @return- Each of the elements on the queue
	 */
	public String toString(){
		String output = "";
		while(!isEmpty()){
			output+= dequeue()+"\n";
		}
		return output;
	}

}
