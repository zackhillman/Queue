import javax.swing.*;
import BreezySwing.*;

public class QueueGUI extends GBFrame{

	private JLabel nameL; //Tells the user where to enter the job's name
	private JLabel descL; //Tells the user where to enter the job's description
	
	private JButton addJob; //Adds a job to the queue
	private JButton removeJob; //Removes a job from the queue
	
	private JButton selectList; //Selects LinkedList Queue
	private JButton selectArray; //Selects Array Queue
	
	private JTextField nameF; //Where the user enters the name of the job
	private JTextField descF; //Where the user enters the job's description
	
	private JList<String> outputList; //Displays all of the jobs in the queue
	
	private QueueADT<Job> queue; //This is the queue which tracks the jobs
	
	/**
	 * This is the constructor method. The GUI objects are instantiated.
	 * Queue is not instantiated here.
	 */
	public QueueGUI(){
		
		selectList = addButton("LinkedList",1,1,1,1);
		selectArray = addButton("Array",1,2,1,1);
		
		nameL = addLabel("Name of Job:",2,1,2,1);
		nameF = addTextField("",3,1,2,1);
		descL = addLabel("Description of Job:",4,1,2,1);
		descF = addTextField("",5,1,2,1);
		
		addJob = addButton("Add Job",6,1,1,1);
		removeJob = addButton("Remove Job",6,2,1,1);
		
		outputList = addList(7,1,2,4);
	
		addJob.setEnabled(false);
		removeJob.setEnabled(false);
		nameF.setEditable(false);
		descF.setEditable(false);

	}
	
	/**
	 * This method is called when a button is clicked
	 */
	public void buttonClicked(JButton buttonObj) {
		try{
			if (buttonObj == selectList) {
				queue = new QueueLinkedList<Job>();
				addJob.setEnabled(true);
				removeJob.setEnabled(true);
				nameF.setEditable(true);
				descF.setEditable(true);
				selectArray.setEnabled(false);
				selectList.setEnabled(false);
			}else if(buttonObj == selectArray){
				sizeDialog setSize = new sizeDialog(this);
				setSize.setVisible(true);
				queue = setSize.getQueue();
				addJob.setEnabled(true);
				removeJob.setEnabled(true);
				nameF.setEditable(true);
				descF.setEditable(true);
				selectArray.setEnabled(false);
				selectList.setEnabled(false);
			}else if (buttonObj == addJob) {
				Job newJob = new Job(nameF.getText(),descF.getText());
				queue.enqueue(newJob);
				DefaultListModel<String> model = (DefaultListModel<String>) outputList.getModel();
				model.addElement(newJob.toString());
				
			}else if(buttonObj == removeJob){
				queue.dequeue();
				DefaultListModel<String> model = (DefaultListModel<String>) outputList.getModel();
				model.remove(0);
			}
				
		}catch(Exception e){
			messageBox(e,400,200);
		}
	}
	

	/**
	 * This is the main method it creates the actual GUI
	 * @param args
	 */
	public static void main(String[] args) {
		QueueGUI theGUI = new QueueGUI();
		theGUI.setSize(500, 450);
		theGUI.setVisible(true);
		theGUI.setTitle("Stack Program");
	}
}
