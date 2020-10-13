import java.sql.*;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "369369");
            if(conn != null)
                System.out.println("success");

            conn.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}

/*

javac -classpath "D:\DS\PizzaOrderingSystem;D:\DS\PizzaOrderingSystem\mysql-connector-java-8.0.21.jar" *.java

*/