import java.rmi.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements ServerInterface{
    
    public int currServerToConnect = 0;

    Server() throws RemoteException {
        super();
    }

    @Override
    public int login() throws RemoteException {
        
        return 0;
    }

    @Override
    public String getServerConnection() throws RemoteException {
        if(currServerToConnect % 3 == 0){
            System.out.println("Connecting to Server A");
            return "A";
        }

        if(currServerToConnect % 3 == 1){
            System.out.println("Connecting to Server B");
            return "B";
        }

        System.out.println("Connecting to server C");
        return "C";
    }

    
}
