package D5strategyMethod;

import java.util.ArrayList;

public class MultipartedEvent extends Event
{
	
	ArrayList <Event> eventList; 
	boolean completed; 
	
	MultipartedEvent()
	{
		completed = false; 
		
		eventList = new ArrayList<Event>();
	}

	private void checkItem()
	{
		
	}
	private void uncheckedItem() 
	{
		
	}
}
