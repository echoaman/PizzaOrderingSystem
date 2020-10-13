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
            System.out.println("Connecting UID " + uid + " to Server A");
            currServerToConnect++;
            return "A";
        }

        if (currServerToConnect % 3 == 1) {
            System.out.println("Connecting UID" + uid + " to Server B");
            currServerToConnect++;
            return "B";
        }

        System.out.println("Connecting UID" + uid + " to Server C");
        currServerToConnect++;
        return "C";
    }

    @Override
    public int signup(String uname, String pwd) throws RemoteException {
        return Query.createAccount(uname, pwd);
    }

    @Override
    public ArrayList<ArrayList<String>> menu(int uid) throws RemoteException {
        System.out.println("\nReturning menu for ID = " + uid);
        ArrayList<ArrayList<String>> menu = Query.getMenu();
        return menu;
    }

    @Override
    public void placeOrder(int uid, String[] items) throws RemoteException {
        // TODO Auto-generated method stub
        System.out.println("Placing order for UID " + uid + " => " + Arrays.toString(items));
        Query.createOrder(uid, items);
    }

    
}
