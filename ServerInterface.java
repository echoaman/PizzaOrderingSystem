import java.rmi.*;

public interface ServerInterface extends Remote{
    public int login() throws RemoteException;
}