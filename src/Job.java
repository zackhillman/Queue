
public class Job {

	private String name;//The job's name
	private String desc;//The job's description
	
	/**
	 * This is the constructor method. It sets the name and description
	 * of the job
	 * @param n- the desired name
	 * @param d- the desired description
	 */
	public Job(String n, String d){
		name = n;
		desc = d;
	}

	/**
	 * This method gets the string representation of the job
	 * @return- the name and description on one line
	 */
	public String toString(){
		return name + "- " + desc;
	}
	
}
