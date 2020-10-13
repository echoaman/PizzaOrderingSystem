import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            ServerInterface st = (ServerInterface)Naming.lookup("rmi://localhost/loadbalancer");
            System.out.println(st.login());
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
