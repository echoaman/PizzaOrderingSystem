import java.rmi.*;
import java.util.*;

public class Admin {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            ServerInterface st = (ServerInterface)Naming.lookup("rmi://localhost/loadbalancer");

            while(true){
                System.out.println("\n1.All orders\t2.Update Status\t3.Exit");

                String choice = in.nextLine().trim();
                
                if(choice.equals("1")){
                    ArrayList<ArrayList<String>> orders = st.allOrders();
                    System.out.println("\nOID\tUID\tTime\t\t\tStatus");
                    for(ArrayList<String> order : orders){
                        System.out.println(order.get(0) + "\t" + order.get(1) + "\t" + order.get(2) + "\t" + order.get(3));
                    }
                }

                if(choice.equals("2")){
                    System.out.print("\nEnter order id : ");
                    int order_id = in.nextInt();
                    st.updateStatus(order_id);
                }

                if(choice.equals("3")){
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
