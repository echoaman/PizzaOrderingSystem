import java.rmi.*;

public class ServerC {
    public static void main(String[] args) {
        System.out.println("Server C\n");
        try {
            ServerInterface serv = new Server();
            Naming.rebind("serverC", serv);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
