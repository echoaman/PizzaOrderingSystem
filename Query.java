import java.sql.*;

public class Query {

    public static int authenticateLogin(String uname, String pwd){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "369369");

            PreparedStatement statement = conn.prepareStatement("SELECT uid FROM users WHERE uname = ? AND pwd = ?");
            statement.setString(1, uname);
            statement.setString(2, pwd);

            ResultSet resultSet = statement.executeQuery();

            conn.close();

            if(resultSet.first()){
                return resultSet.getInt("uid");
            }else return -1;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return -1;
    }

    public static int createAccount(String uname, String pwd){
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "369369");

            PreparedStatement statement = conn.prepareStatement("INSERT INTO users(uname, pwd) VALUES(?,?)");
            statement.setString(1, uname);
            statement.setString(2, pwd);

            int rows = statement.executeUpdate();

            conn.close();

            if(rows == 1){
                return Query.authenticateLogin(uname, pwd);
            }else return -1;
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        return -1;
    }
}
