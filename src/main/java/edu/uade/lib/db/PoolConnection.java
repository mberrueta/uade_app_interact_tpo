package edu.uade.lib.db;
import java.util.Vector;

public class PoolConnection {
    private Vector<DBConnection> connections = new Vector<DBConnection>();
    protected String password;
    private static PoolConnection pool;

    private PoolConnection() throws Exception {
        for (int i = 0; i < 10; i++)
            connections.add(new DBConnection());
    }

    public static PoolConnection getIntance() throws Exception {
        if (pool == null)
            pool = new PoolConnection();
        return pool;
    }

    public void closeConnections() {
        for (int i = 0; i < connections.size(); i++) {
            try {
                connections.elementAt(i).close();
            } catch (Exception e) {
                System.out.println("Mensaje Error: " + e.getMessage());
                System.out.println("Stack Trace: " + e.getStackTrace());
            }
        }
    }

    public DBConnection getConnection() throws Exception {
        DBConnection c = null;
        if (connections.size() > 0)
            c = connections.remove(0);
        else {
            c = new DBConnection();
        }
        return c;
    }

    public void realeaseConnection(DBConnection c) {
        connections.add(c);
    }
}

