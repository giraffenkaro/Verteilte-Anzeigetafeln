package rmiinterface;

import database.objects.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Functions extends Remote
{
    String test(int testID) throws Exception;
    /*
    User getUserById(int id) throws Exception;
    User getUserByName(String username) throws Exception;
    ArrayList<User> getUsers() throws Exception;
    ArrayList<User> getUsersByLevel(int level) throws Exception;
    void saveUser(User user) throws Exception;
    Board getBoardById(int id) throws Exception;
    ArrayList<Board> getBoards() throws Exception;
    void saveBoard(Board board) throws Exception;
    Group getGroupById(int id) throws Exception;
    ArrayList<Group> getGroups() throws Exception;
    ArrayList <Group> getGroupsByUser(User u) throws Exception;
    void saveGroup(Group group) throws Exception;
    ArrayList <User> getUsersNotInGroup(Group group) throws Exception;
    ArrayList <User> getUsersNotInGroup(int groupID) throws Exception;
    ArrayList<User> getGroupMembers(int groupId) throws Exception;
    void deleteGroupMembers(int groupId) throws Exception;
    void saveGroupMembers(int groupId, ArrayList<User> groupMembers) throws Exception;
    Message getMessageById(int id) throws Exception;
    ArrayList<Message> getMessagesByUser(User u) throws Exception;
    ArrayList<Message> getMessages() throws Exception;
    ArrayList<Message> getMessagesByGroup(Group g) throws Exception;
    void saveMessage(Message message) throws Exception;
    User loginUser(String username, String password) throws Exception;
    */
}
