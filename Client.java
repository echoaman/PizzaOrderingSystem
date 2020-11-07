import java.rmi.*;
import java.util.*;
public class Client {

    public static String user_name;
    public static String connectedServer;
    public static int user_id;
    public static ServerInterface st;

    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            st = (ServerInterface)Naming.lookup("rmi://localhost/loadbalancer");

            //Login
            while(true){
                System.out.println("\n1.Sign In\t2.Sign Up\t3.Exit");
                String choice = in.nextLine().trim();

                if(choice.equals("1")){
                    String temp_uname = "";
                    String temp_pwd = "";

                    System.out.print("\nEnter user name: ");
                    temp_uname = in.nextLine().trim();
                    System.out.print("Enter password: ");
                    temp_pwd = in.nextLine().trim();

                    int id = st.signin(temp_uname, temp_pwd);

                    if(id == -1){
                        System.out.println("\nIncorrect user name or password");
                    }else{
                        user_id = id;
                        user_name = temp_uname;
                        System.out.println("\nWelcome " + temp_uname + " !");
                        break;
                    }
                }

                if(choice.equals("2")){
                    String uname = "";
                    String pwd = "";

                    System.out.print("\nEnter user name: ");
                    uname = in.nextLine().trim();
                    System.out.print("Enter password: ");
                    pwd = in.nextLine().trim();

                    int id = st.signup(uname, pwd);
                    if(id == -1){
                        System.out.println("\nUser name exists");
                    }else{
                        user_id = id;
                        user_name = uname;
                        System.err.println("\nWelcome " + user_name + " !");
                        break;
                    }
                }

                if(choice.equals("3")){
                    System.exit(0);
                }
            }

            //get connection
            connection();

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void connection(){
        try {
            connectedServer = st.getServerConnection(user_id);
            st = (ServerInterface)Naming.lookup("rmi://localhost/server"+connectedServer);
            System.out.println("\nConnected to server " + connectedServer);
            while(true){
                System.out.println("\n1.Menu\t2.Place Order\t3.Order History\t4.Exit");
                String choice = in.nextLine().trim();

                if(choice.equals("1")){
                    long req_time = System.currentTimeMillis();
                    ArrayList<ArrayList<String>> menu = st.getMenu(user_id);
                    long server_time = st.getServerTime();
                    long response_time = System.currentTimeMillis();
                    System.out.println("\nSrNo\tName\tCost");
                    for(ArrayList<String> row : menu){
                        System.out.println(row.get(0) + "\t" + row.get(1) + "\t" + row.get(2));
                    }

                    System.out.println("\n");
                    System.out.println("Request time = " + req_time);
                    System.out.println("Response time = " + response_time);
                    System.out.println("Synchronised time = " + (server_time + (response_time - req_time) / 2));
                    System.out.println("\n");
                }

                if(choice.equals("2")){
                    System.out.print("\nEnter items: ");
                    String[] items = in.nextLine().trim().split(" ");
                    long req_time = System.currentTimeMillis();
                    st.placeOrder(user_id, items);
                    long server_time = st.getServerTime();
                    long response_time = System.currentTimeMillis();

                    System.out.println("\n");
                    System.out.println("Request time = " + req_time);
                    System.out.println("Response time = " + response_time);
                    System.out.println("Synchronised time = " + (server_time + (response_time - req_time) / 2));
                    System.out.println("\n");
                }

                if(choice.equals("3")){
                    long req_time = System.currentTimeMillis();
                    ArrayList<ArrayList<String>> history = st.getUserOrders(user_id);
                    long server_time = st.getServerTime();
                    long response_time = System.currentTimeMillis();
                    System.out.println("\nSrNo\tDate\t\t\tStatus");
                    for(ArrayList<String> row : history){
                        System.out.println(row.get(0) + "\t" + row.get(1) + "\t" + row.get(2));
                    }

                    System.out.println("\n");
                    System.out.println("Request time = " + req_time);
                    System.out.println("Response time = " + response_time);
                    System.out.println("Synchronised time = " + (server_time + (response_time - req_time) / 2));
                    System.out.println("\n");
                }

                if(choice.equals("4")){
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
