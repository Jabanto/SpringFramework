import Aspects.Minstrel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by JAbanto on 09.05.2017.
 * las ventajas de DI son las misma tanto configura por xml o por java
 * Aunque {@link BraveKnight} depende de {@link Quest}, no conoce que tipo
 * de Quest recibe ni de donde proviene. Del mismo modo , {@link SlayDragonQuest}
 * depende de {@link java.io.PrintStream} , pero desconoce de donde se origina .
 * Solamente Spring, atravez de su configuration, sbe como combinar todas la piezas
 * , lo que permite cmabiar estas dependencias sin modificar las clase dependientes
 *
 */

@Configuration
@EnableAspectJAutoProxy
public class KnightConfig {

    @Bean
    public Knight knight(){

        return new BraveKnight(quest());
    }
    @Bean
    public Quest quest(){

        return new SlayDragonQuest(System.out);
    }



}
