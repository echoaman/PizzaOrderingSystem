import java.rmi.*;

public class ServerC {
    public static void main(String[] args) {
        try {
            ServerInterface serv = new Server();
            Naming.rebind("serverC", serv);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
