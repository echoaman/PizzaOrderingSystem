public class Initiate {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" LoadBalancer\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" ServerA\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" ServerB\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" ServerC\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" BackUpServer\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" Client\"");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -classpath \"D:\\DS\\PizzaOrderingSystem;D:\\DS\\PizzaOrderingSystem\\mysql-connector-java-8.0.21.jar\" Client\"");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
//java -classpath "D:\DS\PizzaOrderingSystem;D:\DS\PizzaOrderingSystem\mysql-connector-java-8.0.21.jar" LoadBalancer