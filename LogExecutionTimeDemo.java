import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class LogExecutionTimeProcessor {
    public static void processAnnotations(Object obj) throws Exception {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.currentTimeMillis();
                method.invoke(obj);
                long end = System.currentTimeMillis();
                System.out.println(method.getName() + " executed in " + (end - start) + "ms");
            }
        }
    }
}

public class LogExecutionTimeDemo {
    @LogExecutionTime
    public void methodToTime() throws InterruptedException {
        Thread.sleep(200); // Simulate some work
    }

    public static void main(String[] args) throws Exception {
        LogExecutionTimeDemo demo = new LogExecutionTimeDemo();
        LogExecutionTimeProcessor.processAnnotations(demo);
    }
}
