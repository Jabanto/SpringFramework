
import static org.mockito.Mockito.*;
import org.junit.Test;

/**
 * Created by JAbanto on 09.05.2017.
 */


public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest(){

        /**
         * En este caso utilizamos un objeto de marco de trabajo de prueba denominado Mockito
         * para crear un implementacion de prueba de la interfaz Quest. Con el objeto de prueba
         * podemos crear una nueva instancia de @link BraveKnight inyectando el Quest de prueba en el
         * Constructor. Despues de invocar el metodo  @link embarktOnQuest() , solicitamos a
         * Mockito que verifique que el metodo @link embarkt() de Quest solo se invoca un vez.
         *
         */

        Quest mockQuest = mock(Quest.class); // Crear Quest de Prueba.
        BraveKnight knight = new BraveKnight(mockQuest); // inyectar Quest de Prueba
        knight.embarkOnQuest();
        // pedimos a mokito que el metodo embarkt() solo se invoca una vez
        verify(mockQuest, times(1)).embark();

    }

}
