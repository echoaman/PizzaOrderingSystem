import java.rmi.*;

public interface ServerInterface extends Remote{
    public int signin(String uname, String pwd) throws RemoteException;
    public int signup(String uname, String pwd) throws RemoteException;
    public String getServerConnection() throws RemoteException;
}