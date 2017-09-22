import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import database.Database;
import database.exceptions.DatabaseConnectionException;


public class Server implements Functions
{

    public Server() {}

    public static void main(String args[])
    {
        try
        {
            Database database = new Database();

            Server obj = new Server();
            Functions stub = (Functions) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registry.rebind("Functions", stub);

            System.err.println("Server laeuft");
        } catch (Exception e)
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public String getMessages(int boardID) throws RemoteException
    {
        return "getMesseages( " + boardID + " )" ;
    }

    @Override
    public String deleteMessages(int boardID, int userID, int messageID) throws RemoteException
    {
        return "deleteMessages ( " + boardID +"," +  userID + "," + messageID + " )";
    }

    @Override
    public String addMessage(int boardID, int userID, String message) throws RemoteException
    {
        return "addMessage ( " + boardID + "," + userID + "," + message + " )";
    }

    @Override
    public String addUser(String name) throws RemoteException
    {

        return "addUser ( " + name + ")";
    }

    @Override
    public String deleteUser(int userID) throws RemoteException
    {
        return "deleteUser (" + userID + ")";
    }

    @Override
    public String changePassword(String name, String password) throws RemoteException
    {
        return "changePassword (" + name + "," + password + ")" ;
    }

    @Override
    public String setMod(int userID) throws RemoteException
    {
        return "setMod (" + userID + ")";
    }

    @Override
    public String addGroup(String name, int modID) throws RemoteException
    {
        return "addGroup (" + name + "," + modID + ")";
    }

    @Override
    public String setGroup(String name, int groupID) throws RemoteException
    {
        return "setGroup (" + name + "," + groupID + ")";
    }

    @Override
    public String changeGroup(String name, int userID, int groupID) throws RemoteException
    {
        return "changeGroup (" + name + "," + userID + "," + groupID + ")";
    }

    @Override
    public String addBoard(String name, int groupID) throws RemoteException
    {
        return "addBoard(" + name + "," + groupID + ")";
    }

    @Override
    public String deleteBoard(int boardID)
    {
        return "deleteBoard ( " + boardID + ")";
    }
    
    @Override
    public String login(String username, String password)
    {
        //TODO loginfunktionalität basteln
        
        //vorläufig
        return null;
    }
}
