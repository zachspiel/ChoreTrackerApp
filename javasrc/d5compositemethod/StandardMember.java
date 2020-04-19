package d5compositemethod;

import java.util.ArrayList;
import java.util.List;

public class StandardMember implements Member
{
    private String name;

    private List<Event> myEvents = new ArrayList<Event>();

    public StandardMember(String inName)
    {
        name = inName;
    }

    public void addEvent(Event newEvent)
    {
        myEvents.add(newEvent);
    }

    public void removeEvent(Event removeEvent)
    {
        myEvents.remove(removeEvent);
    }

    @Override
    public Event getEvent(Event event)
    {
        if(myEvents.contains(event))
        {
            return myEvents.get(myEvents.indexOf(event));
        }
        return null;
    }
}
