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
}

