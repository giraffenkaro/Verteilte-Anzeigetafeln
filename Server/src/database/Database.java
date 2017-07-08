package database;

import database.exceptions.DatabaseConnectionException;
import database.exceptions.DatabaseObjectNotFoundException;
import database.exceptions.DatabaseObjectNotSavedException;
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
        dbcon.openDB();
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
            ResultSet rs = dbcon.executeQuery("SELECT * FROM User WHERE id = " + id + ";");
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("level"));
            } else {
                throw new DatabaseObjectNotFoundException();
            }
        } catch (Exception e) {
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
            ResultSet rs = dbcon.executeQuery("SELECT * FROM User;");
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("level")));
            }
            if (users.size() > 0) {
                return users;
            }
            throw new DatabaseObjectNotFoundException();
        } catch (Exception e) {
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
            ResultSet rs = dbcon.executeQuery("SELECT * FROM User WHERE level = " + level + ";");
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("level")));
            }
            if (users.size() > 0) {
                return users;
            }
            throw new DatabaseObjectNotFoundException();
        } catch (Exception e) {
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
                    dbcon.executeInsert("INSERT INTO User (name, password, level) VALUES ('" + user.getName() + "','" + user.getPassword() + "','" + user.getLevel() + "');");
                } else {
                    dbcon.executeUpdate("UPDATE User SET name = " + user.getName() + ", password = " + user.getPassword() + ", level = " + user.getLevel() + " WHERE id = " + user.getID() + ";");
                }
            } catch (Exception e) {
                throw new DatabaseObjectNotSavedException();
            }
        } else {
            throw new IllegalArgumentException("User null.");
        }
    }
}
