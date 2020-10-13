import java.rmi.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements ServerInterface{
    
    Server() throws RemoteException {
        super();
    }

    @Override
    public int login() throws RemoteException {
        
        return 0;
    }

    
}
