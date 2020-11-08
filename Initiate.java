import java.util.concurrent.TimeUnit;

public class Initiate {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" LoadBalancer\"");
            TimeUnit.SECONDS.sleep(1);
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" ServerA\"");
            TimeUnit.SECONDS.sleep(1);
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" ServerB\"");
            TimeUnit.SECONDS.sleep(1);
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" ServerC\"");
            TimeUnit.SECONDS.sleep(1);
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" BackUpServer\"");
            TimeUnit.SECONDS.sleep(1);
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" Client\"");
            TimeUnit.SECONDS.sleep(1);
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" Client\"");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
//java -classpath "D:\DS\PizzaOrderingSystem;D:\DS\PizzaOrderingSystem\mysql-connector-java-8.0.21.jar" LoadBalancer