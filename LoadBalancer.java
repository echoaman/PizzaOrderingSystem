import java.rmi.*;

public class LoadBalancer {
    public static void main(String[] args) {

        System.out.println("Load balancer");

        try{
            ServerInterface serv = new Server();
            Naming.rebind("loadbalancer", serv);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
