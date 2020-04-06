package d5compositemethod;

public interface Member
{
    public void addEvent(Event newEvent);
    public void removeEvent(Event removeEvent);
    public Event getEvent(Event event);
}
