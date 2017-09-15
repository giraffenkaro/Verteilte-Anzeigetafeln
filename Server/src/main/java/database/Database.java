package database;

import database.exceptions.DatabaseConnectionException;
import database.exceptions.DatabaseObjectNotFoundException;
import database.exceptions.DatabaseObjectNotSavedException;
import database.objects.Board;
import database.objects.Group;
import database.objects.Message;
import database.objects.User;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author D.Bergum
 * Manage object to database and database to object
 */
public class Database {

    DBConnection dbcon = null;

    /**
     * Connect to database
     * @throws DatabaseConnectionException
     */
    public Database() throws DatabaseConnectionException {
        dbcon = new DBConnection();
        this.openDB();
    }

    /**
     *Connect to database
     */
    public synchronized void openDB() {
        try {
            if (!dbcon.isOpen()) {
                dbcon.openDB();
            }
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close connection to database
     */
    public synchronized void closeDB() {
        try {
            dbcon.closeDB();
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a user from database by id
     * @param id UserId
     * @return User
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized User getUserById(int id) throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ResultSet rs = dbcon.execute("SELECT * FROM 'User' WHERE id = '" + id + "';");
            if (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("level"));
                rs.close();
                dbcon.free();
                return u;
            } else {
                rs.close();
                throw new DatabaseObjectNotFoundException();
            }
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Get all users from database
     * @return Userlist
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized ArrayList<User> getUsers() throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ArrayList<User> users = new ArrayList<User>();
            ResultSet rs = dbcon.execute("SELECT * FROM 'User';");
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("level")));
            }
            rs.close();
            dbcon.free();
            if (users.size() > 0) {
                return users;
            }
            throw new DatabaseObjectNotFoundException();
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Get a user by level from database
     * @param level UserLevel
     * @return User
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized ArrayList<User> getUsersByLevel(int level) throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ArrayList<User> users = new ArrayList<User>();
            ResultSet rs = dbcon.execute("SELECT * FROM 'User' WHERE level = '" + level + "';");
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("level")));
            }
            rs.close();
            dbcon.free();
            if (users.size() > 0) {
                return users;
            }
            throw new DatabaseObjectNotFoundException();
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Save a user in the database
     * @param user User
     * @throws DatabaseObjectNotSavedException
     * @throws IllegalArgumentException
     * @throws DatabaseConnectionException
     */
    public synchronized void saveUser(User user) throws DatabaseObjectNotSavedException, IllegalArgumentException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        if (user != null) {
            try {
                if (user.getID() == -1) {
                    dbcon.execute("INSERT INTO 'User' (name, password, level) VALUES ('" + user.getName() + "','" + user.getPassword() + "','" + user.getLevel() + "');");
                } else {
                    dbcon.execute("UPDATE 'User' SET name = '" + user.getName() + "', password = '" + user.getPassword() + "', level = '" + user.getLevel() + "' WHERE id = '" + user.getID() + "';");
                }
            } catch (Exception e) {
                throw new DatabaseObjectNotSavedException();
            }
        } else {
            throw new IllegalArgumentException("User null.");
        }
    }

    /**
     * Get a board from database by id
     * @param id BoardId
     * @return Board
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized Board getBoardById(int id) throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ResultSet rs = dbcon.execute("SELECT * FROM 'Board' WHERE id = '" + id + "';");
            if (rs.next()) {
                int gId = rs.getInt("groupId");
                int uId = rs.getInt("userId");
                Board b = new Board(rs.getInt("id"), rs.getString("name"), null, null);
                rs.close();
                dbcon.free();
                if (gId != -1) {
                    b.setGroup(getGroupById(gId));
                }
                if (uId != -1) {
                    b.setUser(getUserById(uId));
                }
                return b;
            } else {
                rs.close();
                throw new DatabaseObjectNotFoundException();
            }
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Get all boards from database
     * @return Boardlist
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized ArrayList<Board> getBoards() throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ArrayList<Board> boards = new ArrayList<Board>();
            ArrayList<Integer> gIds = new ArrayList<Integer>();
            ArrayList<Integer> uIds = new ArrayList<Integer>();
            ResultSet rs = dbcon.execute("SELECT * FROM 'Board';");
            while (rs.next()) {
                boards.add(new Board(rs.getInt("id"), rs.getString("name"), null,null));
                gIds.add(rs.getInt("groupId"));
                uIds.add(rs.getInt("userId"));
            }
            rs.close();
            dbcon.free();
            if (boards.size() > 0) {
                for (int i = 0; i < boards.size(); i++) {
                    if (gIds.get(i) != -1) {
                        boards.get(i).setGroup(getGroupById(gIds.get(i)));
                    }
                    if (uIds.get(i) != -1) {
                        boards.get(i).setUser(getUserById(uIds.get(i)));
                    }
                }
                return boards;
            }
            throw new DatabaseObjectNotFoundException();
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Save a board in the database
     * @param board Board
     * @throws DatabaseObjectNotSavedException
     * @throws IllegalArgumentException
     * @throws DatabaseConnectionException
     */
    public synchronized void saveBoard(Board board) throws DatabaseObjectNotSavedException, IllegalArgumentException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        if (board != null) {
            try {
                int uId = -1;
                if (board.getUser() != null){
                    uId = board.getUser().getID();
                }
                int gId = -1;
                if (board.getGroup() != null){
                    gId = board.getGroup().getID();
                }
                if (board.getID() == -1) {
                    dbcon.execute("INSERT INTO 'Board' (name, groupId, userId) VALUES ('" + board.getName() + "','" + gId + "','" + uId + "');");
                } else {
                    dbcon.execute("UPDATE 'Board' SET name = '" + board.getName() + "', userId = '" + uId + "', groupId = '" + gId + "' WHERE id = '" + board.getID() + "';");
                }
            } catch (Exception e) {
                throw new DatabaseObjectNotSavedException();
            }
        } else {
            throw new IllegalArgumentException("Board null.");
        }
    }

    /**
     * Get a group from database by id
     * @param id GroupId
     * @return Group
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized Group getGroupById(int id) throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ResultSet rs = dbcon.execute("SELECT * FROM 'Group' WHERE id = '" + id + "';");
            if (rs.next()) {
                int mId = rs.getInt("modId");
                Group g = new Group(rs.getInt("id"), rs.getString("name"), null, null);
                rs.close();
                dbcon.free();
                if (mId != -1) {
                    g.setModerator(getUserById(mId));
                }
                g.setMembers(getGroupMembers(g.getID()));
                return g;
            } else {
                rs.close();
                throw new DatabaseObjectNotFoundException();
            }
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Get all groups from database
     * @return Grouplist
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized ArrayList<Group> getGroups() throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ArrayList<Group> groups = new ArrayList<Group>();
            ArrayList<Integer> mIds = new ArrayList<Integer>();
            ResultSet rs = dbcon.execute("SELECT * FROM 'Group';");
            while (rs.next()) {
                groups.add(new Group(rs.getInt("id"), rs.getString("name"), null,null));
                mIds.add(rs.getInt("modId"));;
            }
            rs.close();
            dbcon.free();
            if (groups.size() > 0) {
                for (int i = 0; i < groups.size(); i++) {
                    if (mIds.get(i) != -1) {
                        groups.get(i).setModerator(getUserById(mIds.get(i)));
                    }
                    groups.get(i).setMembers(getGroupMembers(groups.get(i).getID()));
                }
                return groups;
            }
            throw new DatabaseObjectNotFoundException();
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Save a group in the database
     * @param group Group
     * @throws DatabaseObjectNotSavedException
     * @throws IllegalArgumentException
     * @throws DatabaseConnectionException
     */
    public synchronized void saveGroup(Group group) throws DatabaseObjectNotSavedException, IllegalArgumentException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        if (group != null) {
            try {
                int groupId = -1;
                if (group.getID() == -1) {
                    ResultSet rs = dbcon.execute("INSERT INTO 'Group' (name, modId) VALUES ('" + group.getName() + "','" + group.getModerator().getID() + "');");
                    if (rs != null) {
                        try {
                            groupId = rs.getInt(1);
                        } catch (Exception e) {
                            groupId = -1;
                        }
                    }
                } else {
                    dbcon.execute("UPDATE 'Group' SET name = '" + group.getName() + "', modId = '" + group.getModerator().getID() + "' WHERE id = '" + group.getID() + "';");
                    groupId = group.getID();
                    deleteGroupMembers(group.getID());
                }
                if (groupId != -1) {
                    saveGroupMembers(groupId, group.getMembers());
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new DatabaseObjectNotSavedException();
            }
        } else {
            throw new IllegalArgumentException("Group null.");
        }
    }

    /**
     * Get all group members
     * @param groupId
     * @return groupMembers
     * @throws DatabaseConnectionException
     * @throws DatabaseObjectNotFoundException
     */
    public ArrayList<User> getGroupMembers(int groupId) throws DatabaseConnectionException, DatabaseObjectNotFoundException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ArrayList<Integer> uIds = new ArrayList<Integer>();
            ResultSet rs = dbcon.execute("SELECT * FROM 'Group_User' WHERE groupId = '" + groupId + "';");
            while (rs.next()) {
                uIds.add(rs.getInt("userId"));
            }
            rs.close();
            dbcon.free();
            if (uIds.size() > 0) {
                ArrayList<User> members = new ArrayList<User>();

                for (int i : uIds) {
                    members.add(getUserById(i));
                }

                return members;
            }
            return null;
        } catch (Exception e) {
            dbcon.free();
            return null;
        }
    }

    /**
     * Delete all group members
     * @param groupId
     * @throws DatabaseConnectionException
     */
    public void deleteGroupMembers(int groupId) throws DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            dbcon.execute("DELETE FROM 'Group_User' WHERE groupId = '" + groupId + "';");
        } catch (Exception e) {
            dbcon.free();
        }
    }

    /**
     * Save all group members
     * @param groupId
     * @param groupMembers
     * @throws DatabaseConnectionException
     * @throws DatabaseObjectNotSavedException
     */
    public void saveGroupMembers(int groupId, ArrayList<User> groupMembers) throws DatabaseConnectionException, DatabaseObjectNotSavedException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        if (groupMembers != null && groupMembers.size() > 0) {
            try {
                for (User gM : groupMembers) {
                    dbcon.execute("INSERT INTO 'Group_User' (groupId, userId) VALUES ('" + groupId + "','" + gM.getID() + "');");
                }
            } catch (Exception e) {
                throw new DatabaseObjectNotSavedException();
            }
        }
    }

    /**
     * Get a message from database by id
     * @param id MessageId
     * @return Message
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized Message getMessageById(int id) throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ResultSet rs = dbcon.execute("SELECT * FROM 'Message' WHERE id = '" + id + "';");
            if (rs.next()) {
                int gId = rs.getInt("groupId");
                int aId = rs.getInt("authorId");
                Message m = new Message(rs.getInt("id"), rs.getString("message"), null, null);
                rs.close();
                dbcon.free();
                if (gId != -1) {
                    m.setGroup(getGroupById(gId));
                }
                if (aId != -1) {
                    m.setAuthor(getUserById(aId));
                }
                return m;
            } else {
                rs.close();
                throw new DatabaseObjectNotFoundException();
            }
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Get all messages from database
     * @return Boardlist
     * @throws DatabaseObjectNotFoundException
     * @throws DatabaseConnectionException
     */
    public synchronized ArrayList<Message> getMessages() throws DatabaseObjectNotFoundException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        try {
            ArrayList<Message> messages = new ArrayList<Message>();
            ArrayList<Integer> gIds = new ArrayList<Integer>();
            ArrayList<Integer> aIds = new ArrayList<Integer>();
            ResultSet rs = dbcon.execute("SELECT * FROM 'Message';");
            while (rs.next()) {
                messages.add(new Message(rs.getInt("id"), rs.getString("message"), null,null));
                gIds.add(rs.getInt("groupId"));
                aIds.add(rs.getInt("authorId"));
            }
            rs.close();
            dbcon.free();
            if (messages.size() > 0) {
                for (int i = 0; i < messages.size(); i++) {
                    if (gIds.get(i) != -1) {
                        messages.get(i).setGroup(getGroupById(gIds.get(i)));
                    }
                    if (aIds.get(i) != -1) {
                        messages.get(i).setAuthor(getUserById(aIds.get(i)));
                    }
                }
                return messages;
            }
            throw new DatabaseObjectNotFoundException();
        } catch (Exception e) {
            dbcon.free();
            throw new DatabaseObjectNotFoundException();
        }
    }

    /**
     * Save a message in the database
     * @param message Message
     * @throws DatabaseObjectNotSavedException
     * @throws IllegalArgumentException
     * @throws DatabaseConnectionException
     */
    public synchronized void saveMessage(Message message) throws DatabaseObjectNotSavedException, IllegalArgumentException, DatabaseConnectionException {
        if (!dbcon.isOpen()) {
            throw new DatabaseConnectionException("Not connected to database.");
        }
        if (message != null) {
            try {
                int aId = -1;
                if (message.getAuthor() != null){
                    aId = message.getAuthor().getID();
                }
                int gId = -1;
                if (message.getGroup() != null){
                    gId = message.getGroup().getID();
                }
                if (message.getID() == -1) {
                    dbcon.execute("INSERT INTO 'Message' (message, groupId, authorId) VALUES ('" + message.getMessage() + "','" + gId + "','" + aId + "');");
                } else {
                    dbcon.execute("UPDATE 'Message' SET message = '" + message.getMessage() + "', authorId = '" + aId + "', groupId = '" + gId + "' WHERE id = '" + message.getID() + "';");
                }
            } catch (Exception e) {
                throw new DatabaseObjectNotSavedException();
            }
        } else {
            throw new IllegalArgumentException("Message null.");
        }
    }
}
