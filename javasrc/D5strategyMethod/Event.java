package D5strategyMethod;


public class Event 
{
	private static Object delete;
	String Name;
	int startTime;
	static int endTime; 
	int dateAssigned; 
	boolean completionStatus;
	String description;
	String difficulty;
	String assignedUser;
	int priority; 
	
	Event(String assignName, String descript, int deadLine, int date)
	{
		Name = "Anonymous";
		startTime = 0;
		endTime = deadLine;
		dateAssigned = date;
		completionStatus = false; 
		priority = 0;
		
	}
	
	private void add(String assignName, String descript, int deadLine, int date) 
	{
		Event newEvent = new Event(assignName, descript, deadLine, date);
	}
	
	private void edit(Event upEvent, String assignName, String descript, int deadLine, int date) 
	{
		upEvent = new Event (assignName, descript, deadLine, date);
	}
	private void delete() 
	{
		Event.delete = null;
	}
	private static void assign(String name) 
	{
		Event.assign(name);
	}
	
	
}
