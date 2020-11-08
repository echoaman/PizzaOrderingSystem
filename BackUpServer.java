import java.rmi.*;

public class BackUpServer {
    public static void main(String[] args) {
        System.out.println("Back Up server\n");
        try {
            ServerInterface serv = new Server();
            Naming.rebind("backup", serv);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
