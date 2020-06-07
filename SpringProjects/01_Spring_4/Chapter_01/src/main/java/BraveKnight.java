import Aspects.Minstrel;

import java.io.PrintStream;

/**
 * Created by JAbanto on 09.05.2017.
 */
public class BraveKnight implements Knight {

    /**
     * Quest
     */

    private Quest quest;


    /**
     * Contructor
     * @param quest INYECTAR QUEST == CONSTRUCTOR INJECTION
     * Como podemos comprobar  , a diferencia de @link DanselRescuingKnightelRes
     * @link BraveKnight no crea su propia hazana sino que se le asigna una durante la
     * construccion con un argunmente en su constructor
     *  este tipo de inyeccion en denominada CONSTRUCTOR INYECTION
     *
     *
     */

    // TODO: 09.05.2017 Deutsch version


    /*
    CONSTRUCTOR INJECTION OF QUEST
     */

    public BraveKnight (Quest quest){

        /**
         * Quest es un interfaz que implementa todas la hazanas de esta forma Braveknight
         * podria hacer todas la tareas, como RescueDameselQuest , SlayDragonQuest , MakeRoundTableRounderQuest
         * o cualquier implementacion Quest que se le asigne
         *
         * La clave en este ejemplo es que BraveKnight no es ta acoplado a ninguna implementacion ESPECIFICA
         * de Quest, da igual la tarea siempre que este implemente la interfaz Quest es
         * ESTA ES LA VENTAJA DE DI
         * al recivir sus dependencias a travez de interface , la dependencia puede cambiarse sin afectar al objeto
         * dependiente. una manera de comprobar esto es haciendo un Test
         *
          */
        this.quest = quest;
    }


    public void embarkOnQuest(){



        quest.embark();
    }


}
