import javax.swing.*;

import BreezySwing.*;

public class sizeDialog<Job> extends GBDialog{

	private IntegerField sizeF; //Where the user input's the desired size
	private JButton customS; //Creates a queue with given size
	private JButton defaultS; //Creates a queue with default size
	
	private QueueADT<Job> queue;
	
	/**
	 * This is the constructor for the sizeDialog box
	 * @param frame- the super class
	 */
	public sizeDialog(JFrame frame) {
		super(frame);
		
		setSize(250,150);
		setTitle("Set Size");
		
		setDlgCloseIndicator("Cancel");
		
		sizeF = addIntegerField(0,1,1,2,1);
		customS = addButton("Custom Size",2,1,1,1);
		defaultS = addButton("Default Size",2,2,1,1);
		
	}

	/**
	 * This method is called when a but1ton is clicked
	 */
	public void buttonClicked(JButton buttonObj) {
		
		if (buttonObj == defaultS){
			queue = new QueueArray<Job>();
		}else{
			if(sizeF.getNumber()<1)
				throw new IllegalArgumentException("Invalid Queue size");
			queue = new QueueArray<Job>(sizeF.getNumber());
		}
		dispose();
	}
	
	public QueueADT<Job> getQueue(){
		return queue;
	}
	
}
