import java.sql.*;
import java.util.*;

public class Query {

    public static final String db_url = "jdbc:mysql://localhost:3306/test";
    public static final String db_user = "root";
    public static final String db_pwd = "369369";

    public static int authenticateLogin(String uname, String pwd){
        try {
            Connection conn = DriverManager.getConnection(db_url, db_user, db_pwd);

            PreparedStatement statement = conn.prepareStatement("SELECT uid FROM users WHERE uname = ? AND pwd = ?");
            statement.setString(1, uname);
            statement.setString(2, pwd);

            ResultSet resultSet = statement.executeQuery();

            int result = -1;
            if(resultSet.next()){
                result = resultSet.getInt("uid");
            }

            conn.close();
            return result;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return -1;
    }

    public static int createAccount(String uname, String pwd){
        try {

            Connection conn = DriverManager.getConnection(db_url, db_user, db_pwd);

            PreparedStatement statement = conn.prepareStatement("INSERT INTO users(uname, pwd) VALUES(?,?)");
            statement.setString(1, uname);
            statement.setString(2, pwd);

            int rows = statement.executeUpdate();

            int result = -1;
            if(rows == 1){
                conn.close();
                result = authenticateLogin(uname, pwd);
            }

            conn.close();
            return result;
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return -1;
    }

    public static ArrayList<ArrayList<String>> getMenu() {
        ArrayList<ArrayList<String>> menu = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(db_url, db_user, db_pwd);
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM pizza");

            while(resultSet.next()){
                ArrayList<String> row = new ArrayList<>();
                row.add(String.valueOf(resultSet.getInt("pid")));
                row.add(resultSet.getString("pname"));
                row.add(String.valueOf(resultSet.getInt("cost")));
                menu.add(row);
            }

            conn.close();
            return menu;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return menu;
    }

    public static void createOrder(int uid, String[] items){
        try {
            Connection conn = DriverManager.getConnection(db_url, db_user, db_pwd);
            Statement count_statment = conn.createStatement();

            ResultSet count_resSet = count_statment.executeQuery("SELECT MAX(oid) as TEMP FROM order_slave");
            
            int row = 0;
            while(count_resSet.next()){
                row = count_resSet.getInt("TEMP");
            }
            row++;

            PreparedStatement ins_statement = conn.prepareStatement("INSERT INTO order_master(uid) VALUES(?)");
            ins_statement.setInt(1, uid);
            
            ins_statement.executeUpdate();

            for(String item : items){
                PreparedStatement item_statement = conn.prepareStatement("INSERT INTO order_detail(oid,pid) VALUES(?,?)");
                item_statement.setInt(1, row);
                item_statement.setInt(2, Integer.parseInt(item));

                item_statement.executeUpdate();
            }

            conn.close();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}

