import database.Database;
import database.exceptions.DatabaseConnectionException;
import threads.ServerThread;

/**
 * Created by Dominik on 08.07.2017.
 */
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
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
        }
    }
}
