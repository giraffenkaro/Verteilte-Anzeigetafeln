package database.objects;

import java.util.ArrayList;

/**
 * Created by Dominik on 18.08.2017.
 */
public class Group {

    private int id;
    private String name;
    private User moderator;
    private ArrayList<User> members;

    /**
     * Create group (with given ID -> Update group in database)
     * @param id
     * @param name
     * @param moderator
     * @param members
     */
    public Group(int id, String name, User moderator, ArrayList<User> members){
        setId(id);
        setName(name);
        setModerator(moderator);
        setMembers(members);
    }

    /**
     * Create group without members (with ID -1 -> Save as new group in database)
     * @param name
     * @param moderator
     */
    public Group(String name, User moderator) {
        this(-1, name, moderator, null);
    }

    /**
     * Create group (with ID -1 -> Save as new group in database)
     * @param name
     * @param moderator
     * @param members
     */
    public Group(String name, User moderator, ArrayList<User> members){
        this(-1, name, moderator, members);
    }

    /**
     * Get group id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set group id
     * @param id Positive or -1
     */
    private void setId(int id) {
        this.id = id;
    }

    /**
     * Get group name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set group name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get group moderator
     * @return moderator
     */
    public User getModerator() {
        return moderator;
    }

    /**
     * Set group moderator
     * @param moderator
     */
    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    /**
     * Get group members
     * @return members
     */
    public ArrayList<User> getMembers() {
        return members;
    }

    /**
     * Set group members
     * @param members
     */
    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    /**
     * Add a member to the group
     * @param member
     */
    public void addMember(User member) {
        this.members.add(member);
    }
}
