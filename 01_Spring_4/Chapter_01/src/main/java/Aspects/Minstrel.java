package Aspects;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.PrintStream;

/**
 * Created by JAbanto on 09.05.2017.
 * Auqnue la DI permite vinvular componentes de sofware de fomra debil , la progrmacion orientada a aspectos
 * le permite capturar la funcionalidad utilizada en su aplicacion y aplicarlas a componnentes reutilizables
 *
 * LA PROGAMACION ORIENTADA  A OBJETOS SULE DEFINIERSE COMO UNA TECNICA QUE PROMUEVE LA SEPARACION DE PROBLEMAS
 * DENTRO DE UN SISTEMA DE SOFWARE.Los sistemas estan formados por varios componentes, cada uno de los cuales
 * es responsable de una funcionalidd especifica . A menudo , estos componentes cuentan con responsabilidad
 * addicionales mas alla de sus funciones basicas. Los servicios de sistemas , como el inicio de sesion
 * la administracion de transacciones y la seguridad , suelen encontrarse en conponentes cuya responsabilidad principal
 * corresponde a otros elementos.
 *
 * A estos servicios de sistema se les suele denominar preocupaciones transversales, ya que tienden a incluirse en diferentes componenentes del sistema
 *
 */

/**
 *  Por el momneto hay que considerar a partir de este ejemplo. En primer lugar Minstrel sigue siendo un POJO.Nada indica que se vaya a utilizar como aspecto . es su lugar , se convierte en uno cuando lo declaramos como tal en el contexto sde Spring
 *
 *  2 en segundo lugar y mas importante, {@link Aspects.Minstrel} puede aplicarse a Braceknight sin que este tenga que invocarlo de forma explicita . DE echo , Bravenight desconoce por completo la existencia de Mintrel
 *
 *  Tambien debemos dejar claro que aunque hemos utilizado algo de magia de Spring para convertir Minstrel en un aspecto, antes se declrar comom de <bean> de Spring. lo que de tener en cuenta en este punto es que , que los aspectos de Spring , puede hacer qualquier cosa que pudiera hacer cos los benas, como por ejemplo inyectarlos como dependencias .
 *  Utilizar aspectos pra que los juglares canten sobles los caballeros es divertido sind embargo esto es lo minimo que usted puede hacer en Spring y AOP
 */

// TODO: 09.05.2017 trasnlate in German

/**funktionalitäten in weiter Komponnente verwenden oder einzubinden
 *
 * wie Sicherheit , Session logging und
 *
 * Systemdienste CCCs (Cross- counting Concern)queerschnittliche Funktionen bezeichnet
 *
 * Sicvherheit und Transak
 */



public class Minstrel {

    private PrintStream stream;

    /*
    Konstructor injection von PrintStream
     */

    public Minstrel(PrintStream stream){

        this.stream = stream;
    }

    /*
      wird vor Quest aufgerufen
     */

    public void SingBeforeQuest(JoinPoint joinPoint)
    {
        joinPoint.getSignature().getName();
        stream.println("Fa la la, the knight is so brave!");
    }

    /*
    wird nach Quest aufgerufen
     */

    public void  SingAfterQuest(JoinPoint joinPoint)
    {
            joinPoint.getSignature().getName();
       stream.println("Tee hee hee , the brave knight " + "did embark on a quest!");
    }

    /**
     * Como puede comprobar Minstrel es una Clase sencilla con dos metodos el metodo
     * {@link singBeforeQuest} se va invocar de que un caballero haya una Quest realizado
     * mientras que el metodo {@link singAfterQuest} se va invocar despues de que el caballero la haya
     * completado, em ambos casos, {@link Minstrel} canta la hazanas del caballero a trave de
     * {@link PrintStream}  inyectado en su constructor
     *
     * no sera dificil incluirla en el codgifo anterior, por lo que vamos a realiazar los cambios necesarios para que
     * BraveKnight utilice {@link Minstrel}
     */


}
