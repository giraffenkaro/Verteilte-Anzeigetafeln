/*import database.Database;
import database.exceptions.DatabaseConnectionException;
import threads.ServerThread;

/**
 * Created by Dominik on 08.07.2017.
 */
/*
public class Server {

    public static void main (String[] args){
        Database database = null;
        try {
            database = new Database();
            /*try {
                ServerThread server = new ServerThread(database);
                server.run();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                database.closeDB();
            }*/
/*
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
        }
    }
}
*/




import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Server implements Functions
{

    public Server() {}

    public static void main(String args[])
    {

        try
        {
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
        return null;
    }

    @Override
    public String deleteMessages(int boardID, int userID, int messageID) throws RemoteException
    {
        return null;
    }

    @Override
    public String addMessage(int boardID, int UserID, String message) throws RemoteException
    {
        return null;
    }

    @Override
    public String addUser(String name) throws RemoteException
    {

        return null;
    }

    @Override
    public String deleteUser(int userID) throws RemoteException
    {
        return null;
    }

    @Override
    public String changePassword(int userID) throws RemoteException
    {
        return null;
    }

    @Override
    public String setMod(int UserID) throws RemoteException
    {
        return null;
    }

    @Override
    public String addGroup(String name, int modID) throws RemoteException
    {
        return null;
    }

    @Override
    public String setGroup(String name, int groupID) throws RemoteException
    {
        return null;
    }

    @Override
    public String changeGroup(String name, int userID, int groupID) throws RemoteException
    {
        return null;
    }

    @Override
    public String addBoard(String name, int groupID) throws RemoteException
    {
        return null;
    }

    @Override
    public String deleteBoard(int boardID)
    {
        return null;
    }
}