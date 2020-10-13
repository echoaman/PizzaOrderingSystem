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
                System.out.println("\n1.Menu\t2.Place Order\t3.Orders\t4.Exit");
                String choice = in.nextLine().trim();

                if(choice.equals("1")){
                    ArrayList<ArrayList<String>> menu = new ArrayList<>();
                    menu = st.menu(user_id);
                    System.out.println("\nSrNo\tName\tCost");
                    for(ArrayList<String> row : menu){
                        System.out.println(row.get(0) + "\t" + row.get(1) + "\t" + row.get(2));
                    }
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
