import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Dien Klasse zum starten der Anwendung
 * @Autor Javanto
 */
public class Starter {

    /**
     * die Argumente der Anwendung
     * @param args
     */
    public static void main(String[] args) {
        //initializierung von Spring

        ApplicationContext context = new AnnotationConfigApplicationContext("com.javanto");
        Runnable service = context.getBean("application",Runnable.class);
        service.run();

    }
}
