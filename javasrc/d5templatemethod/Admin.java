
package d5templatemethod;

/**
 *Class to define a group admin. 
 * Inherits from user following the template design pattern.
 * @author Joseph Vargovich
 */
public class Admin extends User{
    //The group the admin controls.
    Group currentGroup;
    //Constructor for the admin, default values used.
    Admin()
       {
        currentGroup = new Group("DankMemes");
        currentGroup.appendAdmin(this);
       }
   //Adds a member to the group
    private void addMember(User member)
        {
         currentGroup.addMember(member);
        }
    
    //Removes a member from the group.
    private void removeMember(User member)
        {
         currentGroup.removeMember(member);
        }
    
    //Adds a chore to the group's calendar
    private void addChore(Event newChore)
        {
         currentGroup.addMemberEvent(newChore);
        }
    
    //Assigns a chore to a member of the group overseen by the admin.
    private void assignChore(User member, Event chore)
        {
         //Add the chore to the specified user's list.
         chore.assign(member);
        } 
    
}
