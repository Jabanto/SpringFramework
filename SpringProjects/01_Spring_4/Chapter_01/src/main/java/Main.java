import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by JAbanto on 09.05.2017.
 * En este caso el metodo main crea el contexto de la aplication Spring en funcion del archivo
 * XML o archivo Java {@link KnightConfig} a continuacion utiliza el contexto como una fabrica
 * para obtenr el bean Knight , Con una referencia al objeto Knight , invoca al methode embarkOnQuest()
 * para que el caballero haga la tarea encomendada, tenga en cuenta que esta classe no tiene ninguna
 * informacion sobre el tipo de Quest en la que se encuentra nuestro Heroe. En este aspecto desconoce que
 * esta tratando con {@link BraveKnight} solo el archivo Xml o en si lo hacemos por java la clase
 * {@link KnightConfig} conoce cuales son las implemetaciones. con todo esto ya cuenta con una rapida
 * introduccion a la iyeccion de dependencias. ahora toca la siguiente estretegias la
 * PROGRAMACION DECLARATIVA ORIENTADA A ASPECTOS
 *
 */
public class Main {



    public static void main(String[] args) throws Exception {

        /*
          cargar Context de Spring

          Spring Context aufladen , Beans Konfiguration von class KnightConfig aufladen


         */




        ApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);

        Knight knight = context.getBean(Knight.class);

        /*
         utilizar knight

         knight verwendet
         */

        knight.embarkOnQuest();


    }

}
