import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.PrintStream;

/**
 * Created by JAbanto on 09.05.2017.
 * @link SlayDragonQuest implementa la interfaz @link Quest,
 * perfecta para BraveKnight.
 *
 */
public class SlayDragonQuest implements Quest {


    private PrintStream stream;

    /*
    KONSTRUCTOR INJECTION OF PRINTSTREAM
     */

    public SlayDragonQuest(PrintStream stream){

        this.stream = stream;

    }

    /**
     * Ademas en lugar de depender de System.out.println(), SlayDragonQuest solicita PrintStream
     * a travez de su constructor .
     * Para proporcionar Slay dragonQuest a BraveKnight utilizaremosun  de su formas por xml
     * ahora veremos un sencillo archivo que conecta BraveKnight con SlayDragonQuest y PrintStream.
     * pero con Spring podemos configurar esta conexcion utilizando Java y anatocioen en una clase
     * que llamaremos {@link KnightConfig}
     *
     */

    public void embark(){
        stream.println("Embarking on quest to slay the dragon!");
    }

}
