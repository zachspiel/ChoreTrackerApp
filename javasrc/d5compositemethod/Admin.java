package d5compositemethod;

import java.util.ArrayList;
import java.util.List;

public class Admin implements Member
{
    private String name;

    private List<Event> myEvents = new ArrayList<Event>();

    private GroupMembers myGroup;

    public Admin(String inName, GroupMembers group)
    {
        name = inName;
        myGroup = group;
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

    public void assignEvent(Event eventToAssign, Member member)
    {
        if(myGroup.getMember(member) != null)
        {
            myGroup.getMember(member).addEvent(eventToAssign);
        }
    }

    public void deAssignEvent(Event eventDeAssign, Member member)
    {
        if(myGroup.getMember(member) != null && myGroup.getMember(member).getEvent(eventDeAssign) != null)
        {
            myGroup.getMember(member).removeEvent(eventDeAssign);
        }
    }
}