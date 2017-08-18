package database;

import database.objects.Board;
import database.objects.Message;
import database.objects.User;
import database.objects.Group;

/**
 * Created by Dominik on 18.08.2017.
 */
public class ObjectFactory {

    public static User createUser(String name, String password, int level){
        return new User(name, password, level);
    }

    public static Board createGroupBoard(String name, Group group){
        return new Board(name, group);
    }

    public static Board createUserBoard(String name, User user){
        return new Board(name, user);
    }

    public static Message createMessage(String message, User author){
        return new Message(message, author);
    }

    public static Message createGroupMessage(String message, User author, Group group){
        return new Message(message, author, group);
    }
}
