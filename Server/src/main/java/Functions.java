import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Functions extends Remote
{

    String getMessages(int boardID) throws RemoteException;
    String deleteMessages(int boardID, int userID, int messageID) throws RemoteException;
    String addMessage(int boardID, int userID, String message) throws RemoteException;

    String addUser(String name) throws RemoteException;
    String deleteUser(int userID) throws RemoteException;
    String changePassword(String name, String password) throws RemoteException;
    String setMod(int userID) throws RemoteException;

    String addGroup(String name, int modID) throws RemoteException;
    String setGroup(String name, int groupID) throws RemoteException;
    String changeGroup(String name, int userID, int groupID) throws RemoteException;

    String addBoard(String name, int groupID) throws RemoteException;
    String deleteBoard(int boardID) throws RemoteException;




}