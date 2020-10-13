import java.rmi.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements ServerInterface{
    
    public int currServerToConnect = 0;

    Server() throws RemoteException {
        super();
    }

    @Override
    public int signin(String uname, String pwd) throws RemoteException {
        return Query.authenticateLogin(uname, pwd);
    }

    @Override
    public String getServerConnection() throws RemoteException {
        if(currServerToConnect % 3 == 0){
            System.out.println("Connecting to Server A");
            currServerToConnect++;
            return "A";
        }

        if(currServerToConnect % 3 == 1){
            System.out.println("Connecting to Server B");
            currServerToConnect++;
            return "B";
        }

        System.out.println("Connecting to server C");
        currServerToConnect++;
        return "C";
    }

    @Override
    public int signup(String uname, String pwd) throws RemoteException {
        return Query.createAccount(uname, pwd);
    }

    
}
