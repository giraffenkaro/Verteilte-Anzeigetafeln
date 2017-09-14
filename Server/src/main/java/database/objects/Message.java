package database.objects;

/**
 * Created by Dominik on 18.08.2017.
 */
public class Message {

    private int id;
    private String message;
    private User author;
    private Group group;

    /**
     * Create message (with given ID -> Update message in database)
     * @param id
     * @param message
     * @param group
     * @param author
     */
    public Message(int id, String message, Group group, User author) {
        setID(id);
        setMessage(message);
        setAuthor(author);
        setGroup(group);
    }


    /**
     * Create  message (with ID -1 -> Save as new message in database)
     * @param message
     * @param author
     */
    public Message(String message, User author){
        this(-1, message,null, author);
    }

    /**
     * Create  group message (with ID -1 -> Save as new message in database)
     * @param message
     * @param author
     * @param group
     */
    public Message(String message, User author, Group group){
        this(-1, message, group, author);
    }

    /**
     * Get author id
     * @return id
     */
    public int getID(){
        return this.id;
    }

    /**
     * Set Message id
     * @param id Positive or -1
     * @throws IllegalArgumentException
     */
    private void setID(int id) throws IllegalArgumentException {
        if (id < -1){
            throw new IllegalArgumentException("ID negative.");
        }
        this.id = id;
    }

    /**
     * Get Message message
     * @return name
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Set Message message
     * @param message Not null or empty
     * @throws IllegalArgumentException
     */
    public void setMessage(String message) throws IllegalArgumentException {
        if (message == null || message.isEmpty()){
            throw new IllegalArgumentException("Message null or empty.");
        }
        this.message = message;
    }

    /**
     * Get Message author
     * @return author
     */
    public User getAuthor(){
        return this.author;
    }

    /**
     * Set Message author
     */
    public void setAuthor(User author){
        this.author = author;
    }

    /**
     * Get Message group
     * @return group
     */
    public Group getGroup(){
        return this.group;
    }

    /**
     * Set Message group
     */
    public void setGroup(Group group) {
        this.group = group;
    }

}
