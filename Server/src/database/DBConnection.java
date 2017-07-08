package database;

import database.exceptions.DatabaseConnectionException;
import database.exceptions.DatabaseException;

import java.sql.*;

/**
 * @author D.bergum
 *
 * Manage database connection
 */
public class DBConnection {

    Connection con;

    /**
     * Initialise connection objects
     */
    public DBConnection(){
        con = null;
    }

    /**
     * Connect to database
     * @throws DatabaseConnectionException
     */
    public synchronized void openDB() throws DatabaseConnectionException {
        try {
            if (isOpen()) {
                con.close();
            }
            con = null;
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:database.db");
            con.setAutoCommit(false);
        } catch ( Exception e ) {
            throw new DatabaseConnectionException("Could not open database.");
        }
        System.out.println("Opened database successfully.");
    }

    /**
     * Close connection to database
     * @throws DatabaseConnectionException
     */
    public synchronized void closeDB() throws DatabaseConnectionException {
        try {
            if (isOpen()) {
                con.close();
            }
            con = null;
        } catch (Exception e) {
            throw new DatabaseConnectionException("Could not close database.");
        }
        System.out.println("Closed database successfully.");
    }

    /**
     * Check if connected to database
     * @return connected
     */
    public synchronized boolean isOpen() {
        try {
            if (con != null && !con.isClosed()){
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    /**
     * Execute sql query
     * @param sql sql query
     * @return ResultSet
     * @throws DatabaseConnectionException
     */
    public synchronized ResultSet executeQuery(String sql) throws DatabaseConnectionException, DatabaseException {
        if (isOpen()) {
            try {
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                statement.close();
                return rs;
            } catch (SQLException e) {
                throw new DatabaseException("Can't execute query.");
            }
        } else {
            throw  new DatabaseConnectionException("Not connected to database.");
        }
    }

    /**
     * Execute sql update
     * @param sql sql update
     * @throws DatabaseConnectionException
     */
    public synchronized void executeUpdate(String sql) throws DatabaseConnectionException, DatabaseException {
        if (isOpen()) {
            try {
                Statement statement = null;
                statement = con.createStatement();
                statement.executeUpdate(sql);
                statement.close();
                con.commit();
            } catch (SQLException e) {
                throw new DatabaseException("Can't execute update.");
            }
        } else {
            throw  new DatabaseConnectionException("Not connected to database.");
        }
    }

    /**
     * Execute sql insert
     * @param sql sql insert
     * @throws DatabaseConnectionException
     */
    public synchronized void executeInsert(String sql) throws DatabaseConnectionException, DatabaseException {
        executeUpdate(sql);
    }
}
