import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class Server extends UnicastRemoteObject implements ServerInterface {

    public int currServerToConnect = 0;

    Server() throws RemoteException {
        super();
    }

    @Override
    public int signin(String uname, String pwd) throws RemoteException {
        return Query.authenticateLogin(uname, pwd);
    }

    @Override
    public String getServerConnection(int uid) throws RemoteException {
        if (currServerToConnect % 3 == 0) {
            System.out.println("Connecting " + uid + " to Server A");
            currServerToConnect++;
            return "A";
        }

        if (currServerToConnect % 3 == 1) {
            System.out.println("Connecting " + uid + " to Server B");
            currServerToConnect++;
            return "B";
        }

        System.out.println("Connecting " + uid + " to Server C");
        currServerToConnect++;
        return "C";
    }

    @Override
    public int signup(String uname, String pwd) throws RemoteException {
        return Query.createAccount(uname, pwd);
    }

    @Override
    public ArrayList<ArrayList<String>> menu(int uid) throws RemoteException {
        System.out.println("\nServing " + uid);
        ArrayList<ArrayList<String>> menu = Query.getMenu();
        System.out.println(menu);
        return menu;
    }

    
}
