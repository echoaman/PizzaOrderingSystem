## How to run:

```java
1. javac -classpath "D:\DS\PizzaOrderingSystem;D:\DS\PizzaOrderingSystem\mysql-connector-java-8.0.21.jar" *.java
2. rmic Server
3. start rmiregistry
4. java -classpath "D:\DS\PizzaOrderingSystem;D:\DS\PizzaOrderingSystem\mysql-connector-java-8.0.21.jar" LoadBalancer
5. java -classpath "D:\DS\PizzaOrderingSystem;D:\DS\PizzaOrderingSystem\mysql-connector-java-8.0.21.jar" ServerA
5. java -classpath "D:\DS\PizzaOrderingSystem;D:\DS\PizzaOrderingSystem\mysql-connector-java-8.0.21.jar" Client
```