import java.rmi.*;
import java.util.*;

public interface ServerInterface extends Remote{
    public int signin(String uname, String pwd) throws RemoteException;
    public int signup(String uname, String pwd) throws RemoteException;
    public String getServerConnection(int uid) throws RemoteException;
    public ArrayList<ArrayList<String>> menu(int uid) throws RemoteException;
    public void placeOrder(int uid, String[] items) throws RemoteException;
    public ArrayList<ArrayList<String>> getUserOrders(int uid) throws RemoteException;
}