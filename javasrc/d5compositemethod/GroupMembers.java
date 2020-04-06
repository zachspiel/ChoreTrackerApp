package d5compositemethod;

import java.util.ArrayList;
import java.util.List;

public class GroupMembers implements Member
{
    private List<Event> groupEvents = new ArrayList<Event>();

    private List<Member> groupMembers = new ArrayList<Member>();

    public void addEvent(Event newEvent)
    {
        groupEvents.add(newEvent);
    }

    public void removeEvent(Event removeEvent)
    {
        groupEvents.remove(removeEvent);
    }

    @Override
    public Event getEvent(Event event)
    {
        if(groupEvents.contains(event))
        {
            return groupEvents.get(groupEvents.indexOf(event));
        }
        return null;
    }

    public void addMember(Member newMember)
    {
        groupMembers.add(newMember);
    }

    public void removeMember(Member removeMember)
    {
        groupMembers.remove(removeMember);
    }

    public Member getMember(Member member)
    {
        if(groupMembers.contains(member))
        {
            return groupMembers.get(groupMembers.indexOf(member));
        }
        return null;
    }
}
